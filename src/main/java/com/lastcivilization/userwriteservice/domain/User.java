package com.lastcivilization.userwriteservice.domain;

class User {

    private Long id;
    private String keycloakId;
    private String login;
    private String email;
    private long stats;
    private long equipment;
    private long account;

    User(Long id, String keycloakId, String login, String email, long stats, long equipment, long account) {
        this.id = id;
        this.keycloakId = keycloakId;
        this.login = login;
        this.email = email;
        this.stats = stats;
        this.equipment = equipment;
        this.account = account;
    }

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getKeycloakId() {
        return keycloakId;
    }

    void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }

    String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    Long getStats() {
        return stats;
    }

    void setStats(long stats) {
        this.stats = stats;
    }

    Long getEquipment() {
        return equipment;
    }

    void setEquipment(long equipment) {
        this.equipment = equipment;
    }

    Long getAccount() {
        return account;
    }

    void setAccount(long account) {
        this.account = account;
    }

    static final class Builder {

        private Long id;
        private String keycloakId;
        private String login;
        private String email;
        private long stats;
        private long equipment;
        private long account;

        private Builder() {
        }

        static Builder anUser() {
            return new Builder();
        }

        Builder id(Long id) {
            this.id = id;
            return this;
        }

        Builder keycloakId(String keycloakId) {
            this.keycloakId = keycloakId;
            return this;
        }

        Builder login(String login) {
            this.login = login;
            return this;
        }

        Builder email(String email) {
            this.email = email;
            return this;
        }

        Builder stats(long stats) {
            this.stats = stats;
            return this;
        }

        Builder equipment(long equipment) {
            this.equipment = equipment;
            return this;
        }

        Builder account(long account){
            this.account = account;
            return this;
        }

        User build() {
            return new User(id, keycloakId, login, email, stats, equipment, account);
        }
    }
}
