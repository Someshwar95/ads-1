import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *team class is to store properties.
 *of a team.
 */
class Team {
    /**
     *variable to store team name.
     */
    private String teamName;
    /**
     *variable to store number of wins.
     */
    private int wins;
    /**
     *variable to store number of
     * lost matches.
     */
    private int losses;
    /**
     *variable to store number
     * of tie matches.
     */
    private int dw;
    /**
     * constructor to initialize all properties.
     * @param      name  The name
     * @param      won   The won
     * @param      loss  The loss
     * @param      draw  The draw
     */
    Team(final String name,
         final int won, final int loss, final int draw) {
        teamName = name;
        wins = won;
        losses = loss;
        dw = draw;
    }
    /**
     *method to get the name.
     *
     * @return     The name.
     */
    public String getName() {
        return teamName;
    }
    /**
     *method gives the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     *method gives the Losses.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return losses;
    }
    /**
     *this method is to get the draws.
     *
     * @return     The draw.
     */
    public int getDraw() {
        return dw;
    }
}
/**
 * Class for leader board.
 * it stores the data of all teams.
 */
class LeaderBoard {
    /**
    * list is the arraylist created.
     * for storing all the objects.
     */
    private ArrayList<Team> list;
    /**
     * the constructor to initialize the.
     * arraylist.
     */
    LeaderBoard() {
        list = new ArrayList<Team>();
    }
    /**.
     * { function_description }
     *
     * @param      firstTeam   The first team
     * @param      secondTeam  The second team
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(
        final Team firstTeam, final Team secondTeam) {
        if (firstTeam.getWins() < secondTeam.getWins()) {
            return  -1;
        } else if (firstTeam.getWins() > secondTeam.getWins()) {
            return 1;
        } else {
            if (firstTeam.getLosses() < secondTeam.getLosses()) {
                return 1;
            } else if (firstTeam.getLosses() > secondTeam.getLosses()) {
                return -1;
            } else {
                if (firstTeam.getDraw() < secondTeam.getDraw()) {
                    return -1;
                } else if (firstTeam.getDraw() > secondTeam.getDraw()) {
                    return 1;
                }
            }
        }
        return 0;
    }
    /**
     * the method to add the object to array.
     * the time complexity is O(1).
     * because we just insert an element.
     * @param      obj   The object
     */
    public void addTo(final Team obj) {
        list.add(obj);
    }
    /**
     *this method is to perform the sorting.
     *operation.
     *the time complexiety will be N + N^2/2.
     *N is the size of array.
     *it will iterate through out the array.
     *for each comparision so we have N comparisons.
     *and N^2/2.
     */
    public void sorting() {
        int max = 0;
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            max = i;
            for (int j = i + 1; j < list.size(); j++) {
                flag = compareTo(list.get(max), list.get(j));
                if (flag == -1) {
                    max = j;
                }
            }
            Collections.swap(list, i, max);
        }
    }
    /**
     *to print the string format of array.
     *time complexiety is O(n)
     *n is size of the array.
     * @return  str the objects in array.
     */
    public String print() {
        String str = "";
        for (int i = 0; i < list.size() - 1; i++) {
            str += list.get(i).getName() + ",";
        }
        str += list.get(list.size() - 1).getName();
        return str;
    }
}
/**
 *the solution class for main.
 */
final class Solution {
    /**
     * empty constructor.
     */
    private Solution() {
    }
    /**
     * this is main to read the input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Team obj;
        final int three = 3;
        LeaderBoard object = new LeaderBoard();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            obj = new Team(tokens[0],
                           Integer.parseInt(tokens[1]),
                           Integer.parseInt(tokens[2]),
                           Integer.parseInt(tokens[three]));
            object.addTo(obj);
        }
        object.sorting();
        System.out.println(object.print());
    }
}



