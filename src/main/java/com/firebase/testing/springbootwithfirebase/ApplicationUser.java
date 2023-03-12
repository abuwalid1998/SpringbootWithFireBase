package com.firebase.testing.springbootwithfirebase;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    @DocumentId
    private String id;
    private String username;
    private String password;
    private String imageUrl;
    private String bio;

}