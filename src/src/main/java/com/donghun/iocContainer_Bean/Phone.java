package com.donghun.iocContainer_Bean;

import java.util.Date;

public class Phone {

    private Date created;

    private PhoneStatus phoneStatus;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public PhoneStatus getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(PhoneStatus phoneStatus) {
        this.phoneStatus = phoneStatus;
    }
}
