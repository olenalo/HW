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
                "Tower of Hanoi");
        Conference pyCon = new PythonConference(
                "PyCon Ukraine",
                "Monty Python");
        Conference dsCon = new DataScienceConference(
                "Data Science World Conference",
                "UCU",
                "Robots-Programmers Expo");

        conferences[0] = javaCon;
        conferences[1] = pyCon;
        conferences[2] = dsCon;
        String[] giveAwayCandidates = new String[] {"Vova", "OPersian", "Lola", "Linda", "Max", "Peter"};

        for (Conference conference: conferences) {
            System.out.println(conference);
            System.out.println(conference.getTalks());
            System.out.println(conference.getWorkshops());
            System.out.println(makeTechRiddle(conference));
            System.out.println(showExhibitionArea(conference));
            System.out.println("The winners of free tickets are: ");
            for (String winner: conference.pickFreeTicketsWinners(giveAwayCandidates, 2)) {
                System.out.println(winner);
            }
            System.out.println("---------------");
        }


    }

}
