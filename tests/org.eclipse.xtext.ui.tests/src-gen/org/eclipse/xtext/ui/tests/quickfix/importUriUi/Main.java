/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.quickfix.importUriUi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.ImportUriUiPackage#getMain()
 * @model
 * @generated
 */
public interface Main extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.ImportUriUiPackage#getMain_Element()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElement();

} // Main
