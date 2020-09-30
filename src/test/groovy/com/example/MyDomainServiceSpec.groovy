package com.example

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class MyDomainServiceSpec extends Specification implements ServiceUnitTest<MyDomainService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
