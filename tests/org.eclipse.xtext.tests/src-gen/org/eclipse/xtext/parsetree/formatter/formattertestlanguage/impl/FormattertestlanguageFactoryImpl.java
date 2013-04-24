/**
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.formatter.formattertestlanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormattertestlanguageFactoryImpl extends EFactoryImpl implements FormattertestlanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static FormattertestlanguageFactory init()
  {
    try
    {
      FormattertestlanguageFactory theFormattertestlanguageFactory = (FormattertestlanguageFactory)EPackage.Registry.INSTANCE.getEFactory(FormattertestlanguagePackage.eNS_URI);
      if (theFormattertestlanguageFactory != null)
      {
        return theFormattertestlanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new FormattertestlanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormattertestlanguageFactoryImpl()
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
      case FormattertestlanguagePackage.ROOT: return createRoot();
      case FormattertestlanguagePackage.LINE: return createLine();
      case FormattertestlanguagePackage.DECL: return createDecl();
      case FormattertestlanguagePackage.ASSIGN: return createAssign();
      case FormattertestlanguagePackage.METH: return createMeth();
      case FormattertestlanguagePackage.PARAM: return createParam();
      case FormattertestlanguagePackage.SPACE: return createSpace();
      case FormattertestlanguagePackage.TEST_LINEWRAP: return createTestLinewrap();
      case FormattertestlanguagePackage.TEST_LINEWRAP_MIN_MAX: return createTestLinewrapMinMax();
      case FormattertestlanguagePackage.TEST_INDENTATION: return createTestIndentation();
      case FormattertestlanguagePackage.FQN_OBJ: return createFqnObj();
      case FormattertestlanguagePackage.FQN_REF: return createFqnRef();
      case FormattertestlanguagePackage.ENUMERATION: return createEnumeration();
      case FormattertestlanguagePackage.SUPPRESSED_HIDDEN: return createSuppressedHidden();
      case FormattertestlanguagePackage.SUPPRESSED_HIDDEN_SUB: return createSuppressedHiddenSub();
      case FormattertestlanguagePackage.SUPPRESSED_HIDDEN_SUB_SUB: return createSuppressedHiddenSubSub();
      case FormattertestlanguagePackage.SUPPRESSED_HIDDEN_SUB_ID: return createSuppressedHiddenSubID();
      case FormattertestlanguagePackage.DATATYPES: return createDatatypes();
      case FormattertestlanguagePackage.WRAPPING_DATA_TYPE_TEST: return createWrappingDataTypeTest();
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
      case FormattertestlanguagePackage.ENUM1:
        return createEnum1FromString(eDataType, initialValue);
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
      case FormattertestlanguagePackage.ENUM1:
        return convertEnum1ToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Root createRoot()
  {
    RootImpl root = new RootImpl();
    return root;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Line createLine()
  {
    LineImpl line = new LineImpl();
    return line;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Decl createDecl()
  {
    DeclImpl decl = new DeclImpl();
    return decl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assign createAssign()
  {
    AssignImpl assign = new AssignImpl();
    return assign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Meth createMeth()
  {
    MethImpl meth = new MethImpl();
    return meth;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Param createParam()
  {
    ParamImpl param = new ParamImpl();
    return param;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Space createSpace()
  {
    SpaceImpl space = new SpaceImpl();
    return space;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLinewrap createTestLinewrap()
  {
    TestLinewrapImpl testLinewrap = new TestLinewrapImpl();
    return testLinewrap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestLinewrapMinMax createTestLinewrapMinMax()
  {
    TestLinewrapMinMaxImpl testLinewrapMinMax = new TestLinewrapMinMaxImpl();
    return testLinewrapMinMax;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestIndentation createTestIndentation()
  {
    TestIndentationImpl testIndentation = new TestIndentationImpl();
    return testIndentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FqnObj createFqnObj()
  {
    FqnObjImpl fqnObj = new FqnObjImpl();
    return fqnObj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FqnRef createFqnRef()
  {
    FqnRefImpl fqnRef = new FqnRefImpl();
    return fqnRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumeration createEnumeration()
  {
    EnumerationImpl enumeration = new EnumerationImpl();
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuppressedHidden createSuppressedHidden()
  {
    SuppressedHiddenImpl suppressedHidden = new SuppressedHiddenImpl();
    return suppressedHidden;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuppressedHiddenSub createSuppressedHiddenSub()
  {
    SuppressedHiddenSubImpl suppressedHiddenSub = new SuppressedHiddenSubImpl();
    return suppressedHiddenSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuppressedHiddenSubSub createSuppressedHiddenSubSub()
  {
    SuppressedHiddenSubSubImpl suppressedHiddenSubSub = new SuppressedHiddenSubSubImpl();
    return suppressedHiddenSubSub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuppressedHiddenSubID createSuppressedHiddenSubID()
  {
    SuppressedHiddenSubIDImpl suppressedHiddenSubID = new SuppressedHiddenSubIDImpl();
    return suppressedHiddenSubID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Datatypes createDatatypes()
  {
    DatatypesImpl datatypes = new DatatypesImpl();
    return datatypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WrappingDataTypeTest createWrappingDataTypeTest()
  {
    WrappingDataTypeTestImpl wrappingDataTypeTest = new WrappingDataTypeTestImpl();
    return wrappingDataTypeTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enum1 createEnum1FromString(EDataType eDataType, String initialValue)
  {
    Enum1 result = Enum1.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEnum1ToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormattertestlanguagePackage getFormattertestlanguagePackage()
  {
    return (FormattertestlanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static FormattertestlanguagePackage getPackage()
  {
    return FormattertestlanguagePackage.eINSTANCE;
  }

} //FormattertestlanguageFactoryImpl
