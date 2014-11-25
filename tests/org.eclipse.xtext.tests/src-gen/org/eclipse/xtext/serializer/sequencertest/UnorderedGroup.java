/**
 */
package org.eclipse.xtext.serializer.sequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unordered Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal4 <em>Val4</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedGroup()
 * @model
 * @generated
 */
public interface UnorderedGroup extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute.
   * @see #setVal1(String)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedGroup_Val1()
   * @model
   * @generated
   */
  String getVal1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal1 <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val1</em>' attribute.
   * @see #getVal1()
   * @generated
   */
  void setVal1(String value);

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute.
   * @see #setVal2(int)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedGroup_Val2()
   * @model
   * @generated
   */
  int getVal2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal2 <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val2</em>' attribute.
   * @see #getVal2()
   * @generated
   */
  void setVal2(int value);

  /**
   * Returns the value of the '<em><b>Val3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val3</em>' containment reference.
   * @see #setVal3(UnorderedGroupVal)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedGroup_Val3()
   * @model containment="true"
   * @generated
   */
  UnorderedGroupVal getVal3();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal3 <em>Val3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val3</em>' containment reference.
   * @see #getVal3()
   * @generated
   */
  void setVal3(UnorderedGroupVal value);

  /**
   * Returns the value of the '<em><b>Val4</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val4</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val4</em>' containment reference.
   * @see #setVal4(UnorderedGroupValDelegate)
   * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage#getUnorderedGroup_Val4()
   * @model containment="true"
   * @generated
   */
  UnorderedGroupValDelegate getVal4();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.sequencertest.UnorderedGroup#getVal4 <em>Val4</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val4</em>' containment reference.
   * @see #getVal4()
   * @generated
   */
  void setVal4(UnorderedGroupValDelegate value);

} // UnorderedGroup
