package com.enviopack.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigLoader {

    private static final String DEFAULT_CONFIG_PATH = "src/main/resources/config/properties.json";
    private final JsonNode config;
    private static ConfigLoader configLoader;
    
    private ConfigLoader() {
        this(DEFAULT_CONFIG_PATH);
    }

    private ConfigLoader(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.config = objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo de configuración: " + e.getMessage(), e);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public JsonNode getConfig() {
        return this.config;
    }
    public String getBaseUrl() { 
    	return new ConfigAccessor(config).getKey("url"); 
    	} 
    public String getBrowser() { 
    	return new ConfigAccessor(config).getKey("browser");
    }
    public String getAdminEmail() {
    	return new ConfigAccessor(config).getKey("email_admin");
    }

    public String getAdminPassword() {
    	return new ConfigAccessor(config).getKey("password_admin");
    }
    public String getSellerEmail() {
    	return new ConfigAccessor(config).getKey("email_seller");
    }

    public String getSellerPassword() {
    	return new ConfigAccessor(config).getKey("password_seller");
    }
}
