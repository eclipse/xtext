/**
 */
package org.eclipse.xtext.testlanguages.simpleExpressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.simpleExpressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleExpressionsFactoryImpl extends EFactoryImpl implements SimpleExpressionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SimpleExpressionsFactory init()
  {
    try
    {
      SimpleExpressionsFactory theSimpleExpressionsFactory = (SimpleExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(SimpleExpressionsPackage.eNS_URI);
      if (theSimpleExpressionsFactory != null)
      {
        return theSimpleExpressionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SimpleExpressionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleExpressionsFactoryImpl()
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
      case SimpleExpressionsPackage.SEQUENCE: return createSequence();
      case SimpleExpressionsPackage.EXPRESSION: return createExpression();
      case SimpleExpressionsPackage.ATOM: return createAtom();
      case SimpleExpressionsPackage.OP: return createOp();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence createSequence()
  {
    SequenceImpl sequence = new SequenceImpl();
    return sequence;
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
  public SimpleExpressionsPackage getSimpleExpressionsPackage()
  {
    return (SimpleExpressionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SimpleExpressionsPackage getPackage()
  {
    return SimpleExpressionsPackage.eINSTANCE;
  }

} //SimpleExpressionsFactoryImpl
