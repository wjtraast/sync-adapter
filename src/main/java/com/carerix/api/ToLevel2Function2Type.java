//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.04 at 11:15:09 AM CEST 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toLevel2Function2Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toLevel2Function2Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CRDataNode" type="{}CRDataNodeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toLevel2Function2Type", propOrder = {
    "crDataNode"
})
public class ToLevel2Function2Type {

    @XmlElement(name = "CRDataNode", required = true)
    protected CRDataNode crDataNode;

    /**
     * Gets the value of the crDataNode property.
     * 
     * @return
     *     possible object is
     *     {@link CRDataNode }
     *     
     */
    public CRDataNode getCRDataNode() {
        return crDataNode;
    }

    /**
     * Sets the value of the crDataNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRDataNode }
     *     
     */
    public void setCRDataNode(CRDataNode value) {
        this.crDataNode = value;
    }

}
