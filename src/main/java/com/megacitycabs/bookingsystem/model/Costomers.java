package com.megacitycabs.bookingsystem.model;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Costomers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true, referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_customer_user", foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE"))
    private Users user;  // FIXED: Ensure this is your `Users` entity, not `org.apache.catalina.User`

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "nic", nullable = false, unique = true, length = 12)
    private String nic;
}
