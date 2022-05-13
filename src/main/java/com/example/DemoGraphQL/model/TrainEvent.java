package com.example.DemoGraphQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TrainEvent {
    @Id
    @Column(name="event_id", nullable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long eventId;

    @Column(name="train_id", nullable = false)
    private Long trainId;

    @Column(name="current_station", nullable = false)
    private String currentStation;

    @Column(name="time", nullable = false)
    private String time;

    @Column(name = "next_station", nullable = false)
    private String nextStation;

    public TrainEvent() {
    }

    public TrainEvent(Long id) {
        this.eventId = id;
    }

    public TrainEvent(Long trainId, String currentStation, String time,String nextStation) {
        this.trainId = trainId;
        this.currentStation = currentStation;
        this.time = time;
        this.nextStation = nextStation;
    }

    public Long getId() {
        return eventId;
    }
    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(String currentStation) {
        this.currentStation = currentStation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNextStation() {
        return nextStation;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainEvent trainEvent = (TrainEvent) o;

        return eventId.equals(trainEvent.eventId);
    }

    @Override
    public int hashCode() {
        return eventId.hashCode();
    }

    @Override
    public String toString() {
        return "TrainEvent{" +
                "id=" + eventId +
                ", trainId='" + trainId + '\'' +
                ", currentStation='" + currentStation + '\'' +
                ", time='" + time + '\'' +
                ", nextStation='" + nextStation + '\'' +
                '}';
    }
}
