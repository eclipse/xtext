/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage
 * @generated
 */
public interface EpatchTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EpatchTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>EPatch</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EPatch</em>'.
   * @generated
   */
  EPatch createEPatch();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Model Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Import</em>'.
   * @generated
   */
  ModelImport createModelImport();

  /**
   * Returns a new object of class '<em>Resource Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resource Import</em>'.
   * @generated
   */
  ResourceImport createResourceImport();

  /**
   * Returns a new object of class '<em>EPackage Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EPackage Import</em>'.
   * @generated
   */
  EPackageImport createEPackageImport();

  /**
   * Returns a new object of class '<em>Java Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Import</em>'.
   * @generated
   */
  JavaImport createJavaImport();

  /**
   * Returns a new object of class '<em>Extension Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extension Import</em>'.
   * @generated
   */
  ExtensionImport createExtensionImport();

  /**
   * Returns a new object of class '<em>Named Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Resource</em>'.
   * @generated
   */
  NamedResource createNamedResource();

  /**
   * Returns a new object of class '<em>Named Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Object</em>'.
   * @generated
   */
  NamedObject createNamedObject();

  /**
   * Returns a new object of class '<em>Object Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Ref</em>'.
   * @generated
   */
  ObjectRef createObjectRef();

  /**
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
  Assignment createAssignment();

  /**
   * Returns a new object of class '<em>Single Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Assignment</em>'.
   * @generated
   */
  SingleAssignment createSingleAssignment();

  /**
   * Returns a new object of class '<em>List Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Assignment</em>'.
   * @generated
   */
  ListAssignment createListAssignment();

  /**
   * Returns a new object of class '<em>Assignment Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Value</em>'.
   * @generated
   */
  AssignmentValue createAssignmentValue();

  /**
   * Returns a new object of class '<em>Created Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Created Object</em>'.
   * @generated
   */
  CreatedObject createCreatedObject();

  /**
   * Returns a new object of class '<em>Object New</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object New</em>'.
   * @generated
   */
  ObjectNew createObjectNew();

  /**
   * Returns a new object of class '<em>Object Copy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Copy</em>'.
   * @generated
   */
  ObjectCopy createObjectCopy();

  /**
   * Returns a new object of class '<em>Migration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Migration</em>'.
   * @generated
   */
  Migration createMigration();

  /**
   * Returns a new object of class '<em>Executable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Executable</em>'.
   * @generated
   */
  Executable createExecutable();

  /**
   * Returns a new object of class '<em>Java Executable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Executable</em>'.
   * @generated
   */
  JavaExecutable createJavaExecutable();

  /**
   * Returns a new object of class '<em>Expression Executable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Executable</em>'.
   * @generated
   */
  ExpressionExecutable createExpressionExecutable();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EpatchTestLanguagePackage getEpatchTestLanguagePackage();

} //EpatchTestLanguageFactory
