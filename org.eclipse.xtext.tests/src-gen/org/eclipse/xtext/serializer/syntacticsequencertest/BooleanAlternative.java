/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Alternative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative#getBool <em>Bool</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage#getBooleanAlternative()
 * @model
 * @generated
 */
public interface BooleanAlternative extends EObject
{
  /**
   * Returns the value of the '<em><b>Bool</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool</em>' containment reference.
   * @see #setBool(BooleanAlternativeLiteral)
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage#getBooleanAlternative_Bool()
   * @model containment="true"
   * @generated
   */
  BooleanAlternativeLiteral getBool();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative#getBool <em>Bool</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool</em>' containment reference.
   * @see #getBool()
   * @generated
   */
  void setBool(BooleanAlternativeLiteral value);

} // BooleanAlternative
