/**
 * A program to carry on conversations with a human user. This is the initial
 * version that:
 * <ul>
 * <li>Uses indexOf to find strings</li>
 * <li>Handles responding to simple words and phrases</li>
 * </ul>
 * This version uses a nested if to handle default responses.
 * 
 * @author Laurie White
 * @version April 2012
 */
public class Magpie {
    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response = "";
        if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0 || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0 || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a non-committal string
     */
    public String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        }

        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise.
    public int findWord(String str, String word) {
        String string = str.toLowerCase();
        String word1 = word.toLowerCase();
        String[] splitstring = str.split(" ");
        int a = 0;

        for (int i = 0; i < splitstring.length; i++){
            String b = splitstring[i].toLowerCase();
            if (b.equals(word1)){
                a = a +1;
            }
            else {
                a = a + 0;
            }
        }
        if (a >= 1) {
            return string.indexOf(word1);
        }
        else {
            return -1;
        }

    }

    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into "Would you
     * really be happy if you had <something>?"
     * 
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement) {
        String statement1 = statement.trim();
        String lastchar = statement1.substring(statement1.length() - 1);
        if (lastchar.equals(".") || lastchar.equals("!")) {
            statement = statement1.substring(0, statement1.length() - 1);
        }
        int a = findWord(statement1, "I want");
        String restofstatement = statement1.substring(a + 8).trim();
        return "Would you really be happy if you had " + restofstatement + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into "Why do you
     * <something> me?"
     * 
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement) {
        String statement1 = statement.trim();
        String lastchar = statement1.substring(statement1.length() - 1);
        if (lastchar.equals(".")) {
            statement1 = statement1.substring(0, statement1.length() - 1);
        }

        int I = findWord(statement1, "I");
        int you = findWord(statement1, "you");

        String restofstatement = statement1.substring(I + 1, you).trim();
        return "Why do you " + restofstatement + " me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into "What
     * would it mean to <something>?"
     * 
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement) {
        String statement1 = statement.trim();
        String lastchar = statement1.substring(statement.length() - 1);
        if (lastchar.equals(".") || lastchar.equals("!")) {
            statement1 = statement1.substring(0, statement.length() - 1);
        }
        int a = findWord(statement1, "I want to");
        String restofstatement = statement1.substring(a + 11).trim();
        return "What would it mean to " + restofstatement + "?";
    }

    /**
     * Take a statement with "you <something> me" and transform it into "What makes
     * you think that I <something> you?"
     * 
     * @param statement the user statement, assumed to contain "you" followed by
     *                  "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement) {
        String statement1 = statement.trim();
        String lastchar = statement1.substring(statement1.length() - 1);
        if (lastchar.equals(".")) {
            statement1 = statement1.substring(0, statement1.length() - 1);
        }

        int you = findWord(statement, "you");
        int me = findWord(statement, "me");

        String restofstatement = statement1.substring(you + 3, me).trim();
        return "What makes you think that I " + restofstatement + " you?";
    }
}
