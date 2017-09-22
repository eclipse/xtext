/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
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
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.generator.trace.node.TracedAccessors;
import org.eclipse.xtext.generator.trace.node.TracingSugar;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TracedAccessorsProcessor extends AbstractClassProcessor {
  @Override
  public void doTransform(final MutableClassDeclaration annotatedClass, @Extension final TransformationContext context) {
    annotatedClass.setExtendedClass(context.newTypeReference(TracingSugar.class));
    final TypeReference iterableType = context.newTypeReference(Iterable.class, context.newWildcardTypeReference());
    final TypeReference annotationType = context.newTypeReference(TracedAccessors.class);
    AnnotationReference _findAnnotation = annotatedClass.findAnnotation(annotationType.getType());
    TypeReference[] _classArrayValue = null;
    if (_findAnnotation!=null) {
      _classArrayValue=_findAnnotation.getClassArrayValue("value");
    }
    final TypeReference[] factories = _classArrayValue;
    if ((factories == null)) {
      return;
    }
    final Function1<TypeReference, Type> _function = (TypeReference it) -> {
      return it.getType();
    };
    Iterable<InterfaceDeclaration> _filter = Iterables.<InterfaceDeclaration>filter(ListExtensions.<TypeReference, Type>map(((List<TypeReference>)Conversions.doWrapArray(factories)), _function), InterfaceDeclaration.class);
    for (final InterfaceDeclaration f : _filter) {
      final Function1<MethodDeclaration, Boolean> _function_1 = (MethodDeclaration it) -> {
        return Boolean.valueOf((it.getSimpleName().startsWith("create") && IterableExtensions.isEmpty(it.getParameters())));
      };
      final Function1<MethodDeclaration, TypeReference> _function_2 = (MethodDeclaration it) -> {
        return it.getReturnType();
      };
      Iterable<TypeReference> _map = IterableExtensions.map(IterableExtensions.filter(f.getDeclaredMethods(), _function_1), _function_2);
      for (final TypeReference t : _map) {
        final Function1<ResolvedMethod, Boolean> _function_3 = (ResolvedMethod it) -> {
          return Boolean.valueOf(this.isSupportedGetter(it));
        };
        final Function1<ResolvedMethod, Boolean> _function_4 = (ResolvedMethod it) -> {
          boolean _isAssignableFrom = iterableType.isAssignableFrom(it.getDeclaration().getReturnType());
          return Boolean.valueOf((!_isAssignableFrom));
        };
        Iterable<? extends ResolvedMethod> _filter_1 = IterableExtensions.filter(IterableExtensions.filter(t.getAllResolvedMethods(), _function_3), _function_4);
        for (final ResolvedMethod getter : _filter_1) {
          {
            final TypeReference rt = getter.getResolvedReturnType();
            boolean _contains = TracedAccessorsProcessor.TYPES_WITH_GOOD_TO_STRING.contains(rt.getType().getSimpleName().toLowerCase());
            if (_contains) {
              final Procedure1<MutableMethodDeclaration> _function_5 = (MutableMethodDeclaration it) -> {
                it.setReturnType(context.newTypeReference(IGeneratorNode.class));
                it.addParameter("target", t);
                StringConcatenationClient _client = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    _builder.append(EStructuralFeature.class);
                    _builder.append(" feature = target.eClass().getEStructuralFeature(\"");
                    String _featureName = TracedAccessorsProcessor.this.featureName(getter);
                    _builder.append(_featureName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append(ILocationData.class);
                    _builder.append(" location = this.location(target, feature, -1);");
                    _builder.newLineIfNotEmpty();
                    _builder.append(CompositeGeneratorNode.class);
                    _builder.append(" trace = this.trace(location);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("this.append(trace, target.");
                    String _simpleName = getter.getDeclaration().getSimpleName();
                    _builder.append(_simpleName);
                    _builder.append("());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("return trace;");
                    _builder.newLine();
                  }
                };
                it.setBody(_client);
              };
              annotatedClass.addMethod(this.tracerName(getter), _function_5);
              final Procedure1<MutableMethodDeclaration> _function_6 = (MutableMethodDeclaration it) -> {
                it.setReturnType(context.newTypeReference(IGeneratorNode.class));
                it.addParameter("target", t);
                it.addParameter("useForDebugging", context.newTypeReference(Boolean.TYPE));
                StringConcatenationClient _client = new StringConcatenationClient() {
                  @Override
                  protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                    _builder.append(EStructuralFeature.class);
                    _builder.append(" feature = target.eClass().getEStructuralFeature(\"");
                    String _featureName = TracedAccessorsProcessor.this.featureName(getter);
                    _builder.append(_featureName);
                    _builder.append("\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append(ILocationData.class);
                    _builder.append(" location = this.location(target, feature, -1);");
                    _builder.newLineIfNotEmpty();
                    _builder.append(CompositeGeneratorNode.class);
                    _builder.append(" trace = this.trace(location, useForDebugging);");
                    _builder.newLineIfNotEmpty();
                    _builder.append("this.append(trace, target.");
                    String _simpleName = getter.getDeclaration().getSimpleName();
                    _builder.append(_simpleName);
                    _builder.append("());");
                    _builder.newLineIfNotEmpty();
                    _builder.append("return trace;");
                    _builder.newLine();
                  }
                };
                it.setBody(_client);
              };
              annotatedClass.addMethod(this.tracerName(getter), _function_6);
            }
            final Procedure1<MutableMethodDeclaration> _function_7 = (MutableMethodDeclaration it) -> {
              it.setReturnType(context.newTypeReference(IGeneratorNode.class));
              it.addParameter("target", t);
              final TypeReference stringProvider = context.newTypeReference(Function.class, rt, context.getString());
              it.addParameter("stringProvider", stringProvider);
              StringConcatenationClient _client = new StringConcatenationClient() {
                @Override
                protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                  _builder.append(EStructuralFeature.class);
                  _builder.append(" feature = target.eClass().getEStructuralFeature(\"");
                  String _featureName = TracedAccessorsProcessor.this.featureName(getter);
                  _builder.append(_featureName);
                  _builder.append("\");");
                  _builder.newLineIfNotEmpty();
                  _builder.append(ILocationData.class);
                  _builder.append(" location = this.location(target, feature, -1);");
                  _builder.newLineIfNotEmpty();
                  _builder.append(CompositeGeneratorNode.class);
                  _builder.append(" trace = this.trace(location);");
                  _builder.newLineIfNotEmpty();
                  _builder.append("this.append(trace, stringProvider.apply(target.");
                  String _simpleName = getter.getDeclaration().getSimpleName();
                  _builder.append(_simpleName);
                  _builder.append("()));");
                  _builder.newLineIfNotEmpty();
                  _builder.append("return trace;");
                  _builder.newLine();
                }
              };
              it.setBody(_client);
            };
            annotatedClass.addMethod(this.tracerName(getter), _function_7);
          }
        }
      }
    }
  }
  
  public String tracerName(final ResolvedMethod m) {
    String _featureName = this.featureName(m);
    return ("_" + _featureName);
  }
  
  public String featureName(final ResolvedMethod m) {
    String _xblockexpression = null;
    {
      final String n = m.getDeclaration().getSimpleName();
      int _xifexpression = (int) 0;
      boolean _startsWith = n.startsWith("get");
      if (_startsWith) {
        _xifexpression = 3;
      } else {
        _xifexpression = 2;
      }
      final int skip = _xifexpression;
      _xblockexpression = StringExtensions.toFirstLower(m.getDeclaration().getSimpleName().substring(skip));
    }
    return _xblockexpression;
  }
  
  private final static Set<String> TYPES_WITH_GOOD_TO_STRING = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("string", "boolean", "int", "long", "integer"));
  
  public boolean isSupportedGetter(final ResolvedMethod it) {
    boolean _isEmpty = IterableExtensions.isEmpty(it.getDeclaration().getParameters());
    boolean _not = (!_isEmpty);
    if (_not) {
      return false;
    }
    boolean _isStatic = it.getDeclaration().isStatic();
    if (_isStatic) {
      return false;
    }
    final String n = it.getDeclaration().getSimpleName();
    String _qualifiedName = it.getDeclaration().getDeclaringType().getQualifiedName();
    String _name = Object.class.getName();
    boolean _equals = Objects.equal(_qualifiedName, _name);
    if (_equals) {
      return false;
    }
    return (n.startsWith("get") || n.startsWith("is"));
  }
}
