package com.maffy.example.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/10/13
 * Time: 6:45 PM
 */
public class Aircraft  implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    // db-related members, if I were going to deal with dbs tonight
    private Long id;
    private Date dateCreated;
    private Date lastUpdated;

    private String tail;
    private String nose;
    private String model;

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getNose() {
        return nose;
    }

    public void setNose(String nose) {
        this.nose = nose;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (dateCreated != null ? !dateCreated.equals(aircraft.dateCreated) : aircraft.dateCreated != null)
            return false;
        if (id != null ? !id.equals(aircraft.id) : aircraft.id != null) return false;
        if (lastUpdated != null ? !lastUpdated.equals(aircraft.lastUpdated) : aircraft.lastUpdated != null)
            return false;
        if (model != null ? !model.equals(aircraft.model) : aircraft.model != null) return false;
        if (nose != null ? !nose.equals(aircraft.nose) : aircraft.nose != null) return false;
        if (tail != null ? !tail.equals(aircraft.tail) : aircraft.tail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        result = 31 * result + (nose != null ? nose.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
