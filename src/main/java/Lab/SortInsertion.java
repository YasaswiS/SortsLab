package Lab;

import java.util.Arrays;

public class SortInsertion<T>
{

    public <A extends Comparable<A>> A[] InsertionSort(A[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int i1 = i;
            int i2 = i - 1;
            while (i2 >= 0 && arr[i1].compareTo(arr[i2]) < 0)
            {
                A Value1 = arr[i1];
                Arr[i1] = arr[i2];
                Arr[i2] = Value1;

                i1 -= 1;
                i2 -= 1;
            }
        }
        return arr;
    }

    public static class Car implements Comparable<Car> {
        private int Price;
        public Car(int pc)
        {
            Price = pc;
        }

        public int getPrice()
        {
            return Price;
        }

        @Override
        public String toString()
        {
            return "Car: " +
                    "Price is $" + Price +
                    '.';
        }


        @Override
        public int compareTo(Car Je)
        {
            if(Je.getPrice() < this.getPrice())
            {
                return 1;
            }
            else if(Je.getPrice() > this.getPrice())
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

    }
}
