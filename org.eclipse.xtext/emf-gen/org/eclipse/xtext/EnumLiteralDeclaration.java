/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}</li>
 *   <li>{@link org.eclipse.xtext.EnumLiteralDeclaration#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getEnumLiteralDeclaration()
 * @model
 * @generated
 */
public interface EnumLiteralDeclaration extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Enum Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Literal</em>' reference.
	 * @see #setEnumLiteral(EEnumLiteral)
	 * @see org.eclipse.xtext.XtextPackage#getEnumLiteralDeclaration_EnumLiteral()
	 * @model
	 * @generated
	 */
	EEnumLiteral getEnumLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.EnumLiteralDeclaration#getEnumLiteral <em>Enum Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Literal</em>' reference.
	 * @see #getEnumLiteral()
	 * @generated
	 */
	void setEnumLiteral(EEnumLiteral value);

	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' containment reference.
	 * @see #setLiteral(Keyword)
	 * @see org.eclipse.xtext.XtextPackage#getEnumLiteralDeclaration_Literal()
	 * @model containment="true"
	 * @generated
	 */
	Keyword getLiteral();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.EnumLiteralDeclaration#getLiteral <em>Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' containment reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(Keyword value);

} // EnumLiteralDeclaration
