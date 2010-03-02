/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

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
 * @see org.eclipse.xtext.xtype.XtypeFactory
 * @model kind="package"
 * @generated
 */
public interface XtypePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "xtype";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/xbase/Xtype";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "xtype";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XtypePackage eINSTANCE = org.eclipse.xtext.xtype.impl.XtypePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XTypeRefImpl <em>XType Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XTypeRefImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXTypeRef()
   * @generated
   */
  int XTYPE_REF = 0;

  /**
   * The number of structural features of the '<em>XType Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTYPE_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
   * @generated
   */
  int XFUNCTION_TYPE_REF = 1;

  /**
   * The feature id for the '<em><b>Param Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION_TYPE_REF__PARAM_TYPES = XTYPE_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION_TYPE_REF__RETURN_TYPE = XTYPE_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XFunction Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XFUNCTION_TYPE_REF_FEATURE_COUNT = XTYPE_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XSimpleTypeRefImpl <em>XSimple Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XSimpleTypeRefImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXSimpleTypeRef()
   * @generated
   */
  int XSIMPLE_TYPE_REF = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSIMPLE_TYPE_REF__TYPE = XTYPE_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSIMPLE_TYPE_REF__TYPE_PARAMS = XTYPE_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XSimple Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XSIMPLE_TYPE_REF_FEATURE_COUNT = XTYPE_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XWildcardParamImpl <em>XWildcard Param</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XWildcardParamImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXWildcardParam()
   * @generated
   */
  int XWILDCARD_PARAM = 3;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XWILDCARD_PARAM__EXTENDS = XTYPE_REF_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XWILDCARD_PARAM__SUPER = XTYPE_REF_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XWildcard Param</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XWILDCARD_PARAM_FEATURE_COUNT = XTYPE_REF_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XAbstractTypeParamDeclarationImpl <em>XAbstract Type Param Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XAbstractTypeParamDeclarationImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXAbstractTypeParamDeclaration()
   * @generated
   */
  int XABSTRACT_TYPE_PARAM_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XABSTRACT_TYPE_PARAM_DECLARATION__EXTENDS = TypesPackage.JVM_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Super</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XABSTRACT_TYPE_PARAM_DECLARATION__SUPER = TypesPackage.JVM_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XABSTRACT_TYPE_PARAM_DECLARATION__NAME = TypesPackage.JVM_TYPE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>XAbstract Type Param Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XABSTRACT_TYPE_PARAM_DECLARATION_FEATURE_COUNT = TypesPackage.JVM_TYPE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl <em>XType Param Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl
   * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXTypeParamDeclaration()
   * @generated
   */
  int XTYPE_PARAM_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Extends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTYPE_PARAM_DECLARATION__EXTENDS = XABSTRACT_TYPE_PARAM_DECLARATION__EXTENDS;

  /**
   * The feature id for the '<em><b>Super</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTYPE_PARAM_DECLARATION__SUPER = XABSTRACT_TYPE_PARAM_DECLARATION__SUPER;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTYPE_PARAM_DECLARATION__NAME = XABSTRACT_TYPE_PARAM_DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>XType Param Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XTYPE_PARAM_DECLARATION_FEATURE_COUNT = XABSTRACT_TYPE_PARAM_DECLARATION_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XTypeRef <em>XType Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XType Ref</em>'.
   * @see org.eclipse.xtext.xtype.XTypeRef
   * @generated
   */
  EClass getXTypeRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XFunctionTypeRef <em>XFunction Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XFunction Type Ref</em>'.
   * @see org.eclipse.xtext.xtype.XFunctionTypeRef
   * @generated
   */
  EClass getXFunctionTypeRef();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes <em>Param Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Param Types</em>'.
   * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getParamTypes()
   * @see #getXFunctionTypeRef()
   * @generated
   */
  EReference getXFunctionTypeRef_ParamTypes();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see org.eclipse.xtext.xtype.XFunctionTypeRef#getReturnType()
   * @see #getXFunctionTypeRef()
   * @generated
   */
  EReference getXFunctionTypeRef_ReturnType();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XSimpleTypeRef <em>XSimple Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XSimple Type Ref</em>'.
   * @see org.eclipse.xtext.xtype.XSimpleTypeRef
   * @generated
   */
  EClass getXSimpleTypeRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.xtype.XSimpleTypeRef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.xtype.XSimpleTypeRef#getType()
   * @see #getXSimpleTypeRef()
   * @generated
   */
  EReference getXSimpleTypeRef_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XSimpleTypeRef#getTypeParams <em>Type Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Type Params</em>'.
   * @see org.eclipse.xtext.xtype.XSimpleTypeRef#getTypeParams()
   * @see #getXSimpleTypeRef()
   * @generated
   */
  EReference getXSimpleTypeRef_TypeParams();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XWildcardParam <em>XWildcard Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XWildcard Param</em>'.
   * @see org.eclipse.xtext.xtype.XWildcardParam
   * @generated
   */
  EClass getXWildcardParam();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XWildcardParam#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extends</em>'.
   * @see org.eclipse.xtext.xtype.XWildcardParam#getExtends()
   * @see #getXWildcardParam()
   * @generated
   */
  EReference getXWildcardParam_Extends();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XWildcardParam#getSuper <em>Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super</em>'.
   * @see org.eclipse.xtext.xtype.XWildcardParam#getSuper()
   * @see #getXWildcardParam()
   * @generated
   */
  EReference getXWildcardParam_Super();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration <em>XAbstract Type Param Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XAbstract Type Param Declaration</em>'.
   * @see org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration
   * @generated
   */
  EClass getXAbstractTypeParamDeclaration();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extends</em>'.
   * @see org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getExtends()
   * @see #getXAbstractTypeParamDeclaration()
   * @generated
   */
  EReference getXAbstractTypeParamDeclaration_Extends();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getSuper <em>Super</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super</em>'.
   * @see org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getSuper()
   * @see #getXAbstractTypeParamDeclaration()
   * @generated
   */
  EReference getXAbstractTypeParamDeclaration_Super();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtype.XAbstractTypeParamDeclaration#getName()
   * @see #getXAbstractTypeParamDeclaration()
   * @generated
   */
  EAttribute getXAbstractTypeParamDeclaration_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtype.XTypeParamDeclaration <em>XType Param Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XType Param Declaration</em>'.
   * @see org.eclipse.xtext.xtype.XTypeParamDeclaration
   * @generated
   */
  EClass getXTypeParamDeclaration();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  XtypeFactory getXtypeFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XTypeRefImpl <em>XType Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XTypeRefImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXTypeRef()
     * @generated
     */
    EClass XTYPE_REF = eINSTANCE.getXTypeRef();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl <em>XFunction Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XFunctionTypeRefImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXFunctionTypeRef()
     * @generated
     */
    EClass XFUNCTION_TYPE_REF = eINSTANCE.getXFunctionTypeRef();

    /**
     * The meta object literal for the '<em><b>Param Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XFUNCTION_TYPE_REF__PARAM_TYPES = eINSTANCE.getXFunctionTypeRef_ParamTypes();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XFUNCTION_TYPE_REF__RETURN_TYPE = eINSTANCE.getXFunctionTypeRef_ReturnType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XSimpleTypeRefImpl <em>XSimple Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XSimpleTypeRefImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXSimpleTypeRef()
     * @generated
     */
    EClass XSIMPLE_TYPE_REF = eINSTANCE.getXSimpleTypeRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSIMPLE_TYPE_REF__TYPE = eINSTANCE.getXSimpleTypeRef_Type();

    /**
     * The meta object literal for the '<em><b>Type Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XSIMPLE_TYPE_REF__TYPE_PARAMS = eINSTANCE.getXSimpleTypeRef_TypeParams();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XWildcardParamImpl <em>XWildcard Param</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XWildcardParamImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXWildcardParam()
     * @generated
     */
    EClass XWILDCARD_PARAM = eINSTANCE.getXWildcardParam();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XWILDCARD_PARAM__EXTENDS = eINSTANCE.getXWildcardParam_Extends();

    /**
     * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XWILDCARD_PARAM__SUPER = eINSTANCE.getXWildcardParam_Super();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XAbstractTypeParamDeclarationImpl <em>XAbstract Type Param Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XAbstractTypeParamDeclarationImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXAbstractTypeParamDeclaration()
     * @generated
     */
    EClass XABSTRACT_TYPE_PARAM_DECLARATION = eINSTANCE.getXAbstractTypeParamDeclaration();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XABSTRACT_TYPE_PARAM_DECLARATION__EXTENDS = eINSTANCE.getXAbstractTypeParamDeclaration_Extends();

    /**
     * The meta object literal for the '<em><b>Super</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XABSTRACT_TYPE_PARAM_DECLARATION__SUPER = eINSTANCE.getXAbstractTypeParamDeclaration_Super();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XABSTRACT_TYPE_PARAM_DECLARATION__NAME = eINSTANCE.getXAbstractTypeParamDeclaration_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl <em>XType Param Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtype.impl.XTypeParamDeclarationImpl
     * @see org.eclipse.xtext.xtype.impl.XtypePackageImpl#getXTypeParamDeclaration()
     * @generated
     */
    EClass XTYPE_PARAM_DECLARATION = eINSTANCE.getXTypeParamDeclaration();

  }

} //XtypePackage
