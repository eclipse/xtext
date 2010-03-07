/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bug304681 Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getLongDescription <em>Long Description</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getUid <em>Uid</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#isFlag <em>Flag</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model()
 * @model
 * @generated
 */
public interface Bug304681Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Short Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Short Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Short Description</em>' attribute.
   * @see #setShortDescription(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model_ShortDescription()
   * @model
   * @generated
   */
  String getShortDescription();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getShortDescription <em>Short Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Short Description</em>' attribute.
   * @see #getShortDescription()
   * @generated
   */
  void setShortDescription(String value);

  /**
   * Returns the value of the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Long Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long Description</em>' attribute.
   * @see #setLongDescription(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model_LongDescription()
   * @model
   * @generated
   */
  String getLongDescription();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getLongDescription <em>Long Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Description</em>' attribute.
   * @see #getLongDescription()
   * @generated
   */
  void setLongDescription(String value);

  /**
   * Returns the value of the '<em><b>Uid</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Uid</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Uid</em>' attribute.
   * @see #setUid(String)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model_Uid()
   * @model
   * @generated
   */
  String getUid();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#getUid <em>Uid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Uid</em>' attribute.
   * @see #getUid()
   * @generated
   */
  void setUid(String value);

  /**
   * Returns the value of the '<em><b>Flag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flag</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flag</em>' attribute.
   * @see #setFlag(boolean)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model_Flag()
   * @model
   * @generated
   */
  boolean isFlag();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Model#isFlag <em>Flag</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flag</em>' attribute.
   * @see #isFlag()
   * @generated
   */
  void setFlag(boolean value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Bug304681Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestPackage#getBug304681Model_Features()
   * @model containment="true"
   * @generated
   */
  EList<Bug304681Feature> getFeatures();

} // Bug304681Model
