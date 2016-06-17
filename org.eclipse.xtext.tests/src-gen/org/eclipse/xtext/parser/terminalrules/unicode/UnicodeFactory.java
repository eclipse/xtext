/**
 */
package org.eclipse.xtext.parser.terminalrules.unicode;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.terminalrules.unicode.UnicodePackage
 * @generated
 */
public interface UnicodeFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnicodeFactory eINSTANCE = org.eclipse.xtext.parser.terminalrules.unicode.impl.UnicodeFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Abstract String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract String</em>'.
   * @generated
   */
  AbstractString createAbstractString();

  /**
   * Returns a new object of class '<em>GString</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>GString</em>'.
   * @generated
   */
  GString createGString();

  /**
   * Returns a new object of class '<em>Quoted String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Quoted String</em>'.
   * @generated
   */
  QuotedString createQuotedString();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UnicodePackage getUnicodePackage();

} //UnicodeFactory
