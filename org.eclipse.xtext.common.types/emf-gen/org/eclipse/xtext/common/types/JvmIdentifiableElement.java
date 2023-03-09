/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Identifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmIdentifiableElement()
 * @model abstract="true"
 * @generated
 */
public interface JvmIdentifiableElement extends EObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The identifier of a JvmIdentifiableElement is a canonical representation of the element.</p>
	 * <p>A type will return its fully qualified name as its identifier with a '$' delimiter for inner classes. 
	 * The identifier of an executables contains the identifiers of their respective parameter types. They do
	 * not contain any information about type parameters.</p>
	 * <p>Examples for identifiers are:</p>
	 * <ul>
	 * <li>java.lang.String for a class</li>
	 * <li>java.util.Map$Entry for an inner class</li>
	 * <li>java.lang.String.String() for a constructor (note the repeated simple name)</li>
	 * <li>java.lang.String.charAt(int) for a method</li>
	 * <li>java.lang.String.offset for a field</li>
	 * <li>java.lang.Object[][] for an array type</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The simple name of a JvmIdentifiableElement is short representation of the element.</p>
	 * <p>The simple name does not contain any information about type parameters.</p>
	 * <p>Examples for simple names are:</p>
	 * <ul>
	 * <li>String for class java.lang.String</li>
	 * <li>Entry for class java.util.Map$Entry</li>
	 * <li>charAt for method java.lang.String.charAt(int)</li>
	 * <li>String for constructor java.lang.String.String(java.lang.String)</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The qualified name of a JvmIdentifiableElement is a textual representation of the element.</p>
	 * <p>The default delimiter character is the '$'.</p>
	 * @see #getQualifiedName(char)
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The qualified name of a JvmIdentifiableElement is a textual representation of the element.</p>
	 * <p>The name does not contain any information about type parameters. Inner classes are delimited by means of 
	 * the given 'innerClassDelimiter'</p>
	 * <p>Examples for qualified names with a '$' delimiter are:</p>
	 * <ul>
	 * <li>java.lang.String for class java.lang.String</li>
	 * <li>java.util.Map$Entry for class java.util.Map$Entry</li>
	 * <li>java.lang.String.charAt for method java.lang.String.charAt(int)</li>
	 * <li>java.lang.String.offset for field java.lang.String.offset</li>
	 * <li>java.lang.String for a constructor that is identified by java.lang.String.String(java.lang.String)</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	String getQualifiedName(char innerClassDelimiter);

} // JvmIdentifiableElement
