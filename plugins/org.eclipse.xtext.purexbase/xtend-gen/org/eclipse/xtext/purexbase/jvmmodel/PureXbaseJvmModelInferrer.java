package org.eclipse.xtext.purexbase.jvmmodel;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model.
 * Other Xtend models link against the JVM model rather than the source model. The JVM
 * model elements should be associated with their source element by means of the
 * {@link org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator}.</p>
 */
@SuppressWarnings("all")
public class PureXbaseJvmModelInferrer extends AbstractModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  protected void _infer(final Model m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    final XBlockExpression e = m.getBlock();
    Resource _eResource = e.eResource();
    String _name = this.name(_eResource);
    JvmGenericType _class = this._jvmTypesBuilder.toClass(e, _name);
    IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _inferredType = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.inferredType();
        final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmTypeReference> _exceptions = it.getExceptions();
            JvmTypeReference _newTypeRef = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.newTypeRef(e, Throwable.class);
            PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_exceptions, _newTypeRef);
            PureXbaseJvmModelInferrer.this._jvmTypesBuilder.setBody(it, e);
          }
        };
        JvmOperation _method = PureXbaseJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "myMethod", _inferredType, _function);
        PureXbaseJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
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
  
  public void infer(final EObject m, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    if (m instanceof Model) {
      _infer((Model)m, acceptor, prelinkingPhase);
      return;
    } else if (m != null) {
      _infer(m, acceptor, prelinkingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(m, acceptor, prelinkingPhase).toString());
    }
  }
}
