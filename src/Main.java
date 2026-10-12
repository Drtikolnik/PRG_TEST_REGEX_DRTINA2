void main() {

    String jmeno;
    String rasa;
    String datumNarozeni;
    String typZbrane;
    String level;

    ArrayList<Postava> postavy = new ArrayList<Postava>();
    ArrayList<Postava> validniPostavy = new ArrayList<Postava>();
    List<String> radky = new ArrayList<>();

    Path path = Path.of("src/data.txt");

    int lineCount = 0;
    try (BufferedReader br = Files.newBufferedReader(path)) {
        String line;
        while ((line = br.readLine()) != null) {
            lineCount++;
            String[] split = line.split(";");

            //kontrola jesli jsou všchny udaje
            if (split.length != 5) {
                System.out.println("Žádost není validní:");
                System.out.println(" - Chybějící údaj");
                continue;
            }

            //rozdeleni atributu
            jmeno = split[0].trim();
            rasa = split[1].trim();
            datumNarozeni = split[2].trim();
            typZbrane = split[3].trim();
            level = split[4].trim();

            postavy.add(new Postava(jmeno, rasa, datumNarozeni, typZbrane, level));

        }




        ArrayList<String> chybny = new ArrayList<String>();
        chybny.clear();
        int radek = 1;
        for (Postava o : postavy) {

            //kontrola jmena
            if(!ValidacePostav.platneJmeno(o.getJmeno())){
                chybny.add("Neplatné jméno");
            }

            //kontrola rasy
            if(!ValidacePostav.platnaRasa(o.getRasa())){
                chybny.add("Neplatná rasa");
            }

            //kontrola data
            if(!ValidacePostav.platnyDatumNarozeni(o.getDatumNarozeni())){
                chybny.add("neplatné datum narození");
            }

            //kontrola zbrane
            if(!ValidacePostav.platnyTypZbrane(o.getTypZbrane())){
                chybny.add("Neplatný typ zbraně");
            }

            //kontrola levelu
            if(!ValidacePostav.platnyLevel(o.getXp())){
                chybny.add("Neplatný level");
            }



            //výpis, jestli je postava validní nebo ne
            if(chybny.isEmpty()){
                System.out.println("Žádost postavy " +o.getJmeno()+ " je validní");
                validniPostavy.add(o);
            }else{
                System.out.println("Žádost není validní: " +o.getJmeno());
                for (String s : chybny) {
                    System.out.println(" - " + s);
                }
                chybny.clear();
            }

            radek++;
        }

        //vypíše všehny validní postavy
        System.out.println("všechny validní postavy:");
        for (Postava o : validniPostavy) {
            System.out.println(o.getJmeno());
        }

        //vypíše postavy mladší 18 let
        System.out.println("Postavy mladší 18 let:");
        for(Postava o : validniPostavy){
            String rok;


            String[] split = o.getDatumNarozeni().split("\\.");

            rok = split[1].trim();

            int vek = Integer.parseInt(rok) - 2026;
            if(vek < 18){
                System.out.println(o.getJmeno());
            }
        }

        //vypíše počet postav, u kteryh je validni rasa
        System.out.print("pocet validnich zadosti podle rasy: ");
        int pocetPodleRasy=0;
        for(Postava o : postavy){
            if(!ValidacePostav.platnaRasa(o.getRasa())){
                chybny.add("Neplatná rasa");
            }

            if(!chybny.isEmpty()){
                pocetPodleRasy++;
            }
        }
        System.out.println(pocetPodleRasy);

    }catch (Exception e) {
        e.printStackTrace();
    }
































}