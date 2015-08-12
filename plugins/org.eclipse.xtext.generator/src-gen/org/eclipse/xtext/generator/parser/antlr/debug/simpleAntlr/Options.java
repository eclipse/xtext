/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options#getOptionValues <em>Option Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getOptions()
 * @model
 * @generated
 */
public interface Options extends EObject
{
  /**
   * Returns the value of the '<em><b>Option Values</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Option Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Option Values</em>' containment reference list.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getOptions_OptionValues()
   * @model containment="true"
   * @generated
   */
  EList<OptionValue> getOptionValues();

} // Options
