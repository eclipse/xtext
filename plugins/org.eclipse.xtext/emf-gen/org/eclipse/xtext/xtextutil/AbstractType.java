/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractType.java,v 1.3 2008/05/15 14:38:04 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextutil.AbstractType#getEClassifier <em>EClassifier</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType()
 * @model abstract="true"
 * @generated
 */
public interface AbstractType extends EObject
{
  /**
	 * Returns the value of the '<em><b>EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EClassifier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>EClassifier</em>' reference.
	 * @see #setEClassifier(EClassifier)
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType_EClassifier()
	 * @model
	 * @generated
	 */
  EClassifier getEClassifier();

  /**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.AbstractType#getEClassifier <em>EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClassifier</em>' reference.
	 * @see #getEClassifier()
	 * @generated
	 */
  void setEClassifier(EClassifier value);

  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtextutil.XtextutilPackage#getAbstractType_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

} // AbstractType
