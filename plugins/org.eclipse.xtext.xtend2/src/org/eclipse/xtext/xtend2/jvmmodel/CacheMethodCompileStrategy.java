/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendParameter;

import com.google.inject.Inject;

class CacheMethodCompileStrategy implements Functions.Function1<ImportManager, CharSequence> {
	@Inject
	private TypeReferences typeReferences;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private TypeReferenceSerializer typeReferenceSerializer;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	@Inject
	private Xtend2Compiler compiler;

	private CreateExtensionInfo createExtensionInfo;

	private XtendFunction createExtension;

	protected void init(XtendFunction createExtension) {
		this.createExtension = createExtension;
		this.createExtensionInfo = createExtension.getCreateExtensionInfo();
	}

	public CharSequence apply(ImportManager importManager) {
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
		JvmTypeReference listType = typeReferences.getTypeForName(ArrayList.class, createExtension);
		JvmTypeReference collectonLiterals = typeReferences.getTypeForName(CollectionLiterals.class,
				createExtension);
		String cacheVarName = appendable.declareVariable(cacheVarKey(createExtensionInfo), "_createCache_"
				+ createExtension.getName());
		String cacheKeyVarName = appendable.declareVariable("CacheKey", "_cacheKey");
		appendable.append("\nfinal ");
		// TODO: is this the correct context?
		EObject typeReferenceSerializerContext = createExtensionInfo.getCreateExpression();
		typeReferenceSerializer.serialize(listType, typeReferenceSerializerContext, appendable);
		appendable.append(cacheKeyVarName).append(" = ");
		typeReferenceSerializer.serialize(collectonLiterals, typeReferenceSerializerContext, appendable);
		appendable.append(".newArrayList(");
		JvmOperation mainOperation = (JvmOperation) logicalContainerProvider
				.getLogicalContainer(createExtensionInfo.getCreateExpression());
		EList<JvmFormalParameter> list = mainOperation.getParameters();
		for (Iterator<JvmFormalParameter> iterator = list.iterator(); iterator.hasNext();) {
			JvmFormalParameter jvmFormalParameter = iterator.next();
			appendable.append(getVarName(jvmFormalParameter, appendable));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// declare result variable
		JvmTypeReference returnType = typeProvider.getType(createExtensionInfo.getCreateExpression());
		appendable.append("\nfinal ");
		typeReferenceSerializer.serialize(returnType, typeReferenceSerializerContext, appendable);
		String varName = "_result";
		appendable.append(" ").append(varName).append(";");
		// open synchronize block
		appendable.append("\nsynchronized (").append(cacheVarName).append(") {");
		appendable.increaseIndentation();
		// if the cache contains the key return the previously created object.
		appendable.append("\nif (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName)
				.append(")) {");
		appendable.increaseIndentation();
		appendable.append("\nreturn ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().append("\n}");
		// execute the creation
		compiler.toJavaStatement(createExtensionInfo.getCreateExpression(), appendable, true);
		appendable.append("\n");
		appendable.append(varName).append(" = ");
		compiler.toJavaExpression(createExtensionInfo.getCreateExpression(), appendable);
		appendable.append(";");

		// store the newly created object in the cache
		appendable.append("\n").append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ")
				.append(varName).append(");");

		// close synchronize block
		appendable.decreaseIndentation();
		appendable.append("\n}");
		JvmOperation initializer = (JvmOperation) logicalContainerProvider.getLogicalContainer(createExtension
				.getExpression());
		appendable.append("\n").append(initializer.getSimpleName()).append("(").append(varName);
		for (XtendParameter xtendParameter : createExtension.getParameters()) {
			appendable.append(", ").append(xtendParameter.getName());
		}
		appendable.append(");");
		// return the result
		appendable.append("\nreturn ");
		appendable.append(varName).append(";");
		//		appendable.decreaseIndentation();
		//		appendable.append("\n}").closeScope();
		return appendable.toString();
	}

	protected Object cacheVarKey(CreateExtensionInfo createExtensionInfo) {
		return Tuples.pair("cache", createExtensionInfo);
	}

	/**
	 * TODO: we assume that names from the inferred JVM model are the same in the Java code. Does that assumption
	 * hold?
	 */
	protected String getVarName(JvmIdentifiableElement ex, IAppendable appendable) {
		return ex.getSimpleName();
	}
}