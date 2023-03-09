/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.AbstractElement#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link org.eclipse.xtext.AbstractElement#isPredicated <em>Predicated</em>}</li>
 *   <li>{@link org.eclipse.xtext.AbstractElement#isFirstSetPredicated <em>First Set Predicated</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getAbstractElement()
 * @model
 * @generated
 */
public interface AbstractElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(String)
	 * @see org.eclipse.xtext.XtextPackage#getAbstractElement_Cardinality()
	 * @model
	 * @generated
	 */
	String getCardinality();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractElement#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(String value);

	/**
	 * Returns the value of the '<em><b>Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicated</em>' attribute.
	 * @see #setPredicated(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getAbstractElement_Predicated()
	 * @model
	 * @generated
	 */
	boolean isPredicated();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractElement#isPredicated <em>Predicated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicated</em>' attribute.
	 * @see #isPredicated()
	 * @generated
	 */
	void setPredicated(boolean value);

	/**
	 * Returns the value of the '<em><b>First Set Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Set Predicated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 2.6
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Set Predicated</em>' attribute.
	 * @see #setFirstSetPredicated(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getAbstractElement_FirstSetPredicated()
	 * @model
	 * @generated
	 */
	boolean isFirstSetPredicated();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractElement#isFirstSetPredicated <em>First Set Predicated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 2.6
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Set Predicated</em>' attribute.
	 * @see #isFirstSetPredicated()
	 * @generated
	 */
	void setFirstSetPredicated(boolean value);

} // AbstractElement
