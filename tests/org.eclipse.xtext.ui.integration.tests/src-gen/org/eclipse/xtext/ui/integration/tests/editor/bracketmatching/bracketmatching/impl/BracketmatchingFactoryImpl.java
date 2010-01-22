/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.integration.tests.editor.bracketmatching.bracketmatching.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BracketmatchingFactoryImpl extends EFactoryImpl implements BracketmatchingFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BracketmatchingFactory init()
  {
    try
    {
      BracketmatchingFactory theBracketmatchingFactory = (BracketmatchingFactory)EPackage.Registry.INSTANCE.getEFactory("http://xtext.org/ui/integartion/tests/bracketmatching"); 
      if (theBracketmatchingFactory != null)
      {
        return theBracketmatchingFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BracketmatchingFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracketmatchingFactoryImpl()
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
      case BracketmatchingPackage.FILE: return createFile();
      case BracketmatchingPackage.EXPRESSION: return createExpression();
      case BracketmatchingPackage.SEXPRESSION: return createSExpression();
      case BracketmatchingPackage.ATOM: return createAtom();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File createFile()
  {
    FileImpl file = new FileImpl();
    return file;
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
  public SExpression createSExpression()
  {
    SExpressionImpl sExpression = new SExpressionImpl();
    return sExpression;
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
  public BracketmatchingPackage getBracketmatchingPackage()
  {
    return (BracketmatchingPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BracketmatchingPackage getPackage()
  {
    return BracketmatchingPackage.eINSTANCE;
  }

} //BracketmatchingFactoryImpl
