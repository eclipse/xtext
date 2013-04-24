/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug381381TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug381381TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2012/bug381381TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug381381TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug381381TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Stmt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STMT = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl <em>Copy Field Name To Variable Stmt</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguagePackageImpl#getCopyFieldNameToVariableStmt()
   * @generated
   */
  int COPY_FIELD_NAME_TO_VARIABLE_STMT = 1;

  /**
   * The feature id for the '<em><b>Line</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE = 0;

  /**
   * The feature id for the '<em><b>Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME = 2;

  /**
   * The number of structural features of the '<em>Copy Field Name To Variable Stmt</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COPY_FIELD_NAME_TO_VARIABLE_STMT_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model#getStmt <em>Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Stmt</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Model#getStmt()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Stmt();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt <em>Copy Field Name To Variable Stmt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Copy Field Name To Variable Stmt</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt
   * @generated
   */
  EClass getCopyFieldNameToVariableStmt();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getLine <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Line</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getLine()
   * @see #getCopyFieldNameToVariableStmt()
   * @generated
   */
  EAttribute getCopyFieldNameToVariableStmt_Line();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getColumn <em>Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Column</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getColumn()
   * @see #getCopyFieldNameToVariableStmt()
   * @generated
   */
  EAttribute getCopyFieldNameToVariableStmt_Column();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.CopyFieldNameToVariableStmt#getName()
   * @see #getCopyFieldNameToVariableStmt()
   * @generated
   */
  EAttribute getCopyFieldNameToVariableStmt_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug381381TestLanguageFactory getBug381381TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Stmt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__STMT = eINSTANCE.getModel_Stmt();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl <em>Copy Field Name To Variable Stmt</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.CopyFieldNameToVariableStmtImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguagePackageImpl#getCopyFieldNameToVariableStmt()
     * @generated
     */
    EClass COPY_FIELD_NAME_TO_VARIABLE_STMT = eINSTANCE.getCopyFieldNameToVariableStmt();

    /**
     * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COPY_FIELD_NAME_TO_VARIABLE_STMT__LINE = eINSTANCE.getCopyFieldNameToVariableStmt_Line();

    /**
     * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COPY_FIELD_NAME_TO_VARIABLE_STMT__COLUMN = eINSTANCE.getCopyFieldNameToVariableStmt_Column();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COPY_FIELD_NAME_TO_VARIABLE_STMT__NAME = eINSTANCE.getCopyFieldNameToVariableStmt_Name();

  }

} //Bug381381TestLanguagePackage
