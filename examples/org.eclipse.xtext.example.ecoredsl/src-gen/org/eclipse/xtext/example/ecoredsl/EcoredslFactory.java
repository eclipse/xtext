/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.example.ecoredsl.EcoredslPackage
 * @generated
 */
public interface EcoredslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EcoredslFactory eINSTANCE = org.eclipse.xtext.example.ecoredsl.impl.EcoredslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Ecore Dsl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ecore Dsl</em>'.
   * @generated
   */
  EcoreDsl createEcoreDsl();

  /**
   * Returns a new object of class '<em>Referenced Metamodel</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenced Metamodel</em>'.
   * @generated
   */
  ReferencedMetamodel createReferencedMetamodel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EcoredslPackage getEcoredslPackage();

} //EcoredslFactory
