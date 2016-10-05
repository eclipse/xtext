/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.AbstractRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.AbstractRule#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.AbstractRule#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.AbstractRule#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getAbstractRule()
 * @model
 * @generated
 */
public interface AbstractRule extends EObject {
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
	 * @see org.eclipse.xtext.XtextPackage#getAbstractRule_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeRef)
	 * @see org.eclipse.xtext.XtextPackage#getAbstractRule_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractRule#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeRef value);

	/**
	 * Returns the value of the '<em><b>Alternatives</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternatives</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternatives</em>' containment reference.
	 * @see #setAlternatives(AbstractElement)
	 * @see org.eclipse.xtext.XtextPackage#getAbstractRule_Alternatives()
	 * @model containment="true"
	 * @generated
	 */
	AbstractElement getAlternatives();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.AbstractRule#getAlternatives <em>Alternatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternatives</em>' containment reference.
	 * @see #getAlternatives()
	 * @generated
	 */
	void setAlternatives(AbstractElement value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.eclipse.xtext.XtextPackage#getAbstractRule_Annotations()
	 * @model containment="true"
	 * @generated
	 * @since 2.11
	 */
	EList<Annotation> getAnnotations();

} // AbstractRule
