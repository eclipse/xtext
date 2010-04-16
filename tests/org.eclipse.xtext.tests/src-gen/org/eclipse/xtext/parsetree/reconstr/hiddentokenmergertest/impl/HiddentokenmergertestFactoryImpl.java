/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddentokenmergertestFactoryImpl extends EFactoryImpl implements HiddentokenmergertestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HiddentokenmergertestFactory init()
  {
    try
    {
      HiddentokenmergertestFactory theHiddentokenmergertestFactory = (HiddentokenmergertestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/hiddentokensmerger"); 
      if (theHiddentokenmergertestFactory != null)
      {
        return theHiddentokenmergertestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HiddentokenmergertestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case HiddentokenmergertestPackage.MODEL: return createModel();
      case HiddentokenmergertestPackage.DATATYPE_BUG286557: return createDatatypeBug286557();
      case HiddentokenmergertestPackage.ENUM_BUG: return createEnumBug();
      case HiddentokenmergertestPackage.COMMENTABLE: return createCommentable();
      case HiddentokenmergertestPackage.COMMENTABLE_ITEM: return createCommentableItem();
      case HiddentokenmergertestPackage.VALUE_LIST: return createValueList();
      case HiddentokenmergertestPackage.REF_LIST: return createRefList();
      case HiddentokenmergertestPackage.REF_OBJ: return createRefObj();
      case HiddentokenmergertestPackage.SINGLE_REF: return createSingleRef();
      case HiddentokenmergertestPackage.APPEND_TO_FILE_END: return createAppendToFileEnd();
      case HiddentokenmergertestPackage.APPEND_TO_FILE_END_ITEM: return createAppendToFileEndItem();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HiddentokenmergertestPackage.ENUM_BUG_ENUM:
        return createEnumBugEnumFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case HiddentokenmergertestPackage.ENUM_BUG_ENUM:
        return convertEnumBugEnumToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeBug286557 createDatatypeBug286557()
  {
    DatatypeBug286557Impl datatypeBug286557 = new DatatypeBug286557Impl();
    return datatypeBug286557;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBug createEnumBug()
  {
    EnumBugImpl enumBug = new EnumBugImpl();
    return enumBug;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Commentable createCommentable()
  {
    CommentableImpl commentable = new CommentableImpl();
    return commentable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CommentableItem createCommentableItem()
  {
    CommentableItemImpl commentableItem = new CommentableItemImpl();
    return commentableItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueList createValueList()
  {
    ValueListImpl valueList = new ValueListImpl();
    return valueList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefList createRefList()
  {
    RefListImpl refList = new RefListImpl();
    return refList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefObj createRefObj()
  {
    RefObjImpl refObj = new RefObjImpl();
    return refObj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleRef createSingleRef()
  {
    SingleRefImpl singleRef = new SingleRefImpl();
    return singleRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AppendToFileEnd createAppendToFileEnd()
  {
    AppendToFileEndImpl appendToFileEnd = new AppendToFileEndImpl();
    return appendToFileEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AppendToFileEndItem createAppendToFileEndItem()
  {
    AppendToFileEndItemImpl appendToFileEndItem = new AppendToFileEndItemImpl();
    return appendToFileEndItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumBugEnum createEnumBugEnumFromString(EDataType eDataType, String initialValue)
  {
    EnumBugEnum result = EnumBugEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEnumBugEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestPackage getHiddentokenmergertestPackage()
  {
    return (HiddentokenmergertestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HiddentokenmergertestPackage getPackage()
  {
    return HiddentokenmergertestPackage.eINSTANCE;
  }

} //HiddentokenmergertestFactoryImpl
