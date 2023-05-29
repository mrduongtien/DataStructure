package linked_list.doubly_linked_list.update.model;

import java.util.Objects;

public class BankAccount {
    private String name, address, numberCard;
    private String accountNumber;
    private String issuingBank;
    private long balance;

    public BankAccount() {
    }

    public BankAccount(String name, String address, String numberCard, String accountNumber, String issuingBank, long balance) {
        this.name = name;
        this.address = address;
        this.numberCard = numberCard;
        this.accountNumber = accountNumber;
        this.issuingBank = issuingBank;
        this.balance = balance;
    }

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberCard='" + numberCard + '\'' +
                ", accountNumber=" + accountNumber +
                ", issuingBank='" + issuingBank + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BankAccount other) {
            return this.accountNumber.equals(other.accountNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
