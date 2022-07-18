import java.util.StringTokenizer;

public class Bank {
    private Account[] accounts = new Account[10];
    private int accountsCreated;


    public Bank (){


    }

    public void createAccounts(String id) {

        for (int i = 0; i < accountsCreated; i+=2) {
            if(accounts[i].getId() == id){
                System.out.println("You already have an account!");
                return;
            }
        }

        for (int i = 0; i <= accountsCreated; i++) {
            if(accounts[i] == null){
                accounts[i] = new Credit(id);
                accounts[i + 1] = new Debit(id);
                System.out.println("Your accounts were created!");
                accountsCreated+= 2;
                return;
            }
        }
    }

    public void askForCard(String id) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        for (int i = 0; i < accountsCreated-1; i++) {
            if(checkAccount(id, i)){
                if(!accounts[i].hasCards()){
                    accounts[i].askACard();
                    accounts[i+1].askACard();
                    System.out.println("Here is your card!");
                    return;
                }
                System.out.println("You already have a card!");
            }
        }
    }

    public boolean checkAccount(String id, int index){
        return accounts[index].checkAccount(id);
    }

    public boolean checkAccountType(String id, int index, String type){
        return accounts[index].checkAccount(id);
    }

    private Account findAccount(String id, String accountType){
        for (Account account : accounts) {
            if(account == null){
                continue;
            }
            if(account.getTypeOfAccount().equals(accountType) && account.getId() == id ){//checkAccountType(id, i, "credit")){
                return account;
            }
        }
        return null;
    }
    private Account hasAccount(String id){
        for (Account account : accounts) {
            if(account == null){
                continue;
            }
            if(account.getId() == id ){//checkAccountType(id, i, "credit")){
                return account;
            }
        }
        return null;
    }

    public void depositInCreditAccount(String id, double amountToDeposit) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        findAccount(id, Account.CREDIT ).deposit(amountToDeposit);
    }
    public void depositInDebitAccount(String id, double amountToDeposit) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        findAccount(id, Account.DEBIT ).deposit(amountToDeposit);
        }

    public void balanceInCreditAccount(String id) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }

        System.out.println(findAccount(id, Account.CREDIT).getBalance());

    }
    public void balanceInDebitAccount(String id) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }

        System.out.println(findAccount(id, Account.DEBIT).getBalance());
    }


    public void payInCreditAccount(String id, double amountToPay) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        if(findAccount(id, Account.CREDIT ).getBalance() - amountToPay >= 0) {
            findAccount(id, Account.CREDIT ).pay(amountToPay);
            return;
        }
        if(findAccount(id, Account.CREDIT ).getBalance() - amountToPay + 100 >= 0){
            findAccount(id, Account.CREDIT ).pay(amountToPay + 10);
            return;
        }
        System.out.println("You don't have enough money :(");

    }
    public void payInDebitAccount(String id, double amountToPay) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        if(findAccount(id, Account.DEBIT ).getBalance() - amountToPay >= 0){
            findAccount(id, Account.DEBIT ).pay(amountToPay);
            return;
        }
        System.out.println("You don't have enough money :(");

    }

    public void withdrawalInDebitAccount(String id, double amountToWithdraw) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }
        if(findAccount(id, Account.DEBIT ).getBalance() - amountToWithdraw >= 0){
            findAccount(id, Account.DEBIT ).withDraw(amountToWithdraw);

            return;
        }
        System.out.println("You don't have enough money :(");

    }

    public void withdrawalInCreditAccount(String id, double amountToWithdrawal) {
        if(hasAccount(id) == null){
            System.out.println("You don't have an account!");
            return;
        }

        System.out.println("You can't withdraw money from a Credit Account!");
        return;

    }


}
