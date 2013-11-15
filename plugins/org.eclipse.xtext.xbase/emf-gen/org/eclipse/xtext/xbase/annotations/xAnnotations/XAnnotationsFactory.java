/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.xAnnotations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
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
	 * @generated
	 */
	XAnnotation createXAnnotation();

	/**
	 * Returns a new object of class '<em>XAnnotation Element Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAnnotation Element Value Pair</em>'.
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
