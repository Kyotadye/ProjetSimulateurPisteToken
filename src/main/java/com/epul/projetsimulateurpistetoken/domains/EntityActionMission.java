package com.epul.projetsimulateurpistetoken.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "action__mission", schema = "projetpermis1", catalog = "")
@IdClass(EntityActionMissionPK.class)
public class EntityActionMission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_action")
    private int fkAction;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_mission")
    private int fkMission;
    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false)
    private EntityAction actionByFkAction;

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

        EntityActionMission that = (EntityActionMission) o;

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

    public EntityAction getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(EntityAction actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }
}
