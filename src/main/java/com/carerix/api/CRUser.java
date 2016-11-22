//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 10:01:23 AM CET 
//


package com.carerix.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CRUserType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CRUserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalInfo" type="{}additionalInfoType"/>
 *         &lt;element name="addressUseCompanyMailingAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emailNotificationPopup" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="forwardEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="homeFullAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isEmailInConfidential" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isEmailOutConfidential" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isLoginBlocked" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isMasterUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isNewUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isTbaActive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isTokenHomeActive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isTokenRoadActive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isTokenWorkActive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastContactDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mailboxFlags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modificationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="previewDelay" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visitAddressUseCompanyVisitAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="wantsCookie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toCountryNode" type="{}toCountryNodeType"/>
 *         &lt;element name="toFunctionNode" type="{}toFunctionNodeType"/>
 *         &lt;element name="toGenderNode" type="{}toGenderNodeType"/>
 *         &lt;element name="toHomeCountryNode" type="{}toHomeCountryNodeType"/>
 *         &lt;element name="toHomeProvinceNode" type="{}toHomeProvinceNodeType"/>
 *         &lt;element name="toLanguageNode" type="{}toLanguageNodeType"/>
 *         &lt;element name="toProductNode" type="{}toProductNodeType"/>
 *         &lt;element name="toProvinceNode" type="{}toProvinceNodeType"/>
 *         &lt;element name="toSalutationNode" type="{}toSalutationNodeType"/>
 *         &lt;element name="toSingleStatusNode" type="{}toSingleStatusNodeType"/>
 *         &lt;element name="toSmtpServerNode" type="{}toSmtpServerNodeType"/>
 *         &lt;element name="toStatusNode" type="{}toStatusNodeType"/>
 *         &lt;element name="toTrialPeriodUnitNode" type="{}toTrialPeriodUnitNodeType"/>
 *         &lt;element name="toUserRole" type="{}toUserRoleType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRUserType", propOrder = {
    "additionalInfo",
    "addressUseCompanyMailingAddress",
    "creationDate",
    "deleted",
    "emailNotificationPopup",
    "firstName",
    "forwardEmail",
    "homeFullAddress",
    "isActive",
    "isEmailInConfidential",
    "isEmailOutConfidential",
    "isLoginBlocked",
    "isMasterUser",
    "isNewUser",
    "isTbaActive",
    "isTokenHomeActive",
    "isTokenRoadActive",
    "isTokenWorkActive",
    "lastContactDate",
    "jobTitle",
    "lastName",
    "mailboxFlags",
    "modificationDate",
    "password",
    "previewDelay",
    "userID",
    "userName",
    "visitAddressUseCompanyVisitAddress",
    "wantsCookie",
    "toCountryNode",
    "toFunctionNode",
    "toGenderNode",
    "toHomeCountryNode",
    "toHomeProvinceNode",
    "toLanguageNode",
    "toProductNode",
    "toProvinceNode",
    "toSalutationNode",
    "toSingleStatusNode",
    "toSmtpServerNode",
    "toStatusNode",
    "toTrialPeriodUnitNode",
    "toUserRole"
})
public class CRUser {

    @XmlElement(required = true)
    protected AdditionalInfoType additionalInfo;
    @XmlElement(required = true)
    protected String addressUseCompanyMailingAddress;
    @XmlElement(required = true)
    protected String creationDate;
    @XmlElement(required = true)
    protected String deleted;
    @XmlElement(required = true)
    protected String emailNotificationPopup;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String forwardEmail;
    @XmlElement(required = true)
    protected String homeFullAddress;
    @XmlElement(required = true)
    protected String isActive;
    @XmlElement(required = true)
    protected String isEmailInConfidential;
    @XmlElement(required = true)
    protected String isEmailOutConfidential;
    @XmlElement(required = true)
    protected String isLoginBlocked;
    @XmlElement(required = true)
    protected String isMasterUser;
    @XmlElement(required = true)
    protected String isNewUser;
    @XmlElement(required = true)
    protected String isTbaActive;
    @XmlElement(required = true)
    protected String isTokenHomeActive;
    @XmlElement(required = true)
    protected String isTokenRoadActive;
    @XmlElement(required = true)
    protected String isTokenWorkActive;
    @XmlElement(required = true)
    protected String lastContactDate;
    @XmlElement(required = true)
    protected String jobTitle;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String mailboxFlags;
    @XmlElement(required = true)
    protected String modificationDate;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String previewDelay;
    @XmlElement(required = true)
    protected String userID;
    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String visitAddressUseCompanyVisitAddress;
    @XmlElement(required = true)
    protected String wantsCookie;
    @XmlElement(required = true)
    protected ToCountryNodeType toCountryNode;
    @XmlElement(required = true)
    protected ToFunctionNodeType toFunctionNode;
    @XmlElement(required = true)
    protected ToGenderNode toGenderNode;
    @XmlElement(required = true)
    protected ToHomeCountryNodeType toHomeCountryNode;
    @XmlElement(required = true)
    protected ToHomeProvinceNodeType toHomeProvinceNode;
    @XmlElement(required = true)
    protected ToLanguageNodeType toLanguageNode;
    @XmlElement(required = true)
    protected ToProductNodeType toProductNode;
    @XmlElement(required = true)
    protected ToProvinceNodeType toProvinceNode;
    @XmlElement(required = true)
    protected ToSalutationNodeType toSalutationNode;
    @XmlElement(required = true)
    protected ToSingleStatusNodeType toSingleStatusNode;
    @XmlElement(required = true)
    protected ToSmtpServerNodeType toSmtpServerNode;
    @XmlElement(required = true)
    protected ToStatusNodeType toStatusNode;
    @XmlElement(required = true)
    protected ToTrialPeriodUnitNodeType toTrialPeriodUnitNode;
    @XmlElement(required = true)
    protected ToUserRoleType toUserRole;
    @XmlAttribute
    protected String id;

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInfoType }
     *     
     */
    public AdditionalInfoType getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInfoType }
     *     
     */
    public void setAdditionalInfo(AdditionalInfoType value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the addressUseCompanyMailingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressUseCompanyMailingAddress() {
        return addressUseCompanyMailingAddress;
    }

    /**
     * Sets the value of the addressUseCompanyMailingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressUseCompanyMailingAddress(String value) {
        this.addressUseCompanyMailingAddress = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleted(String value) {
        this.deleted = value;
    }

    /**
     * Gets the value of the emailNotificationPopup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailNotificationPopup() {
        return emailNotificationPopup;
    }

    /**
     * Sets the value of the emailNotificationPopup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailNotificationPopup(String value) {
        this.emailNotificationPopup = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the forwardEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardEmail() {
        return forwardEmail;
    }

    /**
     * Sets the value of the forwardEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardEmail(String value) {
        this.forwardEmail = value;
    }

    /**
     * Gets the value of the homeFullAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeFullAddress() {
        return homeFullAddress;
    }

    /**
     * Sets the value of the homeFullAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeFullAddress(String value) {
        this.homeFullAddress = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsActive(String value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the isEmailInConfidential property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEmailInConfidential() {
        return isEmailInConfidential;
    }

    /**
     * Sets the value of the isEmailInConfidential property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEmailInConfidential(String value) {
        this.isEmailInConfidential = value;
    }

    /**
     * Gets the value of the isEmailOutConfidential property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsEmailOutConfidential() {
        return isEmailOutConfidential;
    }

    /**
     * Sets the value of the isEmailOutConfidential property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsEmailOutConfidential(String value) {
        this.isEmailOutConfidential = value;
    }

    /**
     * Gets the value of the isLoginBlocked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLoginBlocked() {
        return isLoginBlocked;
    }

    /**
     * Sets the value of the isLoginBlocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLoginBlocked(String value) {
        this.isLoginBlocked = value;
    }

    /**
     * Gets the value of the isMasterUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsMasterUser() {
        return isMasterUser;
    }

    /**
     * Sets the value of the isMasterUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMasterUser(String value) {
        this.isMasterUser = value;
    }

    /**
     * Gets the value of the isNewUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsNewUser() {
        return isNewUser;
    }

    /**
     * Sets the value of the isNewUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsNewUser(String value) {
        this.isNewUser = value;
    }

    /**
     * Gets the value of the isTbaActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTbaActive() {
        return isTbaActive;
    }

    /**
     * Sets the value of the isTbaActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTbaActive(String value) {
        this.isTbaActive = value;
    }

    /**
     * Gets the value of the isTokenHomeActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTokenHomeActive() {
        return isTokenHomeActive;
    }

    /**
     * Sets the value of the isTokenHomeActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTokenHomeActive(String value) {
        this.isTokenHomeActive = value;
    }

    /**
     * Gets the value of the isTokenRoadActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTokenRoadActive() {
        return isTokenRoadActive;
    }

    /**
     * Sets the value of the isTokenRoadActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTokenRoadActive(String value) {
        this.isTokenRoadActive = value;
    }

    /**
     * Gets the value of the isTokenWorkActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsTokenWorkActive() {
        return isTokenWorkActive;
    }

    /**
     * Sets the value of the isTokenWorkActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsTokenWorkActive(String value) {
        this.isTokenWorkActive = value;
    }

    /**
     * Gets the value of the lastContactDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastContactDate() {
        return lastContactDate;
    }

    /**
     * Sets the value of the lastContactDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastContactDate(String value) {
        this.lastContactDate = value;
    }

    /**
     * Gets the value of the jobTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the value of the jobTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTitle(String value) {
        this.jobTitle = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the mailboxFlags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailboxFlags() {
        return mailboxFlags;
    }

    /**
     * Sets the value of the mailboxFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailboxFlags(String value) {
        this.mailboxFlags = value;
    }

    /**
     * Gets the value of the modificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModificationDate() {
        return modificationDate;
    }

    /**
     * Sets the value of the modificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModificationDate(String value) {
        this.modificationDate = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the previewDelay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewDelay() {
        return previewDelay;
    }

    /**
     * Sets the value of the previewDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewDelay(String value) {
        this.previewDelay = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the visitAddressUseCompanyVisitAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitAddressUseCompanyVisitAddress() {
        return visitAddressUseCompanyVisitAddress;
    }

    /**
     * Sets the value of the visitAddressUseCompanyVisitAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitAddressUseCompanyVisitAddress(String value) {
        this.visitAddressUseCompanyVisitAddress = value;
    }

    /**
     * Gets the value of the wantsCookie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWantsCookie() {
        return wantsCookie;
    }

    /**
     * Sets the value of the wantsCookie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWantsCookie(String value) {
        this.wantsCookie = value;
    }

    /**
     * Gets the value of the toCountryNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToCountryNodeType }
     *     
     */
    public ToCountryNodeType getToCountryNode() {
        return toCountryNode;
    }

    /**
     * Sets the value of the toCountryNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToCountryNodeType }
     *     
     */
    public void setToCountryNode(ToCountryNodeType value) {
        this.toCountryNode = value;
    }

    /**
     * Gets the value of the toFunctionNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToFunctionNodeType }
     *     
     */
    public ToFunctionNodeType getToFunctionNode() {
        return toFunctionNode;
    }

    /**
     * Sets the value of the toFunctionNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToFunctionNodeType }
     *     
     */
    public void setToFunctionNode(ToFunctionNodeType value) {
        this.toFunctionNode = value;
    }

    /**
     * Gets the value of the toGenderNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToGenderNode }
     *     
     */
    public ToGenderNode getToGenderNode() {
        return toGenderNode;
    }

    /**
     * Sets the value of the toGenderNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToGenderNode }
     *     
     */
    public void setToGenderNode(ToGenderNode value) {
        this.toGenderNode = value;
    }

    /**
     * Gets the value of the toHomeCountryNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToHomeCountryNodeType }
     *     
     */
    public ToHomeCountryNodeType getToHomeCountryNode() {
        return toHomeCountryNode;
    }

    /**
     * Sets the value of the toHomeCountryNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToHomeCountryNodeType }
     *     
     */
    public void setToHomeCountryNode(ToHomeCountryNodeType value) {
        this.toHomeCountryNode = value;
    }

    /**
     * Gets the value of the toHomeProvinceNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToHomeProvinceNodeType }
     *     
     */
    public ToHomeProvinceNodeType getToHomeProvinceNode() {
        return toHomeProvinceNode;
    }

    /**
     * Sets the value of the toHomeProvinceNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToHomeProvinceNodeType }
     *     
     */
    public void setToHomeProvinceNode(ToHomeProvinceNodeType value) {
        this.toHomeProvinceNode = value;
    }

    /**
     * Gets the value of the toLanguageNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToLanguageNodeType }
     *     
     */
    public ToLanguageNodeType getToLanguageNode() {
        return toLanguageNode;
    }

    /**
     * Sets the value of the toLanguageNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToLanguageNodeType }
     *     
     */
    public void setToLanguageNode(ToLanguageNodeType value) {
        this.toLanguageNode = value;
    }

    /**
     * Gets the value of the toProductNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToProductNodeType }
     *     
     */
    public ToProductNodeType getToProductNode() {
        return toProductNode;
    }

    /**
     * Sets the value of the toProductNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToProductNodeType }
     *     
     */
    public void setToProductNode(ToProductNodeType value) {
        this.toProductNode = value;
    }

    /**
     * Gets the value of the toProvinceNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToProvinceNodeType }
     *     
     */
    public ToProvinceNodeType getToProvinceNode() {
        return toProvinceNode;
    }

    /**
     * Sets the value of the toProvinceNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToProvinceNodeType }
     *     
     */
    public void setToProvinceNode(ToProvinceNodeType value) {
        this.toProvinceNode = value;
    }

    /**
     * Gets the value of the toSalutationNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToSalutationNodeType }
     *     
     */
    public ToSalutationNodeType getToSalutationNode() {
        return toSalutationNode;
    }

    /**
     * Sets the value of the toSalutationNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToSalutationNodeType }
     *     
     */
    public void setToSalutationNode(ToSalutationNodeType value) {
        this.toSalutationNode = value;
    }

    /**
     * Gets the value of the toSingleStatusNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToSingleStatusNodeType }
     *     
     */
    public ToSingleStatusNodeType getToSingleStatusNode() {
        return toSingleStatusNode;
    }

    /**
     * Sets the value of the toSingleStatusNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToSingleStatusNodeType }
     *     
     */
    public void setToSingleStatusNode(ToSingleStatusNodeType value) {
        this.toSingleStatusNode = value;
    }

    /**
     * Gets the value of the toSmtpServerNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToSmtpServerNodeType }
     *     
     */
    public ToSmtpServerNodeType getToSmtpServerNode() {
        return toSmtpServerNode;
    }

    /**
     * Sets the value of the toSmtpServerNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToSmtpServerNodeType }
     *     
     */
    public void setToSmtpServerNode(ToSmtpServerNodeType value) {
        this.toSmtpServerNode = value;
    }

    /**
     * Gets the value of the toStatusNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToStatusNodeType }
     *     
     */
    public ToStatusNodeType getToStatusNode() {
        return toStatusNode;
    }

    /**
     * Sets the value of the toStatusNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToStatusNodeType }
     *     
     */
    public void setToStatusNode(ToStatusNodeType value) {
        this.toStatusNode = value;
    }

    /**
     * Gets the value of the toTrialPeriodUnitNode property.
     * 
     * @return
     *     possible object is
     *     {@link ToTrialPeriodUnitNodeType }
     *     
     */
    public ToTrialPeriodUnitNodeType getToTrialPeriodUnitNode() {
        return toTrialPeriodUnitNode;
    }

    /**
     * Sets the value of the toTrialPeriodUnitNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToTrialPeriodUnitNodeType }
     *     
     */
    public void setToTrialPeriodUnitNode(ToTrialPeriodUnitNodeType value) {
        this.toTrialPeriodUnitNode = value;
    }

    /**
     * Gets the value of the toUserRole property.
     * 
     * @return
     *     possible object is
     *     {@link ToUserRoleType }
     *     
     */
    public ToUserRoleType getToUserRole() {
        return toUserRole;
    }

    /**
     * Sets the value of the toUserRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToUserRoleType }
     *     
     */
    public void setToUserRole(ToUserRoleType value) {
        this.toUserRole = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
