/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtend.core.xtend.XtendPackage
 * @generated
 */
public class XtendSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtendPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = XtendPackage.eINSTANCE;
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
			case XtendPackage.XTEND_FILE:
			{
				XtendFile xtendFile = (XtendFile)theEObject;
				T result = caseXtendFile(xtendFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_CLASS:
			{
				XtendClass xtendClass = (XtendClass)theEObject;
				T result = caseXtendClass(xtendClass);
				if (result == null) result = caseXtendTypeDeclaration(xtendClass);
				if (result == null) result = caseXtendMember(xtendClass);
				if (result == null) result = caseXtendAnnotationTarget(xtendClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_ANNOTATION_TARGET:
			{
				XtendAnnotationTarget xtendAnnotationTarget = (XtendAnnotationTarget)theEObject;
				T result = caseXtendAnnotationTarget(xtendAnnotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_MEMBER:
			{
				XtendMember xtendMember = (XtendMember)theEObject;
				T result = caseXtendMember(xtendMember);
				if (result == null) result = caseXtendAnnotationTarget(xtendMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_FUNCTION:
			{
				XtendFunction xtendFunction = (XtendFunction)theEObject;
				T result = caseXtendFunction(xtendFunction);
				if (result == null) result = caseXtendExecutable(xtendFunction);
				if (result == null) result = caseXtendMember(xtendFunction);
				if (result == null) result = caseXtendAnnotationTarget(xtendFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_FIELD:
			{
				XtendField xtendField = (XtendField)theEObject;
				T result = caseXtendField(xtendField);
				if (result == null) result = caseXtendMember(xtendField);
				if (result == null) result = caseXtendAnnotationTarget(xtendField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_PARAMETER:
			{
				XtendParameter xtendParameter = (XtendParameter)theEObject;
				T result = caseXtendParameter(xtendParameter);
				if (result == null) result = caseXtendAnnotationTarget(xtendParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.RICH_STRING:
			{
				RichString richString = (RichString)theEObject;
				T result = caseRichString(richString);
				if (result == null) result = caseXBlockExpression(richString);
				if (result == null) result = caseXExpression(richString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.RICH_STRING_LITERAL:
			{
				RichStringLiteral richStringLiteral = (RichStringLiteral)theEObject;
				T result = caseRichStringLiteral(richStringLiteral);
				if (result == null) result = caseXStringLiteral(richStringLiteral);
				if (result == null) result = caseXExpression(richStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.RICH_STRING_FOR_LOOP:
			{
				RichStringForLoop richStringForLoop = (RichStringForLoop)theEObject;
				T result = caseRichStringForLoop(richStringForLoop);
				if (result == null) result = caseXForLoopExpression(richStringForLoop);
				if (result == null) result = caseXExpression(richStringForLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.RICH_STRING_IF:
			{
				RichStringIf richStringIf = (RichStringIf)theEObject;
				T result = caseRichStringIf(richStringIf);
				if (result == null) result = caseXExpression(richStringIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.RICH_STRING_ELSE_IF:
			{
				RichStringElseIf richStringElseIf = (RichStringElseIf)theEObject;
				T result = caseRichStringElseIf(richStringElseIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.CREATE_EXTENSION_INFO:
			{
				CreateExtensionInfo createExtensionInfo = (CreateExtensionInfo)theEObject;
				T result = caseCreateExtensionInfo(createExtensionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_CONSTRUCTOR:
			{
				XtendConstructor xtendConstructor = (XtendConstructor)theEObject;
				T result = caseXtendConstructor(xtendConstructor);
				if (result == null) result = caseXtendExecutable(xtendConstructor);
				if (result == null) result = caseXtendMember(xtendConstructor);
				if (result == null) result = caseXtendAnnotationTarget(xtendConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_TYPE_DECLARATION:
			{
				XtendTypeDeclaration xtendTypeDeclaration = (XtendTypeDeclaration)theEObject;
				T result = caseXtendTypeDeclaration(xtendTypeDeclaration);
				if (result == null) result = caseXtendMember(xtendTypeDeclaration);
				if (result == null) result = caseXtendAnnotationTarget(xtendTypeDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_ANNOTATION_TYPE:
			{
				XtendAnnotationType xtendAnnotationType = (XtendAnnotationType)theEObject;
				T result = caseXtendAnnotationType(xtendAnnotationType);
				if (result == null) result = caseXtendTypeDeclaration(xtendAnnotationType);
				if (result == null) result = caseXtendMember(xtendAnnotationType);
				if (result == null) result = caseXtendAnnotationTarget(xtendAnnotationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_INTERFACE:
			{
				XtendInterface xtendInterface = (XtendInterface)theEObject;
				T result = caseXtendInterface(xtendInterface);
				if (result == null) result = caseXtendTypeDeclaration(xtendInterface);
				if (result == null) result = caseXtendMember(xtendInterface);
				if (result == null) result = caseXtendAnnotationTarget(xtendInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_ENUM:
			{
				XtendEnum xtendEnum = (XtendEnum)theEObject;
				T result = caseXtendEnum(xtendEnum);
				if (result == null) result = caseXtendTypeDeclaration(xtendEnum);
				if (result == null) result = caseXtendMember(xtendEnum);
				if (result == null) result = caseXtendAnnotationTarget(xtendEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_ENUM_LITERAL:
			{
				XtendEnumLiteral xtendEnumLiteral = (XtendEnumLiteral)theEObject;
				T result = caseXtendEnumLiteral(xtendEnumLiteral);
				if (result == null) result = caseXtendMember(xtendEnumLiteral);
				if (result == null) result = caseXtendAnnotationTarget(xtendEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_VARIABLE_DECLARATION:
			{
				XtendVariableDeclaration xtendVariableDeclaration = (XtendVariableDeclaration)theEObject;
				T result = caseXtendVariableDeclaration(xtendVariableDeclaration);
				if (result == null) result = caseXVariableDeclaration(xtendVariableDeclaration);
				if (result == null) result = caseXExpression(xtendVariableDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xtendVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_FORMAL_PARAMETER:
			{
				XtendFormalParameter xtendFormalParameter = (XtendFormalParameter)theEObject;
				T result = caseXtendFormalParameter(xtendFormalParameter);
				if (result == null) result = caseJvmFormalParameter(xtendFormalParameter);
				if (result == null) result = caseJvmAnnotationTarget(xtendFormalParameter);
				if (result == null) result = caseJvmIdentifiableElement(xtendFormalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.XTEND_EXECUTABLE:
			{
				XtendExecutable xtendExecutable = (XtendExecutable)theEObject;
				T result = caseXtendExecutable(xtendExecutable);
				if (result == null) result = caseXtendMember(xtendExecutable);
				if (result == null) result = caseXtendAnnotationTarget(xtendExecutable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtendPackage.ANONYMOUS_CLASS:
			{
				AnonymousClass anonymousClass = (AnonymousClass)theEObject;
				T result = caseAnonymousClass(anonymousClass);
				if (result == null) result = caseXExpression(anonymousClass);
				if (result == null) result = caseXtendTypeDeclaration(anonymousClass);
				if (result == null) result = caseXtendMember(anonymousClass);
				if (result == null) result = caseXtendAnnotationTarget(anonymousClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFile(XtendFile object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendClass(XtendClass object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendAnnotationTarget(XtendAnnotationTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendMember(XtendMember object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFunction(XtendFunction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendField(XtendField object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendParameter(XtendParameter object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichString(RichString object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringLiteral(RichStringLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String For Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringForLoop(RichStringForLoop object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringIf(RichStringIf object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String Else If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String Else If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringElseIf(RichStringElseIf object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Extension Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Extension Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateExtensionInfo(CreateExtensionInfo object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendConstructor(XtendConstructor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendTypeDeclaration(XtendTypeDeclaration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendAnnotationType(XtendAnnotationType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendInterface(XtendInterface object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendEnum(XtendEnum object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendEnumLiteral(XtendEnumLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendVariableDeclaration(XtendVariableDeclaration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFormalParameter(XtendFormalParameter object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendExecutable(XtendExecutable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousClass(AnonymousClass object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 2.7
	 * @generated
	 */
	public T caseXExpression(XExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 2.7
	 * @generated
	 */
	public T caseXBlockExpression(XBlockExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 2.7
	 * @generated
	 */
	public T caseXStringLiteral(XStringLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFor Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFor Loop Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 2.7
	 * @generated
	 */
	public T caseXForLoopExpression(XForLoopExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIdentifiableElement(JvmIdentifiableElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 2.7
	 * @generated
	 */
	public T caseXVariableDeclaration(XVariableDeclaration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationTarget(JvmAnnotationTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Formal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFormalParameter(JvmFormalParameter object)
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

} //XtendSwitch
