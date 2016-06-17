/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossResourceContainerManyChildren.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Resource Container Many Children</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage#getCrossResourceContainerManyChildren()
 * @model
 * @generated
 */
public interface CrossResourceContainerManyChildren extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage#getCrossResourceContainerManyChildren_Children()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EObject> getChildren();

} // CrossResourceContainerManyChildren
