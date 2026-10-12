public class Postava {

    private String jmeno;
    private String rasa;
    private String datumNarozeni;
    private String typZbrane;
    private String xp;

    public Postava(String jmeno, String rasa, String datumNarozeni, String typZbrane, String xp) {
        this.jmeno = jmeno;
        this.rasa = rasa;
        this.datumNarozeni = datumNarozeni;
        this.typZbrane = typZbrane;
        this.xp = xp;

    }





    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno  = jmeno;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getTypZbrane() {
        return typZbrane;
    }

    public void setTypZbrane(String typZbrane) {
        this.typZbrane = typZbrane;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }
}
