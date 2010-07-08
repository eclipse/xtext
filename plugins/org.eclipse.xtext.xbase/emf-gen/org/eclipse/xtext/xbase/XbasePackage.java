/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.XbaseFactory
 * @model kind="package"
 * @generated
 */
public interface XbasePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xbase";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/Xbase";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xbase";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XbasePackage eINSTANCE = org.eclipse.xtext.xbase.impl.XbasePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XFileImpl <em>XFile</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.impl.XFileImpl
   * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFile()
   * @generated
   */
  int XFILE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFILE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFILE__CLASSES = 1;

  /**
   * The feature id for the '<em><b>Package</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFILE__PACKAGE = 2;

  /**
   * The number of structural features of the '<em>XFile</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XImportImpl <em>XImport</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.impl.XImportImpl
   * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXImport()
   * @generated
   */
  int XIMPORT = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT__WILDCARD = 1;

  /**
   * The number of structural features of the '<em>XImport</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XFunctionImpl <em>XFunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.impl.XFunctionImpl
   * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFunction()
   * @generated
   */
  int XFUNCTION = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__ANNOTATIONS = TypesPackage.JVM_OPERATION__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__DECLARING_TYPE = TypesPackage.JVM_OPERATION__DECLARING_TYPE;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__VISIBILITY = TypesPackage.JVM_OPERATION__VISIBILITY;

  /**
   * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__FULLY_QUALIFIED_NAME = TypesPackage.JVM_OPERATION__FULLY_QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__TYPE_PARAMETERS = TypesPackage.JVM_OPERATION__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__PARAMETERS = TypesPackage.JVM_OPERATION__PARAMETERS;

  /**
   * The feature id for the '<em><b>Exceptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__EXCEPTIONS = TypesPackage.JVM_OPERATION__EXCEPTIONS;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__STATIC = TypesPackage.JVM_OPERATION__STATIC;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__FINAL = TypesPackage.JVM_OPERATION__FINAL;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__ABSTRACT = TypesPackage.JVM_OPERATION__ABSTRACT;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__RETURN_TYPE = TypesPackage.JVM_OPERATION__RETURN_TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__NAME = TypesPackage.JVM_OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION__EXPRESSION = TypesPackage.JVM_OPERATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XFunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION_FEATURE_COUNT = TypesPackage.JVM_OPERATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XClassImpl <em>XClass</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xbase.impl.XClassImpl
   * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXClass()
   * @generated
   */
  int XCLASS = 3;

  /**
   * The feature id for the '<em><b>Array Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__ARRAY_TYPE = TypesPackage.JVM_GENERIC_TYPE__ARRAY_TYPE;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__ANNOTATIONS = TypesPackage.JVM_GENERIC_TYPE__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__DECLARING_TYPE = TypesPackage.JVM_GENERIC_TYPE__DECLARING_TYPE;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__VISIBILITY = TypesPackage.JVM_GENERIC_TYPE__VISIBILITY;

  /**
   * The feature id for the '<em><b>Fully Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__FULLY_QUALIFIED_NAME = TypesPackage.JVM_GENERIC_TYPE__FULLY_QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__SUPER_TYPES = TypesPackage.JVM_GENERIC_TYPE__SUPER_TYPES;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__MEMBERS = TypesPackage.JVM_GENERIC_TYPE__MEMBERS;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__ABSTRACT = TypesPackage.JVM_GENERIC_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__STATIC = TypesPackage.JVM_GENERIC_TYPE__STATIC;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__FINAL = TypesPackage.JVM_GENERIC_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__TYPE_PARAMETERS = TypesPackage.JVM_GENERIC_TYPE__TYPE_PARAMETERS;

  /**
   * The feature id for the '<em><b>Interface</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__INTERFACE = TypesPackage.JVM_GENERIC_TYPE__INTERFACE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__NAME = TypesPackage.JVM_GENERIC_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__EXTENDS = TypesPackage.JVM_GENERIC_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Implements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS__IMPLEMENTS = TypesPackage.JVM_GENERIC_TYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>XClass</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XCLASS_FEATURE_COUNT = TypesPackage.JVM_GENERIC_TYPE_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XFile <em>XFile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XFile</em>'.
   * @see org.eclipse.xtext.xbase.XFile
   * @generated
   */
  EClass getXFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XFile#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.xbase.XFile#getImports()
   * @see #getXFile()
   * @generated
   */
  EReference getXFile_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XFile#getClasses <em>Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Classes</em>'.
   * @see org.eclipse.xtext.xbase.XFile#getClasses()
   * @see #getXFile()
   * @generated
   */
  EReference getXFile_Classes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XFile#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package</em>'.
   * @see org.eclipse.xtext.xbase.XFile#getPackage()
   * @see #getXFile()
   * @generated
   */
  EAttribute getXFile_Package();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XImport <em>XImport</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XImport</em>'.
   * @see org.eclipse.xtext.xbase.XImport
   * @generated
   */
  EClass getXImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XImport#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.xbase.XImport#getImportedNamespace()
   * @see #getXImport()
   * @generated
   */
  EAttribute getXImport_ImportedNamespace();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XImport#isWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see org.eclipse.xtext.xbase.XImport#isWildcard()
   * @see #getXImport()
   * @generated
   */
  EAttribute getXImport_Wildcard();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XFunction <em>XFunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XFunction</em>'.
   * @see org.eclipse.xtext.xbase.XFunction
   * @generated
   */
  EClass getXFunction();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.XFunction#getName()
   * @see #getXFunction()
   * @generated
   */
  EAttribute getXFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XFunction#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xbase.XFunction#getExpression()
   * @see #getXFunction()
   * @generated
   */
  EReference getXFunction_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XClass <em>XClass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XClass</em>'.
   * @see org.eclipse.xtext.xbase.XClass
   * @generated
   */
  EClass getXClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xbase.XClass#getName()
   * @see #getXClass()
   * @generated
   */
  EAttribute getXClass_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.XClass#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see org.eclipse.xtext.xbase.XClass#getExtends()
   * @see #getXClass()
   * @generated
   */
  EReference getXClass_Extends();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.xbase.XClass#getImplements <em>Implements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Implements</em>'.
   * @see org.eclipse.xtext.xbase.XClass#getImplements()
   * @see #getXClass()
   * @generated
   */
  EReference getXClass_Implements();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XbaseFactory getXbaseFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XFileImpl <em>XFile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.impl.XFileImpl
     * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFile()
     * @generated
     */
    EClass XFILE = eINSTANCE.getXFile();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XFILE__IMPORTS = eINSTANCE.getXFile_Imports();

    /**
     * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XFILE__CLASSES = eINSTANCE.getXFile_Classes();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XFILE__PACKAGE = eINSTANCE.getXFile_Package();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XImportImpl <em>XImport</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.impl.XImportImpl
     * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXImport()
     * @generated
     */
    EClass XIMPORT = eINSTANCE.getXImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XIMPORT__IMPORTED_NAMESPACE = eINSTANCE.getXImport_ImportedNamespace();

    /**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XIMPORT__WILDCARD = eINSTANCE.getXImport_Wildcard();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XFunctionImpl <em>XFunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.impl.XFunctionImpl
     * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFunction()
     * @generated
     */
    EClass XFUNCTION = eINSTANCE.getXFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XFUNCTION__NAME = eINSTANCE.getXFunction_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XFUNCTION__EXPRESSION = eINSTANCE.getXFunction_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XClassImpl <em>XClass</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xbase.impl.XClassImpl
     * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXClass()
     * @generated
     */
    EClass XCLASS = eINSTANCE.getXClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XCLASS__NAME = eINSTANCE.getXClass_Name();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XCLASS__EXTENDS = eINSTANCE.getXClass_Extends();

    /**
     * The meta object literal for the '<em><b>Implements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XCLASS__IMPLEMENTS = eINSTANCE.getXClass_Implements();

  }

} //XbasePackage
