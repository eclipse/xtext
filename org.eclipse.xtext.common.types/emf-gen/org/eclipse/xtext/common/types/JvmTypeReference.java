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

import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeReference()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeReference extends EObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The identifier of a JvmTypeReference is a canonical representation of the referenced type 
	 * including its type arguments.</p>
	 * <p>The types fully qualified name is used ('$' is the delimiter for inner types).</p>
	 * <p>Examples for reference identifiers are:</p>
	 * <ul>
	 * <li>java.lang.String for a reference to an object type</li>
	 * <li>java.util.Map$Entry&lt;java.lang.Object,java.lang.Integer&gt; for a parameterized type</li>
	 * <li>java.util.List&lt;? extends java.lang.String&gt;[] for a generic array type</li>
	 * </ul>
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getQualifiedName(char innerClassDelimiter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="org.eclipse.xtext.common.types.ITypeReferenceVisitor&lt;Result&gt;"
	 * @generated
	 */
	<Result> Result accept(ITypeReferenceVisitor<Result> visitor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="org.eclipse.xtext.common.types.ITypeReferenceVisitorWithParameter&lt;Parameter, Result&gt;"
	 * @generated
	 */
	<Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter, Result> visitor, Parameter parameter);

} // JvmTypeReference
