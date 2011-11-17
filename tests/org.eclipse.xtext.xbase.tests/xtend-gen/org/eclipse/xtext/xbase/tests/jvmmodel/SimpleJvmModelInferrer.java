package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SimpleJvmModelInferrer implements IJvmModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences references;
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmMember> _members = it.getMembers();
          JvmTypeReference _typeForName = SimpleJvmModelInferrer.this.references.getTypeForName(java.lang.String.class, e);
          final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
              public void apply(final JvmOperation it) {
                {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  JvmTypeReference _typeForName_1 = SimpleJvmModelInferrer.this.references.getTypeForName(java.lang.String.class, e);
                  JvmFormalParameter _parameter = SimpleJvmModelInferrer.this._jvmTypesBuilder.toParameter(e, "s", _typeForName_1);
                  CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                  SimpleJvmModelInferrer.this._jvmTypesBuilder.setBody(it, ((XExpression) e));
                }
              }
            };
          JvmOperation _method = SimpleJvmModelInferrer.this._jvmTypesBuilder.toMethod(e, "doStuff", _typeForName, _function);
          CollectionExtensions.<JvmOperation>operator_add(_members, _method);
        }
      };
    JvmGenericType _class = this._jvmTypesBuilder.toClass(((XExpression) e), "Test", _function);
    acceptor.accept(_class);
  }
}
