package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer;
import org.eclipse.xtext.xbase.controlflow.IEarlyExitComputer.ExitPoint;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  
  protected void _infer(final Model m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    final XBlockExpression e = m.getBlock();
    Resource _eResource = e.eResource();
    String _name = this.name(_eResource);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(e, _name);
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmAnnotationReference> _annotations = it.getAnnotations();
          JvmAnnotationReference _annotation = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toAnnotation(e, SuppressWarnings.class, "all");
          PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmAnnotationReference>operator_add(_annotations, _annotation);
          EList<JvmMember> _members = it.getMembers();
          JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, Void.TYPE);
          final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                it.setStatic(true);
                EList<JvmFormalParameter> _parameters = it.getParameters();
                JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, String.class);
                JvmTypeReference _addArrayTypeDimension = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.addArrayTypeDimension(_newTypeRef);
                JvmFormalParameter _parameter = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toParameter(e, "args", _addArrayTypeDimension);
                PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                boolean _containsReturn = PureXbaseJvmModelInferrer.this.containsReturn(e);
                boolean _not = (!_containsReturn);
                if (_not) {
                  final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                      public void apply(final ITreeAppendable it) {
                        ITreeAppendable _append = it.append("try {");
                        _append.increaseIndentation();
                        ITreeAppendable _trace = it.trace(e);
                        PureXbaseJvmModelInferrer.this.compile(e, _trace);
                        ITreeAppendable _decreaseIndentation = it.decreaseIndentation();
                        ITreeAppendable _newLine = _decreaseIndentation.newLine();
                        _newLine.append("} catch (Throwable t) {}");
                      }
                    };
                  PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
                } else {
                  final Procedure1<ITreeAppendable> _function_1 = new Procedure1<ITreeAppendable>() {
                      public void apply(final ITreeAppendable it) {
                        StringConcatenation _builder = new StringConcatenation();
                        _builder.append("try {");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("xbaseExpression();");
                        _builder.newLine();
                        _builder.append("} catch (Throwable t) {}");
                        _builder.newLine();
                        String _string = _builder.toString();
                        it.append(_string);
                      }
                    };
                  PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function_1);
                }
              }
            };
          JvmOperation _method = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "main", _newTypeRef, _function);
          PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
          boolean _containsReturn = PureXbaseJvmModelInferrer.this.containsReturn(e);
          if (_containsReturn) {
            EList<JvmMember> _members_1 = it.getMembers();
            JvmTypeReference _newTypeRef_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, Object.class);
            final Procedure1<JvmOperation> _function_1 = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  it.setStatic(true);
                  final Procedure1<ITreeAppendable> _function = new Procedure1<ITreeAppendable>() {
                      public void apply(final ITreeAppendable it) {
                        ITreeAppendable _append = it.append("if (Boolean.TRUE) ");
                        _append.increaseIndentation();
                        ITreeAppendable _trace = it.trace(e);
                        PureXbaseJvmModelInferrer.this.compile(e, _trace);
                        ITreeAppendable _decreaseIndentation = it.decreaseIndentation();
                        ITreeAppendable _newLine = _decreaseIndentation.newLine();
                        _newLine.append("return null;");
                      }
                    };
                  PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, _function);
                }
              };
            JvmOperation _method_1 = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "xbaseExpression", _newTypeRef_1, _function_1);
            PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
          }
        }
      };
    _accept.initializeLater(_function);
  }
  
  public String name(final Resource res) {
    URI _uRI = res.getURI();
    final String s = _uRI.lastSegment();
    int _length = s.length();
    int _length_1 = ".xbase".length();
    int _minus = (_length - _length_1);
    return s.substring(0, _minus);
  }
  
  public boolean containsReturn(final XExpression expr) {
    final Collection<ExitPoint> exitPoints = this.computer.getExitPoints(((XExpression) expr));
    for (final ExitPoint point : exitPoints) {
      XExpression _expression = point.getExpression();
      if ((_expression instanceof XReturnExpression)) {
        return true;
      }
    }
    return false;
  }
  
  public void compile(final XBlockExpression obj, final ITreeAppendable appendable) {
    appendable.increaseIndentation();
    JvmTypeReference _newTypeRef = this._jvmTypesBuilder.newTypeRef(obj, Void.TYPE);
    this.compiler.compile(obj, appendable, _newTypeRef);
    appendable.decreaseIndentation();
  }
  
  public void infer(final EObject m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    if (m instanceof Model) {
      _infer((Model)m, acceptor, prelinkingPhase);
    } else if (m != null) {
      _infer(m, acceptor, prelinkingPhase);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(m, acceptor, prelinkingPhase).toString());
    }
  }
}
