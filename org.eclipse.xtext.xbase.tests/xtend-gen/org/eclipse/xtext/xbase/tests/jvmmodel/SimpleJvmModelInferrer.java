package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
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
  
  @Override
  public void infer(final EObject e, final IJvmDeclaredTypeAcceptor acceptor, final boolean prelinkingPhase) {
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmMember> _members = it.getMembers();
      final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(e, "s", this.references.getTypeForName(String.class, e));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        this._jvmTypesBuilder.setBody(it_1, ((XExpression) e));
      };
      JvmOperation _method = this._jvmTypesBuilder.toMethod(e, "doStuff", this.references.getTypeForName(String.class, e), _function_1);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(((XExpression) e), "Test"), _function);
  }
}
