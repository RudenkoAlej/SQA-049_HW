package hw_5.model.score;

import hw_5.model.account.Account;
import hw_5.model.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }



    @Override
    public Money getMoney(double balanceLess) {
        if (super.balance.getValue() < -20000){
            throw new NullPointerException("You cannot use Credit score as balance is less then -20 000");
        }
        if(balanceLess > 30000) {
            throw new IllegalArgumentException("Wrong balance less!");
        }
        super.balance.setValue(super.balance.getValue() - balanceLess);

        return super.balance;
    }

    @Override
    public Money getMoneyWithoutLess() {
        return super.getMoneyWithoutLess();

    }
}
