package com.prueba.plc.Controller;

import com.prueba.plc.Dao.PLCDaoZonaA1;
import com.prueba.plc.Model.PLC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class PLCControllerZonaA1 {
    @Autowired
    private PLCDaoZonaA1 plcDaoZonaA1;

    @GetMapping("/ZonaA1")
    public List<PLC> getPLC() {
        return plcDaoZonaA1.getPLC();
    }


    @GetMapping("/ZonaA1/QM1")
    public List<PLC> getSetPointQM() {
        return plcDaoZonaA1.getSetPointQM();
    }


}