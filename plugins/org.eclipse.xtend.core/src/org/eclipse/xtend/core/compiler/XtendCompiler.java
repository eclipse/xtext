/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.compiler;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow
 */
@NonNullByDefault
public class XtendCompiler extends XbaseCompiler {

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
		private final ITreeAppendable appendable;
		private final String variableName;

		public RichStringPrepareCompiler(ITreeAppendable appendable, String variableName) {
			this.ifStack = Lists.newLinkedList();
			this.forStack = Lists.newLinkedList();
			this.appendable = appendable;
			this.variableName = variableName;
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			appendable.newLine();
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
		public void acceptSemanticText(CharSequence text, @Nullable RichStringLiteral origin) {
			if (text.length() == 0)
				return;
			appendable.newLine();
			appendable.append(variableName);
			appendable.append(".append(\"");
			appendable.append(Strings.convertToJavaString(text.toString()));
			appendable.append("\");");
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			ifStack.add((RichStringIf) condition.eContainer());
			appendable.newLine();
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
			appendable.newLine();
			appendable.append("if (");
			internalToJavaExpression(condition, appendable);
			appendable.append(") {").increaseIndentation();
		}

		protected void writeElse() {
			appendable.decreaseIndentation();
			appendable.newLine();
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
				appendable.newLine();
				appendable.append("}");
			}
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, @Nullable XExpression expression) {
			super.acceptForLoop(parameter, expression);
			if (expression == null)
				throw new IllegalArgumentException("expression may not be null");
			RichStringForLoop forLoop = (RichStringForLoop) expression.eContainer();
			forStack.add(forLoop);
			appendable.newLine().append("{").increaseIndentation();
			internalToJavaStatement(expression, appendable, true);
			String variableName = null;
			if (forLoop.getAfter() != null || forLoop.getSeparator() != null || forLoop.getAfter() != null) {
				variableName = appendable.declareSyntheticVariable(forLoop, "_hasElements");
				appendable.newLine();
				appendable.append("boolean ");
				appendable.append(variableName);
				appendable.append(" = false;");
			}
			appendable.newLine();
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
		public boolean forLoopHasNext(@Nullable XExpression before, @Nullable XExpression separator, CharSequence indentation) {
			if (!super.forLoopHasNext(before, separator, indentation))
				return false;
			RichStringForLoop forLoop = forStack.getLast();
			if (appendable.hasName(forLoop)) {
				String varName = getVarName(forLoop, appendable);
				appendable.newLine();
				appendable.append("if (!");
				appendable.append(varName);
				appendable.append(") {");
				appendable.increaseIndentation();
				appendable.newLine();
				appendable.append(varName);
				appendable.append(" = true;");
				if (before != null) {
					writeExpression(before, indentation, false);
				}
				appendable.decreaseIndentation();
				appendable.newLine();
				appendable.append("}");
				if (separator != null) {
					appendable.append(" else {");
					appendable.increaseIndentation();
					writeExpression(separator, indentation, true);
					appendable.decreaseIndentation();
					appendable.newLine();
					appendable.append("}");
				}
			}
			return true;
		}
		
		@Override
		public void acceptEndFor(@Nullable XExpression after, CharSequence indentation) {
			super.acceptEndFor(after, indentation);
			appendable.decreaseIndentation();
			appendable.newLine();
			appendable.append("}");
			
			RichStringForLoop forLoop = forStack.removeLast();
			if (after != null) {
				String varName = getVarName(forLoop, appendable);
				appendable.newLine();
				appendable.append("if (");
				appendable.append(varName);
				appendable.append(") {");
				appendable.increaseIndentation();
				writeExpression(after, indentation, false);
				appendable.decreaseIndentation();
				appendable.newLine();
				appendable.append("}");
			}
			
			appendable.decreaseIndentation();
			appendable.newLine();
			appendable.append("}");
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			writeExpression(expression, indentation, false);
		}

		protected void writeExpression(XExpression expression, CharSequence indentation, boolean immediate) {
			internalToJavaStatement(expression, appendable, true);
			if (!getTypeReferences().is(getTypeProvider().getType(expression), Void.TYPE)) {
				appendable.newLine();
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
	
	@Override
	public void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof RichString)
			_toJavaStatement((RichString)obj, appendable, isReferenced);
		else
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
	}

	public void _toJavaStatement(RichString richString, ITreeAppendable b, boolean isReferenced) {
		// declare variable
		JvmTypeReference type = getTypeReferences().getTypeForName(StringConcatenation.class, richString);
		String variableName = b.declareSyntheticVariable(richString, "_builder");
		b.newLine();
		serialize(type, richString, b);
		b.append(" ");
		b.append(variableName);
		b.append(" = new ");
		serialize(type, richString, b);
		b.append("();");
		RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(b, variableName);
		richStringProcessor.process(richString, compiler, indentationHandler.get());
	}

	@Override
	public void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof RichString)
			_toJavaExpression((RichString) obj, appendable);
		else
			super.internalToConvertedExpression(obj, appendable);
	}
	
	public void _toJavaExpression(RichString richString, ITreeAppendable b) {
		b.append(getVarName(richString, b));
	}

}
