/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.serializer.contextFinderTest.*;

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
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage
 * @generated
 */
public class ContextFinderTestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ContextFinderTestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ContextFinderTestPackage.eINSTANCE;
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
      case ContextFinderTestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.ATTRIBUTE_EXCLUSION_TEST:
      {
        AttributeExclusionTest attributeExclusionTest = (AttributeExclusionTest)theEObject;
        T result = caseAttributeExclusionTest(attributeExclusionTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_TEST:
      {
        NestedTypeTest nestedTypeTest = (NestedTypeTest)theEObject;
        T result = caseNestedTypeTest(nestedTypeTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_CHILD:
      {
        NestedTypeChild nestedTypeChild = (NestedTypeChild)theEObject;
        T result = caseNestedTypeChild(nestedTypeChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_CHILD1:
      {
        NestedTypeChild1 nestedTypeChild1 = (NestedTypeChild1)theEObject;
        T result = caseNestedTypeChild1(nestedTypeChild1);
        if (result == null) result = caseNestedTypeChild(nestedTypeChild1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_CHILD2:
      {
        NestedTypeChild2 nestedTypeChild2 = (NestedTypeChild2)theEObject;
        T result = caseNestedTypeChild2(nestedTypeChild2);
        if (result == null) result = caseNestedTypeChild(nestedTypeChild2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST:
      {
        NestedTypeRecursiveTest nestedTypeRecursiveTest = (NestedTypeRecursiveTest)theEObject;
        T result = caseNestedTypeRecursiveTest(nestedTypeRecursiveTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.PARENT_REF_TEST1:
      {
        ParentRefTest1 parentRefTest1 = (ParentRefTest1)theEObject;
        T result = caseParentRefTest1(parentRefTest1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.PARENT_REF_TEST2:
      {
        ParentRefTest2 parentRefTest2 = (ParentRefTest2)theEObject;
        T result = caseParentRefTest2(parentRefTest2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.PARENT_REF_TEST_CHILD:
      {
        ParentRefTestChild parentRefTestChild = (ParentRefTestChild)theEObject;
        T result = caseParentRefTestChild(parentRefTestChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.QUANTITY_EXCLUSION_TEST:
      {
        QuantityExclusionTest quantityExclusionTest = (QuantityExclusionTest)theEObject;
        T result = caseQuantityExclusionTest(quantityExclusionTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.VALUE_EXCLUSION_TEST:
      {
        ValueExclusionTest valueExclusionTest = (ValueExclusionTest)theEObject;
        T result = caseValueExclusionTest(valueExclusionTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NODE_EXCLUSION:
      {
        NodeExclusion nodeExclusion = (NodeExclusion)theEObject;
        T result = caseNodeExclusion(nodeExclusion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NODE_EXCLUSION_LIST:
      {
        NodeExclusionList nodeExclusionList = (NodeExclusionList)theEObject;
        T result = caseNodeExclusionList(nodeExclusionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST1:
      {
        NestedTypeRecursiveTest1 nestedTypeRecursiveTest1 = (NestedTypeRecursiveTest1)theEObject;
        T result = caseNestedTypeRecursiveTest1(nestedTypeRecursiveTest1);
        if (result == null) result = caseNestedTypeRecursiveTest(nestedTypeRecursiveTest1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ContextFinderTestPackage.NESTED_TYPE_RECURSIVE_TEST2:
      {
        NestedTypeRecursiveTest2 nestedTypeRecursiveTest2 = (NestedTypeRecursiveTest2)theEObject;
        T result = caseNestedTypeRecursiveTest2(nestedTypeRecursiveTest2);
        if (result == null) result = caseNestedTypeRecursiveTest(nestedTypeRecursiveTest2);
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
   * Returns the result of interpreting the object as an instance of '<em>Attribute Exclusion Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Exclusion Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeExclusionTest(AttributeExclusionTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeTest(NestedTypeTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeChild(NestedTypeChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Child1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Child1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeChild1(NestedTypeChild1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Child2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Child2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeChild2(NestedTypeChild2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Recursive Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Recursive Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeRecursiveTest(NestedTypeRecursiveTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parent Ref Test1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parent Ref Test1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParentRefTest1(ParentRefTest1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parent Ref Test2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parent Ref Test2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParentRefTest2(ParentRefTest2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parent Ref Test Child</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parent Ref Test Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParentRefTestChild(ParentRefTestChild object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quantity Exclusion Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quantity Exclusion Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuantityExclusionTest(QuantityExclusionTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Exclusion Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Exclusion Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueExclusionTest(ValueExclusionTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Exclusion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Exclusion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeExclusion(NodeExclusion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Exclusion List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Exclusion List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeExclusionList(NodeExclusionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Recursive Test1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Recursive Test1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeRecursiveTest1(NestedTypeRecursiveTest1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Type Recursive Test2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Type Recursive Test2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedTypeRecursiveTest2(NestedTypeRecursiveTest2 object)
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

} //ContextFinderTestSwitch
