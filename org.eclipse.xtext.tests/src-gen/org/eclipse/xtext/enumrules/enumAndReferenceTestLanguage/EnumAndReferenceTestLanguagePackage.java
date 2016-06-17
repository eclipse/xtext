/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EnumAndReferenceTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "enumAndReferenceTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/EnumAndReferenceTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "enumAndReferenceTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EnumAndReferenceTestLanguagePackage eINSTANCE = org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl <em>Entity With Enum And Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguagePackageImpl#getEntityWithEnumAndReference()
   * @generated
   */
  int ENTITY_WITH_ENUM_AND_REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_WITH_ENUM_AND_REFERENCE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_WITH_ENUM_AND_REFERENCE__NAME = 1;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_WITH_ENUM_AND_REFERENCE__REF = 2;

  /**
   * The number of structural features of the '<em>Entity With Enum And Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_WITH_ENUM_AND_REFERENCE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword <em>Kind Of Keyword</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguagePackageImpl#getKindOfKeyword()
   * @generated
   */
  int KIND_OF_KEYWORD = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference <em>Entity With Enum And Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity With Enum And Reference</em>'.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference
   * @generated
   */
  EClass getEntityWithEnumAndReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getType()
   * @see #getEntityWithEnumAndReference()
   * @generated
   */
  EAttribute getEntityWithEnumAndReference_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getName()
   * @see #getEntityWithEnumAndReference()
   * @generated
   */
  EAttribute getEntityWithEnumAndReference_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference#getRef()
   * @see #getEntityWithEnumAndReference()
   * @generated
   */
  EReference getEntityWithEnumAndReference_Ref();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword <em>Kind Of Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Kind Of Keyword</em>'.
   * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword
   * @generated
   */
  EEnum getKindOfKeyword();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EnumAndReferenceTestLanguageFactory getEnumAndReferenceTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl <em>Entity With Enum And Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EntityWithEnumAndReferenceImpl
     * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguagePackageImpl#getEntityWithEnumAndReference()
     * @generated
     */
    EClass ENTITY_WITH_ENUM_AND_REFERENCE = eINSTANCE.getEntityWithEnumAndReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY_WITH_ENUM_AND_REFERENCE__TYPE = eINSTANCE.getEntityWithEnumAndReference_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY_WITH_ENUM_AND_REFERENCE__NAME = eINSTANCE.getEntityWithEnumAndReference_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY_WITH_ENUM_AND_REFERENCE__REF = eINSTANCE.getEntityWithEnumAndReference_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword <em>Kind Of Keyword</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.KindOfKeyword
     * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguagePackageImpl#getKindOfKeyword()
     * @generated
     */
    EEnum KIND_OF_KEYWORD = eINSTANCE.getKindOfKeyword();

  }

} //EnumAndReferenceTestLanguagePackage
