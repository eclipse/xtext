/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
 * @since 2.7
 * @generated
 */
public interface XAnnotationsFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XAnnotationsFactory eINSTANCE = org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAnnotation</em>'.
	 * @since 2.7
	 * @generated
	 */
	XAnnotation createXAnnotation();

	/**
	 * Returns a new object of class '<em>XAnnotation Element Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAnnotation Element Value Pair</em>'.
	 * @since 2.7
	 * @generated
	 */
	XAnnotationElementValuePair createXAnnotationElementValuePair();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XAnnotationsPackage getXAnnotationsPackage();

} //XAnnotationsFactory
