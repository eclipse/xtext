/**
 * <copyright>
 * </copyright>
 *
 * $Id: CustomType.java,v 1.1 2008/10/30 21:37:04 mclay Exp $
 */
package ReferenceModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ReferenceModel.CustomType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ReferenceModel.ReferenceModelPackage#getCustomType()
 * @model
 * @generated
 */
public interface CustomType extends EObject {
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
	 * @see ReferenceModel.ReferenceModelPackage#getCustomType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ReferenceModel.CustomType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CustomType
