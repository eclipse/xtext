/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextutilPackage.java,v 1.6 2008/05/19 10:08:41 sefftinge Exp $
 */
package org.eclipse.xtext.xtextutil;

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
 * @see org.eclipse.xtext.xtextutil.XtextutilFactory
 * @model kind="package"
 * @generated
 */
public interface XtextutilPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xtextutil";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/Xtext/Utilities";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xtextutil";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtextutilPackage eINSTANCE = org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl
   * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getAbstractType()
   * @generated
   */
  int ABSTRACT_TYPE = 2;

  /**
   * The feature id for the '<em><b>EClassifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE__ECLASSIFIER = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE__NAME = 1;

  /**
   * The number of structural features of the '<em>Abstract Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.ResolvedTypeImpl <em>Resolved Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextutil.impl.ResolvedTypeImpl
   * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getResolvedType()
   * @generated
   */
  int RESOLVED_TYPE = 0;

  /**
   * The feature id for the '<em><b>EClassifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLVED_TYPE__ECLASSIFIER = ABSTRACT_TYPE__ECLASSIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLVED_TYPE__NAME = ABSTRACT_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Meta Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLVED_TYPE__META_MODEL = ABSTRACT_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Resolved Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLVED_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl <em>Meta Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextutil.impl.MetaModelImpl
   * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getMetaModel()
   * @generated
   */
  int META_MODEL = 1;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODEL__EPACKAGE = 0;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODEL__ALIAS = 1;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODEL__REFERENCED = 2;

  /**
   * The feature id for the '<em><b>Declaration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODEL__DECLARATION = 3;

  /**
   * The number of structural features of the '<em>Meta Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtextutil.impl.BuiltinTypeImpl <em>Builtin Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtextutil.impl.BuiltinTypeImpl
   * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getBuiltinType()
   * @generated
   */
  int BUILTIN_TYPE = 3;

  /**
   * The feature id for the '<em><b>EClassifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILTIN_TYPE__ECLASSIFIER = ABSTRACT_TYPE__ECLASSIFIER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILTIN_TYPE__NAME = ABSTRACT_TYPE__NAME;

  /**
   * The number of structural features of the '<em>Builtin Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILTIN_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.ResolvedType <em>Resolved Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resolved Type</em>'.
   * @see org.eclipse.xtext.xtextutil.ResolvedType
   * @generated
   */
  EClass getResolvedType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.ResolvedType#getMetaModel <em>Meta Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Meta Model</em>'.
   * @see org.eclipse.xtext.xtextutil.ResolvedType#getMetaModel()
   * @see #getResolvedType()
   * @generated
   */
  EReference getResolvedType_MetaModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.MetaModel <em>Meta Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta Model</em>'.
   * @see org.eclipse.xtext.xtextutil.MetaModel
   * @generated
   */
  EClass getMetaModel();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.MetaModel#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.xtext.xtextutil.MetaModel#getEPackage()
   * @see #getMetaModel()
   * @generated
   */
  EReference getMetaModel_EPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.MetaModel#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.xtextutil.MetaModel#getAlias()
   * @see #getMetaModel()
   * @generated
   */
  EAttribute getMetaModel_Alias();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.MetaModel#isReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Referenced</em>'.
   * @see org.eclipse.xtext.xtextutil.MetaModel#isReferenced()
   * @see #getMetaModel()
   * @generated
   */
  EAttribute getMetaModel_Referenced();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.MetaModel#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Declaration</em>'.
   * @see org.eclipse.xtext.xtextutil.MetaModel#getDeclaration()
   * @see #getMetaModel()
   * @generated
   */
  EReference getMetaModel_Declaration();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.AbstractType <em>Abstract Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Type</em>'.
   * @see org.eclipse.xtext.xtextutil.AbstractType
   * @generated
   */
  EClass getAbstractType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtextutil.AbstractType#getEClassifier <em>EClassifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EClassifier</em>'.
   * @see org.eclipse.xtext.xtextutil.AbstractType#getEClassifier()
   * @see #getAbstractType()
   * @generated
   */
  EReference getAbstractType_EClassifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtextutil.AbstractType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtextutil.AbstractType#getName()
   * @see #getAbstractType()
   * @generated
   */
  EAttribute getAbstractType_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtextutil.BuiltinType <em>Builtin Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Builtin Type</em>'.
   * @see org.eclipse.xtext.xtextutil.BuiltinType
   * @generated
   */
  EClass getBuiltinType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XtextutilFactory getXtextutilFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.ResolvedTypeImpl <em>Resolved Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextutil.impl.ResolvedTypeImpl
     * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getResolvedType()
     * @generated
     */
    EClass RESOLVED_TYPE = eINSTANCE.getResolvedType();

    /**
     * The meta object literal for the '<em><b>Meta Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOLVED_TYPE__META_MODEL = eINSTANCE.getResolvedType_MetaModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.MetaModelImpl <em>Meta Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextutil.impl.MetaModelImpl
     * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getMetaModel()
     * @generated
     */
    EClass META_MODEL = eINSTANCE.getMetaModel();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference META_MODEL__EPACKAGE = eINSTANCE.getMetaModel_EPackage();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_MODEL__ALIAS = eINSTANCE.getMetaModel_Alias();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_MODEL__REFERENCED = eINSTANCE.getMetaModel_Referenced();

    /**
     * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference META_MODEL__DECLARATION = eINSTANCE.getMetaModel_Declaration();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextutil.impl.AbstractTypeImpl
     * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getAbstractType()
     * @generated
     */
    EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

    /**
     * The meta object literal for the '<em><b>EClassifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_TYPE__ECLASSIFIER = eINSTANCE.getAbstractType_EClassifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_TYPE__NAME = eINSTANCE.getAbstractType_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtextutil.impl.BuiltinTypeImpl <em>Builtin Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtextutil.impl.BuiltinTypeImpl
     * @see org.eclipse.xtext.xtextutil.impl.XtextutilPackageImpl#getBuiltinType()
     * @generated
     */
    EClass BUILTIN_TYPE = eINSTANCE.getBuiltinType();

  }

} //XtextutilPackage
