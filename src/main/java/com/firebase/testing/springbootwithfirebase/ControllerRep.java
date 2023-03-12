package com.firebase.testing.springbootwithfirebase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ControllerRep {


    final
    PushNotificationService pushNotificationService;

    public ControllerRep(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping("/post")
    boolean postApi(@RequestBody ApplicationUser applicationUser) throws IOException {
        try {

            ApplicationUserRep applicationUserRep = new ApplicationUserRep(new FireStoreConfig().getFireStore(),"usersappid");
            PushNotificationRequest pushNotificationRequest = new PushNotificationRequest(applicationUser.getUsername()," Has Been Added To System ","","");

            pushNotificationService.wait(2000);
            pushNotificationService.sendPushNotificationToToken(pushNotificationRequest);

            return applicationUserRep.save(applicationUser);


        }catch (Exception e){
            PushNotificationRequest pushNotificationRequest = new PushNotificationRequest("Error Happen :- ",e.getMessage(),"","");
            pushNotificationService.sendPushNotificationToToken(pushNotificationRequest);
            return false;
        }




    }


}
