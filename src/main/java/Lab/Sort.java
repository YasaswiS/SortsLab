package Lab;

import java.util.Arrays;

public class Sort<T>
{

    public <A extends Comparable<A>> A[] InsertionSort(A[] Arr)
    {
        for (int I = 1; I < Arr.length; I++)
        {
            int I1 = I;
            int I2 = I - 1;
            while (I2 >= 0 && Arr[I1].compareTo(Arr[I2]) < 0)
            {
                A Value1 = Arr[I1];
                Arr[I1] = Arr[I2];
                Arr[I2] = Value1;

                I1 -= 1;
                I2 -= 1;
            }
        }
        return Arr;
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
