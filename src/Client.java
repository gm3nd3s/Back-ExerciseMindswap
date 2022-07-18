import java.sql.Array;

public class Client {

    private String id;
    private String name;

    private Bank bank;
    private int numberOfclientsCreated;

    public Client(String name){
        this.name = name;
        ++numberOfclientsCreated;
        createId();
    }
    public void setBank (Bank bank) {
        this.bank = bank;
    }

    private void createId(){
        id = "" + name.charAt(0) + numberOfclientsCreated;

    }

    public void createAccount(){
        bank.createAccounts(id);
    }

    public void askForCard (){
        bank.askForCard(this.id);
    }

    public void depositCredit(double amountToDeposit) {
        bank.depositInCreditAccount(this.id, amountToDeposit);
    }
    public void depositDebit(double amountToDeposit){
        bank.depositInDebitAccount(this.id,amountToDeposit);
    }
    public void balanceInCredit(){
        bank.balanceInCreditAccount(this.id);
    }
    public void balanceInDebit(){
        bank.balanceInDebitAccount(this.id);
    }

    public void payInDebit(double amountToPay) {
        bank.payInDebitAccount(this.id, amountToPay);
    }

    public void payInCredit(double amountToPay) {

        bank.payInCreditAccount(this.id, amountToPay);
    }

    public void withdrawMoneyDebit(double amountOfMoney) {
        bank.withdrawalInDebitAccount(this.id, amountOfMoney);
    }

    public void withdrawMoneyCredit(double amountOfMoney) {
        bank.withdrawalInCreditAccount(this.id, amountOfMoney);
    }
}
