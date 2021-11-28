import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank(4);
        Parser parser = new Parser();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            parser.parse(line);
            if (parser.operationType.equals("SHOW")) {

                if (parser.showId != -1) {
                    int showId = parser.showId;
                    System.out.println(bank.users[showId - 1]);
                } else {
                    for (User user : bank.users) {
                        System.out.println(user);
                    }
                }
            } else {
                for (Map.Entry<Integer, Double> entry : parser.moneyOwedTo.entrySet()) {
                    int userMoneyOwedTo = entry.getKey();
                    double newMoney = entry.getValue();
                    bank.addMoneyToUser(newMoney, userMoneyOwedTo, parser.moneyGivenBy);
                }
            }
        }

    }
}
