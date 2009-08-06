/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl;

import org.eclipse.emf.ecore.EClass;
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
      FormattertestlanguageFactory theFormattertestlanguageFactory = (FormattertestlanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://simple/formattertestlanguage"); 
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
      case FormattertestlanguagePackage.TEST_LINEWRAP: return createTestLinewrap();
      case FormattertestlanguagePackage.TEST_INDENTATION: return createTestIndentation();
      case FormattertestlanguagePackage.FQN_REF: return createFqnRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
