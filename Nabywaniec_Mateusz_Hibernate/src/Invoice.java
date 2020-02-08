import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "INVOICES" )
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceNumber;
    private Integer quantity;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Product> includesProducts = new HashSet<>();

    public Invoice(){}

    public Invoice(Product product, int quantity){
        this.includesProducts.add(product);
        this.quantity = quantity;
    }

    public void addProduct(Product product, int quantity){
        this.includesProducts.add(product);
        this.quantity += quantity;
    }


}
