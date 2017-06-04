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
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author david
 */
@Named(value = "customerEditBean")
@RequestScoped
public class CustomerEditBean {

    @EJB
    private DiscountCodeFacade discountCodeFacade;

    @EJB
    private MicroMarketFacade microMarketFacade;

    @EJB
    private CustomerFacade customerFacade;

    @Inject
    private CustomerBean session;

    private Customer customerSelected;
    private String zipSelected;
    private String discountSelected;

    public CustomerEditBean() {
    }

    @PostConstruct
    public void init() {
        this.customerSelected = session.getCustomerSelected();
    }

    public Customer getCustomerSelected() {
        return customerSelected;
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

    public String editCustomer(Customer customer) {
        session.setCustomerSelected(customer);
        session.loadList();
        return "newCustomer";
    }

    public String saveCustomer() {
        MicroMarket mm = this.microMarketFacade.find(session.getZipSelected());
        DiscountCode dc = this.discountCodeFacade.find(session.getDiscountSelected());
        customerSelected.setZip(mm);
        customerSelected.setDiscountCode(dc);
        if (this.customerSelected.getCustomerId() == null) {
            this.customerSelected.setCustomerId(Calendar.MILLISECOND);
            this.customerFacade.create(customerSelected);
        } else {
            this.customerFacade.edit(customerSelected);
        }
        this.session.setCustomerSelected(customerSelected);
        session.init();
        return "customer";
    }

}
