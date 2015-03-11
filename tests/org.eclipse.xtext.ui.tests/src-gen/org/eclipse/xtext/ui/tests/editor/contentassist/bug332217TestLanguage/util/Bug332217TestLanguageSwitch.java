/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.*;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug332217TestLanguage.Bug332217TestLanguagePackage
 * @generated
 */
public class Bug332217TestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Bug332217TestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug332217TestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Bug332217TestLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Bug332217TestLanguagePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.PROPERTY_PATH_PART:
      {
        PropertyPathPart propertyPathPart = (PropertyPathPart)theEObject;
        T result = casePropertyPathPart(propertyPathPart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.TYPE_DESCRIPTION:
      {
        TypeDescription typeDescription = (TypeDescription)theEObject;
        T result = caseTypeDescription(typeDescription);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = casePropertyPathPart(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.OBJECT_REFERENCE:
      {
        ObjectReference objectReference = (ObjectReference)theEObject;
        T result = caseObjectReference(objectReference);
        if (result == null) result = caseExpression(objectReference);
        if (result == null) result = caseScalarExpression(objectReference);
        if (result == null) result = caseCollectionExpression(objectReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.SCALAR_EXPRESSION:
      {
        ScalarExpression scalarExpression = (ScalarExpression)theEObject;
        T result = caseScalarExpression(scalarExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.COLLECTION_EXPRESSION:
      {
        CollectionExpression collectionExpression = (CollectionExpression)theEObject;
        T result = caseCollectionExpression(collectionExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseExpression(stringLiteral);
        if (result == null) result = caseScalarExpression(stringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_FUNCTION:
      {
        StringFunction stringFunction = (StringFunction)theEObject;
        T result = caseStringFunction(stringFunction);
        if (result == null) result = caseExpression(stringFunction);
        if (result == null) result = caseScalarExpression(stringFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.COLLECTION_LITERAL:
      {
        CollectionLiteral collectionLiteral = (CollectionLiteral)theEObject;
        T result = caseCollectionLiteral(collectionLiteral);
        if (result == null) result = caseExpression(collectionLiteral);
        if (result == null) result = caseCollectionExpression(collectionLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.COLLECTION_FUNCTION:
      {
        CollectionFunction collectionFunction = (CollectionFunction)theEObject;
        T result = caseCollectionFunction(collectionFunction);
        if (result == null) result = caseExpression(collectionFunction);
        if (result == null) result = caseCollectionExpression(collectionFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.TABLE_VIEW:
      {
        TableView tableView = (TableView)theEObject;
        T result = caseTableView(tableView);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.VIEW_CONTENT_ELEMENT:
      {
        ViewContentElement viewContentElement = (ViewContentElement)theEObject;
        T result = caseViewContentElement(viewContentElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.SECTION:
      {
        Section section = (Section)theEObject;
        T result = caseSection(section);
        if (result == null) result = caseViewContentElement(section);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.CELL:
      {
        Cell cell = (Cell)theEObject;
        T result = caseCell(cell);
        if (result == null) result = caseViewContentElement(cell);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.COLLECTION_ITERATOR:
      {
        CollectionIterator collectionIterator = (CollectionIterator)theEObject;
        T result = caseCollectionIterator(collectionIterator);
        if (result == null) result = casePropertyPathPart(collectionIterator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.VIEW_ACTION:
      {
        ViewAction viewAction = (ViewAction)theEObject;
        T result = caseViewAction(viewAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.SELECTOR:
      {
        Selector selector = (Selector)theEObject;
        T result = caseSelector(selector);
        if (result == null) result = caseViewAction(selector);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.EXTERNAL_OPEN:
      {
        ExternalOpen externalOpen = (ExternalOpen)theEObject;
        T result = caseExternalOpen(externalOpen);
        if (result == null) result = caseViewAction(externalOpen);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_CONCAT:
      {
        StringConcat stringConcat = (StringConcat)theEObject;
        T result = caseStringConcat(stringConcat);
        if (result == null) result = caseStringFunction(stringConcat);
        if (result == null) result = caseExpression(stringConcat);
        if (result == null) result = caseScalarExpression(stringConcat);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_REPLACE:
      {
        StringReplace stringReplace = (StringReplace)theEObject;
        T result = caseStringReplace(stringReplace);
        if (result == null) result = caseStringFunction(stringReplace);
        if (result == null) result = caseExpression(stringReplace);
        if (result == null) result = caseScalarExpression(stringReplace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_URL_CONFORM:
      {
        StringUrlConform stringUrlConform = (StringUrlConform)theEObject;
        T result = caseStringUrlConform(stringUrlConform);
        if (result == null) result = caseStringFunction(stringUrlConform);
        if (result == null) result = caseExpression(stringUrlConform);
        if (result == null) result = caseScalarExpression(stringUrlConform);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Bug332217TestLanguagePackage.STRING_SPLIT:
      {
        StringSplit stringSplit = (StringSplit)theEObject;
        T result = caseStringSplit(stringSplit);
        if (result == null) result = caseCollectionFunction(stringSplit);
        if (result == null) result = caseExpression(stringSplit);
        if (result == null) result = caseCollectionExpression(stringSplit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Path Part</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Path Part</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyPathPart(PropertyPathPart object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Description</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Description</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDescription(TypeDescription object)
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
   * Returns the result of interpreting the object as an instance of '<em>Object Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectReference(ObjectReference object)
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
   * Returns the result of interpreting the object as an instance of '<em>Scalar Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scalar Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScalarExpression(ScalarExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionExpression(CollectionExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteral(StringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringFunction(StringFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteral(CollectionLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionFunction(CollectionFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table View</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table View</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableView(TableView object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>View Content Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>View Content Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewContentElement(ViewContentElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Section</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSection(Section object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cell</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cell</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCell(Cell object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Iterator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Iterator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionIterator(CollectionIterator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>View Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>View Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseViewAction(ViewAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selector</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selector</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelector(Selector object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Open</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Open</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalOpen(ExternalOpen object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Concat</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Concat</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringConcat(StringConcat object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Replace</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Replace</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringReplace(StringReplace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Url Conform</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Url Conform</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringUrlConform(StringUrlConform object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Split</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Split</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringSplit(StringSplit object)
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
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Bug332217TestLanguageSwitch
