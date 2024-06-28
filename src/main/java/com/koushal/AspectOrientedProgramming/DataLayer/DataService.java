package com.koushal.AspectOrientedProgramming.DataLayer;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    public int[] retrieveData(){
        return new int[]{23,7,54,88,1,56};
    }
}
