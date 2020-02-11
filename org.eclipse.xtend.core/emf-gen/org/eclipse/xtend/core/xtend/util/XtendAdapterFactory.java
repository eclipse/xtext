/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtend.core.xtend.*;

import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.core.xtend.XtendPackage
 * @generated
 */
public class XtendAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtendPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = XtendPackage.eINSTANCE;
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
	protected XtendSwitch<Adapter> modelSwitch =
		new XtendSwitch<Adapter>()
		{
			@Override
			public Adapter caseXtendFile(XtendFile object)
			{
				return createXtendFileAdapter();
			}
			@Override
			public Adapter caseXtendClass(XtendClass object)
			{
				return createXtendClassAdapter();
			}
			@Override
			public Adapter caseXtendAnnotationTarget(XtendAnnotationTarget object)
			{
				return createXtendAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseXtendMember(XtendMember object)
			{
				return createXtendMemberAdapter();
			}
			@Override
			public Adapter caseXtendFunction(XtendFunction object)
			{
				return createXtendFunctionAdapter();
			}
			@Override
			public Adapter caseXtendField(XtendField object)
			{
				return createXtendFieldAdapter();
			}
			@Override
			public Adapter caseXtendParameter(XtendParameter object)
			{
				return createXtendParameterAdapter();
			}
			@Override
			public Adapter caseRichString(RichString object)
			{
				return createRichStringAdapter();
			}
			@Override
			public Adapter caseRichStringLiteral(RichStringLiteral object)
			{
				return createRichStringLiteralAdapter();
			}
			@Override
			public Adapter caseRichStringForLoop(RichStringForLoop object)
			{
				return createRichStringForLoopAdapter();
			}
			@Override
			public Adapter caseRichStringIf(RichStringIf object)
			{
				return createRichStringIfAdapter();
			}
			@Override
			public Adapter caseRichStringElseIf(RichStringElseIf object)
			{
				return createRichStringElseIfAdapter();
			}
			@Override
			public Adapter caseCreateExtensionInfo(CreateExtensionInfo object)
			{
				return createCreateExtensionInfoAdapter();
			}
			@Override
			public Adapter caseXtendConstructor(XtendConstructor object)
			{
				return createXtendConstructorAdapter();
			}
			@Override
			public Adapter caseXtendTypeDeclaration(XtendTypeDeclaration object)
			{
				return createXtendTypeDeclarationAdapter();
			}
			@Override
			public Adapter caseXtendAnnotationType(XtendAnnotationType object)
			{
				return createXtendAnnotationTypeAdapter();
			}
			@Override
			public Adapter caseXtendInterface(XtendInterface object)
			{
				return createXtendInterfaceAdapter();
			}
			@Override
			public Adapter caseXtendEnum(XtendEnum object)
			{
				return createXtendEnumAdapter();
			}
			@Override
			public Adapter caseXtendEnumLiteral(XtendEnumLiteral object)
			{
				return createXtendEnumLiteralAdapter();
			}
			@Override
			public Adapter caseXtendVariableDeclaration(XtendVariableDeclaration object)
			{
				return createXtendVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseXtendFormalParameter(XtendFormalParameter object)
			{
				return createXtendFormalParameterAdapter();
			}
			@Override
			public Adapter caseXtendExecutable(XtendExecutable object)
			{
				return createXtendExecutableAdapter();
			}
			@Override
			public Adapter caseAnonymousClass(AnonymousClass object)
			{
				return createAnonymousClassAdapter();
			}
			@Override
			public Adapter caseXExpression(XExpression object)
			{
				return createXExpressionAdapter();
			}
			@Override
			public Adapter caseXBlockExpression(XBlockExpression object)
			{
				return createXBlockExpressionAdapter();
			}
			@Override
			public Adapter caseXStringLiteral(XStringLiteral object)
			{
				return createXStringLiteralAdapter();
			}
			@Override
			public Adapter caseXForLoopExpression(XForLoopExpression object)
			{
				return createXForLoopExpressionAdapter();
			}
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object)
			{
				return createJvmIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseXVariableDeclaration(XVariableDeclaration object)
			{
				return createXVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object)
			{
				return createJvmAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseJvmFormalParameter(JvmFormalParameter object)
			{
				return createJvmFormalParameterAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendFile
	 * @generated
	 */
	public Adapter createXtendFileAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendClass <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendClass
	 * @generated
	 */
	public Adapter createXtendClassAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendAnnotationTarget <em>Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendAnnotationTarget
	 * @generated
	 */
	public Adapter createXtendAnnotationTargetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendMember <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendMember
	 * @generated
	 */
	public Adapter createXtendMemberAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendFunction
	 * @generated
	 */
	public Adapter createXtendFunctionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendField
	 * @generated
	 */
	public Adapter createXtendFieldAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendParameter
	 * @generated
	 */
	public Adapter createXtendParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.RichString
	 * @generated
	 */
	public Adapter createRichStringAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.RichStringLiteral
	 * @generated
	 */
	public Adapter createRichStringLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.RichStringForLoop
	 * @generated
	 */
	public Adapter createRichStringForLoopAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.RichStringIf
	 * @generated
	 */
	public Adapter createRichStringIfAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.RichStringElseIf
	 * @generated
	 */
	public Adapter createRichStringElseIfAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.CreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.CreateExtensionInfo
	 * @generated
	 */
	public Adapter createCreateExtensionInfoAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendConstructor
	 * @generated
	 */
	public Adapter createXtendConstructorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendTypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendTypeDeclaration
	 * @generated
	 */
	public Adapter createXtendTypeDeclarationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendAnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendAnnotationType
	 * @generated
	 */
	public Adapter createXtendAnnotationTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendInterface
	 * @generated
	 */
	public Adapter createXtendInterfaceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendEnum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendEnum
	 * @generated
	 */
	public Adapter createXtendEnumAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendEnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendEnumLiteral
	 * @generated
	 */
	public Adapter createXtendEnumLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendVariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendVariableDeclaration
	 * @generated
	 */
	public Adapter createXtendVariableDeclarationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendFormalParameter <em>Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendFormalParameter
	 * @generated
	 */
	public Adapter createXtendFormalParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.XtendExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.XtendExecutable
	 * @generated
	 */
	public Adapter createXtendExecutableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtend.core.xtend.AnonymousClass <em>Anonymous Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtend.core.xtend.AnonymousClass
	 * @generated
	 */
	public Adapter createAnonymousClassAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xbase.XExpression
	 * @since 2.7
	 * @generated
	 */
	public Adapter createXExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XBlockExpression <em>XBlock Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xbase.XBlockExpression
	 * @since 2.7
	 * @generated
	 */
	public Adapter createXBlockExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XStringLiteral <em>XString Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xbase.XStringLiteral
	 * @since 2.7
	 * @generated
	 */
	public Adapter createXStringLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XForLoopExpression <em>XFor Loop Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xbase.XForLoopExpression
	 * @since 2.7
	 * @generated
	 */
	public Adapter createXForLoopExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmIdentifiableElement
	 * @generated
	 */
	public Adapter createJvmIdentifiableElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XVariableDeclaration <em>XVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration
	 * @since 2.7
	 * @generated
	 */
	public Adapter createXVariableDeclarationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmAnnotationTarget
	 * @generated
	 */
	public Adapter createJvmAnnotationTargetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFormalParameter <em>Jvm Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmFormalParameter
	 * @generated
	 */
	public Adapter createJvmFormalParameterAdapter()
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

} //XtendAdapterFactory
