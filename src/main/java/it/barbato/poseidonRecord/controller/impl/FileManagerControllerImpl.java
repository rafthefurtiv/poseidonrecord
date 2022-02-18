package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.FileManagerController;
import it.barbato.poseidonRecord.entity.dto.FileDto;
import it.barbato.poseidonRecord.service.ImportazioneService;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileManagerControllerImpl implements FileManagerController {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private ImportazioneService importazioneService;


    @Override
    public ResponseEntity<?> fileList() {
        System.out.println("fileList");

        List<FileDto> results = new ArrayList<>();

        File[] files = new File("/root/startList").listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(new FileDto(file.getName(), file.lastModified()));
            }
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> download(String fileName) throws IOException {
        System.out.println("download");

        HttpHeaders head = new HttpHeaders();
        head.setContentType(MediaType.APPLICATION_PDF);
        head.add("x-filename", fileName);
        head.add("Content-Disposition", "attachment; filename=" + fileName);

        File file = new File("C:/root/startList/".concat(fileName));
        byte[] fileByte = null;
        if(file != null && file.exists() && file.isFile()){
            InputStream inputStream = new FileInputStream(file);
            fileByte = Files.readAllBytes(file.toPath());
        }
        else {
            throw new IOException("File inesistente");
        }


        return new ResponseEntity<byte[]>(fileByte, head, HttpStatus.OK);
    }
}
