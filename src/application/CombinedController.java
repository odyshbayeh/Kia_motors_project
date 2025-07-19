package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class CombinedController implements Initializable {

    // Dashboard fields
    @FXML
    private Label carCountLabel, customerCountLabel, employeeCountLabel;
    @FXML
    private Label saleCountLabel, cashCountLabel, installmentCountLabel;
    
    @FXML
    private TableView<Customer> customerTable1;
    @FXML
    private TableColumn<Customer, Integer> customerIDColumn1;
    @FXML
    private TableColumn<Customer, String> customerNameColumn1, emailColumn1, ninColumn1;
    
    @FXML
    private TableView<Car> carTable1;
    @FXML
    private TableColumn<Car, Integer> carIDColumn1;
    @FXML
    private TableColumn<Car, String> carModelColumn1, carTypeColumn1, carColorColumn1, carStatusColumn1;
    
    @FXML
    private TableView<Employee> employeeTable1;
    @FXML
    private TableColumn<Employee, Integer> employeeIDColumn1;
    @FXML
    private TableColumn<Employee, String> employeeNameColumn1;
    @FXML
    private TableColumn<Employee, Double> salaryColumn1;
    @FXML
    private TableColumn<Employee, LocalDate> dateOfEmploymentColumn1;
    
    @FXML
    private TableView<Sale> salesTable1;
    @FXML
    private TableColumn<Sale, Integer> saleIDColumn1;
    @FXML
    private TableColumn<Sale, String> saleDescriptionColumn1;
    @FXML
    private TableColumn<Sale, Integer> saleCustomerIDColumn1, saleCarIDColumn1, saleEmployeeIDColumn1;

    
    
    ////////////////////////////////////////////////////////////////////////////////////////
    // Customer Fields
    @FXML
    private TextField customerIDField, customerNameField, emailField, ninField, phoneField;

    // Customer Table
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, Integer> customerIDColumn;
    @FXML
    private TableColumn<Customer, String> customerNameColumn, emailColumn, ninColumn;

    // Phone Table
    @FXML
    private TableView<CustomersPhone> phoneTable;
    @FXML
    private TableColumn<CustomersPhone, Integer> phoneCustomerIDColumn;
    @FXML
    private TableColumn<CustomersPhone, Long> phoneColumn;

    // Car Fields
    @FXML
    private TextField carIDField, carModelField, carTypeField, carColorField, carStatusField;

    // Car Table
    @FXML
    private TableView<Car> carTable;
    @FXML
    private TableColumn<Car, Integer> carIDColumn;
    @FXML
    private TableColumn<Car, String> carModelColumn, carTypeColumn, carColorColumn, carStatusColumn;

    // Service Fields
    @FXML
    private TextField serviceIDField, customarIDField, carIDField1, serviceDescriptionField;

    // Service Table
    @FXML
    private TableView<Service> serviceTable;
    @FXML
    private TableColumn<Service, Integer> serviceIDColumn, serviceCustomerIDColumn, serviceCarIDColumn;
    @FXML
    private TableColumn<Service, String> serviceDescriptionColumn;

    // Employee Fields
    @FXML
    private TextField employeeIDField, employeeNameField, salaryField;
    @FXML
    private DatePicker dateOfEmploymentPicker;

    // Employee Table
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> employeeIDColumn;
    @FXML
    private TableColumn<Employee, String> employeeNameColumn;
    @FXML
    private TableColumn<Employee, Double> salaryColumn;
    @FXML
    private TableColumn<Employee, LocalDate> dateOfEmploymentColumn;

    // Advertiser Fields
    @FXML
    private TextField advertiserEmployeeIDField, pointsField;

    // Advertiser Table
    @FXML
    private TableView<Advertisers> advertiserTable;
    @FXML
    private TableColumn<Advertisers, Integer> advertiserEmployeeIDColumn, pointsColumn;

    // Manager Fields
    @FXML
    private TextField managerEmployeeIDField, monthlyReportField;

    // Manager Table
    @FXML
    private TableView<Managers> managerTable;
    @FXML
    private TableColumn<Managers, Integer> managerEmployeeIDColumn;
    @FXML
    private TableColumn<Managers, String> monthlyReportColumn;

    // Salesman Fields
    @FXML
    private TextField salesmanEmployeeIDField, employeeTargetField;

    // Salesman Table
    @FXML
    private TableView<Salesmans> salesmanTable;
    @FXML
    private TableColumn<Salesmans, Integer> salesmanEmployeeIDColumn, employeeTargetColumn;

    // Sale Fields
    @FXML
    private TextField saleIDField, saleDescriptionField, saleCustomerIDField, saleCarIDField, saleEmployeeIDField;

    // Sale Table
    @FXML
    private TableView<Sale> salesTable;
    @FXML
    private TableColumn<Sale, Integer> saleIDColumn;
    @FXML
    private TableColumn<Sale, String> saleDescriptionColumn;
    @FXML
    private TableColumn<Sale, Integer> saleCustomerIDColumn, saleCarIDColumn, saleEmployeeIDColumn;

    // Cash Fields
    @FXML
    private TextField cashSaleIDField, cashProcessNumberField, cashBankCashField, cashDirectCashField,
            cashDiscountsField;

    // Cash Table
    @FXML
    private TableView<Cashs> cashTable;
    @FXML
    private TableColumn<Cashs, Integer> cashSaleIDColumn, cashProcessNumberColumn;
    @FXML
    private TableColumn<Cashs, Double> cashBankCashColumn, cashDirectCashColumn;
    @FXML
    private TableColumn<Cashs, Float> cashDiscountsColumn;

    // InstallmentPayments Fields
    @FXML
    private Button btn_deleteInstallment;

    @FXML
    private Button btn_insertInstallment;

    @FXML
    private Button btn_updateInstallment;

    @FXML
    private TableColumn<InstallmentPayments, Integer> tv_saleID;

    @FXML
    private TableColumn<InstallmentPayments, Integer> tv_processNumber;

    @FXML
    private TableColumn<InstallmentPayments, Double> tv_totalCost;

    @FXML
    private TableColumn<InstallmentPayments, Double> tv_firstPayment;

    @FXML
    private TableColumn<InstallmentPayments, Double> tv_monthlyInstallment;

    @FXML
    private TableColumn<InstallmentPayments, Integer> tv_numberOfMonths;

    @FXML
    private TableView<InstallmentPayments> tv_installmentPayments;

    @FXML
    private TextField txt_saleID;

    @FXML
    private TextField txt_processNumber;

    @FXML
    private TextField txt_totalCost;

    @FXML
    private TextField txt_firstPayment;

    @FXML
    private TextField txt_monthlyInstallment;

    @FXML
    private TextField txt_numberOfMonths;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTables();
        loadAllData();
        updateStatistics();
    }

    private void initializeTables() {
        initializeCustomerTable();
        initializeCustomerTable1();
        initializePhoneTable();
        initializeCarTable();
        initializeCarTable1();
        initializeServiceTable();
        initializeEmployeeTable();
        initializeEmployeeTable1();
        initializeAdvertiserTable();
        initializeManagerTable();
        initializeSalesmanTable();
        initializeSaleTable();
        initializeSaleTable1();
        initializeCashTable();
        initializeInstallmentPaymentsTable();
    }

    private void loadAllData() {
        showCustomers();
        showCustomers1();
        showCustomerPhones();
        showCars();
        showCars1();
        showServices();
        showEmployees();
        showEmployees1();
        showAdvertisers();
        showManagers();
        showSalesmans();
        showSales();
        showSales1();
        showCashs();
        showInstallmentPayments();
    }

    private void updateStatistics() {
        carCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM Cars")));
        customerCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM Customers")));
        employeeCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM Employees")));
        saleCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM Sales")));
        cashCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM Cashs")));
        installmentCountLabel.setText(String.valueOf(getRecordCount("SELECT COUNT(*) FROM InstallmentPayments")));
    }

    private int getRecordCount(String query) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void initializeCustomerTable() {
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        ninColumn.setCellValueFactory(new PropertyValueFactory<>("NIN"));
    }
    
    private void initializeCustomerTable1() {
        customerIDColumn1.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerNameColumn1.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        emailColumn1.setCellValueFactory(new PropertyValueFactory<>("email"));
        ninColumn1.setCellValueFactory(new PropertyValueFactory<>("NIN"));
    }

    private void initializePhoneTable() {
        phoneCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
    }

    private void initializeCarTable() {
        carIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        carTypeColumn.setCellValueFactory(new PropertyValueFactory<>("carType"));
        carModelColumn.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        carColorColumn.setCellValueFactory(new PropertyValueFactory<>("carColor"));
        carStatusColumn.setCellValueFactory(new PropertyValueFactory<>("carStatus"));
    }
    
    private void initializeCarTable1() {
        carIDColumn1.setCellValueFactory(new PropertyValueFactory<>("carID"));
        carTypeColumn1.setCellValueFactory(new PropertyValueFactory<>("carType"));
        carModelColumn1.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        carColorColumn1.setCellValueFactory(new PropertyValueFactory<>("carColor"));
        carStatusColumn1.setCellValueFactory(new PropertyValueFactory<>("carStatus"));
    }

    private void initializeServiceTable() {
        serviceIDColumn.setCellValueFactory(new PropertyValueFactory<>("serviceID"));
        serviceCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customarID"));
        serviceCarIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        serviceDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("serviceDescription"));
    }

    private void initializeEmployeeTable() {
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dateOfEmploymentColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfEmployment"));
    }
    
    private void initializeEmployeeTable1() {
        employeeIDColumn1.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeNameColumn1.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        salaryColumn1.setCellValueFactory(new PropertyValueFactory<>("salary"));
        dateOfEmploymentColumn1.setCellValueFactory(new PropertyValueFactory<>("dateOfEmployment"));
    }

    private void initializeAdvertiserTable() {
        advertiserEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
    }

    private void initializeManagerTable() {
        managerEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        monthlyReportColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyReport"));
    }

    private void initializeSalesmanTable() {
        salesmanEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeTargetColumn.setCellValueFactory(new PropertyValueFactory<>("employeeTarget"));
    }

    private void initializeSaleTable() {
        saleIDColumn.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        saleDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("saleDescription"));
        saleCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customarID"));
        saleCarIDColumn.setCellValueFactory(new PropertyValueFactory<>("carID"));
        saleEmployeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
    }
    
    private void initializeSaleTable1() {
        saleIDColumn1.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        saleDescriptionColumn1.setCellValueFactory(new PropertyValueFactory<>("saleDescription"));
        saleCustomerIDColumn1.setCellValueFactory(new PropertyValueFactory<>("customarID"));
        saleCarIDColumn1.setCellValueFactory(new PropertyValueFactory<>("carID"));
        saleEmployeeIDColumn1.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
    }

    private void initializeCashTable() {
        cashSaleIDColumn.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        cashProcessNumberColumn.setCellValueFactory(new PropertyValueFactory<>("processNumber"));
        cashBankCashColumn.setCellValueFactory(new PropertyValueFactory<>("bankCash"));
        cashDirectCashColumn.setCellValueFactory(new PropertyValueFactory<>("directCash"));
        cashDiscountsColumn.setCellValueFactory(new PropertyValueFactory<>("discounts"));
    }

    private void initializeInstallmentPaymentsTable() {
        tv_saleID.setCellValueFactory(new PropertyValueFactory<>("saleID"));
        tv_processNumber.setCellValueFactory(new PropertyValueFactory<>("processNumber"));
        tv_totalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        tv_firstPayment.setCellValueFactory(new PropertyValueFactory<>("firstPayment"));
        tv_monthlyInstallment.setCellValueFactory(new PropertyValueFactory<>("monthlyInstallment"));
        tv_numberOfMonths.setCellValueFactory(new PropertyValueFactory<>("numberOfMonths"));
    }

    public ObservableList<Customer> getCustomers() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Customers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("customarID"), rs.getString("customarName"),
                        rs.getString("email"), rs.getString("NIN"));
                customerList.add(customer);
            }
            System.out.println("Customers loaded: " + customerList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public void showCustomers() {
        customerTable.setItems(getCustomers());
    }
    
    public void showCustomers1() {
        customerTable1.setItems(getCustomers());
    }

    @FXML
    public void handleCustomerRowSelection(MouseEvent event) {
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
            executeUpdate(query, customerID, customerName, email, nin);
            displayAlert("Customer record inserted successfully.");
            showCustomers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void updateCustomer() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            String customerName = customerNameField.getText().trim();
            String email = emailField.getText().trim();
            String nin = ninField.getText().trim();

            if (emailExistsForAnotherCustomer(customerID, email)) {
                displayAlert("Email already exists for another customer.");
                return;
            }

            String query = "UPDATE Customers SET customarName = ?, email = ?, NIN = ? WHERE customarID = ?";
            executeUpdate(query, customerName, email, nin, customerID);
            displayAlert("Customer record updated successfully.");
            showCustomers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deleteCustomer() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            String query = "DELETE FROM Customers WHERE customarID = ?";
            executeUpdate(query, customerID);
            displayAlert("Customer record deleted successfully.");
            showCustomers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean customerIDExists(int customarID) {
        return recordExists("SELECT COUNT(*) FROM Customers WHERE customarID = ?", customarID);
    }

    private boolean emailExists(String email) {
        return recordExists("SELECT COUNT(*) FROM Customers WHERE email = ?", email);
    }

    private boolean ninExists(String nin) {
        return recordExists("SELECT COUNT(*) FROM Customers WHERE NIN = ?", nin);
    }

    private boolean emailExistsForAnotherCustomer(int customarID, String email) {
        String query = "SELECT COUNT(*) FROM Customers WHERE email = ? AND customarID <> ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setInt(2, customarID);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList<CustomersPhone> getCustomerPhones(String query) {
        ObservableList<CustomersPhone> phoneList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomersPhone phone = new CustomersPhone(rs.getInt("customarID"), rs.getLong("phone"));
                phoneList.add(phone);
            }
            System.out.println("Customer phones loaded: " + phoneList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneList;
    }

    public void showCustomerPhones() {
        String query = "SELECT * FROM CustomersPhone";
        phoneTable.setItems(getCustomerPhones(query));
    }

    public void showCustomerPhonesForCustomer(int customerID) {
        String query = "SELECT * FROM CustomersPhone WHERE customarID = " + customerID;
        phoneTable.setItems(getCustomerPhones(query));
    }

    @FXML
    public void addPhone() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            long phone = Long.parseLong(phoneField.getText().trim());

            if (recordExists("SELECT * FROM CustomersPhone WHERE phone = ?", phone)) {
                displayAlert("Phone number already exists.");
                return;
            }

            String query = "INSERT INTO CustomersPhone (customarID, phone) VALUES (?, ?)";
            executeUpdate(query, customerID, phone);
            displayAlert("Phone record inserted successfully.");
            showCustomerPhonesForCustomer(customerID);
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void updatePhone() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            long phone = Long.parseLong(phoneField.getText().trim());

            if (recordExists("SELECT * FROM CustomersPhone WHERE phone = ? AND customarID != ?", phone, customerID)) {
                displayAlert("Phone number already exists.");
                return;
            }

            String query = "UPDATE CustomersPhone SET phone = ? WHERE customarID = ?";
            executeUpdate(query, phone, customerID);
            displayAlert("Phone record updated successfully.");
            showCustomerPhonesForCustomer(customerID);
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deletePhone() {
        try {
            int customerID = Integer.parseInt(customerIDField.getText().trim());
            long phone = Long.parseLong(phoneField.getText().trim());
            String query = "DELETE FROM CustomersPhone WHERE customarID = ? AND phone = ?";
            executeUpdate(query, customerID, phone);
            displayAlert("Phone record deleted successfully.");
            showCustomerPhonesForCustomer(customerID);
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    public ObservableList<Car> getCars(String query) {
        ObservableList<Car> carList = FXCollections.observableArrayList();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Car car = new Car(rs.getInt("carID"), rs.getString("carType"), rs.getString("carModel"),
                        rs.getString("carColor"), rs.getString("carStatus"));
                carList.add(car);
            }
            System.out.println("Cars loaded: " + carList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public void showCars() {
        String query = "SELECT * FROM MG_PALESTINE_BRANCH.cars";
        carTable.setItems(getCars(query));
    }
    
    public void showCars1() {
        String query = "SELECT * FROM MG_PALESTINE_BRANCH.cars";
        carTable1.setItems(getCars(query));
    }

    @FXML
    public void handleCarRowSelection(MouseEvent event) {
        Car selectedCar = carTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            carIDField.setText(String.valueOf(selectedCar.getCarID()));
            carModelField.setText(selectedCar.getCarModel());
            carTypeField.setText(selectedCar.getCarType());
            carColorField.setText(selectedCar.getCarColor());
            carStatusField.setText(selectedCar.getCarStatus());
        }
    }

    @FXML
    public void addCar() {
        try {
            int carID = Integer.parseInt(carIDField.getText().trim());
            String carType = carTypeField.getText().trim();
            String carModel = carModelField.getText().trim();
            String carColor = carColorField.getText().trim();
            String carStatus = carStatusField.getText().trim();

            if (carIDExists(carID)) {
                displayAlert("Car ID already exists.");
                return;
            }

            String query = "INSERT INTO MG_PALESTINE_BRANCH.cars (carID, carType, carModel, carColor, carStatus) VALUES (?, ?, ?, ?, ?)";
            executeUpdate(query, carID, carType, carModel, carColor, carStatus);
            displayAlert("Car record inserted successfully.");
            showCars();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean carIDExists(int carID) {
        return recordExists("SELECT COUNT(*) FROM MG_PALESTINE_BRANCH.cars WHERE carID = ?", carID);
    }

    @FXML
    public void updateCar() {
        try {
            int carID = Integer.parseInt(carIDField.getText().trim());
            String carType = carTypeField.getText().trim();
            String carModel = carModelField.getText().trim();
            String carColor = carColorField.getText().trim();
            String carStatus = carStatusField.getText().trim();

            String query = "UPDATE MG_PALESTINE_BRANCH.cars SET carType = ?, carModel = ?, carColor = ?, carStatus = ? WHERE carID = ?";
            executeUpdate(query, carType, carModel, carColor, carStatus, carID);
            displayAlert("Car record updated successfully.");
            showCars();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deleteCar() {
        try {
            int carID = Integer.parseInt(carIDField.getText().trim());
            String query = "DELETE FROM MG_PALESTINE_BRANCH.cars WHERE carID = ?";
            executeUpdate(query, carID);
            displayAlert("Car record deleted successfully.");
            showCars();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

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
            System.out.println("Services loaded: " + serviceList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public void showServices() {
        String query = "SELECT * FROM Services";
        serviceTable.setItems(getServices(query));
    }

    @FXML
    public void handleServiceRowSelection(MouseEvent event) {
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

            if (recordExists("SELECT * FROM Services WHERE serviceID = ?", serviceID)) {
                displayAlert("Service ID already exists.");
                return;
            }

            if (recordExists("SELECT * FROM Services WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID already exists in another service.");
                return;
            }

            if (recordExists("SELECT * FROM Services WHERE carID = ?", carID)) {
                displayAlert("Car ID already exists in another service.");
                return;
            }

            if (!recordExists("SELECT * FROM Customers WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID does not exist in Customer's Table.");
                return;
            }

            if (!recordExists("SELECT * FROM Cars WHERE carID = ?", carID)) {
                displayAlert("Car ID does not exist in Car's Table.");
                return;
            }

            String query = "INSERT INTO Services (serviceID, customarID, carID, ServiceDescription) VALUES (?, ?, ?, ?)";
            executeUpdate(query, serviceID, customarID, carID, serviceDescription);
            displayAlert("Service record inserted successfully.");
            showServices();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void updateService() {
        try {
            int serviceID = Integer.parseInt(serviceIDField.getText().trim());
            int customarID = Integer.parseInt(customarIDField.getText().trim());
            int carID = Integer.parseInt(carIDField1.getText().trim());
            String serviceDescription = serviceDescriptionField.getText().trim();

            if (!recordExists("SELECT * FROM Services WHERE serviceID = ?", serviceID)) {
                displayAlert("Service ID does not exist.");
                return;
            }

            if (!recordExists("SELECT * FROM Customers WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID does not exist.");
                return;
            }

            if (!recordExists("SELECT * FROM Cars WHERE carID = ?", carID)) {
                displayAlert("Car ID does not exist.");
                return;
            }

            String query = "UPDATE Services SET customarID = ?, carID = ?, ServiceDescription = ? WHERE serviceID = ?";
            executeUpdate(query, customarID, carID, serviceDescription, serviceID);
            displayAlert("Service record updated successfully.");
            showServices();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deleteService() {
        try {
            int serviceID = Integer.parseInt(serviceIDField.getText().trim());
            String query = "DELETE FROM Services WHERE serviceID = ?";
            executeUpdate(query, serviceID);
            displayAlert("Service record deleted successfully.");
            showServices();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    public ObservableList<Employee> getEmployees() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Employees";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("employeeID"), rs.getString("employeeName"),
                        rs.getInt("salary"), rs.getDate("dateOfEmployment").toLocalDate());
                employeeList.add(employee);
            }
            System.out.println("Employees loaded: " + employeeList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void showEmployees() {
        employeeTable.setItems(getEmployees());
    }
    
    public void showEmployees1() {
        employeeTable1.setItems(getEmployees());
    }

    @FXML
    public void handleEmployeeRowSelection(MouseEvent event) {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employeeIDField.setText(String.valueOf(selectedEmployee.getEmployeeID()));
            employeeNameField.setText(selectedEmployee.getEmployeeName());
            salaryField.setText(String.valueOf(selectedEmployee.getSalary()));
            dateOfEmploymentPicker.setValue(selectedEmployee.getDateOfEmployment());
        }
    }

    @FXML
    public void addEmployee() {
        try {
            int employeeID = Integer.parseInt(employeeIDField.getText().trim());
            String employeeName = employeeNameField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());
            LocalDate dateOfEmployment = dateOfEmploymentPicker.getValue();

            if (recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID already exists.");
                return;
            }

            String query = "INSERT INTO Employees (employeeID, employeeName, salary, dateOfEmployment) VALUES (?, ?, ?, ?)";
            executeUpdate(query, employeeID, employeeName, salary, dateOfEmployment);
            displayAlert("Employee record inserted successfully.");
            showEmployees();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void updateEmployee() {
        try {
            int employeeID = Integer.parseInt(employeeIDField.getText().trim());
            String employeeName = employeeNameField.getText().trim();
            double salary = Double.parseDouble(salaryField.getText().trim());
            LocalDate dateOfEmployment = dateOfEmploymentPicker.getValue();

            String query = "UPDATE Employees SET employeeName = ?, salary = ?, dateOfEmployment = ? WHERE employeeID = ?";
            executeUpdate(query, employeeName, salary, dateOfEmployment, employeeID);
            displayAlert("Employee record updated successfully.");
            showEmployees();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void deleteEmployee() {
        try {
            int employeeID = Integer.parseInt(employeeIDField.getText().trim());
            String query = "DELETE FROM Employees WHERE employeeID = ?";
            executeUpdate(query, employeeID);
            displayAlert("Employee record deleted successfully.");
            showEmployees();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    public ObservableList<Advertisers> getAdvertisers() {
        ObservableList<Advertisers> advertiserList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Advertisers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Advertisers advertiser = new Advertisers(rs.getInt("employeeID"), rs.getInt("points"));
                advertiserList.add(advertiser);
            }
            System.out.println("Advertisers loaded: " + advertiserList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertiserList;
    }

    public void showAdvertisers() {
        advertiserTable.setItems(getAdvertisers());
    }

    @FXML
    public void handleAdvertiserRowSelection(MouseEvent event) {
        Advertisers selectedAdvertiser = advertiserTable.getSelectionModel().getSelectedItem();
        if (selectedAdvertiser != null) {
            advertiserEmployeeIDField.setText(String.valueOf(selectedAdvertiser.getEmployeeID()));
            pointsField.setText(String.valueOf(selectedAdvertiser.getPoints()));
        }
    }

    @FXML
    public void addAdvertiser() {
        try {
            int employeeID = Integer.parseInt(advertiserEmployeeIDField.getText().trim());
            int points = Integer.parseInt(pointsField.getText().trim());

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            if (recordExists("SELECT * FROM Managers WHERE employeeID = ?", employeeID)
                    || recordExists("SELECT * FROM Salesmans WHERE employeeID = ?", employeeID)) {
                displayAlert("This Employee ID is already used in Managers or Salesmans.");
                return;
            }

            String query = "INSERT INTO Advertisers (employeeID, points) VALUES (?, ?)";
            executeUpdate(query, employeeID, points);
            displayAlert("Advertiser record inserted successfully.");
            showAdvertisers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void updateAdvertiser() {
        try {
            int employeeID = Integer.parseInt(advertiserEmployeeIDField.getText().trim());
            int points = Integer.parseInt(pointsField.getText().trim());

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            String query = "UPDATE Advertisers SET points = ? WHERE employeeID = ?";
            executeUpdate(query, points, employeeID);
            displayAlert("Advertiser record updated successfully.");
            showAdvertisers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void deleteAdvertiser() {
        try {
            int employeeID = Integer.parseInt(advertiserEmployeeIDField.getText().trim());
            String query = "DELETE FROM Advertisers WHERE employeeID = ?";
            executeUpdate(query, employeeID);
            displayAlert("Advertiser record deleted successfully.");
            showAdvertisers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    public ObservableList<Managers> getManagers() {
        ObservableList<Managers> managerList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Managers";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Managers manager = new Managers(rs.getInt("employeeID"), rs.getString("MonthlyReport"));
                managerList.add(manager);
            }
            System.out.println("Managers loaded: " + managerList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerList;
    }

    public void showManagers() {
        managerTable.setItems(getManagers());
    }

    @FXML
    public void handleManagerRowSelection(MouseEvent event) {
        Managers selectedManager = managerTable.getSelectionModel().getSelectedItem();
        if (selectedManager != null) {
            managerEmployeeIDField.setText(String.valueOf(selectedManager.getEmployeeID()));
            monthlyReportField.setText(selectedManager.getMonthlyReport());
        }
    }

    @FXML
    public void addManager() {
        try {
            int employeeID = Integer.parseInt(managerEmployeeIDField.getText().trim());
            String monthlyReport = monthlyReportField.getText().trim();

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            if (recordExists("SELECT * FROM Advertisers WHERE employeeID = ?", employeeID)
                    || recordExists("SELECT * FROM Salesmans WHERE employeeID = ?", employeeID)) {
                displayAlert("This Employee ID is already used in Advertisers or Salesmans.");
                return;
            }

            String query = "INSERT INTO Managers (employeeID, MonthlyReport) VALUES (?, ?)";
            executeUpdate(query, employeeID, monthlyReport);
            displayAlert("Manager record inserted successfully.");
            showManagers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void updateManager() {
        try {
            int employeeID = Integer.parseInt(managerEmployeeIDField.getText().trim());
            String monthlyReport = monthlyReportField.getText().trim();

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            String query = "UPDATE Managers SET MonthlyReport = ? WHERE employeeID = ?";
            executeUpdate(query, monthlyReport, employeeID);
            displayAlert("Manager record updated successfully.");
            showManagers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void deleteManager() {
        try {
            int employeeID = Integer.parseInt(managerEmployeeIDField.getText().trim());
            String query = "DELETE FROM Managers WHERE employeeID = ?";
            executeUpdate(query, employeeID);
            displayAlert("Manager record deleted successfully.");
            showManagers();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    public ObservableList<Salesmans> getSalesmans() {
        ObservableList<Salesmans> salesmanList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Salesmans";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Salesmans salesman = new Salesmans(rs.getInt("employeeID"), rs.getInt("employeeTarget"));
                salesmanList.add(salesman);
            }
            System.out.println("Salesmans loaded: " + salesmanList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesmanList;
    }

    public void showSalesmans() {
        salesmanTable.setItems(getSalesmans());
    }

    @FXML
    public void handleSalesmanRowSelection(MouseEvent event) {
        Salesmans selectedSalesman = salesmanTable.getSelectionModel().getSelectedItem();
        if (selectedSalesman != null) {
            salesmanEmployeeIDField.setText(String.valueOf(selectedSalesman.getEmployeeID()));
            employeeTargetField.setText(String.valueOf(selectedSalesman.getEmployeeTarget()));
        }
    }

    @FXML
    public void addSalesman() {
        try {
            int employeeID = Integer.parseInt(salesmanEmployeeIDField.getText().trim());
            int employeeTarget = Integer.parseInt(employeeTargetField.getText().trim());

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            if (recordExists("SELECT * FROM Managers WHERE employeeID = ?", employeeID)
                    || recordExists("SELECT * FROM Advertisers WHERE employeeID = ?", employeeID)) {
                displayAlert("This Employee ID is already used in Managers or Advertisers.");
                return;
            }

            String query = "INSERT INTO Salesmans (employeeID, employeeTarget) VALUES (?, ?)";
            executeUpdate(query, employeeID, employeeTarget);
            displayAlert("Salesman record inserted successfully.");
            showSalesmans();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void updateSalesman() {
        try {
            int employeeID = Integer.parseInt(salesmanEmployeeIDField.getText().trim());
            int employeeTarget = Integer.parseInt(employeeTargetField.getText().trim());

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in the Employees table.");
                return;
            }

            String query = "UPDATE Salesmans SET employeeTarget = ? WHERE employeeID = ?";
            executeUpdate(query, employeeTarget, employeeID);
            displayAlert("Salesman record updated successfully.");
            showSalesmans();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format. Please check the fields.");
        }
    }

    @FXML
    public void deleteSalesman() {
        try {
            int employeeID = Integer.parseInt(salesmanEmployeeIDField.getText().trim());
            String query = "DELETE FROM Salesmans WHERE employeeID = ?";
            executeUpdate(query, employeeID);
            displayAlert("Salesman record deleted successfully.");
            showSalesmans();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

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
            System.out.println("Sales loaded: " + salesList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    public void showSales() {
        String query = "SELECT * FROM Sales";
        salesTable.setItems(getSales(query));
    }
    
    public void showSales1() {
        String query = "SELECT * FROM Sales";
        salesTable1.setItems(getSales(query));
    }

    @FXML
    public void handleSaleRowSelection(MouseEvent event) {
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

            if (recordExists("SELECT * FROM Sales WHERE saleID = ?", saleID)) {
                displayAlert("Sale ID already exists.");
                return;
            }

            if (recordExists("SELECT * FROM Sales WHERE carID = ?", carID)) {
                displayAlert("Car ID already exists in another sale.");
                return;
            }

            if (!recordExists("SELECT * FROM Customers WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID does not exist in Customer's Table .");
                return;
            }

            if (!recordExists("SELECT * FROM Cars WHERE carID = ?", carID)) {
                displayAlert("Car ID does not exist in Car's Table .");
                return;
            }

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in Employee's Table .");
                return;
            }

            String query = "INSERT INTO Sales (saleID, saleDescription, customarID, carID, employeeID) VALUES (?, ?, ?, ?, ?)";
            executeUpdate(query, saleID, saleDescription, customarID, carID, employeeID);
            displayAlert("Sale record inserted successfully.");
            showSales();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void updateSale() {
        try {
            int saleID = Integer.parseInt(saleIDField.getText().trim());
            String saleDescription = saleDescriptionField.getText().trim();
            int customarID = Integer.parseInt(saleCustomerIDField.getText().trim());
            int carID = Integer.parseInt(saleCarIDField.getText().trim());
            int employeeID = Integer.parseInt(saleEmployeeIDField.getText().trim());

            if (!recordExists("SELECT * FROM Sales WHERE saleID = ?", saleID)) {
                displayAlert("Sale ID does not exist.");
                return;
            }

            if (recordExists("SELECT * FROM Sales WHERE carID = ? AND saleID != ?", carID, saleID)) {
                displayAlert("Car ID already exists in another sale.");
                return;
            }

            if (!recordExists("SELECT * FROM Customers WHERE customarID = ?", customarID)) {
                displayAlert("Customer ID does not exist in Customer's Table .");
                return;
            }

            if (!recordExists("SELECT * FROM Cars WHERE carID = ?", carID)) {
                displayAlert("Car ID does not exist in Car's Table .");
                return;
            }

            if (!recordExists("SELECT * FROM Employees WHERE employeeID = ?", employeeID)) {
                displayAlert("Employee ID does not exist in Employee's Table .");
                return;
            }

            String query = "UPDATE Sales SET saleDescription = ?, customarID = ?, carID = ?, employeeID = ? WHERE saleID = ?";
            executeUpdate(query, saleDescription, customarID, carID, employeeID, saleID);
            displayAlert("Sale record updated successfully.");
            showSales();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deleteSale() {
        try {
            int saleID = Integer.parseInt(saleIDField.getText().trim());
            String query = "DELETE FROM Sales WHERE saleID = ?";
            executeUpdate(query, saleID);
            displayAlert("Sale record deleted successfully.");
            showSales();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

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
            System.out.println("Cashs loaded: " + cashsList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cashsList;
    }

    public void showCashs() {
        String query = "SELECT * FROM Cashs";
        cashTable.setItems(getCashsList(query));
    }

    @FXML
    public void handleCashRowSelection(MouseEvent event) {
        Cashs selectedCash = cashTable.getSelectionModel().getSelectedItem();
        if (selectedCash != null) {
            cashSaleIDField.setText(String.valueOf(selectedCash.getSaleID()));
            cashProcessNumberField.setText(String.valueOf(selectedCash.getProcessNumber()));
            cashBankCashField.setText(String.valueOf(selectedCash.getBankCash()));
            cashDirectCashField.setText(String.valueOf(selectedCash.getDirectCash()));
            cashDiscountsField.setText(String.valueOf(selectedCash.getDiscounts()));
        }
    }

    @FXML
    public void addCash() {
        try {
            int saleID = Integer.parseInt(cashSaleIDField.getText().trim());
            int processNumber = Integer.parseInt(cashProcessNumberField.getText().trim());
            double bankCash = Double.parseDouble(cashBankCashField.getText().trim());
            double directCash = Double.parseDouble(cashDirectCashField.getText().trim());
            float discounts = Float.parseFloat(cashDiscountsField.getText().trim());

            if (!saleIDExists1(saleID)) {
                displayAlert("Sale ID does not exist in Sale's Table.");
                return;
            }
            if (cashIDExists(saleID, processNumber)) {
                displayAlert("Sale ID and Process Number combination already exists.");
                return;
            }

            String query = "INSERT INTO Cashs (saleID, processNumber, bankCash, directCash, discounts) VALUES (?, ?, ?, ?, ?)";
            executeUpdate(query, saleID, processNumber, bankCash, directCash, discounts);
            displayAlert("Cash record inserted successfully.");
            showCashs();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void updateCash() {
        try {
            int saleID = Integer.parseInt(cashSaleIDField.getText().trim());
            int processNumber = Integer.parseInt(cashProcessNumberField.getText().trim());
            double bankCash = Double.parseDouble(cashBankCashField.getText().trim());
            double directCash = Double.parseDouble(cashDirectCashField.getText().trim());
            float discounts = Float.parseFloat(cashDiscountsField.getText().trim());

            String query = "UPDATE Cashs SET bankCash = ?, directCash = ?, discounts = ? WHERE saleID = ? AND processNumber = ?";
            executeUpdate(query, bankCash, directCash, discounts, saleID, processNumber);
            displayAlert("Cash record updated successfully.");
            showCashs();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    @FXML
    public void deleteCash() {
        try {
            int saleID = Integer.parseInt(cashSaleIDField.getText().trim());
            int processNumber = Integer.parseInt(cashProcessNumberField.getText().trim());
            String query = "DELETE FROM Cashs WHERE saleID = ? AND processNumber = ?";
            executeUpdate(query, saleID, processNumber);
            displayAlert("Cash record deleted successfully.");
            showCashs();
        } catch (NumberFormatException e) {
            displayAlert("Invalid input format.");
        }
    }

    private boolean saleIDExists1(int saleID) {
        return recordExists("SELECT COUNT(*) FROM Sales WHERE saleID = ?", saleID);
    }

    private boolean cashIDExists(int saleID, int processNumber) {
        return recordExists("SELECT COUNT(*) FROM Cashs WHERE saleID = ? AND processNumber = ?", saleID, processNumber);
    }

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
            System.out.println("Installment Payments loaded: " + installmentPaymentsList.size()); // Debugging statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return installmentPaymentsList;
    }

    public void showInstallmentPayments() {
        String query = "SELECT * FROM InstallmentPayments";
        tv_installmentPayments.setItems(getInstallmentPaymentsList(query));
    }

    @FXML
    public void handleInstallmentRowSelection(MouseEvent event) {
        InstallmentPayments selectedPayment = tv_installmentPayments.getSelectionModel().getSelectedItem();
        if (selectedPayment != null) {
            txt_saleID.setText(String.valueOf(selectedPayment.getSaleID()));
            txt_processNumber.setText(String.valueOf(selectedPayment.getProcessNumber()));
            txt_totalCost.setText(String.valueOf(selectedPayment.getTotalCost()));
            txt_firstPayment.setText(String.valueOf(selectedPayment.getFirstPayment()));
            txt_monthlyInstallment.setText(String.valueOf(selectedPayment.getMonthlyInstallment()));
            txt_numberOfMonths.setText(String.valueOf(selectedPayment.getNumberOfMonths()));
        }
    }

    @FXML
    public void insertInstallmentRecord() {
        if (txt_saleID.getText().isEmpty() || txt_processNumber.getText().isEmpty() || txt_totalCost.getText().isEmpty()
                || txt_firstPayment.getText().isEmpty() || txt_monthlyInstallment.getText().isEmpty()
                || txt_numberOfMonths.getText().isEmpty()) {
            displayAlert("Please fill all fields.");
            return;
        }

        int saleID = Integer.parseInt(txt_saleID.getText().trim());
        int processNumber = Integer.parseInt(txt_processNumber.getText().trim());
        if (!saleIDExists1(saleID)) {
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
            ps.setDouble(3, Double.parseDouble(txt_totalCost.getText().trim()));
            ps.setDouble(4, Double.parseDouble(txt_firstPayment.getText().trim()));
            ps.setDouble(5, Double.parseDouble(txt_monthlyInstallment.getText().trim()));
            ps.setInt(6, Integer.parseInt(txt_numberOfMonths.getText().trim()));
            ps.executeUpdate();
            displayAlert("Record inserted successfully.");
            showInstallmentPayments();
        } catch (SQLException e) {
            e.printStackTrace();
            displayAlert("Error inserting record.");
        }
    }

    @FXML
    public void updateInstallmentRecord() {
        if (txt_saleID.getText().isEmpty() || txt_processNumber.getText().isEmpty() || txt_totalCost.getText().isEmpty()
                || txt_firstPayment.getText().isEmpty() || txt_monthlyInstallment.getText().isEmpty()
                || txt_numberOfMonths.getText().isEmpty()) {
            displayAlert("Please fill all fields.");
            return;
        }

        String query = "UPDATE InstallmentPayments SET totalCost = ?, firstPayment = ?, monthlyInstallment = ?, NumberOfMonths = ? WHERE saleID = ? AND processNumber = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setDouble(1, Double.parseDouble(txt_totalCost.getText().trim()));
            ps.setDouble(2, Double.parseDouble(txt_firstPayment.getText().trim()));
            ps.setDouble(3, Double.parseDouble(txt_monthlyInstallment.getText().trim()));
            ps.setInt(4, Integer.parseInt(txt_numberOfMonths.getText().trim()));
            ps.setInt(5, Integer.parseInt(txt_saleID.getText().trim()));
            ps.setInt(6, Integer.parseInt(txt_processNumber.getText().trim()));
            ps.executeUpdate();
            displayAlert("Record updated successfully.");
            showInstallmentPayments();
        } catch (SQLException e) {
            e.printStackTrace();
            displayAlert("Error updating record.");
        }
    }

    @FXML
    public void deleteInstallmentRecord() {
        if (txt_saleID.getText().isEmpty() || txt_processNumber.getText().isEmpty()) {
            displayAlert("Please fill Sale ID and Process Number fields.");
            return;
        }

        String query = "DELETE FROM InstallmentPayments WHERE saleID = ? AND processNumber = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, Integer.parseInt(txt_saleID.getText().trim()));
            ps.setInt(2, Integer.parseInt(txt_processNumber.getText().trim()));
            ps.executeUpdate();
            displayAlert("Record deleted successfully.");
            showInstallmentPayments();
        } catch (SQLException e) {
            e.printStackTrace();
            displayAlert("Error deleting record.");
        }
    }

    private boolean installmentIDExists(int saleID, int processNumber) {
        return recordExists("SELECT COUNT(*) FROM InstallmentPayments WHERE saleID = ? AND processNumber = ?", saleID,
                processNumber);
    }

    @FXML
    public void refreshDashboard() {
        updateStatistics();
        loadAllData();
    }

    // Utility methods for alerts and database operations
    private boolean recordExists(String query, Object... params) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void executeUpdate(String query, Object... params) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            displayAlert("Database error: " + e.getMessage());
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
