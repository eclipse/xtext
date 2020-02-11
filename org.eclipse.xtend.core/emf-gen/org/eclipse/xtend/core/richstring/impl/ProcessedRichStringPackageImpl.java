/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.richstring.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtend.core.richstring.ElseIfCondition;
import org.eclipse.xtend.core.richstring.ElseStart;
import org.eclipse.xtend.core.richstring.EndIf;
import org.eclipse.xtend.core.richstring.ForLoopEnd;
import org.eclipse.xtend.core.richstring.ForLoopStart;
import org.eclipse.xtend.core.richstring.IfConditionStart;
import org.eclipse.xtend.core.richstring.Line;
import org.eclipse.xtend.core.richstring.LineBreak;
import org.eclipse.xtend.core.richstring.LinePart;
import org.eclipse.xtend.core.richstring.Literal;
import org.eclipse.xtend.core.richstring.PrintedExpression;
import org.eclipse.xtend.core.richstring.ProcessedRichString;
import org.eclipse.xtend.core.richstring.ProcessedRichStringFactory;
import org.eclipse.xtend.core.richstring.ProcessedRichStringPackage;

import org.eclipse.xtend.core.xtend.XtendPackage;

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
public class ProcessedRichStringPackageImpl extends EPackageImpl implements ProcessedRichStringPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processedRichStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineBreakEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forLoopStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forLoopEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifConditionStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseIfConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elseStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endIfEClass = null;

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
	 * @see org.eclipse.xtend.core.richstring.ProcessedRichStringPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessedRichStringPackageImpl()
	{
		super(eNS_URI, ProcessedRichStringFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProcessedRichStringPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProcessedRichStringPackage init()
	{
		if (isInited) return (ProcessedRichStringPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessedRichStringPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredProcessedRichStringPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ProcessedRichStringPackageImpl theProcessedRichStringPackage = registeredProcessedRichStringPackage instanceof ProcessedRichStringPackageImpl ? (ProcessedRichStringPackageImpl)registeredProcessedRichStringPackage : new ProcessedRichStringPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		XAnnotationsPackage.eINSTANCE.eClass();
		XbasePackage.eINSTANCE.eClass();
		XtendPackage.eINSTANCE.eClass();
		XtypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProcessedRichStringPackage.createPackageContents();

		// Initialize created meta-data
		theProcessedRichStringPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProcessedRichStringPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProcessedRichStringPackage.eNS_URI, theProcessedRichStringPackage);
		return theProcessedRichStringPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProcessedRichString()
	{
		return processedRichStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcessedRichString_RichString()
	{
		return (EReference)processedRichStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProcessedRichString_Lines()
	{
		return (EReference)processedRichStringEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLine()
	{
		return lineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLine_Parts()
	{
		return (EReference)lineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLine_RichString()
	{
		return (EReference)lineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLinePart()
	{
		return linePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLinePart_Line()
	{
		return (EReference)linePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral()
	{
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLiteral_Literal()
	{
		return (EReference)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteral_Offset()
	{
		return (EAttribute)literalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiteral_Length()
	{
		return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLineBreak()
	{
		return lineBreakEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForLoopStart()
	{
		return forLoopStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForLoopStart_Loop()
	{
		return (EReference)forLoopStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForLoopStart_End()
	{
		return (EReference)forLoopStartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForLoopEnd()
	{
		return forLoopEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForLoopEnd_Start()
	{
		return (EReference)forLoopEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrintedExpression()
	{
		return printedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrintedExpression_Expression()
	{
		return (EReference)printedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIfConditionStart()
	{
		return ifConditionStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfConditionStart_RichStringIf()
	{
		return (EReference)ifConditionStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfConditionStart_ElseStart()
	{
		return (EReference)ifConditionStartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfConditionStart_ElseIfConditions()
	{
		return (EReference)ifConditionStartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIfConditionStart_EndIf()
	{
		return (EReference)ifConditionStartEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElseIfCondition()
	{
		return elseIfConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseIfCondition_RichStringElseIf()
	{
		return (EReference)elseIfConditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseIfCondition_IfConditionStart()
	{
		return (EReference)elseIfConditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElseStart()
	{
		return elseStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElseStart_IfConditionStart()
	{
		return (EReference)elseStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEndIf()
	{
		return endIfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEndIf_IfConditionStart()
	{
		return (EReference)endIfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessedRichStringFactory getProcessedRichStringFactory()
	{
		return (ProcessedRichStringFactory)getEFactoryInstance();
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
		processedRichStringEClass = createEClass(PROCESSED_RICH_STRING);
		createEReference(processedRichStringEClass, PROCESSED_RICH_STRING__RICH_STRING);
		createEReference(processedRichStringEClass, PROCESSED_RICH_STRING__LINES);

		lineEClass = createEClass(LINE);
		createEReference(lineEClass, LINE__PARTS);
		createEReference(lineEClass, LINE__RICH_STRING);

		linePartEClass = createEClass(LINE_PART);
		createEReference(linePartEClass, LINE_PART__LINE);

		literalEClass = createEClass(LITERAL);
		createEReference(literalEClass, LITERAL__LITERAL);
		createEAttribute(literalEClass, LITERAL__OFFSET);
		createEAttribute(literalEClass, LITERAL__LENGTH);

		lineBreakEClass = createEClass(LINE_BREAK);

		forLoopStartEClass = createEClass(FOR_LOOP_START);
		createEReference(forLoopStartEClass, FOR_LOOP_START__LOOP);
		createEReference(forLoopStartEClass, FOR_LOOP_START__END);

		forLoopEndEClass = createEClass(FOR_LOOP_END);
		createEReference(forLoopEndEClass, FOR_LOOP_END__START);

		printedExpressionEClass = createEClass(PRINTED_EXPRESSION);
		createEReference(printedExpressionEClass, PRINTED_EXPRESSION__EXPRESSION);

		ifConditionStartEClass = createEClass(IF_CONDITION_START);
		createEReference(ifConditionStartEClass, IF_CONDITION_START__RICH_STRING_IF);
		createEReference(ifConditionStartEClass, IF_CONDITION_START__ELSE_START);
		createEReference(ifConditionStartEClass, IF_CONDITION_START__ELSE_IF_CONDITIONS);
		createEReference(ifConditionStartEClass, IF_CONDITION_START__END_IF);

		elseIfConditionEClass = createEClass(ELSE_IF_CONDITION);
		createEReference(elseIfConditionEClass, ELSE_IF_CONDITION__RICH_STRING_ELSE_IF);
		createEReference(elseIfConditionEClass, ELSE_IF_CONDITION__IF_CONDITION_START);

		elseStartEClass = createEClass(ELSE_START);
		createEReference(elseStartEClass, ELSE_START__IF_CONDITION_START);

		endIfEClass = createEClass(END_IF);
		createEReference(endIfEClass, END_IF__IF_CONDITION_START);
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
		XtendPackage theXtendPackage = (XtendPackage)EPackage.Registry.INSTANCE.getEPackage(XtendPackage.eNS_URI);
		XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		literalEClass.getESuperTypes().add(this.getLinePart());
		lineBreakEClass.getESuperTypes().add(this.getLiteral());
		forLoopStartEClass.getESuperTypes().add(this.getLinePart());
		forLoopEndEClass.getESuperTypes().add(this.getLinePart());
		printedExpressionEClass.getESuperTypes().add(this.getLinePart());
		ifConditionStartEClass.getESuperTypes().add(this.getLinePart());
		elseIfConditionEClass.getESuperTypes().add(this.getLinePart());
		elseStartEClass.getESuperTypes().add(this.getLinePart());
		endIfEClass.getESuperTypes().add(this.getLinePart());

		// Initialize classes and features; add operations and parameters
		initEClass(processedRichStringEClass, ProcessedRichString.class, "ProcessedRichString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessedRichString_RichString(), theXtendPackage.getRichString(), null, "richString", null, 0, 1, ProcessedRichString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessedRichString_Lines(), this.getLine(), this.getLine_RichString(), "lines", null, 0, -1, ProcessedRichString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLine_Parts(), this.getLinePart(), this.getLinePart_Line(), "parts", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLine_RichString(), this.getProcessedRichString(), this.getProcessedRichString_Lines(), "richString", null, 0, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linePartEClass, LinePart.class, "LinePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinePart_Line(), this.getLine(), this.getLine_Parts(), "line", null, 0, 1, LinePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteral_Literal(), theXtendPackage.getRichStringLiteral(), null, "literal", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteral_Offset(), ecorePackage.getEInt(), "offset", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteral_Length(), ecorePackage.getEInt(), "length", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineBreakEClass, LineBreak.class, "LineBreak", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forLoopStartEClass, ForLoopStart.class, "ForLoopStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForLoopStart_Loop(), theXtendPackage.getRichStringForLoop(), null, "loop", null, 0, 1, ForLoopStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForLoopStart_End(), this.getForLoopEnd(), this.getForLoopEnd_Start(), "end", null, 0, 1, ForLoopStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forLoopEndEClass, ForLoopEnd.class, "ForLoopEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForLoopEnd_Start(), this.getForLoopStart(), this.getForLoopStart_End(), "start", null, 0, 1, ForLoopEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(printedExpressionEClass, PrintedExpression.class, "PrintedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrintedExpression_Expression(), theXbasePackage.getXExpression(), null, "expression", null, 0, 1, PrintedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifConditionStartEClass, IfConditionStart.class, "IfConditionStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfConditionStart_RichStringIf(), theXtendPackage.getRichStringIf(), null, "richStringIf", null, 0, 1, IfConditionStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfConditionStart_ElseStart(), this.getElseStart(), this.getElseStart_IfConditionStart(), "elseStart", null, 0, 1, IfConditionStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfConditionStart_ElseIfConditions(), this.getElseIfCondition(), this.getElseIfCondition_IfConditionStart(), "elseIfConditions", null, 0, -1, IfConditionStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfConditionStart_EndIf(), this.getEndIf(), null, "endIf", null, 0, 1, IfConditionStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elseIfConditionEClass, ElseIfCondition.class, "ElseIfCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElseIfCondition_RichStringElseIf(), theXtendPackage.getRichStringElseIf(), null, "richStringElseIf", null, 0, 1, ElseIfCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElseIfCondition_IfConditionStart(), this.getIfConditionStart(), this.getIfConditionStart_ElseIfConditions(), "ifConditionStart", null, 0, 1, ElseIfCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elseStartEClass, ElseStart.class, "ElseStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElseStart_IfConditionStart(), this.getIfConditionStart(), this.getIfConditionStart_ElseStart(), "ifConditionStart", null, 0, 1, ElseStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endIfEClass, EndIf.class, "EndIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndIf_IfConditionStart(), this.getIfConditionStart(), null, "ifConditionStart", null, 0, 1, EndIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProcessedRichStringPackageImpl
