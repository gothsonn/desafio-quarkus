package dev.rafaelfreitas.events.domain;

public class Institution {
    private Integer id;
    private String name;
    private InstitutionType type;

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

    public InstitutionType getType() {
        return type;
    }

    public void setType(InstitutionType type) {
        this.type = type;
        validateType();
    }

    private void validateType() {
        if(type == null) {
            throw new IllegalArgumentException("Invalid institution type.");
        }
    }
}