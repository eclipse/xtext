/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Calls</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getOpt1 <em>Opt1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getOptionalCalls()
 * @model
 * @generated
 */
public interface OptionalCalls extends Model
{
  /**
   * Returns the value of the '<em><b>Opt1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opt1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opt1</em>' containment reference.
   * @see #setOpt1(OptionalCallsSub1)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getOptionalCalls_Opt1()
   * @model containment="true"
   * @generated
   */
  OptionalCallsSub1 getOpt1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getOpt1 <em>Opt1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opt1</em>' containment reference.
   * @see #getOpt1()
   * @generated
   */
  void setOpt1(OptionalCallsSub1 value);

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
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getOptionalCalls_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // OptionalCalls
