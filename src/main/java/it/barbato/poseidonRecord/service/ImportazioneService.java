package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.repository.CategoriaRepository;
import it.barbato.poseidonRecord.repository.RecordRepository;
import it.barbato.poseidonRecord.repository.StiliRepository;
import it.barbato.poseidonRecord.repository.UtentiRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImportazioneService {

    @Autowired
    private UtentiRepository utentiRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private StiliRepository stiliRepository;

    @Transactional
    public void convertiUtenti(String jsonFile){
        JSONObject jsonObj = new JSONObject(jsonFile);
        List<String> keys =  jsonObj.keySet().stream().collect(Collectors.toList());
        keys.forEach(k -> {
            Map<String, Object> utenteMap = new JSONObject(jsonObj.get(k).toString()).toMap();
            Utenti u = utentiRepository.save(Converter.mapToUtente(utenteMap));


            try {
                List<Object> gare = (List<Object>) utenteMap.get("gare");

                gare.forEach(g -> {
                    //System.out.println(g);
                    JSONObject gJson = new JSONObject(g.toString().replace("''", "$")
                            .replace("'", "£").replace("=", ":"));

                    if (gJson.get("tempo") != null && !gJson.get("tempo").toString().isEmpty()) {

                        Record record = new Record();
                        if(gJson.get("lunghezza").toString().equalsIgnoreCase("V.C.")){
                            record.setFlagVascaCorta(1);
                        }
                        else if (gJson.get("lunghezza").toString().equalsIgnoreCase("V.L.")){
                            record.setFlagVascaCorta(0);
                        }
                        else{
                            record.setFlagVascaCorta(-1);
                        }
                        record.setTempo(getTempo(gJson.get("tempo").toString(), k));
                        //Utenti utente = utentiRepository.findByUsername(k);
                        record.setUtente(u);
                        record.setMetri(convertiDatoMetri(gJson.get("nomeGara").toString()));

                        Categorie categorie = categoriaRepository.findByCodicecategria(gJson.get("categoria").toString());
                        if(categorie == null) System.out.println("categoria null");
                        record.setCategoria(categorie);

                        Stili stile = stiliRepository.findByDescrizioneBreve(convertiDatoStile(gJson.get("nomeGara").toString()));
                        if(stile == null) System.out.println("stile null");
                        record.setStile(stile);

                        if(record.getTempo() != 0){
                            recordRepository.save(record);
                        }
                    }
                });

            }
            catch (Exception e){
                System.out.println("Errore gare " + k);
                // TODO verificare utente null
            }

        });
    }

    private Double getTempo(String tempo, String username) {
        if(tempo.isEmpty()){return new Double(0);}
        Double result = new Double(0);
        try {
            if (tempo.contains("£") && tempo.contains("$")) {
                String minuti = tempo.substring(0, tempo.indexOf('£'));
                String secondi = tempo.substring(tempo.indexOf('£') + 1, tempo.indexOf('$'));
                String cent = tempo.substring(tempo.indexOf('$') + 1);

                Integer minutiDouble = Integer.parseInt(minuti) * 6000;
                Integer secondiDouble = Integer.parseInt(secondi) * 100;
                Integer centDouble = Integer.parseInt(cent);

                result = new Double(minutiDouble + secondiDouble + centDouble);
            } else if (tempo.contains("$")) {
                String secondi = tempo.substring(0, tempo.indexOf('$'));
                String cent = tempo.substring(tempo.indexOf('$') + 1, tempo.length());

                Integer secondiDouble = Integer.parseInt(secondi) * 100;
                Integer centDouble = Integer.parseInt(cent);
                result = new Double(secondiDouble + centDouble);
            }
        }
        catch (Exception e){
            System.out.println("Errore tempo " + tempo.concat(" - da inserire per utente ".concat(username)));
            //e.printStackTrace();
        }

        return result;
    }

    private Integer convertiDatoMetri(String nomeGara) {
        String metri = nomeGara.substring(0, nomeGara.indexOf(" "));
        return Integer.parseInt(metri);
    }

    private String convertiDatoStile(String nomeGara) {
        String stile = nomeGara.substring(nomeGara.indexOf(" ")+1);
        return stile;
    }
}
