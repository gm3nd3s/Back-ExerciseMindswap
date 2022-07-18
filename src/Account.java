public abstract class Account {

    public final static String DEBIT = "debit";
    public final static String CREDIT = "credit";
    private String id;
    private String typeOfAccount;
    private double balance;
    private boolean hasCards;
    Account (String id , String typeOfAccount){
        this.id = id;
        this.typeOfAccount =typeOfAccount;
    }


    public String getId() {
        return id;
    }

    public boolean hasCards() {
        return hasCards;
    }

    public void askACard() {
        hasCards = true;
    }
    public boolean checkAccount(String id){
        if(this.id == id){
            return true;
        }
        return false;
    }

    public String getTypeOfAccount() {
        return typeOfAccount;
    }

    public double getBalance() {

        return balance;
    }
    public void deposit(double amountToDeposit){
        balance += amountToDeposit;
        System.out.println("You deposit " + amountToDeposit + " in your " + typeOfAccount + " account!");
    }

    public void pay(double amountToPay){
        balance -= amountToPay;
        System.out.println("You payed " + amountToPay + " from your " + typeOfAccount + " account!");
    }

    public void withDraw(double amountToWithdraw){
        balance -= amountToWithdraw;
        System.out.println("You've withdraw " + amountToWithdraw + " from your Debit Account");
    }
}
