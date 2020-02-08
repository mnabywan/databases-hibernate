import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "CATEGORIES" )
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryID;
    private String Name;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Category(){};

    public Category(String name){
        this.Name = name;
    }

    public void addProduct(Product product){
        this.products.add(product);
        product.setCategory(this);
    }

    public List<Product> getProducts(){
        return this.products; //
    }

    public String getName() {
        return Name;
    }

    public int getCategoryID(){
        return this.categoryID;
    }
}
//nt CategoryID, String Name oraz listą produktow
//List<Product> Products