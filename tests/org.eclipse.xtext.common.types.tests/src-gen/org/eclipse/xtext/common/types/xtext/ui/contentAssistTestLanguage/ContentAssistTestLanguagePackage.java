/**
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage;

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
 * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface ContentAssistTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contentAssistTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2010/xtext/ui/common/types/tests/ContentAssist";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contentAssistTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistTestLanguagePackage eINSTANCE = org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Generate Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__GENERATE_DIRECTIVE = 1;

  /**
   * The feature id for the '<em><b>Reference Holder</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__REFERENCE_HOLDER = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl <em>Reference Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getReferenceHolder()
   * @generated
   */
  int REFERENCE_HOLDER = 1;

  /**
   * The feature id for the '<em><b>Default Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER__DEFAULT_REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Customized Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER__CUSTOMIZED_REFERENCE = 1;

  /**
   * The feature id for the '<em><b>Subtype Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER__SUBTYPE_REFERENCE = 2;

  /**
   * The number of structural features of the '<em>Reference Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_HOLDER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.GenerateDirectiveImpl <em>Generate Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.GenerateDirectiveImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getGenerateDirective()
   * @generated
   */
  int GENERATE_DIRECTIVE = 2;

  /**
   * The feature id for the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_DIRECTIVE__TYPE_NAME = 0;

  /**
   * The number of structural features of the '<em>Generate Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_DIRECTIVE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ImportImpl
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getImport()
   * @generated
   */
  int IMPORT = 3;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getGenerateDirective <em>Generate Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Generate Directive</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getGenerateDirective()
   * @see #getModel()
   * @generated
   */
  EReference getModel_GenerateDirective();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getReferenceHolder <em>Reference Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reference Holder</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getReferenceHolder()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ReferenceHolder();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder <em>Reference Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Holder</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder
   * @generated
   */
  EClass getReferenceHolder();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getDefaultReference <em>Default Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Default Reference</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getDefaultReference()
   * @see #getReferenceHolder()
   * @generated
   */
  EReference getReferenceHolder_DefaultReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getCustomizedReference <em>Customized Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Customized Reference</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getCustomizedReference()
   * @see #getReferenceHolder()
   * @generated
   */
  EReference getReferenceHolder_CustomizedReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getSubtypeReference <em>Subtype Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Subtype Reference</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ReferenceHolder#getSubtypeReference()
   * @see #getReferenceHolder()
   * @generated
   */
  EReference getReferenceHolder_SubtypeReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective <em>Generate Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generate Directive</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective
   * @generated
   */
  EClass getGenerateDirective();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective#getTypeName <em>Type Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Name</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.GenerateDirective#getTypeName()
   * @see #getGenerateDirective()
   * @generated
   */
  EAttribute getGenerateDirective_TypeName();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContentAssistTestLanguageFactory getContentAssistTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Generate Directive</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__GENERATE_DIRECTIVE = eINSTANCE.getModel_GenerateDirective();

    /**
     * The meta object literal for the '<em><b>Reference Holder</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__REFERENCE_HOLDER = eINSTANCE.getModel_ReferenceHolder();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl <em>Reference Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ReferenceHolderImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getReferenceHolder()
     * @generated
     */
    EClass REFERENCE_HOLDER = eINSTANCE.getReferenceHolder();

    /**
     * The meta object literal for the '<em><b>Default Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_HOLDER__DEFAULT_REFERENCE = eINSTANCE.getReferenceHolder_DefaultReference();

    /**
     * The meta object literal for the '<em><b>Customized Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_HOLDER__CUSTOMIZED_REFERENCE = eINSTANCE.getReferenceHolder_CustomizedReference();

    /**
     * The meta object literal for the '<em><b>Subtype Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_HOLDER__SUBTYPE_REFERENCE = eINSTANCE.getReferenceHolder_SubtypeReference();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.GenerateDirectiveImpl <em>Generate Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.GenerateDirectiveImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getGenerateDirective()
     * @generated
     */
    EClass GENERATE_DIRECTIVE = eINSTANCE.getGenerateDirective();

    /**
     * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATE_DIRECTIVE__TYPE_NAME = eINSTANCE.getGenerateDirective_TypeName();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ImportImpl
     * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

  }

} //ContentAssistTestLanguagePackage
