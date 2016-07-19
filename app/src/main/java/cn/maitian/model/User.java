package cn.maitian.model;

/**
 * Created by geng on 2016/7/19.
 */
public class User {
    /**
     * first : Joe
     * last : Sixpack
     */

    private NameBean name;
    /**
     * name : {"first":"Joe","last":"Sixpack"}
     * gender : MALE
     * verified : false
     * userImage : Rm9vYmFyIQ==
     */

    private String gender;
    private boolean verified;
    private String userImage;

    public NameBean getName() {
        return name;
    }

    public void setName(NameBean name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", gender='" + gender + '\'' +
                ", verified=" + verified +
                ", userImage='" + userImage + '\'' +
                '}';
    }

    public static class NameBean {
        private String first;
        private String last;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        @Override
        public String toString() {
            return "NameBean{" +
                    "first='" + first + '\'' +
                    ", last='" + last + '\'' +
                    '}';
        }
    }
}
