package org.example.Entity;

import com.shop.dto.JoinFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.constant.Role;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
@ToString
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String name;
    private String address;
    private String password;
    private String PhoneNumber;


    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(JoinFormDto joinFormDto, PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(joinFormDto.getName());
        member.setEmail(joinFormDto.getEmail());
        member.setAddress(joinFormDto.getAddress());
        String password = passwordEncoder.encode(joinFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.ADMIN);
        return member;
    }
}

