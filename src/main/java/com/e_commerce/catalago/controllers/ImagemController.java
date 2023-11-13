package com.e_commerce.catalago.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.catalago.configs.ImageUploadResponse;
import com.e_commerce.catalago.models.Imagem;
import com.e_commerce.catalago.repositories.ImagemRepository;
import com.e_commerce.catalago.util.ImageUtility;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ImagemController {

    @Autowired
    ImagemRepository imageRepository;

 //   @PostMapping("/upload/image") 
    @PostMapping(path = {"/upload/image"})
    public ResponseEntity<ImageUploadResponse> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        imageRepository.save(Imagem.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    

    @GetMapping(path = {"/get/image/info/{name}"})
    public Imagem getImageDetails(@PathVariable("name") String name) throws IOException {

        final Optional<Imagem> dbImage = imageRepository.findByName(name);

        return Imagem.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Imagem> dbImage = imageRepository.findByName(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}

