import java.io.IOException;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        try {
            List<ember>emberek = new ArrayList<>();
            try(BufferedReader reader = new BufferedReader(new FileReader("bukkm2019.txt")))
            {
                String  szam;
                int szamlalo = 0;
                while ((szam = reader.readLine())!=null)
                {
                    String[] sor = reader.readLine().split(";");
                    ember ember = new ember();
                    ember.rajtszam = sor[0];
                    ember.kategoria = sor[1];
                    ember.nev = sor[2];
                    ember.egyesulet = sor[3];
                    ember.ido = sor[4];
                    emberek.add(ember);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //1. feladat
            System.out.print("A versenytávot nem teljesítők: ");
            double kivont = 691 - emberek.size();
            double osszesen = kivont / emberek.size();
            System.out.println(osszesen);
            //2.feladat



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}