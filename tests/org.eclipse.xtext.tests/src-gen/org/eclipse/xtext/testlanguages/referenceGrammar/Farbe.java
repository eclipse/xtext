/**
 */
package org.eclipse.xtext.testlanguages.referenceGrammar;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farbe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.referenceGrammar.Farbe#getWert <em>Wert</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage#getFarbe()
 * @model
 * @generated
 */
public interface Farbe extends EObject
{
  /**
   * Returns the value of the '<em><b>Wert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Wert</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wert</em>' attribute.
   * @see #setWert(String)
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage#getFarbe_Wert()
   * @model
   * @generated
   */
  String getWert();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Farbe#getWert <em>Wert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wert</em>' attribute.
   * @see #getWert()
   * @generated
   */
  void setWert(String value);

} // Farbe
