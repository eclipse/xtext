/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtend.core.richstring.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage
 * @generated
 */
public class ProcessedRichStringAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessedRichStringPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessedRichStringAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ProcessedRichStringPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessedRichStringSwitch<Adapter> modelSwitch =
		new ProcessedRichStringSwitch<Adapter>()
		{
			@Override
			public Adapter caseProcessedRichString(ProcessedRichString object)
			{
				return createProcessedRichStringAdapter();
			}
			@Override
			public Adapter caseLine(Line object)
			{
				return createLineAdapter();
			}
			@Override
			public Adapter caseLinePart(LinePart object)
			{
				return createLinePartAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object)
			{
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseLineBreak(LineBreak object)
			{
				return createLineBreakAdapter();
			}
			@Override
			public Adapter caseForLoopStart(ForLoopStart object)
			{
				return createForLoopStartAdapter();
			}
			@Override
			public Adapter caseForLoopEnd(ForLoopEnd object)
			{
				return createForLoopEndAdapter();
			}
			@Override
			public Adapter casePrintedExpression(PrintedExpression object)
			{
				return createPrintedExpressionAdapter();
			}
			@Override
			public Adapter caseIfConditionStart(IfConditionStart object)
			{
				return createIfConditionStartAdapter();
			}
			@Override
			public Adapter caseElseIfCondition(ElseIfCondition object)
			{
				return createElseIfConditionAdapter();
			}
			@Override
			public Adapter caseElseStart(ElseStart object)
			{
				return createElseStartAdapter();
			}
			@Override
			public Adapter caseEndIf(EndIf object)
			{
				return createEndIfAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.ProcessedRichString <em>Processed Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichString
	 * @generated
	 */
	public Adapter createProcessedRichStringAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.Line
	 * @generated
	 */
	public Adapter createLineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.LinePart <em>Line Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.LinePart
	 * @generated
	 */
	public Adapter createLinePartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.LineBreak <em>Line Break</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.LineBreak
	 * @generated
	 */
	public Adapter createLineBreakAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.ForLoopStart <em>For Loop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.ForLoopStart
	 * @generated
	 */
	public Adapter createForLoopStartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.ForLoopEnd <em>For Loop End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.ForLoopEnd
	 * @generated
	 */
	public Adapter createForLoopEndAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.PrintedExpression <em>Printed Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.PrintedExpression
	 * @generated
	 */
	public Adapter createPrintedExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.IfConditionStart <em>If Condition Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.IfConditionStart
	 * @generated
	 */
	public Adapter createIfConditionStartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.ElseIfCondition <em>Else If Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.ElseIfCondition
	 * @generated
	 */
	public Adapter createElseIfConditionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.ElseStart <em>Else Start</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.ElseStart
	 * @generated
	 */
	public Adapter createElseStartAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.richstring.EndIf <em>End If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.richstring.EndIf
	 * @generated
	 */
	public Adapter createEndIfAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ProcessedRichStringAdapterFactory
