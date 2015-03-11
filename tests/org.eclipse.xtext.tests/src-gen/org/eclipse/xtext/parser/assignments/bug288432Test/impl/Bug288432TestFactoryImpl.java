/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.assignments.bug288432Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug288432TestFactoryImpl extends EFactoryImpl implements Bug288432TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug288432TestFactory init()
  {
    try
    {
      Bug288432TestFactory theBug288432TestFactory = (Bug288432TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug288432TestPackage.eNS_URI);
      if (theBug288432TestFactory != null)
      {
        return theBug288432TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug288432TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug288432TestFactoryImpl()
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
      case Bug288432TestPackage.BODY: return createBody();
      case Bug288432TestPackage.FOO: return createFoo();
      case Bug288432TestPackage.CONTENT: return createContent();
      case Bug288432TestPackage.MY_ELEMENT: return createMyElement();
      case Bug288432TestPackage.PARAMETER_OBJECT: return createParameterObject();
      case Bug288432TestPackage.PARAMETER: return createParameter();
      case Bug288432TestPackage.PARAMETER_REF: return createParameterRef();
      case Bug288432TestPackage.MY_INT: return createMyInt();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Body createBody()
  {
    BodyImpl body = new BodyImpl();
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Foo createFoo()
  {
    FooImpl foo = new FooImpl();
    return foo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Content createContent()
  {
    ContentImpl content = new ContentImpl();
    return content;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyElement createMyElement()
  {
    MyElementImpl myElement = new MyElementImpl();
    return myElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterObject createParameterObject()
  {
    ParameterObjectImpl parameterObject = new ParameterObjectImpl();
    return parameterObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterRef createParameterRef()
  {
    ParameterRefImpl parameterRef = new ParameterRefImpl();
    return parameterRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyInt createMyInt()
  {
    MyIntImpl myInt = new MyIntImpl();
    return myInt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug288432TestPackage getBug288432TestPackage()
  {
    return (Bug288432TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug288432TestPackage getPackage()
  {
    return Bug288432TestPackage.eINSTANCE;
  }

} //Bug288432TestFactoryImpl
