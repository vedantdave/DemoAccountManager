package com.vedant.demoaccountmanager.orm;

/**
 * Created by Vedant on 17-01-2017.
 */

public class QueryBuilder {
    private OModel model;

    public QueryBuilder(OModel model) {
        this.model = model;
    }

    public String createQuery() {
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS ")
                .append(model.getTableName())
                .append(" ( ");
        StringBuffer stringBuffer = new StringBuffer();
        for (OColumn column : model.getAllColumns()) {
            stringBuffer.append(column.name)
                    .append(" ")
                    .append(column.columnType.toString());

            if (column.isPrimaryKey) {
                stringBuffer.append(" PRIMARY KEY ");
            }
            if (column.isAutoIncrement) {
                stringBuffer.append(" AUTOINCREMENT ");
            }
            if (column.defValue != null) {
                stringBuffer.append(" DEFAULT '").append(column.defValue.toString()).append("'");
            }
            stringBuffer.append(" , ");
        }

        String string = stringBuffer.toString();
        sql.append(string.substring(0, stringBuffer.length() - 2)).append(" )");
        return sql.toString();
    }
}
