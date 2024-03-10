package io.github.oengajohn.sakilaappjpa.service.impl;

import io.github.oengajohn.sakilaappjpa.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static io.github.oengajohn.sakilaappjpa.constants.Constants.FILE_SEPARATOR;
import static io.github.oengajohn.sakilaappjpa.constants.Constants.UPLOAD_DIR;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String saveDataToDatabaseWithFilePath(String username, MultipartFile picture) throws IOException {
        String userHome = System.getProperty("user.home");
        String uploadPath = userHome + FILE_SEPARATOR + UPLOAD_DIR;
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdirs();

        }
        String fileName = username + "_" + picture.getOriginalFilename();
        Path filePath = Paths.get(uploadPath + FILE_SEPARATOR + fileName);
        Files.write(filePath, picture.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        // Extract name and extension from the file name

        return fileName;


    }

}
