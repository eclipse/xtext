/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#isFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends EObject
{
  /**
   * Returns the value of the '<em><b>Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fragment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fragment</em>' attribute.
   * @see #setFragment(boolean)
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRule_Fragment()
   * @model
   * @generated
   */
  boolean isFragment();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#isFragment <em>Fragment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fragment</em>' attribute.
   * @see #isFragment()
   * @generated
   */
  void setFragment(boolean value);

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
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRule_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(RuleElement)
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getRule_Body()
   * @model containment="true"
   * @generated
   */
  RuleElement getBody();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(RuleElement value);

} // Rule
