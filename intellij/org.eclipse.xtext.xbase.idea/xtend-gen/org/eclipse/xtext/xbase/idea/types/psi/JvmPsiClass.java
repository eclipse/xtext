/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.HierarchicalMethodSignature;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassInitializer;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiInvalidElementAccessException;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceList;
import com.intellij.psi.PsiSubstitutor;
import com.intellij.psi.PsiTypeParameter;
import com.intellij.psi.PsiTypeParameterList;
import com.intellij.psi.ResolveState;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.util.IncorrectOperationException;
import java.util.Collection;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class JvmPsiClass implements PsiClass {
  @Accessors
  private PsiClass stub;
  
  private PsiClass psiClass;
  
  @Accessors
  private Provider<PsiClass> psiClassProvider;
  
  @Delegate
  public synchronized PsiClass getDelegate() {
    PsiClass _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.psiClass, null);
      if (_equals) {
        try {
          PsiClass _get = this.psiClassProvider.get();
          this.psiClass = _get;
        } catch (final Throwable _t) {
          if (_t instanceof OperationCanceledError) {
            final OperationCanceledError e = (OperationCanceledError)_t;
            throw e.getWrapped();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = this.psiClass;
    }
    return _xblockexpression;
  }
  
  protected PsiClass getPsiClassOrStub() {
    PsiClass _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.psiClass, null));
    if (_notEquals) {
      _xifexpression = this.psiClass;
    } else {
      _xifexpression = this.stub;
    }
    return _xifexpression;
  }
  
  @Override
  public String getName() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.getName();
  }
  
  @Override
  public String getQualifiedName() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.getQualifiedName();
  }
  
  @Override
  public PsiModifierList getModifierList() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.getModifierList();
  }
  
  @Override
  public boolean hasModifierProperty(final String name) {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.hasModifierProperty(name);
  }
  
  @Override
  public boolean hasTypeParameters() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.hasTypeParameters();
  }
  
  @Override
  public PsiClass getContainingClass() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.getContainingClass();
  }
  
  @Override
  public PsiFile getContainingFile() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.getContainingFile();
  }
  
  @Override
  public boolean isInterface() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.isInterface();
  }
  
  @Override
  public boolean isEnum() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.isEnum();
  }
  
  @Override
  public boolean isAnnotationType() {
    PsiClass _psiClassOrStub = this.getPsiClassOrStub();
    return _psiClassOrStub.isAnnotationType();
  }
  
  @Override
  public boolean equals(final Object obj) {
    PsiClass _delegate = this.getDelegate();
    return _delegate.equals(obj);
  }
  
  @Override
  public int hashCode() {
    PsiClass _delegate = this.getDelegate();
    return _delegate.hashCode();
  }
  
  @Override
  public String toString() {
    Class<? extends JvmPsiClass> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = (_simpleName + ":");
    PsiClass _delegate = this.getDelegate();
    String _string = _delegate.toString();
    return (_plus + _string);
  }
  
  @Pure
  public PsiClass getStub() {
    return this.stub;
  }
  
  public void setStub(final PsiClass stub) {
    this.stub = stub;
  }
  
  @Pure
  public Provider<PsiClass> getPsiClassProvider() {
    return this.psiClassProvider;
  }
  
  public void setPsiClassProvider(final Provider<PsiClass> psiClassProvider) {
    this.psiClassProvider = psiClassProvider;
  }
  
  public PsiField findFieldByName(final String name, final boolean checkBases) {
    return this.getDelegate().findFieldByName(name, checkBases);
  }
  
  public PsiClass findInnerClassByName(final String name, final boolean checkBases) {
    return this.getDelegate().findInnerClassByName(name, checkBases);
  }
  
  public PsiMethod findMethodBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return this.getDelegate().findMethodBySignature(patternMethod, checkBases);
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> findMethodsAndTheirSubstitutorsByName(final String name, final boolean checkBases) {
    return this.getDelegate().findMethodsAndTheirSubstitutorsByName(name, checkBases);
  }
  
  public PsiMethod[] findMethodsByName(final String name, final boolean checkBases) {
    return this.getDelegate().findMethodsByName(name, checkBases);
  }
  
  public PsiMethod[] findMethodsBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return this.getDelegate().findMethodsBySignature(patternMethod, checkBases);
  }
  
  public PsiField[] getAllFields() {
    return this.getDelegate().getAllFields();
  }
  
  public PsiClass[] getAllInnerClasses() {
    return this.getDelegate().getAllInnerClasses();
  }
  
  public PsiMethod[] getAllMethods() {
    return this.getDelegate().getAllMethods();
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> getAllMethodsAndTheirSubstitutors() {
    return this.getDelegate().getAllMethodsAndTheirSubstitutors();
  }
  
  public PsiMethod[] getConstructors() {
    return this.getDelegate().getConstructors();
  }
  
  public PsiReferenceList getExtendsList() {
    return this.getDelegate().getExtendsList();
  }
  
  public PsiClassType[] getExtendsListTypes() {
    return this.getDelegate().getExtendsListTypes();
  }
  
  public PsiField[] getFields() {
    return this.getDelegate().getFields();
  }
  
  public PsiReferenceList getImplementsList() {
    return this.getDelegate().getImplementsList();
  }
  
  public PsiClassType[] getImplementsListTypes() {
    return this.getDelegate().getImplementsListTypes();
  }
  
  public PsiClassInitializer[] getInitializers() {
    return this.getDelegate().getInitializers();
  }
  
  public PsiClass[] getInnerClasses() {
    return this.getDelegate().getInnerClasses();
  }
  
  public PsiClass[] getInterfaces() {
    return this.getDelegate().getInterfaces();
  }
  
  public PsiElement getLBrace() {
    return this.getDelegate().getLBrace();
  }
  
  public PsiMethod[] getMethods() {
    return this.getDelegate().getMethods();
  }
  
  public PsiIdentifier getNameIdentifier() {
    return this.getDelegate().getNameIdentifier();
  }
  
  public PsiElement getRBrace() {
    return this.getDelegate().getRBrace();
  }
  
  public PsiElement getScope() {
    return this.getDelegate().getScope();
  }
  
  public PsiClass getSuperClass() {
    return this.getDelegate().getSuperClass();
  }
  
  public PsiClassType[] getSuperTypes() {
    return this.getDelegate().getSuperTypes();
  }
  
  public PsiClass[] getSupers() {
    return this.getDelegate().getSupers();
  }
  
  public Collection<HierarchicalMethodSignature> getVisibleSignatures() {
    return this.getDelegate().getVisibleSignatures();
  }
  
  public boolean isInheritor(final PsiClass baseClass, final boolean checkDeep) {
    return this.getDelegate().isInheritor(baseClass, checkDeep);
  }
  
  public boolean isInheritorDeep(final PsiClass baseClass, final PsiClass classToByPass) {
    return this.getDelegate().isInheritorDeep(baseClass, classToByPass);
  }
  
  public PsiElement setName(final String name) throws IncorrectOperationException {
    return this.getDelegate().setName(name);
  }
  
  public void accept(final PsiElementVisitor visitor) {
    this.getDelegate().accept(visitor);
  }
  
  public void acceptChildren(final PsiElementVisitor visitor) {
    this.getDelegate().acceptChildren(visitor);
  }
  
  public PsiElement add(final PsiElement element) throws IncorrectOperationException {
    return this.getDelegate().add(element);
  }
  
  public PsiElement addAfter(final PsiElement element, final PsiElement anchor) throws IncorrectOperationException {
    return this.getDelegate().addAfter(element, anchor);
  }
  
  public PsiElement addBefore(final PsiElement element, final PsiElement anchor) throws IncorrectOperationException {
    return this.getDelegate().addBefore(element, anchor);
  }
  
  public PsiElement addRange(final PsiElement first, final PsiElement last) throws IncorrectOperationException {
    return this.getDelegate().addRange(first, last);
  }
  
  public PsiElement addRangeAfter(final PsiElement first, final PsiElement last, final PsiElement anchor) throws IncorrectOperationException {
    return this.getDelegate().addRangeAfter(first, last, anchor);
  }
  
  public PsiElement addRangeBefore(final PsiElement first, final PsiElement last, final PsiElement anchor) throws IncorrectOperationException {
    return this.getDelegate().addRangeBefore(first, last, anchor);
  }
  
  public void checkAdd(final PsiElement element) throws IncorrectOperationException {
    this.getDelegate().checkAdd(element);
  }
  
  public void checkDelete() throws IncorrectOperationException {
    this.getDelegate().checkDelete();
  }
  
  public PsiElement copy() {
    return this.getDelegate().copy();
  }
  
  public void delete() throws IncorrectOperationException {
    this.getDelegate().delete();
  }
  
  public void deleteChildRange(final PsiElement first, final PsiElement last) throws IncorrectOperationException {
    this.getDelegate().deleteChildRange(first, last);
  }
  
  public PsiElement findElementAt(final int offset) {
    return this.getDelegate().findElementAt(offset);
  }
  
  public PsiReference findReferenceAt(final int offset) {
    return this.getDelegate().findReferenceAt(offset);
  }
  
  public PsiElement[] getChildren() {
    return this.getDelegate().getChildren();
  }
  
  public PsiElement getContext() {
    return this.getDelegate().getContext();
  }
  
  public <T extends Object> T getCopyableUserData(final Key<T> key) {
    return this.getDelegate().getCopyableUserData(key);
  }
  
  public PsiElement getFirstChild() {
    return this.getDelegate().getFirstChild();
  }
  
  public Language getLanguage() {
    return this.getDelegate().getLanguage();
  }
  
  public PsiElement getLastChild() {
    return this.getDelegate().getLastChild();
  }
  
  public PsiManager getManager() {
    return this.getDelegate().getManager();
  }
  
  public PsiElement getNavigationElement() {
    return this.getDelegate().getNavigationElement();
  }
  
  public PsiElement getNextSibling() {
    return this.getDelegate().getNextSibling();
  }
  
  public ASTNode getNode() {
    return this.getDelegate().getNode();
  }
  
  public PsiElement getOriginalElement() {
    return this.getDelegate().getOriginalElement();
  }
  
  public PsiElement getParent() {
    return this.getDelegate().getParent();
  }
  
  public PsiElement getPrevSibling() {
    return this.getDelegate().getPrevSibling();
  }
  
  public Project getProject() throws PsiInvalidElementAccessException {
    return this.getDelegate().getProject();
  }
  
  public PsiReference getReference() {
    return this.getDelegate().getReference();
  }
  
  public PsiReference[] getReferences() {
    return this.getDelegate().getReferences();
  }
  
  public GlobalSearchScope getResolveScope() {
    return this.getDelegate().getResolveScope();
  }
  
  public int getStartOffsetInParent() {
    return this.getDelegate().getStartOffsetInParent();
  }
  
  public String getText() {
    return this.getDelegate().getText();
  }
  
  public int getTextLength() {
    return this.getDelegate().getTextLength();
  }
  
  public int getTextOffset() {
    return this.getDelegate().getTextOffset();
  }
  
  public TextRange getTextRange() {
    return this.getDelegate().getTextRange();
  }
  
  public SearchScope getUseScope() {
    return this.getDelegate().getUseScope();
  }
  
  public boolean isEquivalentTo(final PsiElement another) {
    return this.getDelegate().isEquivalentTo(another);
  }
  
  public boolean isPhysical() {
    return this.getDelegate().isPhysical();
  }
  
  public boolean isValid() {
    return this.getDelegate().isValid();
  }
  
  public boolean isWritable() {
    return this.getDelegate().isWritable();
  }
  
  public boolean processDeclarations(final PsiScopeProcessor processor, final ResolveState state, final PsiElement lastParent, final PsiElement place) {
    return this.getDelegate().processDeclarations(processor, state, lastParent, place);
  }
  
  public <T extends Object> void putCopyableUserData(final Key<T> key, final T value) {
    this.getDelegate().putCopyableUserData(key, value);
  }
  
  public PsiElement replace(final PsiElement newElement) throws IncorrectOperationException {
    return this.getDelegate().replace(newElement);
  }
  
  public boolean textContains(final char c) {
    return this.getDelegate().textContains(c);
  }
  
  public boolean textMatches(final CharSequence text) {
    return this.getDelegate().textMatches(text);
  }
  
  public boolean textMatches(final PsiElement element) {
    return this.getDelegate().textMatches(element);
  }
  
  public char[] textToCharArray() {
    return this.getDelegate().textToCharArray();
  }
  
  public <T extends Object> T getUserData(final Key<T> key) {
    return this.getDelegate().getUserData(key);
  }
  
  public <T extends Object> void putUserData(final Key<T> key, final T value) {
    this.getDelegate().putUserData(key, value);
  }
  
  public Icon getIcon(final int flags) {
    return this.getDelegate().getIcon(flags);
  }
  
  public PsiDocComment getDocComment() {
    return this.getDelegate().getDocComment();
  }
  
  public boolean isDeprecated() {
    return this.getDelegate().isDeprecated();
  }
  
  public ItemPresentation getPresentation() {
    return this.getDelegate().getPresentation();
  }
  
  public boolean canNavigate() {
    return this.getDelegate().canNavigate();
  }
  
  public boolean canNavigateToSource() {
    return this.getDelegate().canNavigateToSource();
  }
  
  public void navigate(final boolean requestFocus) {
    this.getDelegate().navigate(requestFocus);
  }
  
  public PsiTypeParameterList getTypeParameterList() {
    return this.getDelegate().getTypeParameterList();
  }
  
  public PsiTypeParameter[] getTypeParameters() {
    return this.getDelegate().getTypeParameters();
  }
}
