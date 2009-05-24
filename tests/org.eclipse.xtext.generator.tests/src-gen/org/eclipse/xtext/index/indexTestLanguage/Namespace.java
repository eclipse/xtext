/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.index.indexTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.index.indexTestLanguage.Namespace#getNamedElements <em>Named Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getNamespace()
 * @model
 * @generated
 */
public interface Namespace extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Named Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.index.indexTestLanguage.NamedElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Elements</em>' containment reference list.
   * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguagePackage#getNamespace_NamedElements()
   * @model containment="true"
   * @generated
   */
  EList<NamedElement> getNamedElements();

} // Namespace
