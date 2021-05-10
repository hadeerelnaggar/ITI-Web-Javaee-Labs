package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "biddingschema", catalog = "")
public class UserEntity {
    private int id;
    private String email;
    private String address;
    private String phone;
    private String mobile;
    private Date dateOfBirth;
    private Date registrationDate;
    private String userName;
    private String password;
    private String fullName;
    private Collection<BuyerEntity> buyersById;
    private SellerEntity sellerById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 150)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 45)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "registration_date", nullable = false)
    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 100)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(mobile, that.mobile) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(registrationDate, that.registrationDate) && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, address, phone, mobile, dateOfBirth, registrationDate, userName, password, fullName);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<BuyerEntity> getBuyersById() {
        return buyersById;
    }

    public void setBuyersById(Collection<BuyerEntity> buyersById) {
        this.buyersById = buyersById;
    }

    @OneToOne(mappedBy = "userById")
    public SellerEntity getSellerById() {
        return sellerById;
    }

    public void setSellerById(SellerEntity sellerById) {
        this.sellerById = sellerById;
    }
}
