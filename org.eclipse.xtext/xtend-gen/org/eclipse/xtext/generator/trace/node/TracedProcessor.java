/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.macro.AbstractMethodProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.Traced;
import org.eclipse.xtext.generator.trace.node.TracingSugar;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TracedProcessor extends AbstractMethodProcessor {
  @Override
  public void doTransform(final MutableMethodDeclaration annotatedMethod, @Extension final TransformationContext context) {
    final boolean useForDebugging = annotatedMethod.findAnnotation(context.findTypeGlobally(Traced.class)).getBooleanValue("useForDebugging");
    final TypeReference traceSugar = context.newTypeReference(TracingSugar.class);
    final TypeReference templateClient = context.newTypeReference(StringConcatenationClient.class);
    final TypeReference nodeType = context.newTypeReference(IGeneratorNode.class);
    final TypeReference eobjectType = context.newTypeReference(EObject.class);
    MutableTypeDeclaration _declaringType = annotatedMethod.getDeclaringType();
    final MutableClassDeclaration clazz = ((MutableClassDeclaration) _declaringType);
    final Function1<MutableFieldDeclaration, Boolean> _function = (MutableFieldDeclaration it) -> {
      return Boolean.valueOf(traceSugar.isAssignableFrom(it.getType()));
    };
    final MutableFieldDeclaration field = IterableExtensions.findFirst(clazz.getDeclaredFields(), _function);
    if ((field == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@");
      String _simpleName = Traced.class.getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" methods can only declared in a class with a field of type ");
      _builder.append(TracingSugar.class);
      context.addError(annotatedMethod, _builder.toString());
      return;
    }
    final Function1<MutableParameterDeclaration, Boolean> _function_1 = (MutableParameterDeclaration it) -> {
      return Boolean.valueOf(eobjectType.isAssignableFrom(it.getType()));
    };
    final MutableParameterDeclaration traceParam = IterableExtensions.findFirst(annotatedMethod.getParameters(), _function_1);
    if ((traceParam == null)) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("@");
      String _simpleName_1 = Traced.class.getSimpleName();
      _builder_1.append(_simpleName_1);
      _builder_1.append(" methods need at least one parameter of type ");
      _builder_1.append(EObject.class);
      _builder_1.append(".");
      context.addError(annotatedMethod, _builder_1.toString());
      return;
    }
    String _simpleName_2 = annotatedMethod.getSimpleName();
    String _plus = ("_" + _simpleName_2);
    final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
      Iterable<? extends MutableParameterDeclaration> _parameters = annotatedMethod.getParameters();
      for (final MutableParameterDeclaration p : _parameters) {
        it.addParameter(p.getSimpleName(), p.getType());
      }
      it.setReturnType(templateClient);
      it.setBody(annotatedMethod.getBody());
    };
    clazz.addMethod(_plus, _function_2);
    annotatedMethod.setReturnType(nodeType);
    StringConcatenationClient _client = new StringConcatenationClient() {
      @Override
      protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
        _builder.append(ILocationData.class);
        _builder.append(" _location = this.");
        String _simpleName = field.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(".location(");
        String _simpleName_1 = traceParam.getSimpleName();
        _builder.append(_simpleName_1);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append(CompositeGeneratorNode.class);
        _builder.append(" _traceNode = this.");
        String _simpleName_2 = field.getSimpleName();
        _builder.append(_simpleName_2);
        _builder.append(".trace(_location, ");
        _builder.append(useForDebugging);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("this.");
        String _simpleName_3 = field.getSimpleName();
        _builder.append(_simpleName_3);
        _builder.append(".appendTemplate(_traceNode, _");
        String _simpleName_4 = annotatedMethod.getSimpleName();
        _builder.append(_simpleName_4);
        _builder.append("(");
        final Function1<MutableParameterDeclaration, CharSequence> _function = (MutableParameterDeclaration it) -> {
          return it.getSimpleName();
        };
        String _join = IterableExtensions.join(annotatedMethod.getParameters(), ",", _function);
        _builder.append(_join);
        _builder.append("));");
        _builder.newLineIfNotEmpty();
        _builder.append("return _traceNode;");
        _builder.newLine();
      }
    };
    annotatedMethod.setBody(_client);
  }
}
