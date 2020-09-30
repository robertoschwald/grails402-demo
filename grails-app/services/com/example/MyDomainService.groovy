package com.example

import grails.gorm.services.Service

@Service(MyDomain)
interface MyDomainService {

    MyDomain get(Serializable id)

    List<MyDomain> list(Map args)

    Long count()

    void delete(Serializable id)

    MyDomain save(MyDomain myDomain)

}