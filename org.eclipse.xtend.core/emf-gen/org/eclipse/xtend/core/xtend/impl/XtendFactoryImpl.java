/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtend.core.xtend.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtendFactoryImpl extends EFactoryImpl implements XtendFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtendFactory init()
	{
		try
		{
			XtendFactory theXtendFactory = (XtendFactory)EPackage.Registry.INSTANCE.getEFactory(XtendPackage.eNS_URI);
			if (theXtendFactory != null)
			{
				return theXtendFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtendFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtendFactoryImpl()
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
			case XtendPackage.XTEND_FILE: return createXtendFile();
			case XtendPackage.XTEND_CLASS: return createXtendClass();
			case XtendPackage.XTEND_MEMBER: return createXtendMember();
			case XtendPackage.XTEND_FUNCTION: return createXtendFunction();
			case XtendPackage.XTEND_FIELD: return createXtendField();
			case XtendPackage.XTEND_PARAMETER: return createXtendParameter();
			case XtendPackage.RICH_STRING: return createRichString();
			case XtendPackage.RICH_STRING_LITERAL: return createRichStringLiteral();
			case XtendPackage.RICH_STRING_FOR_LOOP: return createRichStringForLoop();
			case XtendPackage.RICH_STRING_IF: return createRichStringIf();
			case XtendPackage.RICH_STRING_ELSE_IF: return createRichStringElseIf();
			case XtendPackage.CREATE_EXTENSION_INFO: return createCreateExtensionInfo();
			case XtendPackage.XTEND_CONSTRUCTOR: return createXtendConstructor();
			case XtendPackage.XTEND_TYPE_DECLARATION: return createXtendTypeDeclaration();
			case XtendPackage.XTEND_ANNOTATION_TYPE: return createXtendAnnotationType();
			case XtendPackage.XTEND_INTERFACE: return createXtendInterface();
			case XtendPackage.XTEND_ENUM: return createXtendEnum();
			case XtendPackage.XTEND_ENUM_LITERAL: return createXtendEnumLiteral();
			case XtendPackage.XTEND_VARIABLE_DECLARATION: return createXtendVariableDeclaration();
			case XtendPackage.XTEND_FORMAL_PARAMETER: return createXtendFormalParameter();
			case XtendPackage.ANONYMOUS_CLASS: return createAnonymousClass();
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
	public XtendFile createXtendFile()
	{
		XtendFileImpl xtendFile = new XtendFileImpl();
		return xtendFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendClass createXtendClass()
	{
		XtendClassImplCustom xtendClass = new XtendClassImplCustom();
		return xtendClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendMember createXtendMember()
	{
		XtendMemberImplCustom xtendMember = new XtendMemberImplCustom();
		return xtendMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendFunction createXtendFunction()
	{
		XtendFunctionImplCustom xtendFunction = new XtendFunctionImplCustom();
		return xtendFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendField createXtendField()
	{
		XtendFieldImplCustom xtendField = new XtendFieldImplCustom();
		return xtendField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendParameter createXtendParameter()
	{
		XtendParameterImpl xtendParameter = new XtendParameterImpl();
		return xtendParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichString createRichString()
	{
		RichStringImpl richString = new RichStringImpl();
		return richString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichStringLiteral createRichStringLiteral()
	{
		RichStringLiteralImpl richStringLiteral = new RichStringLiteralImpl();
		return richStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichStringForLoop createRichStringForLoop()
	{
		RichStringForLoopImpl richStringForLoop = new RichStringForLoopImpl();
		return richStringForLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichStringIf createRichStringIf()
	{
		RichStringIfImpl richStringIf = new RichStringIfImpl();
		return richStringIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RichStringElseIf createRichStringElseIf()
	{
		RichStringElseIfImpl richStringElseIf = new RichStringElseIfImpl();
		return richStringElseIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreateExtensionInfo createCreateExtensionInfo()
	{
		CreateExtensionInfoImpl createExtensionInfo = new CreateExtensionInfoImpl();
		return createExtensionInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendConstructor createXtendConstructor()
	{
		XtendConstructorImpl xtendConstructor = new XtendConstructorImpl();
		return xtendConstructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendTypeDeclaration createXtendTypeDeclaration()
	{
		XtendTypeDeclarationImplCustom xtendTypeDeclaration = new XtendTypeDeclarationImplCustom();
		return xtendTypeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendAnnotationType createXtendAnnotationType()
	{
		XtendAnnotationTypeImplCustom xtendAnnotationType = new XtendAnnotationTypeImplCustom();
		return xtendAnnotationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendInterface createXtendInterface()
	{
		XtendInterfaceImplCustom xtendInterface = new XtendInterfaceImplCustom();
		return xtendInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendEnum createXtendEnum()
	{
		XtendEnumImplCustom xtendEnum = new XtendEnumImplCustom();
		return xtendEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendEnumLiteral createXtendEnumLiteral()
	{
		XtendEnumLiteralImplCustom xtendEnumLiteral = new XtendEnumLiteralImplCustom();
		return xtendEnumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendVariableDeclaration createXtendVariableDeclaration()
	{
		XtendVariableDeclarationImpl xtendVariableDeclaration = new XtendVariableDeclarationImpl();
		return xtendVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendFormalParameter createXtendFormalParameter()
	{
		XtendFormalParameterImpl xtendFormalParameter = new XtendFormalParameterImpl();
		return xtendFormalParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousClass createAnonymousClass()
	{
		AnonymousClassImplCustom anonymousClass = new AnonymousClassImplCustom();
		return anonymousClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendPackage getXtendPackage()
	{
		return (XtendPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XtendPackage getPackage()
	{
		return XtendPackage.eINSTANCE;
	}

} //XtendFactoryImpl
