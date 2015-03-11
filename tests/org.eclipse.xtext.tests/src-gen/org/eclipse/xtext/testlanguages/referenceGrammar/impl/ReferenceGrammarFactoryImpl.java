/**
 */
package org.eclipse.xtext.testlanguages.referenceGrammar.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.referenceGrammar.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceGrammarFactoryImpl extends EFactoryImpl implements ReferenceGrammarFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReferenceGrammarFactory init()
  {
    try
    {
      ReferenceGrammarFactory theReferenceGrammarFactory = (ReferenceGrammarFactory)EPackage.Registry.INSTANCE.getEFactory(ReferenceGrammarPackage.eNS_URI);
      if (theReferenceGrammarFactory != null)
      {
        return theReferenceGrammarFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReferenceGrammarFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceGrammarFactoryImpl()
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
      case ReferenceGrammarPackage.SPIELPLATZ: return createSpielplatz();
      case ReferenceGrammarPackage.PERSON: return createPerson();
      case ReferenceGrammarPackage.KIND: return createKind();
      case ReferenceGrammarPackage.ERWACHSENER: return createErwachsener();
      case ReferenceGrammarPackage.SPIELZEUG: return createSpielzeug();
      case ReferenceGrammarPackage.FARBE: return createFarbe();
      case ReferenceGrammarPackage.FAMILIE: return createFamilie();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Spielplatz createSpielplatz()
  {
    SpielplatzImpl spielplatz = new SpielplatzImpl();
    return spielplatz;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Person createPerson()
  {
    PersonImpl person = new PersonImpl();
    return person;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Kind createKind()
  {
    KindImpl kind = new KindImpl();
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Erwachsener createErwachsener()
  {
    ErwachsenerImpl erwachsener = new ErwachsenerImpl();
    return erwachsener;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Spielzeug createSpielzeug()
  {
    SpielzeugImpl spielzeug = new SpielzeugImpl();
    return spielzeug;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Farbe createFarbe()
  {
    FarbeImpl farbe = new FarbeImpl();
    return farbe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Familie createFamilie()
  {
    FamilieImpl familie = new FamilieImpl();
    return familie;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceGrammarPackage getReferenceGrammarPackage()
  {
    return (ReferenceGrammarPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReferenceGrammarPackage getPackage()
  {
    return ReferenceGrammarPackage.eINSTANCE;
  }

} //ReferenceGrammarFactoryImpl
