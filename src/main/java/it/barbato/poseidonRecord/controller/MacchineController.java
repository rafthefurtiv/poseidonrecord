package it.barbato.poseidonRecord.controller;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.dto.AddMacchinaDto;
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
    public ResponseEntity<?> addMacchina(@RequestBody AddMacchinaDto macchina) throws Exception;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/macchina")
    public ResponseEntity<?> updateMacchina(@RequestBody AddMacchinaDto macchina) throws Exception;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/macchina/utente/{idUtente}")
    public ResponseEntity<?> deleteMacchina(@PathVariable(value = "idUtente") Integer utente) throws Exception;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/passeggero/{username}/macchina/{idMacchina}")
    public ResponseEntity<?> updatePasseggero(@PathVariable String username,
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
