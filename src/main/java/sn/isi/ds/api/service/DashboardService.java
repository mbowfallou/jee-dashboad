package sn.isi.ds.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sn.isi.ds.api.common.AppUser;
import sn.isi.ds.api.common.TransactionRequest;
import sn.isi.ds.api.common.TransactionResponse;
import sn.isi.ds.api.entity.DashboardEntity;
//import sn.isi.ds.api.repository.DashboardRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class DashboardService {
    //@Autowired
    //private DashboardRepository repository;
    @Autowired
    private RestTemplate template;
    public TransactionResponse getAppUser(TransactionRequest request){
        String message = "";
        AppUser appUser = request.getAppUser();
        DashboardEntity dashboard = new DashboardEntity();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AppUser> entity = new HttpEntity<AppUser>(headers);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-COM-PERSIST", "NO");

        // REST Call
        ResponseEntity<AppUser> appUserResponse =template.exchange(
                "http://localhost:8081/users/account/"+appUser.getEmail()+"/"+appUser.getPassword(),
                HttpMethod.GET,
                entity,
                AppUser.class
        );

        if(appUserResponse != null) {
            message = "AppUser Successful Got";
            dashboard.setEmail(appUserResponse.getBody().getEmail());
            dashboard.setPassword(appUserResponse.getBody().getPassword());
        }else
            message = "There is a Failure in Admin-Service API";

        return new TransactionResponse(appUserResponse.getBody(), message);
    }

    public TransactionResponse getAppUserById(int id){
        String message = "There is a Failure in Admin-Service API";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AppUser> entity = new HttpEntity<AppUser>(headers);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-COM-PERSIST", "NO");

        // REST Call
        ResponseEntity<AppUser> appUserResponse =template.exchange(
                "http://localhost:8081/users/"+id,
                HttpMethod.GET,
                entity,
                AppUser.class
        );

        if(appUserResponse != null)
            message = "AppUser Successful Got";

        return new TransactionResponse(appUserResponse.getBody(), message);
    }

    public List<AppUser> getAppUsers(){
        String message = "There is a Failure in Admin-Service API";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AppUser> entity = new HttpEntity<AppUser>(headers);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-COM-PERSIST", "NO");

        // REST Call
         ResponseEntity<List<AppUser>> appUserResponse =template.exchange(
                "http://localhost:8081/users",
                HttpMethod.GET,
                entity,
                 new ParameterizedTypeReference<List<AppUser>>(){}
        );

        if(appUserResponse != null)
            message = "AppUser Successful Got";

        return appUserResponse.getBody();
    }
}
