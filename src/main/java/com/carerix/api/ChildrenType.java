//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.30 at 09:04:52 AM CEST 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for childrenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="childrenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NSArray" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "childrenType", propOrder = {
    "nsArray"
})
public class ChildrenType {

    @XmlElement(name = "NSArray", required = true)
    protected String nsArray;

    /**
     * Gets the value of the nsArray property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSArray() {
        return nsArray;
    }

    /**
     * Sets the value of the nsArray property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSArray(String value) {
        this.nsArray = value;
    }

}
