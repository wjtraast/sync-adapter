//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.04 at 06:15:41 PM CEST 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for externalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="externalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NSDictionary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "externalInfoType", propOrder = {
    "nsDictionary"
})
public class ExternalInfoType {

    @XmlElement(name = "NSDictionary", required = true)
    protected String nsDictionary;

    /**
     * Gets the value of the nsDictionary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSDictionary() {
        return nsDictionary;
    }

    /**
     * Sets the value of the nsDictionary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSDictionary(String value) {
        this.nsDictionary = value;
    }

}
