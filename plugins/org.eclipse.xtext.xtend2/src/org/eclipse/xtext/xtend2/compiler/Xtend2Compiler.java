package org.eclipse.xtext.xtend2.compiler;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
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
		JvmTypeReference returnType = getIdentifiableTypeProvider().getType(obj);
		appendable.append("\n\n").append("public ").append(returnType.getCanonicalName()).append(" ").append(obj.getName()).append("(");
		final int numParams = obj.getParameters().size();
		for (int i = 0; i < numParams; i++) {
			JvmFormalParameter p = obj.getParameters().get(i);
			String varName = declareNameInVariableScope(p, appendable);
			appendable.append(p.getParameterType().getCanonicalName()).append(" ").append(varName);
			if (i!=numParams-1)
				appendable.append(", ");
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		compile(obj.getExpression(), appendable);
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}

	protected void declareThis(XtendClass clazz, IAppendable appendable) {
		appendable.append("\nprotected final ");
		String variable = makeJavaIdentifier(appendable.declareVariable(clazz, "this"));
		appendable.append(clazz.getName()).append(" ").append(variable).append(" = this;");
	}
	
	public class RichStringPrepareCompiler extends AbstractRichStringPartAcceptor.ForLoopOnce {
		
		private final LinkedList<RichStringIf> ifStack;
		private final IAppendable appendable;
		private final String variableName;
		private boolean controlStructureSeen = false;

		public RichStringPrepareCompiler(IAppendable appendable, String variableName) {
			this.ifStack = Lists.newLinkedList();
			this.appendable = appendable;
			this.variableName = variableName;
		}
		
		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin) {
			appendable.append(variableName);
			if (!controlStructureSeen) {
				appendable.append(".newLine();\n");
			} else {
				appendable.append(".newLineIfNotEmpty();\n");
			}
			controlStructureSeen = false;
		}
		
		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			controlStructureSeen = false;
		}
		
		@Override
		public void acceptSemanticText(CharSequence text, RichStringLiteral origin) {
			if (text.length() == 0)
				return;
			appendable.append(variableName);
			appendable.append(".append(\"");
			appendable.append(text.toString());
			appendable.append("\");\n");
		}
		
		@Override
		public void acceptIfCondition(XExpression condition) {
			ifStack.add((RichStringIf) condition.eContainer());
			appendable.append("{").increaseIndentation().append("\n");
			writeIf(condition);
			controlStructureSeen = true;
		}
		
		@Override
		public void acceptElseIfCondition(XExpression condition) {
			writeElse();
			writeIf(condition);
			controlStructureSeen = true;
		}

		protected void writeIf(XExpression condition) {
			internalPrepare(condition, appendable);
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
			controlStructureSeen = true;
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
			controlStructureSeen = true;
		}
		
		@Override
		public void acceptForLoop(JvmFormalParameter parameter, XExpression expression) {
			super.acceptForLoop(parameter, expression);
			appendable.append("{").increaseIndentation().append("\n");
			internalPrepare(expression, appendable);
			appendable.append("for(");
			JvmTypeReference paramType = getIdentifiableTypeProvider().getType(parameter);
			appendable.append(paramType.getCanonicalName());
			appendable.append(" ");
			String loopParam = declareNameInVariableScope(parameter, appendable);
			appendable.append(loopParam);
			appendable.append(" : ");
			internalToJavaExpression(expression, appendable);
			appendable.append(") {").increaseIndentation().append("\n");
			controlStructureSeen = true;
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
			controlStructureSeen = true;
		}
		
		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			internalPrepare(expression, appendable);
			appendable.append(variableName);
			appendable.append(".append(");
			internalToJavaExpression(expression, appendable);
			appendable.append(", \"");
			appendable.append(indentation.toString());
			appendable.append("\");\n");
			controlStructureSeen = true;
		}
		
	}
	
	public void _prepare(RichString richString, IAppendable b) {
		// declare variable
		JvmTypeReference type = getTypeProvider().getConvertedType(richString);
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
//		
//		internalPrepare(expr.getSwitch(), b);
//
//		// declare local var for the switch expression
//		String name = getNameProvider().getSimpleName(expr);
//		if (name == null) {
//			// define synthetic name
//			name = "__valOfSwitchOver";
//		}
//		b.append("\nfinal ").append(getReturnTypeName(expr.getSwitch())).append(" ");
//		String variableName = b.declareVariable(expr, name);
//		b.append(variableName);
//		b.append(" = ");
//		internalToJavaExpression(expr.getSwitch(), b);
//		b.append(";");
//
//		// declare 'boolean matched' to check whether a case has matched already
//		b.append("\nboolean ");
//		String matchedVariable = b.declareVariable(Tuples.pair(expr, "matches"), "matched");
//		b.append(matchedVariable).append(" = false;");
//
//		for (XCasePart casePart : expr.getCases()) {
//			b.append("\nif (!").append(matchedVariable).append(") {");
//			b.increaseIndentation();
//			if (casePart.getTypeGuard() != null) {
//				final String guardType = getSerializedForm(casePart.getTypeGuard());
//				b.append("\nif (");
//				b.append(variableName);
//				b.append(" instanceof ");
//				b.append(guardType);
//				b.append(") {");
//				b.increaseIndentation();
//
//				// declare local var for case
//				String simpleName = getNameProvider().getSimpleName(casePart);
//				if (simpleName != null) {
//					b.append("\nfinal ").append(guardType).append(" ");
//					String typeGuardName = b.declareVariable(casePart, simpleName);
//					b.append(typeGuardName);
//					b.append(" = (").append(guardType).append(") ").append(variableName).append(";");
//				}
//			}
//			if (casePart.getCase() != null) {
//				internalPrepare(casePart.getCase(), b);
//				b.append("\nif (");
//				JvmTypeReference convertedType = getTypeProvider().getConvertedType(casePart.getCase());
//				if (Boolean.class.getName().equals(convertedType.getCanonicalName())) {
//					internalToJavaExpression(casePart.getCase(), b);
//				} else {
//					b.append(Objects.class.getCanonicalName()).append("._operator_equals(").append(variableName).append(",");
//					internalToJavaExpression(casePart.getCase(), b);
//					b.append(")");
//				}
//				b.append(") {");
//				b.increaseIndentation();
//			}
//			// set matched to true
//			b.append("\n").append(matchedVariable).append("=true;");
//
//			// execute then part
//			internalPrepare(casePart.getThen(), b);
//			b.append("\n").append(switchResultName).append(" = ");
//			internalToJavaExpression(casePart.getThen(), b);
//			b.append(";");
//
//			// close surrounding if statements
//			if (casePart.getCase() != null) {
//				b.decreaseIndentation().append("\n}");
//			}
//			if (casePart.getTypeGuard() != null) {
//				b.decreaseIndentation().append("\n}");
//			}
//			b.decreaseIndentation();
//			b.append("\n}");
//		}
//		if (expr.getDefault()!=null) {
//			b.append("\nif (!").append(matchedVariable).append(") {");
//			b.increaseIndentation();
//			internalPrepare(expr.getDefault(), b);
//			b.append("\n").append(switchResultName).append(" = ");
//			internalToJavaExpression(expr.getDefault(), b);
//			b.append(";");
//			b.decreaseIndentation();
//			b.append("\n}");
//		}

	}

	public void _toJavaExpression(RichString richString, IAppendable b) {
		b.append(getJavaVarName(Tuples.pair(richString, "result"), b));
	}

	public void _toJavaStatement(RichString richString, IAppendable b) {
		_prepare(richString, b);
	}

}
