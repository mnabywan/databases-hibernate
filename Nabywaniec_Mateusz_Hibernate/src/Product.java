import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS" )
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    public String ProductName;
    public Integer UnitsOnStock;

    @ManyToOne
    @JoinColumn(name = "SUPPLIED_BY")
    private Supplier suppliedBy;

    @ManyToOne
    private Category category;

    @ManyToMany(mappedBy = "includesProducts",
            cascade = CascadeType.PERSIST)
    private Set<Invoice> canBeSoldIn = new HashSet<>();
    public Product(String productName) {
        ProductName = productName;
    }

    public Product(String productName, Integer unitsOnStock, Supplier supplier) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
        this.suppliedBy = supplier;
    }

    public Product(String productName, Integer unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setSuppliedBy(Supplier supplier) {
        this.suppliedBy = supplier;
    }


    public void setCategory(Category category){
        this.category = category;
        if(!category.getProducts().contains(this)){
            category.addProduct(this);
        }
    }

    public Supplier getSuppliedBy() {
        return suppliedBy;
    }

    public String getProductName(){
        return this.ProductName;
    }

    public Set<Invoice> getCanBeSoldIn() {
        return canBeSoldIn;
    }

}
