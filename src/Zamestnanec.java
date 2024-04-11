public class Zamestnanec extends Osoba {
    private int rokNastupu;
    private double plat;

    public Zamestnanec(String meno, String priezvisko, String rodneCislo, int rokNastupu, double plat) throws NespravneRodneCisloException, ZaporneCisloException {
        super(meno, priezvisko, rodneCislo);
        if (rokNastupu > 0) {
            this.rokNastupu = rokNastupu;
        } else {
            throw new ZaporneCisloException();
        }
        if (plat > 0) {
            this.plat = plat;
        } else {
            throw new ZaporneCisloException();
        }

    }

    public int getRokNastupu() {
        return this.rokNastupu;
    }

    public void setRokNastupu(int rokNastupu) throws ZaporneCisloException {
        if (rokNastupu > 0) {
            this.rokNastupu = rokNastupu;
        } else {
            throw new ZaporneCisloException();
        }
    }

    public double getPlat() {
        return this.plat;
    }

    public void setPlat(double plat) throws ZaporneCisloException {
        if (plat >= 0) {
            this.plat = plat;
        } else {
            throw new ZaporneCisloException();
        }
    }

    @Override
    public String toString() {
        return this.getMeno() + " " + this.getPriezvisko() + " " + "(" + this.getRodneCislo() + ")" + " - " +
                this.getPlat() + " - zamestnany od " + this.getRokNastupu();
    }
}
