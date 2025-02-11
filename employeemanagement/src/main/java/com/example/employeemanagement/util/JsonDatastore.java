package com.example.employeemanagement.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonDatastore {
    private static final String FILE_PATH = "src/main/resources/data.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> readData() throws IOException {
        return objectMapper.readValue(new File(FILE_PATH), new TypeReference<Map<String, Object>>() {});
    }

    public static void writeData(Map<String, Object> data) throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), data);
    }
}
