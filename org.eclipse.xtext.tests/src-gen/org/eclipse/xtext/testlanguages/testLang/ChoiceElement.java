/**
 */
package org.eclipse.xtext.testlanguages.testLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#isOptionalKeyword <em>Optional Keyword</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getChoiceElement()
 * @model
 * @generated
 */
public interface ChoiceElement extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Optional Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optional Keyword</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optional Keyword</em>' attribute.
   * @see #setOptionalKeyword(boolean)
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getChoiceElement_OptionalKeyword()
   * @model
   * @generated
   */
  boolean isOptionalKeyword();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#isOptionalKeyword <em>Optional Keyword</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional Keyword</em>' attribute.
   * @see #isOptionalKeyword()
   * @generated
   */
  void setOptionalKeyword(boolean value);

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
   * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage#getChoiceElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // ChoiceElement
