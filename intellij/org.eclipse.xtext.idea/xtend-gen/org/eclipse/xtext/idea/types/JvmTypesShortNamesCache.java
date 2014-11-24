package org.eclipse.xtext.idea.types;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.types.psi.PsiJvmDeclaredTypes;
import org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmTypesShortNamesCache /* implements PsiShortNamesCache  */{
  private final static Object/* type is 'null' */ NO_METHODS = Collections.<PsiMethod>unmodifiableList(CollectionLiterals.<PsiMethod>newArrayList());
  
  private final static Object/* type is 'null' */ NO_FIELDS = Collections.<PsiField>unmodifiableList(CollectionLiterals.<PsiField>newArrayList());
  
  @Inject
  @Extension
  private PsiJvmDeclaredTypes _psiJvmDeclaredTypes;
  
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  private final /* Project */Object project;
  
  private final IXtextLanguage language;
  
  public JvmTypesShortNamesCache(final IXtextLanguage language, final /* Project */Object project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  public Object getAllClassNames() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getAllKeys is undefined for the type JvmTypesShortNamesCache");
  }
  
  public Object getAllClassNames(final /* HashSet<String> */Object dest) {
    throw new Error("Unresolved compilation problems:"
      + "\n+= cannot be resolved");
  }
  
  public Object getAllFieldNames() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ArrayUtil is undefined for the type JvmTypesShortNamesCache"
      + "\nEMPTY_STRING_ARRAY cannot be resolved");
  }
  
  public Object getAllFieldNames(final /* HashSet<String> */Object set) {
    return null;
  }
  
  public Object getAllMethodNames() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ArrayUtil is undefined for the type JvmTypesShortNamesCache"
      + "\nEMPTY_STRING_ARRAY cannot be resolved");
  }
  
  public Object getAllMethodNames(final /* HashSet<String> */Object set) {
    return null;
  }
  
  public ArrayList<Object> getClassesByName(final String name, final /* GlobalSearchScope */Object scope) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method get is undefined for the type JvmTypesShortNamesCache"
      + "\nlanguage cannot be resolved"
      + "\n== cannot be resolved"
      + "\ngetPsiJvmDeclaredTypesByName cannot be resolved");
  }
  
  public PsiField getFieldsByName(final String name, final /* GlobalSearchScope */Object scope) {
    return JvmTypesShortNamesCache.NO_FIELDS;
  }
  
  public PsiField getFieldsByNameIfNotMoreThan(final String name, final /* GlobalSearchScope */Object scope, final int maxCount) {
    return JvmTypesShortNamesCache.NO_FIELDS;
  }
  
  public PsiMethod getMethodsByName(final String name, final /* GlobalSearchScope */Object scope) {
    return JvmTypesShortNamesCache.NO_METHODS;
  }
  
  public PsiMethod getMethodsByNameIfNotMoreThan(final String name, final /* GlobalSearchScope */Object scope, final int maxCount) {
    return JvmTypesShortNamesCache.NO_METHODS;
  }
  
  public Object processMethodsWithName(final String name, final /* GlobalSearchScope */Object scope, final /* Processor<PsiMethod> */Object processor) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ContainerUtil is undefined for the type JvmTypesShortNamesCache"
      + "\nprocess cannot be resolved");
  }
}
