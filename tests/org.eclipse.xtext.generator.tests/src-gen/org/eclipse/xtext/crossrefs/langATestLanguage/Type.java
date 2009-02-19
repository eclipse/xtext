/**
 * <copyright>
 * </copyright>
 *
 * $Id: Type.java,v 1.5 2009/02/19 21:10:07 sefftinge Exp $
 */
package org.eclipse.xtext.crossrefs.langATestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.crossrefs.langATestLanguage.Type#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.crossrefs.langATestLanguage.Type#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
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
   * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.crossrefs.langATestLanguage.Type#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(Type)
   * @see org.eclipse.xtext.crossrefs.langATestLanguage.LangATestLanguagePackage#getType_Extends()
   * @model
   * @generated
   */
  Type getExtends();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.crossrefs.langATestLanguage.Type#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(Type value);

} // Type
