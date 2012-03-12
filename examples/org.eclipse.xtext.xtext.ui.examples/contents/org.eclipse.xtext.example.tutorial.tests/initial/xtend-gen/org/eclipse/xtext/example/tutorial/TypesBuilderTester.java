package org.eclipse.xtext.example.tutorial;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.Serializable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.example.tutorial.MockSetup;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TypesBuilderTester implements IJvmModelInferrer {
  @Inject
  private MockSetup mock;
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  public void infer(final EObject it, final IJvmDeclaredTypeAcceptor acceptor, final boolean preIndexingPhase) {
    JvmGenericType _class = this._jvmTypesBuilder.toClass(it, "EmptyClass");
    IPostIndexingInitializing<JvmGenericType> _accept = acceptor.<JvmGenericType>accept(_class);
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
        public void apply(final JvmGenericType it) {
          EList<JvmTypeReference> _superTypes = it.getSuperTypes();
          JvmTypeReference _newTypeRef = TypesBuilderTester.this._jvmTypesBuilder.newTypeRef(it, Serializable.class);
          TypesBuilderTester.this._jvmTypesBuilder.<JvmTypeReference>operator_add(_superTypes, _newTypeRef);
        }
      };
    _accept.initializeLater(_function);
  }
  
  public void run() {
    this.mock.use(this);
  }
  
  public static void main(final String[] args) {
    XbaseStandaloneSetup _xbaseStandaloneSetup = new XbaseStandaloneSetup();
    final Injector injector = _xbaseStandaloneSetup.createInjectorAndDoEMFRegistration();
    TypesBuilderTester _instance = injector.<TypesBuilderTester>getInstance(TypesBuilderTester.class);
    _instance.run();
  }
}
