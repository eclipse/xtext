/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Commentable;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.CommentableItem;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestFactory;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefList;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.RefObj;
import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddentokenmergertestPackageImpl extends EPackageImpl implements HiddentokenmergertestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass datatypeBug286557EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumBugEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commentableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commentableItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refObjEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum enumBugEnumEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private HiddentokenmergertestPackageImpl()
  {
    super(eNS_URI, HiddentokenmergertestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link HiddentokenmergertestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static HiddentokenmergertestPackage init()
  {
    if (isInited) return (HiddentokenmergertestPackage)EPackage.Registry.INSTANCE.getEPackage(HiddentokenmergertestPackage.eNS_URI);

    // Obtain or create and register package
    HiddentokenmergertestPackageImpl theHiddentokenmergertestPackage = (HiddentokenmergertestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof HiddentokenmergertestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new HiddentokenmergertestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theHiddentokenmergertestPackage.createPackageContents();

    // Initialize created meta-data
    theHiddentokenmergertestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theHiddentokenmergertestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(HiddentokenmergertestPackage.eNS_URI, theHiddentokenmergertestPackage);
    return theHiddentokenmergertestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDatatypeBug286557()
  {
    return datatypeBug286557EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDatatypeBug286557_Name()
  {
    return (EAttribute)datatypeBug286557EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDatatypeBug286557_Ref()
  {
    return (EReference)datatypeBug286557EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumBug()
  {
    return enumBugEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumBug_Return()
  {
    return (EAttribute)enumBugEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumBug_Name()
  {
    return (EAttribute)enumBugEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommentable()
  {
    return commentableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCommentable_Item()
  {
    return (EReference)commentableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCommentableItem()
  {
    return commentableItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCommentableItem_Id()
  {
    return (EAttribute)commentableItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueList()
  {
    return valueListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getValueList_Ids()
  {
    return (EAttribute)valueListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefList()
  {
    return refListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefList_Objs()
  {
    return (EReference)refListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefList_Refs()
  {
    return (EReference)refListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefObj()
  {
    return refObjEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefObj_Name()
  {
    return (EAttribute)refObjEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnumBugEnum()
  {
    return enumBugEnumEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestFactory getHiddentokenmergertestFactory()
  {
    return (HiddentokenmergertestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);

    datatypeBug286557EClass = createEClass(DATATYPE_BUG286557);
    createEAttribute(datatypeBug286557EClass, DATATYPE_BUG286557__NAME);
    createEReference(datatypeBug286557EClass, DATATYPE_BUG286557__REF);

    enumBugEClass = createEClass(ENUM_BUG);
    createEAttribute(enumBugEClass, ENUM_BUG__RETURN);
    createEAttribute(enumBugEClass, ENUM_BUG__NAME);

    commentableEClass = createEClass(COMMENTABLE);
    createEReference(commentableEClass, COMMENTABLE__ITEM);

    commentableItemEClass = createEClass(COMMENTABLE_ITEM);
    createEAttribute(commentableItemEClass, COMMENTABLE_ITEM__ID);

    valueListEClass = createEClass(VALUE_LIST);
    createEAttribute(valueListEClass, VALUE_LIST__IDS);

    refListEClass = createEClass(REF_LIST);
    createEReference(refListEClass, REF_LIST__OBJS);
    createEReference(refListEClass, REF_LIST__REFS);

    refObjEClass = createEClass(REF_OBJ);
    createEAttribute(refObjEClass, REF_OBJ__NAME);

    // Create enums
    enumBugEnumEEnum = createEEnum(ENUM_BUG_ENUM);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    datatypeBug286557EClass.getESuperTypes().add(this.getModel());
    enumBugEClass.getESuperTypes().add(this.getModel());
    commentableEClass.getESuperTypes().add(this.getModel());
    valueListEClass.getESuperTypes().add(this.getModel());
    refListEClass.getESuperTypes().add(this.getModel());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(datatypeBug286557EClass, DatatypeBug286557.class, "DatatypeBug286557", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDatatypeBug286557_Name(), ecorePackage.getEString(), "name", null, 0, 1, DatatypeBug286557.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDatatypeBug286557_Ref(), this.getDatatypeBug286557(), null, "ref", null, 0, 1, DatatypeBug286557.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumBugEClass, EnumBug.class, "EnumBug", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumBug_Return(), this.getEnumBugEnum(), "return", null, 0, 1, EnumBug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEnumBug_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumBug.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commentableEClass, Commentable.class, "Commentable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCommentable_Item(), this.getCommentableItem(), null, "item", null, 0, -1, Commentable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(commentableItemEClass, CommentableItem.class, "CommentableItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCommentableItem_Id(), ecorePackage.getEString(), "id", null, 0, 1, CommentableItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueListEClass, ValueList.class, "ValueList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getValueList_Ids(), ecorePackage.getEString(), "ids", null, 0, -1, ValueList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refListEClass, RefList.class, "RefList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefList_Objs(), this.getRefObj(), null, "objs", null, 0, -1, RefList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRefList_Refs(), this.getRefObj(), null, "refs", null, 0, -1, RefList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refObjEClass, RefObj.class, "RefObj", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRefObj_Name(), ecorePackage.getEString(), "name", null, 0, 1, RefObj.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(enumBugEnumEEnum, EnumBugEnum.class, "EnumBugEnum");
    addEEnumLiteral(enumBugEnumEEnum, EnumBugEnum.ARRAY);
    addEEnumLiteral(enumBugEnumEEnum, EnumBugEnum.OBJECT);
    addEEnumLiteral(enumBugEnumEEnum, EnumBugEnum.RESULT_SET);
    addEEnumLiteral(enumBugEnumEEnum, EnumBugEnum.ITERATOR);

    // Create resource
    createResource(eNS_URI);
  }

} //HiddentokenmergertestPackageImpl
