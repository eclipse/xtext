/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtype.XtypePackage
 * @since 2.7
 * @generated
 */
public interface XtypeFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypeFactory eINSTANCE = org.eclipse.xtext.xtype.impl.XtypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XFunction Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFunction Type Ref</em>'.
	 * @since 2.7
	 * @generated
	 */
	XFunctionTypeRef createXFunctionTypeRef();

	/**
	 * Returns a new object of class '<em>XComputed Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XComputed Type Reference</em>'.
	 * @since 2.7
	 * @generated
	 */
	XComputedTypeReference createXComputedTypeReference();

	/**
	 * Returns a new object of class '<em>XImport Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Section</em>'.
	 * @since 2.7
	 * @generated
	 */
	XImportSection createXImportSection();

	/**
	 * Returns a new object of class '<em>XImport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Declaration</em>'.
	 * @since 2.7
	 * @generated
	 */
	XImportDeclaration createXImportDeclaration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtypePackage getXtypePackage();

} //XtypeFactory
