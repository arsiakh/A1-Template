package ca.mcmaster.se2aa4.mazerunner;

public class PathFormat {
    private String path;
    
    public PathFormat(String path) {
        this.path = path;
    }

    public String pathFactored() {
        if (path == null || path.isEmpty()) {
            return "";
        }
        
        StringBuilder factored = new StringBuilder();
        int i = 0;
        
        while (i < path.length()) {
            char current = path.charAt(i);
            int count = 1;
            
            // Count consecutive same characters
            while (i + 1 < path.length() && path.charAt(i + 1) == current) {
                count++;
                i++;
            }
            
            // Add to result
            if (count > 1) {
                factored.append(count).append(current);
            } else {
                factored.append(current);
            }
            
            i++;
        }
        
        return factored.toString();
    }

    public String pathCanonical() {
        if (path == null || path.isEmpty()) {
            return "";
        }
        
        StringBuilder canonical = new StringBuilder();
        int i = 0;
        
        while (i < path.length()) {
            char current = path.charAt(i);
            
            if (Character.isDigit(current)) {
                // Get the full number
                int numStart = i;
                while (i + 1 < path.length() && Character.isDigit(path.charAt(i + 1))) {
                    i++;
                }
                int repeat = Integer.parseInt(path.substring(numStart, i + 1));
                
                // Get and repeat the move character
                if (i + 1 < path.length()) {
                    char move = path.charAt(i + 1);
                    canonical.append(String.valueOf(move).repeat(repeat));
                }
                i++; // Move past the move character
            } else {
                canonical.append(current);
            }
            i++;
        }
        
        return canonical.toString();
    }
}
/*  
public class PathFormat {
    String pathCanonical;
    String pathFactored;
    String path;

    public PathFormat(String path) {
        this.path = path;
        this.pathCanonical = "";
        this.pathFactored = "";
        

    }
    

    public String pathFactored() { //FFFF R FFF L FFFFF = 5F R F3 L 5F
        pathCanonical = path;
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
    public String pathCanonical() {
        pathFactored = path;
        int i = 0;
        while (i < pathFactored.length()) {
            char current = pathFactored.charAt(i);
    
            if (Character.isDigit(current)) {
                // Handle number prefix
                int numStart = i;
                while (i + 1 < pathFactored.length() && Character.isDigit(pathFactored.charAt(i + 1))) {
                    i++;
                }
                int repeat = Integer.parseInt(pathFactored.substring(numStart, i + 1));
                char move = pathFactored.charAt(i + 1);
                
                // Simply repeat the move the specified number of times
                for (int j = 0; j < repeat; j++) {
                    pathCanonical += move;
                }
                i++; // Move past the move character
            } else {
                // Handle single move
                pathCanonical += current;
            }
            i++;
        }
    
        return pathCanonical;
    }
    

}
*/