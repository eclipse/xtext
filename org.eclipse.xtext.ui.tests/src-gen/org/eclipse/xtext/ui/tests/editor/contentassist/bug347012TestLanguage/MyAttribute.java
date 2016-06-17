/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPUBLIC <em>PUBLIC</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPRIVATE <em>PRIVATE</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyAttribute()
 * @model
 * @generated
 */
public interface MyAttribute extends EObject
{
  /**
   * Returns the value of the '<em><b>PUBLIC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>PUBLIC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>PUBLIC</em>' attribute.
   * @see #setPUBLIC(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyAttribute_PUBLIC()
   * @model
   * @generated
   */
  String getPUBLIC();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPUBLIC <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PUBLIC</em>' attribute.
   * @see #getPUBLIC()
   * @generated
   */
  void setPUBLIC(String value);

  /**
   * Returns the value of the '<em><b>PRIVATE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>PRIVATE</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>PRIVATE</em>' attribute.
   * @see #setPRIVATE(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyAttribute_PRIVATE()
   * @model
   * @generated
   */
  String getPRIVATE();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPRIVATE <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PRIVATE</em>' attribute.
   * @see #getPRIVATE()
   * @generated
   */
  void setPRIVATE(String value);

} // MyAttribute
