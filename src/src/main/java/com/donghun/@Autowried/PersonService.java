package com.donghun.pt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    com.donghun.pt2.PersonRepository personRepository;

    public void setPersonRepository(com.donghun.pt2.PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
