/**
 */
package org.eclipse.xtext.testlanguages.testLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reducible Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.ReducibleComposite#getActionFeature <em>Action Feature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getReducibleComposite()
 * @model
 * @generated
 */
public interface ReducibleComposite extends ReducibleElement
{
  /**
   * Returns the value of the '<em><b>Action Feature</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.testLang.TerminalElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Feature</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Feature</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getReducibleComposite_ActionFeature()
   * @model containment="true"
   * @generated
   */
  EList<TerminalElement> getActionFeature();

} // ReducibleComposite
