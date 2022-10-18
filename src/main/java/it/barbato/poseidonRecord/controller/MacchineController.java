package it.barbato.poseidonRecord.controller;
import it.barbato.poseidonRecord.entity.Macchine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/macchine")
public interface MacchineController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/utenti")
    public ResponseEntity<?> findMacchineUtenti();

    // Not used
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public ResponseEntity<?> findMacchine();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/macchina")
    public ResponseEntity<?> addMacchina(@RequestBody Macchine macchina) throws Exception;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/macchina/utente/{idUtente}")
    public ResponseEntity<?> deleteMacchina(@RequestParam Integer utente) throws Exception;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/passeggero/{user}/macchina/{idMacchina}")
    public ResponseEntity<?> updatePasseggero(@PathVariable Integer user,
                                           @PathVariable Integer idMacchina,
                                           @RequestParam Boolean andata,
                                           @RequestParam Boolean ritorno) throws Exception;

    // Not used
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/passeggero/{user}/macchina/{idMacchina}")
    public ResponseEntity<?> deletePasseggero(@PathVariable Integer user,
                                              @PathVariable Integer idMacchina,
                                              @RequestParam Boolean andata,
                                              @RequestParam Boolean ritorno);

}
