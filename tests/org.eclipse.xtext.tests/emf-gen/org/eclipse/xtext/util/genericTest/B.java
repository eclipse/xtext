/**
 * <copyright>
 * </copyright>
 *
 * $Id: B.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.util.genericTest.B#getOtherReference <em>Other Reference</em>}</li>
 *   <li>{@link org.eclipse.xtext.util.genericTest.B#getOtherReference1 <em>Other Reference1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getB()
 * @model
 * @generated
 */
public interface B<U, V> extends A<V> {
	/**
	 * Returns the value of the '<em><b>Other Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Reference</em>' reference.
	 * @see #setOtherReference(Object)
	 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getB_OtherReference()
	 * @model kind="reference"
	 * @generated
	 */
	U getOtherReference();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.util.genericTest.B#getOtherReference <em>Other Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Reference</em>' reference.
	 * @see #getOtherReference()
	 * @generated
	 */
	void setOtherReference(U value);

	/**
	 * Returns the value of the '<em><b>Other Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Reference1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Reference1</em>' reference.
	 * @see #setOtherReference1(A)
	 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage#getB_OtherReference1()
	 * @model
	 * @generated
	 */
	A<OtherType> getOtherReference1();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.util.genericTest.B#getOtherReference1 <em>Other Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Reference1</em>' reference.
	 * @see #getOtherReference1()
	 * @generated
	 */
	void setOtherReference1(A<OtherType> value);

} // B
