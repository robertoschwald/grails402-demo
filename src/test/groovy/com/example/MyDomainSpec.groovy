package com.example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MyDomainSpec extends Specification implements DomainUnitTest<MyDomain> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
