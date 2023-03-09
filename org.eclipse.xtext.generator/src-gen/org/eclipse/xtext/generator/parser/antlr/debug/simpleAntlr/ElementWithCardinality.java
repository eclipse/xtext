/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element With Cardinality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getElementWithCardinality()
 * @model
 * @generated
 */
public interface ElementWithCardinality extends RuleElement
{
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
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getElementWithCardinality_Element()
   * @model containment="true"
   * @generated
   */
  RuleElement getElement();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(RuleElement value);

  /**
   * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' attribute.
   * @see #setCardinality(String)
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getElementWithCardinality_Cardinality()
   * @model
   * @generated
   */
  String getCardinality();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality#getCardinality <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' attribute.
   * @see #getCardinality()
   * @generated
   */
  void setCardinality(String value);

} // ElementWithCardinality
