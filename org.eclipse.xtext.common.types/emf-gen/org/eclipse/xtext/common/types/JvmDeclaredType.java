/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Declared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType()
 * @model abstract="true"
 * @generated
 */
public interface JvmDeclaredType extends JvmMember, JvmComponentType
{
	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_SuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_Members()
	 * @see org.eclipse.xtext.common.types.JvmMember#getDeclaringType
	 * @model opposite="declaringType" containment="true"
	 * @generated
	 */
	EList<JvmMember> getMembers();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmOperation&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmOperation> getDeclaredOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmField&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmField> getDeclaredFields();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the fields and operations with the given simple name.</p>
	 * <p>Inherited features will be returend, but overridden features are not contained in the result.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmFeature&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmFeature> findAllFeaturesByName(String simpleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the fields and operations of this type.</p>
	 * <p>Inherited features are included, but overridden features will not be returned.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmFeature&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmFeature> getAllFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmTypeReference&gt;"
	 * @generated
	 */
	Iterable<JvmTypeReference> getExtendedInterfaces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getExtendedClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInstantiateable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the nested types with the given simple name.</p>
	 * <p>Inherited types will be returned, too.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmDeclaredType&gt;"
	 * @generated
	 */
	Iterable<JvmDeclaredType> findAllNestedTypesByName(String simpleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isLocal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmConstructor&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmConstructor> getDeclaredConstructors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the nested types of this type.</p>
	 * <p>Inherited types will also be returned.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable&lt;org.eclipse.xtext.common.types.JvmDeclaredType&gt;" required="true"
	 * @generated
	 */
	Iterable<JvmDeclaredType> getAllNestedTypes();

} // JvmDeclaredType
