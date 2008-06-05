/**
 * <copyright>
 * </copyright>
 *
 * $Id: Group.java,v 1.10 2008/06/05 15:03:50 sefftinge Exp $
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.Group#getAbstractTokens <em>Abstract Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends AbstractElement
{
  /**
	 * Returns the value of the '<em><b>Abstract Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.AbstractElement}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Tokens</em>' containment reference list.
	 * @see org.eclipse.xtext.XtextPackage#getGroup_AbstractTokens()
	 * @model containment="true"
	 * @generated
	 */
  EList<AbstractElement> getAbstractTokens();

} // Group
