/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAlias <em>Right Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAttribute <em>Right Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getVariableWhereEntry()
 * @model
 * @generated
 */
public interface VariableWhereEntry extends AttributeWhereEntry
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator
   * @see #setOperator(NumericOperator)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getVariableWhereEntry_Operator()
   * @model
   * @generated
   */
  NumericOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.NumericOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(NumericOperator value);

  /**
   * Returns the value of the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Alias</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Alias</em>' reference.
   * @see #setRightAlias(FromEntry)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getVariableWhereEntry_RightAlias()
   * @model
   * @generated
   */
  FromEntry getRightAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAlias <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Alias</em>' reference.
   * @see #getRightAlias()
   * @generated
   */
  void setRightAlias(FromEntry value);

  /**
   * Returns the value of the '<em><b>Right Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Attribute</em>' reference.
   * @see #setRightAttribute(EAttribute)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getVariableWhereEntry_RightAttribute()
   * @model
   * @generated
   */
  EAttribute getRightAttribute();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.VariableWhereEntry#getRightAttribute <em>Right Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Attribute</em>' reference.
   * @see #getRightAttribute()
   * @generated
   */
  void setRightAttribute(EAttribute value);

} // VariableWhereEntry
