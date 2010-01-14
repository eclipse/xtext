/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtypeFactory.java,v 1.1 2010/01/14 14:40:17 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtype.XtypePackage
 * @generated
 */
public interface XtypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypeFactory eINSTANCE = org.eclipse.xtext.xtype.impl.XtypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Ref</em>'.
	 * @generated
	 */
	TypeRef createTypeRef();

	/**
	 * Returns a new object of class '<em>Function Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Type Ref</em>'.
	 * @generated
	 */
	FunctionTypeRef createFunctionTypeRef();

	/**
	 * Returns a new object of class '<em>Simple Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Type Ref</em>'.
	 * @generated
	 */
	SimpleTypeRef createSimpleTypeRef();

	/**
	 * Returns a new object of class '<em>Wildcard Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Param</em>'.
	 * @generated
	 */
	WildcardParam createWildcardParam();

	/**
	 * Returns a new object of class '<em>Type Param Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Param Declaration</em>'.
	 * @generated
	 */
	TypeParamDeclaration createTypeParamDeclaration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtypePackage getXtypePackage();

} //XtypeFactory
