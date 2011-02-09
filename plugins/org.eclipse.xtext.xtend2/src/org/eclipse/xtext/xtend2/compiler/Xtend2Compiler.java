package org.eclipse.xtext.xtend2.compiler;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.typing.TypesService;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class Xtend2Compiler extends XbaseCompiler {
	
	@Inject
	private RichStringProcessor richStringProcessor;
	
	@Inject
	private Provider<DefaultIndentationHandler> indentationHandler;
	
	@Inject
	private TypesService typesService;
	
	public void compile(EObject obj, IAppendable appendable) {
		if (obj instanceof XtendClass) {
			compile((XtendClass) obj, appendable);
		} else if (obj instanceof XtendFunction) {
			compile((XtendFunction) obj, appendable);
		} else if (obj instanceof XtendFile) {
			compile((XtendFile) obj, appendable);
		} else if (obj instanceof XExpression){
			super.compile((XExpression) obj, appendable);
		}
	}
	
	@Override
	protected boolean isLocalVarReference(XAbstractFeatureCall expr) {
		if (expr.getFeature() instanceof XtendClass) {
			return true;
		}
		return super.isLocalVarReference(expr);
	}

	protected void compile(XtendFile obj, IAppendable appendable) {
		appendable.append("package ").append(obj.getPackage()).append(";\n");
		if(obj.getXtendClass() != null) {
			appendable.append("\n");
			compile(obj.getXtendClass(),appendable);
		}
	}

	protected void compile(XtendClass obj, IAppendable appendable) {
		//TODO typeparams, abstract, final
		appendable.append("public class ").append(obj.getName());
		if(obj.getExtends() != null)
			appendable.append(" extends ").append(obj.getExtends().getCanonicalName());
		if(!obj.getImplements().isEmpty()) {
			appendable.append(" implements ").append(obj.getImplements().get(0).getCanonicalName());
			for(int i=1; i< obj.getImplements().size(); ++i) 
				appendable.append(", ").append(obj.getImplements().get(i).getCanonicalName());
		}
		appendable.append(" {");
		appendable.increaseIndentation();
		declareThis(obj, appendable);
		for (XtendMember member : obj.getMembers()) {
			if (member instanceof XtendFunction) {
				compile((XtendFunction)member,appendable);
			}
		}
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}

	protected void compile(XtendFunction obj, IAppendable appendable) {
		//TODO typeparams, exceptions
		JvmTypeReference returnType = getTypeProvider().getTypeForIdentifiable(obj);
		appendable.append("\n\n").append("public ").append(getSerializedForm(returnType)).append(" ").append(obj.getName()).append("(");
		final int numParams = obj.getParameters().size();
		for (int i = 0; i < numParams; i++) {
			JvmFormalParameter p = obj.getParameters().get(i);
			String varName = declareNameInVariableScope(p, appendable);
			appendable.append(getSerializedForm(p.getParameterType())).append(" ").append(varName);
			if (i!=numParams-1)
				appendable.append(", ");
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		boolean isReferenced = !typesService.isPrimitiveVoid(obj.getReturnType());
		if (obj.getReturnType()==null) {
			final JvmTypeReference type = getTypeProvider().getType(obj.getExpression());
			isReferenced = !typesService.isPrimitiveVoid(type);
		}
		compile(obj.getExpression(), appendable, isReferenced);
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}

	protected void declareThis(XtendClass clazz, IAppendable appendable) {
		appendable.append("\nprotected final ");
		String variable = appendable.declareVariable(clazz, "_this");
		appendable.append(clazz.getName()).append(" ").append(variable).append(" = this;");
	}
	
	public class RichStringPrepareCompiler extends AbstractRichStringPartAcceptor.ForLoopOnce {
		
		private final LinkedList<RichStringIf> ifStack;
		private final IAppendable appendable;
		private final String variableName;

		public RichStringPrepareCompiler(IAppendable appendable, String variableName) {
			this.ifStack = Lists.newLinkedList();
			this.appendable = appendable;
			this.variableName = variableName;
		}
		
		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			appendable.append(variableName);
			if (!controlStructureSeen) {
				appendable.append(".newLine();\n");
			} else {
				appendable.append(".newLineIfNotEmpty();\n");
			}
		}
		
		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
		}
		
		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			if (text.length() == 0)
				return;
			appendable.append(variableName);
			appendable.append(".append(\"");
			appendable.append(Strings.convertToJavaString(text.toString()));
			appendable.append("\");\n");
		}
		
		@Override
		public void acceptIfCondition(XExpression condition) {
			ifStack.add((RichStringIf) condition.eContainer());
			appendable.append("{").increaseIndentation().append("\n");
			writeIf(condition);
		}
		
		@Override
		public void acceptElseIfCondition(XExpression condition) {
			writeElse();
			writeIf(condition);
		}

		protected void writeIf(XExpression condition) {
			internalToJavaStatement(condition, appendable, true);
			appendable.append("if (");
			internalToJavaExpression(condition, appendable);
			appendable.append(") {").increaseIndentation().append("\n");
		}

		protected void writeElse() {
			appendable.decreaseIndentation();
			appendable.append("} else {");
			appendable.increaseIndentation();
			appendable.append("\n");
		}
		
		@Override
		public void acceptElse() {
			writeElse();
		}
		
		@Override
		public void acceptEndIf() {
			RichStringIf richStringIf = ifStack.removeLast();
			for(int i = 0; i < richStringIf.getElseIfs().size() + 2; i++) {
				appendable.decreaseIndentation();
				appendable.append("\n");
				appendable.append("}");
			}
			appendable.append("\n");
		}
		
		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			super.acceptForLoop(parameter, expression);
			appendable.append("{").increaseIndentation().append("\n");
			internalToJavaStatement(expression, appendable, true);
			appendable.append("for(");
			JvmTypeReference paramType = getTypeProvider().getTypeForIdentifiable(parameter);
			appendable.append(paramType.getCanonicalName());
			appendable.append(" ");
			String loopParam = declareNameInVariableScope(parameter, appendable);
			appendable.append(loopParam);
			appendable.append(" : ");
			internalToJavaExpression(expression, appendable);
			appendable.append(") {").increaseIndentation().append("\n");
		}
		
		@Override
		public void acceptEndFor() {
			super.acceptEndFor();
			appendable.decreaseIndentation();
			appendable.append("\n");
			appendable.append("}");
			appendable.decreaseIndentation();
			appendable.append("\n");
			appendable.append("}");
			appendable.append("\n");
		}
		
		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			internalToJavaStatement(expression, appendable, true);
			appendable.append(variableName);
			appendable.append(".append(");
			internalToJavaExpression(expression, appendable);
			appendable.append(", \"");
			appendable.append(indentation.toString());
			appendable.append("\");\n");
		}
		
	}
	
	public void _toJavaStatement(RichString richString, IAppendable b, boolean isReferenced) {
		// declare variable
		JvmTypeReference type = getTypeProvider().getType(richString);
		String variableName = makeJavaIdentifier(b.declareVariable(Tuples.pair(richString, "result"), "builder"));
		String typeName = getSerializedForm(type);
		b.append("\n");
		b.append(typeName);
		b.append(" ");
		b.append(variableName);
		b.append(" = new ");
		b.append(typeName);
		b.append("();\n");
		RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(b, variableName);
		richStringProcessor.process(richString, compiler, indentationHandler.get());
	}

	public void _toJavaExpression(RichString richString, IAppendable b) {
		b.append(getJavaVarName(Tuples.pair(richString, "result"), b));
	}

}
