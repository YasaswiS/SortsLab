package com.sorts.lab;

import java.util.ArrayList;

import Lab.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@RequestMapping("")
@Controller
public class MainController {
    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/sort")
    public String multiSort(@RequestParam(value = "sortType", required = false) String sortType,
                            @RequestParam(value = "dataType", required = false) String dataType, Model model){

        System.out.println(String.format("sortType %s, dataType %s", sortType, dataType));

        if (sortType != null && dataType != null)
        {
            Sort So;
            if (dataType.equals("String"))
            {
                So = new Sort<Integer>();
            }
            else if (dataType.equals("Jewelry"))
            {
                So = new Sort<String>();
            }
            else
            {
                So = new Sort<Sort.Jewelry>();
                dataType = "Integer";
            }

            Comparable[] Objs = new Comparable[10];
            for (int I = 0; I < Objs.length; I++)
            {
                if (dataType.equals("String"))
                {
                    Objs[I] = new String(getRandomWord());
                }
                else if(dataType.equals("Jewelry"))
                {
                    Objs[I] = new Sort.Jewelry((int)(Math.random()*100000));
                }
                else if (dataType.equals("Integer"))
                {
                    Objs[I] = new Integer((int)(Math.random()*100));
                }
            }

            Object[] sortedObjects = new Object[Objs.length];
            if (sortType.equals("Bubble"))
            {
                sortedObjects = So.BubbleSort(Objs);
            }
            else if(sortType.equals("Selection"))
            {
                sortedObjects = So.SelectionSort(Objs);
            }
            else
            {
                sortedObjects = So.InsertionSort(Objs);
            }

            String[] Data = new String[sortedObjects.length];
            for (int I = 0; I < Objs.length; I++)
            {
                Data[I] = sortedObjects[I].toString();
            }

            model.addAttribute("sortedData", Data);
        }

        model.addAttribute("sortType", sortType);
        model.addAttribute("dataType", dataType);
        return "/sort";
    }

    private static String[] Words = new String[]
            {"Magician", "Tennis", "Tesla", "Light", "Couch", "Physics", "Quandary", "Cart", "Phone", "Again", "Bowling", "Airport", "Movie", "Pencil", "Chocolate", "Milk", "Falcon", "Nighthawk", "Valley", "Zebra", "Console", "Java", "Skittles", "Python", "Amazon", "Google", "Speaker", "Table", "Mouse", "Scissors", "Highlighter", "Europe", "Monitor", "Restaurant", "Calculator", "Statistics", "Psychology", "Calculus", "Pill", "Globe", "Picture", "Wire", "Port", "Cruise", "Water", "Fire", "Ground", "Hormones", "Watch", "Computer Science", "Histogram", "Knob", "Roll", "Skateboard", "Garage", "Pie", "Blueberry", "Test", "Cadillac", "COVID", "Glue", "Shock", "Brain", "Muscle", "Pig", "Chicken", "Tone", "Earbuds", "Pancakes", "Imposter", "Salt", "Knife", "Weapon", "Widget", "Update", "Old", "Champagne", "Stride", "Proud", "Dance", "YouTube", "Jail", "Fort", "Toilet", "Flock", "Tuck", "Loss", "Soccer", "Eraser", "Schizophrenia", "Bicycle", "Australia", "Camera", "Button", "Bar", "Stool", "Fun", "Pretzel", "Biscuit", "Toe"};
    private static String getRandomWord(){
        return Words[(int)(Math.random()* Words.length)];
    }
}
