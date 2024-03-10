package io.github.oengajohn.sakilaappjpa.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String saveDataToDatabaseWithFilePath(String username, MultipartFile picture) throws IOException;
}
