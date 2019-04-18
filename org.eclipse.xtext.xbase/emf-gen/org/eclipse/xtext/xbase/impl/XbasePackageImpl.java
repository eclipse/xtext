/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAbstractWhileExpression;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XCollectionLiteral;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;

import org.eclipse.xtext.xbase.annotations.xAnnotations.impl.XAnnotationsPackageImpl;

import org.eclipse.xtext.xtype.XtypePackage;

import org.eclipse.xtext.xtype.impl.XtypePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XbasePackageImpl extends EPackageImpl implements XbasePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xIfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSwitchExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCasePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBlockExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xMemberFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xFeatureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xConstructorCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBooleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xNullLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xNumberLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xStringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCollectionLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xListLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSetLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xClosureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCastedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBinaryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xUnaryOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xPostfixOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xForLoopExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xBasicForLoopExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAbstractWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xDoWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xWhileExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTypeLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xInstanceOfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xThrowExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xTryCatchFinallyExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xCatchClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xReturnExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xSynchronizedExpressionEClass = null;

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
	 * @see org.eclipse.xtext.xbase.XbasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XbasePackageImpl()
	{
		super(eNS_URI, XbaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XbasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XbasePackage init()
	{
		if (isInited) return (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Obtain or create and register package
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XbasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		XAnnotationsPackageImpl theXAnnotationsPackage = (XAnnotationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI) instanceof XAnnotationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XAnnotationsPackage.eNS_URI) : XAnnotationsPackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);

		// Create package meta-data objects
		theXbasePackage.createPackageContents();
		theXAnnotationsPackage.createPackageContents();
		theXtypePackage.createPackageContents();

		// Initialize created meta-data
		theXbasePackage.initializePackageContents();
		theXAnnotationsPackage.initializePackageContents();
		theXtypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXbasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XbasePackage.eNS_URI, theXbasePackage);
		return theXbasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExpression()
	{
		return xExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIfExpression()
	{
		return xIfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_If()
	{
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Then()
	{
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Else()
	{
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXIfExpression_ConditionalExpression()
	{
		return (EAttribute)xIfExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSwitchExpression()
	{
		return xSwitchExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Switch()
	{
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Cases()
	{
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Default()
	{
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_DeclaredParam()
	{
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCasePart()
	{
		return xCasePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Case()
	{
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Then()
	{
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_TypeGuard()
	{
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXCasePart_FallThrough()
	{
		return (EAttribute)xCasePartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBlockExpression()
	{
		return xBlockExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBlockExpression_Expressions()
	{
		return (EReference)xBlockExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXVariableDeclaration()
	{
		return xVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Type()
	{
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclaration_Name()
	{
		return (EAttribute)xVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Right()
	{
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclaration_Writeable()
	{
		return (EAttribute)xVariableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractFeatureCall()
	{
		return xAbstractFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_Feature()
	{
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_TypeArguments()
	{
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_ImplicitReceiver()
	{
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAbstractFeatureCall_InvalidFeatureIssueCode()
	{
		return (EAttribute)xAbstractFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAbstractFeatureCall_ValidFeature()
	{
		return (EAttribute)xAbstractFeatureCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractFeatureCall_ImplicitFirstArgument()
	{
		return (EReference)xAbstractFeatureCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMemberFeatureCall()
	{
		return xMemberFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall_MemberCallTarget()
	{
		return (EReference)xMemberFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMemberFeatureCall_MemberCallArguments()
	{
		return (EReference)xMemberFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_ExplicitOperationCall()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_ExplicitStatic()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_NullSafe()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_TypeLiteral()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_StaticWithDeclaringType()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMemberFeatureCall_PackageFragment()
	{
		return (EAttribute)xMemberFeatureCallEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFeatureCall()
	{
		return xFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFeatureCall_FeatureCallArguments()
	{
		return (EReference)xFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_ExplicitOperationCall()
	{
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_TypeLiteral()
	{
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_PackageFragment()
	{
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXConstructorCall()
	{
		return xConstructorCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Constructor()
	{
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Arguments()
	{
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_TypeArguments()
	{
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_InvalidFeatureIssueCode()
	{
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_ValidFeature()
	{
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_ExplicitConstructorCall()
	{
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXConstructorCall_AnonymousClassConstructorCall()
	{
		return (EAttribute)xConstructorCallEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBooleanLiteral()
	{
		return xBooleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXBooleanLiteral_IsTrue()
	{
		return (EAttribute)xBooleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXNullLiteral()
	{
		return xNullLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXNumberLiteral()
	{
		return xNumberLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXNumberLiteral_Value()
	{
		return (EAttribute)xNumberLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXStringLiteral()
	{
		return xStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXStringLiteral_Value()
	{
		return (EAttribute)xStringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCollectionLiteral()
	{
		return xCollectionLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCollectionLiteral_Elements()
	{
		return (EReference)xCollectionLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXListLiteral()
	{
		return xListLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSetLiteral()
	{
		return xSetLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXClosure()
	{
		return xClosureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_DeclaredFormalParameters()
	{
		return (EReference)xClosureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_Expression()
	{
		return (EReference)xClosureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXClosure_ExplicitSyntax()
	{
		return (EAttribute)xClosureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_ImplicitFormalParameters()
	{
		return (EReference)xClosureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCastedExpression()
	{
		return xCastedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Type()
	{
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Target()
	{
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBinaryOperation()
	{
		return xBinaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_LeftOperand()
	{
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_RightOperand()
	{
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXBinaryOperation_ReassignFirstArgument()
	{
		return (EAttribute)xBinaryOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXUnaryOperation()
	{
		return xUnaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXUnaryOperation_Operand()
	{
		return (EReference)xUnaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXPostfixOperation()
	{
		return xPostfixOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXPostfixOperation_Operand()
	{
		return (EReference)xPostfixOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXForLoopExpression()
	{
		return xForLoopExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_ForExpression()
	{
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_EachExpression()
	{
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXForLoopExpression_DeclaredParam()
	{
		return (EReference)xForLoopExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBasicForLoopExpression()
	{
		return xBasicForLoopExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBasicForLoopExpression_Expression()
	{
		return (EReference)xBasicForLoopExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBasicForLoopExpression_EachExpression()
	{
		return (EReference)xBasicForLoopExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBasicForLoopExpression_InitExpressions()
	{
		return (EReference)xBasicForLoopExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBasicForLoopExpression_UpdateExpressions()
	{
		return (EReference)xBasicForLoopExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAbstractWhileExpression()
	{
		return xAbstractWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileExpression_Predicate()
	{
		return (EReference)xAbstractWhileExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAbstractWhileExpression_Body()
	{
		return (EReference)xAbstractWhileExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXDoWhileExpression()
	{
		return xDoWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXWhileExpression()
	{
		return xWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTypeLiteral()
	{
		return xTypeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTypeLiteral_Type()
	{
		return (EReference)xTypeLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXTypeLiteral_ArrayDimensions()
	{
		return (EAttribute)xTypeLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXInstanceOfExpression()
	{
		return xInstanceOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Type()
	{
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Expression()
	{
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXThrowExpression()
	{
		return xThrowExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXThrowExpression_Expression()
	{
		return (EReference)xThrowExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTryCatchFinallyExpression()
	{
		return xTryCatchFinallyExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_Expression()
	{
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_FinallyExpression()
	{
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_CatchClauses()
	{
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTryCatchFinallyExpression_Resources()
	{
		return (EReference)xTryCatchFinallyExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCatchClause()
	{
		return xCatchClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCatchClause_Expression()
	{
		return (EReference)xCatchClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCatchClause_DeclaredParam()
	{
		return (EReference)xCatchClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAssignment()
	{
		return xAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Assignable()
	{
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Value()
	{
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAssignment_ExplicitStatic()
	{
		return (EAttribute)xAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXAssignment_StaticWithDeclaringType()
	{
		return (EAttribute)xAssignmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXReturnExpression()
	{
		return xReturnExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXReturnExpression_Expression()
	{
		return (EReference)xReturnExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSynchronizedExpression()
	{
		return xSynchronizedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSynchronizedExpression_Param()
	{
		return (EReference)xSynchronizedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSynchronizedExpression_Expression()
	{
		return (EReference)xSynchronizedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactory getXbaseFactory()
	{
		return (XbaseFactory)getEFactoryInstance();
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
		xExpressionEClass = createEClass(XEXPRESSION);

		xIfExpressionEClass = createEClass(XIF_EXPRESSION);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__IF);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__THEN);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__ELSE);
		createEAttribute(xIfExpressionEClass, XIF_EXPRESSION__CONDITIONAL_EXPRESSION);

		xSwitchExpressionEClass = createEClass(XSWITCH_EXPRESSION);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__SWITCH);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__CASES);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__DEFAULT);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__DECLARED_PARAM);

		xCasePartEClass = createEClass(XCASE_PART);
		createEReference(xCasePartEClass, XCASE_PART__CASE);
		createEReference(xCasePartEClass, XCASE_PART__THEN);
		createEReference(xCasePartEClass, XCASE_PART__TYPE_GUARD);
		createEAttribute(xCasePartEClass, XCASE_PART__FALL_THROUGH);

		xBlockExpressionEClass = createEClass(XBLOCK_EXPRESSION);
		createEReference(xBlockExpressionEClass, XBLOCK_EXPRESSION__EXPRESSIONS);

		xVariableDeclarationEClass = createEClass(XVARIABLE_DECLARATION);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__TYPE);
		createEAttribute(xVariableDeclarationEClass, XVARIABLE_DECLARATION__NAME);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__RIGHT);
		createEAttribute(xVariableDeclarationEClass, XVARIABLE_DECLARATION__WRITEABLE);

		xAbstractFeatureCallEClass = createEClass(XABSTRACT_FEATURE_CALL);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__FEATURE);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER);
		createEAttribute(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE);
		createEAttribute(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__VALID_FEATURE);
		createEReference(xAbstractFeatureCallEClass, XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT);

		xMemberFeatureCallEClass = createEClass(XMEMBER_FEATURE_CALL);
		createEReference(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET);
		createEReference(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__EXPLICIT_STATIC);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__NULL_SAFE);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__TYPE_LITERAL);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE);
		createEAttribute(xMemberFeatureCallEClass, XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT);

		xFeatureCallEClass = createEClass(XFEATURE_CALL);
		createEReference(xFeatureCallEClass, XFEATURE_CALL__FEATURE_CALL_ARGUMENTS);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__EXPLICIT_OPERATION_CALL);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__TYPE_LITERAL);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__PACKAGE_FRAGMENT);

		xConstructorCallEClass = createEClass(XCONSTRUCTOR_CALL);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__CONSTRUCTOR);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__ARGUMENTS);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__TYPE_ARGUMENTS);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__VALID_FEATURE);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__EXPLICIT_CONSTRUCTOR_CALL);
		createEAttribute(xConstructorCallEClass, XCONSTRUCTOR_CALL__ANONYMOUS_CLASS_CONSTRUCTOR_CALL);

		xBooleanLiteralEClass = createEClass(XBOOLEAN_LITERAL);
		createEAttribute(xBooleanLiteralEClass, XBOOLEAN_LITERAL__IS_TRUE);

		xNullLiteralEClass = createEClass(XNULL_LITERAL);

		xNumberLiteralEClass = createEClass(XNUMBER_LITERAL);
		createEAttribute(xNumberLiteralEClass, XNUMBER_LITERAL__VALUE);

		xStringLiteralEClass = createEClass(XSTRING_LITERAL);
		createEAttribute(xStringLiteralEClass, XSTRING_LITERAL__VALUE);

		xCollectionLiteralEClass = createEClass(XCOLLECTION_LITERAL);
		createEReference(xCollectionLiteralEClass, XCOLLECTION_LITERAL__ELEMENTS);

		xListLiteralEClass = createEClass(XLIST_LITERAL);

		xSetLiteralEClass = createEClass(XSET_LITERAL);

		xClosureEClass = createEClass(XCLOSURE);
		createEReference(xClosureEClass, XCLOSURE__DECLARED_FORMAL_PARAMETERS);
		createEReference(xClosureEClass, XCLOSURE__EXPRESSION);
		createEAttribute(xClosureEClass, XCLOSURE__EXPLICIT_SYNTAX);
		createEReference(xClosureEClass, XCLOSURE__IMPLICIT_FORMAL_PARAMETERS);

		xCastedExpressionEClass = createEClass(XCASTED_EXPRESSION);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TYPE);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TARGET);

		xBinaryOperationEClass = createEClass(XBINARY_OPERATION);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__LEFT_OPERAND);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__RIGHT_OPERAND);
		createEAttribute(xBinaryOperationEClass, XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT);

		xUnaryOperationEClass = createEClass(XUNARY_OPERATION);
		createEReference(xUnaryOperationEClass, XUNARY_OPERATION__OPERAND);

		xPostfixOperationEClass = createEClass(XPOSTFIX_OPERATION);
		createEReference(xPostfixOperationEClass, XPOSTFIX_OPERATION__OPERAND);

		xForLoopExpressionEClass = createEClass(XFOR_LOOP_EXPRESSION);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__FOR_EXPRESSION);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__EACH_EXPRESSION);
		createEReference(xForLoopExpressionEClass, XFOR_LOOP_EXPRESSION__DECLARED_PARAM);

		xBasicForLoopExpressionEClass = createEClass(XBASIC_FOR_LOOP_EXPRESSION);
		createEReference(xBasicForLoopExpressionEClass, XBASIC_FOR_LOOP_EXPRESSION__EXPRESSION);
		createEReference(xBasicForLoopExpressionEClass, XBASIC_FOR_LOOP_EXPRESSION__EACH_EXPRESSION);
		createEReference(xBasicForLoopExpressionEClass, XBASIC_FOR_LOOP_EXPRESSION__INIT_EXPRESSIONS);
		createEReference(xBasicForLoopExpressionEClass, XBASIC_FOR_LOOP_EXPRESSION__UPDATE_EXPRESSIONS);

		xAbstractWhileExpressionEClass = createEClass(XABSTRACT_WHILE_EXPRESSION);
		createEReference(xAbstractWhileExpressionEClass, XABSTRACT_WHILE_EXPRESSION__PREDICATE);
		createEReference(xAbstractWhileExpressionEClass, XABSTRACT_WHILE_EXPRESSION__BODY);

		xDoWhileExpressionEClass = createEClass(XDO_WHILE_EXPRESSION);

		xWhileExpressionEClass = createEClass(XWHILE_EXPRESSION);

		xTypeLiteralEClass = createEClass(XTYPE_LITERAL);
		createEReference(xTypeLiteralEClass, XTYPE_LITERAL__TYPE);
		createEAttribute(xTypeLiteralEClass, XTYPE_LITERAL__ARRAY_DIMENSIONS);

		xInstanceOfExpressionEClass = createEClass(XINSTANCE_OF_EXPRESSION);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__TYPE);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__EXPRESSION);

		xThrowExpressionEClass = createEClass(XTHROW_EXPRESSION);
		createEReference(xThrowExpressionEClass, XTHROW_EXPRESSION__EXPRESSION);

		xTryCatchFinallyExpressionEClass = createEClass(XTRY_CATCH_FINALLY_EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES);
		createEReference(xTryCatchFinallyExpressionEClass, XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES);

		xCatchClauseEClass = createEClass(XCATCH_CLAUSE);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__EXPRESSION);
		createEReference(xCatchClauseEClass, XCATCH_CLAUSE__DECLARED_PARAM);

		xAssignmentEClass = createEClass(XASSIGNMENT);
		createEReference(xAssignmentEClass, XASSIGNMENT__ASSIGNABLE);
		createEReference(xAssignmentEClass, XASSIGNMENT__VALUE);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__EXPLICIT_STATIC);
		createEAttribute(xAssignmentEClass, XASSIGNMENT__STATIC_WITH_DECLARING_TYPE);

		xReturnExpressionEClass = createEClass(XRETURN_EXPRESSION);
		createEReference(xReturnExpressionEClass, XRETURN_EXPRESSION__EXPRESSION);

		xSynchronizedExpressionEClass = createEClass(XSYNCHRONIZED_EXPRESSION);
		createEReference(xSynchronizedExpressionEClass, XSYNCHRONIZED_EXPRESSION__PARAM);
		createEReference(xSynchronizedExpressionEClass, XSYNCHRONIZED_EXPRESSION__EXPRESSION);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xIfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xSwitchExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBlockExpressionEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(theTypesPackage.getJvmIdentifiableElement());
		xAbstractFeatureCallEClass.getESuperTypes().add(this.getXExpression());
		xMemberFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xFeatureCallEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xConstructorCallEClass.getESuperTypes().add(this.getXExpression());
		xBooleanLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNullLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNumberLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStringLiteralEClass.getESuperTypes().add(this.getXExpression());
		xCollectionLiteralEClass.getESuperTypes().add(this.getXExpression());
		xListLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xSetLiteralEClass.getESuperTypes().add(this.getXCollectionLiteral());
		xClosureEClass.getESuperTypes().add(this.getXExpression());
		xCastedExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBinaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xUnaryOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xPostfixOperationEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xForLoopExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBasicForLoopExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAbstractWhileExpressionEClass.getESuperTypes().add(this.getXExpression());
		xDoWhileExpressionEClass.getESuperTypes().add(this.getXAbstractWhileExpression());
		xWhileExpressionEClass.getESuperTypes().add(this.getXAbstractWhileExpression());
		xTypeLiteralEClass.getESuperTypes().add(this.getXExpression());
		xInstanceOfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xThrowExpressionEClass.getESuperTypes().add(this.getXExpression());
		xTryCatchFinallyExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAssignmentEClass.getESuperTypes().add(this.getXAbstractFeatureCall());
		xReturnExpressionEClass.getESuperTypes().add(this.getXExpression());
		xSynchronizedExpressionEClass.getESuperTypes().add(this.getXExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(xExpressionEClass, XExpression.class, "XExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xIfExpressionEClass, XIfExpression.class, "XIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIfExpression_If(), this.getXExpression(), null, "if", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Then(), this.getXExpression(), null, "then", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Else(), this.getXExpression(), null, "else", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXIfExpression_ConditionalExpression(), ecorePackage.getEBoolean(), "conditionalExpression", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSwitchExpressionEClass, XSwitchExpression.class, "XSwitchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSwitchExpression_Switch(), this.getXExpression(), null, "switch", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Cases(), this.getXCasePart(), null, "cases", null, 0, -1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Default(), this.getXExpression(), null, "default", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCasePartEClass, XCasePart.class, "XCasePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCasePart_Case(), this.getXExpression(), null, "case", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_Then(), this.getXExpression(), null, "then", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_TypeGuard(), theTypesPackage.getJvmTypeReference(), null, "typeGuard", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXCasePart_FallThrough(), ecorePackage.getEBoolean(), "fallThrough", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBlockExpressionEClass, XBlockExpression.class, "XBlockExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBlockExpression_Expressions(), this.getXExpression(), null, "expressions", null, 0, -1, XBlockExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xVariableDeclarationEClass, XVariableDeclaration.class, "XVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclaration_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXVariableDeclaration_Right(), this.getXExpression(), null, "right", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclaration_Writeable(), ecorePackage.getEBoolean(), "writeable", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractFeatureCallEClass, XAbstractFeatureCall.class, "XAbstractFeatureCall", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractFeatureCall_Feature(), theTypesPackage.getJvmIdentifiableElement(), null, "feature", null, 0, 1, XAbstractFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, XAbstractFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_ImplicitReceiver(), this.getXExpression(), null, "implicitReceiver", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAbstractFeatureCall_InvalidFeatureIssueCode(), ecorePackage.getEString(), "invalidFeatureIssueCode", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAbstractFeatureCall_ValidFeature(), ecorePackage.getEBoolean(), "validFeature", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractFeatureCall_ImplicitFirstArgument(), this.getXExpression(), null, "implicitFirstArgument", null, 0, 1, XAbstractFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEString(), "getConcreteSyntaxFeatureName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getExplicitArguments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isExplicitOperationCallOrBuilderSyntax", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getActualReceiver", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, this.getXExpression(), "getActualArguments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isStatic", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isExtension", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isPackageFragment", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isTypeLiteral", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(xAbstractFeatureCallEClass, ecorePackage.getEBoolean(), "isOperation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(xMemberFeatureCallEClass, XMemberFeatureCall.class, "XMemberFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXMemberFeatureCall_MemberCallTarget(), this.getXExpression(), null, "memberCallTarget", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMemberFeatureCall_MemberCallArguments(), this.getXExpression(), null, "memberCallArguments", null, 0, -1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_ExplicitOperationCall(), ecorePackage.getEBoolean(), "explicitOperationCall", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_NullSafe(), ecorePackage.getEBoolean(), "nullSafe", null, 0, 1, XMemberFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_TypeLiteral(), ecorePackage.getEBoolean(), "typeLiteral", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_StaticWithDeclaringType(), ecorePackage.getEBoolean(), "staticWithDeclaringType", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMemberFeatureCall_PackageFragment(), ecorePackage.getEBoolean(), "packageFragment", null, 0, 1, XMemberFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(xFeatureCallEClass, XFeatureCall.class, "XFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFeatureCall_FeatureCallArguments(), this.getXExpression(), null, "featureCallArguments", null, 0, -1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_ExplicitOperationCall(), ecorePackage.getEBoolean(), "explicitOperationCall", null, 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_TypeLiteral(), ecorePackage.getEBoolean(), "typeLiteral", null, 0, 1, XFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_PackageFragment(), ecorePackage.getEBoolean(), "packageFragment", null, 0, 1, XFeatureCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(xConstructorCallEClass, XConstructorCall.class, "XConstructorCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXConstructorCall_Constructor(), theTypesPackage.getJvmConstructor(), null, "constructor", null, 0, 1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_Arguments(), this.getXExpression(), null, "arguments", null, 0, -1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_TypeArguments(), theTypesPackage.getJvmTypeReference(), null, "typeArguments", null, 0, -1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_InvalidFeatureIssueCode(), ecorePackage.getEString(), "invalidFeatureIssueCode", null, 0, 1, XConstructorCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_ValidFeature(), ecorePackage.getEBoolean(), "validFeature", null, 0, 1, XConstructorCall.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_ExplicitConstructorCall(), ecorePackage.getEBoolean(), "explicitConstructorCall", null, 0, 1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXConstructorCall_AnonymousClassConstructorCall(), ecorePackage.getEBoolean(), "anonymousClassConstructorCall", null, 0, 1, XConstructorCall.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBooleanLiteralEClass, XBooleanLiteral.class, "XBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXBooleanLiteral_IsTrue(), ecorePackage.getEBoolean(), "isTrue", null, 0, 1, XBooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xNullLiteralEClass, XNullLiteral.class, "XNullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xNumberLiteralEClass, XNumberLiteral.class, "XNumberLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXNumberLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XNumberLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xStringLiteralEClass, XStringLiteral.class, "XStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCollectionLiteralEClass, XCollectionLiteral.class, "XCollectionLiteral", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCollectionLiteral_Elements(), this.getXExpression(), null, "elements", null, 0, -1, XCollectionLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xListLiteralEClass, XListLiteral.class, "XListLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xSetLiteralEClass, XSetLiteral.class, "XSetLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xClosureEClass, XClosure.class, "XClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXClosure_DeclaredFormalParameters(), theTypesPackage.getJvmFormalParameter(), null, "declaredFormalParameters", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXClosure_ExplicitSyntax(), ecorePackage.getEBoolean(), "explicitSyntax", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_ImplicitFormalParameters(), theTypesPackage.getJvmFormalParameter(), null, "implicitFormalParameters", null, 0, -1, XClosure.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(xClosureEClass, theTypesPackage.getJvmFormalParameter(), "getFormalParameters", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(xCastedExpressionEClass, XCastedExpression.class, "XCastedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCastedExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCastedExpression_Target(), this.getXExpression(), null, "target", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBinaryOperationEClass, XBinaryOperation.class, "XBinaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBinaryOperation_LeftOperand(), this.getXExpression(), null, "leftOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBinaryOperation_RightOperand(), this.getXExpression(), null, "rightOperand", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXBinaryOperation_ReassignFirstArgument(), ecorePackage.getEBoolean(), "reassignFirstArgument", null, 0, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xUnaryOperationEClass, XUnaryOperation.class, "XUnaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXUnaryOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xPostfixOperationEClass, XPostfixOperation.class, "XPostfixOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXPostfixOperation_Operand(), this.getXExpression(), null, "operand", null, 0, 1, XPostfixOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xForLoopExpressionEClass, XForLoopExpression.class, "XForLoopExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXForLoopExpression_ForExpression(), this.getXExpression(), null, "forExpression", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopExpression_EachExpression(), this.getXExpression(), null, "eachExpression", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXForLoopExpression_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBasicForLoopExpressionEClass, XBasicForLoopExpression.class, "XBasicForLoopExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBasicForLoopExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XBasicForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBasicForLoopExpression_EachExpression(), this.getXExpression(), null, "eachExpression", null, 0, 1, XBasicForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBasicForLoopExpression_InitExpressions(), this.getXExpression(), null, "initExpressions", null, 0, -1, XBasicForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBasicForLoopExpression_UpdateExpressions(), this.getXExpression(), null, "updateExpressions", null, 0, -1, XBasicForLoopExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAbstractWhileExpressionEClass, XAbstractWhileExpression.class, "XAbstractWhileExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAbstractWhileExpression_Predicate(), this.getXExpression(), null, "predicate", null, 0, 1, XAbstractWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAbstractWhileExpression_Body(), this.getXExpression(), null, "body", null, 0, 1, XAbstractWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xDoWhileExpressionEClass, XDoWhileExpression.class, "XDoWhileExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xWhileExpressionEClass, XWhileExpression.class, "XWhileExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xTypeLiteralEClass, XTypeLiteral.class, "XTypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTypeLiteral_Type(), theTypesPackage.getJvmType(), null, "type", null, 1, 1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXTypeLiteral_ArrayDimensions(), ecorePackage.getEString(), "arrayDimensions", null, 0, -1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xInstanceOfExpressionEClass, XInstanceOfExpression.class, "XInstanceOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXInstanceOfExpression_Type(), theTypesPackage.getJvmTypeReference(), null, "type", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXInstanceOfExpression_Expression(), this.getXExpression(), null, "expression", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xThrowExpressionEClass, XThrowExpression.class, "XThrowExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXThrowExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XThrowExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTryCatchFinallyExpressionEClass, XTryCatchFinallyExpression.class, "XTryCatchFinallyExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTryCatchFinallyExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyExpression_FinallyExpression(), this.getXExpression(), null, "finallyExpression", null, 0, 1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyExpression_CatchClauses(), this.getXCatchClause(), null, "catchClauses", null, 0, -1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXTryCatchFinallyExpression_Resources(), this.getXVariableDeclaration(), null, "resources", null, 0, -1, XTryCatchFinallyExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCatchClauseEClass, XCatchClause.class, "XCatchClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCatchClause_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCatchClause_DeclaredParam(), theTypesPackage.getJvmFormalParameter(), null, "declaredParam", null, 0, 1, XCatchClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAssignmentEClass, XAssignment.class, "XAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAssignment_Assignable(), this.getXExpression(), null, "assignable", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Value(), this.getXExpression(), null, "value", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_ExplicitStatic(), ecorePackage.getEBoolean(), "explicitStatic", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXAssignment_StaticWithDeclaringType(), ecorePackage.getEBoolean(), "staticWithDeclaringType", null, 0, 1, XAssignment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(xReturnExpressionEClass, XReturnExpression.class, "XReturnExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXReturnExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XReturnExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSynchronizedExpressionEClass, XSynchronizedExpression.class, "XSynchronizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSynchronizedExpression_Param(), this.getXExpression(), null, "param", null, 0, 1, XSynchronizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSynchronizedExpression_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XSynchronizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XbasePackageImpl
