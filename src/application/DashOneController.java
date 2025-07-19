package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class DashOneController implements Initializable {

    // Customer Fields
    @FXML
    private TextField customerIDField;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField ninField;
    @FXML
    private TextField phoneField;

    // Customer Table
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, Integer> customerIDColumn;
    @FXML
    private TableColumn<Customer, String> customerNameColumn;
    @FXML
    private TableColumn<Customer, String> emailColumn;
    @FXML
    private TableColumn<Customer, String> ninColumn;

    // Phone Table
    @FXML
    private TableView<CustomersPhone> phoneTable;
    @FXML
    private TableColumn<CustomersPhone, Integer> phoneCustomerIDColumn;
    @FXML
    private TableColumn<CustomersPhone, Long> phoneColumn;

    // Car Fields
    @FXML
    private TextField carIDField;
    @FXML
    private TextField carModelField;
    @FXML
    private TextField carTypeField;
    @FXML
    private TextField carColorField;
    @FXML
    private TextField carStatusField;

    // Car Table
    @FXML
    private TableView<Car> carTable;
    @FXML
    private TableColumn<Car, Integer> carIDColumn;
    @FXML
    private TableColumn<Car, String> carModelColumn;
    @FXML
    private TableColumn<Car, String> carTypeColumn;
    @FXML
    private TableColumn<Car, String> carColorColumn;
    @FXML
    private TableColumn<Car, String> carStatusColumn;

    // Service Fields
    @FXML
    private TextField serviceIDField;
    @FXML
    private TextField customarIDField;
    @FXML
    private TextField carIDField1;
    @FXML
    private TextField serviceDescriptionField;

    // Service Table
    @FXML
    private TableView<Service> serviceTable;
    @FXML
    private TableColumn<Service, Integer> serviceIDColumn;
    @FXML
    private TableColumn<Service, Integer> serviceCustomerIDColumn;
    @FXML
    private TableColumn<Service, Integer> serviceCarIDColumn;
    @FXML
    private TableColumn<Service, String> serviceDescriptionColumn;

    // Sale Fields
    @FXML
    private TextField saleIDField;
    @FXML
    private TextField saleDescriptionField;
    @FXML
    private TextField saleCustomerIDField;
    @FXML
    private TextField saleCarIDField;
    @FXML
    private TextField saleEmployeeIDField;

    // Sale Table
    @FXML
    private TableView<Sale> salesTable;
    @FXML
    private TableColumn<Sale, Integer> saleIDColumn;
    @FXML
    private TableColumn<Sale, String> saleDescriptionColumn;
    @FXML
    private TableColumn<Sale, Integer> saleCustomerIDColumn;
    @FXML
    private TableColumn<Sale, Integer> saleCarIDColumn;
    @FXML
    private TableColumn<Sale, Integer> saleEmployeeIDColumn;

    // Cash Fields
    @FXML
    private TextField cashSaleIDField;
    @FXML
    private TextField processNumberField;
    @FXML
    private TextField bankCashField;
    @FXML
    private TextField directCashField;
    @FXML
    private TextField discountsField;

    // Cash Table
    @FXML
    private TableView<Cashs> cashTable;
    @FXML
    private TableColumn<Cashs, Integer> cashSaleIDColumn;
    @FXML
    private TableColumn<Cashs, Integer> processNumberColumn;
    @FXML
    private TableColumn<Cashs, Double> bankCashColumn;
    @FXML
    private TableColumn<Cashs, Double> directCashColumn;
    @FXML
    private TableColumn<Cashs, Float> discountsColumn;

    // Installment Payments Fields
    @FXML
    private TextField installmentSaleIDField;
    @FXML
    private TextField installmentProcessNumberField;
    @FXML
    private TextField totalCostField;
    @FXML
    private TextField firstPaymentField;
    @FXML
    private TextField monthlyInstallmentField;
    @FXML
    private TextField numberOfMonthsField;

    // Installment Payments Table
    @FXML
    private TableView<InstallmentPayments> installmentPaymentsTable;
    @FXML
    private TableColumn<InstallmentPayments, Integer> installmentSaleIDColumn;
    @FXML
    private TableColumn<InstallmentPayments, Integer> installmentProcessNumberColumn;
    @FXML
    private TableColumn<InstallmentPayments, Double> totalCostColumn;
    @FXML
    private TableColumn<InstallmentPayments, Double> firstPaymentColumn;
    @FXML
    private TableColumn<InstallmentPayments, Double> monthlyInstallmentColumn;
    @FXML
    private TableColumn<InstallmentPayments, Integer> numberOfMonthsColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCustomers();
        showCustomerPhones();
        showAvailableCars();
        showServices();
        showSales();
        showCashs();
        showInstallmentPayments();
    }

    // Methods for Customer
    public ObservableList<Customer> getCustomers() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        Connection conn = DBConnection.getConnection();
        String query = "SELECT * FROM Customers";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customarID"), rs.getString("customarName"),
                        rs.getString("email"), rs.getString("NIN"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void showCustomers() {
        ObservableList<Customer> list = getCustomers();
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        ninColumn.setCellValueFactory(new PropertyValueFactory<>("NIN"));
        customerTable.setItems(list);
    }

    @FXML
    public void handleCustomerRowSelection(MouseEvent event) {
        int index = customerTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerIDField.setText(String.valueOf(selectedCustomer.getCustomerID()));
            customerNameField.setText(selectedCustomer.getCustomerName());
            emailField.setText(selectedCustomer.getEmail());
            ninField.setText(selectedCustomer.getNIN());
            showCustomerPhonesForCustomer(selectedCustomer.getCustomerID());
        }
    }

    @FXML
    public void addCustomer() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            String customerName = customerNameField.getText().trim();
            String email = emailField.getText().trim();
            String nin = ninField.getText().trim();

            if (customerIDExists(customerID)) {
                displayAlert("Customer ID already exists.");
                return;
            }

            if (emailExists(email)) {
                displayAlert("Email already exists.");
                return;
            }

            if (ninExists(nin)) {
                displayAlert("NIN already exists.");
                return;
            }

            String query = "INSERT INTO Customers (customarID, customarName, email, NIN) VALUES (?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, customerID);
                ps.setString(2, customerName);
                ps.setString(3, email);
                ps.setString(4, nin);
                ps.executeUpdate();
                displayAlert("Customer record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting customer record.");
            }
            showCustomers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean customerIDExists(int customarID) {
        String query = "SELECT COUNT(*) FROM Customers WHERE customarID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, customarID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean emailExists(String email) {
        String query = "SELECT COUNT(*) FROM Customers WHERE email = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean ninExists(String nin) {
        String query = "SELECT COUNT(*) FROM Customers WHERE NIN = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nin);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean emailExistsForAnotherCustomer(int customarID, String email) {
        String query = "SELECT COUNT(*) FROM Customers WHERE email = ? AND customarID <> ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setInt(2, customarID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Methods for Phone
    public ObservableList<CustomersPhone> getCustomerPhones(String query) {
        ObservableList<CustomersPhone> phoneList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomersPhone phone = new CustomersPhone(rs.getInt("customarID"), rs.getLong("phone"));
                phoneList.add(phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneList;
    }

    public void showCustomerPhones() {
        String query = "SELECT * FROM CustomersPhone";
        ObservableList<CustomersPhone> phoneList = getCustomerPhones(query);
        phoneCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneTable.setItems(phoneList);
    }

    public void showCustomerPhonesForCustomer(int customerID) {
        String query = "SELECT * FROM CustomersPhone WHERE customarID = " + customerID;
        ObservableList<CustomersPhone> phoneList = getCustomerPhones(query);
        phoneTable.setItems(phoneList);
    }

    @FXML
    public void handlePhoneRowSelection(MouseEvent event) {
        int index = phoneTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        CustomersPhone selectedPhone = phoneTable.getSelectionModel().getSelectedItem();
        if (selectedPhone != null) {
            customerIDField.setText(String.valueOf(selectedPhone.getCustomerID()));
            phoneField.setText(String.valueOf(selectedPhone.getPhone()));
        }
    }

    @FXML
    public void addPhone() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            long phone = Long.parseLong(phoneField.getText().trim());

            String query = "INSERT INTO CustomersPhone (customarID, phone) VALUES (?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, customerID);
                ps.setLong(2, phone);
                ps.executeUpdate();
                displayAlert("Phone record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting phone record: " + e.getMessage());
            }
            showCustomerPhonesForCustomer(customerID);
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    // Methods for Car
    public ObservableList<Car> getAvailableCars(String query) {
        ObservableList<Car> carList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(rs.getInt("carID"), rs.getString("carType"), rs.getString("carModel"),
                        rs.getString("carColor"), rs.getString("carStatus"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public void showAvailableCars() {
        String query = "SELECT * FROM Cars WHERE carStatus = 'Available'";
        ObservableList<Car> carList = getAvailableCars(query);
        carIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        carTypeColumn.setCellValueFactory(new PropertyValueFactory<>("carType"));
        carModelColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        carColorColumn.setCellValueFactory(new PropertyValueFactory<>("carColor"));
        carStatusColumn.setCellValueFactory(new PropertyValueFactory<>("carStatus"));
        carTable.setItems(carList);
    }

    @FXML
    public void handleCarRowSelection(MouseEvent event) {
        int index = carTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        Car selectedCar = carTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            carIDField.setText(String.valueOf(selectedCar.getCarID()));
            carModelField.setText(selectedCar.getCarModel());
            carTypeField.setText(selectedCar.getCarType());
            carColorField.setText(selectedCar.getCarColor());
            carStatusField.setText(selectedCar.getCarStatus());
        }
    }

    private boolean carIDExist(int carID) {
        String query = "SELECT COUNT(*) FROM Cars WHERE carID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, carID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Methods for Service
    public ObservableList<Service> getServices(String query) {
        ObservableList<Service> serviceList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Service service = new Service(rs.getInt("serviceID"), rs.getInt("customarID"), rs.getInt("carID"),
                        rs.getString("ServiceDescription"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public void showServices() {
        String query = "SELECT * FROM Services";
        ObservableList<Service> serviceList = getServices(query);
        serviceIDColumn.setCellValueFactory(new PropertyValueFactory<>("serviceID"));
        serviceCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customarID"));
        serviceCarIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        serviceDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("serviceDescription"));
        serviceTable.setItems(serviceList);
    }

    @FXML
    public void handleServiceRowSelection(MouseEvent event) {
        int index = serviceTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        Service selectedService = serviceTable.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            serviceIDField.setText(String.valueOf(selectedService.getServiceID()));
            customarIDField.setText(String.valueOf(selectedService.getCustomarID()));
            carIDField1.setText(String.valueOf(selectedService.getCarID()));
            serviceDescriptionField.setText(selectedService.getServiceDescription());
        }
    }

    @FXML
    public void addService() {
        try {
            int serviceID = Integer.parseInt(serviceIDField.getText().trim());
            int customarID = Integer.parseInt(customarIDField.getText().trim());
            int carID = Integer.parseInt(carIDField1.getText().trim());
            String serviceDescription = serviceDescriptionField.getText().trim();

            if (!recordExists("SELECT * FROM Customers WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID does not exist.");
                return;
            }

            if (!recordExists("SELECT * FROM Cars WHERE carID = ?", carID)) {
                displayAlert("Car ID does not exist.");
                return;
            }

            String query = "INSERT INTO Services (serviceID, customarID, carID, ServiceDescription) VALUES (?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, serviceID);
                ps.setInt(2, customarID);
                ps.setInt(3, carID);
                ps.setString(4, serviceDescription);
                ps.executeUpdate();
                displayAlert("Service record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting service record: " + e.getMessage());
            }
            showServices();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean recordExists(String query, int id) {
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Methods for Sale
    public ObservableList<Sale> getSales(String query) {
        ObservableList<Sale> salesList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sale sale = new Sale(rs.getInt("saleID"), rs.getString("saleDescription"), rs.getInt("customarID"),
                        rs.getInt("carID"), rs.getInt("employeeID"));
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    public void showSales() {
        String query = "SELECT * FROM Sales";
        ObservableList<Sale> salesList = getSales(query);
        saleIDColumn.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        saleDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("saleDescription"));
        saleCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customarID"));
        saleCarIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        saleEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        salesTable.setItems(salesList);
    }

    @FXML
    public void handleSaleRowSelection(MouseEvent event) {
        int index = salesTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        Sale selectedSale = salesTable.getSelectionModel().getSelectedItem();
        if (selectedSale != null) {
            saleIDField.setText(String.valueOf(selectedSale.getSaleID()));
            saleDescriptionField.setText(selectedSale.getSaleDescription());
            saleCustomerIDField.setText(String.valueOf(selectedSale.getCustomarID()));
            saleCarIDField.setText(String.valueOf(selectedSale.getCarID()));
            saleEmployeeIDField.setText(String.valueOf(selectedSale.getEmployeeID()));
        }
    }

    @FXML
    public void addSale() {
        try {
            int saleID = Integer.parseInt(saleIDField.getText().trim());
            String saleDescription = saleDescriptionField.getText().trim();
            int customarID = Integer.parseInt(saleCustomerIDField.getText().trim());
            int carID = Integer.parseInt(saleCarIDField.getText().trim());
            int employeeID = Integer.parseInt(saleEmployeeIDField.getText().trim());

            String query = "INSERT INTO Sales (saleID, saleDescription, customarID, carID, employeeID) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, saleID);
                ps.setString(2, saleDescription);
                ps.setInt(3, customarID);
                ps.setInt(4, carID);
                ps.setInt(5, employeeID);
                ps.executeUpdate();
                displayAlert("Sale record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting sale record: " + e.getMessage());
            }
            showSales();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    // Methods for Cashs
    public ObservableList<Cashs> getCashsList(String query) {
        ObservableList<Cashs> cashsList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cashs cashs = new Cashs(rs.getInt("saleID"), rs.getInt("processNumber"), rs.getDouble("bankCash"),
                        rs.getDouble("directCash"), rs.getFloat("discounts"));
                cashsList.add(cashs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashsList;
    }

    public void showCashs() {
        String query = "SELECT * FROM Cashs";
        ObservableList<Cashs> cashsList = getCashsList(query);
        cashSaleIDColumn.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        processNumberColumn.setCellValueFactory(new PropertyValueFactory<>("processNumber"));
        bankCashColumn.setCellValueFactory(new PropertyValueFactory<>("bankCash"));
        directCashColumn.setCellValueFactory(new PropertyValueFactory<>("directCash"));
        discountsColumn.setCellValueFactory(new PropertyValueFactory<>("discounts"));
        cashTable.setItems(cashsList);
    }

    @FXML
    public void handleCashRowSelection(MouseEvent event) {
        int index = cashTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        Cashs selectedCash = cashTable.getSelectionModel().getSelectedItem();
        if (selectedCash != null) {
            cashSaleIDField.setText(String.valueOf(selectedCash.getSaleID()));
            processNumberField.setText(String.valueOf(selectedCash.getProcessNumber()));
            bankCashField.setText(String.valueOf(selectedCash.getBankCash()));
            directCashField.setText(String.valueOf(selectedCash.getDirectCash()));
            discountsField.setText(String.valueOf(selectedCash.getDiscounts()));
        }
    }

    @FXML
    public void addCash() {
        try {
            int saleID = Integer.parseInt(cashSaleIDField.getText().trim());
            int processNumber = Integer.parseInt(processNumberField.getText().trim());
            double bankCash = Double.parseDouble(bankCashField.getText().trim());
            double directCash = Double.parseDouble(directCashField.getText().trim());
            float discounts = Float.parseFloat(discountsField.getText().trim());

            if (!saleIDExists(saleID)) {
                displayAlert("Sale ID does not exist in Sales table.");
                return;
            }
            if (cashIDExists(saleID, processNumber)) {
                displayAlert("Sale ID and Process Number combination already exists.");
                return;
            }

            String query = "INSERT INTO Cashs (saleID, processNumber, bankCash, directCash, discounts) VALUES (?, ?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, saleID);
                ps.setInt(2, processNumber);
                ps.setDouble(3, bankCash);
                ps.setDouble(4, directCash);
                ps.setFloat(5, discounts);
                ps.executeUpdate();
                displayAlert("Record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting record.");
            }
            showCashs();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean saleIDExists(int saleID) {
        String query = "SELECT COUNT(*) FROM Sales WHERE saleID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, saleID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean cashIDExists(int saleID, int processNumber) {
        String query = "SELECT COUNT(*) FROM Cashs WHERE saleID = ? AND processNumber = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, saleID);
            ps.setInt(2, processNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Methods for Installment Payments
    public ObservableList<InstallmentPayments> getInstallmentPaymentsList(String query) {
        ObservableList<InstallmentPayments> installmentPaymentsList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InstallmentPayments installmentPayments = new InstallmentPayments(rs.getInt("saleID"),
                        rs.getInt("processNumber"), rs.getDouble("totalCost"), rs.getDouble("firstPayment"),
                        rs.getDouble("monthlyInstallment"), rs.getInt("NumberOfMonths"));
                installmentPaymentsList.add(installmentPayments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return installmentPaymentsList;
    }

    public void showInstallmentPayments() {
        String query = "SELECT * FROM InstallmentPayments";
        ObservableList<InstallmentPayments> installmentPaymentsList = getInstallmentPaymentsList(query);
        installmentSaleIDColumn.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        installmentProcessNumberColumn.setCellValueFactory(new PropertyValueFactory<>("processNumber"));
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        firstPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("firstPayment"));
        monthlyInstallmentColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyInstallment"));
        numberOfMonthsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfMonths"));
        installmentPaymentsTable.setItems(installmentPaymentsList);
    }

    @FXML
    public void handleInstallmentPaymentRowSelection(MouseEvent event) {
        int index = installmentPaymentsTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        InstallmentPayments selectedPayment = installmentPaymentsTable.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            installmentSaleIDField.setText(String.valueOf(selectedPayment.getSaleID()));
            installmentProcessNumberField.setText(String.valueOf(selectedPayment.getProcessNumber()));
            totalCostField.setText(String.valueOf(selectedPayment.getTotalCost()));
            firstPaymentField.setText(String.valueOf(selectedPayment.getFirstPayment()));
            monthlyInstallmentField.setText(String.valueOf(selectedPayment.getMonthlyInstallment()));
            numberOfMonthsField.setText(String.valueOf(selectedPayment.getNumberOfMonths()));
        }
    }

    @FXML
    public void addInstallmentPayment() {
        try {
            int saleID = Integer.parseInt(installmentSaleIDField.getText().trim());
            int processNumber = Integer.parseInt(installmentProcessNumberField.getText().trim());
            double totalCost = Double.parseDouble(totalCostField.getText().trim());
            double firstPayment = Double.parseDouble(firstPaymentField.getText().trim());
            double monthlyInstallment = Double.parseDouble(monthlyInstallmentField.getText().trim());
            int numberOfMonths = Integer.parseInt(numberOfMonthsField.getText().trim());

            if (!saleIDExists(saleID)) {
                displayAlert("Sale ID does not exist in Sales table.");
                return;
            }
            if (installmentIDExists(saleID, processNumber)) {
                displayAlert("Sale ID and Process Number combination already exists.");
                return;
            }

            String query = "INSERT INTO InstallmentPayments (saleID, processNumber, totalCost, firstPayment, monthlyInstallment, NumberOfMonths) VALUES (?, ?, ?, ?, ?, ?)";
            try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setInt(1, saleID);
                ps.setInt(2, processNumber);
                ps.setDouble(3, totalCost);
                ps.setDouble(4, firstPayment);
                ps.setDouble(5, monthlyInstallment);
                ps.setInt(6, numberOfMonths);
                ps.executeUpdate();
                displayAlert("Record inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                displayAlert("Error inserting record.");
            }
            showInstallmentPayments();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean installmentIDExists(int saleID, int processNumber) {
        String query = "SELECT COUNT(*) FROM InstallmentPayments WHERE saleID = ? AND processNumber = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, saleID);
            ps.setInt(2, processNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @FXML
    public void searchForNIN() {
        String nin = ninField.getText().trim();
        if (nin.isEmpty()) {
            displayAlert("Please enter a NIN.");
            return;
        }

        String query = "SELECT COUNT(*) FROM Customers WHERE NIN = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nin);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    displayAlert("This customer exists.");
                } else {
                    displayAlert("This customer does not exist.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            displayAlert("Error searching for customer.");
        }
    }

    private void displayAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}