package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SimpleJvmModelInferrer implements IJvmModelInferrer {
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences references;
  
  public void infer(final EObject e, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    JvmGenericType _class = this._jvmTypesBuilder.toClass(((XExpression) e), "Test");
    IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      public void apply(final JvmGenericType it) {
        EList<JvmMember> _members = it.getMembers();
        JvmTypeReference _typeForName = SimpleJvmModelInferrer.this.references.getTypeForName(String.class, e);
        final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
          public void apply(final JvmOperation it) {
            EList<JvmFormalParameter> _parameters = it.getParameters();
            JvmTypeReference _typeForName = SimpleJvmModelInferrer.this.references.getTypeForName(String.class, e);
            JvmFormalParameter _parameter = SimpleJvmModelInferrer.this._jvmTypesBuilder.toParameter(e, "s", _typeForName);
            SimpleJvmModelInferrer.this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
            SimpleJvmModelInferrer.this._jvmTypesBuilder.setBody(it, ((XExpression) e));
          }
        };
        JvmOperation _method = SimpleJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "doStuff", _typeForName, _function);
        SimpleJvmModelInferrer.this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      }
    };
    _accept.initializeLater(_function);
  }
}
