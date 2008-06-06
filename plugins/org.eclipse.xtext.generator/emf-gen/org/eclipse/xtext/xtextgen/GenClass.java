/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenClass.java,v 1.1 2008/06/06 16:15:41 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.GenClass#getGenClassFQName <em>Gen Class FQ Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenClass()
 * @model
 * @generated
 */
public interface GenClass extends RootTemplate {
    /**
     * Returns the value of the '<em><b>Gen Class FQ Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Gen Class FQ Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Gen Class FQ Name</em>' attribute.
     * @see #setGenClassFQName(String)
     * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getGenClass_GenClassFQName()
     * @model
     * @generated
     */
    String getGenClassFQName();

    /**
     * Sets the value of the '{@link org.eclipse.xtext.xtextgen.GenClass#getGenClassFQName <em>Gen Class FQ Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Gen Class FQ Name</em>' attribute.
     * @see #getGenClassFQName()
     * @generated
     */
    void setGenClassFQName(String value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof GenServiceImpl) { return XtextgenUtil.genClassPackageFQName((GenServiceImpl) this);} else {return XtextgenUtil.genClassPackageFQName((GenClassImpl) this);}'"
     * @generated
     */
    String genClassPackageFQName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof GenServiceImpl) { return XtextgenUtil.genClassName((GenServiceImpl) this);} else {return XtextgenUtil.genClassName((GenClassImpl) this);}'"
     * @generated
     */
    String genClassName();

} // GenClass
