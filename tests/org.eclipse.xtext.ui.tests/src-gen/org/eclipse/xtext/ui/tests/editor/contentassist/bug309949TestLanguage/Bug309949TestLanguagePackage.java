/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug309949TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug309949TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2010/bug309949TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug309949TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug309949TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Errors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ERRORS = 0;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__OPERATIONS = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ErrorImpl <em>Error</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ErrorImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getError()
   * @generated
   */
  int ERROR = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR__NAME = 1;

  /**
   * The number of structural features of the '<em>Error</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ERROR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.OperationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = 1;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.AnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.AnnotationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getAnnotation()
   * @generated
   */
  int ANNOTATION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION__NAME = 0;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANNOTATION_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getErrors <em>Errors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Errors</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getErrors()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Errors();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getOperations()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Operations();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error
   * @generated
   */
  EClass getError();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error#getAnnotations()
   * @see #getError()
   * @generated
   */
  EReference getError_Annotations();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error#getName()
   * @see #getError()
   * @generated
   */
  EAttribute getError_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation#getAnnotations()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Annotations();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation#getName()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Annotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Annotation
   * @generated
   */
  EClass getAnnotation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Annotation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Annotation#getName()
   * @see #getAnnotation()
   * @generated
   */
  EAttribute getAnnotation_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug309949TestLanguageFactory getBug309949TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Errors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ERRORS = eINSTANCE.getModel_Errors();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__OPERATIONS = eINSTANCE.getModel_Operations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ErrorImpl <em>Error</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.ErrorImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getError()
     * @generated
     */
    EClass ERROR = eINSTANCE.getError();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ERROR__ANNOTATIONS = eINSTANCE.getError_Annotations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ERROR__NAME = eINSTANCE.getError_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.OperationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__ANNOTATIONS = eINSTANCE.getOperation_Annotations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.AnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.AnnotationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl.Bug309949TestLanguagePackageImpl#getAnnotation()
     * @generated
     */
    EClass ANNOTATION = eINSTANCE.getAnnotation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANNOTATION__NAME = eINSTANCE.getAnnotation_Name();

  }

} //Bug309949TestLanguagePackage
