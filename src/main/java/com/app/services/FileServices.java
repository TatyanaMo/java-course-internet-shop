package com.app.services;

import com.app.dao.ClientDAO;
import com.app.dao.FileDAO;
import com.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileServices {
    @Autowired
    private FileDAO fileDAO;

    @Autowired
    private ClientDAO clientDAO;

    private final Path LOCATION = Paths.get("src/main/resources/static/files");

    public void storeNewFile(MultipartFile file) throws IOException {
        copyFileToDirectory(file);
        fileDAO.storeNewFile(file.getOriginalFilename());
    }

    public void storeClientAvatar(MultipartFile file) throws IOException {
        copyFileToDirectory(file);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customClient = (CustomUserDetails) authentication.getPrincipal();

        clientDAO.storeClientAvatar(file.getOriginalFilename(), customClient.getClient().getId());
    }

    public List<String> getAllFiles() {
        return fileDAO.getAllFiles();
    }

    private void copyFileToDirectory(MultipartFile file) throws IOException {
        Path destinationFile = LOCATION.resolve(Paths.get(file.getOriginalFilename()))
                .normalize().toAbsolutePath();

        Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
