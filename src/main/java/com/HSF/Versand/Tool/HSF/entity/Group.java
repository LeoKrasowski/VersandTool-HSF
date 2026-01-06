package com.HSF.Versand.Tool.HSF.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
