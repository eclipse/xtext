/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestPackage
 * @generated
 */
public interface TransientvaluestestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TransientvaluestestFactory eINSTANCE = org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns a new object of class '<em>Test Required</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Required</em>'.
   * @generated
   */
  TestRequired createTestRequired();

  /**
   * Returns a new object of class '<em>Test Optional</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Optional</em>'.
   * @generated
   */
  TestOptional createTestOptional();

  /**
   * Returns a new object of class '<em>Test List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test List</em>'.
   * @generated
   */
  TestList createTestList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TransientvaluestestPackage getTransientvaluestestPackage();

} //TransientvaluestestFactory
