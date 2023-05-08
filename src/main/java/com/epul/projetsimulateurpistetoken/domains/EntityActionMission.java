package com.epul.projetsimulateurpistetoken.domains;

import jakarta.persistence.*;

@Entity
@Table(name = "action__mission", schema = "projetpermis1")
@IdClass(EntityActionMissionPK.class)
public class EntityActionMission {
    @Id
    @Column(name = "fk_action")
    private int fkAction;
    @Id
    @Column(name = "fk_mission")
    private int fkMission;
    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private EntityAction actionByFkAction;

    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private EntityMission missionByFkMission;
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
