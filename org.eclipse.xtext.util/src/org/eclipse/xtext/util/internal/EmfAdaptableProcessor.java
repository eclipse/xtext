/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.util.internal;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;

public class EmfAdaptableProcessor extends AbstractClassProcessor {
	@Override
	public void doRegisterGlobals(ClassDeclaration annotatedClass, @Extension RegisterGlobalsContext context) {
		context.registerClass(getAdapterClassName(annotatedClass));
	}

	@Override
	public void doTransform(MutableClassDeclaration annotatedClass, @Extension TransformationContext context) {
		MutableClassDeclaration adapterClass = context.findClass(getAdapterClassName(annotatedClass));
		annotatedClass.addMethod("findInEmfObject", it -> {
			it.addParameter("emfObject", context.newTypeReference(Notifier.class));
			it.setReturnType(context.newTypeReference(annotatedClass));
			it.setStatic(true);
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append("for (");
					builder.append(Adapter.class);
					builder.append(" adapter : emfObject.eAdapters()) {");
					builder.newLineIfNotEmpty();
					builder.append("\t");
					builder.append("if (adapter instanceof ");
					builder.append(adapterClass, "\t");
					builder.append(") {");
					builder.newLineIfNotEmpty();
					builder.append("\t\t");
					builder.append("return ((");
					builder.append(adapterClass, "\t\t");
					builder.append(") adapter).get();");
					builder.newLineIfNotEmpty();
					builder.append("\t");
					builder.append("}");
					builder.newLine();
					builder.append("}");
					builder.newLine();
					builder.append("return null;");
					builder.newLine();
				}
			});
		});
		annotatedClass.addMethod("removeFromEmfObject", it -> {
			it.addParameter("emfObject", context.newTypeReference(Notifier.class));
			it.setReturnType(context.newTypeReference(annotatedClass));
			it.setStatic(true);
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append(List.class);
					builder.append("<");
					builder.append(Adapter.class);
					builder.append("> adapters = emfObject.eAdapters();");
					builder.newLineIfNotEmpty();
					builder.append("for(int i = 0, max = adapters.size(); i < max; i++) {");
					builder.newLine();
					builder.append("\t");
					builder.append(Adapter.class, "\t");
					builder.append(" adapter = adapters.get(i);");
					builder.newLineIfNotEmpty();
					builder.append("\t");
					builder.append("if (adapter instanceof ");
					builder.append(adapterClass, "\t");
					builder.append(") {");
					builder.newLineIfNotEmpty();
					builder.append("\t\t");
					builder.append("emfObject.eAdapters().remove(i);");
					builder.newLine();
					builder.append("\t\t");
					builder.append("return ((");
					builder.append(adapterClass, "\t\t");
					builder.append(") adapter).get();");
					builder.newLineIfNotEmpty();
					builder.append("\t");
					builder.append("}");
					builder.newLine();
					builder.append("}");
					builder.newLine();
					builder.append("return null;");
					builder.newLine();
				}
			});
		});
		annotatedClass.addMethod("attachToEmfObject", it -> {
			it.addParameter("emfObject", context.newTypeReference(Notifier.class));
			it.setReturnType(context.getPrimitiveVoid());
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append(annotatedClass.getSimpleName());
					builder.append(" result = findInEmfObject(emfObject);");
					builder.newLineIfNotEmpty();
					builder.append("if (result != null)");
					builder.newLine();
					builder.append("\t");
					builder.append(
							"throw new IllegalStateException(\"The given EMF object already contains an adapter for ");
					builder.append(annotatedClass.getSimpleName(), "\t");
					builder.append("\");");
					builder.newLineIfNotEmpty();
					builder.append(adapterClass);
					builder.append(" adapter = new ");
					builder.append(adapterClass);
					builder.append("(this);");
					builder.newLineIfNotEmpty();
					builder.append("emfObject.eAdapters().add(adapter);");
					builder.newLine();
				}
			});
		});
		adapterClass.setExtendedClass(context.newTypeReference(AdapterImpl.class));
		adapterClass.addField("element", it -> it.setType(context.newTypeReference(annotatedClass)));
		adapterClass.addConstructor(it -> {
			it.addParameter("element", context.newTypeReference(annotatedClass));
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append("this.element = element;");
					builder.newLine();
				}
			});
		});
		adapterClass.addMethod("get", it -> {
			it.setReturnType(context.newTypeReference(annotatedClass));
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append("return this.element;");
					builder.newLine();
				}
			});
		});
		adapterClass.addMethod("isAdapterForType", it -> {
			it.addAnnotation(context.newAnnotationReference(Override.class));
			it.addParameter("object", context.newTypeReference(Object.class));
			it.setReturnType(context.getPrimitiveBoolean());
			it.setBody(new StringConcatenationClient() {
				@Override
				protected void appendTo(TargetStringConcatenation builder) {
					builder.append("return object == ");
					builder.append(annotatedClass);
					builder.append(".class;");
					builder.newLineIfNotEmpty();
				}
			});
		});
	}

	public String getAdapterClassName(ClassDeclaration declaration) {
		return declaration.getQualifiedName() + "." + declaration.getSimpleName() + "Adapter";
	}
}
