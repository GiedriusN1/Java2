/*
* ArrayActionsLaunch.java
*
* Created on Trečiadienis, 2007, Rugsėjo 12, 18.58
*
*/

/**
*  Uzduotis:
* Duoti du masyvai A(n) ir B(m). Masyvų didžiausius elementus pašalinti, 
* o tų elementų aritmetinį vidurkį užrašyti abiejų masyvų gale. 
* Spausdinti masųyvus prieš ir po veiksmų.
*
* @author Novice
*/
public class ArrayActionsLaunch {
   
    /** Creates a new instance of ArrayActionsLaunch */
    public ArrayActionsLaunch() {
    }
   
        // masyvai, su kuriais bus atliekami veiksmai, darant prielaida,
        // kad juose bus saugomi double tipo elementai
        static double[] A = new double[] {5, 7, 3};
        static double[] B = new double[] {10, -1, 3};
       
        // maksimaliu elementu suma
        static double sumOfMax = 0;
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // parodomi pradiniai masyvai
        System.out.println("Pradiniai masyvai:");
        showArray(A);
        showArray(B);
       
        // pasalinami maksimalus masyvu elementai
       
        int maxOfA = findMax(A);
        int maxOfB = findMax(B);
        deleteMax(A, maxOfA);
        deleteMax(B, maxOfB);
 
        double average = findAverage();
       
        replaceLastWithAverage(A, average);
        replaceLastWithAverage(B, average);
       
        // parodomi galutiniai masyvai
        System.out.println("Galutiniai masyvai:");
        showArray(A);
        showArray(B);
    }
   
     /**
      * parodo masyvo elementus
      * @param array masyvas, kurio elementai bus parodomi
      */
    public static void showArray(double[] array) {
        for (double i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
   
    /**
     * salina maksimalu elementa nurodytu indeksu
     * @param array masyvas, is kurio reikia salinti maksimalu elementa
     * @param indexOfMax indeksas masyvo elemento, kuri reikia pasalinti
     */
    public static void deleteMax(double[] array, int indexOfMax) {
        if (indexOfMax < array.length-1) {
            System.arraycopy(array, indexOfMax+1, array, indexOfMax, array.length - indexOfMax-1);
            // cia palieku paskutini masyvo elementa, koks buvo, turint galvoje, kad jis vis tiek bus pakeistas
            // vidurkiu. siaip tai galima butu kurti kita masyva, i ji kopijuoti laikinai ir pan.
        }       
    }
   
    /**
     * randa maksimaliu elementu vidurki
     * @return dvieju maksimaliu elementu vidurkis
     */
    public static double findAverage() {
        return sumOfMax/2;
    }
   
    /**
     * iraso elementu vidurki vietoj paskutinio masyvo elemento
     * @param array masyvas, kurio paskutinis elementas pakeiciamas
     *              maksimaliu elementu vidurkiu
     * @param average vidurkis, kuriuo reikia pakeisti pask. elementa
     */
    public static void replaceLastWithAverage(double[] array, double average) {
        array[array.length-1] = average;
    }
   
    /**
     * randa maksimalu elementa
     * @param array sveikuju skaiciu masyvas
     * @return indexOfMax maksimalaus array masyvo elemento indeksas
     */
    public static int findMax(double[] array) {
        // cia dar reiketu patikrinti, ar tinkamo ilgio masyvas perduotas
        double max = array[0];
        int indexOfMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[ i ] > max) {
                max = array[ i ];
                indexOfMax = i;
            }
        }
        sumOfMax += max; // susumuoji maksimalius elementus, kad veliau butu galima rasti vidurki
        return indexOfMax;
    }
   
}