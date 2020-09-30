package com.example

class MyDomain {

    String firstName
    String lastName

    static constraints = {
        firstName nullable:true
        lastName nullable:true
    }
}
