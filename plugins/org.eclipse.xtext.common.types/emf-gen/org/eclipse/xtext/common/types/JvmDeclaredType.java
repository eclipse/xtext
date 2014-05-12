/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;

import java.lang.Iterable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Declared Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmDeclaredType#getPackageName <em>Package Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmDeclaredType()
 * @model abstract="true"
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JvmDeclaredType extends JvmMember, JvmComponentType
{
	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmOperation>" required="true"
	 * @generated
	 */
	Iterable<JvmOperation> getDeclaredOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmField>" required="true"
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
	 * @model dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmFeature>" required="true"
	 * @generated
	 * @since 2.1
	 */
	Iterable<JvmFeature> findAllFeaturesByName(String simpleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the fields and operations of this type.</p>
	 * <p>Inherited features are included, but overridden features will not be returned.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmFeature>" required="true"
	 * @generated
	 * @since 2.1
	 */
	Iterable<JvmFeature> getAllFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmTypeReference>"
	 * @generated
	 * @since 2.6
	 */
	Iterable<JvmTypeReference> getExtendedInterfaces();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 * @since 2.6
	 */
	JvmTypeReference getExtendedClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 * @since 2.6
	 */
	boolean isInstantiateable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the nested types with the given simple name.</p>
	 * <p>Inherited types will be returned, too.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmDeclaredType>"
	 * @generated
	 * @since 2.6
	 */
	Iterable<JvmDeclaredType> findAllNestedTypesByName(String simpleName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 * @since 2.6
	 */
	boolean isLocal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmConstructor>" required="true"
	 * @generated
	 * @since 2.6
	 */
	Iterable<JvmConstructor> getDeclaredConstructors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns all the nested types of this type.</p>
	 * <p>Inherited types will also be returned.</p>
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.xtext.common.types.Iterable<org.eclipse.xtext.common.types.JvmDeclaredType>" required="true"
	 * @generated
	 * @since 2.6
	 */
	Iterable<JvmDeclaredType> getAllNestedTypes();

} // JvmDeclaredType
