package org.eclipse.xtext.idea.types.access;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

@SuppressWarnings("all")
public class PsiClassMirror extends AbstractClassMirror {
  private final /* PsiClass */Object psiClass;
  
  private final /* ITypeFactory<PsiClass, JvmDeclaredType> */Object typeFactory;
  
  public PsiClassMirror(final /* PsiClass */Object psiClass, final /* ITypeFactory<PsiClass, JvmDeclaredType> */Object typeFactory) {
    this.psiClass = psiClass;
    this.typeFactory = typeFactory;
  }
  
  protected String getTypeName() {
    throw new Error("Unresolved compilation problems:"
      + "\nqualifiedName cannot be resolved");
  }
  
  public void initialize(final TypeResource typeResource) {
    EList<EObject> _contents = typeResource.getContents();
    JvmDeclaredType _createType = this.typeFactory.createType(this.psiClass);
    _contents.add(_createType);
  }
  
  public boolean isSealed() {
    return true;
  }
}
