package clientPKG;

import java.util.ArrayList;

public class SaveInfo {


    public ArrayList<Admin> adminArrayLis = new ArrayList<>();
    public ArrayList<Customer> customerArrayList = new ArrayList<>();
    public void saveAdminInfo(Admin admin){
        adminArrayLis.add(admin);
    }
    public void saveCustomerInfo(Customer customer){
        customerArrayList.add(customer);
    }

}
