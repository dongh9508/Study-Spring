package com.donghun.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    @Autowired
    Proto proto;

//    @Autowired
//    private ObjectProvider<Proto> proto;

    public Proto getProto() {
        return proto;
//        return proto.getIfAvailable();
    }
}
