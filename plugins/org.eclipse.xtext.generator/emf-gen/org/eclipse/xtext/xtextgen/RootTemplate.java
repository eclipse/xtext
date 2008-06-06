/**
 * <copyright>
 * </copyright>
 *
 * $Id: RootTemplate.java,v 1.1 2008/06/06 16:15:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.RootTemplate#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.RootTemplate#getGenParameters <em>Gen Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getRootTemplate()
 * @model
 * @generated
 */
public interface RootTemplate extends EObject {
    /**
     * Returns the value of the '<em><b>Template Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template Path</em>' attribute.
     * @see #isSetTemplatePath()
     * @see #unsetTemplatePath()
     * @see #setTemplatePath(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getRootTemplate_TemplatePath()
     * @model unsettable="true"
     * @generated
     */
    String getTemplatePath();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.RootTemplate#getTemplatePath <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template Path</em>' attribute.
     * @see #isSetTemplatePath()
     * @see #unsetTemplatePath()
     * @see #getTemplatePath()
     * @generated
     */
    void setTemplatePath(String value);

    /**
     * Unsets the value of the '{@link org.eclipse.xtext.xtextgen.RootTemplate#getTemplatePath <em>Template Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetTemplatePath()
     * @see #getTemplatePath()
     * @see #setTemplatePath(String)
     * @generated
     */
    void unsetTemplatePath();

    /**
     * Returns whether the value of the '{@link org.eclipse.xtext.xtextgen.RootTemplate#getTemplatePath <em>Template Path</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Template Path</em>' attribute is set.
     * @see #unsetTemplatePath()
     * @see #getTemplatePath()
     * @see #setTemplatePath(String)
     * @generated
     */
    boolean isSetTemplatePath();

    /**
     * Returns the value of the '<em><b>Gen Parameters</b></em>' reference list.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Parameters</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gen Parameters</em>' reference list.
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getRootTemplate_GenParameters()
     * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<String, String> getGenParameters();

} // RootTemplate
