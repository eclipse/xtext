/**
 * <copyright>
 * </copyright>
 *
 * $Id: AmetamodelFactory.java,v 1.1 2010/02/04 09:24:53 sefftinge Exp $
 */
package org.eclipse.xtext.grammarinheritance.ametamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.grammarinheritance.ametamodel.AmetamodelPackage
 * @generated
 */
public interface AmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AmetamodelFactory eINSTANCE = org.eclipse.xtext.grammarinheritance.ametamodel.impl.AmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>AType</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AType</em>'.
	 * @generated
	 */
	AType createAType();

	/**
	 * Returns a new object of class '<em>AModel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AModel</em>'.
	 * @generated
	 */
	AModel createAModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AmetamodelPackage getAmetamodelPackage();

} //AmetamodelFactory
