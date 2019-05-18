package app.controller;

import app.Loan;
import app.Loan.Payment;
import app.StudentCalc;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import javafx.application.Application;

import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.geometry.Insets;

import javafx.scene.Group;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;

import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.scene.text.Font;

import javafx.stage.Stage;

public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField Term;
	
	@FXML
	private TextField AdditionalPayment;

	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	     
		    
		    
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double dTerm = Double.parseDouble(Term.getText());
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		Loan L = new Loan(dLoanAmount, dInterestRate, dTerm, dAdditionalPayment);
		for (Payment p :  L.loanPayments) {
			System.out.println(p.getPaymentNumber());
			System.out.println(p.getPayment());
			System.out.println(p.getInterest());
			System.out.println(p.getPrincipal());
			System.out.println(p.getBalance());
		}
			
		lblTotalPayemnts.setText(Integer.toString(L.numberPayments));
		lblTotalInterest.setText(Double.toString(L.totalInterest));
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);

	    

	 
}

	}
	

		 

	    