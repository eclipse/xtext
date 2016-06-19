/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.lookaheadLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LookaheadLangFactoryImpl extends EFactoryImpl implements LookaheadLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LookaheadLangFactory init()
  {
    try
    {
      LookaheadLangFactory theLookaheadLangFactory = (LookaheadLangFactory)EPackage.Registry.INSTANCE.getEFactory(LookaheadLangPackage.eNS_URI);
      if (theLookaheadLangFactory != null)
      {
        return theLookaheadLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LookaheadLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookaheadLangFactoryImpl()
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
      case LookaheadLangPackage.ENTRY: return createEntry();
      case LookaheadLangPackage.ALTS: return createAlts();
      case LookaheadLangPackage.LOOK_AHEAD0: return createLookAhead0();
      case LookaheadLangPackage.LOOK_AHEAD1: return createLookAhead1();
      case LookaheadLangPackage.LOOK_AHEAD2: return createLookAhead2();
      case LookaheadLangPackage.LOOK_AHEAD3: return createLookAhead3();
      case LookaheadLangPackage.LOOK_AHEAD4: return createLookAhead4();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entry createEntry()
  {
    EntryImpl entry = new EntryImpl();
    return entry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alts createAlts()
  {
    AltsImpl alts = new AltsImpl();
    return alts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead0 createLookAhead0()
  {
    LookAhead0Impl lookAhead0 = new LookAhead0Impl();
    return lookAhead0;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead1 createLookAhead1()
  {
    LookAhead1Impl lookAhead1 = new LookAhead1Impl();
    return lookAhead1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead2 createLookAhead2()
  {
    LookAhead2Impl lookAhead2 = new LookAhead2Impl();
    return lookAhead2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead3 createLookAhead3()
  {
    LookAhead3Impl lookAhead3 = new LookAhead3Impl();
    return lookAhead3;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookAhead4 createLookAhead4()
  {
    LookAhead4Impl lookAhead4 = new LookAhead4Impl();
    return lookAhead4;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LookaheadLangPackage getLookaheadLangPackage()
  {
    return (LookaheadLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LookaheadLangPackage getPackage()
  {
    return LookaheadLangPackage.eINSTANCE;
  }

} //LookaheadLangFactoryImpl
