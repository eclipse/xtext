package org.eclipse.xtend.lib.annotations;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.annotations.ValueObjectProcessor;
import org.eclipse.xtend.lib.annotations.Wither;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.Declaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.Synthetic;

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@SuppressWarnings("all")
public class WitherProcessor implements TransformationParticipant<MutableMemberDeclaration> {
  /**
   * @since 2.7
   */
  @Beta
  @GwtCompatible
  public static class Util {
    @Extension
    private TransformationContext context;
    
    public Util(final TransformationContext context) {
      this.context = context;
    }
    
    public boolean hasWither(final FieldDeclaration it) {
      TypeDeclaration _declaringType = it.getDeclaringType();
      String _witherName = this.getWitherName(it);
      TypeReference _type = it.getType();
      MethodDeclaration _findDeclaredMethod = _declaringType.findDeclaredMethod(_witherName, _type);
      return (_findDeclaredMethod != null);
    }
    
    public String getWitherName(final FieldDeclaration it) {
      String _simpleName = it.getSimpleName();
      String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
      return ("with" + _firstUpper);
    }
    
    public void addWither(final MutableFieldDeclaration field, final Iterable<? extends FieldDeclaration> constructorFields) {
      TypeReference _type = field.getType();
      boolean _isInferred = _type.isInferred();
      if (_isInferred) {
        this.context.addError(field, "Type cannot be inferred.");
        return;
      }
      boolean _isStatic = field.isStatic();
      if (_isStatic) {
        this.context.addError(field, "Cannot add a Wither for a static field");
        return;
      }
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      final MutableClassDeclaration cls = ((MutableClassDeclaration) _declaringType);
      String _witherName = this.getWitherName(field);
      final Procedure1<MutableMethodDeclaration> _function = new Procedure1<MutableMethodDeclaration>() {
        public void apply(final MutableMethodDeclaration it) {
          AnnotationReference _newAnnotationReference = Util.this.context.newAnnotationReference(Pure.class);
          it.addAnnotation(_newAnnotationReference);
          TypeReference _newSelfTypeReference = Util.this.context.newSelfTypeReference(cls);
          it.setReturnType(_newSelfTypeReference);
          String _simpleName = field.getSimpleName();
          TypeReference _type = field.getType();
          final MutableParameterDeclaration param = it.addParameter(_simpleName, _type);
          final ArrayList<Declaration> constructorArguments = CollectionLiterals.<Declaration>newArrayList();
          for (final FieldDeclaration otherField : constructorFields) {
            boolean _equals = Objects.equal(field, otherField);
            if (_equals) {
              constructorArguments.add(param);
            } else {
              constructorArguments.add(otherField);
            }
          }
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append("return new ");
              TypeReference _newSelfTypeReference = Util.this.context.newSelfTypeReference(cls);
              _builder.append(_newSelfTypeReference, "");
              _builder.append("(");
              final Function1<Declaration, String> _function = new Function1<Declaration, String>() {
                public String apply(final Declaration it) {
                  return it.getSimpleName();
                }
              };
              String _join = IterableExtensions.<Declaration>join(constructorArguments, ", ", _function);
              _builder.append(_join, "");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
            }
          };
          it.setBody(_client);
        }
      };
      cls.addMethod(_witherName, _function);
    }
  }
  
  public void doTransform(final List<? extends MutableMemberDeclaration> elements, @Extension final TransformationContext context) {
    final Procedure1<MutableMemberDeclaration> _function = new Procedure1<MutableMemberDeclaration>() {
      public void apply(final MutableMemberDeclaration it) {
        WitherProcessor.this.transform(it, context);
      }
    };
    IterableExtensions.forEach(elements, _function);
  }
  
  protected void _transform(final MutableClassDeclaration cls, @Extension final TransformationContext context) {
    @Extension
    final WitherProcessor.Util util = new WitherProcessor.Util(context);
    @Extension
    final ValueObjectProcessor.Util voUtil = new ValueObjectProcessor.Util(context);
    Iterable<? extends MutableFieldDeclaration> _valueObjectConstructorFields = voUtil.getValueObjectConstructorFields(cls);
    final Procedure1<MutableFieldDeclaration> _function = new Procedure1<MutableFieldDeclaration>() {
      public void apply(final MutableFieldDeclaration it) {
        boolean _hasWither = util.hasWither(it);
        boolean _not = (!_hasWither);
        if (_not) {
          Iterable<? extends MutableFieldDeclaration> _valueObjectConstructorFields = voUtil.getValueObjectConstructorFields(cls);
          util.addWither(it, _valueObjectConstructorFields);
        }
      }
    };
    IterableExtensions.forEach(_valueObjectConstructorFields, _function);
  }
  
  protected void _transform(final MutableFieldDeclaration it, @Extension final TransformationContext context) {
    @Extension
    final WitherProcessor.Util util = new WitherProcessor.Util(context);
    @Extension
    final ValueObjectProcessor.Util voUtil = new ValueObjectProcessor.Util(context);
    boolean _hasWither = util.hasWither(it);
    if (_hasWither) {
      Type _findTypeGlobally = context.findTypeGlobally(Wither.class);
      final AnnotationReference annotation = it.findAnnotation(_findTypeGlobally);
      context.addWarning(annotation, "A wither is already defined, this annotation has no effect");
    } else {
      MutableTypeDeclaration _declaringType = it.getDeclaringType();
      Iterable<? extends MutableFieldDeclaration> _valueObjectConstructorFields = voUtil.getValueObjectConstructorFields(_declaringType);
      util.addWither(it, _valueObjectConstructorFields);
    }
  }
  
  @Synthetic
  protected void transform(final MutableMemberDeclaration cls, final TransformationContext context) {
    if (cls instanceof MutableClassDeclaration) {
      _transform((MutableClassDeclaration)cls, context);
      return;
    } else if (cls instanceof MutableFieldDeclaration) {
      _transform((MutableFieldDeclaration)cls, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(cls, context).toString());
    }
  }
}
