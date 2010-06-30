/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtype.XtypePackage
 * @generated
 */
public interface XtypeFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtypeFactory eINSTANCE = org.eclipse.xtext.xtype.impl.XtypeFactoryImpl.init();

  /**
   * Returns a new object of class '<em>XFunction Type Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>XFunction Type Ref</em>'.
   * @generated
   */
  XFunctionTypeRef createXFunctionTypeRef();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XtypePackage getXtypePackage();

} //XtypeFactory
