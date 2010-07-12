/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage
 * @generated
 */
public class BacktrackingContentAssistTestSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BacktrackingContentAssistTestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingContentAssistTestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = BacktrackingContentAssistTestPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case BacktrackingContentAssistTestPackage.DOCUMENT:
      {
        Document document = (Document)theEObject;
        T result = caseDocument(document);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.BODY:
      {
        Body body = (Body)theEObject;
        T result = caseBody(body);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL:
      {
        ClassifierContextDecl classifierContextDecl = (ClassifierContextDecl)theEObject;
        T result = caseClassifierContextDecl(classifierContextDecl);
        if (result == null) result = caseContextDecl(classifierContextDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.CLASSIFIER_REF:
      {
        ClassifierRef classifierRef = (ClassifierRef)theEObject;
        T result = caseClassifierRef(classifierRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.CONTEXT_DECL:
      {
        ContextDecl contextDecl = (ContextDecl)theEObject;
        T result = caseContextDecl(contextDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.DEFINITION:
      {
        Definition definition = (Definition)theEObject;
        T result = caseDefinition(definition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.DER:
      {
        Der der = (Der)theEObject;
        T result = caseDer(der);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.INIT:
      {
        Init init = (Init)theEObject;
        T result = caseInit(init);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.INVARIANT:
      {
        Invariant invariant = (Invariant)theEObject;
        T result = caseInvariant(invariant);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL:
      {
        OperationContextDecl operationContextDecl = (OperationContextDecl)theEObject;
        T result = caseOperationContextDecl(operationContextDecl);
        if (result == null) result = caseContextDecl(operationContextDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.OPERATION_REF:
      {
        OperationRef operationRef = (OperationRef)theEObject;
        T result = caseOperationRef(operationRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PACKAGE_DECLARATION:
      {
        PackageDeclaration packageDeclaration = (PackageDeclaration)theEObject;
        T result = casePackageDeclaration(packageDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PACKAGE_REF:
      {
        PackageRef packageRef = (PackageRef)theEObject;
        T result = casePackageRef(packageRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.POST:
      {
        Post post = (Post)theEObject;
        T result = casePost(post);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PRE:
      {
        Pre pre = (Pre)theEObject;
        T result = casePre(pre);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL:
      {
        PropertyContextDecl propertyContextDecl = (PropertyContextDecl)theEObject;
        T result = casePropertyContextDecl(propertyContextDecl);
        if (result == null) result = caseContextDecl(propertyContextDecl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PROPERTY_REF:
      {
        PropertyRef propertyRef = (PropertyRef)theEObject;
        T result = casePropertyRef(propertyRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.QUALIFIED_CLASSIFIER_REF:
      {
        QualifiedClassifierRef qualifiedClassifierRef = (QualifiedClassifierRef)theEObject;
        T result = caseQualifiedClassifierRef(qualifiedClassifierRef);
        if (result == null) result = caseClassifierRef(qualifiedClassifierRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.QUALIFIED_OPERATION_REF:
      {
        QualifiedOperationRef qualifiedOperationRef = (QualifiedOperationRef)theEObject;
        T result = caseQualifiedOperationRef(qualifiedOperationRef);
        if (result == null) result = caseOperationRef(qualifiedOperationRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.QUALIFIED_PROPERTY_REF:
      {
        QualifiedPropertyRef qualifiedPropertyRef = (QualifiedPropertyRef)theEObject;
        T result = caseQualifiedPropertyRef(qualifiedPropertyRef);
        if (result == null) result = casePropertyRef(qualifiedPropertyRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.QUALIFIED_PACKAGE_REF:
      {
        QualifiedPackageRef qualifiedPackageRef = (QualifiedPackageRef)theEObject;
        T result = caseQualifiedPackageRef(qualifiedPackageRef);
        if (result == null) result = casePackageRef(qualifiedPackageRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SIMPLE_CLASSIFIER_REF:
      {
        SimpleClassifierRef simpleClassifierRef = (SimpleClassifierRef)theEObject;
        T result = caseSimpleClassifierRef(simpleClassifierRef);
        if (result == null) result = caseClassifierRef(simpleClassifierRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SIMPLE_OPERATION_REF:
      {
        SimpleOperationRef simpleOperationRef = (SimpleOperationRef)theEObject;
        T result = caseSimpleOperationRef(simpleOperationRef);
        if (result == null) result = caseOperationRef(simpleOperationRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SIMPLE_PACKAGE_REF:
      {
        SimplePackageRef simplePackageRef = (SimplePackageRef)theEObject;
        T result = caseSimplePackageRef(simplePackageRef);
        if (result == null) result = casePackageRef(simplePackageRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SIMPLE_PROPERTY_REF:
      {
        SimplePropertyRef simplePropertyRef = (SimplePropertyRef)theEObject;
        T result = caseSimplePropertyRef(simplePropertyRef);
        if (result == null) result = casePropertyRef(simplePropertyRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseNavigatingExp(expression);
        if (result == null) result = caseOclMessageArg(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.NAVIGATING_EXP:
      {
        NavigatingExp navigatingExp = (NavigatingExp)theEObject;
        T result = caseNavigatingExp(navigatingExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.OCL_MESSAGE_ARG:
      {
        OclMessageArg oclMessageArg = (OclMessageArg)theEObject;
        T result = caseOclMessageArg(oclMessageArg);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PRIMITIVE_TYPE:
      {
        PrimitiveType primitiveType = (PrimitiveType)theEObject;
        T result = casePrimitiveType(primitiveType);
        if (result == null) result = caseTypeExp(primitiveType);
        if (result == null) result = caseExpression(primitiveType);
        if (result == null) result = caseNavigatingExp(primitiveType);
        if (result == null) result = caseOclMessageArg(primitiveType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.TYPE_EXP:
      {
        TypeExp typeExp = (TypeExp)theEObject;
        T result = caseTypeExp(typeExp);
        if (result == null) result = caseExpression(typeExp);
        if (result == null) result = caseNavigatingExp(typeExp);
        if (result == null) result = caseOclMessageArg(typeExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE:
      {
        CollectionType collectionType = (CollectionType)theEObject;
        T result = caseCollectionType(collectionType);
        if (result == null) result = caseTypeExp(collectionType);
        if (result == null) result = caseCollectionLiteralExp(collectionType);
        if (result == null) result = caseExpression(collectionType);
        if (result == null) result = caseNavigatingExp(collectionType);
        if (result == null) result = caseOclMessageArg(collectionType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.TUPLE_TYPE:
      {
        TupleType tupleType = (TupleType)theEObject;
        T result = caseTupleType(tupleType);
        if (result == null) result = caseTypeExp(tupleType);
        if (result == null) result = caseExpression(tupleType);
        if (result == null) result = caseNavigatingExp(tupleType);
        if (result == null) result = caseOclMessageArg(tupleType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.TUPLE_PART:
      {
        tuplePart tuplePart = (tuplePart)theEObject;
        T result = casetuplePart(tuplePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_EXP:
      {
        CollectionLiteralExp collectionLiteralExp = (CollectionLiteralExp)theEObject;
        T result = caseCollectionLiteralExp(collectionLiteralExp);
        if (result == null) result = caseExpression(collectionLiteralExp);
        if (result == null) result = caseNavigatingExp(collectionLiteralExp);
        if (result == null) result = caseOclMessageArg(collectionLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART:
      {
        CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart)theEObject;
        T result = caseCollectionLiteralPart(collectionLiteralPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PRIMITIVE_LITERAL_EXP:
      {
        PrimitiveLiteralExp primitiveLiteralExp = (PrimitiveLiteralExp)theEObject;
        T result = casePrimitiveLiteralExp(primitiveLiteralExp);
        if (result == null) result = caseExpression(primitiveLiteralExp);
        if (result == null) result = caseNavigatingExp(primitiveLiteralExp);
        if (result == null) result = caseOclMessageArg(primitiveLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.TUPLE_LITERAL_EXP:
      {
        TupleLiteralExp tupleLiteralExp = (TupleLiteralExp)theEObject;
        T result = caseTupleLiteralExp(tupleLiteralExp);
        if (result == null) result = caseExpression(tupleLiteralExp);
        if (result == null) result = caseNavigatingExp(tupleLiteralExp);
        if (result == null) result = caseOclMessageArg(tupleLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.TUPLE_LITERAL_PART:
      {
        TupleLiteralPart tupleLiteralPart = (TupleLiteralPart)theEObject;
        T result = caseTupleLiteralPart(tupleLiteralPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.NUMBER_LITERAL_EXP:
      {
        NumberLiteralExp numberLiteralExp = (NumberLiteralExp)theEObject;
        T result = caseNumberLiteralExp(numberLiteralExp);
        if (result == null) result = casePrimitiveLiteralExp(numberLiteralExp);
        if (result == null) result = caseExpression(numberLiteralExp);
        if (result == null) result = caseNavigatingExp(numberLiteralExp);
        if (result == null) result = caseOclMessageArg(numberLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.STRING_LITERAL_EXP:
      {
        StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
        T result = caseStringLiteralExp(stringLiteralExp);
        if (result == null) result = casePrimitiveLiteralExp(stringLiteralExp);
        if (result == null) result = caseExpression(stringLiteralExp);
        if (result == null) result = caseNavigatingExp(stringLiteralExp);
        if (result == null) result = caseOclMessageArg(stringLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.BOOLEAN_LITERAL_EXP:
      {
        BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
        T result = caseBooleanLiteralExp(booleanLiteralExp);
        if (result == null) result = casePrimitiveLiteralExp(booleanLiteralExp);
        if (result == null) result = caseExpression(booleanLiteralExp);
        if (result == null) result = caseNavigatingExp(booleanLiteralExp);
        if (result == null) result = caseOclMessageArg(booleanLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.INVALID_LITERAL_EXP:
      {
        InvalidLiteralExp invalidLiteralExp = (InvalidLiteralExp)theEObject;
        T result = caseInvalidLiteralExp(invalidLiteralExp);
        if (result == null) result = casePrimitiveLiteralExp(invalidLiteralExp);
        if (result == null) result = caseExpression(invalidLiteralExp);
        if (result == null) result = caseNavigatingExp(invalidLiteralExp);
        if (result == null) result = caseOclMessageArg(invalidLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.NULL_LITERAL_EXP:
      {
        NullLiteralExp nullLiteralExp = (NullLiteralExp)theEObject;
        T result = caseNullLiteralExp(nullLiteralExp);
        if (result == null) result = casePrimitiveLiteralExp(nullLiteralExp);
        if (result == null) result = caseExpression(nullLiteralExp);
        if (result == null) result = caseNavigatingExp(nullLiteralExp);
        if (result == null) result = caseOclMessageArg(nullLiteralExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.ITERATOR_VARIABLE:
      {
        iteratorVariable iteratorVariable = (iteratorVariable)theEObject;
        T result = caseiteratorVariable(iteratorVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.ITERATOR_ACCUMULATOR:
      {
        iteratorAccumulator iteratorAccumulator = (iteratorAccumulator)theEObject;
        T result = caseiteratorAccumulator(iteratorAccumulator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP:
      {
        RoundBracketExp roundBracketExp = (RoundBracketExp)theEObject;
        T result = caseRoundBracketExp(roundBracketExp);
        if (result == null) result = caseExpression(roundBracketExp);
        if (result == null) result = caseNavigatingExp(roundBracketExp);
        if (result == null) result = caseOclMessageArg(roundBracketExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SQUARE_BRACKET_EXP:
      {
        SquareBracketExp squareBracketExp = (SquareBracketExp)theEObject;
        T result = caseSquareBracketExp(squareBracketExp);
        if (result == null) result = caseExpression(squareBracketExp);
        if (result == null) result = caseNavigatingExp(squareBracketExp);
        if (result == null) result = caseOclMessageArg(squareBracketExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PRE_EXP:
      {
        PreExp preExp = (PreExp)theEObject;
        T result = casePreExp(preExp);
        if (result == null) result = caseExpression(preExp);
        if (result == null) result = caseNavigatingExp(preExp);
        if (result == null) result = caseOclMessageArg(preExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SELF_EXP:
      {
        SelfExp selfExp = (SelfExp)theEObject;
        T result = caseSelfExp(selfExp);
        if (result == null) result = caseExpression(selfExp);
        if (result == null) result = caseNavigatingExp(selfExp);
        if (result == null) result = caseOclMessageArg(selfExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.NAME_EXP:
      {
        NameExp nameExp = (NameExp)theEObject;
        T result = caseNameExp(nameExp);
        if (result == null) result = caseTypeExp(nameExp);
        if (result == null) result = caseExpression(nameExp);
        if (result == null) result = caseNavigatingExp(nameExp);
        if (result == null) result = caseOclMessageArg(nameExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PATH_NAME_EXP:
      {
        PathNameExp pathNameExp = (PathNameExp)theEObject;
        T result = casePathNameExp(pathNameExp);
        if (result == null) result = caseNameExp(pathNameExp);
        if (result == null) result = caseTypeExp(pathNameExp);
        if (result == null) result = caseExpression(pathNameExp);
        if (result == null) result = caseNavigatingExp(pathNameExp);
        if (result == null) result = caseOclMessageArg(pathNameExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.SIMPLE_NAME_EXP:
      {
        SimpleNameExp simpleNameExp = (SimpleNameExp)theEObject;
        T result = caseSimpleNameExp(simpleNameExp);
        if (result == null) result = caseNameExp(simpleNameExp);
        if (result == null) result = caseTypeExp(simpleNameExp);
        if (result == null) result = caseExpression(simpleNameExp);
        if (result == null) result = caseNavigatingExp(simpleNameExp);
        if (result == null) result = caseOclMessageArg(simpleNameExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.IF_EXP:
      {
        IfExp ifExp = (IfExp)theEObject;
        T result = caseIfExp(ifExp);
        if (result == null) result = caseExpression(ifExp);
        if (result == null) result = caseNavigatingExp(ifExp);
        if (result == null) result = caseOclMessageArg(ifExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.LET_EXP:
      {
        LetExp letExp = (LetExp)theEObject;
        T result = caseLetExp(letExp);
        if (result == null) result = caseExpression(letExp);
        if (result == null) result = caseNavigatingExp(letExp);
        if (result == null) result = caseOclMessageArg(letExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.LET_VARIABLE:
      {
        LetVariable letVariable = (LetVariable)theEObject;
        T result = caseLetVariable(letVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.INFIX_EXP:
      {
        InfixExp infixExp = (InfixExp)theEObject;
        T result = caseInfixExp(infixExp);
        if (result == null) result = caseExpression(infixExp);
        if (result == null) result = caseNavigatingExp(infixExp);
        if (result == null) result = caseOclMessageArg(infixExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.OCL_MESSAGE:
      {
        OclMessage oclMessage = (OclMessage)theEObject;
        T result = caseOclMessage(oclMessage);
        if (result == null) result = caseExpression(oclMessage);
        if (result == null) result = caseNavigatingExp(oclMessage);
        if (result == null) result = caseOclMessageArg(oclMessage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.PREFIX_EXP:
      {
        PrefixExp prefixExp = (PrefixExp)theEObject;
        T result = casePrefixExp(prefixExp);
        if (result == null) result = caseExpression(prefixExp);
        if (result == null) result = caseNavigatingExp(prefixExp);
        if (result == null) result = caseOclMessageArg(prefixExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case BacktrackingContentAssistTestPackage.NESTED_EXP:
      {
        NestedExp nestedExp = (NestedExp)theEObject;
        T result = caseNestedExp(nestedExp);
        if (result == null) result = caseExpression(nestedExp);
        if (result == null) result = caseNavigatingExp(nestedExp);
        if (result == null) result = caseOclMessageArg(nestedExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocument(Document object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Body</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Body</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBody(Body object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierContextDecl(ClassifierContextDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierRef(ClassifierRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextDecl(ContextDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefinition(Definition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Der</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Der</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDer(Der object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Init</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Init</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInit(Init object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invariant</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invariant</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvariant(Invariant object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Context Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationContextDecl(OperationContextDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationRef(OperationRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDeclaration(PackageDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageRef(PackageRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Post</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Post</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePost(Post object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePre(Pre object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Context Decl</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Context Decl</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyContextDecl(PropertyContextDecl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyRef(PropertyRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Classifier Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Classifier Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedClassifierRef(QualifiedClassifierRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Operation Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Operation Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedOperationRef(QualifiedOperationRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Property Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Property Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedPropertyRef(QualifiedPropertyRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Package Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Package Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedPackageRef(QualifiedPackageRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Classifier Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Classifier Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleClassifierRef(SimpleClassifierRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Operation Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Operation Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleOperationRef(SimpleOperationRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Package Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Package Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimplePackageRef(SimplePackageRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Property Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Property Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimplePropertyRef(SimplePropertyRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Navigating Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Navigating Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNavigatingExp(NavigatingExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ocl Message Arg</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ocl Message Arg</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOclMessageArg(OclMessageArg object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveType(PrimitiveType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeExp(TypeExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionType(CollectionType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleType(TupleType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>tuple Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>tuple Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casetuplePart(tuplePart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteralExp(CollectionLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteralPart(CollectionLiteralPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveLiteralExp(PrimitiveLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleLiteralExp(TupleLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleLiteralPart(TupleLiteralPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteralExp(NumberLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralExp(StringLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteralExp(BooleanLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvalidLiteralExp(InvalidLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Literal Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullLiteralExp(NullLiteralExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>iterator Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>iterator Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseiteratorVariable(iteratorVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>iterator Accumulator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>iterator Accumulator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseiteratorAccumulator(iteratorAccumulator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Round Bracket Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Round Bracket Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoundBracketExp(RoundBracketExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Square Bracket Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Square Bracket Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSquareBracketExp(SquareBracketExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePreExp(PreExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Self Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Self Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelfExp(SelfExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameExp(NameExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Path Name Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Name Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePathNameExp(PathNameExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Name Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Name Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleNameExp(SimpleNameExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfExp(IfExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetExp(LetExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetVariable(LetVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Infix Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Infix Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInfixExp(InfixExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ocl Message</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ocl Message</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOclMessage(OclMessage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefix Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefix Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixExp(PrefixExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedExp(NestedExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //BacktrackingContentAssistTestSwitch
