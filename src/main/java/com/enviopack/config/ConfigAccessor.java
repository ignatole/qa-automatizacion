package com.enviopack.config;

import com.fasterxml.jackson.databind.JsonNode;

public class ConfigAccessor {

    private final JsonNode config;

    public ConfigAccessor(JsonNode config) {
        this.config = config;
    }

    public String getKey(String clave) {
        String[] keys = clave.split("\\.");
        JsonNode currentNode = config;
        for (String key : keys) {
            currentNode = currentNode.path(key);
            if (currentNode.isMissingNode()) {
                throw new IllegalArgumentException("Clave no encontrada: " + clave);
            }
        }
        return currentNode.asText();
    }

    public int getInt(String clave) {
        return Integer.parseInt(getKey(clave));
    }

    public boolean getBoolean(String clave) {
        return Boolean.parseBoolean(getKey(clave));
    }
}