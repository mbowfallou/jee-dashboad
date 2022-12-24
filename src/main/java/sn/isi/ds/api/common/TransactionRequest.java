package sn.isi.ds.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.ds.api.entity.DashboardEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private AppUser appUser;
}
