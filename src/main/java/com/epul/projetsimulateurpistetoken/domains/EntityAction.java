package com.epul.projetsimulateurpistetoken.domains;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "action", schema = "projetpermis1")
public class EntityAction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "fk_action", insertable = false, updatable = false)
    private Integer fkAction;

    @Basic
    @Column(name = "wording")
    private String wording;

    @Basic
    @Column(name = "scoreMinimum")
    private Integer scoreMinimum;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id")
    private EntityAction actionByFkAction;

    @OneToMany(mappedBy = "actionByFkAction")
    private Collection<EntityAction> actionsById;

    @OneToMany(mappedBy = "actionByFkAction")
    private Collection<EntityActionMission> actionMissionsById;

    @OneToMany(mappedBy = "actionByFkAction")
    private Collection<EntityIndicator> indicatorsById;

    @OneToMany(mappedBy = "actionByFkAction")
    private Collection<EntityInscriptionAction> inscriptionActionsById;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFkAction() {
        return fkAction;
    }

    public void setFkAction(Integer fkAction) {
        this.fkAction = fkAction;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityAction that = (EntityAction) o;

        if (id != that.id) return false;
        if (fkAction != null ? !fkAction.equals(that.fkAction) : that.fkAction != null) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;
        if (scoreMinimum != null ? !scoreMinimum.equals(that.scoreMinimum) : that.scoreMinimum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkAction != null ? fkAction.hashCode() : 0);
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (scoreMinimum != null ? scoreMinimum.hashCode() : 0);
        return result;
    }

    public EntityAction getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(EntityAction actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    public Collection<EntityAction> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<EntityAction> actionsById) {
        this.actionsById = actionsById;
    }

    public Collection<EntityActionMission> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<EntityActionMission> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    public Collection<EntityIndicator> getIndicatorsById() {
        return indicatorsById;
    }

    public void setIndicatorsById(Collection<EntityIndicator> indicatorsById) {
        this.indicatorsById = indicatorsById;
    }

    public Collection<EntityInscriptionAction> getInscriptionActionsById() {
        return inscriptionActionsById;
    }

    public void setInscriptionActionsById(Collection<EntityInscriptionAction> inscriptionActionsById) {
        this.inscriptionActionsById = inscriptionActionsById;
    }
}
