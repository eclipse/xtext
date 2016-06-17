/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.antlr.bug378967Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug378967TestFactoryImpl extends EFactoryImpl implements Bug378967TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug378967TestFactory init()
  {
    try
    {
      Bug378967TestFactory theBug378967TestFactory = (Bug378967TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug378967TestPackage.eNS_URI);
      if (theBug378967TestFactory != null)
      {
        return theBug378967TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug378967TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug378967TestFactoryImpl()
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
      case Bug378967TestPackage.ROOT: return createRoot();
      case Bug378967TestPackage.RULE1: return createRule1();
      case Bug378967TestPackage.RULE2: return createRule2();
      case Bug378967TestPackage.RULE3: return createRule3();
      case Bug378967TestPackage.RULE4: return createRule4();
      case Bug378967TestPackage.AFTER_OBJ: return createAfterObj();
      case Bug378967TestPackage.SOBJ: return createSObj();
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
      case Bug378967TestPackage.FIRST_ENUM:
        return createFirstEnumFromString(eDataType, initialValue);
      case Bug378967TestPackage.SECOND_ENUM:
        return createSecondEnumFromString(eDataType, initialValue);
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
      case Bug378967TestPackage.FIRST_ENUM:
        return convertFirstEnumToString(eDataType, instanceValue);
      case Bug378967TestPackage.SECOND_ENUM:
        return convertSecondEnumToString(eDataType, instanceValue);
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
  public Rule1 createRule1()
  {
    Rule1Impl rule1 = new Rule1Impl();
    return rule1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule2 createRule2()
  {
    Rule2Impl rule2 = new Rule2Impl();
    return rule2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule3 createRule3()
  {
    Rule3Impl rule3 = new Rule3Impl();
    return rule3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rule4 createRule4()
  {
    Rule4Impl rule4 = new Rule4Impl();
    return rule4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AfterObj createAfterObj()
  {
    AfterObjImpl afterObj = new AfterObjImpl();
    return afterObj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SObj createSObj()
  {
    SObjImpl sObj = new SObjImpl();
    return sObj;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FirstEnum createFirstEnumFromString(EDataType eDataType, String initialValue)
  {
    FirstEnum result = FirstEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFirstEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondEnum createSecondEnumFromString(EDataType eDataType, String initialValue)
  {
    SecondEnum result = SecondEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSecondEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug378967TestPackage getBug378967TestPackage()
  {
    return (Bug378967TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug378967TestPackage getPackage()
  {
    return Bug378967TestPackage.eINSTANCE;
  }

} //Bug378967TestFactoryImpl
