package ua.com.codespace.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CountryDetails> countryDetails = new HashSet<>();

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

    public Set<CountryDetails> getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(Set<CountryDetails> countryDetails) {
        this.countryDetails = countryDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getId() == country.getId() &&
                Objects.equals(getName(), country.getName()) &&
                Objects.equals(getCountryDetails(), country.getCountryDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountryDetails());
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryDetails=" + countryDetails +
                '}';
    }
}
