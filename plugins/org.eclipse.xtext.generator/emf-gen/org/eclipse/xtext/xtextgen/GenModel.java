/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenModel.java,v 1.1 2008/06/06 16:15:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import java.util.Map.Entry;
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
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getRootTemplates <em>Root Templates</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenModel#getOutletMap <em>Outlet Map</em>}</li>
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
     * Returns the value of the '<em><b>Root Templates</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.xtext.xtextgen.RootTemplate}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Templates</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root Templates</em>' reference list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_RootTemplates()
     * @model
     * @generated
     */
    EList<RootTemplate> getRootTemplates();

    /**
     * Returns the value of the '<em><b>Outlet Map</b></em>' reference list.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outlet Map</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outlet Map</em>' reference list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenModel_OutletMap()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getOutletMap();

} // GenModel
