/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overriding Hiddens</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled <em>Called</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddens()
 * @model
 * @generated
 */
public interface OverridingHiddens extends Model
{
  /**
   * Returns the value of the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Called</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Called</em>' containment reference.
   * @see #setCalled(OverridingHiddensCall)
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddens_Called()
   * @model containment="true"
   * @generated
   */
  OverridingHiddensCall getCalled();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled <em>Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Called</em>' containment reference.
   * @see #getCalled()
   * @generated
   */
  void setCalled(OverridingHiddensCall value);

} // OverridingHiddens
