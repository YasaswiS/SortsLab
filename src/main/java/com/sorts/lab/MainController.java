package com.sorts.lab;

import Lab.SortInsertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@RequestMapping("")
@Controller
public class MainController
{
    int integer = (int)Math.random()*10000;
    @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/sort")
    public String multiSort(@RequestParam(value = "sortType", required = false) String sortType,
                            @RequestParam(value = "dataType", required = false) String dataType, Model model){

        if (sortType != null && dataType != null)
        {
            SortInsertion So;
            if (dataType.equals("String"))
            {
                So = new SortInsertion<Integer>();
            }
            else if (dataType.equals("Car"))
            {
                So = new SortInsertion<String>();
            }
            else
            {
                So = new SortInsertion<SortInsertion.Car>();
                dataType = "Integer";
            }

            Comparable[] Objs = new Comparable[10];
            for (int I = 0; I < Objs.length; I++)
            {
                if (dataType.equals("String"))
                {
                    Objs[I] = new String(getRandomWord());
                }
                else if(dataType.equals("Car"))
                {
                    Objs[I] = new SortInsertion.Car(integer);
                }
                else if (dataType.equals("Integer"))
                {
                    Objs[I] = new Integer(integer);
                }
            }

            Object[] sortedObjects = new Object[Objs.length];

            if(sortType.equals("Insertion"))
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
        return "sort";
    }

    private static String[] Words = new String[]
            {"stay", "profound", "menu", "insist", "general", "isolation", "buffet", "temptation", "highway", "vegetation", "pavement", "budget", "swim, bottle", "stop", "entertainment", "parameter", "popular", "stab", "discipline"};
    private static String getRandomWord(){
        return Words[(int)(Math.random()* Words.length)];
    }
}
