import org.hibernate.dialect.ProgressDialect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Supplier extends  Company {
    public String bankAccountNumber;


    @OneToMany
    @JoinColumn(name = "SUPPLIED_BY")
    private Set<Product> supplies = new HashSet<>();

    public Supplier() {
        super();
    }

    public Supplier(String companyName, String street, String city, String account) {
        super(companyName, street, city);
        bankAccountNumber = account;
    }

    public void addSuppliedProduct(Product p) {
        supplies.add(p);
        p.setSuppliedBy(this);
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public boolean suppliesProduct(Product p) {
        return supplies.contains(p);
    }

}

/*
@Entity
@Table(name = "SUPPLIERS" )
@SecondaryTable(name = "ADDRESS_TBL")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierID;

    private String CompanyName;

  //  @Embedded
  //  private Address address;
    @Column(table = "ADDRESS_TBL")
    private String Street;
    @Column(table = "ADDRESS_TBL")
    private String City;
    @Column(table = "ADDRESS_TBL")
    private String Country;


    @OneToMany
    private Set<Product> suppliedProducts = new HashSet<>();

    public Supplier(String companyName, String street, String city, String country) {
        CompanyName = companyName;
        Street = street;
        City = city;
        this.Country = country;
        //address = new Address(street, city, country);
    }

    public Supplier(){};

    public String getStreet() {
        return this.Street;
    }

    public void setStreet(String street) {
        this.Street = street;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public void addProduct(Product product){
        this.suppliedProducts.add(product);
        product.setSuppliedBy(this);
    }

     public void setCountry(String country){
        this.Country = country;
     }
*/


