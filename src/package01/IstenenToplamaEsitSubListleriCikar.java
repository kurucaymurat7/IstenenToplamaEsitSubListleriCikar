package package01;

import java.util.*;

public class IstenenToplamaEsitSubListleriCikar {
    public static void main(String[] args) {
        /*      Verilen bir list içerisinde (tekrarsız elemanlardan oluşan),
                istenen toplama eşit olan her bir
                sublisti yazdıran bir program yazınız.

                Örnek 1:
                List = {1,2,3,4,5,6};
                istenen toplam: 8
                1- {2,6}
                2- {3,5}
                3- {1,3,4}

                Örnek 2:
                List = {5,10,15,20};
                istenen toplam: 30
                1- {5,10,15}
                2- {10,20}*/

        List<Integer> list = new ArrayList<>(Arrays.asList(3,9,4,12,5,6,7,1,8));
        int istenenToplam = 13;
        List<List<Integer>> bigList = new ArrayList<>();
        bigList = listiParcala(list);

        for (List<Integer> integers : bigList) {
            if (listToplam(integers) == istenenToplam) {
                System.out.println(integers);
            }
        }
    }

    private static List<List<Integer>> listiParcala(List<Integer> list) {
        Collections.sort(list);
        int listSize = list.size();
        List<List<Integer>> bigList = new ArrayList<>();

        for (int i = 2; i <= listSize; i++) {
            int sizeiliKombinasyon = faktoriyelHesapla(listSize) / (faktoriyelHesapla(i) * (faktoriyelHesapla(listSize - i)));
            for (int j = 1; j <= sizeiliKombinasyon; j++) {
                List<Integer> subList = new ArrayList<>();
                Random random = new Random();
                do {
                    int randomIndex = random.nextInt(listSize);
                    if (!subList.contains(list.get(randomIndex))) {
                        subList.add(list.get(randomIndex));
                    }

                    if (subList.size() == i) {
                        Collections.sort(subList);

                        if (!bigList.contains(subList)) {
                            bigList.add(subList);
                        } else
                            j--;
                    }
                } while (subList.size() < i);
            }
        }
        return bigList;
    }

    private static int listToplam(List<Integer> list) {
        int toplam = 0;
        for (Integer integer : list) {
            toplam += integer;
        }
        return  toplam;
    }


    private static int faktoriyelHesapla(int sayi) {
        int faktoriyel = 1;
        if (sayi != 0) {
            for (int i = 1; i <= sayi; i++) {
                faktoriyel = faktoriyel * i;
            }
        }
        return faktoriyel;
    }
}
