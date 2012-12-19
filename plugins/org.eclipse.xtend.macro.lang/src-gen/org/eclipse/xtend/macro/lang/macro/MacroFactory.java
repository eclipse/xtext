/**
 */
package org.eclipse.xtend.macro.lang.macro;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.macro.lang.macro.MacroPackage
 * @generated
 */
public interface MacroFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MacroFactory eINSTANCE = org.eclipse.xtend.macro.lang.macro.impl.MacroFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  MacroAnnotation createMacroAnnotation();

  /**
   * Returns a new object of class '<em>Registrator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Registrator</em>'.
   * @generated
   */
  Registrator createRegistrator();

  /**
   * Returns a new object of class '<em>Processor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Processor</em>'.
   * @generated
   */
  Processor createProcessor();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MacroPackage getMacroPackage();

} //MacroFactory
