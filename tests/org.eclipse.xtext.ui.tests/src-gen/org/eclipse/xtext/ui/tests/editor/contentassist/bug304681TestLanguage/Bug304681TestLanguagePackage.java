/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Bug304681TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug304681TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug304681TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2010/bug304681TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug304681TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug304681TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getPackageDefinition()
   * @generated
   */
  int PACKAGE_DEFINITION = 0;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__CONTENTS = 1;

  /**
   * The number of structural features of the '<em>Package Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl <em>Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getObject()
   * @generated
   */
  int OBJECT = 1;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__ENABLED = 0;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__ABSTRACT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__NAME = 2;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__PARENT = 3;

  /**
   * The feature id for the '<em><b>Short Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__SHORT_DESCRIPTION = 4;

  /**
   * The feature id for the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__LONG_DESCRIPTION = 5;

  /**
   * The feature id for the '<em><b>Serial Version UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__SERIAL_VERSION_UID = 6;

  /**
   * The feature id for the '<em><b>Cloneable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__CLONEABLE = 7;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT__FEATURES = 8;

  /**
   * The number of structural features of the '<em>Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.FeatureImpl <em>Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.FeatureImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getFeature()
   * @generated
   */
  int FEATURE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE__NAME = 0;

  /**
   * The number of structural features of the '<em>Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = FEATURE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__NAME = FEATURE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__TYPE = FEATURE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__MANY = FEATURE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Short Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__SHORT_DESCRIPTION = FEATURE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Long Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__LONG_DESCRIPTION = FEATURE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 4;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition
   * @generated
   */
  EClass getPackageDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getNamespace()
   * @see #getPackageDefinition()
   * @generated
   */
  EAttribute getPackageDefinition_Namespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.PackageDefinition#getContents()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Contents();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object
   * @generated
   */
  EClass getObject();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Enabled</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isEnabled()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_Enabled();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isAbstract()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getName()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parent</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getParent()
   * @see #getObject()
   * @generated
   */
  EReference getObject_Parent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getShortDescription <em>Short Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Short Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getShortDescription()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_ShortDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getLongDescription <em>Long Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Long Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getLongDescription()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_LongDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getSerialVersionUID <em>Serial Version UID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Serial Version UID</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getSerialVersionUID()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_SerialVersionUID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isCloneable <em>Cloneable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cloneable</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#isCloneable()
   * @see #getObject()
   * @generated
   */
  EAttribute getObject_Cloneable();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Object#getFeatures()
   * @see #getObject()
   * @generated
   */
  EReference getObject_Features();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature
   * @generated
   */
  EClass getFeature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Feature#getName()
   * @see #getFeature()
   * @generated
   */
  EAttribute getFeature_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getType()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#isMany()
   * @see #getReference()
   * @generated
   */
  EAttribute getReference_Many();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getShortDescription <em>Short Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Short Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getShortDescription()
   * @see #getReference()
   * @generated
   */
  EAttribute getReference_ShortDescription();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getLongDescription <em>Long Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Long Description</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.Reference#getLongDescription()
   * @see #getReference()
   * @generated
   */
  EAttribute getReference_LongDescription();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug304681TestLanguageFactory getBug304681TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.PackageDefinitionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getPackageDefinition()
     * @generated
     */
    EClass PACKAGE_DEFINITION = eINSTANCE.getPackageDefinition();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DEFINITION__NAMESPACE = eINSTANCE.getPackageDefinition_Namespace();

    /**
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DEFINITION__CONTENTS = eINSTANCE.getPackageDefinition_Contents();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ObjectImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getObject()
     * @generated
     */
    EClass OBJECT = eINSTANCE.getObject();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__ENABLED = eINSTANCE.getObject_Enabled();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__ABSTRACT = eINSTANCE.getObject_Abstract();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__NAME = eINSTANCE.getObject_Name();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT__PARENT = eINSTANCE.getObject_Parent();

    /**
     * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__SHORT_DESCRIPTION = eINSTANCE.getObject_ShortDescription();

    /**
     * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__LONG_DESCRIPTION = eINSTANCE.getObject_LongDescription();

    /**
     * The meta object literal for the '<em><b>Serial Version UID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__SERIAL_VERSION_UID = eINSTANCE.getObject_SerialVersionUID();

    /**
     * The meta object literal for the '<em><b>Cloneable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT__CLONEABLE = eINSTANCE.getObject_Cloneable();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT__FEATURES = eINSTANCE.getObject_Features();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.FeatureImpl <em>Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.FeatureImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getFeature()
     * @generated
     */
    EClass FEATURE = eINSTANCE.getFeature();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.AttributeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.ReferenceImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug304681TestLanguage.impl.Bug304681TestLanguagePackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__TYPE = eINSTANCE.getReference_Type();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE__MANY = eINSTANCE.getReference_Many();

    /**
     * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE__SHORT_DESCRIPTION = eINSTANCE.getReference_ShortDescription();

    /**
     * The meta object literal for the '<em><b>Long Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE__LONG_DESCRIPTION = eINSTANCE.getReference_LongDescription();

  }

} //Bug304681TestLanguagePackage
