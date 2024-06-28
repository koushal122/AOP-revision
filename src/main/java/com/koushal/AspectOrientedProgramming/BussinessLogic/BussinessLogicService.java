package com.koushal.AspectOrientedProgramming.BussinessLogic;

import com.koushal.AspectOrientedProgramming.DataLayer.DataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BussinessLogicService {
    private DataService dataService;
    BussinessLogicService(DataService dataService){
        this.dataService=dataService;
    }
    public int getMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
