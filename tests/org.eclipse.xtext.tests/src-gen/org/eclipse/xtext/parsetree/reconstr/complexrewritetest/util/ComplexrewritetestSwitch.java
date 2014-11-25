/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.*;

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
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage
 * @generated
 */
public class ComplexrewritetestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ComplexrewritetestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexrewritetestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ComplexrewritetestPackage.eINSTANCE;
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
      case ComplexrewritetestPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseRoot(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.ATOM:
      {
        Atom atom = (Atom)theEObject;
        T result = caseAtom(atom);
        if (result == null) result = caseExpression(atom);
        if (result == null) result = caseRoot(atom);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_B:
      {
        TrickyB trickyB = (TrickyB)theEObject;
        T result = caseTrickyB(trickyB);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_C:
      {
        TrickyC trickyC = (TrickyC)theEObject;
        T result = caseTrickyC(trickyC);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_D:
      {
        TrickyD trickyD = (TrickyD)theEObject;
        T result = caseTrickyD(trickyD);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_E:
      {
        TrickyE trickyE = (TrickyE)theEObject;
        T result = caseTrickyE(trickyE);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_F:
      {
        TrickyF trickyF = (TrickyF)theEObject;
        T result = caseTrickyF(trickyF);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_G:
      {
        TrickyG trickyG = (TrickyG)theEObject;
        T result = caseTrickyG(trickyG);
        if (result == null) result = caseRoot(trickyG);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_G1:
      {
        TrickyG1 trickyG1 = (TrickyG1)theEObject;
        T result = caseTrickyG1(trickyG1);
        if (result == null) result = caseTrickyG2(trickyG1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.TRICKY_G2:
      {
        TrickyG2 trickyG2 = (TrickyG2)theEObject;
        T result = caseTrickyG2(trickyG2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.ADD:
      {
        Add add = (Add)theEObject;
        T result = caseAdd(add);
        if (result == null) result = caseExpression(add);
        if (result == null) result = caseRoot(add);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.MINUS:
      {
        Minus minus = (Minus)theEObject;
        T result = caseMinus(minus);
        if (result == null) result = caseExpression(minus);
        if (result == null) result = caseRoot(minus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.C1:
      {
        C1 c1 = (C1)theEObject;
        T result = caseC1(c1);
        if (result == null) result = caseTrickyC(c1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.C2:
      {
        C2 c2 = (C2)theEObject;
        T result = caseC2(c2);
        if (result == null) result = caseTrickyC(c2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ComplexrewritetestPackage.C3:
      {
        C3 c3 = (C3)theEObject;
        T result = caseC3(c3);
        if (result == null) result = caseTrickyC(c3);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
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
   * Returns the result of interpreting the object as an instance of '<em>Tricky B</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky B</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyB(TrickyB object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky C</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky C</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyC(TrickyC object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky D</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky D</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyD(TrickyD object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky E</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky E</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyE(TrickyE object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky F</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky F</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyF(TrickyF object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky G</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky G</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyG(TrickyG object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky G1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky G1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyG1(TrickyG1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tricky G2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tricky G2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrickyG2(TrickyG2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdd(Add object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMinus(Minus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>C1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>C1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseC1(C1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>C2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>C2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseC2(C2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>C3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>C3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseC3(C3 object)
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

} //ComplexrewritetestSwitch
