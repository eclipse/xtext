/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendAnnotationTarget;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFormalParameter;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtendPackageImpl extends EPackageImpl implements XtendPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendAnnotationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringForLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringIfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass richStringElseIfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createExtensionInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendConstructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendTypeDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendAnnotationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendEnumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendEnumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendFormalParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xtendExecutableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anonymousClassEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.xtend.core.xtend.XtendPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XtendPackageImpl()
	{
		super(eNS_URI, XtendFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link XtendPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XtendPackage init()
	{
		if (isInited) return (XtendPackage)EPackage.Registry.INSTANCE.getEPackage(XtendPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredXtendPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		XtendPackageImpl theXtendPackage = registeredXtendPackage instanceof XtendPackageImpl ? (XtendPackageImpl)registeredXtendPackage : new XtendPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		XAnnotationsPackage.eINSTANCE.eClass();
		XbasePackage.eINSTANCE.eClass();
		XtypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXtendPackage.createPackageContents();

		// Initialize created meta-data
		theXtendPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXtendPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XtendPackage.eNS_URI, theXtendPackage);
		return theXtendPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendFile()
	{
		return xtendFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendFile_ImportSection()
	{
		return (EReference)xtendFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendFile_XtendTypes()
	{
		return (EReference)xtendFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendFile_Package()
	{
		return (EAttribute)xtendFileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendClass()
	{
		return xtendClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendClass_Extends()
	{
		return (EReference)xtendClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendClass_Implements()
	{
		return (EReference)xtendClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendClass_TypeParameters()
	{
		return (EReference)xtendClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendAnnotationTarget()
	{
		return xtendAnnotationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendAnnotationTarget_Annotations()
	{
		return (EReference)xtendAnnotationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendMember()
	{
		return xtendMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendMember_AnnotationInfo()
	{
		return (EReference)xtendMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendMember_Modifiers()
	{
		return (EAttribute)xtendMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendMember_DeclaringType()
	{
		return (EReference)xtendMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendFunction()
	{
		return xtendFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendFunction_Name()
	{
		return (EAttribute)xtendFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendFunction_ReturnType()
	{
		return (EReference)xtendFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendFunction_CreateExtensionInfo()
	{
		return (EReference)xtendFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendField()
	{
		return xtendFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendField_Name()
	{
		return (EAttribute)xtendFieldEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendField_Type()
	{
		return (EReference)xtendFieldEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendField_InitialValue()
	{
		return (EReference)xtendFieldEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendParameter()
	{
		return xtendParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendParameter_Name()
	{
		return (EAttribute)xtendParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendParameter_ParameterType()
	{
		return (EReference)xtendParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendParameter_VarArg()
	{
		return (EAttribute)xtendParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendParameter_Extension()
	{
		return (EAttribute)xtendParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRichString()
	{
		return richStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRichStringLiteral()
	{
		return richStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRichStringForLoop()
	{
		return richStringForLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringForLoop_Separator()
	{
		return (EReference)richStringForLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringForLoop_Before()
	{
		return (EReference)richStringForLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringForLoop_After()
	{
		return (EReference)richStringForLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRichStringIf()
	{
		return richStringIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringIf_If()
	{
		return (EReference)richStringIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringIf_Then()
	{
		return (EReference)richStringIfEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringIf_ElseIfs()
	{
		return (EReference)richStringIfEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringIf_Else()
	{
		return (EReference)richStringIfEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRichStringElseIf()
	{
		return richStringElseIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringElseIf_If()
	{
		return (EReference)richStringElseIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRichStringElseIf_Then()
	{
		return (EReference)richStringElseIfEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCreateExtensionInfo()
	{
		return createExtensionInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCreateExtensionInfo_CreateExpression()
	{
		return (EReference)createExtensionInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCreateExtensionInfo_Name()
	{
		return (EAttribute)createExtensionInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendConstructor()
	{
		return xtendConstructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendTypeDeclaration()
	{
		return xtendTypeDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendTypeDeclaration_Name()
	{
		return (EAttribute)xtendTypeDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendTypeDeclaration_Members()
	{
		return (EReference)xtendTypeDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendAnnotationType()
	{
		return xtendAnnotationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendInterface()
	{
		return xtendInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendInterface_Extends()
	{
		return (EReference)xtendInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendInterface_TypeParameters()
	{
		return (EReference)xtendInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendEnum()
	{
		return xtendEnumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendEnumLiteral()
	{
		return xtendEnumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendEnumLiteral_Name()
	{
		return (EAttribute)xtendEnumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendVariableDeclaration()
	{
		return xtendVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendVariableDeclaration_Extension()
	{
		return (EAttribute)xtendVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendFormalParameter()
	{
		return xtendFormalParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getXtendFormalParameter_Extension()
	{
		return (EAttribute)xtendFormalParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXtendExecutable()
	{
		return xtendExecutableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendExecutable_Exceptions()
	{
		return (EReference)xtendExecutableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendExecutable_TypeParameters()
	{
		return (EReference)xtendExecutableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendExecutable_Expression()
	{
		return (EReference)xtendExecutableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getXtendExecutable_Parameters()
	{
		return (EReference)xtendExecutableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnonymousClass()
	{
		return anonymousClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnonymousClass_ConstructorCall()
	{
		return (EReference)anonymousClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XtendFactory getXtendFactory()
	{
		return (XtendFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xtendFileEClass = createEClass(XTEND_FILE);
		createEReference(xtendFileEClass, XTEND_FILE__IMPORT_SECTION);
		createEReference(xtendFileEClass, XTEND_FILE__XTEND_TYPES);
		createEAttribute(xtendFileEClass, XTEND_FILE__PACKAGE);

		xtendClassEClass = createEClass(XTEND_CLASS);
		createEReference(xtendClassEClass, XTEND_CLASS__EXTENDS);
		createEReference(xtendClassEClass, XTEND_CLASS__IMPLEMENTS);
		createEReference(xtendClassEClass, XTEND_CLASS__TYPE_PARAMETERS);

		xtendAnnotationTargetEClass = createEClass(XTEND_ANNOTATION_TARGET);
		createEReference(xtendAnnotationTargetEClass, XTEND_ANNOTATION_TARGET__ANNOTATIONS);

		xtendMemberEClass = createEClass(XTEND_MEMBER);
		createEReference(xtendMemberEClass, XTEND_MEMBER__ANNOTATION_INFO);
		createEAttribute(xtendMemberEClass, XTEND_MEMBER__MODIFIERS);
		createEReference(xtendMemberEClass, XTEND_MEMBER__DECLARING_TYPE);

		xtendFunctionEClass = createEClass(XTEND_FUNCTION);
		createEAttribute(xtendFunctionEClass, XTEND_FUNCTION__NAME);
		createEReference(xtendFunctionEClass, XTEND_FUNCTION__RETURN_TYPE);
		createEReference(xtendFunctionEClass, XTEND_FUNCTION__CREATE_EXTENSION_INFO);

		xtendFieldEClass = createEClass(XTEND_FIELD);
		createEAttribute(xtendFieldEClass, XTEND_FIELD__NAME);
		createEReference(xtendFieldEClass, XTEND_FIELD__TYPE);
		createEReference(xtendFieldEClass, XTEND_FIELD__INITIAL_VALUE);

		xtendParameterEClass = createEClass(XTEND_PARAMETER);
		createEAttribute(xtendParameterEClass, XTEND_PARAMETER__NAME);
		createEReference(xtendParameterEClass, XTEND_PARAMETER__PARAMETER_TYPE);
		createEAttribute(xtendParameterEClass, XTEND_PARAMETER__VAR_ARG);
		createEAttribute(xtendParameterEClass, XTEND_PARAMETER__EXTENSION);

		richStringEClass = createEClass(RICH_STRING);

		richStringLiteralEClass = createEClass(RICH_STRING_LITERAL);

		richStringForLoopEClass = createEClass(RICH_STRING_FOR_LOOP);
		createEReference(richStringForLoopEClass, RICH_STRING_FOR_LOOP__SEPARATOR);
		createEReference(richStringForLoopEClass, RICH_STRING_FOR_LOOP__BEFORE);
		createEReference(richStringForLoopEClass, RICH_STRING_FOR_LOOP__AFTER);

		richStringIfEClass = createEClass(RICH_STRING_IF);
		createEReference(richStringIfEClass, RICH_STRING_IF__IF);
		createEReference(richStringIfEClass, RICH_STRING_IF__THEN);
		createEReference(richStringIfEClass, RICH_STRING_IF__ELSE_IFS);
		createEReference(richStringIfEClass, RICH_STRING_IF__ELSE);

		richStringElseIfEClass = createEClass(RICH_STRING_ELSE_IF);
		createEReference(richStringElseIfEClass, RICH_STRING_ELSE_IF__IF);
		createEReference(richStringElseIfEClass, RICH_STRING_ELSE_IF__THEN);

		createExtensionInfoEClass = createEClass(CREATE_EXTENSION_INFO);
		createEReference(createExtensionInfoEClass, CREATE_EXTENSION_INFO__CREATE_EXPRESSION);
		createEAttribute(createExtensionInfoEClass, CREATE_EXTENSION_INFO__NAME);

		xtendConstructorEClass = createEClass(XTEND_CONSTRUCTOR);

		xtendTypeDeclarationEClass = createEClass(XTEND_TYPE_DECLARATION);
		createEAttribute(xtendTypeDeclarationEClass, XTEND_TYPE_DECLARATION__NAME);
		createEReference(xtendTypeDeclarationEClass, XTEND_TYPE_DECLARATION__MEMBERS);

		xtendAnnotationTypeEClass = createEClass(XTEND_ANNOTATION_TYPE);

		xtendInterfaceEClass = createEClass(XTEND_INTERFACE);
		createEReference(xtendInterfaceEClass, XTEND_INTERFACE__EXTENDS);
		createEReference(xtendInterfaceEClass, XTEND_INTERFACE__TYPE_PARAMETERS);

		xtendEnumEClass = createEClass(XTEND_ENUM);

		xtendEnumLiteralEClass = createEClass(XTEND_ENUM_LITERAL);
		createEAttribute(xtendEnumLiteralEClass, XTEND_ENUM_LITERAL__NAME);

		xtendVariableDeclarationEClass = createEClass(XTEND_VARIABLE_DECLARATION);
		createEAttribute(xtendVariableDeclarationEClass, XTEND_VARIABLE_DECLARATION__EXTENSION);

		xtendFormalParameterEClass = createEClass(XTEND_FORMAL_PARAMETER);
		createEAttribute(xtendFormalParameterEClass, XTEND_FORMAL_PARAMETER__EXTENSION);

		xtendExecutableEClass = createEClass(XTEND_EXECUTABLE);
		createEReference(xtendExecutableEClass, XTEND_EXECUTABLE__EXCEPTIONS);
		createEReference(xtendExecutableEClass, XTEND_EXECUTABLE__TYPE_PARAMETERS);
		createEReference(xtendExecutableEClass, XTEND_EXECUTABLE__EXPRESSION);
		createEReference(xtendExecutableEClass, XTEND_EXECUTABLE__PARAMETERS);

		anonymousClassEClass = createEClass(ANONYMOUS_CLASS);
		createEReference(anonymousClassEClass, ANONYMOUS_CLASS__CONSTRUCTOR_CALL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		XAnnotationsPackage theXAnnotationsPackage = (XAnnotationsPackage)EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xtendClassEClass.getESuperTypes().add(this.getXtendTypeDeclaration());
		xtendMemberEClass.getESuperTypes().add(this.getXtendAnnotationTarget());
		xtendFunctionEClass.getESuperTypes().add(this.getXtendExecutable());
		xtendFieldEClass.getESuperTypes().add(this.getXtendMember());
		xtendParameterEClass.getESuperTypes().add(this.getXtendAnnotationTarget());
		richStringEClass.getESuperTypes().add(theXbasePackage.getXBlockExpression());
		richStringLiteralEClass.getESuperTypes().add(theXbasePackage.getXStringLiteral());
		richStringForLoopEClass.getESuperTypes().add(theXbasePackage.getXForLoopExpression());
		richStringIfEClass.getESuperTypes().add(theXbasePackage.getXExpression());
		xtendConstructorEClass.getESuperTypes().add(this.getXtendExecutable());
		xtendTypeDeclarationEClass.getESuperTypes().add(this.getXtendMember());
		xtendAnnotationTypeEClass.getESuperTypes().add(this.getXtendTypeDeclaration());
		xtendInterfaceEClass.getESuperTypes().add(this.getXtendTypeDeclaration());
		xtendEnumEClass.getESuperTypes().add(this.getXtendTypeDeclaration());
		xtendEnumLiteralEClass.getESuperTypes().add(this.getXtendMember());
		xtendVariableDeclarationEClass.getESuperTypes().add(theXbasePackage.getXVariableDeclaration());
		xtendFormalParameterEClass.getESuperTypes().add(theTypesPackage.getJvmFormalParameter());
		xtendExecutableEClass.getESuperTypes().add(this.getXtendMember());
		anonymousClassEClass.getESuperTypes().add(theXbasePackage.getXExpression());
		anonymousClassEClass.getESuperTypes().add(this.getXtendTypeDeclaration());

		// Initialize classes and features; add operations and parameters
		initEClass(xtendFileEClass, XtendFile.class, "XtendFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendFile_ImportSection(), theXtypePackage.getXImportSection(), null, "importSection", null, 0, 1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendFile_XtendTypes(), this.getXtendTypeDeclaration(), null, "xtendTypes", null, 0, -1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendFile_Package(), ecorePackage.getEString(), "package", null, 0, 1, XtendFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendClassEClass, XtendClass.class, "XtendClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendClass_Extends(), theTypesPackage.getJvmTypeReference(), null, "extends", null, 0, 1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendClass_Implements(), theTypesPackage.getJvmTypeReference(), null, "implements", null, 0, -1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendClass_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, XtendClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendClassEClass, ecorePackage.getEBoolean(), "isAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendClassEClass, ecorePackage.getEBoolean(), "isStrictFloatingPoint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendAnnotationTargetEClass, XtendAnnotationTarget.class, "XtendAnnotationTarget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendAnnotationTarget_Annotations(), theXAnnotationsPackage.getXAnnotation(), null, "annotations", null, 0, -1, XtendAnnotationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendMemberEClass, XtendMember.class, "XtendMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendMember_AnnotationInfo(), this.getXtendAnnotationTarget(), null, "annotationInfo", null, 0, 1, XtendMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendMember_Modifiers(), ecorePackage.getEString(), "modifiers", null, 0, -1, XtendMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendMember_DeclaringType(), this.getXtendTypeDeclaration(), this.getXtendTypeDeclaration_Members(), "declaringType", null, 0, 1, XtendMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendMemberEClass, theTypesPackage.getJvmVisibility(), "getVisibility", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendMemberEClass, theTypesPackage.getJvmVisibility(), "getDeclaredVisibility", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendMemberEClass, ecorePackage.getEBoolean(), "isStatic", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendMemberEClass, ecorePackage.getEBoolean(), "isFinal", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendFunctionEClass, XtendFunction.class, "XtendFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendFunction_ReturnType(), theTypesPackage.getJvmTypeReference(), null, "returnType", null, 0, 1, XtendFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendFunction_CreateExtensionInfo(), this.getCreateExtensionInfo(), null, "createExtensionInfo", null, 0, 1, XtendFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isOverride", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isDispatch", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isStrictFloatingPoint", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isNative", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFunctionEClass, ecorePackage.getEBoolean(), "isSynchonized", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendFieldEClass, XtendField.class, "XtendField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendField_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendField_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XtendField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendField_InitialValue(), theXbasePackage.getXExpression(), null, "initialValue", null, 0, 1, XtendField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendFieldEClass, ecorePackage.getEBoolean(), "isExtension", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFieldEClass, ecorePackage.getEBoolean(), "isVolatile", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendFieldEClass, ecorePackage.getEBoolean(), "isTransient", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendParameterEClass, XtendParameter.class, "XtendParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendParameter_ParameterType(), theTypesPackage.getJvmTypeReference(), null, "parameterType", null, 0, 1, XtendParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendParameter_VarArg(), ecorePackage.getEBoolean(), "varArg", null, 0, 1, XtendParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXtendParameter_Extension(), ecorePackage.getEBoolean(), "extension", null, 0, 1, XtendParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(richStringEClass, RichString.class, "RichString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(richStringLiteralEClass, RichStringLiteral.class, "RichStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(richStringForLoopEClass, RichStringForLoop.class, "RichStringForLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRichStringForLoop_Separator(), theXbasePackage.getXExpression(), null, "separator", null, 0, 1, RichStringForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringForLoop_Before(), theXbasePackage.getXExpression(), null, "before", null, 0, 1, RichStringForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringForLoop_After(), theXbasePackage.getXExpression(), null, "after", null, 0, 1, RichStringForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(richStringIfEClass, RichStringIf.class, "RichStringIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRichStringIf_If(), theXbasePackage.getXExpression(), null, "if", null, 0, 1, RichStringIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringIf_Then(), theXbasePackage.getXExpression(), null, "then", null, 0, 1, RichStringIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringIf_ElseIfs(), this.getRichStringElseIf(), null, "elseIfs", null, 0, -1, RichStringIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringIf_Else(), theXbasePackage.getXExpression(), null, "else", null, 0, 1, RichStringIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(richStringElseIfEClass, RichStringElseIf.class, "RichStringElseIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRichStringElseIf_If(), theXbasePackage.getXExpression(), null, "if", null, 0, 1, RichStringElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRichStringElseIf_Then(), theXbasePackage.getXExpression(), null, "then", null, 0, 1, RichStringElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createExtensionInfoEClass, CreateExtensionInfo.class, "CreateExtensionInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateExtensionInfo_CreateExpression(), theXbasePackage.getXExpression(), null, "createExpression", null, 0, 1, CreateExtensionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCreateExtensionInfo_Name(), ecorePackage.getEString(), "name", "it", 0, 1, CreateExtensionInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendConstructorEClass, XtendConstructor.class, "XtendConstructor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xtendTypeDeclarationEClass, XtendTypeDeclaration.class, "XtendTypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendTypeDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendTypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendTypeDeclaration_Members(), this.getXtendMember(), this.getXtendMember_DeclaringType(), "members", null, 0, -1, XtendTypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendTypeDeclarationEClass, ecorePackage.getEBoolean(), "isAnonymous", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xtendTypeDeclarationEClass, ecorePackage.getEBoolean(), "isLocal", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendAnnotationTypeEClass, XtendAnnotationType.class, "XtendAnnotationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xtendInterfaceEClass, XtendInterface.class, "XtendInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendInterface_Extends(), theTypesPackage.getJvmTypeReference(), null, "extends", null, 0, -1, XtendInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendInterface_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, XtendInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(xtendInterfaceEClass, ecorePackage.getEBoolean(), "isStrictFloatingPoint", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xtendEnumEClass, XtendEnum.class, "XtendEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xtendEnumLiteralEClass, XtendEnumLiteral.class, "XtendEnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendEnumLiteral_Name(), ecorePackage.getEString(), "name", null, 0, 1, XtendEnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendVariableDeclarationEClass, XtendVariableDeclaration.class, "XtendVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendVariableDeclaration_Extension(), ecorePackage.getEBoolean(), "extension", null, 0, 1, XtendVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendFormalParameterEClass, XtendFormalParameter.class, "XtendFormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXtendFormalParameter_Extension(), ecorePackage.getEBoolean(), "extension", null, 0, 1, XtendFormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xtendExecutableEClass, XtendExecutable.class, "XtendExecutable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXtendExecutable_Exceptions(), theTypesPackage.getJvmTypeReference(), null, "exceptions", null, 0, -1, XtendExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendExecutable_TypeParameters(), theTypesPackage.getJvmTypeParameter(), null, "typeParameters", null, 0, -1, XtendExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendExecutable_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, XtendExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXtendExecutable_Parameters(), this.getXtendParameter(), null, "parameters", null, 0, -1, XtendExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anonymousClassEClass, AnonymousClass.class, "AnonymousClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnonymousClass_ConstructorCall(), theXbasePackage.getXConstructorCall(), null, "constructorCall", null, 0, 1, AnonymousClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XtendPackageImpl
