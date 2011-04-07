/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperCallReferable <em>Super Call Referable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass()
 * @model
 * @generated
 */
public interface XtendClass extends JvmIdentifiableElement, JvmTypeParameterDeclarator
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference.
	 * @see #setExtends(JvmTypeReference)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_Extends()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getExtends <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' containment reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' containment reference list.
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_Implements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getImplements();

	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' reference list.
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_SuperTypes()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	EList<JvmTypeReference> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtend2.xtend2.XtendMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_Members()
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType
	 * @model opposite="declaringType" containment="true"
	 * @generated
	 */
	EList<XtendMember> getMembers();

	/**
	 * Returns the value of the '<em><b>Super Call Referable</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable#getXtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Call Referable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Call Referable</em>' containment reference.
	 * @see #setSuperCallReferable(XtendClassSuperCallReferable)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendClass_SuperCallReferable()
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable#getXtendClass
	 * @model opposite="xtendClass" containment="true" required="true" transient="true"
	 * @generated
	 */
	XtendClassSuperCallReferable getSuperCallReferable();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperCallReferable <em>Super Call Referable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Call Referable</em>' containment reference.
	 * @see #getSuperCallReferable()
	 * @generated
	 */
	void setSuperCallReferable(XtendClassSuperCallReferable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getPackageName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

} // XtendClass
