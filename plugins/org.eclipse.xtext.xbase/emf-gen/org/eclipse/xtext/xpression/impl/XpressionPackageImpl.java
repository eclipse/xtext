/**
 * <copyright>
 * </copyright>
 *
 * $Id: XpressionPackageImpl.java,v 1.3 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

import org.eclipse.xtext.xbase.impl.XbasePackageImpl;

import org.eclipse.xtext.xpression.XAssignment;
import org.eclipse.xtext.xpression.XBinaryOperation;
import org.eclipse.xtext.xpression.XBlockExpression;
import org.eclipse.xtext.xpression.XBooleanLiteral;
import org.eclipse.xtext.xpression.XCasePart;
import org.eclipse.xtext.xpression.XCastedExpression;
import org.eclipse.xtext.xpression.XClosure;
import org.eclipse.xtext.xpression.XConstructorCall;
import org.eclipse.xtext.xpression.XDeclaredParameter;
import org.eclipse.xtext.xpression.XExpression;
import org.eclipse.xtext.xpression.XFeatureCall;
import org.eclipse.xtext.xpression.XIfExpression;
import org.eclipse.xtext.xpression.XInstanceOfExpression;
import org.eclipse.xtext.xpression.XIntLiteral;
import org.eclipse.xtext.xpression.XNullLiteral;
import org.eclipse.xtext.xpression.XRichString;
import org.eclipse.xtext.xpression.XRichStringLiteral;
import org.eclipse.xtext.xpression.XStringLiteral;
import org.eclipse.xtext.xpression.XSwitchExpression;
import org.eclipse.xtext.xpression.XTypeLiteral;
import org.eclipse.xtext.xpression.XUnaryOperation;
import org.eclipse.xtext.xpression.XVariableDeclaration;
import org.eclipse.xtext.xpression.XWhileExpression;
import org.eclipse.xtext.xpression.XpressionFactory;
import org.eclipse.xtext.xpression.XpressionPackage;

import org.eclipse.xtext.xtype.XtypePackage;

import org.eclipse.xtext.xtype.impl.XtypePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XpressionPackageImpl extends EPackageImpl implements XpressionPackage {
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
	private EClass xDeclaredParameterEClass = null;

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
	private EClass xIntLiteralEClass = null;

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
	private EClass xRichStringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xRichStringLiteralEClass = null;

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
	private EClass xAssignmentEClass = null;

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
	 * @see org.eclipse.xtext.xpression.XpressionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XpressionPackageImpl() {
		super(eNS_URI, XpressionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XpressionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XpressionPackage init() {
		if (isInited) return (XpressionPackage)EPackage.Registry.INSTANCE.getEPackage(XpressionPackage.eNS_URI);

		// Obtain or create and register package
		XpressionPackageImpl theXpressionPackage = (XpressionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XpressionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XpressionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		XbasePackageImpl theXbasePackage = (XbasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) instanceof XbasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI) : XbasePackage.eINSTANCE);
		XtypePackageImpl theXtypePackage = (XtypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) instanceof XtypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI) : XtypePackage.eINSTANCE);

		// Create package meta-data objects
		theXpressionPackage.createPackageContents();
		theXbasePackage.createPackageContents();
		theXtypePackage.createPackageContents();

		// Initialize created meta-data
		theXpressionPackage.initializePackageContents();
		theXbasePackage.initializePackageContents();
		theXtypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXpressionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XpressionPackage.eNS_URI, theXpressionPackage);
		return theXpressionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXExpression() {
		return xExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIfExpression() {
		return xIfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_If() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Then() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXIfExpression_Else() {
		return (EReference)xIfExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXSwitchExpression() {
		return xSwitchExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Switch() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Cases() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXSwitchExpression_Default() {
		return (EReference)xSwitchExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCasePart() {
		return xCasePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Case() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCasePart_Then() {
		return (EReference)xCasePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBlockExpression() {
		return xBlockExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBlockExpression_Expressions() {
		return (EReference)xBlockExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXVariableDeclaration() {
		return xVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Type() {
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXVariableDeclaration_Name() {
		return (EAttribute)xVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXVariableDeclaration_Right() {
		return (EReference)xVariableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXDeclaredParameter() {
		return xDeclaredParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXDeclaredParameter_Type() {
		return (EReference)xDeclaredParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXDeclaredParameter_Name() {
		return (EAttribute)xDeclaredParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXFeatureCall() {
		return xFeatureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFeatureCall_Target() {
		return (EReference)xFeatureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXFeatureCall_Name() {
		return (EAttribute)xFeatureCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXFeatureCall_Params() {
		return (EReference)xFeatureCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXConstructorCall() {
		return xConstructorCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Type() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Params() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXConstructorCall_Initializer() {
		return (EReference)xConstructorCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBooleanLiteral() {
		return xBooleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXBooleanLiteral_IsTrue() {
		return (EAttribute)xBooleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXNullLiteral() {
		return xNullLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXIntLiteral() {
		return xIntLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXIntLiteral_Value() {
		return (EAttribute)xIntLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXStringLiteral() {
		return xStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXStringLiteral_Value() {
		return (EAttribute)xStringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXRichString() {
		return xRichStringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXRichString_Expressions() {
		return (EReference)xRichStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXRichStringLiteral() {
		return xRichStringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXRichStringLiteral_Value() {
		return (EAttribute)xRichStringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXClosure() {
		return xClosureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_Params() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXClosure_Expression() {
		return (EReference)xClosureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXCastedExpression() {
		return xCastedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Type() {
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXCastedExpression_Target() {
		return (EReference)xCastedExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXAssignment() {
		return xAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Left() {
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXAssignment_Right() {
		return (EReference)xAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXBinaryOperation() {
		return xBinaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_Left() {
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXBinaryOperation_Operator() {
		return (EAttribute)xBinaryOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXBinaryOperation_Right() {
		return (EReference)xBinaryOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXUnaryOperation() {
		return xUnaryOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXUnaryOperation_Operator() {
		return (EAttribute)xUnaryOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXUnaryOperation_Target() {
		return (EReference)xUnaryOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXWhileExpression() {
		return xWhileExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXWhileExpression_Predicate() {
		return (EReference)xWhileExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXWhileExpression_Body() {
		return (EReference)xWhileExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXTypeLiteral() {
		return xTypeLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXTypeLiteral_Type() {
		return (EReference)xTypeLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXInstanceOfExpression() {
		return xInstanceOfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Type() {
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXInstanceOfExpression_Expression() {
		return (EReference)xInstanceOfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XpressionFactory getXpressionFactory() {
		return (XpressionFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xExpressionEClass = createEClass(XEXPRESSION);

		xIfExpressionEClass = createEClass(XIF_EXPRESSION);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__IF);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__THEN);
		createEReference(xIfExpressionEClass, XIF_EXPRESSION__ELSE);

		xSwitchExpressionEClass = createEClass(XSWITCH_EXPRESSION);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__SWITCH);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__CASES);
		createEReference(xSwitchExpressionEClass, XSWITCH_EXPRESSION__DEFAULT);

		xCasePartEClass = createEClass(XCASE_PART);
		createEReference(xCasePartEClass, XCASE_PART__CASE);
		createEReference(xCasePartEClass, XCASE_PART__THEN);

		xBlockExpressionEClass = createEClass(XBLOCK_EXPRESSION);
		createEReference(xBlockExpressionEClass, XBLOCK_EXPRESSION__EXPRESSIONS);

		xVariableDeclarationEClass = createEClass(XVARIABLE_DECLARATION);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__TYPE);
		createEAttribute(xVariableDeclarationEClass, XVARIABLE_DECLARATION__NAME);
		createEReference(xVariableDeclarationEClass, XVARIABLE_DECLARATION__RIGHT);

		xDeclaredParameterEClass = createEClass(XDECLARED_PARAMETER);
		createEReference(xDeclaredParameterEClass, XDECLARED_PARAMETER__TYPE);
		createEAttribute(xDeclaredParameterEClass, XDECLARED_PARAMETER__NAME);

		xFeatureCallEClass = createEClass(XFEATURE_CALL);
		createEReference(xFeatureCallEClass, XFEATURE_CALL__TARGET);
		createEAttribute(xFeatureCallEClass, XFEATURE_CALL__NAME);
		createEReference(xFeatureCallEClass, XFEATURE_CALL__PARAMS);

		xConstructorCallEClass = createEClass(XCONSTRUCTOR_CALL);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__TYPE);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__PARAMS);
		createEReference(xConstructorCallEClass, XCONSTRUCTOR_CALL__INITIALIZER);

		xBooleanLiteralEClass = createEClass(XBOOLEAN_LITERAL);
		createEAttribute(xBooleanLiteralEClass, XBOOLEAN_LITERAL__IS_TRUE);

		xNullLiteralEClass = createEClass(XNULL_LITERAL);

		xIntLiteralEClass = createEClass(XINT_LITERAL);
		createEAttribute(xIntLiteralEClass, XINT_LITERAL__VALUE);

		xStringLiteralEClass = createEClass(XSTRING_LITERAL);
		createEAttribute(xStringLiteralEClass, XSTRING_LITERAL__VALUE);

		xRichStringEClass = createEClass(XRICH_STRING);
		createEReference(xRichStringEClass, XRICH_STRING__EXPRESSIONS);

		xRichStringLiteralEClass = createEClass(XRICH_STRING_LITERAL);
		createEAttribute(xRichStringLiteralEClass, XRICH_STRING_LITERAL__VALUE);

		xClosureEClass = createEClass(XCLOSURE);
		createEReference(xClosureEClass, XCLOSURE__PARAMS);
		createEReference(xClosureEClass, XCLOSURE__EXPRESSION);

		xCastedExpressionEClass = createEClass(XCASTED_EXPRESSION);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TYPE);
		createEReference(xCastedExpressionEClass, XCASTED_EXPRESSION__TARGET);

		xAssignmentEClass = createEClass(XASSIGNMENT);
		createEReference(xAssignmentEClass, XASSIGNMENT__LEFT);
		createEReference(xAssignmentEClass, XASSIGNMENT__RIGHT);

		xBinaryOperationEClass = createEClass(XBINARY_OPERATION);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__LEFT);
		createEAttribute(xBinaryOperationEClass, XBINARY_OPERATION__OPERATOR);
		createEReference(xBinaryOperationEClass, XBINARY_OPERATION__RIGHT);

		xUnaryOperationEClass = createEClass(XUNARY_OPERATION);
		createEAttribute(xUnaryOperationEClass, XUNARY_OPERATION__OPERATOR);
		createEReference(xUnaryOperationEClass, XUNARY_OPERATION__TARGET);

		xWhileExpressionEClass = createEClass(XWHILE_EXPRESSION);
		createEReference(xWhileExpressionEClass, XWHILE_EXPRESSION__PREDICATE);
		createEReference(xWhileExpressionEClass, XWHILE_EXPRESSION__BODY);

		xTypeLiteralEClass = createEClass(XTYPE_LITERAL);
		createEReference(xTypeLiteralEClass, XTYPE_LITERAL__TYPE);

		xInstanceOfExpressionEClass = createEClass(XINSTANCE_OF_EXPRESSION);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__TYPE);
		createEReference(xInstanceOfExpressionEClass, XINSTANCE_OF_EXPRESSION__EXPRESSION);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XtypePackage theXtypePackage = (XtypePackage)EPackage.Registry.INSTANCE.getEPackage(XtypePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xIfExpressionEClass.getESuperTypes().add(this.getXExpression());
		xSwitchExpressionEClass.getESuperTypes().add(this.getXExpression());
		xBlockExpressionEClass.getESuperTypes().add(this.getXExpression());
		xVariableDeclarationEClass.getESuperTypes().add(this.getXExpression());
		xFeatureCallEClass.getESuperTypes().add(this.getXExpression());
		xConstructorCallEClass.getESuperTypes().add(this.getXExpression());
		xBooleanLiteralEClass.getESuperTypes().add(this.getXExpression());
		xNullLiteralEClass.getESuperTypes().add(this.getXExpression());
		xIntLiteralEClass.getESuperTypes().add(this.getXExpression());
		xStringLiteralEClass.getESuperTypes().add(this.getXExpression());
		xRichStringEClass.getESuperTypes().add(this.getXExpression());
		xClosureEClass.getESuperTypes().add(this.getXExpression());
		xCastedExpressionEClass.getESuperTypes().add(this.getXExpression());
		xAssignmentEClass.getESuperTypes().add(this.getXExpression());
		xBinaryOperationEClass.getESuperTypes().add(this.getXExpression());
		xUnaryOperationEClass.getESuperTypes().add(this.getXExpression());
		xWhileExpressionEClass.getESuperTypes().add(this.getXExpression());
		xTypeLiteralEClass.getESuperTypes().add(this.getXExpression());
		xInstanceOfExpressionEClass.getESuperTypes().add(this.getXExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(xExpressionEClass, XExpression.class, "XExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xIfExpressionEClass, XIfExpression.class, "XIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXIfExpression_If(), this.getXExpression(), null, "if", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Then(), this.getXExpression(), null, "then", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXIfExpression_Else(), this.getXExpression(), null, "else", null, 0, 1, XIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xSwitchExpressionEClass, XSwitchExpression.class, "XSwitchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXSwitchExpression_Switch(), this.getXExpression(), null, "switch", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Cases(), this.getXCasePart(), null, "cases", null, 0, -1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXSwitchExpression_Default(), this.getXExpression(), null, "default", null, 0, 1, XSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCasePartEClass, XCasePart.class, "XCasePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCasePart_Case(), this.getXExpression(), null, "case", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCasePart_Then(), this.getXExpression(), null, "then", null, 0, 1, XCasePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBlockExpressionEClass, XBlockExpression.class, "XBlockExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBlockExpression_Expressions(), this.getXExpression(), null, "expressions", null, 0, -1, XBlockExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xVariableDeclarationEClass, XVariableDeclaration.class, "XVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXVariableDeclaration_Type(), theXtypePackage.getXTypeRef(), null, "type", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXVariableDeclaration_Right(), this.getXExpression(), null, "right", null, 0, 1, XVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xDeclaredParameterEClass, XDeclaredParameter.class, "XDeclaredParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXDeclaredParameter_Type(), theXtypePackage.getXTypeRef(), null, "type", null, 0, 1, XDeclaredParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXDeclaredParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, XDeclaredParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xFeatureCallEClass, XFeatureCall.class, "XFeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXFeatureCall_Target(), this.getXExpression(), null, "target", null, 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXFeatureCall_Name(), ecorePackage.getEString(), "name", null, 0, 1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXFeatureCall_Params(), this.getXExpression(), null, "params", null, 0, -1, XFeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xConstructorCallEClass, XConstructorCall.class, "XConstructorCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXConstructorCall_Type(), theXtypePackage.getXTypeRef(), null, "type", null, 0, 1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_Params(), this.getXExpression(), null, "params", null, 0, -1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXConstructorCall_Initializer(), this.getXBlockExpression(), null, "initializer", null, 0, 1, XConstructorCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBooleanLiteralEClass, XBooleanLiteral.class, "XBooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXBooleanLiteral_IsTrue(), ecorePackage.getEBoolean(), "isTrue", null, 0, 1, XBooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xNullLiteralEClass, XNullLiteral.class, "XNullLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xIntLiteralEClass, XIntLiteral.class, "XIntLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXIntLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, XIntLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xStringLiteralEClass, XStringLiteral.class, "XStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xRichStringEClass, XRichString.class, "XRichString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXRichString_Expressions(), ecorePackage.getEObject(), null, "expressions", null, 0, -1, XRichString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xRichStringLiteralEClass, XRichStringLiteral.class, "XRichStringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXRichStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, XRichStringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xClosureEClass, XClosure.class, "XClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXClosure_Params(), this.getXDeclaredParameter(), null, "params", null, 0, -1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXClosure_Expression(), this.getXExpression(), null, "expression", null, 0, 1, XClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xCastedExpressionEClass, XCastedExpression.class, "XCastedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXCastedExpression_Type(), theXtypePackage.getXTypeRef(), null, "type", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXCastedExpression_Target(), this.getXExpression(), null, "target", null, 0, 1, XCastedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xAssignmentEClass, XAssignment.class, "XAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXAssignment_Left(), this.getXExpression(), null, "left", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXAssignment_Right(), this.getXExpression(), null, "right", null, 0, 1, XAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xBinaryOperationEClass, XBinaryOperation.class, "XBinaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXBinaryOperation_Left(), this.getXExpression(), null, "left", null, 1, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXBinaryOperation_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXBinaryOperation_Right(), this.getXExpression(), null, "right", null, 1, 1, XBinaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xUnaryOperationEClass, XUnaryOperation.class, "XUnaryOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXUnaryOperation_Operator(), ecorePackage.getEString(), "operator", null, 1, 1, XUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXUnaryOperation_Target(), this.getXExpression(), null, "target", null, 1, 1, XUnaryOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xWhileExpressionEClass, XWhileExpression.class, "XWhileExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXWhileExpression_Predicate(), this.getXExpression(), null, "predicate", null, 0, 1, XWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXWhileExpression_Body(), this.getXExpression(), null, "body", null, 0, 1, XWhileExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xTypeLiteralEClass, XTypeLiteral.class, "XTypeLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXTypeLiteral_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, XTypeLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xInstanceOfExpressionEClass, XInstanceOfExpression.class, "XInstanceOfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXInstanceOfExpression_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXInstanceOfExpression_Expression(), this.getXExpression(), null, "expression", null, 1, 1, XInstanceOfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XpressionPackageImpl
