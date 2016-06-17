/**
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.List2#getVal1 <em>Val1</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getList2()
 * @model
 * @generated
 */
public interface List2 extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val1</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getList2_Val1()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal1();

} // List2
