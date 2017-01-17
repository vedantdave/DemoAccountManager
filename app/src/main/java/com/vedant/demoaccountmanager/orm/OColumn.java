package com.vedant.demoaccountmanager.orm;

/**
 * Created by Vedant on 17-01-2017.
 */

public class OColumn {
    public String name, label, relModel;
    public boolean isPrimaryKey = false, isAutoIncrement = false, isLocal = false;
    public ColumnType columnType;
    public Object defValue;

    public OColumn(String label, ColumnType columnType)
    {
        this(label,columnType,null);
    }

    public OColumn(String label, ColumnType columnType, String relModel) {
        this.label=label;
        this.columnType= columnType;
        this.relModel= relModel;

    }
    public OColumn makePrimaryKey() {
        isPrimaryKey = true;
        return this;
    }

    public OColumn makeAutoIncrement() {
        isAutoIncrement = true;
        return this;
    }

    public OColumn makeLocal() {
        isLocal = true;
        return this;
    }

    public OColumn setDefaultValue(Object defValue) {
        this.defValue = defValue;
        return this;
    }
}
