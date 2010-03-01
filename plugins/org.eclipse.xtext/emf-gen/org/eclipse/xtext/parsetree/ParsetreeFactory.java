/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.ParsetreePackage
 * @generated
 */
public interface ParsetreeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParsetreeFactory eINSTANCE = org.eclipse.xtext.parsetree.impl.ParsetreeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Composite Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Node</em>'.
	 * @generated
	 */
	CompositeNode createCompositeNode();

	/**
	 * Returns a new object of class '<em>Leaf Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leaf Node</em>'.
	 * @generated
	 */
	LeafNode createLeafNode();

	/**
	 * Returns a new object of class '<em>Syntax Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Syntax Error</em>'.
	 * @generated
	 */
	SyntaxError createSyntaxError();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParsetreePackage getParsetreePackage();

} //ParsetreeFactory
