import java.util.*;

public class LotteryProgram {

    //CONSTANT VARIABLES
    public static final int NUMBERS = 6;
    public static final int MAX_NUMBERS = 40;
    public static final int PRIZE = 100;

    public static void main(String[] args) {

        //Randomly Generate Winning Lottery Ticket
        //Prompt Players to Enter Numbers from 1 to 40
        //Depending on How many number match, player wins various prizes

        //Two Sets: Winning Number and Player Number


        // GET WINNING NUMBERS AND PLAYER NUMBERS

        Set <Integer> winning = CreateWinningNumbers();
        Set <Integer> ticket = GetPlayerNumbers();

        System.out.println();

        //CHECK WINNING NUMBERS IN PLAYER NUMBERS
        Set <Integer> matchingNumbers = new TreeSet<>(ticket);
        matchingNumbers.retainAll(winning);
        //retain all to keep winning numbers from player number

        //PRIZE CALCULATION
        System.out.println("Your Ticket Numbers: " +ticket);
        System.out.println("Winning Numbers: " +winning);

        if(matchingNumbers.size() > 0) {
            double prize = PRIZE * Math.pow(2, matchingNumbers.size());
            System.out.println("Matched Numbers: " +matchingNumbers);
            System.out.println("Your Prize is " + prize);
        }





    }

    //SET INITIALIZATIONS

    //WINNING LOTTERY NUMBERS
    public static Set <Integer> CreateWinningNumbers(){
        Set <Integer> winningNumbers = new TreeSet<>();
        Random randomNumbers = new Random();

        //CREATING WINNING NUMBERS
        while(winningNumbers.size() < NUMBERS) {
            int lottoNumber = randomNumbers.nextInt(MAX_NUMBERS) + 1;
            winningNumbers.add(lottoNumber);
        }
        return winningNumbers;
    }

    //PLAYER LOTTERY NUMBERS
    public static Set <Integer> GetPlayerNumbers() {
        Set <Integer> playerNumbers = new TreeSet<>();

        //SCANNER INITIALIZATION
        Scanner user_input = new Scanner(System.in);

        //USER INPUT
        System.out.println("Please Enter 6 Numbers from 1 to 40: ");
        while(playerNumbers.size() < NUMBERS) {
            int userNumbers = user_input.nextInt();

            if(userNumbers <= MAX_NUMBERS && userNumbers > 0){
                playerNumbers.add(userNumbers);
            }
        }

        return playerNumbers;
    };


}
