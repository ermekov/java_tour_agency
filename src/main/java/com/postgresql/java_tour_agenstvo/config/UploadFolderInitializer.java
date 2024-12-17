package com.postgresql.java_tour_agenstvo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import java.io.File;

public class UploadFolderInitializer implements CommandLineRunner {

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void run(String... args) throws Exception {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            if (created) {
                System.out.println("Папка для загрузки файлов создана: " + uploadPath);
            } else {
                System.err.println("Не удалось создать папку для загрузки файлов: " + uploadPath);
            }
        }
    }
}
