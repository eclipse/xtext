/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.AbstractMulti2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug305171;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Enum;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Bug310435Val;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ConcreteMulti;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNameTest;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.CrossRefNamed;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.DuplicateBug284491;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectElement;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectBug284850;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Expression;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop3;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Loop4;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.LoopBug285452;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.ManyStrings;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.MultiInheritanceBug280439;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Op;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Ref2;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Spare;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Transient1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Type;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug1B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2A;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug2B;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_1;
import org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TypeBug305577_2;

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
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage
 * @generated
 */
public class SimplerewritetestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SimplerewritetestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplerewritetestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SimplerewritetestPackage.eINSTANCE;
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
      case SimplerewritetestPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.ATOM:
      {
        Atom atom = (Atom)theEObject;
        T result = caseAtom(atom);
        if (result == null) result = caseExpression(atom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TWO_NUMBERS:
      {
        TwoNumbers twoNumbers = (TwoNumbers)theEObject;
        T result = caseTwoNumbers(twoNumbers);
        if (result == null) result = caseExpression(twoNumbers);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.MANY_STRINGS:
      {
        ManyStrings manyStrings = (ManyStrings)theEObject;
        T result = caseManyStrings(manyStrings);
        if (result == null) result = caseExpression(manyStrings);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = caseExpression(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.REF2:
      {
        Ref2 ref2 = (Ref2)theEObject;
        T result = caseRef2(ref2);
        if (result == null) result = caseExpression(ref2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.SPARE:
      {
        Spare spare = (Spare)theEObject;
        T result = caseSpare(spare);
        if (result == null) result = caseExpression(spare);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.BOOLEAN:
      {
        org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean boolean_ = (org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean)theEObject;
        T result = caseBoolean(boolean_);
        if (result == null) result = caseExpression(boolean_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TRANSIENT1:
      {
        Transient1 transient1 = (Transient1)theEObject;
        T result = caseTransient1(transient1);
        if (result == null) result = caseExpression(transient1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.CONSUMED1:
      {
        Consumed1 consumed1 = (Consumed1)theEObject;
        T result = caseConsumed1(consumed1);
        if (result == null) result = caseExpression(consumed1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.CONSUMED2:
      {
        Consumed2 consumed2 = (Consumed2)theEObject;
        T result = caseConsumed2(consumed2);
        if (result == null) result = caseExpression(consumed2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.LOOP1:
      {
        Loop1 loop1 = (Loop1)theEObject;
        T result = caseLoop1(loop1);
        if (result == null) result = caseExpression(loop1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.LOOP2:
      {
        Loop2 loop2 = (Loop2)theEObject;
        T result = caseLoop2(loop2);
        if (result == null) result = caseExpression(loop2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.LOOP3:
      {
        Loop3 loop3 = (Loop3)theEObject;
        T result = caseLoop3(loop3);
        if (result == null) result = caseExpression(loop3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.LOOP4:
      {
        Loop4 loop4 = (Loop4)theEObject;
        T result = caseLoop4(loop4);
        if (result == null) result = caseExpression(loop4);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.LOOP_BUG285452:
      {
        LoopBug285452 loopBug285452 = (LoopBug285452)theEObject;
        T result = caseLoopBug285452(loopBug285452);
        if (result == null) result = caseExpression(loopBug285452);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.DUPLICATE_BUG284491:
      {
        DuplicateBug284491 duplicateBug284491 = (DuplicateBug284491)theEObject;
        T result = caseDuplicateBug284491(duplicateBug284491);
        if (result == null) result = caseExpression(duplicateBug284491);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.EMPTY_OBJECT_BUG284850:
      {
        EmptyObjectBug284850 emptyObjectBug284850 = (EmptyObjectBug284850)theEObject;
        T result = caseEmptyObjectBug284850(emptyObjectBug284850);
        if (result == null) result = caseExpression(emptyObjectBug284850);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.EMPTY_OBJECT_ITEMS:
      {
        EmptyObjectItems emptyObjectItems = (EmptyObjectItems)theEObject;
        T result = caseEmptyObjectItems(emptyObjectItems);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.EMPTY_OBJECT_ITEM:
      {
        EmptyObjectItem emptyObjectItem = (EmptyObjectItem)theEObject;
        T result = caseEmptyObjectItem(emptyObjectItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.MULTI_INHERITANCE_BUG280439:
      {
        MultiInheritanceBug280439 multiInheritanceBug280439 = (MultiInheritanceBug280439)theEObject;
        T result = caseMultiInheritanceBug280439(multiInheritanceBug280439);
        if (result == null) result = caseExpression(multiInheritanceBug280439);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.ABSTRACT_MULTI1:
      {
        AbstractMulti1 abstractMulti1 = (AbstractMulti1)theEObject;
        T result = caseAbstractMulti1(abstractMulti1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.ABSTRACT_MULTI2:
      {
        AbstractMulti2 abstractMulti2 = (AbstractMulti2)theEObject;
        T result = caseAbstractMulti2(abstractMulti2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.CONCRETE_MULTI:
      {
        ConcreteMulti concreteMulti = (ConcreteMulti)theEObject;
        T result = caseConcreteMulti(concreteMulti);
        if (result == null) result = caseAbstractMulti1(concreteMulti);
        if (result == null) result = caseAbstractMulti2(concreteMulti);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.EOBJECT_REF:
      {
        EObjectRef eObjectRef = (EObjectRef)theEObject;
        T result = caseEObjectRef(eObjectRef);
        if (result == null) result = caseExpression(eObjectRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.EOBJECT_ELEMENT:
      {
        EObjectElement eObjectElement = (EObjectElement)theEObject;
        T result = caseEObjectElement(eObjectElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG305577_1:
      {
        TypeBug305577_1 typeBug305577_1 = (TypeBug305577_1)theEObject;
        T result = caseTypeBug305577_1(typeBug305577_1);
        if (result == null) result = caseExpression(typeBug305577_1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG305577_2:
      {
        TypeBug305577_2 typeBug305577_2 = (TypeBug305577_2)theEObject;
        T result = caseTypeBug305577_2(typeBug305577_2);
        if (result == null) result = caseExpression(typeBug305577_2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG1_A:
      {
        TypeBug1A typeBug1A = (TypeBug1A)theEObject;
        T result = caseTypeBug1A(typeBug1A);
        if (result == null) result = caseTypeBug305577_1(typeBug1A);
        if (result == null) result = caseExpression(typeBug1A);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG1_B:
      {
        TypeBug1B typeBug1B = (TypeBug1B)theEObject;
        T result = caseTypeBug1B(typeBug1B);
        if (result == null) result = caseTypeBug1A(typeBug1B);
        if (result == null) result = caseTypeBug305577_1(typeBug1B);
        if (result == null) result = caseExpression(typeBug1B);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG2_A:
      {
        TypeBug2A typeBug2A = (TypeBug2A)theEObject;
        T result = caseTypeBug2A(typeBug2A);
        if (result == null) result = caseTypeBug305577_2(typeBug2A);
        if (result == null) result = caseExpression(typeBug2A);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.TYPE_BUG2_B:
      {
        TypeBug2B typeBug2B = (TypeBug2B)theEObject;
        T result = caseTypeBug2B(typeBug2B);
        if (result == null) result = caseTypeBug2A(typeBug2B);
        if (result == null) result = caseTypeBug305577_2(typeBug2B);
        if (result == null) result = caseExpression(typeBug2B);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.BUG305171:
      {
        Bug305171 bug305171 = (Bug305171)theEObject;
        T result = caseBug305171(bug305171);
        if (result == null) result = caseExpression(bug305171);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.BUG310435_ENUM:
      {
        Bug310435Enum bug310435Enum = (Bug310435Enum)theEObject;
        T result = caseBug310435Enum(bug310435Enum);
        if (result == null) result = caseExpression(bug310435Enum);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.BUG310435_VAL:
      {
        Bug310435Val bug310435Val = (Bug310435Val)theEObject;
        T result = caseBug310435Val(bug310435Val);
        if (result == null) result = caseExpression(bug310435Val);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.CROSS_REF_NAME_TEST:
      {
        CrossRefNameTest crossRefNameTest = (CrossRefNameTest)theEObject;
        T result = caseCrossRefNameTest(crossRefNameTest);
        if (result == null) result = caseExpression(crossRefNameTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.CROSS_REF_NAMED:
      {
        CrossRefNamed crossRefNamed = (CrossRefNamed)theEObject;
        T result = caseCrossRefNamed(crossRefNamed);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SimplerewritetestPackage.OP:
      {
        Op op = (Op)theEObject;
        T result = caseOp(op);
        if (result == null) result = caseExpression(op);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Atom</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Atom</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAtom(Atom object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Two Numbers</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Two Numbers</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTwoNumbers(TwoNumbers object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Many Strings</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Many Strings</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseManyStrings(ManyStrings object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRef2(Ref2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Spare</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Spare</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpare(Spare object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolean(org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Boolean object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transient1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transient1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransient1(Transient1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Consumed1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Consumed1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConsumed1(Consumed1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Consumed2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Consumed2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConsumed2(Consumed2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop1(Loop1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop2(Loop2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop3(Loop3 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoop4(Loop4 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Loop Bug285452</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Loop Bug285452</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLoopBug285452(LoopBug285452 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Duplicate Bug284491</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Duplicate Bug284491</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDuplicateBug284491(DuplicateBug284491 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Object Bug284850</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Object Bug284850</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyObjectBug284850(EmptyObjectBug284850 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Object Items</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Object Items</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyObjectItems(EmptyObjectItems object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Empty Object Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Empty Object Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEmptyObjectItem(EmptyObjectItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Inheritance Bug280439</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Inheritance Bug280439</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiInheritanceBug280439(MultiInheritanceBug280439 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Multi1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Multi1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractMulti1(AbstractMulti1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Multi2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Multi2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractMulti2(AbstractMulti2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concrete Multi</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concrete Multi</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcreteMulti(ConcreteMulti object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEObjectRef(EObjectRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEObjectElement(EObjectElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug305577 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug305577 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug305577_1(TypeBug305577_1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug305577 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug305577 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug305577_2(TypeBug305577_2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug1 A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug1 A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug1A(TypeBug1A object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug1 B</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug1 B</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug1B(TypeBug1B object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug2 A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug2 A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug2A(TypeBug2A object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Bug2 B</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Bug2 B</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeBug2B(TypeBug2B object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug305171</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug305171</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug305171(Bug305171 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug310435 Enum</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug310435 Enum</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug310435Enum(Bug310435Enum object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bug310435 Val</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bug310435 Val</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBug310435Val(Bug310435Val object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cross Ref Name Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cross Ref Name Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCrossRefNameTest(CrossRefNameTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cross Ref Named</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cross Ref Named</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCrossRefNamed(CrossRefNamed object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOp(Op object)
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

} //SimplerewritetestSwitch
