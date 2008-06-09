/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenModel.java,v 1.2 2008/06/09 12:52:54 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.Grammar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getModelFileExtensions <em>Model File Extensions</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getFileHeader <em>File Header</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getGrammar <em>Grammar</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getGrammarResourceURI <em>Grammar Resource URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getOutletMap <em>Outlet Map</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getLanguageInterfaceFQName <em>Language Interface FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getStandaloneSetupClassFQName <em>Standalone Setup Class FQ Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getNonUIPluginBundleID <em>Non UI Plugin Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getUiPluginBundleID <em>Ui Plugin Bundle ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel()
 * @model
 * @generated
 */
public interface GenModel extends EObject {
    /**
     * Returns the value of the '<em><b>Model File Extensions</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Model File Extensions</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Model File Extensions</em>' attribute list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_ModelFileExtensions()
     * @model
     * @generated
     */
    EList<String> getModelFileExtensions();

    /**
     * Returns the value of the '<em><b>File Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Header</em>' attribute.
     * @see #setFileHeader(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_FileHeader()
     * @model
     * @generated
     */
    String getFileHeader();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getFileHeader <em>File Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Header</em>' attribute.
     * @see #getFileHeader()
     * @generated
     */
    void setFileHeader(String value);

    /**
     * Returns the value of the '<em><b>Grammar</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grammar</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grammar</em>' reference.
     * @see #setGrammar(Grammar)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_Grammar()
     * @model
     * @generated
     */
    Grammar getGrammar();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getGrammar <em>Grammar</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grammar</em>' reference.
     * @see #getGrammar()
     * @generated
     */
    void setGrammar(Grammar value);

    /**
     * Returns the value of the '<em><b>Grammar Resource URI</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grammar Resource URI</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grammar Resource URI</em>' attribute.
     * @see #setGrammarResourceURI(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_GrammarResourceURI()
     * @model transient="true"
     * @generated
     */
    String getGrammarResourceURI();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getGrammarResourceURI <em>Grammar Resource URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grammar Resource URI</em>' attribute.
     * @see #getGrammarResourceURI()
     * @generated
     */
    void setGrammarResourceURI(String value);

    /**
     * Returns the value of the '<em><b>Services</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.xtext.xtextgen.GenService}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Services</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Services</em>' reference list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_Services()
     * @model
     * @generated
     */
    EList<GenService> getServices();

    /**
     * Returns the value of the '<em><b>Outlet Map</b></em>' reference list.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outlet Map</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outlet Map</em>' reference list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_OutletMap()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getOutletMap();

    /**
     * Returns the value of the '<em><b>Ui Plugin Bundle ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ui Plugin Bundle ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ui Plugin Bundle ID</em>' attribute.
     * @see #setUiPluginBundleID(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_UiPluginBundleID()
     * @model
     * @generated
     */
    String getUiPluginBundleID();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getUiPluginBundleID <em>Ui Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ui Plugin Bundle ID</em>' attribute.
     * @see #getUiPluginBundleID()
     * @generated
     */
    void setUiPluginBundleID(String value);

    /**
     * Returns the value of the '<em><b>Language Interface FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language Interface FQ Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Language Interface FQ Name</em>' attribute.
     * @see #setLanguageInterfaceFQName(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_LanguageInterfaceFQName()
     * @model
     * @generated
     */
    String getLanguageInterfaceFQName();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getLanguageInterfaceFQName <em>Language Interface FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language Interface FQ Name</em>' attribute.
     * @see #getLanguageInterfaceFQName()
     * @generated
     */
    void setLanguageInterfaceFQName(String value);

    /**
     * Returns the value of the '<em><b>Standalone Setup Class FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Standalone Setup Class FQ Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Standalone Setup Class FQ Name</em>' attribute.
     * @see #setStandaloneSetupClassFQName(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_StandaloneSetupClassFQName()
     * @model
     * @generated
     */
    String getStandaloneSetupClassFQName();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getStandaloneSetupClassFQName <em>Standalone Setup Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Standalone Setup Class FQ Name</em>' attribute.
     * @see #getStandaloneSetupClassFQName()
     * @generated
     */
    void setStandaloneSetupClassFQName(String value);

    /**
     * Returns the value of the '<em><b>Non UI Plugin Bundle ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Non UI Plugin Bundle ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Non UI Plugin Bundle ID</em>' attribute.
     * @see #setNonUIPluginBundleID(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_NonUIPluginBundleID()
     * @model
     * @generated
     */
    String getNonUIPluginBundleID();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenModel#getNonUIPluginBundleID <em>Non UI Plugin Bundle ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Non UI Plugin Bundle ID</em>' attribute.
     * @see #getNonUIPluginBundleID()
     * @generated
     */
    void setNonUIPluginBundleID(String value);

} // GenModel
