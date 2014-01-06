package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AccessObjectProcessor implements TransformationParticipant<MutableClassDeclaration>, RegisterGlobalsParticipant<ClassDeclaration> {
  public void doTransform(final List<? extends MutableClassDeclaration> annotatedSourceClasses, @Extension final TransformationContext ctx) {
    final Procedure1<MutableClassDeclaration> _function = new Procedure1<MutableClassDeclaration>() {
      public void apply(final MutableClassDeclaration it) {
        Iterable<? extends MutableFieldDeclaration> _declaredFields = it.getDeclaredFields();
        final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
          public void apply(final MutableFieldDeclaration field) {
            MutableTypeDeclaration _declaringType = field.getDeclaringType();
            String _simpleName = field.getSimpleName();
            String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
            String _plus = ("get" + _firstUpper);
            final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
              public void apply(final MutableMethodDeclaration it) {
                TypeReference _type = field.getType();
                it.setReturnType(_type);
                final CompilationStrategy _function = new CompilationStrategy() {
                  public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("return this.");
                    String _simpleName = field.getSimpleName();
                    _builder.append(_simpleName, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    return _builder;
                  }
                };
                it.setBody(_function);
              }
            };
            _declaringType.addMethod(_plus, _function);
          }
        };
        IterableExtensions.forEach(_declaredFields, _function);
        String _qualifiedName = it.getQualifiedName();
        String _qualifiedName_1 = it.getQualifiedName();
        int _length = _qualifiedName_1.length();
        String _simpleName = it.getSimpleName();
        int _length_1 = _simpleName.length();
        int _minus = (_length - _length_1);
        final String pkg = _qualifiedName.substring(0, _minus);
        final TypeReference ser = ctx.newTypeReference(Serializable.class);
        boolean _equals = Objects.equal(ser, null);
        if (_equals) {
          ctx.addError(it, "Cannot find Serializable");
        }
        String _simpleName_1 = it.getSimpleName();
        final String PVersionName = ((pkg + "P") + _simpleName_1);
        final MutableClassDeclaration p = ctx.findClass(PVersionName);
        boolean _equals_1 = Objects.equal(p, null);
        if (_equals_1) {
          ctx.addError(it, (("Class " + PVersionName) + " not found"));
        }
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(p, null));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _notEquals_1 = (!Objects.equal(ser, null));
          _and = (_notEquals && _notEquals_1);
        }
        if (_and) {
          final LinkedList<TypeReference> pIfcs = new LinkedList<TypeReference>();
          pIfcs.add(ser);
          p.setImplementedInterfaces(pIfcs);
        }
        String _simpleName_2 = it.getSimpleName();
        final String GVersionName = ((pkg + "G") + _simpleName_2);
        final MutableClassDeclaration g = ctx.findClass(GVersionName);
        boolean _equals_2 = Objects.equal(g, null);
        if (_equals_2) {
          ctx.addError(it, (("Class " + GVersionName) + " not found"));
        }
        boolean _and_1 = false;
        boolean _notEquals_2 = (!Objects.equal(g, null));
        if (!_notEquals_2) {
          _and_1 = false;
        } else {
          boolean _notEquals_3 = (!Objects.equal(ser, null));
          _and_1 = (_notEquals_2 && _notEquals_3);
        }
        if (_and_1) {
          final LinkedList<TypeReference> gIfcs = new LinkedList<TypeReference>();
          gIfcs.add(ser);
          g.setImplementedInterfaces(gIfcs);
        }
      }
    };
    IterableExtensions.forEach(annotatedSourceClasses, _function);
  }
  
  public void doRegisterGlobals(final List<? extends ClassDeclaration> annotatedSourceElements, @Extension final RegisterGlobalsContext ctx) {
    final Procedure1<ClassDeclaration> _function = new Procedure1<ClassDeclaration>() {
      public void apply(final ClassDeclaration it) {
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
      }
    };
    IterableExtensions.forEach(annotatedSourceElements, _function);
  }
}
