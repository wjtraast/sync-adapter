//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.25 at 08:39:41 AM CET 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toFunction3Level1NodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toFunction3Level1NodeType">
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
@XmlType(name = "toFunction3Level1NodeType", propOrder = {
    "crDataNode"
})
public class ToFunction3Level1NodeType {

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
