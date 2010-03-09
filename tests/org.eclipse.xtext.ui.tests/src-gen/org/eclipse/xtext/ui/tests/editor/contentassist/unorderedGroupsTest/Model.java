/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFirst <em>First</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getSecond <em>Second</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getThrird <em>Thrird</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getForth <em>Forth</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFifth <em>Fifth</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(SimpleModel)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_First()
   * @model containment="true"
   * @generated
   */
  SimpleModel getFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(SimpleModel value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(MandatoryModel)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_Second()
   * @model containment="true"
   * @generated
   */
  MandatoryModel getSecond();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(MandatoryModel value);

  /**
   * Returns the value of the '<em><b>Thrird</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Thrird</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Thrird</em>' containment reference.
   * @see #setThrird(LoopedModel)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_Thrird()
   * @model containment="true"
   * @generated
   */
  LoopedModel getThrird();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getThrird <em>Thrird</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Thrird</em>' containment reference.
   * @see #getThrird()
   * @generated
   */
  void setThrird(LoopedModel value);

  /**
   * Returns the value of the '<em><b>Forth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forth</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forth</em>' containment reference.
   * @see #setForth(GroupLoopedModel)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_Forth()
   * @model containment="true"
   * @generated
   */
  GroupLoopedModel getForth();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getForth <em>Forth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Forth</em>' containment reference.
   * @see #getForth()
   * @generated
   */
  void setForth(GroupLoopedModel value);

  /**
   * Returns the value of the '<em><b>Fifth</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fifth</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fifth</em>' containment reference.
   * @see #setFifth(LoopedAlternativeModel)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_Fifth()
   * @model containment="true"
   * @generated
   */
  LoopedAlternativeModel getFifth();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getFifth <em>Fifth</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fifth</em>' containment reference.
   * @see #getFifth()
   * @generated
   */
  void setFifth(LoopedAlternativeModel value);

  /**
   * Returns the value of the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' containment reference.
   * @see #setModel(Bug304681Model)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getModel_Model()
   * @model containment="true"
   * @generated
   */
  Bug304681Model getModel();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getModel <em>Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' containment reference.
   * @see #getModel()
   * @generated
   */
  void setModel(Bug304681Model value);

} // Model
