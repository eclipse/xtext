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
      Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
      final Consumer<MutableFieldDeclaration> _function_1 = (MutableFieldDeclaration field) -> {
        MutableTypeDeclaration _declaringType = field.getDeclaringType();
        String _simpleName = field.getSimpleName();
        String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
        String _plus = ("get" + _firstUpper);
        final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it_1) -> {
          TypeReference _type = field.getType();
          it_1.setReturnType(_type);
          final CompilationStrategy _function_3 = (CompilationStrategy.CompilationContext it_2) -> {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("return this.");
            String _simpleName_1 = field.getSimpleName();
            _builder.append(_simpleName_1, "");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            return _builder;
          };
          it_1.setBody(_function_3);
        };
        _declaringType.addMethod(_plus, _function_2);
      };
      _declaredFields.forEach(_function_1);
      String _qualifiedName = it.getQualifiedName();
      String _qualifiedName_1 = it.getQualifiedName();
      int _length = _qualifiedName_1.length();
      String _simpleName = it.getSimpleName();
      int _length_1 = _simpleName.length();
      int _minus = (_length - _length_1);
      final String pkg = _qualifiedName.substring(0, _minus);
      final TypeReference ser = ctx.newTypeReference(Serializable.class);
      if ((ser == null)) {
        ctx.addError(it, "Cannot find Serializable");
      }
      String _simpleName_1 = it.getSimpleName();
      final String PVersionName = ((pkg + "P") + _simpleName_1);
      final MutableClassDeclaration p = ctx.findClass(PVersionName);
      if ((p == null)) {
        ctx.addError(it, (("Class " + PVersionName) + " not found"));
      }
      if (((p != null) && (ser != null))) {
        final LinkedList<TypeReference> pIfcs = new LinkedList<TypeReference>();
        pIfcs.add(ser);
        p.setImplementedInterfaces(pIfcs);
      }
      String _simpleName_2 = it.getSimpleName();
      final String GVersionName = ((pkg + "G") + _simpleName_2);
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
      String _qualifiedName_1 = it.getQualifiedName();
      int _length = _qualifiedName_1.length();
      String _simpleName = it.getSimpleName();
      int _length_1 = _simpleName.length();
      int _minus = (_length - _length_1);
      final String pkg = _qualifiedName.substring(0, _minus);
      String _simpleName_1 = it.getSimpleName();
      final String PVersionName = ((pkg + "P") + _simpleName_1);
      String _simpleName_2 = it.getSimpleName();
      final String GVersionName = ((pkg + "G") + _simpleName_2);
      ctx.registerClass(PVersionName);
      ctx.registerClass(GVersionName);
    };
    annotatedSourceElements.forEach(_function);
  }
}
