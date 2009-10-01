/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage;

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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Bug291022TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug291022TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug291022TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/bug291022TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug291022TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug291022TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelAttributeImpl <em>Model Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelAttributeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getModelAttribute()
   * @generated
   */
  int MODEL_ATTRIBUTE = 1;

  /**
   * The number of structural features of the '<em>Model Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ATTRIBUTE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 0;

  /**
   * The feature id for the '<em><b>First Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__FIRST_REFERENCE = MODEL_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__NAME = MODEL_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Second Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__SECOND_REFERENCE = MODEL_ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__ELEMENTS = MODEL_ATTRIBUTE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = MODEL_ATTRIBUTE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.AttributeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 2;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__FEATURE = MODEL_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = MODEL_ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = MODEL_ATTRIBUTE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.RootModelImpl <em>Root Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.RootModelImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getRootModel()
   * @generated
   */
  int ROOT_MODEL = 3;

  /**
   * The feature id for the '<em><b>First Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL__FIRST_REFERENCE = MODEL_ELEMENT__FIRST_REFERENCE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL__NAME = MODEL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Second Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL__SECOND_REFERENCE = MODEL_ELEMENT__SECOND_REFERENCE;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL__ELEMENTS = MODEL_ELEMENT__ELEMENTS;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Root Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_MODEL_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getFirstReference <em>First Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>First Reference</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getFirstReference()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_FirstReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getName()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getSecondReference <em>Second Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Second Reference</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getSecondReference()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_SecondReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelElement#getElements()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelAttribute <em>Model Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.ModelAttribute
   * @generated
   */
  EClass getModelAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute#getFeature()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.RootModel <em>Root Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root Model</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.RootModel
   * @generated
   */
  EClass getRootModel();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.RootModel#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.RootModel#getType()
   * @see #getRootModel()
   * @generated
   */
  EReference getRootModel_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug291022TestLanguageFactory getBug291022TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelElementImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>First Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__FIRST_REFERENCE = eINSTANCE.getModelElement_FirstReference();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

    /**
     * The meta object literal for the '<em><b>Second Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__SECOND_REFERENCE = eINSTANCE.getModelElement_SecondReference();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__ELEMENTS = eINSTANCE.getModelElement_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelAttributeImpl <em>Model Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.ModelAttributeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getModelAttribute()
     * @generated
     */
    EClass MODEL_ATTRIBUTE = eINSTANCE.getModelAttribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.AttributeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__FEATURE = eINSTANCE.getAttribute_Feature();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.RootModelImpl <em>Root Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.RootModelImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguagePackageImpl#getRootModel()
     * @generated
     */
    EClass ROOT_MODEL = eINSTANCE.getRootModel();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT_MODEL__TYPE = eINSTANCE.getRootModel_Type();

  }

} //Bug291022TestLanguagePackage
