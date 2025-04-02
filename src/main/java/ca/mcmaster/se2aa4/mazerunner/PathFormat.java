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