package cn.maitian.api.bean;

import cn.maitian.api.base.BaseBean;

/**
 * Created by geng on 2016/7/21.
 */
public class UserBean extends BaseBean {
    private NameBean name;
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

}
