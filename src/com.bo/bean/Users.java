package com.bo.bean;

public class Users {
    //创建用户信息表
        private String user;
        private String password;
        private String privilege;

        public Users() {
        }

        public Users(String user, String password, String privilege) {
            this.user = user;
            this.password = password;
            this.privilege = privilege;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPrivilege() {
            return privilege;
        }

        public void setPrivilege(String privilege) {
            this.privilege = privilege;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Users users = (Users) o;

            if (!user.equals(users.user)) return false;
            if (!password.equals(users.password)) return false;
            return privilege.equals(users.privilege);
        }

        @Override
        public String toString() {
            return "Users{" +
                    "user='" + user + '\'' +
                    ", password='" + password + '\'' +
                    ", privilege='" + privilege + '\'' +
                    '}';
        }
    }


