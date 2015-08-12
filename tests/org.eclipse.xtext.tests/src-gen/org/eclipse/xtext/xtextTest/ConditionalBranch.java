/**
 */
package org.eclipse.xtext.xtextTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.ConditionalBranch#isFiltered <em>Filtered</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getGuardedElement <em>Guarded Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getConditionalBranch()
 * @model
 * @generated
 */
public interface ConditionalBranch extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Filtered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filtered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filtered</em>' attribute.
   * @see #setFiltered(boolean)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getConditionalBranch_Filtered()
   * @model
   * @generated
   */
  boolean isFiltered();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#isFiltered <em>Filtered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filtered</em>' attribute.
   * @see #isFiltered()
   * @generated
   */
  void setFiltered(boolean value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' reference.
   * @see #setParameter(Parameter)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getConditionalBranch_Parameter()
   * @model
   * @generated
   */
  Parameter getParameter();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getParameter <em>Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' reference.
   * @see #getParameter()
   * @generated
   */
  void setParameter(Parameter value);

  /**
   * Returns the value of the '<em><b>Guarded Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guarded Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guarded Element</em>' containment reference.
   * @see #setGuardedElement(AbstractElement)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getConditionalBranch_GuardedElement()
   * @model containment="true"
   * @generated
   */
  AbstractElement getGuardedElement();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.ConditionalBranch#getGuardedElement <em>Guarded Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guarded Element</em>' containment reference.
   * @see #getGuardedElement()
   * @generated
   */
  void setGuardedElement(AbstractElement value);

} // ConditionalBranch
