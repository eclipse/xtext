/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;

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
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestFactory
 * @model kind="package"
 * @generated
 */
public interface HiddentokenmergertestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hiddentokenmergertest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/hiddentokensmerger";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hiddentokenmergertest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HiddentokenmergertestPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl <em>Datatype Bug286557</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getDatatypeBug286557()
   * @generated
   */
  int DATATYPE_BUG286557 = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557__NAME = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557__REF = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Datatype Bug286557</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl <em>Enum Bug</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getEnumBug()
   * @generated
   */
  int ENUM_BUG = 2;

  /**
   * The feature id for the '<em><b>Return</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_BUG__RETURN = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_BUG__NAME = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Bug</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_BUG_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableImpl <em>Commentable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getCommentable()
   * @generated
   */
  int COMMENTABLE = 3;

  /**
   * The feature id for the '<em><b>Item</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENTABLE__ITEM = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Commentable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENTABLE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableItemImpl <em>Commentable Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableItemImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getCommentableItem()
   * @generated
   */
  int COMMENTABLE_ITEM = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENTABLE_ITEM__ID = 0;

  /**
   * The number of structural features of the '<em>Commentable Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENTABLE_ITEM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ValueListImpl <em>Value List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ValueListImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getValueList()
   * @generated
   */
  int VALUE_LIST = 5;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_LIST__IDS = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_LIST_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl <em>Ref List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getRefList()
   * @generated
   */
  int REF_LIST = 6;

  /**
   * The feature id for the '<em><b>Objs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_LIST__OBJS = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_LIST__REFS = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ref List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_LIST_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefObjImpl <em>Ref Obj</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefObjImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getRefObj()
   * @generated
   */
  int REF_OBJ = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_OBJ__NAME = 0;

  /**
   * The number of structural features of the '<em>Ref Obj</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_OBJ_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum <em>Enum Bug Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getEnumBugEnum()
   * @generated
   */
  int ENUM_BUG_ENUM = 8;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557 <em>Datatype Bug286557</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatype Bug286557</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557
   * @generated
   */
  EClass getDatatypeBug286557();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getName()
   * @see #getDatatypeBug286557()
   * @generated
   */
  EAttribute getDatatypeBug286557_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getRef()
   * @see #getDatatypeBug286557()
   * @generated
   */
  EReference getDatatypeBug286557_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug <em>Enum Bug</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Bug</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug
   * @generated
   */
  EClass getEnumBug();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Return</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getReturn()
   * @see #getEnumBug()
   * @generated
   */
  EAttribute getEnumBug_Return();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getName()
   * @see #getEnumBug()
   * @generated
   */
  EAttribute getEnumBug_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable <em>Commentable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Commentable</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable
   * @generated
   */
  EClass getCommentable();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable#getItem <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Item</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable#getItem()
   * @see #getCommentable()
   * @generated
   */
  EReference getCommentable_Item();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem <em>Commentable Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Commentable Item</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem
   * @generated
   */
  EClass getCommentableItem();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem#getId()
   * @see #getCommentableItem()
   * @generated
   */
  EAttribute getCommentableItem_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList <em>Value List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value List</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList
   * @generated
   */
  EClass getValueList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList#getIds()
   * @see #getValueList()
   * @generated
   */
  EAttribute getValueList_Ids();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList <em>Ref List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref List</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList
   * @generated
   */
  EClass getRefList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList#getObjs <em>Objs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objs</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList#getObjs()
   * @see #getRefList()
   * @generated
   */
  EReference getRefList_Objs();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refs</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList#getRefs()
   * @see #getRefList()
   * @generated
   */
  EReference getRefList_Refs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj <em>Ref Obj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Obj</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj
   * @generated
   */
  EClass getRefObj();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj#getName()
   * @see #getRefObj()
   * @generated
   */
  EAttribute getRefObj_Name();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum <em>Enum Bug Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum Bug Enum</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum
   * @generated
   */
  EEnum getEnumBugEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HiddentokenmergertestFactory getHiddentokenmergertestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl <em>Datatype Bug286557</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getDatatypeBug286557()
     * @generated
     */
    EClass DATATYPE_BUG286557 = eINSTANCE.getDatatypeBug286557();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPE_BUG286557__NAME = eINSTANCE.getDatatypeBug286557_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATATYPE_BUG286557__REF = eINSTANCE.getDatatypeBug286557_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl <em>Enum Bug</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.EnumBugImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getEnumBug()
     * @generated
     */
    EClass ENUM_BUG = eINSTANCE.getEnumBug();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_BUG__RETURN = eINSTANCE.getEnumBug_Return();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_BUG__NAME = eINSTANCE.getEnumBug_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableImpl <em>Commentable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getCommentable()
     * @generated
     */
    EClass COMMENTABLE = eINSTANCE.getCommentable();

    /**
     * The meta object literal for the '<em><b>Item</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMMENTABLE__ITEM = eINSTANCE.getCommentable_Item();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableItemImpl <em>Commentable Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.CommentableItemImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getCommentableItem()
     * @generated
     */
    EClass COMMENTABLE_ITEM = eINSTANCE.getCommentableItem();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMMENTABLE_ITEM__ID = eINSTANCE.getCommentableItem_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ValueListImpl <em>Value List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ValueListImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getValueList()
     * @generated
     */
    EClass VALUE_LIST = eINSTANCE.getValueList();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_LIST__IDS = eINSTANCE.getValueList_Ids();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl <em>Ref List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefListImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getRefList()
     * @generated
     */
    EClass REF_LIST = eINSTANCE.getRefList();

    /**
     * The meta object literal for the '<em><b>Objs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_LIST__OBJS = eINSTANCE.getRefList_Objs();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_LIST__REFS = eINSTANCE.getRefList_Refs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefObjImpl <em>Ref Obj</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.RefObjImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getRefObj()
     * @generated
     */
    EClass REF_OBJ = eINSTANCE.getRefObj();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REF_OBJ__NAME = eINSTANCE.getRefObj_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum <em>Enum Bug Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getEnumBugEnum()
     * @generated
     */
    EEnum ENUM_BUG_ENUM = eINSTANCE.getEnumBugEnum();

  }

} //HiddentokenmergertestPackage
