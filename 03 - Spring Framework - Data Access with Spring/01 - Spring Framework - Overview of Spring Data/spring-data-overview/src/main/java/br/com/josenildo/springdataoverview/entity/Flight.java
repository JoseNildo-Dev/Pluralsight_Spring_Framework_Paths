package br.com.josenildo.springdataoverview.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long id;
    private String origin;
    private String destination;
    private LocalDateTime scheduleAt;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", scheduleAt=" + scheduleAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getScheduleAt() {
        return scheduleAt;
    }

    public void setScheduleAt(LocalDateTime scheduleAt) {
        this.scheduleAt = scheduleAt;
    }
}
