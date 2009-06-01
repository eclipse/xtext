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
 * A representation of the model object '<em><b>Second Level A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA1 <em>Third Level A1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA2 <em>Third Level A2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelA()
 * @model
 * @generated
 */
public interface SecondLevelA extends EObject
{
  /**
   * Returns the value of the '<em><b>Third Level A1</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third Level A1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third Level A1</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelA_ThirdLevelA1()
   * @model containment="true"
   * @generated
   */
  EList<ThirdLevelA1> getThirdLevelA1();

  /**
   * Returns the value of the '<em><b>Third Level A2</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third Level A2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third Level A2</em>' containment reference list.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelA_ThirdLevelA2()
   * @model containment="true"
   * @generated
   */
  EList<ThirdLevelA2> getThirdLevelA2();

} // SecondLevelA
