public class Demo {

    public static String makeTechRiddle(Conference conference) {
        // FIXME: This is where ClassCastException could be thrown
        // if for example `PythonConference` object is passed;
        // Downcasting would also provoke the exception
        JavaConference javaConference = (JavaConference) conference;
        return javaConference.getTechPuzzle();
    }

    public static String showExhibitionArea(Conference conference) {
        // FIXME: This is where ClassCastException could be thrown
        // if for example `JavaConference` object is passed;
        // Downcasting would also provoke the exception
        DataScienceConference dsConference = (DataScienceConference) conference;
        return dsConference.getExhibitionArea();
    }

    public static void main(String[] args) {

        Conference[] conferences = new Conference[3];

        Conference javaCon = new JavaConference(
                "JavaCon Europe",
                "Jabba the Hutt",
                "Tower of Hanoi",
                550);
        Conference pyCon = new PythonConference(
                "PyCon Ukraine",
                "Monty Python",
                450);
        Conference dsCon = new DataScienceConference(
                "Data Science World Conference",
                "UCU",
                "Robots-Programmers Expo",
                1000);

        conferences[0] = javaCon;
        conferences[1] = pyCon;
        conferences[2] = dsCon;
        String[] giveAwayContestCandidates = new String[] {"Vova", "OPersian", "Lola", "Linda", "Max", "Peter"};

        // Update the price (organizers decided to make JavaCon and PyCon prices equal taking the JavaCon price)
        // FIXME: NumberFormatException (cannot cast string of such format to numeric type)
        pyCon.setPrice(Double.valueOf(javaCon.showPrice()));

        for (Conference conference: conferences) {
            System.out.println(conference);
            System.out.println("The talks are as follows: ");

            // FIXME: NullPointerException could occur here and below
            // if a conference has no `talks`
            for (String talk: conference.getTalks()) {
                System.out.println(talk);
            }
            System.out.println("The workshops are as follows: ");
            for (String workshop: conference.getWorkshops()) {
                System.out.println(workshop);
            }

            System.out.println(makeTechRiddle(conference));
            System.out.println(showExhibitionArea(conference));

            System.out.println("The winners of free tickets are: ");
            for (String winner: conference.pickFreeTicketsWinners(giveAwayContestCandidates, 2)) {
                System.out.println(winner);
            }
            System.out.println("The price is " + conference.showPrice());
            System.out.println("---------------");
        }




    }

}
