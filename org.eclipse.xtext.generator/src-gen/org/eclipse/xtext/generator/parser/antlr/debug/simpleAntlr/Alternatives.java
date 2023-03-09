/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternatives</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives#getGroups <em>Groups</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAlternatives()
 * @model
 * @generated
 */
public interface Alternatives extends RuleElement
{
  /**
   * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groups</em>' containment reference list.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage#getAlternatives_Groups()
   * @model containment="true"
   * @generated
   */
  EList<RuleElement> getGroups();

} // Alternatives
