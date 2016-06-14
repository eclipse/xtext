/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Antlr Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAntlrGrammar()
 * @model
 * @generated
 */
public interface AntlrGrammar extends EObject
{
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
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAntlrGrammar_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAntlrGrammar_Options()
   * @model containment="true"
   * @generated
   */
  Options getOptions();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar#getOptions <em>Options</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Options</em>' containment reference.
   * @see #getOptions()
   * @generated
   */
  void setOptions(Options value);

  /**
   * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rules</em>' containment reference list.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAntlrGrammar_Rules()
   * @model containment="true"
   * @generated
   */
  EList<Rule> getRules();

} // AntlrGrammar
