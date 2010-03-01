/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.LeafNode#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.LeafNode#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.LeafNode#isHidden <em>Hidden</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getLeafNode()
 * @model
 * @generated
 */
public interface LeafNode extends AbstractNode {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getLeafNode_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.LeafNode#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getLeafNode_Feature()
	 * @model
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.LeafNode#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see #setHidden(boolean)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getLeafNode_Hidden()
	 * @model
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.LeafNode#isHidden <em>Hidden</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hidden</em>' attribute.
	 * @see #isHidden()
	 * @generated
	 */
	void setHidden(boolean value);

} // LeafNode
