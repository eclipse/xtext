/**
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Character Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.CharacterRange#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.CharacterRange#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getCharacterRange()
 * @model
 * @generated
 */
public interface CharacterRange extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Keyword)
	 * @see org.eclipse.xtext.XtextPackage#getCharacterRange_Left()
	 * @model containment="true"
	 * @generated
	 */
	Keyword getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.CharacterRange#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Keyword value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Keyword)
	 * @see org.eclipse.xtext.XtextPackage#getCharacterRange_Right()
	 * @model containment="true"
	 * @generated
	 */
	Keyword getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.CharacterRange#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Keyword value);

} // CharacterRange
