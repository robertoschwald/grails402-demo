package com.example

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MyDomainController {

    MyDomainService myDomainService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        log.warn("bla")
        respond myDomainService.list(params), model:[myDomainCount: myDomainService.count()]
    }

    def show(Long id) {
        respond myDomainService.get(id)
    }

    def create() {
        respond new MyDomain(params)
    }

    def save(MyDomain myDomain) {
        if (myDomain == null) {
            notFound()
            return
        }

        try {
            myDomainService.save(myDomain)
        } catch (ValidationException e) {
            respond myDomain.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'myDomain.label', default: 'MyDomain'), myDomain.id])
                redirect myDomain
            }
            '*' { respond myDomain, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond myDomainService.get(id)
    }

    def update(MyDomain myDomain) {
        if (myDomain == null) {
            notFound()
            return
        }

        try {
            myDomainService.save(myDomain)
        } catch (ValidationException e) {
            respond myDomain.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'myDomain.label', default: 'MyDomain'), myDomain.id])
                redirect myDomain
            }
            '*'{ respond myDomain, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        myDomainService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'myDomain.label', default: 'MyDomain'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'myDomain.label', default: 'MyDomain'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
