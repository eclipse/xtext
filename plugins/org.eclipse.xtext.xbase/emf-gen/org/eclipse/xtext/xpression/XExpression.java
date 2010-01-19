/**
 * <copyright>
 * </copyright>
 *
 * $Id: XExpression.java,v 1.2 2010/01/19 19:53:09 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XTypeRef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XExpression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXExpression()
 * @model abstract="true"
 * @generated
 */
public interface XExpression extends EObject
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
  XTypeRef getDerivedReturnType();

} // XExpression
