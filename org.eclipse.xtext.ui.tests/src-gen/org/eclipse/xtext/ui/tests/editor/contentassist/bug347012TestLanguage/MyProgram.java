/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyProgram()
 * @model
 * @generated
 */
public interface MyProgram extends EObject
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' containment reference.
   * @see #setPackage(MyPackage)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyProgram_Package()
   * @model containment="true"
   * @generated
   */
  MyPackage getPackage();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram#getPackage <em>Package</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' containment reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(MyPackage value);

} // MyProgram
