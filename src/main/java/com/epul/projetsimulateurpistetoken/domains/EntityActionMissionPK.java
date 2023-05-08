package com.epul.projetsimulateurpistetoken.domains;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class EntityActionMissionPK implements Serializable {
    @Column(name = "fk_action")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkAction;
    @Column(name = "fk_mission")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkMission;

    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityActionMissionPK that = (EntityActionMissionPK) o;

        if (fkAction != that.fkAction) return false;
        if (fkMission != that.fkMission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fkAction;
        result = 31 * result + fkMission;
        return result;
    }
}
