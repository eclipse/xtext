/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XStringLiteral;

import org.eclipse.xtext.xtend2.xtend2.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package
 * @generated
 */
public class Xtend2AdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Xtend2Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xtend2AdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = Xtend2Package.eINSTANCE;
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
	protected Xtend2Switch<Adapter> modelSwitch =
		new Xtend2Switch<Adapter>()
		{
			@Override
			public Adapter caseXtendFile(XtendFile object)
			{
				return createXtendFileAdapter();
			}
			@Override
			public Adapter caseXtendImport(XtendImport object)
			{
				return createXtendImportAdapter();
			}
			@Override
			public Adapter caseXtendFunction(XtendFunction object)
			{
				return createXtendFunctionAdapter();
			}
			@Override
			public Adapter caseXtendClass(XtendClass object)
			{
				return createXtendClassAdapter();
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
			public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object)
			{
				return createJvmAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseJvmIdentifyableElement(JvmIdentifyableElement object)
			{
				return createJvmIdentifyableElementAdapter();
			}
			@Override
			public Adapter caseJvmMember(JvmMember object)
			{
				return createJvmMemberAdapter();
			}
			@Override
			public Adapter caseJvmFeature(JvmFeature object)
			{
				return createJvmFeatureAdapter();
			}
			@Override
			public Adapter caseJvmTypeParameterDeclarator(JvmTypeParameterDeclarator object)
			{
				return createJvmTypeParameterDeclaratorAdapter();
			}
			@Override
			public Adapter caseJvmExecutable(JvmExecutable object)
			{
				return createJvmExecutableAdapter();
			}
			@Override
			public Adapter caseJvmOperation(JvmOperation object)
			{
				return createJvmOperationAdapter();
			}
			@Override
			public Adapter caseJvmType(JvmType object)
			{
				return createJvmTypeAdapter();
			}
			@Override
			public Adapter caseJvmComponentType(JvmComponentType object)
			{
				return createJvmComponentTypeAdapter();
			}
			@Override
			public Adapter caseJvmDeclaredType(JvmDeclaredType object)
			{
				return createJvmDeclaredTypeAdapter();
			}
			@Override
			public Adapter caseJvmGenericType(JvmGenericType object)
			{
				return createJvmGenericTypeAdapter();
			}
			@Override
			public Adapter caseXExpression(XExpression object)
			{
				return createXExpressionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.XtendFile <em>Xtend File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFile
	 * @generated
	 */
	public Adapter createXtendFileAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport <em>Xtend Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendImport
	 * @generated
	 */
	public Adapter createXtendImportAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction <em>Xtend Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction
	 * @generated
	 */
	public Adapter createXtendFunctionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass
	 * @generated
	 */
	public Adapter createXtendClassAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichString
	 * @generated
	 */
	public Adapter createRichStringAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringLiteral
	 * @generated
	 */
	public Adapter createRichStringLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringForLoop
	 * @generated
	 */
	public Adapter createRichStringForLoopAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf
	 * @generated
	 */
	public Adapter createRichStringIfAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringElseIf
	 * @generated
	 */
	public Adapter createRichStringElseIfAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifyableElement <em>Jvm Identifyable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmIdentifyableElement
	 * @generated
	 */
	public Adapter createJvmIdentifyableElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmMember <em>Jvm Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmMember
	 * @generated
	 */
	public Adapter createJvmMemberAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFeature <em>Jvm Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmFeature
	 * @generated
	 */
	public Adapter createJvmFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator <em>Jvm Type Parameter Declarator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
	 * @generated
	 */
	public Adapter createJvmTypeParameterDeclaratorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmExecutable <em>Jvm Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmExecutable
	 * @generated
	 */
	public Adapter createJvmExecutableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmOperation <em>Jvm Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmOperation
	 * @generated
	 */
	public Adapter createJvmOperationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmType <em>Jvm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmType
	 * @generated
	 */
	public Adapter createJvmTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmComponentType <em>Jvm Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmComponentType
	 * @generated
	 */
	public Adapter createJvmComponentTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmDeclaredType
	 * @generated
	 */
	public Adapter createJvmDeclaredTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmGenericType <em>Jvm Generic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.xtext.common.types.JvmGenericType
	 * @generated
	 */
	public Adapter createJvmGenericTypeAdapter()
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
	 * @generated
	 */
	public Adapter createXExpressionAdapter()
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
	 * @generated
	 */
	public Adapter createXForLoopExpressionAdapter()
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

} //Xtend2AdapterFactory
