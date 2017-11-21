package server.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "iot", schema = "pocsm")
public class IotEntity {
    private int id;
    private Integer reference;
    private Integer value;
    private Timestamp date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reference")
    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "value")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IotEntity iotEntity = (IotEntity) o;

        if (id != iotEntity.id) return false;
        if (reference != null ? !reference.equals(iotEntity.reference) : iotEntity.reference != null) return false;
        if (value != null ? !value.equals(iotEntity.value) : iotEntity.value != null) return false;
        if (date != null ? !date.equals(iotEntity.date) : iotEntity.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
