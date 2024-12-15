package MergeSort;

public class MergeSort {
    private long[] dizi;
    private int elemanSayisi;

    //dizi belirli bir kapasiteyle olusturulur
    public MergeSort(int max) {//diziyi kullanici ne kadar girerse o kadar olustur
        dizi = new long[max];
        elemanSayisi = 0;
    }

    public void insert(long d){//yeni ekleme yapilan metotlarda parametre kullanilir
        //eleman diziye eklenir
        dizi [elemanSayisi] = d;
        elemanSayisi++;
    }

    public void display(){
        for(int i=0; i < elemanSayisi; i++)
        System.out.print(dizi[i] + " ");
        System.out.println(" ");
    }

    //MERGE SORT
    //mergeSort() metodu dizinin siralama islemini baslatip kontrol eder
    public void mergeSort(){
        //workSpace adinda gecici dizi olusturuyoruz
        //bu dizi siralama esnasinda birlestirme islemi icin kullanilir
        long [] workSpace = new long [elemanSayisi];
        //alt parcalama
        recMergeSort(workSpace, 0, elemanSayisi-1);
    }

    //diziyi parcalara bolup her parcayi siralayacak
    //diziyi tek elemanli alt parcalara boler
    //her parcayi siralar
    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        //lowerBound baslangic indisi
        //upperBound bitis indisi

        //tek eleman varsa
        if(lowerBound == upperBound){ //esit ise dizide bir eleman vardir

            //1 eleman varsa siralama yapma veya bolme yapmadan geri don
            return;
        }
        else{ //dizide birden fazla eleman var ise dizi ortadan ikiye bolunmeli
            //ikiye bolme islemi, ilk yari ve ikinci yari icin kendi kendine cagrilmali
            //son olarak bolunmus iki parcayi birlestirmek icin merge() metodu kullanilir

            //ortayi belirle
            int mid = (lowerBound + upperBound) / 2;
            //ilk yariyi sirala
            recMergeSort(workSpace, lowerBound, mid);
            //son yariyi sirala
            recMergeSort(workSpace, mid + 1, upperBound);
            //ikisini birlestir
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }
    //siralanmis parcalari birlestirerek sirali yapi olustur
    //bolunmus alt parcalari sirali bir sekilde birlestirir
    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        // lowPtr sol alt dizinin baslangic indisi - lowerBound yerine kullanacagiz
        // highPtr sağ alt dizinin baslangic indisi - mid+1 yerine kullanacagiz (workSpace'de)

        //workSpace dizinin indis degerini tutacak olan bir degisken tanımlama
        int i=0;
        int lowerBound = lowPtr; //sol alt dizinin baslangic indisi
        int mid = highPtr -1; //sol alt dizinin son indisi tutulur
        //eleman sayisini hesapla
        int n = upperBound-lowerBound + 1;//(eleman sayisi = (son indis - baslangic indisi)+1)

        //her iki alt dizide de eleman kalip kalmadigi kontrol edilir
        //lowPtr <= mid -> sol alt dizide hala islenmemis eleman var mi?
        //highPtr <= upperBound -> sag alt dizide hala islenmemis eleman var mi?

        //ilk while dongusunde iki alt dizide elemanlar karsilastirilir ve siralanir
        //ikinci while dongusunde sol alt dizide kalan elemanlar eklenir
        //ücüncü while dongusunde ise sag alt dizide kalan elemanlar eklenir, böylece iki alt diziyi birlestirme islemi tamamlanır

        while(lowPtr <= mid && highPtr <= upperBound){
            if(dizi[lowPtr] < dizi [highPtr]){
                //sol alt diziden kucuk eleman alinir
                workSpace[i++] = dizi [lowPtr++];

            }
            else {
                //sag alt diziden kucuk eleman alinir
                workSpace[i++] = dizi [highPtr++];
            }
        }

        //sol alt dizide islenmemis eleman kontrolu
        //sol alt dizide kalan elemanlar workSpace'e aktarilir
        //sayilar karsilastirmasina ragmen dizinin sol tarafinda eleman kaldiysa birlestirilen diziye aktar

        while(lowPtr <= mid){
            workSpace[i++] = dizi[lowPtr++];
        }

        //sag alt dizide kalan elemanlar workSpace'e aktarilir
        //sayilar karsilastirmasina ragmen dizinin sag tarafinda eleman kaldiysa birlestirilen diziye aktar

        while(highPtr <= upperBound){
            workSpace[i++] = dizi[highPtr++];
        }

        //birlestirme ve siralama islemini gerceklestirir
        //workSpace'teki sirali elemanlar ana diziye geri yazdirilir
        for(i = 0 ; i < n ; i++){
            //i degiskeni workSpace dizisindeki sirali elemanlari tek tek dolasir
            //hangi konumdan birlestirilecekse lowerBound ile listeleme islemi yapiliyor
            dizi [lowerBound+i] = workSpace[i];//ile sirali elemanlar orijinal dizideki dogru yere yerlestirilir
            //lowerBound+i, orijinal dizinin siralanan alt kismini ifade eder
            //lowerBound baslangic noktasi olarak alinir
            // lowerBound+i yazilmasinin sebebi,merge() metodundaki siralama isleminde sadece belli bir aralık (alt dizi) uzerinde calismasidir
        }
    }
}
