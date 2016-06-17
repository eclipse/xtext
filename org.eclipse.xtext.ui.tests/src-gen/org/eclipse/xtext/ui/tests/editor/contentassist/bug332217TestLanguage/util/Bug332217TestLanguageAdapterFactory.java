/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage
 * @generated
 */
public class Bug332217TestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Bug332217TestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug332217TestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Bug332217TestLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Bug332217TestLanguageSwitch<Adapter> modelSwitch =
    new Bug332217TestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter casePropertyPathPart(PropertyPathPart object)
      {
        return createPropertyPathPartAdapter();
      }
      @Override
      public Adapter caseTypeDescription(TypeDescription object)
      {
        return createTypeDescriptionAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseObjectReference(ObjectReference object)
      {
        return createObjectReferenceAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseScalarExpression(ScalarExpression object)
      {
        return createScalarExpressionAdapter();
      }
      @Override
      public Adapter caseCollectionExpression(CollectionExpression object)
      {
        return createCollectionExpressionAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseStringFunction(StringFunction object)
      {
        return createStringFunctionAdapter();
      }
      @Override
      public Adapter caseCollectionLiteral(CollectionLiteral object)
      {
        return createCollectionLiteralAdapter();
      }
      @Override
      public Adapter caseCollectionFunction(CollectionFunction object)
      {
        return createCollectionFunctionAdapter();
      }
      @Override
      public Adapter caseTableView(TableView object)
      {
        return createTableViewAdapter();
      }
      @Override
      public Adapter caseViewContentElement(ViewContentElement object)
      {
        return createViewContentElementAdapter();
      }
      @Override
      public Adapter caseSection(Section object)
      {
        return createSectionAdapter();
      }
      @Override
      public Adapter caseCell(Cell object)
      {
        return createCellAdapter();
      }
      @Override
      public Adapter caseCollectionIterator(CollectionIterator object)
      {
        return createCollectionIteratorAdapter();
      }
      @Override
      public Adapter caseViewAction(ViewAction object)
      {
        return createViewActionAdapter();
      }
      @Override
      public Adapter caseSelector(Selector object)
      {
        return createSelectorAdapter();
      }
      @Override
      public Adapter caseExternalOpen(ExternalOpen object)
      {
        return createExternalOpenAdapter();
      }
      @Override
      public Adapter caseStringConcat(StringConcat object)
      {
        return createStringConcatAdapter();
      }
      @Override
      public Adapter caseStringReplace(StringReplace object)
      {
        return createStringReplaceAdapter();
      }
      @Override
      public Adapter caseStringUrlConform(StringUrlConform object)
      {
        return createStringUrlConformAdapter();
      }
      @Override
      public Adapter caseStringSplit(StringSplit object)
      {
        return createStringSplitAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart <em>Property Path Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.PropertyPathPart
   * @generated
   */
  public Adapter createPropertyPathPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription <em>Type Description</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TypeDescription
   * @generated
   */
  public Adapter createTypeDescriptionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference <em>Object Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ObjectReference
   * @generated
   */
  public Adapter createObjectReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression <em>Scalar Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ScalarExpression
   * @generated
   */
  public Adapter createScalarExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionExpression <em>Collection Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionExpression
   * @generated
   */
  public Adapter createCollectionExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringFunction <em>String Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringFunction
   * @generated
   */
  public Adapter createStringFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral <em>Collection Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionLiteral
   * @generated
   */
  public Adapter createCollectionLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionFunction <em>Collection Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionFunction
   * @generated
   */
  public Adapter createCollectionFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView <em>Table View</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.TableView
   * @generated
   */
  public Adapter createTableViewAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement <em>View Content Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewContentElement
   * @generated
   */
  public Adapter createViewContentElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section <em>Section</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Section
   * @generated
   */
  public Adapter createSectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell <em>Cell</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Cell
   * @generated
   */
  public Adapter createCellAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator <em>Collection Iterator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.CollectionIterator
   * @generated
   */
  public Adapter createCollectionIteratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction <em>View Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ViewAction
   * @generated
   */
  public Adapter createViewActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector <em>Selector</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Selector
   * @generated
   */
  public Adapter createSelectorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen <em>External Open</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.ExternalOpen
   * @generated
   */
  public Adapter createExternalOpenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat <em>String Concat</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringConcat
   * @generated
   */
  public Adapter createStringConcatAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace <em>String Replace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringReplace
   * @generated
   */
  public Adapter createStringReplaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform <em>String Url Conform</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringUrlConform
   * @generated
   */
  public Adapter createStringUrlConformAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit <em>String Split</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.StringSplit
   * @generated
   */
  public Adapter createStringSplitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Bug332217TestLanguageAdapterFactory
