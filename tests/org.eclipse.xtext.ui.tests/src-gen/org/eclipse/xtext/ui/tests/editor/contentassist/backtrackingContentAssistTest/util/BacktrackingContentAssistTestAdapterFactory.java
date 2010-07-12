/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage
 * @generated
 */
public class BacktrackingContentAssistTestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BacktrackingContentAssistTestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingContentAssistTestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = BacktrackingContentAssistTestPackage.eINSTANCE;
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
  protected BacktrackingContentAssistTestSwitch<Adapter> modelSwitch =
    new BacktrackingContentAssistTestSwitch<Adapter>()
    {
      @Override
      public Adapter caseDocument(Document object)
      {
        return createDocumentAdapter();
      }
      @Override
      public Adapter caseBody(Body object)
      {
        return createBodyAdapter();
      }
      @Override
      public Adapter caseClassifierContextDecl(ClassifierContextDecl object)
      {
        return createClassifierContextDeclAdapter();
      }
      @Override
      public Adapter caseClassifierRef(ClassifierRef object)
      {
        return createClassifierRefAdapter();
      }
      @Override
      public Adapter caseContextDecl(ContextDecl object)
      {
        return createContextDeclAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseDer(Der object)
      {
        return createDerAdapter();
      }
      @Override
      public Adapter caseInit(Init object)
      {
        return createInitAdapter();
      }
      @Override
      public Adapter caseInvariant(Invariant object)
      {
        return createInvariantAdapter();
      }
      @Override
      public Adapter caseOperationContextDecl(OperationContextDecl object)
      {
        return createOperationContextDeclAdapter();
      }
      @Override
      public Adapter caseOperationRef(OperationRef object)
      {
        return createOperationRefAdapter();
      }
      @Override
      public Adapter casePackageDeclaration(PackageDeclaration object)
      {
        return createPackageDeclarationAdapter();
      }
      @Override
      public Adapter casePackageRef(PackageRef object)
      {
        return createPackageRefAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter casePost(Post object)
      {
        return createPostAdapter();
      }
      @Override
      public Adapter casePre(Pre object)
      {
        return createPreAdapter();
      }
      @Override
      public Adapter casePropertyContextDecl(PropertyContextDecl object)
      {
        return createPropertyContextDeclAdapter();
      }
      @Override
      public Adapter casePropertyRef(PropertyRef object)
      {
        return createPropertyRefAdapter();
      }
      @Override
      public Adapter caseQualifiedClassifierRef(QualifiedClassifierRef object)
      {
        return createQualifiedClassifierRefAdapter();
      }
      @Override
      public Adapter caseQualifiedOperationRef(QualifiedOperationRef object)
      {
        return createQualifiedOperationRefAdapter();
      }
      @Override
      public Adapter caseQualifiedPropertyRef(QualifiedPropertyRef object)
      {
        return createQualifiedPropertyRefAdapter();
      }
      @Override
      public Adapter caseQualifiedPackageRef(QualifiedPackageRef object)
      {
        return createQualifiedPackageRefAdapter();
      }
      @Override
      public Adapter caseSimpleClassifierRef(SimpleClassifierRef object)
      {
        return createSimpleClassifierRefAdapter();
      }
      @Override
      public Adapter caseSimpleOperationRef(SimpleOperationRef object)
      {
        return createSimpleOperationRefAdapter();
      }
      @Override
      public Adapter caseSimplePackageRef(SimplePackageRef object)
      {
        return createSimplePackageRefAdapter();
      }
      @Override
      public Adapter caseSimplePropertyRef(SimplePropertyRef object)
      {
        return createSimplePropertyRefAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseNavigatingExp(NavigatingExp object)
      {
        return createNavigatingExpAdapter();
      }
      @Override
      public Adapter caseOclMessageArg(OclMessageArg object)
      {
        return createOclMessageArgAdapter();
      }
      @Override
      public Adapter casePrimitiveType(PrimitiveType object)
      {
        return createPrimitiveTypeAdapter();
      }
      @Override
      public Adapter caseTypeExp(TypeExp object)
      {
        return createTypeExpAdapter();
      }
      @Override
      public Adapter caseCollectionType(CollectionType object)
      {
        return createCollectionTypeAdapter();
      }
      @Override
      public Adapter caseTupleType(TupleType object)
      {
        return createTupleTypeAdapter();
      }
      @Override
      public Adapter casetuplePart(tuplePart object)
      {
        return createtuplePartAdapter();
      }
      @Override
      public Adapter caseCollectionLiteralExp(CollectionLiteralExp object)
      {
        return createCollectionLiteralExpAdapter();
      }
      @Override
      public Adapter caseCollectionLiteralPart(CollectionLiteralPart object)
      {
        return createCollectionLiteralPartAdapter();
      }
      @Override
      public Adapter casePrimitiveLiteralExp(PrimitiveLiteralExp object)
      {
        return createPrimitiveLiteralExpAdapter();
      }
      @Override
      public Adapter caseTupleLiteralExp(TupleLiteralExp object)
      {
        return createTupleLiteralExpAdapter();
      }
      @Override
      public Adapter caseTupleLiteralPart(TupleLiteralPart object)
      {
        return createTupleLiteralPartAdapter();
      }
      @Override
      public Adapter caseNumberLiteralExp(NumberLiteralExp object)
      {
        return createNumberLiteralExpAdapter();
      }
      @Override
      public Adapter caseStringLiteralExp(StringLiteralExp object)
      {
        return createStringLiteralExpAdapter();
      }
      @Override
      public Adapter caseBooleanLiteralExp(BooleanLiteralExp object)
      {
        return createBooleanLiteralExpAdapter();
      }
      @Override
      public Adapter caseInvalidLiteralExp(InvalidLiteralExp object)
      {
        return createInvalidLiteralExpAdapter();
      }
      @Override
      public Adapter caseNullLiteralExp(NullLiteralExp object)
      {
        return createNullLiteralExpAdapter();
      }
      @Override
      public Adapter caseiteratorVariable(iteratorVariable object)
      {
        return createiteratorVariableAdapter();
      }
      @Override
      public Adapter caseiteratorAccumulator(iteratorAccumulator object)
      {
        return createiteratorAccumulatorAdapter();
      }
      @Override
      public Adapter caseRoundBracketExp(RoundBracketExp object)
      {
        return createRoundBracketExpAdapter();
      }
      @Override
      public Adapter caseSquareBracketExp(SquareBracketExp object)
      {
        return createSquareBracketExpAdapter();
      }
      @Override
      public Adapter casePreExp(PreExp object)
      {
        return createPreExpAdapter();
      }
      @Override
      public Adapter caseSelfExp(SelfExp object)
      {
        return createSelfExpAdapter();
      }
      @Override
      public Adapter caseNameExp(NameExp object)
      {
        return createNameExpAdapter();
      }
      @Override
      public Adapter casePathNameExp(PathNameExp object)
      {
        return createPathNameExpAdapter();
      }
      @Override
      public Adapter caseSimpleNameExp(SimpleNameExp object)
      {
        return createSimpleNameExpAdapter();
      }
      @Override
      public Adapter caseIfExp(IfExp object)
      {
        return createIfExpAdapter();
      }
      @Override
      public Adapter caseLetExp(LetExp object)
      {
        return createLetExpAdapter();
      }
      @Override
      public Adapter caseLetVariable(LetVariable object)
      {
        return createLetVariableAdapter();
      }
      @Override
      public Adapter caseInfixExp(InfixExp object)
      {
        return createInfixExpAdapter();
      }
      @Override
      public Adapter caseOclMessage(OclMessage object)
      {
        return createOclMessageAdapter();
      }
      @Override
      public Adapter casePrefixExp(PrefixExp object)
      {
        return createPrefixExpAdapter();
      }
      @Override
      public Adapter caseNestedExp(NestedExp object)
      {
        return createNestedExpAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document <em>Document</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document
   * @generated
   */
  public Adapter createDocumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body
   * @generated
   */
  public Adapter createBodyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl <em>Classifier Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl
   * @generated
   */
  public Adapter createClassifierContextDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef <em>Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef
   * @generated
   */
  public Adapter createClassifierRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ContextDecl <em>Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ContextDecl
   * @generated
   */
  public Adapter createContextDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der <em>Der</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der
   * @generated
   */
  public Adapter createDerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init
   * @generated
   */
  public Adapter createInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant <em>Invariant</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant
   * @generated
   */
  public Adapter createInvariantAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl <em>Operation Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl
   * @generated
   */
  public Adapter createOperationContextDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef <em>Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef
   * @generated
   */
  public Adapter createOperationRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration
   * @generated
   */
  public Adapter createPackageDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageRef <em>Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageRef
   * @generated
   */
  public Adapter createPackageRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post <em>Post</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post
   * @generated
   */
  public Adapter createPostAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre <em>Pre</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre
   * @generated
   */
  public Adapter createPreAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl <em>Property Context Decl</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl
   * @generated
   */
  public Adapter createPropertyContextDeclAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef <em>Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef
   * @generated
   */
  public Adapter createPropertyRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef <em>Qualified Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef
   * @generated
   */
  public Adapter createQualifiedClassifierRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef <em>Qualified Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef
   * @generated
   */
  public Adapter createQualifiedOperationRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef <em>Qualified Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef
   * @generated
   */
  public Adapter createQualifiedPropertyRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef <em>Qualified Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef
   * @generated
   */
  public Adapter createQualifiedPackageRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef <em>Simple Classifier Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef
   * @generated
   */
  public Adapter createSimpleClassifierRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef <em>Simple Operation Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef
   * @generated
   */
  public Adapter createSimpleOperationRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef <em>Simple Package Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef
   * @generated
   */
  public Adapter createSimplePackageRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef <em>Simple Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef
   * @generated
   */
  public Adapter createSimplePropertyRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NavigatingExp <em>Navigating Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NavigatingExp
   * @generated
   */
  public Adapter createNavigatingExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg <em>Ocl Message Arg</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg
   * @generated
   */
  public Adapter createOclMessageArgAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType <em>Primitive Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType
   * @generated
   */
  public Adapter createPrimitiveTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp <em>Type Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp
   * @generated
   */
  public Adapter createTypeExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType <em>Collection Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType
   * @generated
   */
  public Adapter createCollectionTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType
   * @generated
   */
  public Adapter createTupleTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart <em>tuple Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart
   * @generated
   */
  public Adapter createtuplePartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp
   * @generated
   */
  public Adapter createCollectionLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart <em>Collection Literal Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart
   * @generated
   */
  public Adapter createCollectionLiteralPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveLiteralExp
   * @generated
   */
  public Adapter createPrimitiveLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp <em>Tuple Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp
   * @generated
   */
  public Adapter createTupleLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart <em>Tuple Literal Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart
   * @generated
   */
  public Adapter createTupleLiteralPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp <em>Number Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp
   * @generated
   */
  public Adapter createNumberLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp <em>String Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp
   * @generated
   */
  public Adapter createStringLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp
   * @generated
   */
  public Adapter createBooleanLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InvalidLiteralExp <em>Invalid Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InvalidLiteralExp
   * @generated
   */
  public Adapter createInvalidLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NullLiteralExp <em>Null Literal Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NullLiteralExp
   * @generated
   */
  public Adapter createNullLiteralExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable <em>iterator Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable
   * @generated
   */
  public Adapter createiteratorVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator <em>iterator Accumulator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator
   * @generated
   */
  public Adapter createiteratorAccumulatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp <em>Round Bracket Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp
   * @generated
   */
  public Adapter createRoundBracketExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp <em>Square Bracket Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp
   * @generated
   */
  public Adapter createSquareBracketExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp <em>Pre Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp
   * @generated
   */
  public Adapter createPreExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SelfExp <em>Self Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SelfExp
   * @generated
   */
  public Adapter createSelfExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp <em>Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp
   * @generated
   */
  public Adapter createNameExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp <em>Path Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp
   * @generated
   */
  public Adapter createPathNameExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp <em>Simple Name Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp
   * @generated
   */
  public Adapter createSimpleNameExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp <em>If Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp
   * @generated
   */
  public Adapter createIfExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp <em>Let Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp
   * @generated
   */
  public Adapter createLetExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable <em>Let Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable
   * @generated
   */
  public Adapter createLetVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp <em>Infix Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp
   * @generated
   */
  public Adapter createInfixExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage <em>Ocl Message</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage
   * @generated
   */
  public Adapter createOclMessageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp <em>Prefix Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp
   * @generated
   */
  public Adapter createPrefixExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp <em>Nested Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp
   * @generated
   */
  public Adapter createNestedExpAdapter()
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

} //BacktrackingContentAssistTestAdapterFactory
