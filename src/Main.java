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
            BufferedReader reader = new BufferedReader(new FileReader("bukkm2019.txt"));
                reader.readLine();
                String Sor;
                while ((Sor = reader.readLine())!=null)
                {
                    String[] sor = Sor.split(";");
                    ember ember = new ember();
                    ember.rajtszam = sor[0];
                    ember.kategoria = sor[1];
                    ember.nev = sor[2];
                    ember.egyesulet = sor[3];
                    ember.ido = sor[4];
                    emberek.add(ember);
                }

            //4. feladat
            System.out.print("4. feladat: ");
            System.out.print("A versenytávot nem teljesítők: ");
            double kivont = 691 - emberek.size();
            double osszesen = kivont / emberek.size();
            System.out.println(osszesen*100+"%");

            //5.feladat
            System.out.print("5. feladat: ");
            Integer szamlalo = 0;
            for (ember a: emberek)
            {
                Versenytav vt = new Versenytav(a.rajtszam);
                char utolso = a.kategoria.charAt(a.kategoria.length() - 1);
                if (utolso == 'n' && vt.getTav() == "Rövid")
                {
                    szamlalo ++;
                }
            }
            System.out.println("A női versenyzők száma rövid távon: "+szamlalo+"fő");

            //6. feladat
            System.out.print("6. feladat: ");
            boolean bool = false;
            for (ember a:emberek)
            {
                String[] sor = a.ido.split(":");
                int ora = Integer.parseInt(sor[0]);
                if (ora >= 6)
                {
                    bool = true;
                }
            }
            if (bool == true)
            {
                System.out.println("Volt ilyen versenyző");
            }
            else
            {
                System.out.println("Nem volt ilyen versenyző");
            }
            //7. feladat
            System.out.print("7. feladat: ");

            int kicsi = 1000000;
            boolean start = false;
            String hetrajt = " ";
            String hetnev = " ";
            String hetegyes = " ";
            String hetido = " ";
            for (ember a: emberek)
            {
                Versenytav vt = new Versenytav(a.rajtszam);
                String[] sor = a.ido.split(":");
                String elokesz = sor[0] + sor[1] + sor[2];
                int szam = Integer.parseInt(elokesz);
                if (a.kategoria.equals("ff")  && vt.getTav().equals("Rövid"))
                {
                    if (kicsi > szam)
                    {
                        kicsi = szam;

                        hetrajt = a.rajtszam;
                        hetnev = a.nev;
                        hetegyes = a.egyesulet;
                        hetido = a.ido;
                    }
                }
            }
            System.out.println("A felnőtt férfi (ff) kategória győztese rövi távon");
            System.out.println("Rajtszám: "+hetrajt);
            System.out.println("Nev: "+hetnev);
            System.out.println("Egyesület: "+hetegyes);
            System.out.println("Idő: "+hetido);

            //8. feladat
            System.out.print("8. feladat: ");
            List<String> kategoriak = new ArrayList<>();
            for (ember a:emberek)
            {
                String uj = a.kategoria;
                if (!kategoriak.contains(uj))
                {
                    kategoriak.add(uj);
                }
            }
            String kateg = "";
            int szam = 0;
            for (String a:kategoriak)
            {
                kateg = a;
                for (ember b:emberek)
                {
                    if (kateg.equals(b.kategoria))
                    {
                        szam = szam + 1;
                    }
                }
                System.out.println(kateg + " - "+szam+"fő");
                szam = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}