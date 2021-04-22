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

    @GetMapping("/insertion")
    public String Insertion(@RequestParam(value = "length", required = false, defaultValue = "8") int length, Model model) {
        long startTime = System.nanoTime();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
        {
            array.add((int) (Math.random() * 100 + 1));
        }
        model.addAttribute("unsorted", "This is the Array that's not sorted, but is randomly generated: " + array.toString() + ".");
        Integer[] arr = new Integer[length];
        for (int j = 0; j < length; j++)
        {
            arr[j] = array.get(j);
        }
        Sort insertion = new Sort();
        model.addAttribute("sorted", "This is the Array, which is now sorted: " + insertion.returnSort(arr) + ".");
        long finalTime = System.nanoTime() - startTime;
        model.addAttribute("time", "The time it took to execute the command was " + finalTime + " nanoseconds.");
        return "insertion";
    }
}
