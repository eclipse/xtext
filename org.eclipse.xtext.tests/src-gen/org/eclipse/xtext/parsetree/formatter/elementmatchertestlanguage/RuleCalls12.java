/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Calls12</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCalls12()
 * @model
 * @generated
 */
public interface RuleCalls12 extends Model
{
  /**
   * Returns the value of the '<em><b>Constructor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constructor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constructor</em>' containment reference.
   * @see #setConstructor(Constructor)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCalls12_Constructor()
   * @model containment="true"
   * @generated
   */
  Constructor getConstructor();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12#getConstructor <em>Constructor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constructor</em>' containment reference.
   * @see #getConstructor()
   * @generated
   */
  void setConstructor(Constructor value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Field}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getRuleCalls12_Fields()
   * @model containment="true"
   * @generated
   */
  EList<Field> getFields();

} // RuleCalls12
