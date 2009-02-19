/**
 * <copyright>
 * </copyright>
 *
 * $Id: Thing.java,v 1.4 2009/02/19 16:27:01 sefftinge Exp $
 */
package org.eclipse.xtext.testlanguages.actionLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Thing#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Thing#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getThing()
 * @model
 * @generated
 */
public interface Thing extends Type
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(Type)
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getThing_Content()
   * @model containment="true"
   * @generated
   */
  Type getContent();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang.Thing#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(Type value);

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
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getThing_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang.Thing#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Thing
