/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractElement.java,v 1.13 2010/04/06 14:10:12 sefftinge Exp $
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
 * <ul>
 *   <li>{@link org.eclipse.xtext.AbstractElement#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
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

} // AbstractElement
