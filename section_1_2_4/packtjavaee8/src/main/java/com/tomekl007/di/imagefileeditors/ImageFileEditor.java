package com.tomekl007.di.imagefileeditors;

public interface ImageFileEditor {
    
    String openFile(String fileName);
    
    String editFile(String fileName);
    
    String writeFile(String fileName);
    
    String saveFile(String fileName);
}