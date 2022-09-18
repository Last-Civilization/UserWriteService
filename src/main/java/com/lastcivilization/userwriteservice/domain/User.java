package com.lastcivilization.userwriteservice.domain;

class User {

    private Long id;
    private String keycloakId;
    private String login;
    private String email;
    private Long stats;
    private Long equipment;
    private Long account;

    public User(Long id, String keycloakId, String login, String email, Long stats, Long equipment, Long account) {
        this.id = id;
        this.keycloakId = keycloakId;
        this.login = login;
        this.email = email;
        this.stats = stats;
        this.equipment = equipment;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStats() {
        return stats;
    }

    public void setStats(Long stats) {
        this.stats = stats;
    }

    public Long getEquipment() {
        return equipment;
    }

    public void setEquipment(Long equipment) {
        this.equipment = equipment;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public static final class Builder {

        private Long id;
        private String keycloakId;
        private String login;
        private String email;
        private Long stats;
        private Long equipment;
        private Long account;

        private Builder() {
        }

        public static Builder anUser() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder keycloakId(String keycloakId) {
            this.keycloakId = keycloakId;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder stats(Long stats) {
            this.stats = stats;
            return this;
        }

        public Builder equipment(Long equipment) {
            this.equipment = equipment;
            return this;
        }

        public Builder account(Long account){
            this.account = account;
            return this;
        }

        public User build() {
            return new User(id, keycloakId, login, email, stats, equipment, account);
        }
    }
}
