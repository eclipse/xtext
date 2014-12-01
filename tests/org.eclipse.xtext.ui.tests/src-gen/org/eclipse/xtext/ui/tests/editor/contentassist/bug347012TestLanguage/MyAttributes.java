/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyAttributes()
 * @model
 * @generated
 */
public interface MyAttributes extends EObject
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguagePackage#getMyAttributes_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<MyAttribute> getAttributes();

} // MyAttributes
