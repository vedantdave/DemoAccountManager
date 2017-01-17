package com.vedant.demoaccountmanager.orm;


public enum ColumnType {
    VARCHAR("VARCHAR"),
    INTEGER("INTEGER"),
    FLOAT("FLOAT"),
    BOOLEAN("BOOLEAN"),
    BLOB("BLOB");

    String type;

    ColumnType(String type) {
        this.type = type;
    }

}
