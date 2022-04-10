package Targil2;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String customerInfo) {
        List<String> customerData = Arrays.asList(customerInfo.split("\\s"));
        id = Long.parseLong(customerData.get(1));
        name = customerData.get(3);
        tier = Integer.parseInt(customerData.get(5));
    }

    public Customer(long Cid, String Cname, int Ctier) {
        setId(Cid);
        setName(Cname);
        setTier(Ctier);
    }

    public String toString() {
        return "customer: " + getId() + " name: " + getName() + " tier: " + getTier() + "\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}