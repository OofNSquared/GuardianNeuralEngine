package com.guardian.GuardianWorkflows.userworkflows;

public class UpdateUserRequest {

    private int id;
    private String email;

    public UpdateUserRequest(int id, String email) {
        if (isNullOrBlank(email)) throw new IllegalArgumentException("email cannot be null or blank");
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
        if (isNullOrBlank(email)) throw new IllegalArgumentException("email cannot be null or blank");
        this.email = email;
    }

    private boolean isNullOrBlank(String str) {
        return (str == null || str.isBlank());
    }

}