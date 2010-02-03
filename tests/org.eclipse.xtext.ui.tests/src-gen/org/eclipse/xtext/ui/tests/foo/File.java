/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.foo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.foo.File#getStuff <em>Stuff</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.foo.FooPackage#getFile()
 * @model
 * @generated
 */
public interface File extends EObject
{
  /**
   * Returns the value of the '<em><b>Stuff</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.foo.Stuff}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stuff</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stuff</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.foo.FooPackage#getFile_Stuff()
   * @model containment="true"
   * @generated
   */
  EList<Stuff> getStuff();

} // File
