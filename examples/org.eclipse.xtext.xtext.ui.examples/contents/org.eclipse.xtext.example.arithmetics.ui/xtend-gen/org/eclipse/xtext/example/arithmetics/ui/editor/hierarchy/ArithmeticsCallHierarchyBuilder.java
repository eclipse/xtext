package org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.ui.editor.hierarchy.ArithmeticsCallHierarchyNodeLocationProvider;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocationProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;

@SuppressWarnings("all")
public class ArithmeticsCallHierarchyBuilder extends DefaultCallHierarchyBuilder {
  @Inject
  private ArithmeticsCallHierarchyNodeLocationProvider arithmeticsCallHierarchyNodeLocationProvider;
  
  @Override
  protected HierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
    return this.arithmeticsCallHierarchyNodeLocationProvider;
  }
  
  @Override
  protected IEObjectDescription getRootDeclaration(final IEObjectDescription declaration) {
    EClass _eClass = null;
    if (declaration!=null) {
      _eClass=declaration.getEClass();
    }
    boolean _isDefinition = this.isDefinition(_eClass);
    if (_isDefinition) {
      return declaration;
    }
    return null;
  }
  
  @Override
  protected IEObjectDescription getDeclaration(final IReferenceDescription reference) {
    EReference _eReference = null;
    if (reference!=null) {
      _eReference=reference.getEReference();
    }
    EClassifier _eType = null;
    if (_eReference!=null) {
      _eType=_eReference.getEType();
    }
    final EClassifier type = _eType;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof EClass) {
        boolean _isDefinition = this.isDefinition(((EClass)type));
        if (_isDefinition) {
          _matched=true;
          return super.getDeclaration(reference);
        }
      }
    }
    return null;
  }
  
  protected boolean isDefinition(final EClass type) {
    return EcoreUtil2.isAssignableFrom(ArithmeticsPackage.Literals.ABSTRACT_DEFINITION, type);
  }
}
