/**
 * <copyright>
 * </copyright>
 *
 * $Id: Alternatives.java,v 1.1 2009/02/06 09:46:51 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternatives</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Alternatives#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getAlternatives()
 * @model
 * @generated
 */
public interface Alternatives extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groups</em>' containment reference list.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getAlternatives_Groups()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getGroups();

} // Alternatives
