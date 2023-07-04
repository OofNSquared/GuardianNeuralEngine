package com.guardian.GuardianWorkflows.userworkflows;

public abstract class UserRequests {

    private int id;
    private String email;


    public UserRequests(int id, String email) {
        this.id = id;
        this.email = email;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }
    

}