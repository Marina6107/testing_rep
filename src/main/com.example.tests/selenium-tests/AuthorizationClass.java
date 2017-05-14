/**
 * Created by marina on 09.05.2017.
 */

import common.LoginForm;
import org.testng.annotations.Test;

public class AuthorizationClass extends BaseClass {

    @Test(dataProvider = "groupsFromFile", dataProviderClass = GroupDataGenerator.class)
    public void testLogin(LoginForm loginForm) throws Exception {
        getBaseUrl();
        fillLoginForm(loginForm);
        confirmForm();
        isEqualsElement("Мои задачи");
    }

}
