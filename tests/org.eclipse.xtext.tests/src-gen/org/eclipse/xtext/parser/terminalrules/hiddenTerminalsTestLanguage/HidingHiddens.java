/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hiding Hiddens</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getSpace <em>Space</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getCalled <em>Called</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getHidingHiddens()
 * @model
 * @generated
 */
public interface HidingHiddens extends EObject
{
  /**
   * Returns the value of the '<em><b>Space</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Space</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Space</em>' attribute.
   * @see #setSpace(String)
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getHidingHiddens_Space()
   * @model
   * @generated
   */
  String getSpace();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getSpace <em>Space</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Space</em>' attribute.
   * @see #getSpace()
   * @generated
   */
  void setSpace(String value);

  /**
   * Returns the value of the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Called</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Called</em>' containment reference.
   * @see #setCalled(InheritingHiddensCall)
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getHidingHiddens_Called()
   * @model containment="true"
   * @generated
   */
  InheritingHiddensCall getCalled();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens#getCalled <em>Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Called</em>' containment reference.
   * @see #getCalled()
   * @generated
   */
  void setCalled(InheritingHiddensCall value);

} // HidingHiddens
