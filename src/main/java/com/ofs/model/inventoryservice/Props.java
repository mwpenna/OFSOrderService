package com.ofs.model.inventoryservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Map;

@Data
public class Props {

    public enum Type {
        NUMBER,
        STRING,
        BOOLEAN
    }

    private String name;
    private Type type;
    private boolean required;
    private String value;
    private String defaultValue;
}
