/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util.internal;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.macro.AbstractClassProcessor;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EmfAdaptableProcessor extends AbstractClassProcessor {
  @Override
  public void doRegisterGlobals(final ClassDeclaration annotatedClass, @Extension final RegisterGlobalsContext context) {
    String _adapterClassName = this.getAdapterClassName(annotatedClass);
    context.registerClass(_adapterClassName);
  }
  
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    String _adapterClassName = this.getAdapterClassName(annotatedClass);
    final MutableClassDeclaration adapterClass = context.findClass(_adapterClassName);
    final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(Notifier.class);
        it.addParameter("emfObject", _newTypeReference);
        TypeReference _newTypeReference_1 = context.newTypeReference(annotatedClass);
        it.setReturnType(_newTypeReference_1);
        it.setStatic(true);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("for (");
            _builder.append(Adapter.class, "");
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
      }
    };
    annotatedClass.addMethod("findInEmfObject", _function);
    final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(Notifier.class);
        it.addParameter("emfObject", _newTypeReference);
        TypeReference _newTypeReference_1 = context.newTypeReference(annotatedClass);
        it.setReturnType(_newTypeReference_1);
        it.setStatic(true);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append(List.class, "");
            _builder.append("<");
            _builder.append(Adapter.class, "");
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
      }
    };
    annotatedClass.addMethod("removeFromEmfObject", _function_1);
    final Procedure1<MutableMethodDeclaration> _function_2 = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(Notifier.class);
        it.addParameter("emfObject", _newTypeReference);
        TypeReference _primitiveVoid = context.getPrimitiveVoid();
        it.setReturnType(_primitiveVoid);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            String _simpleName = annotatedClass.getSimpleName();
            _builder.append(_simpleName, "");
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
            _builder.append(adapterClass, "");
            _builder.append(" adapter = new ");
            _builder.append(adapterClass, "");
            _builder.append("(this);");
            _builder.newLineIfNotEmpty();
            _builder.append("emfObject.eAdapters().add(adapter);");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    annotatedClass.addMethod("attachToEmfObject", _function_2);
    TypeReference _newTypeReference = context.newTypeReference(AdapterImpl.class);
    adapterClass.setExtendedClass(_newTypeReference);
    final Procedure1<MutableFieldDeclaration> _function_3 = new Procedure1<MutableFieldDeclaration>() {
      @Override
      public void apply(final MutableFieldDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(annotatedClass);
        it.setType(_newTypeReference);
      }
    };
    adapterClass.addField("element", _function_3);
    final Procedure1<MutableConstructorDeclaration> _function_4 = new Procedure1<MutableConstructorDeclaration>() {
      @Override
      public void apply(final MutableConstructorDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(annotatedClass);
        it.addParameter("element", _newTypeReference);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("this.element = element;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    adapterClass.addConstructor(_function_4);
    final Procedure1<MutableMethodDeclaration> _function_5 = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        TypeReference _newTypeReference = context.newTypeReference(annotatedClass);
        it.setReturnType(_newTypeReference);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return this.element;");
            _builder.newLine();
          }
        };
        it.setBody(_client);
      }
    };
    adapterClass.addMethod("get", _function_5);
    final Procedure1<MutableMethodDeclaration> _function_6 = new Procedure1<MutableMethodDeclaration>() {
      @Override
      public void apply(final MutableMethodDeclaration it) {
        AnnotationReference _newAnnotationReference = context.newAnnotationReference(Override.class);
        it.addAnnotation(_newAnnotationReference);
        TypeReference _newTypeReference = context.newTypeReference(Object.class);
        it.addParameter("object", _newTypeReference);
        TypeReference _primitiveBoolean = context.getPrimitiveBoolean();
        it.setReturnType(_primitiveBoolean);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append("return object == ");
            _builder.append(annotatedClass, "");
            _builder.append(".class;");
            _builder.newLineIfNotEmpty();
          }
        };
        it.setBody(_client);
      }
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
