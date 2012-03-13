package org.eclipse.xtext.example.tutorial;

import com.google.inject.Inject;
import java.io.Serializable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TypesBuilderExercise implements IJvmModelInferrer {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  public void infer(final EObject sourceObject, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexingPhase) {
    JvmGenericType _class = this._jvmTypesBuilder.toClass(sourceObject, "EmptyClass");
    final IPostIndexingInitializing<JvmGenericType> initializable = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
        public void apply(final JvmDeclaredType emptyClass) {
          EList<JvmTypeReference> _superTypes = emptyClass.getSuperTypes();
          JvmTypeReference _newTypeRef = TypesBuilderExercise.this._jvmTypesBuilder.newTypeRef(sourceObject, Serializable.class);
          TypesBuilderExercise.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
        }
      };
    initializable.initializeLater(_function);
  }
}
