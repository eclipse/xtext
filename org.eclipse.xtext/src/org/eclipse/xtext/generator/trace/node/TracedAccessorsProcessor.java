/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class TracedAccessorsProcessor extends AbstractClassProcessor {

	private static final Set<String> TYPES_WITH_GOOD_TO_STRING = Collections
			.unmodifiableSet(Sets.newHashSet("string", "boolean", "int", "long", "integer"));

	@Override
	public void doTransform(MutableClassDeclaration annotatedClass, @Extension TransformationContext context) {
		annotatedClass.setExtendedClass(context.newTypeReference(TracingSugar.class));
		TypeReference iterableType = context.newTypeReference(Iterable.class, context.newWildcardTypeReference());
		TypeReference annotationType = context.newTypeReference(TracedAccessors.class);
		AnnotationReference annotation = annotatedClass.findAnnotation(annotationType.getType());
		TypeReference[] factories = annotation == null ? null : annotation.getClassArrayValue("value");
		if (factories == null)
			return;
		for (InterfaceDeclaration f : Iterables.filter(Lists.transform(Arrays.asList(factories), it -> it.getType()),
				InterfaceDeclaration.class)) {
			for (TypeReference t : FluentIterable.from(f.getDeclaredMethods())
					.filter(it -> it.getSimpleName().startsWith("create") && Iterables.isEmpty(it.getParameters()))
					.transform(MethodDeclaration::getReturnType)
					.toSortedList(Comparator.comparing(TypeReference::getSimpleName))) {
				for (ResolvedMethod getter : FluentIterable.from(t.getAllResolvedMethods())
						.filter(it -> isSupportedGetter(it))
						.filter(it -> !iterableType.isAssignableFrom(it.getDeclaration().getReturnType()))
						.toSortedList(Comparator.comparing(ResolvedMethod::getSimpleSignature))) {
					TypeReference rt = getter.getResolvedReturnType();
					if (TracedAccessorsProcessor.TYPES_WITH_GOOD_TO_STRING
							.contains(rt.getType().getSimpleName().toLowerCase())) {
						annotatedClass.addMethod(tracerName(getter), it -> {
							it.setReturnType(context.newTypeReference(IGeneratorNode.class));
							it.addParameter("target", t);
							it.setBody(new StringConcatenationClient() {
								@Override
								protected void appendTo(TargetStringConcatenation builder) {
									builder.append(EStructuralFeature.class);
									builder.append(" feature = target.eClass().getEStructuralFeature(\"");
									builder.append(TracedAccessorsProcessor.this.featureName(getter));
									builder.append("\");");
									builder.newLineIfNotEmpty();
									builder.append(ILocationData.class);
									builder.append(" location = this.location(target, feature, -1);");
									builder.newLineIfNotEmpty();
									builder.append(CompositeGeneratorNode.class);
									builder.append(" trace = this.trace(location);");
									builder.newLineIfNotEmpty();
									builder.append("this.append(trace, target.");
									builder.append(getter.getDeclaration().getSimpleName());
									builder.append("());");
									builder.newLineIfNotEmpty();
									builder.append("return trace;");
									builder.newLine();
								}
							});
						});
						annotatedClass.addMethod(tracerName(getter), it -> {
							it.setReturnType(context.newTypeReference(IGeneratorNode.class));
							it.addParameter("target", t);
							it.addParameter("useForDebugging", context.newTypeReference(Boolean.TYPE));
							it.setBody(new StringConcatenationClient() {
								@Override
								protected void appendTo(TargetStringConcatenation builder) {
									builder.append(EStructuralFeature.class);
									builder.append(" feature = target.eClass().getEStructuralFeature(\"");
									builder.append(TracedAccessorsProcessor.this.featureName(getter));
									builder.append("\");");
									builder.newLineIfNotEmpty();
									builder.append(ILocationData.class);
									builder.append(" location = this.location(target, feature, -1);");
									builder.newLineIfNotEmpty();
									builder.append(CompositeGeneratorNode.class);
									builder.append(" trace = this.trace(location, useForDebugging);");
									builder.newLineIfNotEmpty();
									builder.append("this.append(trace, target.");
									builder.append(getter.getDeclaration().getSimpleName());
									builder.append("());");
									builder.newLineIfNotEmpty();
									builder.append("return trace;");
									builder.newLine();
								}
							});
						});
					}
					annotatedClass.addMethod(this.tracerName(getter), (MutableMethodDeclaration it) -> {
						it.setReturnType(context.newTypeReference(IGeneratorNode.class));
						it.addParameter("target", t);
						it.addParameter("stringProvider",
								context.newTypeReference(Function.class, rt, context.getString()));
						it.setBody(new StringConcatenationClient() {
							@Override
							protected void appendTo(TargetStringConcatenation builder) {
								builder.append(EStructuralFeature.class);
								builder.append(" feature = target.eClass().getEStructuralFeature(\"");
								builder.append(TracedAccessorsProcessor.this.featureName(getter));
								builder.append("\");");
								builder.newLineIfNotEmpty();
								builder.append(ILocationData.class);
								builder.append(" location = this.location(target, feature, -1);");
								builder.newLineIfNotEmpty();
								builder.append(CompositeGeneratorNode.class);
								builder.append(" trace = this.trace(location);");
								builder.newLineIfNotEmpty();
								builder.append("this.append(trace, stringProvider.apply(target.");
								builder.append(getter.getDeclaration().getSimpleName());
								builder.append("()));");
								builder.newLineIfNotEmpty();
								builder.append("return trace;");
								builder.newLine();
							}
						});
					});
				}
			}
		}
	}

	public String tracerName(ResolvedMethod m) {
		return "_" + featureName(m);
	}

	public String featureName(ResolvedMethod m) {
		int skip = m.getDeclaration().getSimpleName().startsWith("get") ? 3 : 2;
		return StringExtensions.toFirstLower(m.getDeclaration().getSimpleName().substring(skip));
	}

	public boolean isSupportedGetter(ResolvedMethod it) {
		if (!IterableExtensions.isEmpty(it.getDeclaration().getParameters()))
			return false;
		if (it.getDeclaration().isStatic())
			return false;
		String n = it.getDeclaration().getSimpleName();
		if (Object.class.getName().equals(it.getDeclaration().getDeclaringType().getQualifiedName()))
			return false;
		return n.startsWith("get") || n.startsWith("is");
	}
}
