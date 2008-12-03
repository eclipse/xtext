/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRule.java,v 1.12 2008/12/03 20:57:09 szarnekow Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ParserRule#getAlternatives <em>Alternatives</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getParserRule()
 * @model
 * @generated
 */
public interface ParserRule extends AbstractRule
{

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
	 * @see org.eclipse.xtext.XtextPackage#getParserRule_Alternatives()
	 * @model containment="true"
	 * @generated
	 */
	AbstractElement getAlternatives();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.ParserRule#getAlternatives <em>Alternatives</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternatives</em>' containment reference.
	 * @see #getAlternatives()
	 * @generated
	 */
	void setAlternatives(AbstractElement value);

} // ParserRule
