package org.eclipse.xtext.idea.types;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiShortNamesCache;
import com.intellij.util.ArrayUtil;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.idea.types.psi.PsiJvmDeclaredTypes;
import org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmTypesShortNamesCache extends PsiShortNamesCache {
  private final static PsiMethod[] NO_METHODS = {};
  
  private final static PsiField[] NO_FIELDS = {};
  
  @Inject
  @Extension
  private PsiJvmDeclaredTypes _psiJvmDeclaredTypes;
  
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  private final Project project;
  
  private final IXtextLanguage language;
  
  public JvmTypesShortNamesCache(final IXtextLanguage language, final Project project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  @Override
  public String[] getAllClassNames() {
    return ((String[])Conversions.unwrapArray(this.jvmDeclaredTypeShortNameIndex.getAllKeys(this.project), String.class));
  }
  
  @Override
  public void getAllClassNames(final HashSet<String> dest) {
    String[] _allClassNames = this.getAllClassNames();
    Iterables.<String>addAll(dest, ((Iterable<? extends String>)Conversions.doWrapArray(_allClassNames)));
  }
  
  @Override
  public String[] getAllFieldNames() {
    return ArrayUtil.EMPTY_STRING_ARRAY;
  }
  
  @Override
  public void getAllFieldNames(final HashSet<String> set) {
  }
  
  @Override
  public String[] getAllMethodNames() {
    return ArrayUtil.EMPTY_STRING_ARRAY;
  }
  
  @Override
  public void getAllMethodNames(final HashSet<String> set) {
  }
  
  @Override
  public PsiClass[] getClassesByName(final String name, final GlobalSearchScope scope) {
    ArrayList<JvmPsiClass> _xblockexpression = null;
    {
      final ArrayList<JvmPsiClass> result = CollectionLiterals.<JvmPsiClass>newArrayList();
      final Collection<BaseXtextFile> xtextFiles = this.jvmDeclaredTypeShortNameIndex.get(name, this.project, scope);
      for (final BaseXtextFile xtextFile : xtextFiles) {
        Language _language = xtextFile.getLanguage();
        boolean _equals = Objects.equal(_language, this.language);
        if (_equals) {
          ArrayList<JvmPsiClass> _psiJvmDeclaredTypesByName = this._psiJvmDeclaredTypes.getPsiJvmDeclaredTypesByName(xtextFile, name);
          Iterables.<JvmPsiClass>addAll(result, _psiJvmDeclaredTypesByName);
        }
      }
      _xblockexpression = result;
    }
    return ((PsiClass[])Conversions.unwrapArray(_xblockexpression, PsiClass.class));
  }
  
  @Override
  public PsiField[] getFieldsByName(final String name, final GlobalSearchScope scope) {
    return JvmTypesShortNamesCache.NO_FIELDS;
  }
  
  @Override
  public PsiField[] getFieldsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return JvmTypesShortNamesCache.NO_FIELDS;
  }
  
  @Override
  public PsiMethod[] getMethodsByName(final String name, final GlobalSearchScope scope) {
    return JvmTypesShortNamesCache.NO_METHODS;
  }
  
  @Override
  public PsiMethod[] getMethodsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return JvmTypesShortNamesCache.NO_METHODS;
  }
  
  @Override
  public boolean processMethodsWithName(final String name, final GlobalSearchScope scope, final Processor<PsiMethod> processor) {
    PsiMethod[] _methodsByName = this.getMethodsByName(name, scope);
    return ContainerUtil.<PsiMethod>process(_methodsByName, processor);
  }
}
