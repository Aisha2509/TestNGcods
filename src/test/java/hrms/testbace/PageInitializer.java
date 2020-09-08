package hrms.testbace;

import com.hrms.pages.AddEmployeePageElement;
import com.hrms.pages.DashboardPageElement;
import com.hrms.pages.LoginPageElement;

public class PageInitializer extends BaceClass{

	protected static LoginPageElement login;
	protected static DashboardPageElement dash;
	protected static AddEmployeePageElement addEmp;

	public static void initializePageObjects() {

		login = new LoginPageElement();
		dash = new DashboardPageElement();
		addEmp = new AddEmployeePageElement();

	}
}
