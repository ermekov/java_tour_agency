package com.postgresql.java_tour_agenstvo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Выберите файл для загрузки!");
            return "redirect:/";
        }

        try {
            Path path = Paths.get(uploadPath + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);

            redirectAttributes.addFlashAttribute("message","Файл успешно загружен: " + file.getOriginalFilename());

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Ошибка загрузки файла!");
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
