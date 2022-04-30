package manager;
import models.User;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData(){
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"kvitka@gmail.com","Kvi12345$"});
        list.add(new Object[]{"mona@gmail.com","Mm12345$"});
        list.add(new Object[]{"zoa@gmail.com","Zoa12345$"});
        list.add(new Object[]{"wik416@gmail.com","Ww12345$"});

        return list.iterator();
    }
    
    
    @DataProvider
    public Iterator<Object[]> validModelLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object []{new User().withEmail("kvitka@gmail.com").withPassword("Kvi12345$")});
        list.add(new Object []{new User().withEmail("mona@gmail.com").withPassword("Mm12345$")});
        list.add(new Object []{new User().withEmail("zoa@gmail.com").withPassword("Zoa12345$")});
        list.add(new Object []{new User().withEmail("wik416@gmail.com").withPassword("Ww12345$")});


    return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validModelCSV() throws IOException {
        List <Object[]> list = new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/loginValid.csv")));
        String line = reader.readLine();


        while(line!=null){
            String[] split = line.split(",");// rosrisay po ,
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validDataContact() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();


        return list.iterator();
    }
}
