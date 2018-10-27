public class Demo {

    public static String makeTechRiddle(Conference conference) {
        String puzzle = null;
        if (conference instanceof JavaConference) {
            JavaConference javaConference = (JavaConference) conference;
            puzzle = javaConference.getTechPuzzle();
        }
        return puzzle;
    }

    public static String showExhibitionArea(Conference conference) {
        String expo = null;
        if (conference instanceof DataScienceConference) {
            DataScienceConference dsConference = (DataScienceConference) conference;
            expo = dsConference.getExhibitionArea();
        }
        return expo;
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
        pyCon.setPrice(javaCon.getPrice());

        for (Conference conference: conferences) {
            System.out.println(conference);

            if (conference.getTalks() != null) {
                System.out.println("The talks are as follows: ");
                for (String talk : conference.getTalks()) {
                    System.out.println(talk);
                }
            }
            if (conference.getWorkshops() != null) {
                System.out.println("The workshops are as follows: ");
                for (String workshop : conference.getWorkshops()) {
                    System.out.println(workshop);
                }
            }

            if (makeTechRiddle(conference) != null) {
                System.out.println("Solve the riddle: " + makeTechRiddle(conference));
            }
            if (showExhibitionArea(conference) != null) {
                System.out.println("Visit the exhibition: " + showExhibitionArea(conference));
            }

            System.out.println("The winners of free tickets are: ");
            for (String winner: conference.pickFreeTicketsWinners(giveAwayContestCandidates, 2)) {
                System.out.println(winner);
            }
            System.out.println("The price is " + conference.showPrice());
            System.out.println("---------------");
        }




    }

}
