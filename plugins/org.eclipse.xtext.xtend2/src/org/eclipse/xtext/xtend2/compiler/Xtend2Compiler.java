/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.compiler;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

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
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.compiler.AnnotationCompiler;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.compiler.DelegatingAppendable;
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
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringLiteral;
import org.eclipse.xtext.xtend2.xtend2.XtendAnnotationTarget;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendClassSuperCallReferable;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendMember;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
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

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private IXtend2JvmAssociations associations;
	
	@Inject
	private AnnotationCompiler annotationCompiler; 

	/**
	 * Compile the given {@link XtendFile file} to java code and write
	 * the result into the writer. It is assumed that a single file will
	 * be compiled to a single artifact.
	 * @param obj the file to be compiled. May not be <code>null</code>.
	 * @param writer the output acceptor. May not be <code>null</code>.
	 * @throws RuntimeException something went wrong (I/O errors or the like)
	 */
	public void compile(XtendFile obj, Writer writer) {
		try {
			if (obj.getPackage() != null) {
				writer.append("package ");
				writer.append(obj.getPackage());
				writer.append(";\n");
			}
			ImportManager importManager = new ImportManager(true, obj.getXtendClass() != null ? obj.getXtendClass().getName() : null);
			StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
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
		generateAnnotations(obj, appendable);
		appendable.append("\npublic class ").append(obj.getName());
		appendTypeParameterDeclaration(obj.getTypeParameters(), appendable);
		if (obj.getExtends() != null) {
			appendable.append(" extends ");
			serialize(obj.getExtends(), obj, appendable);
		}
		if (!obj.getImplements().isEmpty()) {
			appendable.append(" implements ");
			serialize(obj.getImplements().get(0), obj, appendable);
			for (int i = 1; i < obj.getImplements().size(); ++i) {
				appendable.append(", ");
				serialize(obj.getImplements().get(i), obj, appendable);
			}
		}
		appendable.append(" {");
		appendable.increaseIndentation();
		declareThis(obj, appendable);
		for (XtendMember member : obj.getMembers()) {
			if (member instanceof XtendFunction) {
				compile((XtendFunction) member, appendable);
			} else if (member instanceof XtendField) {
				compile((XtendField) member, appendable);
			}
		}
		generateDispatchMethods(obj, appendable);
		appendable.decreaseIndentation();
		appendable.append("\n}");
	}


	protected void compile(XtendField field, IAppendable appendable) {
		appendable.append("\n");
		generateAnnotations(field, appendable);
		appendable.append("\nprivate ");
		serialize(field.getType(), field, appendable);
		appendable.append(" ");
		appendable.append(appendable.declareVariable(field, field.getName())).append(";");
	}

	protected void generateAnnotations(XtendAnnotationTarget annotationTarget, IAppendable appendable) {
		for (XAnnotation anno : annotationTarget.getAnnotations()) {
			appendable.append("\n");
			annotationCompiler.generate(anno, appendable);
		}
	}

	protected void generateDispatchMethods(XtendClass obj, IAppendable appendable) {
		JvmGenericType type = associations.getInferredType(obj);
		Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(type);
		for (final Pair<String, Integer> dispatchMethod : dispatchMethods.keySet()) {
			JvmOperation jvmOperation = dispatchingSupport.findSyntheticDispatchMethod(obj, dispatchMethod);
			generateDispatchMethod(jvmOperation, dispatchMethods.get(dispatchMethod), appendable);
		}
	}

	protected void generateDispatchMethod(JvmOperation dispatchOperation, Collection<JvmOperation> collection,
			IAppendable a) {
		a.openScope();
		a.append("\n\n").append(getJavaVisibility(dispatchOperation.getVisibility())).append(" ");
		serialize(dispatchOperation.getReturnType(), dispatchOperation, a);
		a.append(" ");
		a.append(dispatchOperation.getSimpleName()).append("(");
		declareJvmParameters(dispatchOperation.getParameters(), a);
		a.append(") ");
		declareExceptions(dispatchOperation, a);
		a.append("{");
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
				final String name = getVarName(p1, a);
				if (getTypeReferences().is(type, Void.class)) {
					a.append("(").append(name).append(" == null)");
				} else {
					a.append("(").append(name).append(" instanceof ");
					a.append(getPrimitives().asWrapperTypeIfPrimitive(type).getType()).append(")");
				}
				if (iter2.hasNext()) {
					a.append("\n && ");
				}
			}
			a.decreaseIndentation().decreaseIndentation();
			a.append(") {").increaseIndentation();
			a.append("\n");
			final boolean isCurrentVoid = getTypeReferences().is(operation.getReturnType(), Void.TYPE);
			final boolean isDispatchVoid = getTypeReferences().is(dispatchOperation.getReturnType(), Void.TYPE);
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
		// TODO use import for java.util.Arrays
		a.append("\n");
		a.increaseIndentation();
		a.append("throw new IllegalArgumentException(\"Unhandled parameter types: \" +\njava.util.Arrays.<Object>asList(");
		Iterator<JvmFormalParameter> iterator = dispatchOperation.getParameters().iterator();
		while(iterator.hasNext()) {
			JvmFormalParameter parameter = iterator.next();
			final String name = getVarName(parameter, a);
			a.append(name);
			if (iterator.hasNext()) {
				a.append(", ");
			}
		}
		a.append(").toString());");
		a.decreaseIndentation();
		a.decreaseIndentation().append("\n}");
		a.decreaseIndentation().append("\n}");
		a.closeScope();
	}

	protected void generateActualDispatchCall(JvmOperation dispatchOperation, JvmOperation actualOperationToCall,
			IAppendable a) {
		a.append(actualOperationToCall.getSimpleName()).append("(");
		Iterator<JvmFormalParameter> iter1 = dispatchOperation.getParameters().iterator();
		for (Iterator<JvmFormalParameter> iter2 = actualOperationToCall.getParameters().iterator(); iter2.hasNext();) {
			JvmFormalParameter p1 = iter1.next();
			JvmFormalParameter p2 = iter2.next();
			a.append("(");
			serialize(getPrimitives().asWrapperTypeIfPrimitive(p2.getParameterType()), dispatchOperation, a);
			a.append(")");
			if (getTypeReferences().is(p2.getParameterType(), Void.class)) {
				a.append("null");
			} else {
				a.append(getVarName(p1, a));
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
		final JvmOperation directlyInferredOperation = associations.getDirectlyInferredOperation(obj);
		JvmTypeReference returnType = directlyInferredOperation.getReturnType();
		String name = obj.getName();
		if (obj.isDispatch()) {
			name = "_" + name;
		}
		appendable.append("\n");
		generateAnnotations(obj, appendable);
		appendable.append("\n").append(getJavaVisibility(directlyInferredOperation.getVisibility())).append(" ");
		appendTypeParameterDeclaration(obj.getTypeParameters(), appendable);
		serialize(resolveMultiType(returnType), obj, appendable);
		appendable.append(" ").append(name).append("(");
		final EList<XtendParameter> parameters = obj.getParameters();
		declareParameters(parameters, appendable);
		appendable.append(") ");
		JvmOperation operation = directlyInferredOperation;
		declareExceptions(operation, appendable);
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

	protected Object getJavaVisibility(JvmVisibility visibility) {
		switch (visibility) {
			case PUBLIC : return "public";
			case PROTECTED : return "protected";
			case PRIVATE : return "private";
			case DEFAULT : return "";
		}
		return null;
	}

	protected void declareExceptions(JvmOperation obj, IAppendable appendable) {
		List<JvmTypeReference> checkedExceptions = getCheckedExceptions(obj);
		Set<JvmType> alreadyDeclared = newHashSet();
		if (!checkedExceptions.isEmpty()) {
			appendable.append("throws ");
			for (Iterator<JvmTypeReference> iterator = checkedExceptions.iterator(); iterator.hasNext();) {
				JvmTypeReference jvmTypeReference = iterator.next();
				if (alreadyDeclared.add(jvmTypeReference.getType())) {
					serialize(jvmTypeReference, obj, appendable);
					if (iterator.hasNext())
						appendable.append(", ");
				}
			}
			appendable.append(" ");
		}
	}

	protected void compileCreateExtensionBody(XtendFunction obj, IAppendable appendable) {
		CreateExtensionInfo info = obj.getCreateExtensionInfo();
		JvmTypeReference listType = getTypeReferences().getTypeForName(ArrayList.class, obj);
		JvmTypeReference collectonLiterals = getTypeReferences().getTypeForName(CollectionLiterals.class, obj);
		String cacheVarName = appendable.getName(cacheVarKey(info));
		String cacheKeyVarName = appendable.declareVariable("CacheKey", "_cacheKey");
		appendable.append("\nfinal ");
		serialize(listType, info.getCreateExpression(), appendable);
		appendable.append(cacheKeyVarName).append(" = ");
		serialize(collectonLiterals, info.getCreateExpression(), appendable);
		appendable.append(".newArrayList(");
		EList<XtendParameter> list = obj.getParameters();
		for (Iterator<XtendParameter> iterator = list.iterator(); iterator.hasNext();) {
			XtendParameter jvmFormalParameter = iterator.next();
			appendable.append(appendable.getName(jvmFormalParameter));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// declare result variable
		JvmTypeReference returnType = getTypeProvider().getType(info.getCreateExpression());
		appendable.append("\n");
		serialize(returnType,info.getCreateExpression(),appendable);
		String varName = declareNameInVariableScope(info, appendable);
		appendable.append(" ").append(varName).append(";");
		// open synchronize block
		appendable.append("\nsynchronized (").append(cacheVarName).append(") {");
		appendable.increaseIndentation();
		// if the cache contains the key return the previously created object.
		appendable.append("\nif (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName).append(")) {");
		appendable.increaseIndentation();
		appendable.append("\nreturn ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().append("\n}");
		// execute the creation
		internalToJavaStatement(info.getCreateExpression(), appendable, true);
		appendable.append("\n");
		appendable.append(varName).append(" = ");
		internalToJavaExpression(info.getCreateExpression(), appendable);
		appendable.append(";");
		
		// store the newly created object in the cache
		appendable.append("\n").append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ").append(varName).append(");");
		
		// close synchronize block
		appendable.decreaseIndentation();
		appendable.append("\n}");
		
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
		serialize(map, info.getCreateExpression(), appendable);
		appendable.append(" ");
		String cacheName = appendable.declareVariable(cacheVarKey(info), "_createCache_"+obj.getName());
		appendable.append(cacheName);
		appendable.append(" = new ");
		serialize(map, info.getCreateExpression(), appendable);
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
						serialize(constraint.getTypeReference(), tp, appendable);
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
	
	protected List<JvmTypeReference> getCheckedExceptions(JvmOperation operation) {
		Iterable<JvmTypeReference> types = getTypeProvider().getThrownExceptionForIdentifiable(operation);
		List<JvmTypeReference> result = newArrayList();
		Set<JvmType> alreadyDeclared = Sets.newHashSet();
		for (JvmTypeReference jvmTypeReference : types) {
			if (alreadyDeclared.add(jvmTypeReference.getType())) {
				if (getTypeReferences().isInstanceOf(jvmTypeReference, Exception.class)) {
					result.add(jvmTypeReference);
				}
			}
		}
		Collections.sort(result, new Comparator<JvmTypeReference>() {
			public int compare(JvmTypeReference o1, JvmTypeReference o2) {
				return o1.getIdentifier().compareTo(o2.getIdentifier());
			}
		});
		return result;
	}

	protected void declareParameters(final EList<XtendParameter> parameters, IAppendable appendable) {
		final int numParams = parameters.size();
		for (int i = 0; i < numParams; i++) {
			XtendParameter p = parameters.get(i);
			String varName = declareNameInVariableScope(p, appendable);
			appendable.append("final ");
			serialize(p.getParameterType(),p,appendable);
			appendable.append(" ").append(varName);
			if (i != numParams - 1)
				appendable.append(", ");
		}
	}
	protected void declareJvmParameters(final EList<JvmFormalParameter> parameters, IAppendable appendable) {
		final int numParams = parameters.size();
		for (int i = 0; i < numParams; i++) {
			JvmFormalParameter p = parameters.get(i);
			String varName = declareNameInVariableScope(p, appendable);
			appendable.append("final ");
			serialize(p.getParameterType(),p,appendable);
			appendable.append(" ").append(varName);
			if (i != numParams - 1)
				appendable.append(", ");
		}
	}
	

	protected void declareThis(XtendClass clazz, IAppendable appendable) {
		appendable.declareVariable(clazz, "this");
		appendable.declareVariable(clazz.getSuperCallReferable(), "super");
	}
	
	@Override
	protected void _toJavaStatement(XClosure closure, IAppendable b, boolean isReferenced) {
		super._toJavaStatement(closure, getClosureContextAppendable(b), isReferenced);
	}
	
	protected IAppendable getClosureContextAppendable(final IAppendable appendable) {
		return new DelegatingAppendable(appendable) {
			@Override
			public String getName(Object key) {
				if (key instanceof XtendClass) {
					return ((XtendClass) key).getSimpleName()+".this";
				}
				if (key instanceof XtendClassSuperCallReferable) {
					return ((XtendClassSuperCallReferable) key).getXtendClass().getSimpleName()+".super";
				}
				return super.getName(key);
			}
		};
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
			serialize(paramType, parameter, appendable);
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
		String variableName = b.declareVariable(Tuples.pair(richString, "result"), "_builder");
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
