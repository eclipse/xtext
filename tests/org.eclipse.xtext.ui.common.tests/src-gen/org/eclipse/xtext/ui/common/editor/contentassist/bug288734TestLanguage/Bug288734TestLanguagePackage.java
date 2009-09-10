/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage;

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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Bug288734TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug288734TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug288734TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/bug288734TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug288734TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug288734TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONSTANTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TConstantImpl <em>TConstant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TConstantImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTConstant()
   * @generated
   */
  int TCONSTANT = 1;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTANT__ANNOTATIONS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTANT__NAME = 1;

  /**
   * The number of structural features of the '<em>TConstant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTANT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TStringConstantImpl <em>TString Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TStringConstantImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTStringConstant()
   * @generated
   */
  int TSTRING_CONSTANT = 2;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTRING_CONSTANT__ANNOTATIONS = TCONSTANT__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTRING_CONSTANT__NAME = TCONSTANT__NAME;

  /**
   * The number of structural features of the '<em>TString Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSTRING_CONSTANT_FEATURE_COUNT = TCONSTANT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TIntegerConstantImpl <em>TInteger Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TIntegerConstantImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTIntegerConstant()
   * @generated
   */
  int TINTEGER_CONSTANT = 3;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTEGER_CONSTANT__ANNOTATIONS = TCONSTANT__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTEGER_CONSTANT__NAME = TCONSTANT__NAME;

  /**
   * The number of structural features of the '<em>TInteger Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTEGER_CONSTANT_FEATURE_COUNT = TCONSTANT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TBooleanConstantImpl <em>TBoolean Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TBooleanConstantImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTBooleanConstant()
   * @generated
   */
  int TBOOLEAN_CONSTANT = 4;

  /**
   * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOOLEAN_CONSTANT__ANNOTATIONS = TCONSTANT__ANNOTATIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOOLEAN_CONSTANT__NAME = TCONSTANT__NAME;

  /**
   * The number of structural features of the '<em>TBoolean Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOOLEAN_CONSTANT_FEATURE_COUNT = TCONSTANT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TAnnotationImpl <em>TAnnotation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TAnnotationImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTAnnotation()
   * @generated
   */
  int TANNOTATION = 5;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TANNOTATION__DESCRIPTION = 0;

  /**
   * The number of structural features of the '<em>TAnnotation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TANNOTATION_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Model#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Model#getConstants()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Constants();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant <em>TConstant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TConstant</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant
   * @generated
   */
  EClass getTConstant();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant#getAnnotations <em>Annotations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Annotations</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant#getAnnotations()
   * @see #getTConstant()
   * @generated
   */
  EReference getTConstant_Annotations();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TConstant#getName()
   * @see #getTConstant()
   * @generated
   */
  EAttribute getTConstant_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TStringConstant <em>TString Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TString Constant</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TStringConstant
   * @generated
   */
  EClass getTStringConstant();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TIntegerConstant <em>TInteger Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TInteger Constant</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TIntegerConstant
   * @generated
   */
  EClass getTIntegerConstant();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TBooleanConstant <em>TBoolean Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TBoolean Constant</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TBooleanConstant
   * @generated
   */
  EClass getTBooleanConstant();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TAnnotation <em>TAnnotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TAnnotation</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TAnnotation
   * @generated
   */
  EClass getTAnnotation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TAnnotation#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.TAnnotation#getDescription()
   * @see #getTAnnotation()
   * @generated
   */
  EAttribute getTAnnotation_Description();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug288734TestLanguageFactory getBug288734TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CONSTANTS = eINSTANCE.getModel_Constants();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TConstantImpl <em>TConstant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TConstantImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTConstant()
     * @generated
     */
    EClass TCONSTANT = eINSTANCE.getTConstant();

    /**
     * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TCONSTANT__ANNOTATIONS = eINSTANCE.getTConstant_Annotations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCONSTANT__NAME = eINSTANCE.getTConstant_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TStringConstantImpl <em>TString Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TStringConstantImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTStringConstant()
     * @generated
     */
    EClass TSTRING_CONSTANT = eINSTANCE.getTStringConstant();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TIntegerConstantImpl <em>TInteger Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TIntegerConstantImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTIntegerConstant()
     * @generated
     */
    EClass TINTEGER_CONSTANT = eINSTANCE.getTIntegerConstant();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TBooleanConstantImpl <em>TBoolean Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TBooleanConstantImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTBooleanConstant()
     * @generated
     */
    EClass TBOOLEAN_CONSTANT = eINSTANCE.getTBooleanConstant();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TAnnotationImpl <em>TAnnotation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.TAnnotationImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguagePackageImpl#getTAnnotation()
     * @generated
     */
    EClass TANNOTATION = eINSTANCE.getTAnnotation();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TANNOTATION__DESCRIPTION = eINSTANCE.getTAnnotation_Description();

  }

} //Bug288734TestLanguagePackage
