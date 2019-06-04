package schooldata.department;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DepartmentSearchController {
	
	@FXML
	TextField dptname;
	
	@FXML 
	ComboBox dptid;
	
	@FXML
	ListView searchList;
	
	@FXML 
	BorderPane outDepartmentSearchPnl;
	
	Pane editpane;
	
	FXMLLoader load;
	
	SqlDatabase data = SqlDatabase.getInstance();
	
	@FXML
	public void search() {
		
	}

}
