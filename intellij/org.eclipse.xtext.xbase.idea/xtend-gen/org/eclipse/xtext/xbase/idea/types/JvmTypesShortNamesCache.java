/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types;

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
import com.intellij.util.CommonProcessors;
import com.intellij.util.Processor;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.HashSet;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.idea.types.stubs.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class JvmTypesShortNamesCache extends PsiShortNamesCache {
  @Inject
  @Extension
  private JvmPsiClasses _jvmPsiClasses;
  
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
    CommonProcessors.CollectProcessor<String> _collectProcessor = new CommonProcessors.CollectProcessor<String>(dest);
    this.processAllClassNames(_collectProcessor);
  }
  
  @Override
  public boolean processAllClassNames(final Processor<String> processor) {
    return this.jvmDeclaredTypeShortNameIndex.processAllKeys(this.project, processor);
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
    ArrayList<PsiClass> _xblockexpression = null;
    {
      final Collection<BaseXtextFile> xtextFiles = this.jvmDeclaredTypeShortNameIndex.get(name, this.project, scope);
      boolean _isEmpty = xtextFiles.isEmpty();
      if (_isEmpty) {
        return PsiClass.EMPTY_ARRAY;
      }
      final ArrayList<PsiClass> result = CollectionLiterals.<PsiClass>newArrayList();
      for (final BaseXtextFile xtextFile : xtextFiles) {
        Language _language = xtextFile.getLanguage();
        boolean _equals = Objects.equal(_language, this.language);
        if (_equals) {
          Iterable<PsiClass> _psiClassesByName = this._jvmPsiClasses.getPsiClassesByName(xtextFile, name);
          Iterables.<PsiClass>addAll(result, _psiClassesByName);
        }
      }
      _xblockexpression = result;
    }
    return ((PsiClass[])Conversions.unwrapArray(_xblockexpression, PsiClass.class));
  }
  
  @Override
  public PsiField[] getFieldsByName(final String name, final GlobalSearchScope scope) {
    return PsiField.EMPTY_ARRAY;
  }
  
  @Override
  public PsiField[] getFieldsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return PsiField.EMPTY_ARRAY;
  }
  
  @Override
  public PsiMethod[] getMethodsByName(final String name, final GlobalSearchScope scope) {
    return PsiMethod.EMPTY_ARRAY;
  }
  
  @Override
  public PsiMethod[] getMethodsByNameIfNotMoreThan(final String name, final GlobalSearchScope scope, final int maxCount) {
    return PsiMethod.EMPTY_ARRAY;
  }
  
  @Override
  public boolean processMethodsWithName(final String name, final GlobalSearchScope scope, final Processor<PsiMethod> processor) {
    PsiMethod[] _methodsByName = this.getMethodsByName(name, scope);
    return ContainerUtil.<PsiMethod>process(_methodsByName, processor);
  }
}
