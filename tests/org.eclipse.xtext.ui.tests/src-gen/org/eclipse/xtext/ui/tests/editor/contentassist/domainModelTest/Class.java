/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class#getSubClasses <em>Sub Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Type
{
  /**
   * Returns the value of the '<em><b>Super Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Class</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Class</em>' reference.
   * @see #setSuperClass(Class)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getClass_SuperClass()
   * @model
   * @generated
   */
  Class getSuperClass();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class#getSuperClass <em>Super Class</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Class</em>' reference.
   * @see #getSuperClass()
   * @generated
   */
  void setSuperClass(Class value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getClass_Properties()
   * @model containment="true"
   * @generated
   */
  EList<Property> getProperties();

  /**
   * Returns the value of the '<em><b>Sub Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.Class}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Classes</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.domainModelTest.DomainModelTestPackage#getClass_SubClasses()
   * @model containment="true"
   * @generated
   */
  EList<Class> getSubClasses();

} // Class
