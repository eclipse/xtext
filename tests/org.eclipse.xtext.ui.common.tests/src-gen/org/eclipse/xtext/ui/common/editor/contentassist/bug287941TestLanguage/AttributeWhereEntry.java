/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAttributeWhereEntry()
 * @model
 * @generated
 */
public interface AttributeWhereEntry extends WhereEntry
{
  /**
   * Returns the value of the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' reference.
   * @see #setAlias(FromEntry)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAttributeWhereEntry_Alias()
   * @model
   * @generated
   */
  FromEntry getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(FromEntry value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(EAttribute)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAttributeWhereEntry_Attribute()
   * @model
   * @generated
   */
  EAttribute getAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AttributeWhereEntry#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(EAttribute value);

} // AttributeWhereEntry
