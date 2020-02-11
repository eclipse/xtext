/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceInitializer;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.inject.Inject;

public class CacheMethodCompileStrategy implements Procedures.Procedure1<ITreeAppendable> {

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;

	@Inject
	private XbaseCompiler compiler;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	private CreateExtensionInfo createExtensionInfo;

	private JvmOperation initializerMethod;

	private JvmField cacheField;

	protected void init(CreateExtensionInfo createExtensionInfo, JvmField cacheField, JvmOperation initializerMethod) {
		this.createExtensionInfo = createExtensionInfo;
		this.initializerMethod = initializerMethod;
		this.cacheField = cacheField; 
	}

	@Override
	public void apply(ITreeAppendable appendable) {
		JvmOperation cacheMethod = (JvmOperation) logicalContainerProvider.getLogicalContainer(createExtensionInfo.getCreateExpression());
		JvmDeclaredType containerType = cacheMethod.getDeclaringType();
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(containerType);
		final ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, containerType);
		LightweightTypeReference listType = owner.newReferenceTo(ArrayList.class, new TypeReferenceInitializer<ParameterizedTypeReference>() {
			@Override
			public LightweightTypeReference enhance(ParameterizedTypeReference reference) {
				reference.addTypeArgument(owner.newWildcardTypeReference());
				return reference;
			}
		});
		String cacheVarName = cacheField.getSimpleName();
		String cacheKeyVarName = appendable.declareSyntheticVariable("CacheKey", "_cacheKey");
		appendable.append("final ").append(listType).append(" ").append(cacheKeyVarName)
			.append(" = ").append(CollectionLiterals.class).append(".newArrayList(");
		List<JvmFormalParameter> list = cacheMethod.getParameters();
		for (Iterator<JvmFormalParameter> iterator = list.iterator(); iterator.hasNext();) {
			JvmFormalParameter jvmFormalParameter = iterator.next();
			appendable.append(getVarName(jvmFormalParameter));
			if (iterator.hasNext()) {
				appendable.append(", ");
			}
		}
		appendable.append(");");
		// declare result variable
		LightweightTypeReference returnType = resolvedTypes.getActualType(initializerMethod.getParameters().get(0));
		if (returnType != null) {
			appendable.newLine().append("final ").append(returnType);
		} else {
			appendable.newLine().append("final Object");
		}
		String resultVarName = "_result";
		appendable.append(" ").append(resultVarName).append(";");
		// open synchronize block
		appendable.newLine().append("synchronized (").append(cacheVarName).append(") {");
		appendable.increaseIndentation();
		// if the cache contains the key return the previously created object.
		appendable.newLine().append("if (").append(cacheVarName).append(".containsKey(").append(cacheKeyVarName)
				.append(")) {");
		appendable.increaseIndentation();
		appendable.newLine().append("return ").append(cacheVarName).append(".get(").append(cacheKeyVarName).append(");");
		appendable.decreaseIndentation().newLine().append("}");
		
		// execute the creation
		compiler.toJavaStatement(createExtensionInfo.getCreateExpression(), appendable, true);
		appendable.newLine();
		appendable.append(resultVarName).append(" = ");
		compiler.toJavaExpression(createExtensionInfo.getCreateExpression(), appendable);
		appendable.append(";");

		// store the newly created object in the cache
		appendable.newLine().append(cacheVarName).append(".put(").append(cacheKeyVarName).append(", ");
		LightweightTypeReference fieldType = resolvedTypes.getActualType(cacheField);
		LightweightTypeReference declaredResultType = fieldType.getTypeArguments().get(1);
		boolean castRequired = false;
		if (!declaredResultType.isAssignableFrom(returnType)) {
			castRequired = true;
			appendable.append("(").append(declaredResultType).append(")");
		}
		appendable.append(resultVarName).append(");");

		// close synchronize block
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
		appendable.newLine().append(initializerMethod.getSimpleName()).append("(").append(resultVarName);
		for (JvmFormalParameter parameter : cacheMethod.getParameters()) {
			appendable.append(", ").append(parameter.getName());
		}
		appendable.append(");");
		// return the result
		appendable.newLine().append("return ");
		if (castRequired) {
			appendable.append("(").append(declaredResultType).append(")");
		}
		appendable.append(resultVarName).append(";");
	}

	protected String getVarName(JvmIdentifiableElement ex) {
		return ex.getSimpleName();
	}
}