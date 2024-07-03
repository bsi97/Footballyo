package com.footballyo.common.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    protected String createdAt;
    protected String modifiedAt;
    protected boolean visibility = true;

    private String customFormat() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @PrePersist
    protected void onPrePersist() {
        createdAt = customFormat();
        modifiedAt = createdAt;
    }

    @PreUpdate
    protected void onPreUpdate() {
        modifiedAt = customFormat();
    }

    public void softDelete() {
        visibility = false;
    }

    public void setVisible() {
        visibility = true;
    }
}
