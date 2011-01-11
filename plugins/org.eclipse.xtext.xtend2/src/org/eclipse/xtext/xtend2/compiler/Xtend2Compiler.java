package org.eclipse.xtext.xtend2.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

public class Xtend2Compiler extends XbaseCompiler {
	
	@Override
	public void compile(EObject obj, IAppendable appendable) {
		if (obj instanceof XtendClass) {
			compile((XtendClass) obj, appendable);
		} else if (obj instanceof XtendFunction) {
			compile((XtendFunction) obj, appendable);
		} else if (obj instanceof XtendFile) {
			compile((XtendFile) obj, appendable);
		} else {
			super.compile(obj, appendable);
		}
	}

	protected void compile(XtendFile obj, IAppendable appendable) {
		appendable.append("package ").append(obj.getPackage()).append(";\n");
		for (XtendClass clazz: obj.getClasses()) {
			appendable.append("\n");
			compile(clazz,appendable);
		}
	}

	protected void compile(XtendClass obj, IAppendable appendable) {
		//TODO typeparams, inheritance, abstract, final
		appendable.append("public class ").append(obj.getName()).append(" {");
		appendable.increaseIndentation();
		for (JvmOperation op : obj.getDeclaredOperations()) {
			if (op instanceof XtendFunction) {
				compile((XtendFunction)op,appendable);
			}
		}
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}

	protected void compile(XtendFunction obj, IAppendable appendable) {
		//TODO typeparams, exceptions
		JvmTypeReference returnType = getTypeProvider().getType(obj);
		appendable.append("\n").append("public ").append(returnType.getCanonicalName()).append(" ").append(obj.getName()).append("(");
		final int numParams = obj.getParameters().size();
		for (int i = 0; i < numParams; i++) {
			JvmFormalParameter p = obj.getParameters().get(i);
			appendable.append(p.getParameterType().getCanonicalName()).append(" ").append(makeJavaIdentifier(p.getName()));
			if (i!=numParams-1)
				appendable.append(", ");
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		compile(obj.getExpression(), appendable);
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}
}
