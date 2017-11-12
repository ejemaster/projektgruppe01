package org.projektmanagement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.INITIALIZE;
import org.projektmanagement.model.Kunde;
import org.projektmanagement.service.KundenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyValue;
import javafx.application.Application;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerOverviewController {
	private static final Logger log = LoggerFactory.getLogger(CustomerOverviewController.class);
	private ListProperty<Kunde> listProperty = new SimpleListProperty();
	private Set<String> names = new HashSet<String>();
	private KundenService kundenService = new KundenService();
	
	@FXML
	private TextField firstnameField;
	@FXML
	private TextField lastnameField;
	@FXML
	private TableView<Kunde> tableView;
	@FXML
	private TableColumn<Kunde, Integer> kundeIdCol;
	@FXML
	private TableColumn<Kunde, String> kundeFirstnameCol;
	@FXML
	private TableColumn<Kunde, String> kundeLastnameCol;
	@FXML
	private TableColumn<Kunde, String> kundeEmailCol;
	@FXML
	private TableColumn<Kunde, String> kundePhoneCol;
	@FXML
	private TableColumn<Kunde, String> kundeStreetCol;
	@FXML
	private TableColumn<Kunde, String> kundeStreetnrCol;
	@FXML
	private TableColumn<Kunde, String> kundePlzCol;
	@FXML
	private TableColumn<Kunde, String> kundePlaceCol;
	@FXML
	private TableColumn<Kunde, String> kundeCountryCol;
	
	@FXML
	private void initialize() {
		kundeIdCol.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("id"));
		kundeFirstnameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("firstname"));
		kundeLastnameCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("lastname"));
		kundeEmailCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("email"));
		kundePhoneCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("phone"));
		kundeStreetCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("street"));
		kundeStreetnrCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("streetnr"));
		kundePlzCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("plz"));
		kundePlaceCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("place"));
		kundeCountryCol.setCellValueFactory(new PropertyValueFactory<Kunde, String>("country"));
	}
	
	@FXML
	public void addKunde() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/views/customerAdd.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Benutzer hinzufügen");
        stage.setScene(new Scene(rootNode));
        stage.show();
	}

	@FXML
	public void refresh() {
		List<Kunde> kunden = kundenService.getKundenHandler().getAllKunden();

		if (kunden != null) {
			tableView.setItems(FXCollections.observableArrayList(kunden));
		}

		log.info("Customer table updated");
	}
}
