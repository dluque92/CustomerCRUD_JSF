package entity;

import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-06-03T23:49:35")
@StaticMetamodel(ProductCode.class)
public class ProductCode_ { 

    public static volatile SingularAttribute<ProductCode, String> prodCode;
    public static volatile SingularAttribute<ProductCode, Character> discountCode;
    public static volatile CollectionAttribute<ProductCode, Product> productCollection;
    public static volatile SingularAttribute<ProductCode, String> description;

}