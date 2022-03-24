package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email,String password) {

        type(By.xpath("//input[1]"), email);
        //fill password
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginRegistrationForm(User user) {

        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword);
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));

    }
    public boolean isLoginRegistrationSuccess() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public boolean isSingOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sing Out']"));
    }

    public void isSingOut() {
        click(By.xpath("//button[text()='Sing Out']"));
    }
}
