/**
 */
package org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.ecore.genmodelaccess.nestedPackage1.NestedClass1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No Lit Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getAttribute2 <em>Attribute2</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getReference2 <em>Reference2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage#getNoLitClass()
 * @model
 * @generated
 */
public interface NoLitClass extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attribute2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute2</em>' attribute.
	 * @see #setAttribute2(String)
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage#getNoLitClass_Attribute2()
	 * @model
	 * @generated
	 */
	String getAttribute2();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getAttribute2 <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute2</em>' attribute.
	 * @see #getAttribute2()
	 * @generated
	 */
	void setAttribute2(String value);

	/**
	 * Returns the value of the '<em><b>Reference2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference2</em>' reference.
	 * @see #setReference2(NestedClass1)
	 * @see org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLiteralsPackage#getNoLitClass_Reference2()
	 * @model
	 * @generated
	 */
	NestedClass1 getReference2();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.genmodelaccess.noLiterals.NoLitClass#getReference2 <em>Reference2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference2</em>' reference.
	 * @see #getReference2()
	 * @generated
	 */
	void setReference2(NestedClass1 value);

} // NoLitClass
