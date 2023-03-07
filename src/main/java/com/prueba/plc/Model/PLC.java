package com.prueba.plc.Model;

public class PLC {

    private Long id;
    private String terminaldate;
    private String group;
    private String source;
    private String value;
    private String ServerTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerminaldate() {
        return terminaldate;
    }

    public void setTerminaldate(String terminaldate) {
        this.terminaldate = terminaldate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getServerTimestamp() {
        return ServerTimestamp;
    }

    public void setServerTimestamp(String serverTimestamp) {
        ServerTimestamp = serverTimestamp;
    }
}
