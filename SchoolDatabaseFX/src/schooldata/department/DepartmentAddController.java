package schooldata.department;

import com.joyiontimmons.schooldata.SqlDatabase;

import javafx.fxml.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DepartmentAddController {
	
	@FXML
	TextField dptid;
	
	@FXML
	TextField dptname;
	
	@FXML
	ComboBox dpthead;
	
	SqlDatabase database = SqlDatabase.getInstance();
	
	public DepartmentAddController() {
		
		
	}

	@FXML 
	public void add() {
		
		
		
	}
	
}
