/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartialParserTestLanguageFactoryImpl extends EFactoryImpl implements PartialParserTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PartialParserTestLanguageFactory init()
  {
    try
    {
      PartialParserTestLanguageFactory thePartialParserTestLanguageFactory = (PartialParserTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(PartialParserTestLanguagePackage.eNS_URI);
      if (thePartialParserTestLanguageFactory != null)
      {
        return thePartialParserTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PartialParserTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialParserTestLanguageFactoryImpl()
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
      case PartialParserTestLanguagePackage.SOME_CONTAINER: return createSomeContainer();
      case PartialParserTestLanguagePackage.NESTED: return createNested();
      case PartialParserTestLanguagePackage.CONTENT: return createContent();
      case PartialParserTestLanguagePackage.CHILDREN: return createChildren();
      case PartialParserTestLanguagePackage.CHILD: return createChild();
      case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN: return createAbstractChildren();
      case PartialParserTestLanguagePackage.ABSTRACT_CHILD: return createAbstractChild();
      case PartialParserTestLanguagePackage.FIRST_CONCRETE: return createFirstConcrete();
      case PartialParserTestLanguagePackage.SECOND_CONCRETE: return createSecondConcrete();
      case PartialParserTestLanguagePackage.NAMED: return createNamed();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SomeContainer createSomeContainer()
  {
    SomeContainerImpl someContainer = new SomeContainerImpl();
    return someContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Nested createNested()
  {
    NestedImpl nested = new NestedImpl();
    return nested;
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
  public Children createChildren()
  {
    ChildrenImpl children = new ChildrenImpl();
    return children;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Child createChild()
  {
    ChildImpl child = new ChildImpl();
    return child;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractChildren createAbstractChildren()
  {
    AbstractChildrenImpl abstractChildren = new AbstractChildrenImpl();
    return abstractChildren;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractChild createAbstractChild()
  {
    AbstractChildImpl abstractChild = new AbstractChildImpl();
    return abstractChild;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FirstConcrete createFirstConcrete()
  {
    FirstConcreteImpl firstConcrete = new FirstConcreteImpl();
    return firstConcrete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondConcrete createSecondConcrete()
  {
    SecondConcreteImpl secondConcrete = new SecondConcreteImpl();
    return secondConcrete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Named createNamed()
  {
    NamedImpl named = new NamedImpl();
    return named;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialParserTestLanguagePackage getPartialParserTestLanguagePackage()
  {
    return (PartialParserTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PartialParserTestLanguagePackage getPackage()
  {
    return PartialParserTestLanguagePackage.eINSTANCE;
  }

} //PartialParserTestLanguageFactoryImpl
