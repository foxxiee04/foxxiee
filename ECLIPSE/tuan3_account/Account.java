package tuan3_account;

public class Account {
    private long numOfAcc; 
    private String name; 
    private double balance; 
    private static final double RATE = 0.035;

  
    public long getNumOfAcc() {
        return numOfAcc;
    }

    public void setNumOfAcc(long numOfAcc) {
        this.numOfAcc = numOfAcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Account(long numOfAcc, String name, double balance) {
        super();
        this.numOfAcc = numOfAcc;
        this.name = name;
        this.balance = balance;
    }

    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Phương thức gửi tiền vào tài khoản
    public void deposit(double amount) throws Exception {
        double mybalance = this.getBalance();
        if (amount > 0) {
            mybalance += amount;
            this.setBalance(mybalance);
        } else {
            throw new Exception("Số tiền gửi vào không hợp lệ!");
        }
    }

    // Phương thức rút tiền từ tài khoản với phí rút tiền
    public void withdraw(double amount, double withdrawalFee) throws Exception {
        if (amount > 0) {
            if (this.getBalance() - (amount + withdrawalFee) > 50) {
                balance -= (amount + withdrawalFee);
            } else {
                throw new Exception("Số dư không đủ!");
            }
        } else {
            throw new Exception("Phương thức rút tiền không hợp lệ!");
        }
    }

    // Phương thức tính lãi suất
    public void maturity() {
        this.balance += this.balance * RATE;
    }

    // Phương thức chuyển tiền từ tài khoản này sang tài khoản khác
    public void transfer(Account destinationAccount, double amount) throws Exception {
        if (amount > 0) {
            if (this.getBalance() - (amount + 10) > 50) 
            {
                this.withdraw(amount, 10);
                destinationAccount.deposit(amount);
            } else {
                throw new Exception("Số dư không đủ.");
            }
        } else {
            throw new Exception("Phương thức chuyển tiền không hợp lệ!");
        }
    }

    // Phương thức hiển thị thông tin tài khoản dưới dạng chuỗi
    @Override
    public String toString() {
        String str = String.format("%20d %20s %15.2f", getNumOfAcc(), getName(), getBalance());
        return str;
    }
}
