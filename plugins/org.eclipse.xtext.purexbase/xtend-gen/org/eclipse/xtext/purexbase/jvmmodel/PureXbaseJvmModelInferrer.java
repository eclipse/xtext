package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
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
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer.ExitPoint;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model.
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link IJvmModelAssociator}.</p>
 */
@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private IEarlyExitComputer computer;
  
  @Inject
  private XbaseCompiler compiler;
  
  protected void _infer(final Model m, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
      XBlockExpression _block = m.getBlock();
      final XBlockExpression e = _block;
      Resource _eResource = e.eResource();
      String _name = this.name(_eResource);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            {
              EList<JvmAnnotationReference> _annotations = it.getAnnotations();
              JvmAnnotationReference _annotation = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toAnnotation(e, java.lang.SuppressWarnings.class, "all");
              CollectionExtensions.<JvmAnnotationReference>operator_add(_annotations, _annotation);
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, Void.TYPE);
              final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                  public void apply(final JvmOperation it) {
                    {
                      it.setStatic(true);
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, java.lang.String.class);
                      JvmTypeReference _addArrayTypeDimension = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.addArrayTypeDimension(_newTypeRef);
                      JvmFormalParameter _parameter = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toParameter(e, "args", _addArrayTypeDimension);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      boolean _containsReturn = PureXbaseJvmModelInferrer.this.containsReturn(e);
                      boolean _operator_not = BooleanExtensions.operator_not(_containsReturn);
                      if (_operator_not) {
                        final Function1<ImportManager,StringConcatenation> _function = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it) {
                              StringConcatenation _builder = new StringConcatenation();
                              _builder.append("try {");
                              String _compile = PureXbaseJvmModelInferrer.this.compile(e, it);
                              _builder.append(_compile, "");
                              _builder.newLineIfNotEmpty();
                              _builder.append("} catch (Throwable t) {}");
                              _builder.newLine();
                              return _builder;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
                      } else {
                        final Function1<ImportManager,StringConcatenation> _function_1 = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it) {
                              StringConcatenation _builder = new StringConcatenation();
                              _builder.append("try {");
                              _builder.newLine();
                              _builder.append("\t");
                              _builder.append("xbaseExpression();");
                              _builder.newLine();
                              _builder.append("} catch (Throwable t) {}");
                              _builder.newLine();
                              return _builder;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function_1);
                      }
                    }
                  }
                };
              JvmOperation _method = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "main", _newTypeRef, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members, _method);
              boolean _containsReturn = PureXbaseJvmModelInferrer.this.containsReturn(e);
              if (_containsReturn) {
                EList<JvmMember> _members_1 = it.getMembers();
                JvmTypeReference _newTypeRef_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, java.lang.Object.class);
                final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      {
                        it.setStatic(true);
                        final Function1<ImportManager,StringConcatenation> _function = new Function1<ImportManager,StringConcatenation>() {
                            public StringConcatenation apply(final ImportManager it) {
                              StringConcatenation _builder = new StringConcatenation();
                              _builder.append("if (Boolean.TRUE) {");
                              String _compile = PureXbaseJvmModelInferrer.this.compile(e, it);
                              _builder.append(_compile, "");
                              _builder.newLineIfNotEmpty();
                              _builder.append("}");
                              _builder.newLine();
                              _builder.append("return null;");
                              _builder.newLine();
                              return _builder;
                            }
                          };
                        PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
                      }
                    }
                  };
                JvmOperation _method_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "xbaseExpression", _newTypeRef_1, _function_1);
                CollectionExtensions.<JvmOperation>operator_add(_members_1, _method_1);
              }
            }
          }
        };
      JvmGenericType _class = this._jvmTypesBuilder.toClass(e, _name, _function);
      acceptor.accept(_class);
  }
  
  public String name(final Resource res) {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      final String s = _lastSegment;
      int _length = s.length();
      int _length_1 = ".xbase".length();
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_length), ((Integer)_length_1));
      String _substring = s.substring(0, _operator_minus);
      return _substring;
  }
  
  public boolean containsReturn(final XExpression expr) {
      Collection<ExitPoint> _exitPoints = this.computer.getExitPoints(((XExpression) expr));
      final Collection<ExitPoint> exitPoints = _exitPoints;
      for (final ExitPoint point : exitPoints) {
        XExpression _expression = point.getExpression();
        if ((_expression instanceof XReturnExpression)) {
          return true;
        }
      }
      return false;
  }
  
  public String compile(final XBlockExpression obj, final ImportManager mnr) {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(mnr, "\t");
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      appendable.increaseIndentation();
      JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(obj, Void.TYPE);
      this.compiler.compile(obj, appendable, _newTypeRef);
      String _string = appendable.toString();
      return _string;
  }
  
  public void infer(final EObject m, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    if (m instanceof Model) {
      _infer((Model)m, acceptor, prelinkingPhase);
    } else {
      _infer(m, acceptor, prelinkingPhase);
    }
  }
}
