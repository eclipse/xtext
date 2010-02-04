/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossResourceContainerOneChild.java,v 1.1 2010/02/04 09:24:52 sefftinge Exp $
 */
package org.eclipse.xtext.parser.partialParsingTestUtil;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Resource Container One Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage#getCrossResourceContainerOneChild()
 * @model
 * @generated
 */
public interface CrossResourceContainerOneChild extends EObject {
	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference.
	 * @see #setChild(EObject)
	 * @see org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage#getCrossResourceContainerOneChild_Child()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EObject getChild();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild#getChild <em>Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' containment reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(EObject value);

} // CrossResourceContainerOneChild
