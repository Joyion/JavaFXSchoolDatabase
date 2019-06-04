package schooldata.student;

import java.util.ArrayList;
import java.util.Arrays;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class StudentEditController {
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
	
	@FXML 
	Button edit;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	public void initialize() {
	try {
		Student s = data.returnStudent();
		System.out.println(s.toString());
		
		stid.setText(Integer.toString(s.getID()));
		fname.setText(s.getName());
		lname.setText(s.getLastName());
		address.setText(s.getAddress());
		city.setText(s.getCity());
		String [] statelist = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA","GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN","MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
		ArrayList<String> convert = new ArrayList<String>(Arrays.asList(statelist));
		ObservableList<String> states = FXCollections.observableArrayList(convert);
		state.getItems().addAll(states);
		state.getSelectionModel().select(s.getState());
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	@FXML
	public void editOrSave() {
	
	if (edit.getText().compareToIgnoreCase("Save") == 0)
		try {
			String stateitem = (String) state.getSelectionModel().getSelectedItem();
			Student stud = data.returnStudent();
			data.saveStudent(fname.getText().trim(), lname.getText().trim(), address.getText().trim(), 
					city.getText().trim(), stateitem.trim(), stid.getText().trim(), stud);
			fname.clear();
			lname.clear();
			address.clear();
			city.clear();
			stid.clear();
			edit.setText("Edit");
			stid.setEditable(false);
			fname.setEditable(false);
			lname.setEditable(false);
			address.setEditable(false);
			city.setEditable(false);
			state.setDisable(true);
			}
		
		catch (NumberFormatException n)
		{
			System.out.println(n.getMessage());
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	else if (edit.getText().compareToIgnoreCase("Edit") == 0)
	{
		fname.setEditable(true);
		lname.setEditable(true);
		address.setEditable(true);
		city.setEditable(true);
		state.setDisable(false);
		edit.setText("Save");
	}
	
		
		
	}
	

}
