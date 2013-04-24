/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HiddenTerminalsTestLanguageFactoryImpl extends EFactoryImpl implements HiddenTerminalsTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static HiddenTerminalsTestLanguageFactory init()
  {
    try
    {
      HiddenTerminalsTestLanguageFactory theHiddenTerminalsTestLanguageFactory = (HiddenTerminalsTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(HiddenTerminalsTestLanguagePackage.eNS_URI);
      if (theHiddenTerminalsTestLanguageFactory != null)
      {
        return theHiddenTerminalsTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new HiddenTerminalsTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddenTerminalsTestLanguageFactoryImpl()
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
      case HiddenTerminalsTestLanguagePackage.MODEL: return createModel();
      case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS: return createWithoutHiddens();
      case HiddenTerminalsTestLanguagePackage.WITH_HIDDENS: return createWithHiddens();
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS: return createOverridingHiddens();
      case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL: return createOverridingHiddensCall();
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS: return createInheritingHiddens();
      case HiddenTerminalsTestLanguagePackage.DATATYPE_HIDDENS: return createDatatypeHiddens();
      case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS: return createHidingHiddens();
      case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS_CALL: return createInheritingHiddensCall();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WithoutHiddens createWithoutHiddens()
  {
    WithoutHiddensImpl withoutHiddens = new WithoutHiddensImpl();
    return withoutHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WithHiddens createWithHiddens()
  {
    WithHiddensImpl withHiddens = new WithHiddensImpl();
    return withHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OverridingHiddens createOverridingHiddens()
  {
    OverridingHiddensImpl overridingHiddens = new OverridingHiddensImpl();
    return overridingHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OverridingHiddensCall createOverridingHiddensCall()
  {
    OverridingHiddensCallImpl overridingHiddensCall = new OverridingHiddensCallImpl();
    return overridingHiddensCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InheritingHiddens createInheritingHiddens()
  {
    InheritingHiddensImpl inheritingHiddens = new InheritingHiddensImpl();
    return inheritingHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DatatypeHiddens createDatatypeHiddens()
  {
    DatatypeHiddensImpl datatypeHiddens = new DatatypeHiddensImpl();
    return datatypeHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HidingHiddens createHidingHiddens()
  {
    HidingHiddensImpl hidingHiddens = new HidingHiddensImpl();
    return hidingHiddens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InheritingHiddensCall createInheritingHiddensCall()
  {
    InheritingHiddensCallImpl inheritingHiddensCall = new InheritingHiddensCallImpl();
    return inheritingHiddensCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddenTerminalsTestLanguagePackage getHiddenTerminalsTestLanguagePackage()
  {
    return (HiddenTerminalsTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static HiddenTerminalsTestLanguagePackage getPackage()
  {
    return HiddenTerminalsTestLanguagePackage.eINSTANCE;
  }

} //HiddenTerminalsTestLanguageFactoryImpl
