/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.encoding.encodingTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.encoding.encodingTest.Model#getWords <em>Words</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.encoding.encodingTest.EncodingTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Words</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Words</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Words</em>' attribute list.
   * @see org.eclipse.xtext.parser.encoding.encodingTest.EncodingTestPackage#getModel_Words()
   * @model unique="false"
   * @generated
   */
  EList<String> getWords();

} // Model
