public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Bank bank2 = new Bank();
        Client client = new Client( "Jackson");
        Client client2 = new Client( "Puta");

        client.setBank(bank);
        client.createAccount();
        client.askForCard();
        client.depositDebit(200);
        client.depositCredit(100);
        client.balanceInDebit();
        client.balanceInCredit();
        client.payInCredit(150);
        client.payInDebit(100);
        client.balanceInDebit();
        client.balanceInCredit();
        System.out.println();
        client.setBank(bank2);
        client.createAccount();
        client.askForCard();
        client.depositDebit(300);
        client.depositCredit(200);
        client.balanceInDebit();
        client.balanceInCredit();
        client.payInCredit(240);
        client.payInDebit(210);
        client.balanceInDebit();
        client.balanceInCredit();
        System.out.println();
        client.setBank(bank);
        client.balanceInDebit();
        client.balanceInCredit();







    }
}