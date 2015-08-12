/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRuleOptions()
 * @model
 * @generated
 */
public interface RuleOptions extends RuleElement
{
  /**
   * Returns the value of the '<em><b>Options</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Options</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Options</em>' containment reference.
   * @see #setOptions(Options)
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRuleOptions_Options()
   * @model containment="true"
   * @generated
   */
  Options getOptions();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getOptions <em>Options</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Options</em>' containment reference.
   * @see #getOptions()
   * @generated
   */
  void setOptions(Options value);

  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(RuleElement)
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRuleOptions_Element()
   * @model containment="true"
   * @generated
   */
  RuleElement getElement();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(RuleElement value);

} // RuleOptions
