/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alias Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getRightAlias <em>Right Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAliasWhereEntry()
 * @model
 * @generated
 */
public interface AliasWhereEntry extends WhereEntry
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
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAliasWhereEntry_Alias()
   * @model
   * @generated
   */
  FromEntry getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(FromEntry value);

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
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getAliasWhereEntry_RightAlias()
   * @model
   * @generated
   */
  FromEntry getRightAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.AliasWhereEntry#getRightAlias <em>Right Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Alias</em>' reference.
   * @see #getRightAlias()
   * @generated
   */
  void setRightAlias(FromEntry value);

} // AliasWhereEntry
