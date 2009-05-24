/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.index.indexTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.File#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.File#getNameSpaces <em>Name Spaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.index.indexTestLanguage.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getFile_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Name Spaces</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.index.indexTestLanguage.Namespace}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name Spaces</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name Spaces</em>' containment reference list.
   * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getFile_NameSpaces()
   * @model containment="true"
   * @generated
   */
  EList<Namespace> getNameSpaces();

} // File
