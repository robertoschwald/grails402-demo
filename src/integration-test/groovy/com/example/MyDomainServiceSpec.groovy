package com.example

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MyDomainServiceSpec extends Specification {

    MyDomainService myDomainService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MyDomain(...).save(flush: true, failOnError: true)
        //new MyDomain(...).save(flush: true, failOnError: true)
        //MyDomain myDomain = new MyDomain(...).save(flush: true, failOnError: true)
        //new MyDomain(...).save(flush: true, failOnError: true)
        //new MyDomain(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //myDomain.id
    }

    void "test get"() {
        setupData()

        expect:
        myDomainService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MyDomain> myDomainList = myDomainService.list(max: 2, offset: 2)

        then:
        myDomainList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        myDomainService.count() == 5
    }

    void "test delete"() {
        Long myDomainId = setupData()

        expect:
        myDomainService.count() == 5

        when:
        myDomainService.delete(myDomainId)
        sessionFactory.currentSession.flush()

        then:
        myDomainService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MyDomain myDomain = new MyDomain()
        myDomainService.save(myDomain)

        then:
        myDomain.id != null
    }
}
