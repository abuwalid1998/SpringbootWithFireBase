package com.firebase.testing.springbootwithfirebase;

import com.google.cloud.firestore.Firestore;

public class ApplicationUserRep extends AbstractFirestoreRepository<ApplicationUser>{
    protected ApplicationUserRep(Firestore firestore, String collection) {
        super(firestore, collection);
    }
}
