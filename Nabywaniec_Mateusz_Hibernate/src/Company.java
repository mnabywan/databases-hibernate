import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {
    @Id
    public String CompanyName;

    private String Street;
    private  String City;

    public Company() {
    }

    public Company(String companyName, String street, String city) {
        CompanyName = companyName;
        Street = street;
        City = city;
    }

    public String getCompanyName() {
        return CompanyName;
    }
}