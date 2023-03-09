/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericTestFactory.java,v 1.1 2010/03/31 13:22:31 jkohnlein Exp $
 */
package org.eclipse.xtext.util.genericTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.util.genericTest.GenericTestPackage
 * @generated
 */
public interface GenericTestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericTestFactory eINSTANCE = org.eclipse.xtext.util.genericTest.impl.GenericTestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A</em>'.
	 * @generated
	 */
	<T> A<T> createA();

	/**
	 * Returns a new object of class '<em>B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>B</em>'.
	 * @generated
	 */
	<U, V> B<U, V> createB();

	/**
	 * Returns a new object of class '<em>C</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C</em>'.
	 * @generated
	 */
	<W> C<W> createC();

	/**
	 * Returns a new object of class '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>D</em>'.
	 * @generated
	 */
	D createD();

	/**
	 * Returns a new object of class '<em>Some Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Some Type</em>'.
	 * @generated
	 */
	SomeType createSomeType();

	/**
	 * Returns a new object of class '<em>Other Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other Type</em>'.
	 * @generated
	 */
	OtherType createOtherType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenericTestPackage getGenericTestPackage();

} //GenericTestFactory
