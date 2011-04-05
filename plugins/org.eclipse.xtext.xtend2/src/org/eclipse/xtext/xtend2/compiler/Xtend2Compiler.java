package org.eclipse.xtext.xtend2.compiler;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.richstring.AbstractRichStringPartAcceptor;
import org.eclipse.xtext.xtend2.richstring.DefaultIndentationHandler;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;
import org.eclipse.xtext.xtend2.xtend2.DeclaredDependency;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class Xtend2Compiler extends XbaseCompiler {

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private Provider<DefaultIndentationHandler> indentationHandler;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private Primitives primitives;

	@Inject
	private IXtend2JvmAssociations associations;

	public void compile(XtendFile obj, Writer writer) {
		try {
			if (obj.getPackage() != null) {
				writer.append("package ");
				writer.append(obj.getPackage());
				writer.append(";\n");
			}
			StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(new ImportManager(true));
			if (obj.getXtendClass() != null) {
				compile(obj.getXtendClass(), appendable);
			}
			for (String imprt : appendable.getImports()) {
				writer.append("\nimport ").append(imprt).append(";");
			}
			writer.append("\n");
			writer.append(appendable.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void compile(EObject obj, IAppendable appendable) {
		if (obj instanceof XtendClass) {
			compile((XtendClass) obj, appendable);
		} else if (obj instanceof XtendFunction) {
			compile((XtendFunction) obj, appendable);
		} else if (obj instanceof XtendFile) {
			compile(obj, appendable);
		} else {
			throw new IllegalArgumentException();
		}
	}

	protected void compile(XtendClass obj, IAppendable appendable) {
		//TODO abstract, final
		appendable.append("\n@SuppressWarnings(\"all\")");
		appendable.append("\npublic class ").append(obj.getName());
		appendTypeParameterDeclaration(obj.getTypeParameters(), appendable);
		if (obj.getExtends() != null)
			appendable.append(" extends ").append(obj.getExtends());
		if (!obj.getImplements().isEmpty()) {
			appendable.append(" implements ").append(obj.getImplements().get(0));
			for (int i = 1; i < obj.getImplements().size(); ++i)
				appendable.append(", ").append(obj.getImplements().get(i));
		}
		appendable.append(" {");
		appendable.increaseIndentation();
		declareThis(obj, appendable);
		for (XtendMember member : obj.getMembers()) {
			if (member instanceof XtendFunction) {
				compile((XtendFunction) member, appendable);
			} else if (member instanceof DeclaredDependency) {
				compile((DeclaredDependency) member, appendable);
			}
		}
		generateDispatchMethods(obj, appendable);
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}


	protected void compile(DeclaredDependency dependency, IAppendable appendable) {
		appendable.append("\n@com.google.inject.Inject private ");
		appendable.append(dependency.getType()).append(" ");
		appendable.append(appendable.declareVariable(dependency, dependency.getSimpleName())).append(";");
	}

	protected void generateDispatchMethods(XtendClass obj, IAppendable appendable) {
		JvmGenericType type = associations.getInferredType(obj);
		Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(type);
		for (final Pair<String, Integer> dispatchMethod : dispatchMethods.keySet()) {
			final Collection<JvmOperation> collection = dispatchMethods.get(dispatchMethod);
			JvmOperation dispatchOperation = find(type.getDeclaredOperations(), new Predicate<JvmOperation>() {
				public boolean apply(JvmOperation input) {
					return dispatchMethod.getFirst().equals(input.getSimpleName())
							&& dispatchMethod.getSecond().equals(input.getParameters().size());
				}
			});
			generateDispatchMethod(dispatchOperation, collection, appendable);
		}
	}

	protected void generateDispatchMethod(JvmOperation dispatchOperation, Collection<JvmOperation> collection,
			IAppendable a) {
		a.openScope();
		a.append("\n\npublic ");
		a.append(resolveMultiType(dispatchOperation.getReturnType())).append(" ");
		a.append(dispatchOperation.getSimpleName()).append("(");
		declareParameters(dispatchOperation.getParameters(), a);
		a.append(") {");
		a.increaseIndentation();
		a.append("\n");
		for (JvmOperation operation : dispatchingSupport.sort(collection)) {
			a.append("if (");
			a.increaseIndentation().increaseIndentation();
			Iterator<JvmFormalParameter> iter1 = dispatchOperation.getParameters().iterator();
			for (Iterator<JvmFormalParameter> iter2 = operation.getParameters().iterator(); iter2.hasNext();) {
				JvmFormalParameter p1 = iter1.next();
				JvmFormalParameter p2 = iter2.next();
				final JvmTypeReference type = p2.getParameterType();
				if (this.typeRefs.is(type, Void.class)) {
					a.append("(").append(p1.getName()).append(" == null)");
				} else {
					a.append("(").append(p1.getName()).append(" instanceof ");
					a.append(primitives.asWrapperTypeIfPrimitive(type).getType()).append(")");
				}
				if (iter2.hasNext()) {
					a.append("\n && ");
				}
			}
			a.decreaseIndentation().decreaseIndentation();
			a.append(") {").increaseIndentation();
			a.append("\n");
			final boolean isCurrentVoid = typeRefs.is(operation.getReturnType(), Void.TYPE);
			final boolean isDispatchVoid = typeRefs.is(dispatchOperation.getReturnType(), Void.TYPE);
			if (isDispatchVoid) {
				generateActualDispatchCall(dispatchOperation, operation, a);
				a.append(";");
			} else {
				if (isCurrentVoid) {
					generateActualDispatchCall(dispatchOperation, operation, a);
					a.append(";\nreturn null");
				} else {
					a.append("return ");
					generateActualDispatchCall(dispatchOperation, operation, a);
				}
				a.append(";");
			}
			a.decreaseIndentation().append("\n} else ");
		}
		a.append("{").increaseIndentation();
		a.append("\nthrow new IllegalArgumentException();");
		a.decreaseIndentation().append("\n}");
		a.decreaseIndentation().append("\n}");
		a.closeScope();
	}

	protected void generateActualDispatchCall(JvmOperation dispatchOperation, JvmOperation actualOperationToCall,
			IAppendable a) {
		Iterator<JvmFormalParameter> iter1;
		a.append(actualOperationToCall.getSimpleName()).append("(");
		iter1 = dispatchOperation.getParameters().iterator();
		for (Iterator<JvmFormalParameter> iter2 = actualOperationToCall.getParameters().iterator(); iter2.hasNext();) {
			JvmFormalParameter p1 = iter1.next();
			JvmFormalParameter p2 = iter2.next();
			a.append("(").append(primitives.asWrapperTypeIfPrimitive(p2.getParameterType())).append(")");
			if (typeRefs.is(p2.getParameterType(), Void.class)) {
				a.append("null");
			} else {
				a.append(p1.getName());
			}
			if (iter2.hasNext()) {
				a.append(", ");
			}
		}
		a.append(")");
	}

	protected void compile(XtendFunction obj, IAppendable appendable) {
		if (obj.getCreateExtensionInfo()!=null) {
			declareCreateExtensionCache(obj, appendable);
		}
		
		appendable.openScope();
		JvmTypeReference returnType = associations.getDirectlyInferredOperation(obj).getReturnType();
		String name = obj.getName();
		if (obj.isDispatch()) {
			name = "_" + name;
		}
		appendable.append("\n\n").append("public ");
		appendTypeParameterDeclaration(obj.getTypeParameters(), appendable);
		appendable.append(resolveMultiType(returnType)).append(" ").append(name).append("(");
		final EList<JvmFormalParameter> parameters = obj.getParameters();
		declareParameters(parameters, appendable);
		appendable.append(") ");
		List<JvmTypeReference> checkedExceptions = getCheckedExceptions(obj);
		if (!checkedExceptions.isEmpty()) {
			appendable.append("throws ");
			for (Iterator<JvmTypeReference> iterator = checkedExceptions.iterator(); iterator.hasNext();) {
				JvmTypeReference jvmTypeReference = iterator.next();
				appendable.append(jvmTypeReference);
				if (iterator.hasNext())
					appendable.append(", ");
			}
		}
		appendable.append("{");
		appendable.increaseIndentation();
		if (obj.getCreateExtensionInfo()!=null) {
			compileCreateExtensionBody(obj, appendable);
		} else {
			compile(obj.getExpression(), appendable, returnType);
		}
		appendable.decreaseIndentation();
		appendable.append("\n}").closeScope();
	}

	protected void compileCreateExtensionBody(XtendFunction obj, IAppendable appendable) {
		CreateExtensionInfo info = obj.getCreateExtensionInfo();
		JvmTypeReference listType = getTypeReferences().getTypeForName(ArrayList.class, obj);
		JvmTypeReference collectonLiterals = getTypeReferences().getTypeForName(CollectionLiterals.class, obj);
		String cacheVarName = appendable.getName(cacheVarKey(info));
		String cacheKeyVarName = appendable.declareVariable("CacheKey", "_cacheKey");
		appendable.append("\nfinal ");
		serialize(listType, info.getCreateExpression(), appendable, false, true);
		appendable.append(cacheKeyVarName).append(" = ");
		serialize(collectonLiterals, info.getCreateExpression(), appendable, false, true);
		appendable.append(".newArrayList(");
		EList<JvmFormalParameter> list = obj.getParameters();
		for (Iterator<JvmFormalParameter> iterator = list.iterator(); iterator.hasNext();) {
			JvmFormalParameter jvmFormalParameter = iterator.next();
			appendable.append(appendable.getName(jvmFormalParameter));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// if the cache contains the key return the previously created object.
		appendable.append("\nif (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName).append(")) {");
		appendable.increaseIndentation();
		appendable.append("\nreturn ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().append("\n}");
		
		// execute the creation
		JvmTypeReference returnType = getTypeProvider().getType(info.getCreateExpression());
		internalToJavaStatement(info.getCreateExpression(), appendable, true);
		appendable.append("\n");
		serialize(returnType,info.getCreateExpression(),appendable,false,true);
		String varName = declareNameInVariableScope(info, appendable);
		appendable.append(" ").append(varName).append(" = ");
		internalToJavaExpression(info.getCreateExpression(), appendable);
		appendable.append(";");
		
		// store the newly created object in the cache
		appendable.append("\n").append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ").append(varName).append(");");
		
		// execute the initialization
		JvmTypeReference primitiveVoid = getTypeReferences().getTypeForName(Void.TYPE, obj);
		compile(obj.getExpression(), appendable, primitiveVoid);
		
		// return the result
		appendable.append("\nreturn ");
		appendable.append(varName).append(";");
	}

	protected void declareCreateExtensionCache(XtendFunction obj, IAppendable appendable) {
		final CreateExtensionInfo info = obj.getCreateExtensionInfo();
		JvmTypeReference returnType = getTypeProvider().getType(info.getCreateExpression());
		JvmTypeReference list = getTypeReferences().getTypeForName(ArrayList.class, obj);
		JvmTypeReference map = getTypeReferences().getTypeForName(HashMap.class, obj, list, returnType);
		appendable.append("\n\nprivate final ");
		serialize(map, info.getCreateExpression(), appendable, false, true);
		appendable.append(" ");
		String cacheName = appendable.declareVariable(cacheVarKey(info), "_createCache_"+obj.getName());
		appendable.append(cacheName);
		appendable.append(" = new ");
		serialize(map, info.getCreateExpression(), appendable, false, true);
		appendable.append("();");
	}

	protected Object cacheVarKey(CreateExtensionInfo createExtensionInfo) {
		return Tuples.pair("cache", createExtensionInfo);
	}

	protected void appendTypeParameterDeclaration(EList<JvmTypeParameter> typeParameters, IAppendable appendable) {
		if (!typeParameters.isEmpty()) {
			appendable.append("<");
			for (Iterator<JvmTypeParameter> iterator = typeParameters.iterator(); iterator.hasNext();) {
				JvmTypeParameter tp = iterator.next();
				appendable.append(tp);
				final Iterable<JvmUpperBound> constraints = filter(tp.getConstraints(), JvmUpperBound.class);
				Iterator<JvmUpperBound> iter2 = constraints.iterator();
				if (iter2.hasNext()) {
					appendable.append(" extends ");
					while (iter2.hasNext()) {
						JvmUpperBound constraint = iter2.next();
						appendable.append(constraint.getTypeReference());
						if (iter2.hasNext())
							appendable.append(",");
					}
				}
				if (iterator.hasNext())
					appendable.append(",");
			}
			appendable.append("> ");
		}
	}
	
	protected List<JvmTypeReference> getCheckedExceptions(XtendFunction obj) {
		Iterable<JvmTypeReference> types = getTypeProvider().getThrownExceptionTypes(obj.getExpression());
		List<JvmTypeReference> checkedExceptions = newArrayList();
		for (JvmTypeReference jvmTypeReference : types) {
			if (typeRefs.isInstanceOf(jvmTypeReference, Exception.class)) {
				checkedExceptions.add(jvmTypeReference);
			}
		}
		Collections.sort(checkedExceptions, new Comparator<JvmTypeReference>() {
			public int compare(JvmTypeReference o1, JvmTypeReference o2) {
				return o1.getIdentifier().compareTo(o2.getIdentifier());
			}
		});
		return checkedExceptions;
	}

	protected void declareParameters(final EList<JvmFormalParameter> parameters, IAppendable appendable) {
		final int numParams = parameters.size();
		for (int i = 0; i < numParams; i++) {
			JvmFormalParameter p = parameters.get(i);
			String varName = declareNameInVariableScope(p, appendable);
			appendable.append("final ").append(p.getParameterType()).append(" ").append(varName);
			if (i != numParams - 1)
				appendable.append(", ");
		}
	}

	protected void declareThis(XtendClass clazz, IAppendable appendable) {
		appendable.append("\nprivate final ");
		String variable = appendable.declareVariable(clazz, "_this");
		appendable.append(clazz.getName()).append(" ").append(variable).append(" = this;");
	}
	
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
				variableName = declareNameInVariableScope(forLoop, appendable);
				appendable.append("\n");
				appendable.append("boolean ");
				appendable.append(variableName);
				appendable.append(" = false;");
			}
			appendable.append("\n");
			appendable.append("for(");
			JvmTypeReference paramType = getTypeProvider().getTypeForIdentifiable(parameter);
			appendable.append(paramType.getIdentifier());
			appendable.append(" ");
			String loopParam = declareNameInVariableScope(parameter, appendable);
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
		JvmTypeReference type = getTypeProvider().getType(richString);
		String variableName = makeJavaIdentifier(b.declareVariable(Tuples.pair(richString, "result"), "builder"));
		b.append("\n");
		b.append(type);
		b.append(" ");
		b.append(variableName);
		b.append(" = new ");
		b.append(type);
		b.append("();");
		RichStringPrepareCompiler compiler = new RichStringPrepareCompiler(b, variableName);
		richStringProcessor.process(richString, compiler, indentationHandler.get());
	}

	public void _toJavaExpression(RichString richString, IAppendable b) {
		b.append(getJavaVarName(Tuples.pair(richString, "result"), b));
	}
	
}
