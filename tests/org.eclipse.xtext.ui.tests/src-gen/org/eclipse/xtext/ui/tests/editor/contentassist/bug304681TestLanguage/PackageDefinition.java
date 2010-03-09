/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getPackageDefinition()
 * @model
 * @generated
 */
public interface PackageDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' attribute.
   * @see #setNamespace(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getPackageDefinition_Namespace()
   * @model
   * @generated
   */
  String getNamespace();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' attribute.
   * @see #getNamespace()
   * @generated
   */
  void setNamespace(String value);

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguagePackage#getPackageDefinition_Contents()
   * @model containment="true"
   * @generated
   */
  EList<org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object> getContents();

} // PackageDefinition
