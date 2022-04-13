/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.macro;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.macro.RegisterGlobalsContext;
import org.eclipse.xtend.lib.macro.RegisterGlobalsParticipant;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AccessObjectProcessor implements TransformationParticipant<MutableClassDeclaration>, RegisterGlobalsParticipant<ClassDeclaration> {
  @Override
  public void doTransform(final List<? extends MutableClassDeclaration> annotatedSourceClasses, @Extension final TransformationContext ctx) {
    final Consumer<MutableClassDeclaration> _function = (MutableClassDeclaration it) -> {
      final Consumer<MutableFieldDeclaration> _function_1 = (MutableFieldDeclaration field) -> {
        MutableTypeDeclaration _declaringType = field.getDeclaringType();
        String _firstUpper = StringExtensions.toFirstUpper(field.getSimpleName());
        String _plus = ("get" + _firstUpper);
        final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it_1) -> {
          it_1.setReturnType(field.getType());
          final CompilationStrategy _function_3 = (CompilationStrategy.CompilationContext it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return this.");
            String _simpleName = field.getSimpleName();
            _builder.append(_simpleName);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          };
          it_1.setBody(_function_3);
        };
        _declaringType.addMethod(_plus, _function_2);
      };
      it.getDeclaredFields().forEach(_function_1);
      String _qualifiedName = it.getQualifiedName();
      int _length = it.getQualifiedName().length();
      int _length_1 = it.getSimpleName().length();
      int _minus = (_length - _length_1);
      final String pkg = _qualifiedName.substring(0, _minus);
      final TypeReference ser = ctx.newTypeReference(Serializable.class);
      if ((ser == null)) {
        ctx.addError(it, "Cannot find Serializable");
      }
      String _simpleName = it.getSimpleName();
      final String PVersionName = ((pkg + "P") + _simpleName);
      final MutableClassDeclaration p = ctx.findClass(PVersionName);
      if ((p == null)) {
        ctx.addError(it, (("Class " + PVersionName) + " not found"));
      }
      if (((p != null) && (ser != null))) {
        final LinkedList<TypeReference> pIfcs = new LinkedList<TypeReference>();
        pIfcs.add(ser);
        p.setImplementedInterfaces(pIfcs);
      }
      String _simpleName_1 = it.getSimpleName();
      final String GVersionName = ((pkg + "G") + _simpleName_1);
      final MutableClassDeclaration g = ctx.findClass(GVersionName);
      if ((g == null)) {
        ctx.addError(it, (("Class " + GVersionName) + " not found"));
      }
      if (((g != null) && (ser != null))) {
        final LinkedList<TypeReference> gIfcs = new LinkedList<TypeReference>();
        gIfcs.add(ser);
        g.setImplementedInterfaces(gIfcs);
      }
    };
    annotatedSourceClasses.forEach(_function);
  }

  @Override
  public void doRegisterGlobals(final List<? extends ClassDeclaration> annotatedSourceElements, @Extension final RegisterGlobalsContext ctx) {
    final Consumer<ClassDeclaration> _function = (ClassDeclaration it) -> {
      String _qualifiedName = it.getQualifiedName();
      int _length = it.getQualifiedName().length();
      int _length_1 = it.getSimpleName().length();
      int _minus = (_length - _length_1);
      final String pkg = _qualifiedName.substring(0, _minus);
      String _simpleName = it.getSimpleName();
      final String PVersionName = ((pkg + "P") + _simpleName);
      String _simpleName_1 = it.getSimpleName();
      final String GVersionName = ((pkg + "G") + _simpleName_1);
      ctx.registerClass(PVersionName);
      ctx.registerClass(GVersionName);
    };
    annotatedSourceElements.forEach(_function);
  }
}
