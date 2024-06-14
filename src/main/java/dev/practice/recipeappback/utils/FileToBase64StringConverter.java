package dev.practice.recipeappback.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

public class FileToBase64StringConverter {
    public static void main(String[] args) throws IOException {
        System.out.println(imageToBase64("beverages-hot-small4-200x200.jpg"));
    }

    public static String imageToBase64(String filename) throws IOException {
        String inputFilePath = "static/images/" + filename;
        ClassLoader classLoader = FileToBase64StringConverter.class.getClassLoader();
        File inputFile = new File(Objects.requireNonNull(classLoader
                        .getResource(inputFilePath))
                .getFile());
        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
    }
}
