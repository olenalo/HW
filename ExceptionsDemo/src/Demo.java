public class Demo {

    public static String makeTechRiddle(Object object) {
        // This is where ClassCastException could be thrown
        // if for example `PythonConference` object is passed;
        // Downcasting would also provoke the exception
        JavaConference javaConference = (JavaConference) object;
        return javaConference.getTechPuzzle();
    }

    public static String showExhibitionArea(Object object) {
        // This is where ClassCastException could be thrown
        // if for example `JavaConference` object is passed;
        // Downcasting would also provoke the exception
        DataScienceConference dsConference = (DataScienceConference) object;
        return dsConference.getExhibitionArea();
    }

    public static void main(String[] args) {



    }

}
