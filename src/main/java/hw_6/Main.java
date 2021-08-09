package hw_6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String[] masOfProducts = new String[5];
        Integer[] masOfCosts = new Integer[5];
        Integer[] masOfCounts = new Integer[5];

        System.out.println("Enter line with product, it's price and number of products." +
                "Enter \"q\" if you want to finish list");
        while (sc.hasNext() && count < 5) {
            String s = sc.nextLine();
            if ("q".equals(s)) {
                break;
            }
            count++;

            String[] parts = s.split(" ");

            if (parts.length != 3) {
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            Integer productCost;
            Integer productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < 5; i++) {
                if (productName.equals(masOfProducts[i])) {
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            if (!productAlreadyExists) {
                for (int i = 0; i < 5; i++) {
                    if (masOfProducts[i] == null) {
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                    }
                }
            }

        }

        String[] sortedProducts = new String[5];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, 5);
        Arrays.sort(sortedProducts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        System.out.println(Arrays.toString(sortedProducts));

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += masOfCosts[i] * masOfCosts[i];
        }
        System.out.println(sum);

    for (int j = 0; j < 3; j++) {
        int indexOfMostPupularProduct = 0;
        for (int i =0; i < 5; i++) {
            if (masOfCosts[i] > masOfCosts[indexOfMostPupularProduct]) {
                indexOfMostPupularProduct = i;
            }
        }

        System.out.println("Most popular product is " +
                masOfProducts[indexOfMostPupularProduct]);
        masOfProducts[indexOfMostPupularProduct] = null;
        masOfCounts[indexOfMostPupularProduct] = 0;
        masOfCosts[indexOfMostPupularProduct] = 0;
        }
    }
}
