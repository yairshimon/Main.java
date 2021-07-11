import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//
        Scanner scanner = new Scanner(System.in);
        String userName, passwordOfUser;
        int choice;
        System.out.println("Enter your name:");
        userName = scanner.next();
        System.out.println("Enter your password");
        passwordOfUser = scanner.next();
        System.setProperty("webdriver.edge.driver", "C:\\Users\\lenovo-1\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.aac.ac.il/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> infoPersonal = driver.findElements(By.tagName("li"));
        for (int i = 0; i <= infoPersonal.size(); i++) {
            if (infoPersonal.get(i).getText().equals("מידע אישי")) {
                infoPersonal.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement user = driver.findElement(By.id("Ecom_User_ID"));
            if (user != null)
                user.sendKeys(userName);
            WebElement password = driver.findElement(By.id("Ecom_Password"));
            if (password != null)
                password.sendKeys(passwordOfUser);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement enter = driver.findElement(By.className("submit"));
            enter.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> moodle = driver.findElements(By.className("col-sm-6"));
            for (WebElement webElement : moodle) {
                if (webElement.getText().equals("מערכת Moodle")) {
                    webElement.click();
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> menu1 = driver.findElements(By.className("avatars")); //avatars
            menu1.get(0).click();
        }catch (Exception e){
            System.out.println("Dear user. The username or password is incorrect");
            System.exit(3) ;
        }
        WebElement myCourses = driver.findElement(By.id("actionmenuaction-2"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myCourses.click();
        List<WebElement> temp = driver.findElements(By.className("contentnode"));
        WebElement menu2 = temp.get(2);
        List<WebElement> courses = menu2.findElements(By.tagName("li"));
        int i;
        for (i = 1; i <courses.size(); i++) { //"for" to print only the course name
            System.out.println();
            String d = courses.get(i-1).getText();
            int j = 0;
            if (!d.isEmpty()) {
                try {
                    System.out.print("course" + i  + ": ");
                    while (d.charAt(j) != '(') {
                        System.out.print(d.charAt(j));
                        j++;}
                     } catch (Exception StringIndexOutOfBoundsException) {
                    System.out.println(".");
                }
            }
        }
        do {
            System.out.println("\nEnter a number of the course you want to enter between 1 to " + courses.size() + " :");
            choice = scanner.nextInt();
        }while(!(choice >= 1 && choice < courses.size()));
        courses.get(choice-1).click();
       // courses.get(choice).click();
        try{
            WebElement pressCourse = courses.get(choice-1).findElement(By.tagName("a"));
            pressCourse.click();
        }catch (Exception ignored){}
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> menu3 = driver.findElements(By.className("breadcrumb-item"));
        menu3.get(2).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> menu4 = driver.findElements(By.className("avatars")); //avatars
        menu4.get(0).click();
        WebElement exitMoodle = driver.findElement(By.id("actionmenuaction-6"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exitMoodle.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> exitInfoPersonal = driver.findElements(By.tagName("li"));
        for (i = 0; i <exitInfoPersonal.size(); i++) {
            if (exitInfoPersonal.get(i).getText().equals("יציאה")) {
                exitInfoPersonal.get(i).click();
                break;
            }
        }
        System.out.println("BY");
    }
}