//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 08:14:09 PM CET 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toUserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CRUser" type="{}CRUserType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toUserType", propOrder = {
    "crUser"
})
public class ToUser {

    @XmlElement(name = "CRUser", required = true)
    protected CRUser crUser;

    /**
     * Gets the value of the crUser property.
     * 
     * @return
     *     possible object is
     *     {@link CRUser }
     *     
     */
    public CRUser getCRUser() {
        return crUser;
    }

    /**
     * Sets the value of the crUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRUser }
     *     
     */
    public void setCRUser(CRUser value) {
        this.crUser = value;
    }

}
