/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage;

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
 * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.RefactoringTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface RefactoringTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "refactoringTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2011/xtext/ui/common/types/xtext/ui/Refactoring";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "refactoringTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RefactoringTestLanguagePackage eINSTANCE = org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.RefactoringTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.RefactoringTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Reference Holder</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__REFERENCE_HOLDER = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl <em>Reference Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.RefactoringTestLanguagePackageImpl#getReferenceHolder()
   * @generated
   */
  int REFERENCE_HOLDER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER__NAME = 0;

  /**
   * The feature id for the '<em><b>Default Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER__DEFAULT_REFERENCE = 1;

  /**
   * The number of structural features of the '<em>Reference Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model#getReferenceHolder <em>Reference Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Reference Holder</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model#getReferenceHolder()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ReferenceHolder();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder <em>Reference Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Holder</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder
   * @generated
   */
  EClass getReferenceHolder();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getName()
   * @see #getReferenceHolder()
   * @generated
   */
  EAttribute getReferenceHolder_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Default Reference</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder#getDefaultReference()
   * @see #getReferenceHolder()
   * @generated
   */
  EReference getReferenceHolder_DefaultReference();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RefactoringTestLanguageFactory getRefactoringTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.RefactoringTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Reference Holder</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__REFERENCE_HOLDER = eINSTANCE.getModel_ReferenceHolder();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl <em>Reference Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.ReferenceHolderImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl.RefactoringTestLanguagePackageImpl#getReferenceHolder()
     * @generated
     */
    EClass REFERENCE_HOLDER = eINSTANCE.getReferenceHolder();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_HOLDER__NAME = eINSTANCE.getReferenceHolder_Name();

    /**
     * The meta object literal for the '<em><b>Default Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_HOLDER__DEFAULT_REFERENCE = eINSTANCE.getReferenceHolder_DefaultReference();

  }

} //RefactoringTestLanguagePackage
