package hw_5.model.score;

import hw_5.model.account.Account;
import hw_5.model.money.Money;

public class DebitScore extends Score{
    private CreditScore creditScore;

    public DebitScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }
}
