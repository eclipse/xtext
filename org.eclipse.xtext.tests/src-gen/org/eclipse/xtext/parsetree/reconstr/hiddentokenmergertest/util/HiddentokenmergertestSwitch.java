/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.*;

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
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage
 * @generated
 */
public class HiddentokenmergertestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HiddentokenmergertestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddentokenmergertestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = HiddentokenmergertestPackage.eINSTANCE;
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
      case HiddentokenmergertestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.DATATYPE_BUG286557:
      {
        DatatypeBug286557 datatypeBug286557 = (DatatypeBug286557)theEObject;
        T result = caseDatatypeBug286557(datatypeBug286557);
        if (result == null) result = caseModel(datatypeBug286557);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ENUM_BUG:
      {
        EnumBug enumBug = (EnumBug)theEObject;
        T result = caseEnumBug(enumBug);
        if (result == null) result = caseModel(enumBug);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.COMMENTABLE:
      {
        Commentable commentable = (Commentable)theEObject;
        T result = caseCommentable(commentable);
        if (result == null) result = caseModel(commentable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.COMMENTABLE_ITEM:
      {
        CommentableItem commentableItem = (CommentableItem)theEObject;
        T result = caseCommentableItem(commentableItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.VALUE_LIST:
      {
        ValueList valueList = (ValueList)theEObject;
        T result = caseValueList(valueList);
        if (result == null) result = caseModel(valueList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.REF_LIST:
      {
        RefList refList = (RefList)theEObject;
        T result = caseRefList(refList);
        if (result == null) result = caseModel(refList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.REF_OBJ:
      {
        RefObj refObj = (RefObj)theEObject;
        T result = caseRefObj(refObj);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.SINGLE_REF:
      {
        SingleRef singleRef = (SingleRef)theEObject;
        T result = caseSingleRef(singleRef);
        if (result == null) result = caseModel(singleRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.APPEND_TO_FILE_END:
      {
        AppendToFileEnd appendToFileEnd = (AppendToFileEnd)theEObject;
        T result = caseAppendToFileEnd(appendToFileEnd);
        if (result == null) result = caseModel(appendToFileEnd);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.APPEND_TO_FILE_END_ITEM:
      {
        AppendToFileEndItem appendToFileEndItem = (AppendToFileEndItem)theEObject;
        T result = caseAppendToFileEndItem(appendToFileEndItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ACTION1:
      {
        Action1 action1 = (Action1)theEObject;
        T result = caseAction1(action1);
        if (result == null) result = caseModel(action1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ACTION1_SUB1:
      {
        Action1Sub1 action1Sub1 = (Action1Sub1)theEObject;
        T result = caseAction1Sub1(action1Sub1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ACTION1_SUB2:
      {
        Action1Sub2 action1Sub2 = (Action1Sub2)theEObject;
        T result = caseAction1Sub2(action1Sub2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ACTION1_SUB:
      {
        Action1Sub action1Sub = (Action1Sub)theEObject;
        T result = caseAction1Sub(action1Sub);
        if (result == null) result = caseAction1Sub1(action1Sub);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case HiddentokenmergertestPackage.ACTION1_SUB_CLASS:
      {
        Action1SubClass action1SubClass = (Action1SubClass)theEObject;
        T result = caseAction1SubClass(action1SubClass);
        if (result == null) result = caseAction1Sub2(action1SubClass);
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
   * Returns the result of interpreting the object as an instance of '<em>Datatype Bug286557</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Datatype Bug286557</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDatatypeBug286557(DatatypeBug286557 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Bug</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Bug</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumBug(EnumBug object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Commentable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Commentable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommentable(Commentable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Commentable Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Commentable Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCommentableItem(CommentableItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueList(ValueList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefList(RefList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Obj</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Obj</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefObj(RefObj object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleRef(SingleRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Append To File End</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Append To File End</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAppendToFileEnd(AppendToFileEnd object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Append To File End Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Append To File End Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAppendToFileEndItem(AppendToFileEndItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction1(Action1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action1 Sub1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action1 Sub1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction1Sub1(Action1Sub1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action1 Sub2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action1 Sub2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction1Sub2(Action1Sub2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action1 Sub</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action1 Sub</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction1Sub(Action1Sub object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action1 Sub Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action1 Sub Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction1SubClass(Action1SubClass object)
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

} //HiddentokenmergertestSwitch
