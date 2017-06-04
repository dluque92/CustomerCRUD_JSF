package entity;

import entity.Customer;
import entity.Product;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-03T23:49:35")
@StaticMetamodel(PurchaseOrder.class)
public class PurchaseOrder_ { 

    public static volatile SingularAttribute<PurchaseOrder, Short> quantity;
    public static volatile SingularAttribute<PurchaseOrder, BigDecimal> shippingCost;
    public static volatile SingularAttribute<PurchaseOrder, Date> shippingDate;
    public static volatile SingularAttribute<PurchaseOrder, Product> productId;
    public static volatile SingularAttribute<PurchaseOrder, Date> salesDate;
    public static volatile SingularAttribute<PurchaseOrder, String> freightCompany;
    public static volatile SingularAttribute<PurchaseOrder, Customer> customerId;
    public static volatile SingularAttribute<PurchaseOrder, Integer> orderNum;

}