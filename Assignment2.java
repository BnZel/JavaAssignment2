import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Assignment2 extends Application implements EventHandler<ActionEvent> {
    private  Scene home,addScene,depositScene,withdrawScene,listScene,transferScene;
    Stage window;  // represents main Stage globally
    Button btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu,btnAdd,btnListHome,btnHome;
    
    Button btnDepositBack,btnWithdrawBack,btnTransferBack,btnListBack,btnAddBack;
    TextField custName,custAccNum,custBalance;
    
    Bank bankMan;
    
    
    TextArea accountList;
    
    Button btnWithdraw;
    TextField deposAmt,withdrawAmt,custToAccNum,custTransferAmt;
        
    public void init(){
        bankMan = new Bank(10000);
    }
    
    public void start(Stage primaryStage){
        window = primaryStage;
        
        // ==============setting up Home Scene===================
        Label lblHomeMenu = new Label("Welcome to Trusty Bank. Please select an option from below");
        
        btnAddMenu = new Button("Add");
        btnAddMenu.setOnAction(this);
        btnAddMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnDepositMenu = new Button("Deposit");
        btnDepositMenu.setOnAction(this);
        btnDepositMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnWithdrawMenu = new Button("Withdraw");
        btnWithdrawMenu.setOnAction(this);
        btnWithdrawMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnTransferMenu = new Button("Transfer");
        btnTransferMenu.setOnAction(this);
        btnTransferMenu.setMaxWidth(Double.MAX_VALUE);
        
        btnListMenu = new Button("List");
        btnListMenu.setOnAction(this);
        btnListMenu.setMaxWidth(Double.MAX_VALUE);
        
        VBox homeLayout = new VBox();
        
        homeLayout.setAlignment(Pos.CENTER);    
        
        homeLayout.getChildren().addAll(lblHomeMenu,btnAddMenu,btnDepositMenu,btnWithdrawMenu,btnTransferMenu,btnListMenu);
        
        home = new Scene(homeLayout,500,500);
        
        //==========setting up Add Scene================
        Label lblAddMenu = new Label("Add Account");
        
        Label lblName =new Label("Name:");
        custName = new TextField();
        
        Label lblAccNum =new Label("Account#:");
        custAccNum=new TextField();
        
        Label lblBalance =new Label("Balance:");
        custBalance = new TextField();
        
        btnAdd = new Button("Add Account");
        btnAdd.setOnAction(this);
        
        btnAddBack = new Button("Back");
        btnAddBack.setOnAction(this);
        
        VBox addLayout =new VBox();
        
        addLayout.getChildren().addAll(lblAddMenu,lblName,custName,lblAccNum,custAccNum,lblBalance,custBalance,btnAdd,btnAddBack);
        
        addScene = new Scene(addLayout,500,500);
        
        // ===========setting up Deposit Scene==============
        Label lblAcNum = new Label("Account#:");
        custAccNum = new TextField();
        
        Label lblAmount = new Label("Desposit Amount:");
        deposAmt = new TextField();
        
        btnAdd = new Button("Deposit");
        btnAdd.setOnAction(this);
        
        btnDepositBack = new Button("Back");   
        btnDepositBack.setOnAction(this);
                       
        VBox depositLayout = new VBox();
        
        depositLayout.getChildren().addAll(lblAcNum,custAccNum,lblAmount,deposAmt,btnAdd,btnDepositBack);
        
        depositScene = new Scene(depositLayout,500,500);
                
        //===============setting up Withdraw Scene==============
        Label lblAcccNum = new Label("Account#:");
        custAccNum = new TextField();
        
        Label lblWithdrawAmt = new Label("Withdraw Amount:");
        withdrawAmt = new TextField();
        
        btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(this);
        
        btnWithdrawBack = new Button("Back");
        btnWithdrawBack.setOnAction(this);
        
        btnWithdrawBack.setMaxWidth(Double.MAX_VALUE);
        
        VBox withdrawLayout =new VBox();
        
        withdrawLayout.getChildren().addAll(lblAcccNum,custAccNum,lblWithdrawAmt,withdrawAmt,btnWithdrawBack);
        
        withdrawScene = new Scene (withdrawLayout,500,500);        
        
        //===============setting up Transfer Scene============
        Label lblFromAccNum = new Label("From Account#:");
        custAccNum = new TextField();
        
        Label lblToAccNum = new Label("To Account#:");
        custToAccNum = new TextField();
        
        Label lblTransferAmt = new Label("Transfer Amount:");
        custTransferAmt = new TextField();
                
        btnTransferBack = new Button("Back");
        btnTransferBack.setOnAction(this);
        
        btnTransferBack.setMaxWidth(Double.MAX_VALUE);
        
        VBox transferLayout =new VBox();
        
        transferLayout.getChildren().addAll(lblFromAccNum,custAccNum,lblToAccNum,custToAccNum,lblTransferAmt,custTransferAmt,btnTransferBack);
        
        transferScene = new Scene (transferLayout,500,500);
         
                
        // ===============setting up List Scene===============
        Label lblShow = new Label("List of accounts...");
        accountList = new TextArea();
        
        btnListBack = new Button("Back");
        btnListBack.setOnAction(this);
        
        btnListBack.setMaxWidth(Double.MAX_VALUE);
        
        VBox listLayout =new VBox();
        
        listLayout.getChildren().addAll(lblShow,accountList,btnListBack);
        
        listScene = new Scene (listLayout,500,500);
         
        window.setScene(home);
        window.show();
    }
    
    public void stop(){
        
    }
    
    
    public void handle(ActionEvent e){
        
        if (e.getSource()==btnAddMenu){
            System.out.println("add Menu btn pressed (on menu scene)");
            window.setScene(addScene);                              
            
           
        }
        
        //PROBLEM: addAccount function works, doesn't display on textarea
        if(e.getSource() == btnAdd){                
                
                long accNum = Long.valueOf(custAccNum.getText());
                double amt  = Double.valueOf(custBalance.getText());
                String nameStored = String.valueOf(custName.getText());
                bankMan.addAccount(accNum,amt,nameStored);
                
                
            }
        
        if(e.getSource() == btnWithdrawMenu){
            System.out.println("withdraw menu btn pressed");
            window.setScene(withdrawScene);
            if(e.getSource() == btnWithdraw){
                long accNum = Long.valueOf(custAccNum.getText());
                double amt = Double.valueOf(withdrawAmt.getText());
                bankMan.withdrawAccount(accNum, amt);
            }
        }
        
        if(e.getSource() == btnTransferMenu){
            System.out.println("transfer menu btn pressed (on menu scene)");
            window.setScene(transferScene);
        }
        
        if(e.getSource()==btnDepositMenu){
            System.out.println("deposit menu pressed");
            window.setScene(depositScene);
        }
        
        if (e.getSource()==btnListMenu){
            System.out.println("list accounts btn pressed (on menu scene)");
            accountList.setText(bankMan.printAccounts());
            window.setScene(listScene);
        }
        
        if (e.getSource()==btnHome||e.getSource()==btnListHome || e.getSource()== btnAddBack ||
                e.getSource()== btnWithdrawBack || e.getSource() == btnTransferBack 
                || e.getSource() == btnDepositBack || e.getSource() ==btnListBack){
            System.out.println("Back button pressed");
            window.setScene(home);
        }  
        
    }
    
    public static void main(String[] args) {
      launch(args);
    }
    
}
