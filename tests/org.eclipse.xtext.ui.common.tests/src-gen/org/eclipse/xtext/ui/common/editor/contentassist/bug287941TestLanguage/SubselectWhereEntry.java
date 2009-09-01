/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subselect Where Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#isNotIn <em>Not In</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getSubselectWhereEntry()
 * @model
 * @generated
 */
public interface SubselectWhereEntry extends WhereEntry
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
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getSubselectWhereEntry_Alias()
   * @model
   * @generated
   */
  FromEntry getAlias();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(FromEntry value);

  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(EReference)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getSubselectWhereEntry_Reference()
   * @model
   * @generated
   */
  EReference getReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(EReference value);

  /**
   * Returns the value of the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Not In</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not In</em>' attribute.
   * @see #setNotIn(boolean)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getSubselectWhereEntry_NotIn()
   * @model
   * @generated
   */
  boolean isNotIn();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#isNotIn <em>Not In</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not In</em>' attribute.
   * @see #isNotIn()
   * @generated
   */
  void setNotIn(boolean value);

  /**
   * Returns the value of the '<em><b>Sub Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Query</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Query</em>' containment reference.
   * @see #setSubQuery(MQLquery)
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getSubselectWhereEntry_SubQuery()
   * @model containment="true"
   * @generated
   */
  MQLquery getSubQuery();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Query</em>' containment reference.
   * @see #getSubQuery()
   * @generated
   */
  void setSubQuery(MQLquery value);

} // SubselectWhereEntry
