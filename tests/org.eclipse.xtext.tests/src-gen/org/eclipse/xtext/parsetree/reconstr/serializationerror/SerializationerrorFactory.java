/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage
 * @generated
 */
public interface SerializationerrorFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SerializationerrorFactory eINSTANCE = org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test</em>'.
   * @generated
   */
  Test createTest();

  /**
   * Returns a new object of class '<em>Two Required</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two Required</em>'.
   * @generated
   */
  TwoRequired createTwoRequired();

  /**
   * Returns a new object of class '<em>Two Options</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Two Options</em>'.
   * @generated
   */
  TwoOptions createTwoOptions();

  /**
   * Returns a new object of class '<em>Indent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indent</em>'.
   * @generated
   */
  Indent createIndent();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SerializationerrorPackage getSerializationerrorPackage();

} //SerializationerrorFactory
