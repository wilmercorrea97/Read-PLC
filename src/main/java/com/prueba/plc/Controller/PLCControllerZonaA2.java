package com.prueba.plc.Controller;

import com.prueba.plc.Dao.PLCDaoZonaA2;
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
public class PLCControllerZonaA2 {

    @Autowired
    private PLCDaoZonaA2 plcDaoZonaA2;


    @GetMapping("/ZonaA2")
    public List<PLC> getPLC(){
        return plcDaoZonaA2.getPLC();
    }

    @GetMapping("/ZonaA2/QM2")
    public List<PLC> getSetPointQM(){
        return plcDaoZonaA2.getSetPointQM();
    }

}
