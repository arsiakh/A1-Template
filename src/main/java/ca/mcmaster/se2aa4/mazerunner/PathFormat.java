package ca.mcmaster.se2aa4.mazerunner;

public class PathFormat {
    String pathCanonical;
    String pathFactored;

    public PathFormat(String pathCanonical) {
        this.pathCanonical = pathCanonical;
        this.pathFactored = "";
    }

    public String pathCanonical() { 
        return pathCanonical; //original non factored path

    }

    public String pathFactored() { //FFFF R FFF L FFFFF = 5F R F3 L 5F
        for (int i = 0; i < pathCanonical.length(); i++) {
            if (pathCanonical.charAt(i) == 'F') {
                int countF = 1;
                while (i + 1 < pathCanonical.length() && pathCanonical.charAt(i + 1) == 'F') { //count the number of F's
                    countF++;
                    i++;
                }
                if (countF > 1) { //only if there is more than one conceding F place the number
                    pathFactored += countF + "F";
                } else {
                    pathFactored += "F";
                }
                
            } 
            if (pathCanonical.charAt(i) == 'R') {
                int countR = 1;
                while (i + 1 < pathCanonical.length() && pathCanonical.charAt(i + 1) == 'R') { //count R's same process as F
                    countR++;
                    i++;
                }
                if (countR > 1) {
                    pathFactored += countR + "R";
                } else {
                    pathFactored += "R";
                }
                
                }
            if (pathCanonical.charAt(i) == 'L') { //Count L's same process as F and R 
                int countL = 1;
                while (i + 1 < pathCanonical.length() && pathCanonical.charAt(i + 1) == 'L') {
                    countL++;
                    i++;
                }
                if (countL > 1) {
                    pathFactored += countL + "L";
                } else {
                    pathFactored += "L";
                }
                }
            } 
            return pathFactored;
            
     


    }
    

}
