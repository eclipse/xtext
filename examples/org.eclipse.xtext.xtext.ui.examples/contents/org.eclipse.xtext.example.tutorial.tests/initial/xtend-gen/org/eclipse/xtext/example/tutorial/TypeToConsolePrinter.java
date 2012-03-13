package org.eclipse.xtext.example.tutorial;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage.Literals;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.example.tutorial.TypesBuilderExercise;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TypeToConsolePrinter implements IJvmDeclaredTypeAcceptor {
  @Inject
  private JvmModelGenerator _jvmModelGenerator;
  
  @Inject
  private TypesBuilderExercise exercise;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private Resource workingResource;
  
  private EObject createEObjectInNewResource() {
    final XtextResourceSet resourceSet = this.resourceSetProvider.get();
    Class<? extends Object> _class = this.getClass();
    resourceSet.setClasspathURIContext(_class);
    URI _createURI = URI.createURI("dummy.xmi");
    Resource _createResource = resourceSet.createResource(_createURI);
    this.workingResource = _createResource;
    final EObject result = EcoreUtil.create(Literals.EOBJECT);
    EList<EObject> _contents = this.workingResource.getContents();
    _contents.add(result);
    return result;
  }
  
  private void printToConsole() {
    EList<EObject> _contents = this.workingResource.getContents();
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
        public void apply(final EObject object) {
          boolean _matched = false;
          if (!_matched) {
            if (object instanceof JvmDeclaredType) {
              final JvmDeclaredType _jvmDeclaredType = (JvmDeclaredType)object;
              _matched=true;
              CharSequence _generateType = TypeToConsolePrinter.this._jvmModelGenerator.generateType(_jvmDeclaredType);
              InputOutput.<CharSequence>println(_generateType);
            }
          }
        }
      };
    IterableExtensions.<EObject>forEach(_contents, _function);
  }
  
  public static void main(final String[] args) {
    XbaseStandaloneSetup _xbaseStandaloneSetup = new XbaseStandaloneSetup();
    final Injector injector = _xbaseStandaloneSetup.createInjectorAndDoEMFRegistration();
    final TypeToConsolePrinter it = injector.<TypeToConsolePrinter>getInstance(TypeToConsolePrinter.class);
    final EObject object = it.createEObjectInNewResource();
    it.exercise.infer(object, it, false);
    it.printToConsole();
  }
  
  public <T extends JvmDeclaredType> IPostIndexingInitializing<T> accept(final T type) {
    boolean _notEquals = (!Objects.equal(type, null));
    if (_notEquals) {
      EList<EObject> _contents = this.workingResource.getContents();
      _contents.add(type);
    }
    final Procedure1<Procedure1<? super T>> _function = new Procedure1<Procedure1<? super T>>() {
        public void apply(final Procedure1<? super T> it) {
          boolean _notEquals = (!Objects.equal(type, null));
          if (_notEquals) {
            if (it!=null) it.apply(type);
          }
        }
      };
    return new IPostIndexingInitializing<T>() {
        public void initializeLater(Procedure1<? super T> lateInitialization) {
          _function.apply(lateInitialization);
        }
    };
  }
}
