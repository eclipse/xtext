/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtend.core.richstring.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessedRichStringFactoryImpl extends EFactoryImpl implements ProcessedRichStringFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessedRichStringFactory init()
	{
		try
		{
			ProcessedRichStringFactory theProcessedRichStringFactory = (ProcessedRichStringFactory)EPackage.Registry.INSTANCE.getEFactory(ProcessedRichStringPackage.eNS_URI);
			if (theProcessedRichStringFactory != null)
			{
				return theProcessedRichStringFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcessedRichStringFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessedRichStringFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ProcessedRichStringPackage.PROCESSED_RICH_STRING: return createProcessedRichString();
			case ProcessedRichStringPackage.LINE: return createLine();
			case ProcessedRichStringPackage.LINE_PART: return createLinePart();
			case ProcessedRichStringPackage.LITERAL: return createLiteral();
			case ProcessedRichStringPackage.LINE_BREAK: return createLineBreak();
			case ProcessedRichStringPackage.FOR_LOOP_START: return createForLoopStart();
			case ProcessedRichStringPackage.FOR_LOOP_END: return createForLoopEnd();
			case ProcessedRichStringPackage.PRINTED_EXPRESSION: return createPrintedExpression();
			case ProcessedRichStringPackage.IF_CONDITION_START: return createIfConditionStart();
			case ProcessedRichStringPackage.ELSE_IF_CONDITION: return createElseIfCondition();
			case ProcessedRichStringPackage.ELSE_START: return createElseStart();
			case ProcessedRichStringPackage.END_IF: return createEndIf();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessedRichString createProcessedRichString()
	{
		ProcessedRichStringImpl processedRichString = new ProcessedRichStringImpl();
		return processedRichString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Line createLine()
	{
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LinePart createLinePart()
	{
		LinePartImpl linePart = new LinePartImpl();
		return linePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal createLiteral()
	{
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LineBreak createLineBreak()
	{
		LineBreakImpl lineBreak = new LineBreakImpl();
		return lineBreak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForLoopStart createForLoopStart()
	{
		ForLoopStartImpl forLoopStart = new ForLoopStartImpl();
		return forLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForLoopEnd createForLoopEnd()
	{
		ForLoopEndImpl forLoopEnd = new ForLoopEndImpl();
		return forLoopEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrintedExpression createPrintedExpression()
	{
		PrintedExpressionImpl printedExpression = new PrintedExpressionImpl();
		return printedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfConditionStart createIfConditionStart()
	{
		IfConditionStartImpl ifConditionStart = new IfConditionStartImpl();
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElseIfCondition createElseIfCondition()
	{
		ElseIfConditionImpl elseIfCondition = new ElseIfConditionImpl();
		return elseIfCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElseStart createElseStart()
	{
		ElseStartImpl elseStart = new ElseStartImpl();
		return elseStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EndIf createEndIf()
	{
		EndIfImpl endIf = new EndIfImpl();
		return endIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessedRichStringPackage getProcessedRichStringPackage()
	{
		return (ProcessedRichStringPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcessedRichStringPackage getPackage()
	{
		return ProcessedRichStringPackage.eINSTANCE;
	}

} //ProcessedRichStringFactoryImpl
