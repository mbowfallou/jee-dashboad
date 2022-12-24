package sn.isi.ds.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.ds.api.common.AppUser;
import sn.isi.ds.api.entity.DashboardEntity;

public interface DashboardRepository extends JpaRepository<DashboardEntity, Integer> {
}
