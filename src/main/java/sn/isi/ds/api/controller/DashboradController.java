package sn.isi.ds.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sn.isi.ds.api.common.AppUser;
import sn.isi.ds.api.common.TransactionRequest;
import sn.isi.ds.api.common.TransactionResponse;
import sn.isi.ds.api.service.DashboardService;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboradController {
    @Autowired
    private DashboardService service;

    @Autowired
    private RestTemplate template;

    @GetMapping("/users")
    public List<AppUser> getAppUsers(){
        return service.getAppUsers();
    }

    @GetMapping("/users/{id}")
    public TransactionResponse getAppUser(@PathVariable("id") int id){
        return service.getAppUserById(id);
    }

    @GetMapping("/users/account")
    public TransactionResponse getAppUser(@RequestBody TransactionRequest request){
        return service.getAppUser(request);
    }
}
