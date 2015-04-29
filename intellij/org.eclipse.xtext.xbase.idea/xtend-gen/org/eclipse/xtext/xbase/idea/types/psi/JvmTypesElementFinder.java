/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFinder;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.xtext.common.types.access.impl.AbstractJvmTypeProvider;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JvmTypesElementFinder extends PsiElementFinder {
  @Inject
  private JvmPsiClasses jvmPsiClasses;
  
  private final Project project;
  
  private final IXtextLanguage language;
  
  public JvmTypesElementFinder(final IXtextLanguage language, final Project project) {
    language.injectMembers(this);
    this.project = project;
    this.language = language;
  }
  
  @Override
  public PsiClass findClass(final String qualifiedName, final GlobalSearchScope scope) {
    Iterable<PsiClass> _doFindClasses = this.doFindClasses(qualifiedName, scope);
    return IterableExtensions.<PsiClass>head(_doFindClasses);
  }
  
  @Override
  public PsiClass[] findClasses(final String qualifiedName, final GlobalSearchScope scope) {
    return ((PsiClass[])Conversions.unwrapArray(this.doFindClasses(qualifiedName, scope), PsiClass.class));
  }
  
  protected Iterable<PsiClass> doFindClasses(final String qualifiedName, final GlobalSearchScope scope) {
    Iterable<String> _variants = this.getVariants(qualifiedName);
    final Function1<String, Iterable<PsiClass>> _function = new Function1<String, Iterable<PsiClass>>() {
      @Override
      public Iterable<PsiClass> apply(final String variant) {
        QualifiedName _qualifiedName = JvmTypesElementFinder.this.toQualifiedName(variant);
        return JvmTypesElementFinder.this.jvmPsiClasses.getPsiClassesByQualifiedName(_qualifiedName, scope);
      }
    };
    Iterable<Iterable<PsiClass>> _map = IterableExtensions.<String, Iterable<PsiClass>>map(_variants, _function);
    Iterable<PsiClass> _flatten = Iterables.<PsiClass>concat(_map);
    final Function1<PsiClass, Boolean> _function_1 = new Function1<PsiClass, Boolean>() {
      @Override
      public Boolean apply(final PsiClass psiClass) {
        boolean _xblockexpression = false;
        {
          final PsiFile containingFile = psiClass.getContainingFile();
          boolean _xifexpression = false;
          if ((containingFile instanceof BaseXtextFile)) {
            Language _language = ((BaseXtextFile)containingFile).getLanguage();
            _xifexpression = Objects.equal(_language, JvmTypesElementFinder.this.language);
          }
          _xblockexpression = _xifexpression;
        }
        return Boolean.valueOf(_xblockexpression);
      }
    };
    return IterableExtensions.<PsiClass>filter(_flatten, _function_1);
  }
  
  protected Iterable<String> getVariants(final String qualifiedName) {
    final Iterable<String> _function = new Iterable<String>() {
      @Override
      public Iterator<String> iterator() {
        return new AbstractJvmTypeProvider.ClassNameVariants(qualifiedName);
      }
    };
    return Iterables.<String>concat(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(qualifiedName)), _function);
  }
  
  protected QualifiedName toQualifiedName(final String variant) {
    String[] _split = variant.split("\\.");
    return QualifiedName.create(_split);
  }
  
  @Override
  public Condition<PsiClass> getClassesFilter(final GlobalSearchScope scope) {
    final Condition<PsiClass> _function = new Condition<PsiClass>() {
      @Override
      public boolean value(final PsiClass psiClass) {
        if ((psiClass instanceof JvmPsiClass)) {
          return true;
        }
        String _qualifiedName = psiClass.getQualifiedName();
        PsiClass _findClass = JvmTypesElementFinder.this.findClass(_qualifiedName, scope);
        return Objects.equal(_findClass, null);
      }
    };
    return _function;
  }
}
