/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelA <em>Second Level A</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelB <em>Second Level B</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel()
 * @model
 * @generated
 */
public interface FirstLevel extends EObject
{
  /**
   * Returns the value of the '<em><b>Second Level A</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Level A</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Level A</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel_SecondLevelA()
   * @model containment="true"
   * @generated
   */
  EList<SecondLevelA> getSecondLevelA();

  /**
   * Returns the value of the '<em><b>Second Level B</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Level B</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Level B</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getFirstLevel_SecondLevelB()
   * @model containment="true"
   * @generated
   */
  EList<SecondLevelB> getSecondLevelB();

} // FirstLevel
