package com.epul.projetsimulateurpistetoken.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "indicator", schema = "projetpermis1", catalog = "")
public class EntityIndicator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_action")
    private int fkAction;
    @Basic
    @Column(name = "wording")
    private String wording;
    @Basic
    @Column(name = "valueIfCheck")
    private Integer valueIfCheck;
    @Basic
    @Column(name = "valueIfUnCheck")
    private Integer valueIfUnCheck;
    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false)
    private EntityAction actionByFkAction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityIndicator that = (EntityIndicator) o;

        if (id != that.id) return false;
        if (fkAction != that.fkAction) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;
        if (valueIfCheck != null ? !valueIfCheck.equals(that.valueIfCheck) : that.valueIfCheck != null) return false;
        if (valueIfUnCheck != null ? !valueIfUnCheck.equals(that.valueIfUnCheck) : that.valueIfUnCheck != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkAction;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (valueIfCheck != null ? valueIfCheck.hashCode() : 0);
        result = 31 * result + (valueIfUnCheck != null ? valueIfUnCheck.hashCode() : 0);
        return result;
    }

    public EntityAction getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(EntityAction actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }
}
