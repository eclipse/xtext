/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.root;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getReference1 <em>Reference1</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage#getRootClass()
 * @model
 * @generated
 */
public interface RootClass extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute1</em>' attribute.
	 * @see #setAttribute1(String)
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage#getRootClass_Attribute1()
	 * @model
	 * @generated
	 */
	String getAttribute1();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getAttribute1 <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute1</em>' attribute.
	 * @see #getAttribute1()
	 * @generated
	 */
	void setAttribute1(String value);

	/**
	 * Returns the value of the '<em><b>Reference1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference1</em>' reference.
	 * @see #setReference1(NestedClass1)
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootPackage#getRootClass_Reference1()
	 * @model
	 * @generated
	 */
	NestedClass1 getReference1();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.root.RootClass#getReference1 <em>Reference1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference1</em>' reference.
	 * @see #getReference1()
	 * @generated
	 */
	void setReference1(NestedClass1 value);

} // RootClass
