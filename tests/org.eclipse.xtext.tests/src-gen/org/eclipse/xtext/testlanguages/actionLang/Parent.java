/**
 */
package org.eclipse.xtext.testlanguages.actionLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getParent()
 * @model
 * @generated
 */
public interface Parent extends Model
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Child)
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getParent_Left()
   * @model containment="true"
   * @generated
   */
  Child getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Child value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Child)
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getParent_Right()
   * @model containment="true"
   * @generated
   */
  Child getRight();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Child value);

} // Parent
