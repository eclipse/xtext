/**
 * <copyright>
 * </copyright>
 *
 * $Id: A.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.util.genericTest.A#getSomeReference <em>Some Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.util.genericTest.A#getSomeReference1 <em>Some Reference1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getA()
 * @model
 * @generated
 */
public interface A<T> extends EObject {
	/**
	 * Returns the value of the '<em><b>Some Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Some Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Some Reference</em>' reference.
	 * @see #setSomeReference(Object)
	 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getA_SomeReference()
	 * @model kind="reference"
	 * @generated
	 */
	T getSomeReference();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.util.genericTest.A#getSomeReference <em>Some Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Some Reference</em>' reference.
	 * @see #getSomeReference()
	 * @generated
	 */
	void setSomeReference(T value);

	/**
	 * Returns the value of the '<em><b>Some Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Some Reference1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Some Reference1</em>' reference.
	 * @see #setSomeReference1(SomeType)
	 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getA_SomeReference1()
	 * @model
	 * @generated
	 */
	SomeType getSomeReference1();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.util.genericTest.A#getSomeReference1 <em>Some Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Some Reference1</em>' reference.
	 * @see #getSomeReference1()
	 * @generated
	 */
	void setSomeReference1(SomeType value);

} // A
