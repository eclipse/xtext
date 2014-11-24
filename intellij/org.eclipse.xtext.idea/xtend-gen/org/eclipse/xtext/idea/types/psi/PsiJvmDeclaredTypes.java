package org.eclipse.xtext.idea.types.psi;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import org.eclipse.xtext.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Extension;

@Singleton
@SuppressWarnings("all")
public class PsiJvmDeclaredTypes {
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  public ArrayList<JvmPsiClass> getPsiJvmDeclaredTypesByName(final BaseXtextFile it, final String name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method psiElement is undefined for the type PsiJvmDeclaredTypes");
  }
  
  public ArrayList<JvmPsiClass> getPsiJvmDeclaredTypes(final BaseXtextFile it, final QualifiedName qualifiedName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method psiElement is undefined for the type PsiJvmDeclaredTypes");
  }
}
