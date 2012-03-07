/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static com.google.common.collect.Sets.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.typing.Closures;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
public class XbaseCompiler extends FeatureCallCompiler {
	
	@Inject 
	private IEarlyExitComputer earlyExitComputer;
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XBlockExpression) {
			_toJavaExpression((XBlockExpression) obj, appendable);
		} else if (obj instanceof XCastedExpression) {
			_toJavaExpression((XCastedExpression) obj, appendable);
		} else if (obj instanceof XClosure) {
			_toJavaExpression((XClosure) obj, appendable);
		} else if (obj instanceof XConstructorCall) {
			_toJavaExpression((XConstructorCall) obj, appendable);
		} else if (obj instanceof XIfExpression) {
			_toJavaExpression((XIfExpression) obj, appendable);
		} else if (obj instanceof XInstanceOfExpression) {
			_toJavaExpression((XInstanceOfExpression) obj, appendable);
		} else if (obj instanceof XSwitchExpression) {
			_toJavaExpression((XSwitchExpression) obj, appendable);
		} else if (obj instanceof XTryCatchFinallyExpression) {
			_toJavaExpression((XTryCatchFinallyExpression) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}
	
	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XBlockExpression) {
			_toJavaStatement((XBlockExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XCastedExpression) {
			_toJavaStatement((XCastedExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XClosure) {
			_toJavaStatement((XClosure) obj, appendable, isReferenced);
		} else if (obj instanceof XConstructorCall) {
			_toJavaStatement((XConstructorCall) obj, appendable, isReferenced);
		} else if (obj instanceof XDoWhileExpression) {
			_toJavaStatement((XDoWhileExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XForLoopExpression) {
			_toJavaStatement((XForLoopExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XIfExpression) {
			_toJavaStatement((XIfExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XInstanceOfExpression) {
			_toJavaStatement((XInstanceOfExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XReturnExpression) {
			_toJavaStatement((XReturnExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XSwitchExpression) {
			_toJavaStatement((XSwitchExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XThrowExpression) {
			_toJavaStatement((XThrowExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XTryCatchFinallyExpression) {
			_toJavaStatement((XTryCatchFinallyExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XVariableDeclaration) {
			_toJavaStatement((XVariableDeclaration) obj, appendable, isReferenced);
		} else if (obj instanceof XWhileExpression) {
			_toJavaStatement((XWhileExpression) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}
	
	protected void _toJavaStatement(XBlockExpression expr, ITreeAppendable b, boolean isReferenced) {
		b = b.trace(expr, false);
		if (expr.getExpressions().isEmpty())
			return;
		if (expr.getExpressions().size()==1) {
			internalToJavaStatement(expr.getExpressions().get(0), b, isReferenced);
			return;
		}
		if (isReferenced)
			declareSyntheticVariable(expr, b);
		boolean needsBraces = isReferenced || !bracesAreAddedByOuterStructure(expr);
		if (needsBraces) {
			b.newLine().append("{").increaseIndentation();
			b.openPseudoScope();
		}
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b, false);
			} else {
				internalToJavaStatement(ex, b, isReferenced);
				if (isReferenced) {
					b.newLine().append(getVarName(expr, b)).append(" = (");
					internalToConvertedExpression(ex, b, null);
					b.append(");");
				}
			}
		}
		if (needsBraces) {
			b.closeScope();
			b.decreaseIndentation().newLine().append("}");
		}
	}
	
	protected boolean bracesAreAddedByOuterStructure(XBlockExpression block) {
		EObject container = block.eContainer();
		if (container instanceof XTryCatchFinallyExpression 
				|| container instanceof XIfExpression
				|| container instanceof XClosure) {
			return true;
		}
		if (!(container instanceof XExpression)) {
			return true;
		}
		return false;
	}

	protected void _toJavaExpression(XBlockExpression expr, ITreeAppendable b) {
		if (expr.getExpressions().isEmpty()) {
			b.append("null");
			return;
		}
		if (expr.getExpressions().size()==1) {
			internalToConvertedExpression(expr.getExpressions().get(0), b, null);
			return;
		}
		b = b.trace(expr, false);
		b.append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XTryCatchFinallyExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (isReferenced && !isPrimitiveVoid(expr)) {
			declareSyntheticVariable(expr, b);
		}
		b.newLine().append("try {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getExpression());
		internalToJavaStatement(expr.getExpression(), b, canBeReferenced);
		if (canBeReferenced) {
			b.newLine().append(getVarName(expr, b)).append(" = ");
			internalToConvertedExpression(expr.getExpression(), b, null);
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("}");
		appendCatchAndFinally(expr, b, isReferenced);
	}

	protected void appendCatchAndFinally(XTryCatchFinallyExpression expr, ITreeAppendable b, boolean isReferenced) {
		final EList<XCatchClause> catchClauses = expr.getCatchClauses();
		if (!catchClauses.isEmpty()) {
			String variable = b.declareSyntheticVariable(Tuples.pair(expr, "_catchedThrowable"), "_t");
			b.append(" catch (final Throwable ").append(variable).append(") ");
			b.append("{").increaseIndentation();
			b.newLine();
			Iterator<XCatchClause> iterator = catchClauses.iterator();
			while (iterator.hasNext()) {
				XCatchClause catchClause = iterator.next();
				JvmTypeReference type = catchClause.getDeclaredParam().getParameterType();
				final String name = b.declareVariable(catchClause.getDeclaredParam(), catchClause.getDeclaredParam().getName());
				b.append("if (").append(variable).append(" instanceof ");
				b.append(type.getType());
				b.append(") ").append("{");
				b.increaseIndentation();
				b.newLine().append("final ");
				serialize(type,expr,b);
				b.append(" ").append(name).append(" = (");
				serialize(type,expr,b);
				b.append(")").append(variable).append(";");
				final boolean canBeReferenced = isReferenced && ! isPrimitiveVoid(catchClause.getExpression());
				internalToJavaStatement(catchClause.getExpression(), b, canBeReferenced);
				if (canBeReferenced) {
					b.newLine().append(getVarName(expr, b)).append(" = ");
					internalToConvertedExpression(catchClause.getExpression(), b, null);
					b.append(";");
				}
				b.decreaseIndentation();
				b.newLine().append("}");
				if (iterator.hasNext()) {
					b.append(" else ");
				}
			}
			b.append(" else {");
			b.increaseIndentation();
			final JvmType sneakyThrowType = getTypeReferences().findDeclaredType(Exceptions.class, expr);
			if (sneakyThrowType == null) {
				b.append("COMPILE ERROR : '"+Exceptions.class.getCanonicalName()+"' could not be found on the classpath!");
			} else {
				b.newLine().append("throw ");
				b.append(sneakyThrowType);
				b.append(".sneakyThrow(");
				b.append(variable);
				b.append(");");
			}
			b.decreaseIndentation();
			b.newLine().append("}");
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		final XExpression finallyExp = expr.getFinallyExpression();
		if (finallyExp != null) {
			b.append(" finally {").increaseIndentation();
			internalToJavaStatement(finallyExp, b, false);
			b.decreaseIndentation().newLine().append("}");
		}
	}

	protected void _toJavaExpression(XTryCatchFinallyExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XThrowExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
		b.newLine().append("throw ");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(";");
	}

	protected void _toJavaExpression(XInstanceOfExpression expr, ITreeAppendable b) {
		b.append("(");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(" instanceof ");
		serialize(expr.getType(), expr, b);
		b.append(")");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XInstanceOfExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XVariableDeclaration varDeclaration, ITreeAppendable b, boolean isReferenced) {
		if (varDeclaration.getRight() != null) {
			internalToJavaStatement(varDeclaration.getRight(), b, true);
		}
		b.newLine();
		if (!varDeclaration.isWriteable()) {
			b.append("final ");
		}
		JvmTypeReference type = null;
		if (varDeclaration.getType() != null) {
			type = varDeclaration.getType();
		} else {
			type = getTypeProvider().getType(varDeclaration.getRight());
		}
		serialize(type, varDeclaration, b);
		b.append(" ");
		b.append(b.declareVariable(varDeclaration, varDeclaration.getName()));
		b.append(" = ");
		if (varDeclaration.getRight() != null) {
			internalToConvertedExpression(varDeclaration.getRight(), b, type);
		} else {
			if (getPrimitives().isPrimitive(type)) {
				Primitive primitiveKind = getPrimitives().primitiveKind((JvmPrimitiveType) type.getType());
				switch (primitiveKind) {
					case Boolean:
						b.append("false");
						break;
					default:
						b.append("0");
						break;
				}
			} else {
				b.append("null");
			}
		}
		b.append(";");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getPredicate(), b, true);
		final String varName = b.declareSyntheticVariable(expr, "_while");
		b.newLine().append("boolean ").append(varName).append(" = ");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(";");
		b.newLine().append("while (");
		b.append(varName);
		b.append(") {").increaseIndentation();
		b.openPseudoScope();
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.newLine();
		if (!earlyExitComputer.isEarlyExit(expr.getBody())) {
			b.append(varName).append(" = ");
			internalToJavaExpression(expr.getPredicate(), b);
			b.append(";");
		}
		b.closeScope();
		b.decreaseIndentation().newLine().append("}");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature  
	 */
	protected void _toJavaStatement(XDoWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
		String variable = b.declareSyntheticVariable(expr, "_dowhile");
		b.newLine().append("boolean ").append(variable).append(" = false;");
		b.newLine().append("do {").increaseIndentation();
		internalToJavaStatement(expr.getBody(), b, false);
		internalToJavaStatement(expr.getPredicate(), b, true);
		b.newLine();
		if (!earlyExitComputer.isEarlyExit(expr.getBody())) {
			b.append(variable).append(" = ");
			internalToJavaExpression(expr.getPredicate(), b);
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("} while(");
		b.append(variable);
		b.append(");");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XForLoopExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getForExpression(), b, true);
		b.newLine().append("for (final ");
		JvmTypeReference paramType = getTypeProvider().getTypeForIdentifiable(expr.getDeclaredParam());
		serialize(paramType,expr,b);
		b.append(" ");
		String varName = b.declareVariable(expr.getDeclaredParam(), expr.getDeclaredParam().getName());
		b.append(varName);
		b.append(" : ");
		internalToJavaExpression(expr.getForExpression(), b);
		b.append(") {").increaseIndentation();
		internalToJavaStatement(expr.getEachExpression(), b, false);
		b.decreaseIndentation().newLine().append("}");
	}

	protected void _toJavaStatement(final XConstructorCall expr, ITreeAppendable b, final boolean isReferenced) {
		for (XExpression arg : expr.getArguments()) {
			internalToJavaStatement(arg, b, true);
		}
		
		Later later = new Later() {
			public void exec(ITreeAppendable appendable) {
				appendable.append("new ");
				JvmTypeReference producedType = getTypeProvider().getType(expr);
				serialize(producedType, expr, appendable, false, false, true, false);
				appendable.append("(");
				appendArguments(expr.getArguments(), appendable);
				appendable.append(")");
			}
		};
		if (isReferenced) {
			declareFreshLocalVariable(expr, b, later);
		} else {
			b.newLine();
			later.exec(b);
			b.append(";");
		}
	}

	protected void _toJavaExpression(XConstructorCall expr, ITreeAppendable b) {
		String varName = getVarName(expr, b);
		b.trace(expr, false).append(varName);
	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XReturnExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (expr.getExpression()!=null) {
			JvmIdentifiableElement logicalContainer = getLogicalContainerProvider().getNearestLogicalContainer(expr);
			boolean needsSneakyThrow = false;
			if(logicalContainer instanceof JvmExecutable) {
				List<JvmTypeReference> declaredExceptions = ((JvmExecutable) logicalContainer).getExceptions();
				needsSneakyThrow = needsSneakyThrow(expr.getExpression(), declaredExceptions);
			}
			if (needsSneakyThrow) {
				b.newLine().append("try {").increaseIndentation();
			}
			internalToJavaStatement(expr.getExpression(), b, true);
			b.newLine().append("return ");
			internalToJavaExpression(expr.getExpression(), b);
			b.append(";");
			if (needsSneakyThrow) {
				generateCheckedExceptionHandling(expr, b);
			}
		} else {
			b.newLine().append("return;");
		}
	}
	
	protected void _toJavaExpression(XCastedExpression expr, ITreeAppendable b) {
		b.append("((");
		serialize(expr.getType(), expr, b);
		b.append(") ");
		internalToConvertedExpression(expr.getTarget(), b, expr.getType());
		b.append(")");
	}

	protected void _toJavaStatement(XCastedExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getTarget(), b, isReferenced);
	}

	protected void _toJavaStatement(XIfExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (isReferenced)
			declareSyntheticVariable(expr, b);
		internalToJavaStatement(expr.getIf(), b, true);
		b.newLine().append("if (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getThen());
		internalToJavaStatement(expr.getThen(), b, canBeReferenced);
		if (canBeReferenced) {
			b.newLine();
			b.append(getVarName(expr, b));
			b.append(" = ");
			internalToConvertedExpression(expr.getThen(), b, null);
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("}");
		if (expr.getElse() != null) {
			b.append(" else {").increaseIndentation();
			final boolean canElseBeReferenced = isReferenced && !isPrimitiveVoid(expr.getElse());
			internalToJavaStatement(expr.getElse(), b, canElseBeReferenced);
			if (canElseBeReferenced) {
				b.newLine();
				b.append(getVarName(expr, b));
				b.append(" = ");
				internalToConvertedExpression(expr.getElse(), b, null);
				b.append(";");
			}
			b.decreaseIndentation().newLine().append("}");
		}
	}

	protected void _toJavaExpression(XIfExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XSwitchExpression expr, ITreeAppendable b, boolean isReferenced) {
		// declare variable
		JvmTypeReference type = getTypeForVariableDeclaration(expr);
		String switchResultName = b.declareSyntheticVariable(expr, "_switchResult");
		if (isReferenced) {
			b.newLine();
			serialize(type, expr, b);
			b.append(" ").append(switchResultName).append(" = ");
			b.append(getDefaultValueLiteral(expr));
			b.append(";");
		}
		
		internalToJavaStatement(expr.getSwitch(), b, true);
		
		// declare the matched variable outside the pseudo scope
		String matchedVariable = b.declareSyntheticVariable(Tuples.pair(expr, "matches"), "_matched");

		// open a pseudo scope so we can re assign 'expr' to the switch over expression (switch is used as a JvmIdentifiable)
		b.openPseudoScope();
		
		// declare local var for the switch expression
		String variableName = null;
		if(expr.getLocalVarName() == null && expr.getSwitch() instanceof XFeatureCall) {
			JvmIdentifiableElement feature = ((XFeatureCall) expr.getSwitch()).getFeature();
			if (b.hasName(feature))
				variableName = b.getName(feature);
		} 
		if(variableName == null) {
			String name = getNameProvider().getSimpleName(expr);
			if (name!=null) { 
				name = makeJavaIdentifier(name);
			} else {
				// define synthetic name
				name = "__valOfSwitchOver";
			}
			JvmTypeReference typeReference = getTypeProvider().getType(expr.getSwitch());
			b.newLine().append("final ");
			serialize(typeReference, expr, b);
			b.append(" ");
			variableName = b.declareSyntheticVariable(expr, name);
			b.append(variableName);
			b.append(" = ");
			internalToJavaExpression(expr.getSwitch(), b);
			b.append(";");
		}
		// declare 'boolean matched' to check whether a case has matched already
		b.newLine().append("boolean ");
		b.append(matchedVariable).append(" = false;");

		for (XCasePart casePart : expr.getCases()) {
			b.newLine().append("if (!").append(matchedVariable).append(") {");
			b.increaseIndentation();
			if (casePart.getTypeGuard() != null) {
				b.newLine().append("if (");
				b.append(variableName);
				b.append(" instanceof ");
				b.append(casePart.getTypeGuard().getType());
				b.append(") {");
				b.increaseIndentation();
				JvmIdentifiableElement switchOver = expr.getSwitch() instanceof XFeatureCall ? ((XFeatureCall) expr.getSwitch()).getFeature() : expr;
				b.openPseudoScope();
				final String proposedName = getFavoriteVariableName(casePart.getTypeGuard().getType());
				final String castedVariableName = b.declareSyntheticVariable(switchOver, proposedName);
				b.newLine().append("final ");
				serialize(casePart.getTypeGuard(), expr, b);
				b.append(" ");
				b.append(castedVariableName);
				b.append(" = (");
				serialize(casePart.getTypeGuard(), expr, b);
				b.append(")");
				b.append(variableName);
				b.append(";");
			}
			if (casePart.getCase() != null) {
				internalToJavaStatement(casePart.getCase(), b, true);
				b.newLine().append("if (");
				JvmTypeReference convertedType = getTypeProvider().getType(casePart.getCase());
				if (getTypeReferences().is(convertedType, Boolean.TYPE) || getTypeReferences().is(convertedType, Boolean.class)) {
					internalToJavaExpression(casePart.getCase(), b);
				} else {
					JvmTypeReference typeRef = getTypeReferences().getTypeForName(ObjectExtensions.class, expr);
					serialize(typeRef, casePart, b);
					b.append(".operator_equals(").append(variableName).append(",");
					internalToJavaExpression(casePart.getCase(), b);
					b.append(")");
				}
				b.append(") {");
				b.increaseIndentation();
			}
			// set matched to true
			b.newLine().append(matchedVariable).append("=true;");

			// execute then part
			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(casePart.getThen());
			internalToJavaStatement(casePart.getThen(), b, canBeReferenced);
			if (canBeReferenced) {
				b.newLine().append(switchResultName).append(" = ");
				internalToConvertedExpression(casePart.getThen(), b, null);
				b.append(";");
			}

			// close surrounding if statements
			if (casePart.getCase() != null) {
				b.decreaseIndentation().newLine().append("}");
			}
			if (casePart.getTypeGuard() != null) {
				b.decreaseIndentation().newLine().append("}");
				b.closeScope();
			}
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		if (expr.getDefault()!=null) {
			b.newLine().append("if (!").append(matchedVariable).append(") {");
			b.increaseIndentation();
			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getDefault());
			internalToJavaStatement(expr.getDefault(), b, canBeReferenced);
			if (canBeReferenced) {
				b.newLine().append(switchResultName).append(" = ");
				internalToConvertedExpression(expr.getDefault(), b, null);
				b.append(";");
			}
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		b.closeScope(); // close the pseudo scope
	}

	protected void _toJavaExpression(XSwitchExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

	@Inject
	private Closures closures;
	
	@Inject
	private TypeArgumentContextProvider ctxProvider;
	
	protected void _toJavaStatement(final XClosure closure, final ITreeAppendable b, boolean isReferenced) {
		if (!isReferenced)
			throw new IllegalArgumentException("a closure definition does not cause any side-effects");
		JvmTypeReference type = getTypeProvider().getType(closure);
		ITypeArgumentContext context = ctxProvider.getTypeArgumentContext(new TypeArgumentContextProvider.ReceiverRequest(type));
		b.newLine().append("final ");
		serialize(type, closure, b);
		b.append(" ");
		String variableName = b.declareSyntheticVariable(closure, "_function");
		b.append(variableName).append(" = ");
		b.append("new ");
		// TODO parameters in type arguments are safe to be a wildcard
		serialize(type, closure, b, false, false, true, false);
		b.append("() {");
		b.increaseIndentation().increaseIndentation();
		try {
			b.openScope();
			JvmOperation operation = closures.findImplementingOperation(type, closure.eResource());
			final JvmTypeReference returnType = context.resolve(operation.getReturnType());
			b.newLine().append("public ");
			serialize(returnType, closure, b, false, false, true, true);
			b.append(" ").append(operation.getSimpleName());
			b.append("(");
			List<JvmFormalParameter> closureParams = closure.getFormalParameters();
			List<JvmFormalParameter> operationParams = operation.getParameters();
			for (int i = 0; i < closureParams.size(); i++) {
				JvmFormalParameter closureParam = closureParams.get(i);
				JvmFormalParameter operationParam = operationParams.get(i);
				JvmTypeReference parameterType = context.resolve(operationParam.getParameterType());
				b.append("final ");
				serialize(parameterType, closure, b, false, false, true, true);
				b.append(" ");
				String name = b.declareVariable(closureParam, closureParam.getName());
				b.append(name);
				if (i != closureParams.size() - 1)
					b.append(", ");
			}
			b.append(") {");
			b.increaseIndentation();
			if (b.hasObject("this")) {
				Object element = b.getObject("this");
				if (element instanceof JvmType) {
					final String proposedName = ((JvmType) element).getSimpleName()+".this";
					if (!b.hasObject(proposedName)) {
						b.declareSyntheticVariable(element, proposedName);
						if (b.hasObject("super")) {
							Object superElement = b.getObject("super");
							if (superElement instanceof JvmType) {
								b.declareSyntheticVariable(superElement, ((JvmType) element).getSimpleName()+".super");
							}
						}
					}
				}
			}
			compile(closure.getExpression(), b, operation.getReturnType(), newHashSet(operation.getExceptions()));
		} finally {
			b.closeScope();
		}
		b.decreaseIndentation();
		b.newLine().append("}");
		b.decreaseIndentation().newLine().append("};").decreaseIndentation();
	}
	
	protected void _toJavaExpression(final XClosure call, final ITreeAppendable b) {
		b.trace(call, false).append(getVarName(call, b));
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XCastedExpression) {
			return false;
		}
		if (expr instanceof XInstanceOfExpression) {
			return false;
		}
		final EObject container = expr.eContainer();
		if ((container instanceof XVariableDeclaration)
			|| (container instanceof XReturnExpression) 
			|| (container instanceof XThrowExpression)){
			return false;
		}
		return super.isVariableDeclarationRequired(expr, b);
	}
	
}
