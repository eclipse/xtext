/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EmfAdaptableProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    context.registerClass(this.getAdapterClassName(annotatedClass));
  }
  
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    final MutableClassDeclaration adapterClass = context.findClass(this.getAdapterClassName(annotatedClass));
    final Procedure1<MutableMethodDeclaration> _function = (MutableMethodDeclaration it) -> {
      it.addParameter("emfObject", context.newTypeReference(Notifier.class));
      it.setReturnType(context.newTypeReference(annotatedClass));
      it.setStatic(true);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("for (");
          _builder.append(Adapter.class);
          _builder.append(" adapter : emfObject.eAdapters()) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("if (adapter instanceof ");
          _builder.append(adapterClass, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("return ((");
          _builder.append(adapterClass, "\t\t");
          _builder.append(") adapter).get();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return null;");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("findInEmfObject", _function);
    final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
      it.addParameter("emfObject", context.newTypeReference(Notifier.class));
      it.setReturnType(context.newTypeReference(annotatedClass));
      it.setStatic(true);
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append(List.class);
          _builder.append("<");
          _builder.append(Adapter.class);
          _builder.append("> adapters = emfObject.eAdapters();");
          _builder.newLineIfNotEmpty();
          _builder.append("for(int i = 0, max = adapters.size(); i < max; i++) {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append(Adapter.class, "\t");
          _builder.append(" adapter = adapters.get(i);");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("if (adapter instanceof ");
          _builder.append(adapterClass, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("emfObject.eAdapters().remove(i);");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return ((");
          _builder.append(adapterClass, "\t\t");
          _builder.append(") adapter).get();");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.append("return null;");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("removeFromEmfObject", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
      it.addParameter("emfObject", context.newTypeReference(Notifier.class));
      it.setReturnType(context.getPrimitiveVoid());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          String _simpleName = annotatedClass.getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" result = findInEmfObject(emfObject);");
          _builder.newLineIfNotEmpty();
          _builder.append("if (result != null)");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("throw new IllegalStateException(\"The given EMF object already contains an adapter for ");
          String _simpleName_1 = annotatedClass.getSimpleName();
          _builder.append(_simpleName_1, "\t");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
          _builder.append(adapterClass);
          _builder.append(" adapter = new ");
          _builder.append(adapterClass);
          _builder.append("(this);");
          _builder.newLineIfNotEmpty();
          _builder.append("emfObject.eAdapters().add(adapter);");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    annotatedClass.addMethod("attachToEmfObject", _function_2);
    adapterClass.setExtendedClass(context.newTypeReference(AdapterImpl.class));
    final Procedure1<MutableFieldDeclaration> _function_3 = (MutableFieldDeclaration it) -> {
      it.setType(context.newTypeReference(annotatedClass));
    };
    adapterClass.addField("element", _function_3);
    final Procedure1<MutableConstructorDeclaration> _function_4 = (MutableConstructorDeclaration it) -> {
      it.addParameter("element", context.newTypeReference(annotatedClass));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("this.element = element;");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    adapterClass.addConstructor(_function_4);
    final Procedure1<MutableMethodDeclaration> _function_5 = (MutableMethodDeclaration it) -> {
      it.setReturnType(context.newTypeReference(annotatedClass));
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("return this.element;");
          _builder.newLine();
        }
      };
      it.setBody(_client);
    };
    adapterClass.addMethod("get", _function_5);
    final Procedure1<MutableMethodDeclaration> _function_6 = (MutableMethodDeclaration it) -> {
      it.addAnnotation(context.newAnnotationReference(Override.class));
      it.addParameter("object", context.newTypeReference(Object.class));
      it.setReturnType(context.getPrimitiveBoolean());
      StringConcatenationClient _client = new StringConcatenationClient() {
        @Override
        protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
          _builder.append("return object == ");
          _builder.append(annotatedClass);
          _builder.append(".class;");
          _builder.newLineIfNotEmpty();
        }
      };
      it.setBody(_client);
    };
    adapterClass.addMethod("isAdapterForType", _function_6);
  }
  
  public String getAdapterClassName(final ClassDeclaration declaration) {
    String _qualifiedName = declaration.getQualifiedName();
    String _plus = (_qualifiedName + ".");
    String _simpleName = declaration.getSimpleName();
    String _plus_1 = (_plus + _simpleName);
    return (_plus_1 + "Adapter");
  }
}
