/**
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.SingleEnum#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getSingleEnum()
 * @model
 * @generated
 */
public interface SingleEnum extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.serializer.sequencertest.DefEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see org.eclipse.xtext.serializer.sequencertest.DefEnum
   * @see #setVal(DefEnum)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getSingleEnum_Val()
   * @model
   * @generated
   */
  DefEnum getVal();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.SingleEnum#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see org.eclipse.xtext.serializer.sequencertest.DefEnum
   * @see #getVal()
   * @generated
   */
  void setVal(DefEnum value);

} // SingleEnum
