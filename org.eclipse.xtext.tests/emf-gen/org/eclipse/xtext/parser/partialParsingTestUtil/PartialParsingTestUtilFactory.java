/**
 * <copyright>
 * </copyright>
 *
 * $Id: PartialParsingTestUtilFactory.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage
 * @generated
 */
public interface PartialParsingTestUtilFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PartialParsingTestUtilFactory eINSTANCE = org.eclipse.xtext.parser.partialParsingTestUtil.impl.PartialParsingTestUtilFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Cross Resource Container Many Children</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cross Resource Container Many Children</em>'.
	 * @generated
	 */
	CrossResourceContainerManyChildren createCrossResourceContainerManyChildren();

	/**
	 * Returns a new object of class '<em>Cross Resource Container One Child</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cross Resource Container One Child</em>'.
	 * @generated
	 */
	CrossResourceContainerOneChild createCrossResourceContainerOneChild();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PartialParsingTestUtilPackage getPartialParsingTestUtilPackage();

} //PartialParsingTestUtilFactory
