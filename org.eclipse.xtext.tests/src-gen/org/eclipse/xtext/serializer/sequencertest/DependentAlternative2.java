/**
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependent Alternative2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.DependentAlternative2#getVal <em>Val</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.DependentAlternative2#isFlag <em>Flag</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDependentAlternative2()
 * @model
 * @generated
 */
public interface DependentAlternative2 extends EObject
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute list.
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDependentAlternative2_Val()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal();

  /**
   * Returns the value of the '<em><b>Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flag</em>' attribute.
   * @see #setFlag(boolean)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getDependentAlternative2_Flag()
   * @model
   * @generated
   */
  boolean isFlag();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.DependentAlternative2#isFlag <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flag</em>' attribute.
   * @see #isFlag()
   * @generated
   */
  void setFlag(boolean value);

} // DependentAlternative2
