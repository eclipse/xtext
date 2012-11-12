/**
 */
package org.eclipse.xtend.macro.lang.macro;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtend.core.xtend.XtendPackage;

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
 * @see org.eclipse.xtend.macro.lang.macro.MacroFactory
 * @model kind="package"
 * @generated
 */
public interface MacroPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "macro";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtend/macro/lang/Macro";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "macro";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MacroPackage eINSTANCE = org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl <em>Annotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl
   * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getMacroAnnotation()
   * @generated
   */
  int MACRO_ANNOTATION = 0;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION__ANNOTATIONS = XtendPackage.XTEND_TYPE_DECLARATION__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION__ANNOTATION_INFO = XtendPackage.XTEND_TYPE_DECLARATION__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION__NAME = XtendPackage.XTEND_TYPE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Target Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION__TARGET_TYPE = XtendPackage.XTEND_TYPE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION__MEMBERS = XtendPackage.XTEND_TYPE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Annotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MACRO_ANNOTATION_FEATURE_COUNT = XtendPackage.XTEND_TYPE_DECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtend.macro.lang.macro.impl.RegistratorImpl <em>Registrator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtend.macro.lang.macro.impl.RegistratorImpl
   * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getRegistrator()
   * @generated
   */
  int REGISTRATOR = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTRATOR__ANNOTATIONS = XtendPackage.XTEND_MEMBER__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTRATOR__ANNOTATION_INFO = XtendPackage.XTEND_MEMBER__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTRATOR__EXPRESSION = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Registrator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTRATOR_FEATURE_COUNT = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtend.macro.lang.macro.impl.ProcessorImpl <em>Processor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtend.macro.lang.macro.impl.ProcessorImpl
   * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getProcessor()
   * @generated
   */
  int PROCESSOR = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__ANNOTATIONS = XtendPackage.XTEND_MEMBER__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Annotation Info</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__ANNOTATION_INFO = XtendPackage.XTEND_MEMBER__ANNOTATION_INFO;

  /**
   * The feature id for the '<em><b>Each</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__EACH = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__VARIABLE_NAME = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR__EXPRESSION = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Processor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESSOR_FEATURE_COUNT = XtendPackage.XTEND_MEMBER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtend.macro.lang.macro.TargetType <em>Target Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtend.macro.lang.macro.TargetType
   * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getTargetType()
   * @generated
   */
  int TARGET_TYPE = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtend.macro.lang.macro.MacroAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Annotation</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.MacroAnnotation
   * @generated
   */
  EClass getMacroAnnotation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getTargetType <em>Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Target Type</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getTargetType()
   * @see #getMacroAnnotation()
   * @generated
   */
  EAttribute getMacroAnnotation_TargetType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.MacroAnnotation#getMembers()
   * @see #getMacroAnnotation()
   * @generated
   */
  EReference getMacroAnnotation_Members();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtend.macro.lang.macro.Registrator <em>Registrator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Registrator</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Registrator
   * @generated
   */
  EClass getRegistrator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtend.macro.lang.macro.Registrator#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Registrator#getExpression()
   * @see #getRegistrator()
   * @generated
   */
  EReference getRegistrator_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtend.macro.lang.macro.Processor <em>Processor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Processor</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Processor
   * @generated
   */
  EClass getProcessor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtend.macro.lang.macro.Processor#isEach <em>Each</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Each</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Processor#isEach()
   * @see #getProcessor()
   * @generated
   */
  EAttribute getProcessor_Each();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtend.macro.lang.macro.Processor#getVariableName <em>Variable Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable Name</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Processor#getVariableName()
   * @see #getProcessor()
   * @generated
   */
  EAttribute getProcessor_VariableName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtend.macro.lang.macro.Processor#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.Processor#getExpression()
   * @see #getProcessor()
   * @generated
   */
  EReference getProcessor_Expression();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtend.macro.lang.macro.TargetType <em>Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Target Type</em>'.
   * @see org.eclipse.xtend.macro.lang.macro.TargetType
   * @generated
   */
  EEnum getTargetType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MacroFactory getMacroFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl <em>Annotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtend.macro.lang.macro.impl.MacroAnnotationImpl
     * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getMacroAnnotation()
     * @generated
     */
    EClass MACRO_ANNOTATION = eINSTANCE.getMacroAnnotation();

    /**
     * The meta object literal for the '<em><b>Target Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MACRO_ANNOTATION__TARGET_TYPE = eINSTANCE.getMacroAnnotation_TargetType();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MACRO_ANNOTATION__MEMBERS = eINSTANCE.getMacroAnnotation_Members();

    /**
     * The meta object literal for the '{@link org.eclipse.xtend.macro.lang.macro.impl.RegistratorImpl <em>Registrator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtend.macro.lang.macro.impl.RegistratorImpl
     * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getRegistrator()
     * @generated
     */
    EClass REGISTRATOR = eINSTANCE.getRegistrator();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGISTRATOR__EXPRESSION = eINSTANCE.getRegistrator_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtend.macro.lang.macro.impl.ProcessorImpl <em>Processor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtend.macro.lang.macro.impl.ProcessorImpl
     * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getProcessor()
     * @generated
     */
    EClass PROCESSOR = eINSTANCE.getProcessor();

    /**
     * The meta object literal for the '<em><b>Each</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROCESSOR__EACH = eINSTANCE.getProcessor_Each();

    /**
     * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROCESSOR__VARIABLE_NAME = eINSTANCE.getProcessor_VariableName();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCESSOR__EXPRESSION = eINSTANCE.getProcessor_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtend.macro.lang.macro.TargetType <em>Target Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtend.macro.lang.macro.TargetType
     * @see org.eclipse.xtend.macro.lang.macro.impl.MacroPackageImpl#getTargetType()
     * @generated
     */
    EEnum TARGET_TYPE = eINSTANCE.getTargetType();

  }

} //MacroPackage
