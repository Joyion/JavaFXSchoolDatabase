package schooldata.student;

import java.util.ArrayList;
import java.util.Arrays;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class StudentAddController {
	
	@FXML
	TextField stid;
	
	@FXML
	TextField fname;
	
	@FXML 
	TextField lname;
	
	@FXML 
	TextField address;
	
	@FXML 
	TextField city;
	
	@FXML 
	ComboBox state;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	public void initialize () {
	//	String [] statelist = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
	//	ArrayList<String> convert = new ArrayList<String>(Arrays.asList(statelist));
		ObservableList<String> states = FXCollections.observableArrayList("AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY");
		state.getItems().addAll(states);
	}
	
	@FXML
	public void add() {
	
	try {
		String stateitem = (String) state.getSelectionModel().getSelectedItem();
		data.addStudent(fname.getText().trim(), lname.getText().trim(), address.getText().trim(), 
				city.getText().trim(), stateitem, stid.getText().trim());
		fname.clear();
		lname.clear();
		address.clear();
		city.clear();
		stid.clear();
		state.getSelectionModel().select(0);
		
		}
	
	catch (NumberFormatException n)
	{
		System.out.println(n.getMessage());
	}
	
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	}
	
}
