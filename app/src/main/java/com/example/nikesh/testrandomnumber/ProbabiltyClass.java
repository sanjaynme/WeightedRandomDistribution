package com.example.nikesh.testrandomnumber;

import java.util.List;

/**
 * Created by Sanjay on 9/6/2017.
 */

public class ProbabiltyClass {
    int probabilyPercentage;
    List<Integer> arrayItems;

    public List<Integer> getWeightedValues() {
        return weightedValues;
    }

    public void setWeightedValues(List<Integer> weightedValues) {
        this.weightedValues = weightedValues;
    }

    List<Integer> weightedValues;

    public int getProbabilyPercentage() {
        return probabilyPercentage;
    }

    public void setProbabilyPercentage(int probabilyPercentage) {
        this.probabilyPercentage = probabilyPercentage;
    }

    public List<Integer> getArrayItems() {
        return arrayItems;
    }

    public void setArrayItems(List<Integer> arrayItems) {
        this.arrayItems = arrayItems;
    }
}
