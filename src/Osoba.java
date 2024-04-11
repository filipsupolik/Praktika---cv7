public class Osoba {
    private String meno;
    private String priezvisko;
    private String rodneCislo;

    public Osoba(String meno, String priezvisko, String rodneCislo) throws NespravneRodneCisloException {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.rodneCislo = rodneCislo;
        if (!this.skontrolujRC()) {
            this.rodneCislo = "00000/0000";
            throw new NespravneRodneCisloException();
        }
    }

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getRodneCislo() {
        return this.rodneCislo;
    }

    public void setRodneCislo(String rodneCislo) throws NespravneRodneCisloException {
        if (this.skontrolujRC()) {
            this.rodneCislo = rodneCislo;
        } else {
            this.rodneCislo = "00000/0000";
            throw new NespravneRodneCisloException();
        }
    }

    public boolean skontrolujRC() {
        String rc = this.rodneCislo;
        rc = rc.replace("/", "");
        int sumaParne = 0;
        int sumaNeparne = 0;
        for (int i = 0; i < rc.length(); i++) {
            int cislica = Character.getNumericValue(rc.charAt(i));
            if (i % 2 == 0) {
                sumaParne += cislica;
            } else {
                sumaNeparne += cislica;
            }
        }
        int rozdiel = Math.abs(sumaParne - sumaNeparne);
        return rozdiel == 0 || rozdiel == 11 || rozdiel == 22;
    }

    @Override
    public String toString() {
        return this.meno + " " + this.priezvisko + " " + "(" + this.rodneCislo + ")";
    }
}
