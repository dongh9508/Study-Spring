package com.donghun.iocContainer_Bean;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class PhoneService {

    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone save(Phone phone) {
        phone.setCreated(new Date());
        phone.setPhoneStatus(PhoneStatus.IPHONE);
        return phoneRepository.save(phone);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("===========");
        System.out.println("Hello");
    }
}
