/**
 */
package org.eclipse.xtext.testlanguages.actionLang2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.actionLang2.ActionLang2Package
 * @generated
 */
public interface ActionLang2Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionLang2Factory eINSTANCE = org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2FactoryImpl.init();

  /**
   * Returns a new object of class '<em>ORing</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ORing</em>'.
   * @generated
   */
  ORing createORing();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ActionLang2Package getActionLang2Package();

} //ActionLang2Factory
