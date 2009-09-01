/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MQ Lquery</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getSelectEntries <em>Select Entries</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getFromEntries <em>From Entries</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.MQLquery#getWhereEntries <em>Where Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getMQLquery()
 * @model
 * @generated
 */
public interface MQLquery extends EObject
{
  /**
   * Returns the value of the '<em><b>Select Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.SelectEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Select Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Select Entries</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getMQLquery_SelectEntries()
   * @model containment="true"
   * @generated
   */
  EList<SelectEntry> getSelectEntries();

  /**
   * Returns the value of the '<em><b>From Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.FromEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From Entries</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getMQLquery_FromEntries()
   * @model containment="true"
   * @generated
   */
  EList<FromEntry> getFromEntries();

  /**
   * Returns the value of the '<em><b>Where Entries</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.WhereEntry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Where Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Where Entries</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug287941TestLanguage.Bug287941TestLanguagePackage#getMQLquery_WhereEntries()
   * @model containment="true"
   * @generated
   */
  EList<WhereEntry> getWhereEntries();

} // MQLquery
