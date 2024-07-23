package com.app.manager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class AppsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appId;
    private String name;
    private String ip;
    private int port;

    @Column(name = "is_url")
    private boolean urlStatus;

    @Column(name = "url")
    private String urlLink;

    @Enumerated(EnumType.STRING)
    private Availability availability;
}
