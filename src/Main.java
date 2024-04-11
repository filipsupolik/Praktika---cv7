import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Zamestnanec> zamestnanci = new ArrayList<>();
        Firma firma = new Firma("Nova Firma", zamestnanci);
        boolean koniec = false;
        Scanner sc = new Scanner(System.in);
        while (!koniec) {
            System.out.println("Vyber akciu:");
            System.out.println("[1] Pridat zamestnanca");
            System.out.println("[2] Zamestnanci");
            System.out.println("[3] Celkovy vypis");
            System.out.println("[4] Priemerny plat");
            System.out.println("[5] Najvyssi plat");
            System.out.println("[6] Zamestnanec s najvyssim platom");
            System.out.println("[7] Zamestnanci s nadpriemernym platom");
            System.out.println("[8] Zamestnanci s daneho roku");
            System.out.println("[9] ukonci");
            int cisloPrikazu = sc.nextInt();
            switch (cisloPrikazu) {
                case 1:
                    System.out.println("Prosim zadajte meno zamestnanca:");
                    String meno = sc.next();
                    System.out.println("Prosim zadajte priezvisko zamestnanca:");
                    String priezvisko = sc.next();
                    System.out.println("Prosim zadajte rodne cislo zamestnanca:");
                    String rodneCislo = sc.next();
                    System.out.println("Prosim zadajte rok nastupu zamestnanca:");
                    int rokNastupu = sc.nextInt();
                    System.out.println("Prosim zadajte plat zamestnanca v hrubom:");
                    double plat = sc.nextDouble();
                    Zamestnanec zamestnanec = null;
                    try {
                        zamestnanec = new Zamestnanec(meno, priezvisko, rodneCislo, rokNastupu, plat);
                    } catch (NespravneRodneCisloException e) {
                        System.out.println("Zadal si nespravne rodne cislo");
                    } catch (ZaporneCisloException e) {
                        System.out.println("Zadal si zaporny rok alebo plat");
                    }
                    if (firma.pridajZamestnanca(zamestnanec)) {
                        break;
                    } else {
                        System.out.println("Nepodarilo sa pridat zamestnanca");
                    }
                    break;
                case 2:
                    firma.vypisZamestnancov();
                    break;
                case 3:
                    firma.vypisVsetko();
                    break;
                case 4:
                    System.out.println(firma.dajPriemernyPlat());
                    break;
                case 5:
                    System.out.println(firma.dajNajvyssiPlat());
                    break;
                case 6:
                    System.out.println(firma.dajZamestnancaSMaxPlatom());
                    break;
                case 7:
                    for (Zamestnanec zamestnanec1 : firma.dajZamestnancovSNadpriemernymPlatom()) {
                        System.out.println(zamestnanec1);
                    }
                    break;
                case 8:
                    System.out.println("Prosim zadaj rok, z ktoreho chces zamestnancov:");
                    int rok = sc.nextInt();
                    for (Zamestnanec zamestnanec1: firma.dajZamestnancovZDanehoRoku(rok)) {
                        System.out.println(zamestnanec1);
                    }
                    break;
                case 9:
                    koniec = true;
            }
        }
    }
}