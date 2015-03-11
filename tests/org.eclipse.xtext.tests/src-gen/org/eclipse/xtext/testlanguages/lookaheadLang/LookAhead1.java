/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Look Ahead1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1()
 * @model
 * @generated
 */
public interface LookAhead1 extends Alts
{
  /**
   * Returns the value of the '<em><b>Y</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Y</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' containment reference.
   * @see #setY(LookAhead2)
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1_Y()
   * @model containment="true"
   * @generated
   */
  LookAhead2 getY();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getY <em>Y</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' containment reference.
   * @see #getY()
   * @generated
   */
  void setY(LookAhead2 value);

  /**
   * Returns the value of the '<em><b>Z</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Z</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Z</em>' attribute.
   * @see #setZ(String)
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1_Z()
   * @model
   * @generated
   */
  String getZ();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getZ <em>Z</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Z</em>' attribute.
   * @see #getZ()
   * @generated
   */
  void setZ(String value);

} // LookAhead1
