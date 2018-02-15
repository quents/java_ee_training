package com.training.ee.model;

import com.training.ee.jpa.ColorConverter;
import com.training.ee.jpa.PasswordConverter;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@Entity
@Table(name = "PersonTable", indexes = { @Index(columnList = "name,surname", unique = true, name = "my_ns_index") })
@SecondaryTable(name = "personsecond")
@XmlType(name = "personType", propOrder = { "isim", "yas", "soyisim", "cinsiyet", "department", "requestId", "id",
        "mid","personExtra", "spouse", "addressList", "hairColor", "encyPassword" })
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "select_by_name", query = "select a from Person a where a.isim = :isim")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "select_by_name_native", query = "select * from persontable where name = :isim")
})
public class Person {

    @Id
    @GeneratedValue
    @XmlTransient //id gosterme
    private long personId;


    @Column(name = "name", length = 20, nullable = false) // database e gidilip yapilir
    @PathParam("name")
    @XmlElement(name = "name", nillable = false, required = true)
    @Size(min=2, max=20, message="isim 2 ila 20 arasinda olmali")
    @NotNull // database de yapilmaz, gitmeden yapilir
    @Pattern(regexp = "[a-z]+")
    private String isim;


    @Max(value = 150, message = "Yaş 150 den büyük olamaz")
    @Min(value = 10, message = "Yaş 10 dan küçük olamaz")
    @Column(name = "age", nullable = false)
    @PathParam("age")
    private int yas;


    @Column(name = "surname", length = 20, nullable = false)
    @FormParam("surname")
    private String soyisim;

    @Column(name = "gender", length = 10, nullable = false)
    @FormParam("gender")
    private String cinsiyet;

    @FormParam("department")
    private String department;

    @FormParam("requestId")
    private String requestId;

    @Column(unique = true, table = "personsecond")
    @FormParam("id")
    private String id;

    @Column(unique = true, table = "personsecond")
    @FormParam("mid")
    private String mid;

    @Convert(converter = ColorConverter.class)
    private Color hairColor;

    @FormParam("password")
    @Convert(converter = PasswordConverter.class)
    private String encyPassword;

    public String getEncyPassword() {
        return encyPassword;
    }

    public void setEncyPassword(String encyPassword) {
        this.encyPassword = encyPassword;
    }

    @Embedded
    private PersonExtra personExtra;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Spouse spouse;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Address> addressList;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public PersonExtra getPersonExtra() {
        return personExtra;
    }

    public void setPersonExtra(PersonExtra personExtra) {
        this.personExtra = personExtra;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @PostPersist
    @PostLoad
    @PostRemove
    @PostUpdate
    public void after(){
        //isim = isim.substring(0, isim.indexOf("_pre"));
    }

    @PrePersist
    @PreRemove
    @PreUpdate
    public void before(){
        //isim = isim + "_pre";
    }

}
