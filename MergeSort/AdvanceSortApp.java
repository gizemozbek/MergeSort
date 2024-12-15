package MergeSort;

public class AdvanceSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        MergeSort dizi = new MergeSort(maxSize); //100 elemanli dizi olusturduk

        //0 ile 1 arasinda rastgele sayi uretilerek uretilen sayi 99 ile carpilmali
        //ve tam sayiya donusturulerek diziye 0 ile 98 arasinda 10 adet rastgele
        //sayi eklenmelidir
        for(int i = 0; i<10; i++){
            dizi.insert((int) (java.lang.Math.random() *99));
        }
        dizi.display();//dizinin sirasiz durumu
        dizi.mergeSort(); //siralama islemi
        dizi.display();//dizinin siralanmis hali
    }
}
