package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.AbstractDefinition;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy.ArithmeticsCallHierarchyNodeLocationProvider;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

@SuppressWarnings("all")
public class ArithmeticsCallHierarchyBuilder extends DefaultCallHierarchyBuilder {
  @Inject
  private ArithmeticsCallHierarchyNodeLocationProvider arithmeticsCallHierarchyNodeLocationProvider;
  
  @Override
  protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.arithmeticsCallHierarchyNodeLocationProvider;
  }
  
  @Override
  protected IEObjectDescription findDeclaration(final URI objectURI) {
    final IEObjectDescription description = this.getDescription(objectURI);
    EClass _eClass = null;
    if (description!=null) {
      _eClass=description.getEClass();
    }
    boolean _isDefinition = this.isDefinition(_eClass);
    if (_isDefinition) {
      return description;
    }
    final IUnitOfWork<IEObjectDescription, EObject> _function = new IUnitOfWork<IEObjectDescription, EObject>() {
      @Override
      public IEObjectDescription exec(final EObject object) throws Exception {
        AbstractDefinition _containerOfType = EcoreUtil2.<AbstractDefinition>getContainerOfType(object, AbstractDefinition.class);
        return ArithmeticsCallHierarchyBuilder.this.getDescription(_containerOfType);
      }
    };
    return this.<IEObjectDescription>readOnly(objectURI, _function);
  }
  
  @Override
  protected boolean filterReference(final IReferenceDescription reference) {
    return ((reference != null) && this.isDefinition(reference.getEReference().getEType()));
  }
  
  protected boolean isDefinition(final EClassifier type) {
    return this.isAssignable(ArithmeticsPackage.Literals.ABSTRACT_DEFINITION, type);
  }
}
