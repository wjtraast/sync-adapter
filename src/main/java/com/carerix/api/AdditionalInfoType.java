//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.13 at 09:54:33 PM CEST 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for additionalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="additionalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NSDictionary" type="{}NSDictionaryType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "additionalInfoType", propOrder = {
    "nsDictionary"
})
public class AdditionalInfoType {

    @XmlElement(name = "NSDictionary", required = true)
    protected NSDictionaryType nsDictionary;

    /**
     * Gets the value of the nsDictionary property.
     * 
     * @return
     *     possible object is
     *     {@link NSDictionaryType }
     *     
     */
    public NSDictionaryType getNSDictionary() {
        return nsDictionary;
    }

    /**
     * Sets the value of the nsDictionary property.
     * 
     * @param value
     *     allowed object is
     *     {@link NSDictionaryType }
     *     
     */
    public void setNSDictionary(NSDictionaryType value) {
        this.nsDictionary = value;
    }

}
