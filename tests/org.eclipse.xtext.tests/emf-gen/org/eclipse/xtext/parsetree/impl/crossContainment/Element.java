/**
 * <copyright>
 * </copyright>
 *
 * $Id: Element.java,v 1.1 2010/04/09 10:00:01 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree.impl.crossContainment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainment <em>Containment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Element)
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage#getElement_Container()
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainment
	 * @model opposite="containment" transient="false"
	 * @generated
	 */
	Element getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Element value);

	/**
	 * Returns the value of the '<em><b>Containment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.parsetree.impl.crossContainment.Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment</em>' containment reference list.
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.CrossContainmentPackage#getElement_Containment()
	 * @see org.eclipse.xtext.parsetree.impl.crossContainment.Element#getContainer
	 * @model opposite="container" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Element> getContainment();

} // Element
