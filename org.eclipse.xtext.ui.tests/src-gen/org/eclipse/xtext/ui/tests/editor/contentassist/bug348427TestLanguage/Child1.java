/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#isBool <em>Bool</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getChild1()
 * @model
 * @generated
 */
public interface Child1 extends EObject
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
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getChild1_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool</em>' attribute.
   * @see #setBool(boolean)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getChild1_Bool()
   * @model
   * @generated
   */
  boolean isBool();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#isBool <em>Bool</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool</em>' attribute.
   * @see #isBool()
   * @generated
   */
  void setBool(boolean value);

  /**
   * Returns the value of the '<em><b>Enum Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Type</em>' attribute.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType
   * @see #setEnumType(EnumType)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getChild1_EnumType()
   * @model
   * @generated
   */
  EnumType getEnumType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getEnumType <em>Enum Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Type</em>' attribute.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType
   * @see #getEnumType()
   * @generated
   */
  void setEnumType(EnumType value);

} // Child1
