package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer.ExitPoint;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer implements IJvmModelInferrer {
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder0;
  
  @Inject
  private IEarlyExitComputer computer;
  
  @Inject
  private XbaseCompiler compiler;
  
  protected void _infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor) {
  }
  
  protected void _infer(final Model m, final IAcceptor<JvmDeclaredType> acceptor) {
    {
      XBlockExpression _block = m.getBlock();
      final XBlockExpression e = _block;
      Resource _eResource = e.eResource();
      String _name = this.name(_eResource);
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.newTypeRef(e, Void.TYPE);
              final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it_1) {
                    Void _xblockexpression_1 = null;
                    {
                      it_1.setStatic(true);
                      EList<JvmFormalParameter> _parameters = it_1.getParameters();
                      JvmTypeReference _newTypeRef_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.newTypeRef(e, java.lang.String.class);
                      JvmTypeReference _addArrayTypeDimension = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.addArrayTypeDimension(_newTypeRef_1);
                      JvmFormalParameter _parameter = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.toParameter(e, "args", _addArrayTypeDimension);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      boolean _containsReturn = PureXbaseJvmModelInferrer.this.containsReturn(e);
                      boolean _operator_not = BooleanExtensions.operator_not(_containsReturn);
                      if (_operator_not) {
                        final Function1<ImportManager,StringConcatenation> _function_2 = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it_2) {
                              StringConcatenation _builder = new StringConcatenation();
                              _builder.append("try {");
                              _builder.newLine();
                              _builder.append("\t");
                              String _compile = PureXbaseJvmModelInferrer.this.compile(e, it_2);
                              _builder.append(_compile, "	");
                              _builder.newLineIfNotEmpty();
                              _builder.append("} catch (Throwable t) {}");
                              _builder.newLine();
                              return _builder;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.body(it_1, _function_2);
                      } else {
                        final Function1<ImportManager,StringConcatenation> _function_3 = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it_3) {
                              StringConcatenation _builder_1 = new StringConcatenation();
                              _builder_1.append("try {");
                              _builder_1.newLine();
                              _builder_1.append("\t");
                              _builder_1.append("xbaseExpression();");
                              _builder_1.newLine();
                              _builder_1.append("} catch (Throwable t) {}");
                              _builder_1.newLine();
                              return _builder_1;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.body(it_1, _function_3);
                      }
                      _xblockexpression_1 = (null);
                    }
                    return _xblockexpression_1;
                  }
                };
              JvmOperation _method = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.toMethod(e, "main", _newTypeRef, _function_1);
              CollectionExtensions.<JvmMember>operator_add(_members, _method);
              boolean _containsReturn_1 = PureXbaseJvmModelInferrer.this.containsReturn(e);
              if (_containsReturn_1) {
                EList<JvmMember> _members_1 = it.getMembers();
                JvmTypeReference _newTypeRef_2 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.newTypeRef(e, java.lang.Object.class);
                final Function1<JvmOperation,Void> _function_4 = new Function1<JvmOperation,Void>() {
                    public Void apply(final JvmOperation it_4) {
                      Void _xblockexpression_2 = null;
                      {
                        it_4.setStatic(true);
                        final Function1<ImportManager,StringConcatenation> _function_5 = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it_5) {
                              StringConcatenation _builder_2 = new StringConcatenation();
                              _builder_2.append("if (Boolean.TRUE) {");
                              _builder_2.newLine();
                              _builder_2.append("\t");
                              String _compile_1 = PureXbaseJvmModelInferrer.this.compile(e, it_5);
                              _builder_2.append(_compile_1, "	");
                              _builder_2.newLineIfNotEmpty();
                              _builder_2.append("}");
                              _builder_2.newLine();
                              _builder_2.append("return null;");
                              _builder_2.newLine();
                              return _builder_2;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.body(it_4, _function_5);
                        _xblockexpression_2 = (null);
                      }
                      return _xblockexpression_2;
                    }
                  };
                JvmOperation _method_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder0.toMethod(e, "xbaseExpression", _newTypeRef_2, _function_4);
                CollectionExtensions.<JvmMember>operator_add(_members_1, _method_1);
              }
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this._jvmTypesBuilder0.toClazz(e, _name, _function);
      acceptor.accept(_clazz);
    }
  }
  
  public String name(final Resource res) {
    {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      final String s = _lastSegment;
      int _length = s.length();
      int _length_1 = ".xbase".length();
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)_length_1));
      String _substring = s.substring(0, _operator_minus);
      return _substring;
    }
  }
  
  public boolean containsReturn(final XExpression expr) {
    {
      Collection<ExitPoint> _exitPoints = this.computer.getExitPoints(((XExpression) expr));
      final Collection<ExitPoint> exitPoints = _exitPoints;
      for (final ExitPoint point : exitPoints) {
        XExpression _expression = point.getExpression();
        if ((_expression instanceof org.eclipse.xtext.xbase.XReturnExpression)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public String compile(final XExpression obj, final ImportManager mnr) {
    {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(mnr);
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      this.compiler.toJavaStatement(((XExpression) obj), appendable, false);
      String _string = appendable.toString();
      return _string;
    }
  }
  
  public void infer(final EObject m, final IAcceptor<JvmDeclaredType> acceptor) {
    if ((m instanceof Model)
         && (acceptor instanceof IAcceptor)) {
      _infer((Model)m, (IAcceptor<JvmDeclaredType>)acceptor);
    } else if ((m instanceof EObject)
         && (acceptor instanceof IAcceptor)) {
      _infer((EObject)m, (IAcceptor<JvmDeclaredType>)acceptor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(m, acceptor).toString());
    }
  }
}