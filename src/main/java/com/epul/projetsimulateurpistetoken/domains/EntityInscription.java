package com.epul.projetsimulateurpistetoken.domains;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "inscription", schema = "projetpermis1")
public class EntityInscription {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_user")
    private int fkUser;
    @Basic
    @Column(name = "fk_mission")
    private int fkMission;
    @Basic
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "fk_mission", referencedColumnName = "id", insertable = false, updatable = false)
    private EntityMission missionByFkMission;
    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "NumUtil",  insertable = false, updatable = false)
    private EntityUtilisateur utilisateurByFkUser;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityInscription that = (EntityInscription) o;

        if (id != that.id) return false;
        if (fkUser != that.fkUser) return false;
        if (fkMission != that.fkMission) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkUser;
        result = 31 * result + fkMission;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
