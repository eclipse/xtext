/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguagePackage
 * @generated
 */
public interface FormattertestlanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormattertestlanguageFactory eINSTANCE = org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns a new object of class '<em>Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Line</em>'.
   * @generated
   */
  Line createLine();

  /**
   * Returns a new object of class '<em>Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decl</em>'.
   * @generated
   */
  Decl createDecl();

  /**
   * Returns a new object of class '<em>Assign</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assign</em>'.
   * @generated
   */
  Assign createAssign();

  /**
   * Returns a new object of class '<em>Meth</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meth</em>'.
   * @generated
   */
  Meth createMeth();

  /**
   * Returns a new object of class '<em>Param</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Param</em>'.
   * @generated
   */
  Param createParam();

  /**
   * Returns a new object of class '<em>Space</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Space</em>'.
   * @generated
   */
  Space createSpace();

  /**
   * Returns a new object of class '<em>Test Linewrap</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Linewrap</em>'.
   * @generated
   */
  TestLinewrap createTestLinewrap();

  /**
   * Returns a new object of class '<em>Test Linewrap Min Max</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Linewrap Min Max</em>'.
   * @generated
   */
  TestLinewrapMinMax createTestLinewrapMinMax();

  /**
   * Returns a new object of class '<em>Test Indentation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Indentation</em>'.
   * @generated
   */
  TestIndentation createTestIndentation();

  /**
   * Returns a new object of class '<em>Fqn Obj</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fqn Obj</em>'.
   * @generated
   */
  FqnObj createFqnObj();

  /**
   * Returns a new object of class '<em>Fqn Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fqn Ref</em>'.
   * @generated
   */
  FqnRef createFqnRef();

  /**
   * Returns a new object of class '<em>Enumeration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration</em>'.
   * @generated
   */
  Enumeration createEnumeration();

  /**
   * Returns a new object of class '<em>Suppressed Hidden</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suppressed Hidden</em>'.
   * @generated
   */
  SuppressedHidden createSuppressedHidden();

  /**
   * Returns a new object of class '<em>Suppressed Hidden Sub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suppressed Hidden Sub</em>'.
   * @generated
   */
  SuppressedHiddenSub createSuppressedHiddenSub();

  /**
   * Returns a new object of class '<em>Suppressed Hidden Sub Sub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suppressed Hidden Sub Sub</em>'.
   * @generated
   */
  SuppressedHiddenSubSub createSuppressedHiddenSubSub();

  /**
   * Returns a new object of class '<em>Suppressed Hidden Sub ID</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suppressed Hidden Sub ID</em>'.
   * @generated
   */
  SuppressedHiddenSubID createSuppressedHiddenSubID();

  /**
   * Returns a new object of class '<em>Datatypes</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Datatypes</em>'.
   * @generated
   */
  Datatypes createDatatypes();

  /**
   * Returns a new object of class '<em>Wrapping Data Type Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wrapping Data Type Test</em>'.
   * @generated
   */
  WrappingDataTypeTest createWrappingDataTypeTest();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FormattertestlanguagePackage getFormattertestlanguagePackage();

} //FormattertestlanguageFactory
