//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.30 at 08:26:12 AM CEST 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toAttachmentDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toAttachmentDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CRAttachmentData" type="{}CRAttachmentDataType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toAttachmentDataType", propOrder = {
    "crAttachmentData"
})
public class ToAttachmentDataType {

    @XmlElement(name = "CRAttachmentData", required = true)
    protected CRAttachmentDataType crAttachmentData;

    /**
     * Gets the value of the crAttachmentData property.
     * 
     * @return
     *     possible object is
     *     {@link CRAttachmentDataType }
     *     
     */
    public CRAttachmentDataType getCRAttachmentData() {
        return crAttachmentData;
    }

    /**
     * Sets the value of the crAttachmentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRAttachmentDataType }
     *     
     */
    public void setCRAttachmentData(CRAttachmentDataType value) {
        this.crAttachmentData = value;
    }

}
