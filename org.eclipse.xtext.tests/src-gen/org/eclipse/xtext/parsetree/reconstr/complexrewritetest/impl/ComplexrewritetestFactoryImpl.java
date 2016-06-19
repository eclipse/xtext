/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComplexrewritetestFactoryImpl extends EFactoryImpl implements ComplexrewritetestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ComplexrewritetestFactory init()
  {
    try
    {
      ComplexrewritetestFactory theComplexrewritetestFactory = (ComplexrewritetestFactory)EPackage.Registry.INSTANCE.getEFactory(ComplexrewritetestPackage.eNS_URI);
      if (theComplexrewritetestFactory != null)
      {
        return theComplexrewritetestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ComplexrewritetestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexrewritetestFactoryImpl()
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
      case ComplexrewritetestPackage.ROOT: return createRoot();
      case ComplexrewritetestPackage.EXPRESSION: return createExpression();
      case ComplexrewritetestPackage.ATOM: return createAtom();
      case ComplexrewritetestPackage.TRICKY_B: return createTrickyB();
      case ComplexrewritetestPackage.TRICKY_C: return createTrickyC();
      case ComplexrewritetestPackage.TRICKY_D: return createTrickyD();
      case ComplexrewritetestPackage.TRICKY_E: return createTrickyE();
      case ComplexrewritetestPackage.TRICKY_F: return createTrickyF();
      case ComplexrewritetestPackage.TRICKY_G: return createTrickyG();
      case ComplexrewritetestPackage.TRICKY_G1: return createTrickyG1();
      case ComplexrewritetestPackage.TRICKY_G2: return createTrickyG2();
      case ComplexrewritetestPackage.ADD: return createAdd();
      case ComplexrewritetestPackage.MINUS: return createMinus();
      case ComplexrewritetestPackage.C1: return createC1();
      case ComplexrewritetestPackage.C2: return createC2();
      case ComplexrewritetestPackage.C3: return createC3();
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
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Atom createAtom()
  {
    AtomImpl atom = new AtomImpl();
    return atom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyB createTrickyB()
  {
    TrickyBImpl trickyB = new TrickyBImpl();
    return trickyB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyC createTrickyC()
  {
    TrickyCImpl trickyC = new TrickyCImpl();
    return trickyC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyD createTrickyD()
  {
    TrickyDImpl trickyD = new TrickyDImpl();
    return trickyD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyE createTrickyE()
  {
    TrickyEImpl trickyE = new TrickyEImpl();
    return trickyE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyF createTrickyF()
  {
    TrickyFImpl trickyF = new TrickyFImpl();
    return trickyF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyG createTrickyG()
  {
    TrickyGImpl trickyG = new TrickyGImpl();
    return trickyG;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyG1 createTrickyG1()
  {
    TrickyG1Impl trickyG1 = new TrickyG1Impl();
    return trickyG1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrickyG2 createTrickyG2()
  {
    TrickyG2Impl trickyG2 = new TrickyG2Impl();
    return trickyG2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add createAdd()
  {
    AddImpl add = new AddImpl();
    return add;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Minus createMinus()
  {
    MinusImpl minus = new MinusImpl();
    return minus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C1 createC1()
  {
    C1Impl c1 = new C1Impl();
    return c1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C2 createC2()
  {
    C2Impl c2 = new C2Impl();
    return c2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public C3 createC3()
  {
    C3Impl c3 = new C3Impl();
    return c3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexrewritetestPackage getComplexrewritetestPackage()
  {
    return (ComplexrewritetestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ComplexrewritetestPackage getPackage()
  {
    return ComplexrewritetestPackage.eINSTANCE;
  }

} //ComplexrewritetestFactoryImpl
