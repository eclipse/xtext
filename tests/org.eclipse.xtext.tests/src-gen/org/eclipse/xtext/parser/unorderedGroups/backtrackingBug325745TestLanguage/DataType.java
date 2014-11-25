/**
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends EObject
{
  /**
   * Returns the value of the '<em><b>Base Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' attribute.
   * @see #setBaseType(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getDataType_BaseType()
   * @model
   * @generated
   */
  String getBaseType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getBaseType <em>Base Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Type</em>' attribute.
   * @see #getBaseType()
   * @generated
   */
  void setBaseType(String value);

  /**
   * Returns the value of the '<em><b>Default Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Value</em>' attribute.
   * @see #setDefaultValue(String)
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.BacktrackingBug325745TestLanguagePackage#getDataType_DefaultValue()
   * @model
   * @generated
   */
  String getDefaultValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.DataType#getDefaultValue <em>Default Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default Value</em>' attribute.
   * @see #getDefaultValue()
   * @generated
   */
  void setDefaultValue(String value);

} // DataType
