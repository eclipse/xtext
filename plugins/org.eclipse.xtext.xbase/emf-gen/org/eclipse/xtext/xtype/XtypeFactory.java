/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noreference This field is not intended to be referenced by clients.
 * @noimplement This interface is not intended to be implemented by clients.
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
	 * @generated
	 */
	XFunctionTypeRef createXFunctionTypeRef();

	/**
	 * Returns a new object of class '<em>XComputed Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XComputed Type Reference</em>'.
	 * @generated
	 */
	XComputedTypeReference createXComputedTypeReference();

	/**
	 * Returns a new object of class '<em>XImport Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Section</em>'.
	 * @generated
	 */
	XImportSection createXImportSection();

	/**
	 * Returns a new object of class '<em>XImport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Declaration</em>'.
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
