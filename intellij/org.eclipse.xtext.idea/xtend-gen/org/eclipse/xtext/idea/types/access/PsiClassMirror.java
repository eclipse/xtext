package org.eclipse.xtext.idea.types.access;

import com.intellij.psi.PsiClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

@SuppressWarnings("all")
public class PsiClassMirror extends AbstractClassMirror {
  private final PsiClass psiClass;
  
  private final ITypeFactory<PsiClass, JvmDeclaredType> typeFactory;
  
  public PsiClassMirror(final PsiClass psiClass, final ITypeFactory<PsiClass, JvmDeclaredType> typeFactory) {
    this.psiClass = psiClass;
    this.typeFactory = typeFactory;
  }
  
  protected String getTypeName() {
    return this.psiClass.getQualifiedName();
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
