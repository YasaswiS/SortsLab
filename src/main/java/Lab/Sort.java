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
                // This swaps the elements contained in the Array.
                A Value1 = Arr[I1];
                Arr[I1] = Arr[I2];
                Arr[I2] = Value1;

                // This decrements the various values of I.
                I1 -= 1;
                I2 -= 1;
            }
        }
        return Arr;
    }

    public <A extends Comparable<A>> A[] BubbleSort(A[] Arr)
    {
        boolean Sorted = false;
        while (!Sorted)
        {
            Sorted = true;
            for(int I = 0; I < Arr.length - 1; I++)
            {
                if (Arr[I].compareTo(Arr[I + 1]) > 0)
                {
                    Sorted = false;
                    A Temp  = Arr[I + 1];
                    Arr[I + 1] = Arr[I];
                    Arr[I] = Temp;
                }
            }
        }
        return Arr;
    }

    public <A extends Comparable<A>> A[] SelectionSort(A[] Arr)
    {
        for (int I = 0; I < Arr.length; I++)
        {
            int Smallest = I;
            for (int J = I; J < Arr.length; J++)
            {
                if (Arr[J].compareTo(Arr[Smallest]) < 0)
                {
                    Smallest = J;
                }
            }

            // This swaps the elements contained in the Array.
            A SmallestItem = Arr[Smallest];
            Arr[Smallest] = Arr[I];
            Arr[I] = SmallestItem;
        }
        return Arr;
    }

    public static void main(String [] args)
    {
        String[] Str = new String[]{"Lamborghini", "Police", "Spanish", "Ball", "Sport"};
        Sort<String> So = new Sort<>();
        System.out.println(Arrays.toString(So.InsertionSort(Str)));
        // -------------------------------------------------------------------------------
        Jewelry[] Jewel = new Jewelry[10];
        for (int I = 0; I < Jewel.length; I++)
        {
            Jewel[I] = new Jewelry((int)(Math.random()*1000));
        }
        Sort<Jewelry> J = new Sort<>();
        System.out.println(Arrays.toString(J.InsertionSort(Jewel)));
        // --------------------------------------------------------------------------------
        Integer[] Ints = new Integer[10];
        for (int I = 0; I < Ints.length; I++)
        {
            Ints[I] = (int)(Math.random()*1000);
        }
        Sort<Integer> Inte = new Sort<>();
        System.out.println(Arrays.toString(Inte.InsertionSort(Ints)));
    }

    public static class Jewelry implements Comparable<Jewelry> {
        private int Price;
        public Jewelry(int Price)
        {
            this.Price = Price;
        }

        public int getPrice()
        {
            return Price;
        }

        @Override
        public String toString()
        {
            return "Jewelry: " +
                    "Price = $" + Price +
                    '.';
        }

        @Override
        public int compareTo(Jewelry Je)
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
