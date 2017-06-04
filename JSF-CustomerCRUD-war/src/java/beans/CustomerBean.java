/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.CustomerFacade;
import ejb.DiscountCodeFacade;
import ejb.MicroMarketFacade;
import entity.Customer;
import entity.DiscountCode;
import entity.MicroMarket;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author david
 */
@Named(value = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {

    @EJB
    private MicroMarketFacade microMarketFacade;

    @EJB
    private DiscountCodeFacade discountCodeFacade;

    @EJB
    private CustomerFacade customerFacade;

    private List<Customer> listCustomer;
    private List<DiscountCode> listDiscount = null;
    private List<MicroMarket> listZip = null;
    private Customer customerSelected;
    private String zipSelected;
    private String discountSelected;

    public CustomerBean() {
    }

    @PostConstruct
    public void init() {
        this.listCustomer = customerFacade.findAll();
        this.listDiscount = discountCodeFacade.findAll();
        this.listZip = microMarketFacade.findAll();
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public List<DiscountCode> getListDiscount() {
        return listDiscount;
    }

    public void setListDiscount(List<DiscountCode> listDiscount) {
        this.listDiscount = listDiscount;
    }

    public List<MicroMarket> getListZip() {
        return listZip;
    }

    public void setListZip(List<MicroMarket> listZip) {
        this.listZip = listZip;
    }
    
    public Customer getCustomerSelected() {
        return customerSelected;
    }

    public void setCustomerSelected(Customer customerSelected) {
        this.customerSelected = customerSelected;
    }
    
    public String getZipSelected() {
        return zipSelected;
    }

    public void setZipSelected(String zipSelected) {
        this.zipSelected = zipSelected;
    }

    public String getDiscountSelected() {
        return discountSelected;
    }

    public void setDiscountSelected(String discountSelected) {
        this.discountSelected = discountSelected;
    }

    public void newCustomer() {
        this.customerSelected = new Customer();
        this.zipSelected = null;
        this.discountSelected = null;
    }

    public void loadList() {
        if (listDiscount == null || listZip == null) {
            this.listZip = microMarketFacade.findAll();
            this.listDiscount = discountCodeFacade.findAll();
        }
    }
    
    public String editCustomer(int idCustomer){
        this.customerSelected = customerFacade.find(idCustomer);
        this.zipSelected = customerSelected.getZip().getZipCode();
        this.discountSelected = customerSelected.getDiscountCode().getDiscountCode();
        loadList();
        return "newCustomer";
    }
    
    public String deleteCustomer(int idCustomer){
        this.customerSelected = customerFacade.find(idCustomer);
        customerFacade.remove(customerSelected);
        init();
        return "customer";
    }

    public String createCustomer() {
        newCustomer();
        loadList();
        return "newCustomer";
    }

}
