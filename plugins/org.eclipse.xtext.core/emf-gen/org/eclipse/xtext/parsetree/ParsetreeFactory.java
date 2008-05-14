/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParsetreeFactory.java,v 1.1 2008/05/14 13:29:32 jkohnlein Exp $
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
	 * Returns a new object of class '<em>Parser Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parser Node</em>'.
	 * @generated
	 */
	ParserNode createParserNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ParsetreePackage getParsetreePackage();

} //ParsetreeFactory
