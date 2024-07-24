package com.example.demo;

import com.example.demo.interfaces.*;

public class FileStorageServiceImpl implements FileStorageService {
    @Override
    public void saveToFile(String name) {
       System.out.println("Almaceno el archivo");
    }
}
