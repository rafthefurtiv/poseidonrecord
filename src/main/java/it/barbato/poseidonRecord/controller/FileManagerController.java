package it.barbato.poseidonRecord.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/file")
public interface FileManagerController {



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<?> fileList();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> download(
            @PathVariable String fileName
    ) throws IOException;

}
