package org.eclipse.xtext.idea.types.psi;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.types.psi.PsiJvmDeclaredTypes;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmTypesElementFinder /* implements PsiElementFinder  */{
  @Inject
  @Extension
  private PsiJvmDeclaredTypes _psiJvmDeclaredTypes;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  private final /* Project */Object project;
  
  private final IXtextLanguage language;
  
  public JvmTypesElementFinder(final IXtextLanguage language, final /* Project */Object project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  public Object findClass(final String qualifiedName, final /* GlobalSearchScope */Object scope) {
    ArrayList<Object> _findClasses = this.findClasses(qualifiedName, scope);
    return IterableExtensions.<Object>head(_findClasses);
  }
  
  public ArrayList<Object> findClasses(final String qualifiedName, final /* GlobalSearchScope */Object scope) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method get is undefined for the type JvmTypesElementFinder"
      + "\nlanguage cannot be resolved"
      + "\n== cannot be resolved"
      + "\ngetPsiJvmDeclaredTypes cannot be resolved");
  }
}
