package schooldata.grade;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GradeSearchController {
	
	@FXML
	TextField stid;
	
	@FXML 
	TextField cid;
	
	@FXML 
	ComboBox semester;
	
	@FXML 
	ComboBox year;
	
	@FXML 
	ComboBox grade;
	
	@FXML 
	ListView searchList;
	
	@FXML
	BorderPane outGradeSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	@FXML
	public void search() {
		
	}
	

}
