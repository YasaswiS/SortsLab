package Lab;

import java.util.Arrays;
public class Sort
{
    public Integer[] sort(Integer[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public String returnSort(Integer[] arr)
    {
        Integer[] arrr = sort(arr);
        String answer = "";
        answer+="[";
        for (int i = 0; i < arrr.length - 1; i++)
        {
            answer+=arrr[i];
            answer+=", ";
        }
        answer+=arrr[arrr.length-1];
        answer+="]";
        return answer;
    }
}
