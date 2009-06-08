/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestFactory;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimplerewritetestFactoryImpl extends EFactoryImpl implements SimplerewritetestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SimplerewritetestFactory init()
  {
    try
    {
      SimplerewritetestFactory theSimplerewritetestFactory = (SimplerewritetestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/tmf/xtext/simplerewritetest"); 
      if (theSimplerewritetestFactory != null)
      {
        return theSimplerewritetestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SimplerewritetestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestFactoryImpl()
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
      case SimplerewritetestPackage.EXPRESSION: return createExpression();
      case SimplerewritetestPackage.ATOM: return createAtom();
      case SimplerewritetestPackage.TWO_NUMBERS: return createTwoNumbers();
      case SimplerewritetestPackage.MANY_STRINGS: return createManyStrings();
      case SimplerewritetestPackage.TYPE: return createType();
      case SimplerewritetestPackage.REF2: return createRef2();
      case SimplerewritetestPackage.SPARE: return createSpare();
      case SimplerewritetestPackage.BOOLEAN: return createBoolean();
      case SimplerewritetestPackage.TRANSIENT1: return createTransient1();
      case SimplerewritetestPackage.CONSUMED1: return createConsumed1();
      case SimplerewritetestPackage.CONSUMED2: return createConsumed2();
      case SimplerewritetestPackage.OP: return createOp();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public TwoNumbers createTwoNumbers()
  {
    TwoNumbersImpl twoNumbers = new TwoNumbersImpl();
    return twoNumbers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ManyStrings createManyStrings()
  {
    ManyStringsImpl manyStrings = new ManyStringsImpl();
    return manyStrings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Ref2 createRef2()
  {
    Ref2Impl ref2 = new Ref2Impl();
    return ref2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Spare createSpare()
  {
    SpareImpl spare = new SpareImpl();
    return spare;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean createBoolean()
  {
    BooleanImpl boolean_ = new BooleanImpl();
    return boolean_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transient1 createTransient1()
  {
    Transient1Impl transient1 = new Transient1Impl();
    return transient1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Consumed1 createConsumed1()
  {
    Consumed1Impl consumed1 = new Consumed1Impl();
    return consumed1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Consumed2 createConsumed2()
  {
    Consumed2Impl consumed2 = new Consumed2Impl();
    return consumed2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Op createOp()
  {
    OpImpl op = new OpImpl();
    return op;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestPackage getSimplerewritetestPackage()
  {
    return (SimplerewritetestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SimplerewritetestPackage getPackage()
  {
    return SimplerewritetestPackage.eINSTANCE;
  }

} //SimplerewritetestFactoryImpl
