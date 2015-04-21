/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.jvm;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.HierarchicalMethodSignature;
import com.intellij.psi.PsiAnonymousClass;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassInitializer;
import com.intellij.psi.PsiClassType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiExpressionList;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiInvalidElementAccessException;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMirrorElement;
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
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class JvmPsiAnonymousClass implements PsiAnonymousClass, PsiMirrorElement {
  @Delegate
  private final PsiAnonymousClass delegate;
  
  @Override
  public PsiElement getNavigationElement() {
    PsiElement _elvis = null;
    PsiElement _navigationElement = JvmPsiElementExtensions.getNavigationElement(this);
    if (_navigationElement != null) {
      _elvis = _navigationElement;
    } else {
      PsiElement _navigationElement_1 = this.delegate.getNavigationElement();
      _elvis = _navigationElement_1;
    }
    return _elvis;
  }
  
  @Override
  public PsiElement getPrototype() {
    return this;
  }
  
  public JvmPsiAnonymousClass(final PsiAnonymousClass delegate) {
    super();
    this.delegate = delegate;
  }
  
  public PsiExpressionList getArgumentList() {
    return this.delegate.getArgumentList();
  }
  
  public PsiJavaCodeReferenceElement getBaseClassReference() {
    return this.delegate.getBaseClassReference();
  }
  
  public PsiClassType getBaseClassType() {
    return this.delegate.getBaseClassType();
  }
  
  public boolean isInQualifiedNew() {
    return this.delegate.isInQualifiedNew();
  }
  
  public PsiField findFieldByName(final String name, final boolean checkBases) {
    return this.delegate.findFieldByName(name, checkBases);
  }
  
  public PsiClass findInnerClassByName(final String name, final boolean checkBases) {
    return this.delegate.findInnerClassByName(name, checkBases);
  }
  
  public PsiMethod findMethodBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return this.delegate.findMethodBySignature(patternMethod, checkBases);
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> findMethodsAndTheirSubstitutorsByName(final String name, final boolean checkBases) {
    return this.delegate.findMethodsAndTheirSubstitutorsByName(name, checkBases);
  }
  
  public PsiMethod[] findMethodsByName(final String name, final boolean checkBases) {
    return this.delegate.findMethodsByName(name, checkBases);
  }
  
  public PsiMethod[] findMethodsBySignature(final PsiMethod patternMethod, final boolean checkBases) {
    return this.delegate.findMethodsBySignature(patternMethod, checkBases);
  }
  
  public PsiField[] getAllFields() {
    return this.delegate.getAllFields();
  }
  
  public PsiClass[] getAllInnerClasses() {
    return this.delegate.getAllInnerClasses();
  }
  
  public PsiMethod[] getAllMethods() {
    return this.delegate.getAllMethods();
  }
  
  public List<Pair<PsiMethod, PsiSubstitutor>> getAllMethodsAndTheirSubstitutors() {
    return this.delegate.getAllMethodsAndTheirSubstitutors();
  }
  
  public PsiMethod[] getConstructors() {
    return this.delegate.getConstructors();
  }
  
  public PsiClass getContainingClass() {
    return this.delegate.getContainingClass();
  }
  
  public PsiReferenceList getExtendsList() {
    return this.delegate.getExtendsList();
  }
  
  public PsiClassType[] getExtendsListTypes() {
    return this.delegate.getExtendsListTypes();
  }
  
  public PsiField[] getFields() {
    return this.delegate.getFields();
  }
  
  public PsiReferenceList getImplementsList() {
    return this.delegate.getImplementsList();
  }
  
  public PsiClassType[] getImplementsListTypes() {
    return this.delegate.getImplementsListTypes();
  }
  
  public PsiClassInitializer[] getInitializers() {
    return this.delegate.getInitializers();
  }
  
  public PsiClass[] getInnerClasses() {
    return this.delegate.getInnerClasses();
  }
  
  public PsiClass[] getInterfaces() {
    return this.delegate.getInterfaces();
  }
  
  public PsiElement getLBrace() {
    return this.delegate.getLBrace();
  }
  
  public PsiMethod[] getMethods() {
    return this.delegate.getMethods();
  }
  
  public PsiIdentifier getNameIdentifier() {
    return this.delegate.getNameIdentifier();
  }
  
  public String getQualifiedName() {
    return this.delegate.getQualifiedName();
  }
  
  public PsiElement getRBrace() {
    return this.delegate.getRBrace();
  }
  
  public PsiElement getScope() {
    return this.delegate.getScope();
  }
  
  public PsiClass getSuperClass() {
    return this.delegate.getSuperClass();
  }
  
  public PsiClassType[] getSuperTypes() {
    return this.delegate.getSuperTypes();
  }
  
  public PsiClass[] getSupers() {
    return this.delegate.getSupers();
  }
  
  public Collection<HierarchicalMethodSignature> getVisibleSignatures() {
    return this.delegate.getVisibleSignatures();
  }
  
  public boolean isAnnotationType() {
    return this.delegate.isAnnotationType();
  }
  
  public boolean isEnum() {
    return this.delegate.isEnum();
  }
  
  public boolean isInheritor(final PsiClass baseClass, final boolean checkDeep) {
    return this.delegate.isInheritor(baseClass, checkDeep);
  }
  
  public boolean isInheritorDeep(final PsiClass baseClass, final PsiClass classToByPass) {
    return this.delegate.isInheritorDeep(baseClass, classToByPass);
  }
  
  public boolean isInterface() {
    return this.delegate.isInterface();
  }
  
  public PsiElement setName(final String name) throws IncorrectOperationException {
    return this.delegate.setName(name);
  }
  
  public String getName() {
    return this.delegate.getName();
  }
  
  public void accept(final PsiElementVisitor visitor) {
    this.delegate.accept(visitor);
  }
  
  public void acceptChildren(final PsiElementVisitor visitor) {
    this.delegate.acceptChildren(visitor);
  }
  
  public PsiElement add(final PsiElement element) throws IncorrectOperationException {
    return this.delegate.add(element);
  }
  
  public PsiElement addAfter(final PsiElement element, final PsiElement anchor) throws IncorrectOperationException {
    return this.delegate.addAfter(element, anchor);
  }
  
  public PsiElement addBefore(final PsiElement element, final PsiElement anchor) throws IncorrectOperationException {
    return this.delegate.addBefore(element, anchor);
  }
  
  public PsiElement addRange(final PsiElement first, final PsiElement last) throws IncorrectOperationException {
    return this.delegate.addRange(first, last);
  }
  
  public PsiElement addRangeAfter(final PsiElement first, final PsiElement last, final PsiElement anchor) throws IncorrectOperationException {
    return this.delegate.addRangeAfter(first, last, anchor);
  }
  
  public PsiElement addRangeBefore(final PsiElement first, final PsiElement last, final PsiElement anchor) throws IncorrectOperationException {
    return this.delegate.addRangeBefore(first, last, anchor);
  }
  
  public void checkAdd(final PsiElement element) throws IncorrectOperationException {
    this.delegate.checkAdd(element);
  }
  
  public void checkDelete() throws IncorrectOperationException {
    this.delegate.checkDelete();
  }
  
  public PsiElement copy() {
    return this.delegate.copy();
  }
  
  public void delete() throws IncorrectOperationException {
    this.delegate.delete();
  }
  
  public void deleteChildRange(final PsiElement first, final PsiElement last) throws IncorrectOperationException {
    this.delegate.deleteChildRange(first, last);
  }
  
  public PsiElement findElementAt(final int offset) {
    return this.delegate.findElementAt(offset);
  }
  
  public PsiReference findReferenceAt(final int offset) {
    return this.delegate.findReferenceAt(offset);
  }
  
  public PsiElement[] getChildren() {
    return this.delegate.getChildren();
  }
  
  public PsiFile getContainingFile() throws PsiInvalidElementAccessException {
    return this.delegate.getContainingFile();
  }
  
  public PsiElement getContext() {
    return this.delegate.getContext();
  }
  
  public <T extends Object> T getCopyableUserData(final Key<T> key) {
    return this.delegate.getCopyableUserData(key);
  }
  
  public PsiElement getFirstChild() {
    return this.delegate.getFirstChild();
  }
  
  public Language getLanguage() {
    return this.delegate.getLanguage();
  }
  
  public PsiElement getLastChild() {
    return this.delegate.getLastChild();
  }
  
  public PsiManager getManager() {
    return this.delegate.getManager();
  }
  
  public PsiElement getNextSibling() {
    return this.delegate.getNextSibling();
  }
  
  public ASTNode getNode() {
    return this.delegate.getNode();
  }
  
  public PsiElement getOriginalElement() {
    return this.delegate.getOriginalElement();
  }
  
  public PsiElement getParent() {
    return this.delegate.getParent();
  }
  
  public PsiElement getPrevSibling() {
    return this.delegate.getPrevSibling();
  }
  
  public Project getProject() throws PsiInvalidElementAccessException {
    return this.delegate.getProject();
  }
  
  public PsiReference getReference() {
    return this.delegate.getReference();
  }
  
  public PsiReference[] getReferences() {
    return this.delegate.getReferences();
  }
  
  public GlobalSearchScope getResolveScope() {
    return this.delegate.getResolveScope();
  }
  
  public int getStartOffsetInParent() {
    return this.delegate.getStartOffsetInParent();
  }
  
  public String getText() {
    return this.delegate.getText();
  }
  
  public int getTextLength() {
    return this.delegate.getTextLength();
  }
  
  public int getTextOffset() {
    return this.delegate.getTextOffset();
  }
  
  public TextRange getTextRange() {
    return this.delegate.getTextRange();
  }
  
  public SearchScope getUseScope() {
    return this.delegate.getUseScope();
  }
  
  public boolean isEquivalentTo(final PsiElement another) {
    return this.delegate.isEquivalentTo(another);
  }
  
  public boolean isPhysical() {
    return this.delegate.isPhysical();
  }
  
  public boolean isValid() {
    return this.delegate.isValid();
  }
  
  public boolean isWritable() {
    return this.delegate.isWritable();
  }
  
  public boolean processDeclarations(final PsiScopeProcessor processor, final ResolveState state, final PsiElement lastParent, final PsiElement place) {
    return this.delegate.processDeclarations(processor, state, lastParent, place);
  }
  
  public <T extends Object> void putCopyableUserData(final Key<T> key, final T value) {
    this.delegate.putCopyableUserData(key, value);
  }
  
  public PsiElement replace(final PsiElement newElement) throws IncorrectOperationException {
    return this.delegate.replace(newElement);
  }
  
  public boolean textContains(final char c) {
    return this.delegate.textContains(c);
  }
  
  public boolean textMatches(final CharSequence text) {
    return this.delegate.textMatches(text);
  }
  
  public boolean textMatches(final PsiElement element) {
    return this.delegate.textMatches(element);
  }
  
  public char[] textToCharArray() {
    return this.delegate.textToCharArray();
  }
  
  public <T extends Object> T getUserData(final Key<T> key) {
    return this.delegate.getUserData(key);
  }
  
  public <T extends Object> void putUserData(final Key<T> key, final T value) {
    this.delegate.putUserData(key, value);
  }
  
  public Icon getIcon(final int flags) {
    return this.delegate.getIcon(flags);
  }
  
  public PsiModifierList getModifierList() {
    return this.delegate.getModifierList();
  }
  
  public boolean hasModifierProperty(final String name) {
    return this.delegate.hasModifierProperty(name);
  }
  
  public PsiDocComment getDocComment() {
    return this.delegate.getDocComment();
  }
  
  public boolean isDeprecated() {
    return this.delegate.isDeprecated();
  }
  
  public ItemPresentation getPresentation() {
    return this.delegate.getPresentation();
  }
  
  public boolean canNavigate() {
    return this.delegate.canNavigate();
  }
  
  public boolean canNavigateToSource() {
    return this.delegate.canNavigateToSource();
  }
  
  public void navigate(final boolean requestFocus) {
    this.delegate.navigate(requestFocus);
  }
  
  public PsiTypeParameterList getTypeParameterList() {
    return this.delegate.getTypeParameterList();
  }
  
  public PsiTypeParameter[] getTypeParameters() {
    return this.delegate.getTypeParameters();
  }
  
  public boolean hasTypeParameters() {
    return this.delegate.hasTypeParameters();
  }
}
