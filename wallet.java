import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Wallet {
    private double balance;
    private boolean closed = false;

    public Wallet(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (closed) {
            throw new IllegalStateException("Wallet is closed");
        }

        balance += amount;
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (closed) {
            throw new IllegalStateException("Wallet is closed");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        balance -= amount;
        System.out.println("Balance: " + balance);
    }

    public void close() {
        closed = true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = sc.nextDouble();
        Wallet wallet = new Wallet(balance);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty())
                continue;

            String[] parts = line.split(" ");

            try {
                if (parts[0].equalsIgnoreCase("deposit")) {
                    double amount = Double.parseDouble(parts[1]);
                    wallet.deposit(amount);

                } else if (parts[0].equalsIgnoreCase("withdraw")) {
                    double amount = Double.parseDouble(parts[1]);
                    wallet.withdraw(amount);

                } else if (parts[0].equalsIgnoreCase("close")) {
                    wallet.close();
                    System.out.println("Wallet closed");
                }

            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
