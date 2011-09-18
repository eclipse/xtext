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
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class SimpleJvmModelInferrer extends AbstractModelInferrer {
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder0;
  
  @Inject
  private TypeReferences references;
  
  protected void _infer(final XExpression e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
        public Void apply(final JvmGenericType it) {
          Void _xblockexpression = null;
          {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeForName = SimpleJvmModelInferrer.this.references.getTypeForName(java.lang.String.class, e);
            final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                public Void apply(final JvmOperation it_1) {
                  {
                    EList<JvmFormalParameter> _parameters = it_1.getParameters();
                    JvmTypeReference _typeForName_1 = SimpleJvmModelInferrer.this.references.getTypeForName(java.lang.String.class, e);
                    JvmFormalParameter _parameter = SimpleJvmModelInferrer.this._jvmTypesBuilder0.toParameter(e, "s", _typeForName_1);
                    CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                    SimpleJvmModelInferrer.this._jvmTypesBuilder0.associate(e, it_1);
                  }
                  return null;
                }
              };
            JvmOperation _method = SimpleJvmModelInferrer.this._jvmTypesBuilder0.toMethod(e, "doStuff", _typeForName, _function_1);
            CollectionExtensions.<JvmMember>operator_add(_members, _method);
            _xblockexpression = (((Void) null));
          }
          return _xblockexpression;
        }
      };
    JvmGenericType _clazz = this._jvmTypesBuilder0.toClazz(e, "Test", _function);
    acceptor.accept(_clazz);
  }
  
  public void infer(final EObject e, final IAcceptor<JvmDeclaredType> acceptor, final boolean prelinkingPhase) {
    if ((e instanceof XExpression)) {
      _infer((XExpression)e, (IAcceptor<JvmDeclaredType>)acceptor, (Boolean)prelinkingPhase);
    } else {
      _infer((EObject)e, (IAcceptor<JvmDeclaredType>)acceptor, (Boolean)prelinkingPhase);
    }
  }
}