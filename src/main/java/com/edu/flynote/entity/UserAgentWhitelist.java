package com.edu.flynote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserAgentWhitelist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String value;
}
