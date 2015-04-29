/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.impl.XtextFileAwareEObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClasses;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class StubBasedJvmPsiClass implements JvmPsiClass {
  @Inject
  private JvmPsiClasses jvmPsiClasses;
  
  @Inject
  @Extension
  private IPsiModelAssociations _iPsiModelAssociations;
  
  private JvmPsiClass delegate;
  
  @Accessors
  private IEObjectDescription objectDescription;
  
  @Delegate
  public synchronized JvmPsiClass getDelegate() {
    JvmPsiClass _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.delegate, null);
      if (_equals) {
        BaseXtextFile _xtextFile = this.getXtextFile();
        XtextResource _resource = _xtextFile.getResource();
        PsiElement _psiElement = this._iPsiModelAssociations.getPsiElement(this.objectDescription, _resource);
        this.delegate = ((JvmPsiClass) _psiElement);
      }
      _xblockexpression = this.delegate;
    }
    return _xblockexpression;
  }
  
  @Override
  public EClass getType() {
    return this.objectDescription.getEClass();
  }
  
  @Override
  public String getQualifiedName() {
    QualifiedName _qualifiedName = this.objectDescription.getQualifiedName();
    String _string = _qualifiedName.toString();
    return _string.replace("$", ".");
  }
  
  @Override
  public String getName() {
    QualifiedName _qualifiedName = this.objectDescription.getQualifiedName();
    return this.jvmPsiClasses.getShortName(_qualifiedName);
  }
  
  @Override
  public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
    return this.getXtextFile();
  }
  
  @Override
  public Project getProject() throws PsiInvalidElementAccessException {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getProject();
  }
  
  @Override
  public PsiManager getManager() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getManager();
  }
  
  public BaseXtextFile getXtextFile() {
    BaseXtextFile _xifexpression = null;
    if ((this.objectDescription instanceof XtextFileAwareEObjectDescription)) {
      _xifexpression = ((XtextFileAwareEObjectDescription)this.objectDescription).getXtextFile();
    }
    return _xifexpression;
  }
  
  @Override
  public String toString() {
    String _simpleName = StubBasedJvmPsiClass.class.getSimpleName();
    String _plus = (_simpleName + ":");
    String _qualifiedName = this.getQualifiedName();
    return (_plus + _qualifiedName);
  }
  
  @Pure
  public IEObjectDescription getObjectDescription() {
    return this.objectDescription;
  }
  
  public void setObjectDescription(final IEObjectDescription objectDescription) {
    this.objectDescription = objectDescription;
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
  
  public PsiClass getContainingClass() {
    return this.getDelegate().getContainingClass();
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
  
  public boolean isAnnotationType() {
    return this.getDelegate().isAnnotationType();
  }
  
  public boolean isEnum() {
    return this.getDelegate().isEnum();
  }
  
  public boolean isInheritor(final PsiClass baseClass, final boolean checkDeep) {
    return this.getDelegate().isInheritor(baseClass, checkDeep);
  }
  
  public boolean isInheritorDeep(final PsiClass baseClass, final PsiClass classToByPass) {
    return this.getDelegate().isInheritorDeep(baseClass, classToByPass);
  }
  
  public boolean isInterface() {
    return this.getDelegate().isInterface();
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
  
  public PsiModifierList getModifierList() {
    return this.getDelegate().getModifierList();
  }
  
  public boolean hasModifierProperty(final String name) {
    return this.getDelegate().hasModifierProperty(name);
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
  
  public boolean hasTypeParameters() {
    return this.getDelegate().hasTypeParameters();
  }
}
