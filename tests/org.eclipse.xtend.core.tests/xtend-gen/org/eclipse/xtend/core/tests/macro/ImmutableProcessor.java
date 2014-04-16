package org.eclipse.xtend.core.tests.macro;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ImmutableProcessor implements TransformationParticipant<MutableClassDeclaration> {
  public void doTransform(final List<? extends MutableClassDeclaration> annotatedTargetElements, @Extension final TransformationContext context) {
    for (final MutableClassDeclaration clazz : annotatedTargetElements) {
      {
        final Iterable<? extends MutableFieldDeclaration> fields = clazz.getDeclaredFields();
        final Procedure1<MutableConstructorDeclaration> _function = new Procedure1<MutableConstructorDeclaration>() {
          public void apply(final MutableConstructorDeclaration it) {
            for (final MutableFieldDeclaration f : fields) {
              String _simpleName = f.getSimpleName();
              TypeReference _type = f.getType();
              it.addParameter(_simpleName, _type);
            }
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                {
                  for(final MutableFieldDeclaration f : fields) {
                    _builder.append("this.");
                    String _simpleName = f.getSimpleName();
                    _builder.append(_simpleName, "");
                    _builder.append(" = ");
                    String _simpleName_1 = f.getSimpleName();
                    _builder.append(_simpleName_1, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        clazz.addConstructor(_function);
        for (final MutableFieldDeclaration f : fields) {
          {
            f.setFinal(true);
            String _simpleName = f.getSimpleName();
            String _firstUpper = StringExtensions.toFirstUpper(_simpleName);
            final String getterName = ("get" + _firstUpper);
            final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
              public void apply(final MutableMethodDeclaration it) {
                TypeReference _type = f.getType();
                it.setReturnType(_type);
                final CompilationStrategy _function = new CompilationStrategy() {
                  public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("return ");
                    String _simpleName = f.getSimpleName();
                    _builder.append(_simpleName, "");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    return _builder;
                  }
                };
                it.setBody(_function);
              }
            };
            this.tryAddMethod(clazz, getterName, _function_1);
          }
        }
        final Procedure1<MutableMethodDeclaration> _function_1 = new Procedure1<MutableMethodDeclaration>() {
          public void apply(final MutableMethodDeclaration it) {
            TypeReference _primitiveInt = context.getPrimitiveInt();
            it.setReturnType(_primitiveInt);
            AnnotationReference _newAnnotationReference = context.newAnnotationReference(Override.class);
            it.addAnnotation(_newAnnotationReference);
            final CompilationStrategy _function = new CompilationStrategy() {
              public CharSequence compile(final CompilationStrategy.CompilationContext it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("final int prime = 31;");
                _builder.newLine();
                {
                  boolean _extendsSomethingWithProperHashCode = ImmutableProcessor.this.getExtendsSomethingWithProperHashCode(clazz);
                  if (_extendsSomethingWithProperHashCode) {
                    _builder.append("int result = super.hashCode();");
                    _builder.newLine();
                  } else {
                    _builder.append("int result = 1;");
                    _builder.newLine();
                  }
                }
                {
                  for(final MutableFieldDeclaration f : fields) {
                    {
                      TypeReference _type = f.getType();
                      TypeReference _primitiveBoolean = context.getPrimitiveBoolean();
                      boolean _equals = Objects.equal(_type, _primitiveBoolean);
                      if (_equals) {
                        _builder.append("result = prime * result + (");
                        String _simpleName = f.getSimpleName();
                        _builder.append(_simpleName, "");
                        _builder.append(" ? 1231 : 1237);");
                        _builder.newLineIfNotEmpty();
                      } else {
                        TypeReference _primitiveInt = context.getPrimitiveInt();
                        TypeReference _primitiveChar = context.getPrimitiveChar();
                        TypeReference _primitiveByte = context.getPrimitiveByte();
                        TypeReference _primitiveShort = context.getPrimitiveShort();
                        TypeReference _type_1 = f.getType();
                        boolean _contains = Collections.<TypeReference>unmodifiableSet(Sets.<TypeReference>newHashSet(_primitiveInt, _primitiveChar, _primitiveByte, _primitiveShort)).contains(_type_1);
                        if (_contains) {
                          _builder.append("result = prime * result + ");
                          String _simpleName_1 = f.getSimpleName();
                          _builder.append(_simpleName_1, "");
                          _builder.append(";");
                          _builder.newLineIfNotEmpty();
                        } else {
                          TypeReference _primitiveLong = context.getPrimitiveLong();
                          TypeReference _type_2 = f.getType();
                          boolean _equals_1 = Objects.equal(_primitiveLong, _type_2);
                          if (_equals_1) {
                            _builder.append("result = prime * result + (int) (");
                            String _simpleName_2 = f.getSimpleName();
                            _builder.append(_simpleName_2, "");
                            _builder.append(" ^ (");
                            String _simpleName_3 = f.getSimpleName();
                            _builder.append(_simpleName_3, "");
                            _builder.append(" >>> 32));");
                            _builder.newLineIfNotEmpty();
                          } else {
                            TypeReference _primitiveFloat = context.getPrimitiveFloat();
                            TypeReference _type_3 = f.getType();
                            boolean _equals_2 = Objects.equal(_primitiveFloat, _type_3);
                            if (_equals_2) {
                              _builder.append("result = prime * result + Float.floatToIntBits(");
                              String _simpleName_4 = f.getSimpleName();
                              _builder.append(_simpleName_4, "");
                              _builder.append(");");
                              _builder.newLineIfNotEmpty();
                            } else {
                              TypeReference _primitiveDouble = context.getPrimitiveDouble();
                              TypeReference _type_4 = f.getType();
                              boolean _equals_3 = Objects.equal(_primitiveDouble, _type_4);
                              if (_equals_3) {
                                _builder.append("result = prime * result + (int) (Double.doubleToLongBits(");
                                String _simpleName_5 = f.getSimpleName();
                                _builder.append(_simpleName_5, "");
                                _builder.append(") ^ (Double.doubleToLongBits(");
                                String _simpleName_6 = f.getSimpleName();
                                _builder.append(_simpleName_6, "");
                                _builder.append(") >>> 32));");
                                _builder.newLineIfNotEmpty();
                              } else {
                                _builder.append("result = prime * result + ((");
                                String _simpleName_7 = f.getSimpleName();
                                _builder.append(_simpleName_7, "");
                                _builder.append("== null) ? 0 : ");
                                String _simpleName_8 = f.getSimpleName();
                                _builder.append(_simpleName_8, "");
                                _builder.append(".hashCode());");
                                _builder.newLineIfNotEmpty();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("return result;");
                _builder.newLine();
                return _builder;
              }
            };
            it.setBody(_function);
          }
        };
        this.tryAddMethod(clazz, "hashCode", _function_1);
      }
    }
  }
  
  public boolean getExtendsSomethingWithProperHashCode(final MutableClassDeclaration declaration) {
    return false;
  }
  
  public MutableMethodDeclaration tryAddMethod(final MutableClassDeclaration it, final String name, final Procedure1<? super MutableMethodDeclaration> initializer) {
    MutableMethodDeclaration _elvis = null;
    MutableMethodDeclaration _findDeclaredMethod = it.findDeclaredMethod(name);
    if (_findDeclaredMethod != null) {
      _elvis = _findDeclaredMethod;
    } else {
      MutableMethodDeclaration _addMethod = it.addMethod(name, ((Procedure1<MutableMethodDeclaration>)initializer));
      _elvis = _addMethod;
    }
    return _elvis;
  }
}
