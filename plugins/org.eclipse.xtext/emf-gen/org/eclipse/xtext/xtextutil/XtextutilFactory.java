/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextutilFactory.java,v 1.10 2008/05/23 08:22:20 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextutil;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtextutil.XtextutilPackage
 * @generated
 */
public interface XtextutilFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtextutilFactory eINSTANCE = org.eclipse.xtext.xtextutil.impl.XtextutilFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Resolved Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resolved Type</em>'.
   * @generated
   */
  ResolvedType createResolvedType();

  /**
   * Returns a new object of class '<em>Meta Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Model</em>'.
   * @generated
   */
  MetaModel createMetaModel();

  /**
   * Returns a new object of class '<em>Builtin Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Builtin Type</em>'.
   * @generated
   */
  BuiltinType createBuiltinType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XtextutilPackage getXtextutilPackage();

} //XtextutilFactory
