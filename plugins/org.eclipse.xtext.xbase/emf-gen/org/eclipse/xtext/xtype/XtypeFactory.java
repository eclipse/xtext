/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtypeFactory.java,v 1.2 2010/01/16 08:50:52 sefftinge Exp $
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
	 * Returns a new object of class '<em>XType Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Ref</em>'.
	 * @generated
	 */
	XTypeRef createXTypeRef();

	/**
	 * Returns a new object of class '<em>XFunction Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFunction Type Ref</em>'.
	 * @generated
	 */
	XFunctionTypeRef createXFunctionTypeRef();

	/**
	 * Returns a new object of class '<em>XSimple Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSimple Type Ref</em>'.
	 * @generated
	 */
	XSimpleTypeRef createXSimpleTypeRef();

	/**
	 * Returns a new object of class '<em>XWildcard Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XWildcard Param</em>'.
	 * @generated
	 */
	XWildcardParam createXWildcardParam();

	/**
	 * Returns a new object of class '<em>XType Param Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Param Declaration</em>'.
	 * @generated
	 */
	XTypeParamDeclaration createXTypeParamDeclaration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtypePackage getXtypePackage();

} //XtypeFactory
