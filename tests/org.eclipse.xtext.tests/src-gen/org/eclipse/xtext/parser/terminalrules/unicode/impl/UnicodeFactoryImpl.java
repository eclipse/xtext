/**
 */
package org.eclipse.xtext.parser.terminalrules.unicode.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.terminalrules.unicode.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnicodeFactoryImpl extends EFactoryImpl implements UnicodeFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnicodeFactory init()
  {
    try
    {
      UnicodeFactory theUnicodeFactory = (UnicodeFactory)EPackage.Registry.INSTANCE.getEFactory(UnicodePackage.eNS_URI);
      if (theUnicodeFactory != null)
      {
        return theUnicodeFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnicodeFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnicodeFactoryImpl()
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
      case UnicodePackage.MODEL: return createModel();
      case UnicodePackage.ABSTRACT_STRING: return createAbstractString();
      case UnicodePackage.GSTRING: return createGString();
      case UnicodePackage.QUOTED_STRING: return createQuotedString();
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
  public AbstractString createAbstractString()
  {
    AbstractStringImpl abstractString = new AbstractStringImpl();
    return abstractString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GString createGString()
  {
    GStringImpl gString = new GStringImpl();
    return gString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuotedString createQuotedString()
  {
    QuotedStringImpl quotedString = new QuotedStringImpl();
    return quotedString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnicodePackage getUnicodePackage()
  {
    return (UnicodePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnicodePackage getPackage()
  {
    return UnicodePackage.eINSTANCE;
  }

} //UnicodeFactoryImpl
