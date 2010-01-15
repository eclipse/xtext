/**
 * <copyright>
 * </copyright>
 *
 * $Id: XpressionFactoryImpl.java,v 1.2 2010/01/15 08:16:16 sefftinge Exp $
 */
package org.eclipse.xtext.xpression.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xpression.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XpressionFactoryImpl extends EFactoryImpl implements XpressionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XpressionFactory init() {
		try {
			XpressionFactory theXpressionFactory = (XpressionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/xbase/Xpression"); 
			if (theXpressionFactory != null) {
				return theXpressionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XpressionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XpressionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XpressionPackage.EXPRESSION: return createExpression();
			case XpressionPackage.IF_EXPRESSION: return createIfExpression();
			case XpressionPackage.SWITCH_EXPRESSION: return createSwitchExpression();
			case XpressionPackage.CASE_PART: return createCasePart();
			case XpressionPackage.BLOCK_EXPRESSION: return createBlockExpression();
			case XpressionPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case XpressionPackage.DECLARED_PARAMETER: return createDeclaredParameter();
			case XpressionPackage.FEATURE_CALL: return createFeatureCall();
			case XpressionPackage.CONSTRUCTOR_CALL: return createConstructorCall();
			case XpressionPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case XpressionPackage.NULL_LITERAL: return createNullLiteral();
			case XpressionPackage.INT_LITERAL: return createIntLiteral();
			case XpressionPackage.STRING_LITERAL: return createStringLiteral();
			case XpressionPackage.RICH_STRING: return createRichString();
			case XpressionPackage.RICH_STRING_LITERAL: return createRichStringLiteral();
			case XpressionPackage.CLOSURE: return createClosure();
			case XpressionPackage.CASTED_EXPRESSION: return createCastedExpression();
			case XpressionPackage.ASSIGNMENT: return createAssignment();
			case XpressionPackage.BINARY_OPERATION: return createBinaryOperation();
			case XpressionPackage.UNARY_OPERATION: return createUnaryOperation();
			case XpressionPackage.WHILE_EXPRESSION: return createWhileExpression();
			case XpressionPackage.TYPE_LITERAL: return createTypeLiteral();
			case XpressionPackage.INSTANCE_OF_EXPRESSION: return createInstanceOfExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpression createIfExpression() {
		IfExpressionImpl ifExpression = new IfExpressionImpl();
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpression createSwitchExpression() {
		SwitchExpressionImpl switchExpression = new SwitchExpressionImpl();
		return switchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasePart createCasePart() {
		CasePartImpl casePart = new CasePartImpl();
		return casePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpression createBlockExpression() {
		BlockExpressionImpl blockExpression = new BlockExpressionImpl();
		return blockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredParameter createDeclaredParameter() {
		DeclaredParameterImpl declaredParameter = new DeclaredParameterImpl();
		return declaredParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureCall createFeatureCall() {
		FeatureCallImpl featureCall = new FeatureCallImpl();
		return featureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorCall createConstructorCall() {
		ConstructorCallImpl constructorCall = new ConstructorCallImpl();
		return constructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteral createNullLiteral() {
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntLiteral createIntLiteral() {
		IntLiteralImpl intLiteral = new IntLiteralImpl();
		return intLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichString createRichString() {
		RichStringImpl richString = new RichStringImpl();
		return richString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichStringLiteral createRichStringLiteral() {
		RichStringLiteralImpl richStringLiteral = new RichStringLiteralImpl();
		return richStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Closure createClosure() {
		ClosureImpl closure = new ClosureImpl();
		return closure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CastedExpression createCastedExpression() {
		CastedExpressionImpl castedExpression = new CastedExpressionImpl();
		return castedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperation createBinaryOperation() {
		BinaryOperationImpl binaryOperation = new BinaryOperationImpl();
		return binaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperation createUnaryOperation() {
		UnaryOperationImpl unaryOperation = new UnaryOperationImpl();
		return unaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExpression createWhileExpression() {
		WhileExpressionImpl whileExpression = new WhileExpressionImpl();
		return whileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLiteral createTypeLiteral() {
		TypeLiteralImpl typeLiteral = new TypeLiteralImpl();
		return typeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceOfExpression createInstanceOfExpression() {
		InstanceOfExpressionImpl instanceOfExpression = new InstanceOfExpressionImpl();
		return instanceOfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XpressionPackage getXpressionPackage() {
		return (XpressionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XpressionPackage getPackage() {
		return XpressionPackage.eINSTANCE;
	}

} //XpressionFactoryImpl
