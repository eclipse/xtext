/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsPackage
 * @generated
 */
public interface TwoContextsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TwoContextsFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Main Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Main Model</em>'.
   * @generated
   */
  MainModel createMainModel();

  /**
   * Returns a new object of class '<em>An Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>An Element</em>'.
   * @generated
   */
  AnElement createAnElement();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TwoContextsPackage getTwoContextsPackage();

} //TwoContextsFactory
