package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
// 만약 엔티티의 클래스와 db 테이블명이 다르면, @Table Annotation으로 지정해주면 된다.
// @Table(name = "USER")
public class Member {

    @Id
    private Long id;


    //    @Column(name = "name" , insertable = true , updatable = true)
    // UK_ektea7vp6e3low620iewuxhlq 이름 인식 불가
    // 컬럼에서는 유니크 이름 지정 불가
    @Column(name = "name" , nullable = true)
    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /*
        testLocalDate date,
        testLocalDateTime timestamp,
     */
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;


    @Lob
    private String description;

    // db 상관없이 계산로직 하고 싶을때
    @Transient
    private int temp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }


    public Member() {

    }
}
