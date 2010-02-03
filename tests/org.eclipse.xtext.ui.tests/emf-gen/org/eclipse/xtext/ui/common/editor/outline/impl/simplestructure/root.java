/**
 * <copyright>
 * </copyright>
 *
 * $Id: root.java,v 1.1 2010/02/03 18:24:43 sefftinge Exp $
 */
package org.eclipse.xtext.ui.common.editor.outline.impl.simplestructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.root#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructurePackage#getroot()
 * @model
 * @generated
 */
public interface root extends EObject {
	/**
	 * Returns the value of the '<em><b>A</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.ui.editor.outline.impl.simplestructure.A}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' containment reference list.
	 * @see org.eclipse.xtext.ui.editor.outline.impl.simplestructure.SimplestructurePackage#getroot_A()
	 * @model containment="true"
	 * @generated
	 */
	EList<A> getA();

} // root
