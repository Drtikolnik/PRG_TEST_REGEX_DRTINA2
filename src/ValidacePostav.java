import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public class ValidacePostav {



//ulozeni  paternu
    private static final Pattern jmenoR = Pattern.compile("[A-Z]{1}[a-z]+"); //^\\p{Lu}\\p{Ll}$"
    private static final Pattern rasaR = Pattern.compile("(Elf|Trpaslík|Člověk|Ork|Hobit)");
    private static final Pattern datumR = Pattern.compile("(0[1-9]|[12]\\d|3[01])\\.(0[1-9]|1[0-2])\\.\\d{4}");
    //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final Pattern typZbraneR = Pattern.compile("^(Meč|Kuše|Hůl|Sekera|Dýka)$");
    private static final Pattern levelR = Pattern.compile("^\\d{1,100}");

    public ValidacePostav() {
    }


    //kontrola
    public static boolean platneJmeno(String jmeno) {
        return jmenoR.matcher(jmeno).matches();
    }
    public static boolean platnaRasa(String rasa) {
        return rasaR.matcher(rasa).matches();
    }
    public static boolean platnyDatumNarozeni(String datum) {
        return datumR.matcher(datum).matches();
    }
    /*
    public static boolean platnyDatumNarozeni(String datum) {
        if (datum == null) {
            return false;
        }
        try {
            LocalDate.parse(datum, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    */

    public static boolean platnyTypZbrane(String zbran) {
        return typZbraneR.matcher(String.valueOf(zbran)).matches();
    }
    public static boolean platnyLevel(String level) {
        return levelR.matcher(String.valueOf(level)).matches();
    }





/*


    public void validaceRadku(){
        for(String radek : radky){
            //Jméno a příjmení	^\p{Lu}\p{Ll}+\s\p{Lu}\p{Ll}+$
            //Datum narozeni ^(0[1-9]|[12]\d|3[01])\.(0[1-9]|1[0-2])\.\d{4}$
            //Telefon	^\+420 \d{3} \d{3} \d{3}$
            //Email	^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$
            //Město	^\p{Lu}[\p{L} ]*$
            //Ulice	^\p{Lu}[\p{L} ]*$
            //Číslo popisné	^[1-9]\d*$
            //PSČ	^\d{3} \d{2}$


        }

    }
*/



























}