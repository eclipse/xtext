/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.serializer.syntacticsequencertest.*;

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
 * @see org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage
 * @generated
 */
public class SyntacticsequencertestSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SyntacticsequencertestPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyntacticsequencertestSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = SyntacticsequencertestPackage.eINSTANCE;
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
      case SyntacticsequencertestPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.MANDATORY_KEYWORDS:
      {
        MandatoryKeywords mandatoryKeywords = (MandatoryKeywords)theEObject;
        T result = caseMandatoryKeywords(mandatoryKeywords);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.EXP0:
      {
        Exp0 exp0 = (Exp0)theEObject;
        T result = caseExp0(exp0);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.EXP1:
      {
        Exp1 exp1 = (Exp1)theEObject;
        T result = caseExp1(exp1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.EXP2:
      {
        Exp2 exp2 = (Exp2)theEObject;
        T result = caseExp2(exp2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE:
      {
        SingleCrossReference singleCrossReference = (SingleCrossReference)theEObject;
        T result = caseSingleCrossReference(singleCrossReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE:
      {
        BooleanAlternative booleanAlternative = (BooleanAlternative)theEObject;
        T result = caseBooleanAlternative(booleanAlternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE_LITERAL:
      {
        BooleanAlternativeLiteral booleanAlternativeLiteral = (BooleanAlternativeLiteral)theEObject;
        T result = caseBooleanAlternativeLiteral(booleanAlternativeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.UNASSIGNED_DATATYPE:
      {
        UnassignedDatatype unassignedDatatype = (UnassignedDatatype)theEObject;
        T result = caseUnassignedDatatype(unassignedDatatype);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.OPTIONAL_SINGLE_TRANSITION:
      {
        OptionalSingleTransition optionalSingleTransition = (OptionalSingleTransition)theEObject;
        T result = caseOptionalSingleTransition(optionalSingleTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.OPTIONAL_MANY_TRANSITION:
      {
        OptionalManyTransition optionalManyTransition = (OptionalManyTransition)theEObject;
        T result = caseOptionalManyTransition(optionalManyTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.MANDATORY_MANY_TRANSITION:
      {
        MandatoryManyTransition mandatoryManyTransition = (MandatoryManyTransition)theEObject;
        T result = caseMandatoryManyTransition(mandatoryManyTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.ALTERNATIVE_TRANSITION:
      {
        AlternativeTransition alternativeTransition = (AlternativeTransition)theEObject;
        T result = caseAlternativeTransition(alternativeTransition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.BOOLEAN_VALUES:
      {
        BooleanValues booleanValues = (BooleanValues)theEObject;
        T result = caseBooleanValues(booleanValues);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.LONG_ALTERNATIVE:
      {
        LongAlternative longAlternative = (LongAlternative)theEObject;
        T result = caseLongAlternative(longAlternative);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.ACTION_ONLY:
      {
        ActionOnly actionOnly = (ActionOnly)theEObject;
        T result = caseActionOnly(actionOnly);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.FRAGMENT_CALLER_TYPE:
      {
        FragmentCallerType fragmentCallerType = (FragmentCallerType)theEObject;
        T result = caseFragmentCallerType(fragmentCallerType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.ADD0:
      {
        Add0 add0 = (Add0)theEObject;
        T result = caseAdd0(add0);
        if (result == null) result = caseExp0(add0);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.VAL0:
      {
        Val0 val0 = (Val0)theEObject;
        T result = caseVal0(val0);
        if (result == null) result = caseExp0(val0);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.ADD1:
      {
        Add1 add1 = (Add1)theEObject;
        T result = caseAdd1(add1);
        if (result == null) result = caseExp1(add1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.VAL1:
      {
        Val1 val1 = (Val1)theEObject;
        T result = caseVal1(val1);
        if (result == null) result = caseExp1(val1);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.ADD2:
      {
        Add2 add2 = (Add2)theEObject;
        T result = caseAdd2(add2);
        if (result == null) result = caseExp2(add2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.MULT2:
      {
        Mult2 mult2 = (Mult2)theEObject;
        T result = caseMult2(mult2);
        if (result == null) result = caseExp2(mult2);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case SyntacticsequencertestPackage.VAL2:
      {
        Val2 val2 = (Val2)theEObject;
        T result = caseVal2(val2);
        if (result == null) result = caseExp2(val2);
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
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Keywords</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Keywords</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryKeywords(MandatoryKeywords object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exp0</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exp0</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExp0(Exp0 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exp1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exp1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExp1(Exp1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exp2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exp2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExp2(Exp2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Cross Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Cross Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleCrossReference(SingleCrossReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Alternative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Alternative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanAlternative(BooleanAlternative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Alternative Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Alternative Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanAlternativeLiteral(BooleanAlternativeLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unassigned Datatype</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unassigned Datatype</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnassignedDatatype(UnassignedDatatype object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Single Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Single Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalSingleTransition(OptionalSingleTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Optional Many Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Optional Many Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOptionalManyTransition(OptionalManyTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mandatory Many Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mandatory Many Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMandatoryManyTransition(MandatoryManyTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alternative Transition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alternative Transition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlternativeTransition(AlternativeTransition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Values</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Values</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanValues(BooleanValues object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Long Alternative</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Long Alternative</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLongAlternative(LongAlternative object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action Only</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action Only</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActionOnly(ActionOnly object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fragment Caller Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fragment Caller Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFragmentCallerType(FragmentCallerType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add0</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add0</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdd0(Add0 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Val0</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Val0</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVal0(Val0 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdd1(Add1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Val1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Val1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVal1(Val1 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAdd2(Add2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mult2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mult2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMult2(Mult2 object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Val2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Val2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVal2(Val2 object)
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

} //SyntacticsequencertestSwitch
