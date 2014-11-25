/**
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
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.File#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.index.indexTestLanguage.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getFile_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // File
