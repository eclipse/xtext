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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo;

import com.google.inject.Inject;

public class CacheMethodCompileStrategy implements Functions.Function1<ImportManager, CharSequence> {
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

	private JvmOperation initializerMethod;

	private JvmField cacheField;

	protected void init(CreateExtensionInfo createExtensionInfo, JvmField cacheField, JvmOperation initializerMethod) {
		this.createExtensionInfo = createExtensionInfo;
		this.initializerMethod = initializerMethod;
		this.cacheField = cacheField; 
	}

	public CharSequence apply(ImportManager importManager) {
		JvmOperation cacheMethod = (JvmOperation) logicalContainerProvider
				.getLogicalContainer(createExtensionInfo.getCreateExpression());
		StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable(importManager);
		JvmDeclaredType containerType = cacheMethod.getDeclaringType();
		JvmTypeReference listType = typeReferences.getTypeForName(ArrayList.class, containerType);
		JvmTypeReference collectonLiterals = typeReferences.getTypeForName(CollectionLiterals.class,
				containerType);
		String cacheVarName = cacheField.getSimpleName();
		String cacheKeyVarName = appendable.declareVariable("CacheKey", "_cacheKey");
		appendable.append("final ");
		typeReferenceSerializer.serialize(listType, containerType, appendable);
		appendable.append(cacheKeyVarName).append(" = ");
		typeReferenceSerializer.serialize(collectonLiterals, containerType, appendable);
		appendable.append(".newArrayList(");
		EList<JvmFormalParameter> list = cacheMethod.getParameters();
		for (Iterator<JvmFormalParameter> iterator = list.iterator(); iterator.hasNext();) {
			JvmFormalParameter jvmFormalParameter = iterator.next();
			appendable.append(getVarName(jvmFormalParameter));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// declare result variable
		JvmTypeReference returnType = typeProvider.getType(createExtensionInfo.getCreateExpression());
		appendable.append("\nfinal ");
		typeReferenceSerializer.serialize(returnType, containerType, appendable);
		String resultVarName = "_result";
		appendable.append(" ").append(resultVarName).append(";");
		// open synchronize block
		appendable.append("\nsynchronized (").append(cacheVarName).append(") {");
		appendable.increaseIndentation();
		// if the cache contains the key return the previously created object.
		appendable.append("\nif (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName)
				.append(")) {");
		appendable.increaseIndentation();
		appendable.append("\nreturn ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().append("\n}");
		
		// initialize the appendable
		appendable.declareVariable(cacheMethod.getDeclaringType(), "this");
		if (cacheMethod.getDeclaringType() instanceof JvmGenericType) {
			JvmTypeReference superClass = ((JvmGenericType)cacheMethod.getDeclaringType()).getExtendedClass();
			if (superClass != null) {
				appendable.declareVariable(superClass.getType(), "super");
			}
		}
		for (JvmFormalParameter p : cacheMethod.getParameters()) {
			appendable.declareVariable(p, p.getName());
		}
		
		// execute the creation
		compiler.toJavaStatement(createExtensionInfo.getCreateExpression(), appendable, true);
		appendable.append("\n");
		appendable.append(resultVarName).append(" = ");
		compiler.toJavaExpression(createExtensionInfo.getCreateExpression(), appendable);
		appendable.append(";");

		// store the newly created object in the cache
		appendable.append("\n").append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ")
				.append(resultVarName).append(");");

		// close synchronize block
		appendable.decreaseIndentation();
		appendable.append("\n}");
		appendable.append("\n").append(initializerMethod.getSimpleName()).append("(").append(resultVarName);
		for (JvmFormalParameter parameter : cacheMethod.getParameters()) {
			appendable.append(", ").append(parameter.getName());
		}
		appendable.append(");");
		// return the result
		appendable.append("\nreturn ");
		appendable.append(resultVarName).append(";");
		return appendable.toString();
	}

	protected String getVarName(JvmIdentifiableElement ex) {
		return ex.getSimpleName();
	}
}