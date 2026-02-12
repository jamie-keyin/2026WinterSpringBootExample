package com.keyin.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.springframework.util.StringUtils;

@Entity
public class Status {
    @Id
    @SequenceGenerator(name = "status_sequence", sequenceName = "status_sequence", allocationSize = 1, initialValue=2)
    @GeneratedValue(generator = "status_sequence")
    private Long id;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        if (!StringUtils.hasText(status)) {
            return "no-status";
        }

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
