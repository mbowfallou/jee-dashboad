package sn.isi.ds.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardEntity {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;
}
