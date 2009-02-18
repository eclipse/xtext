/**
 * <copyright>
 * </copyright>
 *
 * $Id: Group.java,v 1.2 2009/02/18 21:22:36 sefftinge Exp $
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.Group#getAbstractTokens <em>Abstract Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Abstract Tokens</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextTest.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Tokens</em>' containment reference list.
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getGroup_AbstractTokens()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getAbstractTokens();

} // Group
