/**
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingBug325745TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BacktrackingBug325745TestLanguageFactoryImpl extends EFactoryImpl implements BacktrackingBug325745TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BacktrackingBug325745TestLanguageFactory init()
  {
    try
    {
      BacktrackingBug325745TestLanguageFactory theBacktrackingBug325745TestLanguageFactory = (BacktrackingBug325745TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(BacktrackingBug325745TestLanguagePackage.eNS_URI);
      if (theBacktrackingBug325745TestLanguageFactory != null)
      {
        return theBacktrackingBug325745TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BacktrackingBug325745TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingBug325745TestLanguageFactoryImpl()
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
      case BacktrackingBug325745TestLanguagePackage.MODEL: return createModel();
      case BacktrackingBug325745TestLanguagePackage.ELEMENT: return createElement();
      case BacktrackingBug325745TestLanguagePackage.DATA_TYPE: return createDataType();
      case BacktrackingBug325745TestLanguagePackage.EXPRESSION: return createExpression();
      case BacktrackingBug325745TestLanguagePackage.SIMPLE_TERM: return createSimpleTerm();
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
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
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
  public SimpleTerm createSimpleTerm()
  {
    SimpleTermImpl simpleTerm = new SimpleTermImpl();
    return simpleTerm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingBug325745TestLanguagePackage getBacktrackingBug325745TestLanguagePackage()
  {
    return (BacktrackingBug325745TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BacktrackingBug325745TestLanguagePackage getPackage()
  {
    return BacktrackingBug325745TestLanguagePackage.eINSTANCE;
  }

} //BacktrackingBug325745TestLanguageFactoryImpl
