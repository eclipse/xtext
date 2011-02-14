/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Constraint Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmConstraintOwner#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmConstraintOwner()
 * @model abstract="true"
 * @generated
 */
public interface JvmConstraintOwner extends JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeConstraint}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmConstraintOwner_Constraints()
	 * @see org.eclipse.xtext.common.types.JvmTypeConstraint#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<JvmTypeConstraint> getConstraints();

} // JvmConstraintOwner
