/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XStringLiteral;

import org.eclipse.xtext.xtend2.xtend2.*;

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
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package
 * @generated
 */
public class Xtend2Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Xtend2Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xtend2Switch()
	{
		if (modelPackage == null)
		{
			modelPackage = Xtend2Package.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject)
	{
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject)
	{
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case Xtend2Package.XTEND_FILE:
			{
				XtendFile xtendFile = (XtendFile)theEObject;
				T result = caseXtendFile(xtendFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_IMPORT:
			{
				XtendImport xtendImport = (XtendImport)theEObject;
				T result = caseXtendImport(xtendImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_CLASS:
			{
				XtendClass xtendClass = (XtendClass)theEObject;
				T result = caseXtendClass(xtendClass);
				if (result == null) result = caseXtendAnnotationTarget(xtendClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_ANNOTATION_TARGET:
			{
				XtendAnnotationTarget xtendAnnotationTarget = (XtendAnnotationTarget)theEObject;
				T result = caseXtendAnnotationTarget(xtendAnnotationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_CLASS_SUPER_CALL_REFERABLE:
			{
				XtendClassSuperCallReferable xtendClassSuperCallReferable = (XtendClassSuperCallReferable)theEObject;
				T result = caseXtendClassSuperCallReferable(xtendClassSuperCallReferable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_MEMBER:
			{
				XtendMember xtendMember = (XtendMember)theEObject;
				T result = caseXtendMember(xtendMember);
				if (result == null) result = caseXtendAnnotationTarget(xtendMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_FUNCTION:
			{
				XtendFunction xtendFunction = (XtendFunction)theEObject;
				T result = caseXtendFunction(xtendFunction);
				if (result == null) result = caseXtendMember(xtendFunction);
				if (result == null) result = caseXtendAnnotationTarget(xtendFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_FIELD:
			{
				XtendField xtendField = (XtendField)theEObject;
				T result = caseXtendField(xtendField);
				if (result == null) result = caseXtendMember(xtendField);
				if (result == null) result = caseXtendAnnotationTarget(xtendField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_PARAMETER:
			{
				XtendParameter xtendParameter = (XtendParameter)theEObject;
				T result = caseXtendParameter(xtendParameter);
				if (result == null) result = caseXtendAnnotationTarget(xtendParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.RICH_STRING:
			{
				RichString richString = (RichString)theEObject;
				T result = caseRichString(richString);
				if (result == null) result = caseXBlockExpression(richString);
				if (result == null) result = caseXExpression(richString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.RICH_STRING_LITERAL:
			{
				RichStringLiteral richStringLiteral = (RichStringLiteral)theEObject;
				T result = caseRichStringLiteral(richStringLiteral);
				if (result == null) result = caseXStringLiteral(richStringLiteral);
				if (result == null) result = caseXExpression(richStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.RICH_STRING_FOR_LOOP:
			{
				RichStringForLoop richStringForLoop = (RichStringForLoop)theEObject;
				T result = caseRichStringForLoop(richStringForLoop);
				if (result == null) result = caseXForLoopExpression(richStringForLoop);
				if (result == null) result = caseXExpression(richStringForLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.RICH_STRING_IF:
			{
				RichStringIf richStringIf = (RichStringIf)theEObject;
				T result = caseRichStringIf(richStringIf);
				if (result == null) result = caseXExpression(richStringIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.RICH_STRING_ELSE_IF:
			{
				RichStringElseIf richStringElseIf = (RichStringElseIf)theEObject;
				T result = caseRichStringElseIf(richStringElseIf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.CREATE_EXTENSION_INFO:
			{
				CreateExtensionInfo createExtensionInfo = (CreateExtensionInfo)theEObject;
				T result = caseCreateExtensionInfo(createExtensionInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xtend2Package.XTEND_CONSTRUCTOR:
			{
				XtendConstructor xtendConstructor = (XtendConstructor)theEObject;
				T result = caseXtendConstructor(xtendConstructor);
				if (result == null) result = caseXtendMember(xtendConstructor);
				if (result == null) result = caseXtendAnnotationTarget(xtendConstructor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFile(XtendFile object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendImport(XtendImport object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendClass(XtendClass object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendAnnotationTarget(XtendAnnotationTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Class Super Call Referable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Class Super Call Referable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendClassSuperCallReferable(XtendClassSuperCallReferable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendMember(XtendMember object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendFunction(XtendFunction object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendField(XtendField object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Parameter</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Xtend Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Xtend Constructor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXtendConstructor(XtendConstructor object)
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
	 * @generated
	 */
	public T caseXForLoopExpression(XForLoopExpression object)
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
	public T defaultCase(EObject object)
	{
		return null;
	}

} //Xtend2Switch
