package hw_5.model.score;

import hw_5.model.account.Account;
import hw_5.model.money.Money;
import hw_5.model.money.MoneyInterface;

public abstract class Score implements MoneyInterface {
    public Money balance;
    private Account owner;
    private Integer number;

    public Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public void addMoney(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        double usdValueThis = this.balance.getValue() * this.balance.getCurrency().getUsdCource();

        if (usdValueThis < usdValueIn) {
            System.out.println("You have no so much!");
            return;
        }

        if (checkBefore()) {
            this.balance.setValue(((usdValueThis + usdValueIn) * this.balance.getCurrency().getUsdCource()));
        } else {
            System.out.println("No check!");
            return;
        }
    }


    public boolean checkBefore() {
        return true;
    }

    @Override
    public Money getMoney(double balanceLess) {
        if(balanceLess > 30000) {
            throw new IllegalArgumentException("It is not allowed to get more then 30 000 with 1 transaction");
        }
        this.balance.setValue(this.balance.getValue() - balanceLess);

        return this.balance;
    }

    @Override
    public Money getMoneyWithoutLess() {
        return this.balance;
    }
}
