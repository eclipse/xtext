/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug347012TestLanguageFactoryImpl extends EFactoryImpl implements Bug347012TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug347012TestLanguageFactory init()
  {
    try
    {
      Bug347012TestLanguageFactory theBug347012TestLanguageFactory = (Bug347012TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(Bug347012TestLanguagePackage.eNS_URI);
      if (theBug347012TestLanguageFactory != null)
      {
        return theBug347012TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug347012TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug347012TestLanguageFactoryImpl()
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
      case Bug347012TestLanguagePackage.MY_PROGRAM: return createMyProgram();
      case Bug347012TestLanguagePackage.IDENTIFIER: return createIdentifier();
      case Bug347012TestLanguagePackage.LITERAL: return createLiteral();
      case Bug347012TestLanguagePackage.MY_PRIMARY: return createMyPrimary();
      case Bug347012TestLanguagePackage.MY_PACKAGE: return createMyPackage();
      case Bug347012TestLanguagePackage.MY_CLASS: return createMyClass();
      case Bug347012TestLanguagePackage.MY_ATTRIBUTE: return createMyAttribute();
      case Bug347012TestLanguagePackage.MY_ATTRIBUTES: return createMyAttributes();
      case Bug347012TestLanguagePackage.MY_FIELD: return createMyField();
      case Bug347012TestLanguagePackage.MY_BINDING: return createMyBinding();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyProgram createMyProgram()
  {
    MyProgramImpl myProgram = new MyProgramImpl();
    return myProgram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl();
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyPrimary createMyPrimary()
  {
    MyPrimaryImpl myPrimary = new MyPrimaryImpl();
    return myPrimary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyPackage createMyPackage()
  {
    MyPackageImpl myPackage = new MyPackageImpl();
    return myPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyClass createMyClass()
  {
    MyClassImpl myClass = new MyClassImpl();
    return myClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyAttribute createMyAttribute()
  {
    MyAttributeImpl myAttribute = new MyAttributeImpl();
    return myAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyAttributes createMyAttributes()
  {
    MyAttributesImpl myAttributes = new MyAttributesImpl();
    return myAttributes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyField createMyField()
  {
    MyFieldImpl myField = new MyFieldImpl();
    return myField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyBinding createMyBinding()
  {
    MyBindingImpl myBinding = new MyBindingImpl();
    return myBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug347012TestLanguagePackage getBug347012TestLanguagePackage()
  {
    return (Bug347012TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug347012TestLanguagePackage getPackage()
  {
    return Bug347012TestLanguagePackage.eINSTANCE;
  }

} //Bug347012TestLanguageFactoryImpl
