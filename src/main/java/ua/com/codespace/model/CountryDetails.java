package ua.com.codespace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country_details")
public class CountryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "information")
    private InformationType information;

    @Column(name = "value")
    private double value;

    @Column(name = "year")
    private int year;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InformationType getInformation() {
        return information;
    }

    public void setInformation(InformationType information) {
        this.information = information;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryDetails)) return false;
        CountryDetails that = (CountryDetails) o;
        return Double.compare(that.getValue(), getValue()) == 0 &&
                getYear() == that.getYear() &&
                getInformation() == that.getInformation();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getInformation(), getValue(), getYear());
    }

    @Override
    public String toString() {
        return "CountryDetails{" +
                "information=" + information +
                ", value=" + value +
                ", year=" + year +
                '}';
    }
}
