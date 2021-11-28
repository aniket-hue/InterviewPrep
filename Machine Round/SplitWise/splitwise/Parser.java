package splitwise;

import java.util.Hashtable;

public class Parser {
    public int noOfPeopleMoneyOwe = 0;
    public int moneyGivenBy;
    public int showId = -1;
    public double totalMoney = 0;
    public Hashtable<Integer, Double> moneyOwedTo;
    public String splitType = "";

    public String operationType = "EXPENSE";

    private String EXACT = "EXACT";
    private String EQUAL = "EQUAL";
    private String PERCENT = "PERCENT";

    public void parse(String line) {
        moneyOwedTo = new Hashtable<Integer, Double>();

        String[] words = line.split(" ");
        operationType = words[0];

        if (operationType.equals("SHOW")) {
            if (words.length > 1) {
                showId = findId(words[1]);
            }
        } else {
            moneyGivenBy = findId(words[1]);
            totalMoney = Integer.parseInt(words[2]);
            noOfPeopleMoneyOwe = Integer.parseInt(words[3]);
            showId = -1;

            int idx = 3 + noOfPeopleMoneyOwe;
            splitType = words[idx + 1];

            int i = 4, j = idx + 2;
            while (i < 4 + noOfPeopleMoneyOwe) {
                int id = findId(words[i]);

                if (splitType.equals(EXACT)) {
                    double money = Double.parseDouble(words[j]);
                    moneyOwedTo.put(id, money);
                } else if (splitType.equals(EQUAL) && id != moneyGivenBy) {
                    double money = totalMoney / noOfPeopleMoneyOwe;
                    moneyOwedTo.put(id, money);
                } else if (splitType.equals(PERCENT)) {
                    double percent = Double.parseDouble(words[j]);
                    double money = totalMoney * (percent / 100);
                    moneyOwedTo.put(id, money);
                }

                j++;
                i++;
            }
        }
    }

    public int findId(String line) {
        String[] words = line.split("");
        int id = Integer.parseInt(words[1]);
        return id;
    }
}
