/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.compiler;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow
 */
public class Xtend2Compiler extends XbaseCompiler {

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject	
	private Provider<DefaultIndentationHandler> indentationHandler;
	
	@Override
	protected String getFavoriteVariableName(EObject ex) {
		if (ex instanceof RichStringForLoop)
			return "hasAnyElements";
		return super.getFavoriteVariableName(ex);
	}
	
	public class RichStringPrepareCompiler extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private final LinkedList<RichStringIf> ifStack;
		private final LinkedList<RichStringForLoop> forStack;
		private final IAppendable appendable;
		private final String variableName;

		public RichStringPrepareCompiler(IAppendable appendable, String variableName) {
			this.ifStack = Lists.newLinkedList();
			this.forStack = Lists.newLinkedList();
			this.appendable = appendable;
			this.variableName = variableName;
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			appendable.append("\n");
			appendable.append(variableName);
			if (!controlStructureSeen) {
				appendable.append(".newLine();");
			} else {
				appendable.append(".newLineIfNotEmpty();");
			}
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		}

		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			if (text.length() == 0)
				return;
			appendable.append("\n");
			appendable.append(variableName);
			appendable.append(".append(\"");
			appendable.append(Strings.convertToJavaString(text.toString()));
			appendable.append("\");");
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			ifStack.add((RichStringIf) condition.eContainer());
			appendable.append("\n");
			appendable.append("{").increaseIndentation();
			writeIf(condition);
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			writeElse();
			writeIf(condition);
		}

		protected void writeIf(XExpression condition) {
			internalToJavaStatement(condition, appendable, true);
			appendable.append("\n");
			appendable.append("if (");
			internalToJavaExpression(condition, appendable);
			appendable.append(") {").increaseIndentation();
		}

		protected void writeElse() {
			appendable.decreaseIndentation();
			appendable.append("\n");
			appendable.append("} else {");
			appendable.increaseIndentation();
		}

		@Override
		public void acceptElse() {
			writeElse();
		}

		@Override
		public void acceptEndIf() {
			RichStringIf richStringIf = ifStack.removeLast();
			for (int i = 0; i < richStringIf.getElseIfs().size() + 2; i++) {
				appendable.decreaseIndentation();
				appendable.append("\n");
				appendable.append("}");
			}
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			super.acceptForLoop(parameter, expression);
			RichStringForLoop forLoop = (RichStringForLoop) expression.eContainer();
			forStack.add(forLoop);
			appendable.append("\n").append("{").increaseIndentation();
			internalToJavaStatement(expression, appendable, true);
			String variableName = null;
			if (forLoop.getAfter() != null || forLoop.getSeparator() != null || forLoop.getAfter() != null) {
				variableName = appendable.declareSyntheticVariable(forLoop, "_hasElements");
				appendable.append("\n");
				appendable.append("boolean ");
				appendable.append(variableName);
				appendable.append(" = false;");
			}
			appendable.append("\n");
			appendable.append("for(final ");
			JvmTypeReference paramType = getTypeProvider().getTypeForIdentifiable(parameter);
			serialize(paramType, parameter, appendable);
			appendable.append(" ");
			String loopParam = appendable.declareVariable(parameter, parameter.getName());
			appendable.append(loopParam);
			appendable.append(" : ");
			internalToJavaExpression(expression, appendable);
			appendable.append(") {").increaseIndentation();
		}
		
		@Override
		public boolean forLoopHasNext(XExpression before, XExpression separator, CharSequence indentation) {
			if (!super.forLoopHasNext(before, separator, indentation))
				return false;
			RichStringForLoop forLoop = forStack.getLast();
			String varName = getVarName(forLoop, appendable);
			if (varName != null) {
				appendable.append("\n");
				appendable.append("if (!");
				appendable.append(varName);
				appendable.append(") {");
				appendable.increaseIndentation();
				appendable.append("\n");
				appendable.append(varName);
				appendable.append(" = true;");
				if (before != null) {
					writeExpression(before, indentation, false);
				}
				appendable.decreaseIndentation();
				appendable.append("\n");
				appendable.append("}");
				if (forLoop.getSeparator() != null) {
					appendable.append(" else {");
					appendable.increaseIndentation();
					writeExpression(separator, indentation, true);
					appendable.decreaseIndentation();
					appendable.append("\n");
					appendable.append("}");
				}
			}
			return true;
		}
		
		@Override
		public void acceptEndFor(XExpression after, CharSequence indentation) {
			super.acceptEndFor(after, indentation);
			appendable.decreaseIndentation();
			appendable.append("\n");
			appendable.append("}");
			
			RichStringForLoop forLoop = forStack.removeLast();
			if (after != null) {
				String varName = getVarName(forLoop, appendable);
				appendable.append("\n");
				appendable.append("if (");
				appendable.append(varName);
				appendable.append(") {");
				appendable.increaseIndentation();
				writeExpression(after, indentation, false);
				appendable.decreaseIndentation();
				appendable.append("\n");
				appendable.append("}");
			}
			
			appendable.decreaseIndentation();
			appendable.append("\n");
			appendable.append("}");
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			writeExpression(expression, indentation, false);
		}

		protected void writeExpression(XExpression expression, CharSequence indentation, boolean immediate) {
			internalToJavaStatement(expression, appendable, true);
			if (!getTypeReferences().is(getTypeProvider().getType(expression), Void.TYPE)) {
				appendable.append("\n");
				appendable.append(variableName);
				if (immediate)
					appendable.append(".appendImmediate(");
				else
					appendable.append(".append(");
				internalToJavaExpression(expression, appendable);
				appendable.append(", \"");
				appendable.append(indentation.toString());
				appendable.append("\");");
			}
		}

	}

	public void _toJavaStatement(RichString richString, IAppendable b, boolean isReferenced) {
		// declare variable
		JvmTypeReference type = getTypeReferences().getTypeForName(StringConcatenation.class, richString);
		String variableName = b.declareSyntheticVariable(Tuples.pair(richString, "result"), "_builder");
		b.append("\n");
		serialize(type, richString, b);
		b.append(" ");
		b.append(variableName);
		b.append(" = new ");
		serialize(type, richString, b);
		b.append("();");
		RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(b, variableName);
		richStringProcessor.process(richString, compiler, indentationHandler.get());
	}

	public void _toJavaExpression(RichString richString, IAppendable b) {
		b.append(getVarName(Tuples.pair(richString, "result"), b));
	}

}
