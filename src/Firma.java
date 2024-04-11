import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Firma {
    private final String nazov;
    private final ArrayList<Zamestnanec> zoznamZamestnancov;

    public Firma(String nazov, ArrayList<Zamestnanec> zoznamZamestnancov) {
        this.nazov = nazov;
        this.zoznamZamestnancov = zoznamZamestnancov;
    }


    public boolean pridajZamestnanca(Zamestnanec zam) {
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            if (!zam.getRodneCislo().equals(zamestnanec.getRodneCislo())) {
                this.zoznamZamestnancov.add(zam);
                return true;
            } else if (this.zoznamZamestnancov.isEmpty()) {
                this.zoznamZamestnancov.add(zam);
                return true;
            }
        }
        return false;
    }

    public void vypisZamestnancov() {
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            System.out.println(zamestnanec);
        }
    }

    public void vypisVsetko() {
        System.out.printf(this.nazov);
        this.vypisZamestnancov();
    }

    public double dajPriemernyPlat() {
        double celkovyPlat = 0;
        double priemernyPlat;
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            celkovyPlat += zamestnanec.getPlat();
        }
        priemernyPlat = celkovyPlat / this.zoznamZamestnancov.size();
        return priemernyPlat;
    }

    public double dajNajvyssiPlat() {
        double najvyssiPlat = 0;
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            double aktualnyPlat = zamestnanec.getPlat();
            if (aktualnyPlat > najvyssiPlat) {
                najvyssiPlat = aktualnyPlat;
            }
        }
        return najvyssiPlat;
    }

    public Zamestnanec dajZamestnancaSMaxPlatom() {
        Zamestnanec najvyssiPlat = this.zoznamZamestnancov.get(0);

        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            if (zamestnanec.getPlat() > najvyssiPlat.getPlat()) {
                najvyssiPlat = zamestnanec; 
            }
        }

        return najvyssiPlat;
    }

    public List<Zamestnanec> dajZamestnancovSNadpriemernymPlatom() {
        List<Zamestnanec> zamestnanci = new ArrayList<>();
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            if (zamestnanec.getPlat() > this.dajPriemernyPlat()) {
                zamestnanci.add(zamestnanec);
            }
        }
        return Collections.unmodifiableList(zamestnanci);
    }

    public List<Zamestnanec> dajZamestnancovZDanehoRoku(int rok) {
        List<Zamestnanec> zamestnanci = new ArrayList<>();
        for (Zamestnanec zamestnanec : this.zoznamZamestnancov) {
            if (zamestnanec.getRokNastupu() == rok) {
                zamestnanci.add(zamestnanec);
            }
        }
        return Collections.unmodifiableList(zamestnanci);
    }
}
