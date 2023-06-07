package com.example.geektrust.constants;

public enum CommandType {
    ADD_DRIVER("ADD_DRIVER"),
    ADD_RIDER("ADD_RIDER"),
    MATCH("MATCH"),
    START_RIDE("START_RIDE"),
    STOP_RIDE("STOP_RIDE"),
    BILL("BILL");
    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CommandType fromString(String value) {
        for (CommandType type : CommandType.values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
