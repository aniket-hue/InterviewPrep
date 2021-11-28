import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    public HashMap<Integer, Double> moneyOwe = new HashMap<Integer, Double>();
    public HashMap<Integer, Double> moneyToGive = new HashMap<Integer, Double>();
    static NumberFormat nf = NumberFormat.getInstance();

    User(int id) {
        this.id = id;
        nf.setMaximumFractionDigits(2);
    }

    @Override
    public String toString() {
        for (Map.Entry<Integer, Double> e : moneyOwe.entrySet()) {
            System.out.println("User" + (id) + " owes User" + (e.getKey()) + ": " + e.getValue());
        }

        for (Map.Entry<Integer, Double> e : moneyToGive.entrySet()) {
            System.out.println("User" + (e.getKey()) + " owes User" + (id) + ": " + e.getValue());
        }
        return "";
    }

    public void addMoneyToTake(double newMoney, int moneyOwedBy) {
        nf.format(newMoney);

        if (moneyOwe.containsKey(moneyOwedBy)) {
            double moneyOwed = moneyOwe.get(moneyOwedBy);
            moneyOwed += newMoney;
            moneyOwe.put(moneyOwedBy, moneyOwed);
        } else {
            moneyOwe.put(moneyOwedBy, newMoney);
        }
    }

    public void addMoneyToGive(double newMoney, int moneyOwedBy) {
        nf.format(newMoney);

        if (moneyToGive.containsKey(moneyOwedBy)) {
            double moneyOwed = moneyToGive.get(moneyOwedBy);
            moneyOwed += newMoney;
            moneyToGive.put(moneyOwedBy, moneyOwed);
        } else {
            moneyToGive.put(moneyOwedBy, newMoney);
        }
    }

}
