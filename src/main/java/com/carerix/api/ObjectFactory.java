//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.05 at 09:10:45 AM CEST 
//


package com.carerix.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.carerix.api package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NSException_QNAME = new QName("", "NSException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.carerix.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NSExceptionType }
     * 
     */
    public NSExceptionType createNSExceptionType() {
        return new NSExceptionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NSExceptionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NSException")
    public JAXBElement<NSExceptionType> createNSException(NSExceptionType value) {
        return new JAXBElement<NSExceptionType>(_NSException_QNAME, NSExceptionType.class, null, value);
    }

}
