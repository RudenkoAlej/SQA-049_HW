package hw_5.model.score;

import hw_5.model.account.Account;
import hw_5.model.money.Money;

public class CurrentScore extends Score {
    private DebitScore debitScore;
    private Money balance;

    public CurrentScore(Money balance, Account owner, Integer number, DebitScore debitScore) {
        super(balance, owner, number);
        this.debitScore = debitScore;
    }

    @Override
    public void addMoney(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        double usdValueThis = super.balance.getValue() * super.balance.getCurrency().getUsdCource();

        if (usdValueThis < usdValueIn) {
            System.out.println("You have no so much!");
            return;
        }

        if (usdValueIn > 1000000) {
            usdValueThis += 2000;
            return;
        }

        if (checkBefore()) {
            this.balance.setValue(((usdValueThis + usdValueIn) * this.balance.getCurrency().getUsdCource()));
        } else {
            System.out.println("No check!");
            return;
        }
    }
}
