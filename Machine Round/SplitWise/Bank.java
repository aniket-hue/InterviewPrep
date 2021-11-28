import java.text.NumberFormat;

public class Bank {
    public User[] users;

    Bank(int noOfUsers) {
        this.users = new User[noOfUsers];
        for (int i = 0; i < users.length; i++) {
            this.users[i] = new User(i + 1);
        }
    }

    public void addMoneyToUser(double newMoney, int moneyOwedTo, int moneyOwedBy) {
        users[moneyOwedTo - 1].addMoneyToTake(newMoney, moneyOwedBy);
        users[moneyOwedBy - 1].addMoneyToGive(newMoney, moneyOwedTo);
    }
}
