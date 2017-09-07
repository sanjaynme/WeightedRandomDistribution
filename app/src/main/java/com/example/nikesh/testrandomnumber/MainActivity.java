package com.example.nikesh.testrandomnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProbabiltyClass probabilyty1 = new ProbabiltyClass();
    ProbabiltyClass probabilyty2 = new ProbabiltyClass();
    ProbabiltyClass probabilyty3 = new ProbabiltyClass();
    ArrayList<ProbabiltyClass> listProbabilyty1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> integers1 = new ArrayList<>();
        List<Integer> integers2 = new ArrayList<>();
        List<Integer> integers3 = new ArrayList<>();

        List<Integer> weightedArray1 = new ArrayList<>();
        List<Integer> weightedArray2 = new ArrayList<>();
        List<Integer> weightedArray3 = new ArrayList<>();

        probabilyty1.setProbabilyPercentage(30);
        integers1.add(1);
        weightedArray1.add(3);
        integers1.add(3);
        weightedArray1.add(5);
        integers1.add(5);
        weightedArray1.add(8);
        probabilyty1.setArrayItems(integers1);
        probabilyty1.setWeightedValues(weightedArray1);

        listProbabilyty1.add(probabilyty1);

        probabilyty2.setProbabilyPercentage(50);
        integers2.add(2);
        weightedArray2.add(3);

        integers2.add(4);
        weightedArray2.add(2);

        probabilyty2.setArrayItems(integers2);
        probabilyty2.setWeightedValues(weightedArray2);
        listProbabilyty1.add(probabilyty2);
        probabilyty3.setProbabilyPercentage(20);
        integers3.add(6);
        weightedArray3.add(3);

        integers3.add(7);
        weightedArray3.add(4);

        integers3.add(8);
        weightedArray3.add(1);


        integers3.add(9);
        weightedArray3.add(2);

        integers3.add(10);
        weightedArray3.add(8);

        probabilyty3.setArrayItems(integers3);
        probabilyty3.setWeightedValues(weightedArray3);
        listProbabilyty1.add(probabilyty3);

        for (int i = 0; i < 10; i++) {
            methodRandomGeneralisation();
        }
    }

    private void methodRandomGeneralisation() {
        ArrayList<Integer> itemsList = new ArrayList<>();
        // For now assume probabilty as weightage
        // and arrange items with their probability percentage

        for (ProbabiltyClass items : listProbabilyty1) {
            //expand the set of array items accroding to a probabilty
            //eg--40 40 40 50 50 ......till 100th item
            for (int i = 0; i < items.getProbabilyPercentage(); i++) {
                itemsList.add(items.getProbabilyPercentage());
            }
        }
        System.out.println("itemslistS----------" + itemsList);

        //generate a random number from the size of itemsLists
        double doubleRandomNumber = (Math.random()) * itemsList.size();
        int randomNumber = (int) doubleRandomNumber;

        System.out.println("randomNumbr----------" + randomNumber);

        //randomly pick an item from itemslists
        //Here,itemList.get(randomNumber) gives result
        System.out.println(" probablity item==" + itemsList.get(randomNumber));

        ProbabiltyClass pickedUpresult = new ProbabiltyClass();
        for (ProbabiltyClass itemsNamee : listProbabilyty1) {
            //Now from picked up probabilty % filter the array of items and its weights
            //and put it in another object of its class for further filter
            if (itemsNamee.getProbabilyPercentage() == itemsList.get(randomNumber)) {
                pickedUpresult = itemsNamee;
                //filtering array items according to probability
                for (int i = 0; i < pickedUpresult.getArrayItems().size(); i++) {
                    Log.d("", "Sanjay IS testing-----:" + pickedUpresult.getArrayItems().get(i));
                }
            }
        }

        //Now array items ko weight herera o/p garne with same process
        ArrayList<Integer> pickeditemsList = new ArrayList<>();
        //find size of array items filtered from probablity %
        //And add those filtered array items in a new array
        for (int j = 0; j < pickedUpresult.getArrayItems().size(); j++) {
            for (int i = 0; i < pickedUpresult.getWeightedValues().get(j); i++) {
                //now from filtered array expand the set for each entry
                pickeditemsList.add(pickedUpresult.getArrayItems().get(j));
            }
        }

        System.out.println("pickeditemsList----------" + pickeditemsList);
        System.out.println("pickeditemsList Size----------" + pickeditemsList.size());
        double finalRandomNumber = (Math.random()) * pickeditemsList.size();
        int finalrandomNumbers = (int) finalRandomNumber;
        System.out.println("pickeditemsList Random number----------" + finalrandomNumbers);

        System.out.println("itemAnswerValues==" + pickeditemsList.get(finalrandomNumbers));
    }
}