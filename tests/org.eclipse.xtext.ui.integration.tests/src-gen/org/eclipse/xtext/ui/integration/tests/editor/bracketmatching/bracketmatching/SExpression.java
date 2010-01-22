/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SExpression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.SExpression#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage#getSExpression()
 * @model
 * @generated
 */
public interface SExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference list.
   * @see org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage#getSExpression_Element()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElement();

} // SExpression
