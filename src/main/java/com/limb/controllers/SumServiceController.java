package com.limb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SumServiceController {
    @GetMapping("/sum")
    public String sum(@RequestParam(defaultValue = "0") String x,
                      @RequestParam(defaultValue = "0") String y,
                      Map<String, Object> model){
        model.put("X", x);
        model.put("Y", y);
        Integer sumXY = Integer.valueOf(x) + Integer.valueOf(y);
        model.put("sum", sumXY.toString());
        return "sum";
    }

    @PostMapping("/sum")
    public String getSum(String X, String Y, Map<String, Object> model){
        model.put("X", X);
        model.put("Y", Y);
        Integer sumXY = Integer.valueOf(X) + Integer.valueOf(Y);
        model.put("sum", sumXY.toString());
        return "sum";
    }
}
