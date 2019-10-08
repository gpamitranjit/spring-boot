package com.logicbig.example;

import javax.persistence.*;

@Entity
@Table(name = "myTable")
public class MyEntity {
    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "myDbSeq",
            initialValue = 5, allocationSize = 3)
    @GeneratedValue(generator = "mySeqGen")
    private int myId;
}