package com.prueba.plc.Dao;

import com.prueba.plc.Model.PLC;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PLCDaoZonaA1 {

    // Datos de conexión a la DB
    private String url = "jdbc:sqlserver://192.168.1.12:1433;DatabaseName=mqtt;TrustServerCertificate=True;";
    private String username = "reportes";
    private String password ="Invertec2023";

    // Conexión a la DB
    private Connection getConnectionPLC(){
        try {
            return DriverManager.getConnection(url,username,password);

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // Consulta a la DB
    public List<PLC> getPLC(){
        String query = "SELECT        id,value, terminaldate, [group], source, ServerTimestamp, CONVERT(float, value) AS valor\n" +
                "FROM            dbo.mqttlogs\n" +
                "WHERE source = 'DAS_SECADO_FROZEN_TEMP_PROM_ZONA_A1' AND CONVERT(date, ServerTimestamp) = CONVERT(date, GETDATE()) ORDER BY ServerTimestamp ASC;";
        List<PLC> plcs = new ArrayList<>();


        try (Connection connection = getConnectionPLC();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PLC plc = new PLC();
                plc.setId(resultSet.getLong("id"));
                plc.setTerminaldate(resultSet.getString("terminaldate"));
                plc.setGroup(resultSet.getString("group"));
                plc.setSource(resultSet.getString("source"));
                plc.setValue(resultSet.getString("value"));
                plc.setServerTimestamp(resultSet.getString("ServerTimeStamp"));
                plcs.add(plc);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return plcs;
    }

    public List<PLC> getSetPointQM(){
        String query = "SELECT TOP (1) id, terminaldate, [group], source, value, ServerTimestamp FROM dbo.mqttlogs WHERE (source = 'DAS_SECADO_FROZEN_SET_POINT_QUEM1') ORDER BY id DESC";
        List<PLC> plcs = new ArrayList<>();


        try (Connection connection = getConnectionPLC();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                PLC plc = new PLC();
                plc.setId(resultSet.getLong("id"));
                plc.setTerminaldate(resultSet.getString("terminaldate"));
                plc.setGroup(resultSet.getString("group"));
                plc.setSource(resultSet.getString("source"));
                plc.setValue(resultSet.getString("value"));
                plc.setServerTimestamp(resultSet.getString("ServerTimeStamp"));
                plcs.add(plc);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plcs;
    }

}
