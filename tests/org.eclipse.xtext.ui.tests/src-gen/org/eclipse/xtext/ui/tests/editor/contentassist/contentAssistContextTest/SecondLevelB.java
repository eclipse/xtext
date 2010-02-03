/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Second Level B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB1 <em>Third Level B1</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB2 <em>Third Level B2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelB()
 * @model
 * @generated
 */
public interface SecondLevelB extends EObject
{
  /**
   * Returns the value of the '<em><b>Third Level B1</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB1}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third Level B1</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third Level B1</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelB_ThirdLevelB1()
   * @model containment="true"
   * @generated
   */
  EList<ThirdLevelB1> getThirdLevelB1();

  /**
   * Returns the value of the '<em><b>Third Level B2</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB2}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Third Level B2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Third Level B2</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage#getSecondLevelB_ThirdLevelB2()
   * @model containment="true"
   * @generated
   */
  EList<ThirdLevelB2> getThirdLevelB2();

} // SecondLevelB
