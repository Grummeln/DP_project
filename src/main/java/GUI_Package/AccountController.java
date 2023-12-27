package GUI_Package;

import Account_Package.Account;
import Account_Package.AccountEUR;
import Account_Package.AccountRON;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class AccountController {

    @FXML
    private TableColumn accountTypeField;

    @FXML
    private TableColumn balanceField;

    @FXML
    private TextArea lastOperationsArea;

    @FXML
    private TableView<Account> accountTableView;
    @FXML
    private Button blockAccountButton;

    @FXML
    private Button requestNewAccountButton;

    @FXML
    private TextField idField;

    @FXML
    private TextArea clientBillingInfoArea;

    @FXML
    private TextArea bankPhoneNrArea;

    public AccountController() {
    }

    public void initialize(Account account) {
        // Set the values from the provided Account object
        ObservableList<Account> accountsData = FXCollections.observableArrayList(account);

        // Set the items for the TableView
        accountTableView.setItems(accountsData);

        // Set up the cell value factories for each column
        accountTypeField.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        balanceField.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        // Set default values for demonstration purposes
        lastOperationsArea.setText("Transaction 1\nTransaction 2\nTransaction 3");
    }
    @FXML
    private void blockAccountButtonClicked(ActionEvent event) {
        // Get the selected account from the TableView
        Account selectedAccount = accountTableView.getSelectionModel().getSelectedItem();

        if (selectedAccount != null) {
            // Perform the block account action (you can replace this with your actual logic)
            selectedAccount.block_account();
        }
        showBlockedAccountPopup(selectedAccount.getAccountNumber());
    }
    private void showBlockedAccountPopup(String accountNumber) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account Blocked");
        alert.setHeaderText(null);
        alert.setContentText("Account " + accountNumber + " has been blocked.");

        // Customize the alert dialog (optional)
        alert.initOwner(accountTableView.getScene().getWindow());
        alert.showAndWait();
    }


    @FXML
    private void requestNewAccountButtonClicked() {
        // Prompt the user to choose the account type
        Account.TYPE selectedType = showAccountTypeSelectionDialog();

        if (selectedType != null) {
            try {
                Account newAccount = createRandomAccount(selectedType);
                showNewAccountCreatedPopup(newAccount);
            } catch (Exception e) {
                // Handle exceptions (e.g., display an error message)
                e.printStackTrace();
            }
        }
    }
    private void showNewAccountCreatedPopup(Account newAccount) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account Created");
        alert.setHeaderText(null);
        alert.setContentText("New account created!\nAccount Number: " + newAccount.getAccountNumber());
        alert.showAndWait();
    }

    private Account.TYPE showAccountTypeSelectionDialog() {
        // Create a choice dialog for selecting the account type
        ChoiceDialog<Account.TYPE> dialog = new ChoiceDialog<>(Account.TYPE.EUR, Account.TYPE.EUR, Account.TYPE.RON);
        dialog.setTitle("Account Type Selection");
        dialog.setHeaderText("Select the type of account:");
        dialog.setContentText("Account Type:");

        // Show the dialog and wait for the user's choice
        Optional<Account.TYPE> result = dialog.showAndWait();

        // Return the selected account type or null if canceled
        return result.orElse(null);
    }

    private Account createRandomAccount(Account.TYPE accountType) throws Exception {
        Account newAccount;
        if (accountType == Account.TYPE.EUR) {
            String randomAccountNumber = "EUR" + (int) (Math.random() * 1000);
            newAccount = new AccountEUR(randomAccountNumber, 0.0);
        } else {
            String randomAccountNumber = "RON" + (int) (Math.random() * 1000);
            newAccount = new AccountRON(randomAccountNumber, 0.0);
        }

        // Add the new account to the TableView or perform other necessary actions
        accountTableView.getItems().add(newAccount);

        return newAccount;
    }
}
