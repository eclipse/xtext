/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getJavaImport()
 * @model
 * @generated
 */
public interface JavaImport extends Import
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute list.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#getJavaImport_Path()
   * @model unique="false"
   * @generated
   */
  EList<String> getPath();

} // JavaImport
