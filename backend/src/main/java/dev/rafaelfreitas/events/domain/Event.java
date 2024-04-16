package dev.rafaelfreitas.events.domain;


import java.time.LocalDate;

public class Event {
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    private Integer institutionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isValid() {
        if (startDate == null || endDate == null || institutionId == null) {
            return false;
        }
        if ( (startDate.isBefore(LocalDate.now()) || startDate.isEqual(LocalDate.now())) && startDate.isAfter(endDate)) {
            return false;
        }
        return !endDate.isBefore(startDate);
    }

    public void validate() throws IllegalArgumentException {
        if (!isValid()) {
            throw new IllegalArgumentException("Invalid event");
        }
    }
}
