/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef#getDay <em>Day</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage#getTimeDef()
 * @model
 * @generated
 */
public interface TimeDef extends EObject
{
  /**
   * Returns the value of the '<em><b>Day</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Day</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Day</em>' attribute.
   * @see #setDay(int)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguagePackage#getTimeDef_Day()
   * @model
   * @generated
   */
  int getDay();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef#getDay <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Day</em>' attribute.
   * @see #getDay()
   * @generated
   */
  void setDay(int value);

} // TimeDef
