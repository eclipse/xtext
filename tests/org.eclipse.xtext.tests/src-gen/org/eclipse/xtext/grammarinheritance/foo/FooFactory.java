/**
 */
package org.eclipse.xtext.grammarinheritance.foo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage
 * @generated
 */
public interface FooFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FooFactory eINSTANCE = org.eclipse.xtext.grammarinheritance.foo.impl.FooFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root Rule</em>'.
   * @generated
   */
  RootRule createRootRule();

  /**
   * Returns a new object of class '<em>Concrete Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concrete Parser Rule</em>'.
   * @generated
   */
  ConcreteParserRule createConcreteParserRule();

  /**
   * Returns a new object of class '<em>Call Overriden Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Overriden Parser Rule</em>'.
   * @generated
   */
  CallOverridenParserRule createCallOverridenParserRule();

  /**
   * Returns a new object of class '<em>AType2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>AType2</em>'.
   * @generated
   */
  AType2 createAType2();

  /**
   * Returns a new object of class '<em>Subrule1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subrule1</em>'.
   * @generated
   */
  Subrule1 createSubrule1();

  /**
   * Returns a new object of class '<em>Subrule2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subrule2</em>'.
   * @generated
   */
  Subrule2 createSubrule2();

  /**
   * Returns a new object of class '<em>Subrule3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subrule3</em>'.
   * @generated
   */
  Subrule3 createSubrule3();

  /**
   * Returns a new object of class '<em>Call Extended Parser Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Extended Parser Rule</em>'.
   * @generated
   */
  CallExtendedParserRule createCallExtendedParserRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FooPackage getFooPackage();

} //FooFactory
