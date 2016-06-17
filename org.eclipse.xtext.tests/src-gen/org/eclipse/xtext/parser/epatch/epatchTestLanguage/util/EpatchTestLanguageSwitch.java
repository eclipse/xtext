/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.*;

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
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage
 * @generated
 */
public class EpatchTestLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EpatchTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EpatchTestLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EpatchTestLanguagePackage.eINSTANCE;
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
      case EpatchTestLanguagePackage.EPATCH:
      {
        EPatch ePatch = (EPatch)theEObject;
        T result = caseEPatch(ePatch);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.MODEL_IMPORT:
      {
        ModelImport modelImport = (ModelImport)theEObject;
        T result = caseModelImport(modelImport);
        if (result == null) result = caseImport(modelImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.RESOURCE_IMPORT:
      {
        ResourceImport resourceImport = (ResourceImport)theEObject;
        T result = caseResourceImport(resourceImport);
        if (result == null) result = caseModelImport(resourceImport);
        if (result == null) result = caseImport(resourceImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.EPACKAGE_IMPORT:
      {
        EPackageImport ePackageImport = (EPackageImport)theEObject;
        T result = caseEPackageImport(ePackageImport);
        if (result == null) result = caseModelImport(ePackageImport);
        if (result == null) result = caseImport(ePackageImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.JAVA_IMPORT:
      {
        JavaImport javaImport = (JavaImport)theEObject;
        T result = caseJavaImport(javaImport);
        if (result == null) result = caseImport(javaImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.EXTENSION_IMPORT:
      {
        ExtensionImport extensionImport = (ExtensionImport)theEObject;
        T result = caseExtensionImport(extensionImport);
        if (result == null) result = caseImport(extensionImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.NAMED_RESOURCE:
      {
        NamedResource namedResource = (NamedResource)theEObject;
        T result = caseNamedResource(namedResource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.NAMED_OBJECT:
      {
        NamedObject namedObject = (NamedObject)theEObject;
        T result = caseNamedObject(namedObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.OBJECT_REF:
      {
        ObjectRef objectRef = (ObjectRef)theEObject;
        T result = caseObjectRef(objectRef);
        if (result == null) result = caseNamedObject(objectRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.ASSIGNMENT:
      {
        Assignment assignment = (Assignment)theEObject;
        T result = caseAssignment(assignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT:
      {
        SingleAssignment singleAssignment = (SingleAssignment)theEObject;
        T result = caseSingleAssignment(singleAssignment);
        if (result == null) result = caseAssignment(singleAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.LIST_ASSIGNMENT:
      {
        ListAssignment listAssignment = (ListAssignment)theEObject;
        T result = caseListAssignment(listAssignment);
        if (result == null) result = caseAssignment(listAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE:
      {
        AssignmentValue assignmentValue = (AssignmentValue)theEObject;
        T result = caseAssignmentValue(assignmentValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.CREATED_OBJECT:
      {
        CreatedObject createdObject = (CreatedObject)theEObject;
        T result = caseCreatedObject(createdObject);
        if (result == null) result = caseNamedObject(createdObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.OBJECT_NEW:
      {
        ObjectNew objectNew = (ObjectNew)theEObject;
        T result = caseObjectNew(objectNew);
        if (result == null) result = caseCreatedObject(objectNew);
        if (result == null) result = caseNamedObject(objectNew);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.OBJECT_COPY:
      {
        ObjectCopy objectCopy = (ObjectCopy)theEObject;
        T result = caseObjectCopy(objectCopy);
        if (result == null) result = caseCreatedObject(objectCopy);
        if (result == null) result = caseNamedObject(objectCopy);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.MIGRATION:
      {
        Migration migration = (Migration)theEObject;
        T result = caseMigration(migration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.EXECUTABLE:
      {
        Executable executable = (Executable)theEObject;
        T result = caseExecutable(executable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.JAVA_EXECUTABLE:
      {
        JavaExecutable javaExecutable = (JavaExecutable)theEObject;
        T result = caseJavaExecutable(javaExecutable);
        if (result == null) result = caseExecutable(javaExecutable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE:
      {
        ExpressionExecutable expressionExecutable = (ExpressionExecutable)theEObject;
        T result = caseExpressionExecutable(expressionExecutable);
        if (result == null) result = caseExecutable(expressionExecutable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EPatch</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EPatch</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEPatch(EPatch object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelImport(ModelImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Resource Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Resource Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResourceImport(ResourceImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EPackage Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EPackage Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEPackageImport(EPackageImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaImport(JavaImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extension Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extension Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtensionImport(ExtensionImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Resource</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Resource</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedResource(NamedResource object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedObject(NamedObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectRef(ObjectRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignment(Assignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleAssignment(SingleAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListAssignment(ListAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignmentValue(AssignmentValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Created Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Created Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCreatedObject(CreatedObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object New</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object New</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectNew(ObjectNew object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Object Copy</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Object Copy</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseObjectCopy(ObjectCopy object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Migration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Migration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMigration(Migration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Executable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Executable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutable(Executable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java Executable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Executable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaExecutable(JavaExecutable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Executable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Executable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionExecutable(ExpressionExecutable object)
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

} //EpatchTestLanguageSwitch
