package org.eclipse.xtext.idea.types.psi;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.psi.PsiElement;
import java.util.ArrayList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class PsiJvmDeclaredTypes {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  public ArrayList<JvmPsiClass> getPsiJvmDeclaredTypesByName(final BaseXtextFile it, final String name) {
    ArrayList<JvmPsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<JvmPsiClass> result = CollectionLiterals.<JvmPsiClass>newArrayList();
      IResourceDescription _resourceDescription = it.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjectsByType = _resourceDescription.getExportedObjectsByType(TypesPackage.Literals.JVM_DECLARED_TYPE);
      for (final IEObjectDescription description : _exportedObjectsByType) {
        ResourceSet _resourceSet = resource.getResourceSet();
        URI _eObjectURI = description.getEObjectURI();
        EObject _eObject = _resourceSet.getEObject(_eObjectURI, true);
        final EObject jvmDeclaredType = _eObject;
        boolean _matched = false;
        if (!_matched) {
          if (jvmDeclaredType instanceof JvmDeclaredType) {
            String _simpleName = ((JvmDeclaredType)jvmDeclaredType).getSimpleName();
            boolean _equals = Objects.equal(_simpleName, name);
            if (_equals) {
              _matched=true;
              PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(jvmDeclaredType);
              result.add(((JvmPsiClass) _psiElement));
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public ArrayList<JvmPsiClass> getPsiJvmDeclaredTypes(final BaseXtextFile it, final QualifiedName qualifiedName) {
    ArrayList<JvmPsiClass> _xblockexpression = null;
    {
      final Resource resource = it.getResource();
      final ArrayList<JvmPsiClass> result = CollectionLiterals.<JvmPsiClass>newArrayList();
      IResourceDescription _resourceDescription = it.getResourceDescription();
      Iterable<IEObjectDescription> _exportedObjects = _resourceDescription.getExportedObjects(TypesPackage.Literals.JVM_DECLARED_TYPE, qualifiedName, false);
      for (final IEObjectDescription description : _exportedObjects) {
        ResourceSet _resourceSet = resource.getResourceSet();
        URI _eObjectURI = description.getEObjectURI();
        EObject _eObject = _resourceSet.getEObject(_eObjectURI, true);
        final EObject jvmDeclaredType = _eObject;
        boolean _matched = false;
        if (!_matched) {
          if (jvmDeclaredType instanceof JvmDeclaredType) {
            _matched=true;
            PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(jvmDeclaredType);
            result.add(((JvmPsiClass) _psiElement));
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
