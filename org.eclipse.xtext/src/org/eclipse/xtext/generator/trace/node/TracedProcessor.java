/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

public class TracedProcessor extends AbstractMethodProcessor {
	@Override
	public void doTransform(MutableMethodDeclaration annotatedMethod, @Extension TransformationContext context) {
		boolean useForDebugging = annotatedMethod.findAnnotation(context.findTypeGlobally(Traced.class))
				.getBooleanValue("useForDebugging");
		TypeReference traceSugar = context.newTypeReference(TracingSugar.class);
		TypeReference templateClient = context.newTypeReference(StringConcatenationClient.class);
		TypeReference nodeType = context.newTypeReference(IGeneratorNode.class);
		TypeReference eobjectType = context.newTypeReference(EObject.class);
		MutableClassDeclaration clazz = (MutableClassDeclaration) annotatedMethod.getDeclaringType();
		MutableFieldDeclaration field = IterableExtensions.findFirst(clazz.getDeclaredFields(),
				it -> Boolean.valueOf(traceSugar.isAssignableFrom(it.getType())));
		if (field == null) {
			context.addError(annotatedMethod, "@" + Traced.class.getSimpleName()
					+ " methods can only declared in a class with a field of type " + TracingSugar.class);
			return;
		}
		MutableParameterDeclaration traceParam = IterableExtensions.findFirst(annotatedMethod.getParameters(),
				it -> eobjectType.isAssignableFrom(it.getType()));
		if (traceParam == null) {
			context.addError(annotatedMethod, "@" + Traced.class.getSimpleName()
					+ " methods need at least one parameter of type " + EObject.class + ".");
			return;
		}
		clazz.addMethod("_" + annotatedMethod.getSimpleName(), it -> {
			for (MutableParameterDeclaration p : annotatedMethod.getParameters())
				it.addParameter(p.getSimpleName(), p.getType());
			it.setReturnType(templateClient);
			it.setBody(annotatedMethod.getBody());
		});
		annotatedMethod.setReturnType(nodeType);
		annotatedMethod.setBody(new StringConcatenationClient() {
			@Override
			protected void appendTo(TargetStringConcatenation builder) {
				builder.append(ILocationData.class);
				builder.append(" _location = this.");
				builder.append(field.getSimpleName());
				builder.append(".location(");
				builder.append(traceParam.getSimpleName());
				builder.append(");");
				builder.newLineIfNotEmpty();
				builder.append(CompositeGeneratorNode.class);
				builder.append(" _traceNode = this.");
				builder.append(field.getSimpleName());
				builder.append(".trace(_location, ");
				builder.append(useForDebugging);
				builder.append(");");
				builder.newLineIfNotEmpty();
				builder.append("this.");
				builder.append(field.getSimpleName());
				builder.append(".appendTemplate(_traceNode, _");
				builder.append(annotatedMethod.getSimpleName());
				builder.append("(");
				builder.append(IterableExtensions.join(annotatedMethod.getParameters(), ",", it -> it.getSimpleName()));
				builder.append("));");
				builder.newLineIfNotEmpty();
				builder.append("return _traceNode;");
				builder.newLine();
			}
		});
	}
}
