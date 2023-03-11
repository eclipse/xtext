/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtend.core.richstring.*;

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
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage
 * @generated
 */
public class ProcessedRichStringSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessedRichStringPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessedRichStringSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ProcessedRichStringPackage.eINSTANCE;
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
			case ProcessedRichStringPackage.PROCESSED_RICH_STRING:
			{
				ProcessedRichString processedRichString = (ProcessedRichString)theEObject;
				T result = caseProcessedRichString(processedRichString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.LINE:
			{
				Line line = (Line)theEObject;
				T result = caseLine(line);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.LINE_PART:
			{
				LinePart linePart = (LinePart)theEObject;
				T result = caseLinePart(linePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.LITERAL:
			{
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseLinePart(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.LINE_BREAK:
			{
				LineBreak lineBreak = (LineBreak)theEObject;
				T result = caseLineBreak(lineBreak);
				if (result == null) result = caseLiteral(lineBreak);
				if (result == null) result = caseLinePart(lineBreak);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.FOR_LOOP_START:
			{
				ForLoopStart forLoopStart = (ForLoopStart)theEObject;
				T result = caseForLoopStart(forLoopStart);
				if (result == null) result = caseLinePart(forLoopStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.FOR_LOOP_END:
			{
				ForLoopEnd forLoopEnd = (ForLoopEnd)theEObject;
				T result = caseForLoopEnd(forLoopEnd);
				if (result == null) result = caseLinePart(forLoopEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.PRINTED_EXPRESSION:
			{
				PrintedExpression printedExpression = (PrintedExpression)theEObject;
				T result = casePrintedExpression(printedExpression);
				if (result == null) result = caseLinePart(printedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.IF_CONDITION_START:
			{
				IfConditionStart ifConditionStart = (IfConditionStart)theEObject;
				T result = caseIfConditionStart(ifConditionStart);
				if (result == null) result = caseLinePart(ifConditionStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.ELSE_IF_CONDITION:
			{
				ElseIfCondition elseIfCondition = (ElseIfCondition)theEObject;
				T result = caseElseIfCondition(elseIfCondition);
				if (result == null) result = caseLinePart(elseIfCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.ELSE_START:
			{
				ElseStart elseStart = (ElseStart)theEObject;
				T result = caseElseStart(elseStart);
				if (result == null) result = caseLinePart(elseStart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessedRichStringPackage.END_IF:
			{
				EndIf endIf = (EndIf)theEObject;
				T result = caseEndIf(endIf);
				if (result == null) result = caseLinePart(endIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processed Rich String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processed Rich String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessedRichString(ProcessedRichString object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLine(Line object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinePart(LinePart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Break</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Break</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineBreak(LineBreak object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Loop Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Loop Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForLoopStart(ForLoopStart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Loop End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Loop End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForLoopEnd(ForLoopEnd object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Printed Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Printed Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrintedExpression(PrintedExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Condition Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Condition Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfConditionStart(IfConditionStart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else If Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else If Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseIfCondition(ElseIfCondition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else Start</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else Start</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseStart(ElseStart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndIf(EndIf object)
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

} //ProcessedRichStringSwitch
