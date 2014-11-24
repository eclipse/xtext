package org.eclipse.xtext.idea.types.psi.impl;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.types.psi.JvmPsiClass;
import org.eclipse.xtext.idea.types.psi.impl.AnnotatableModifierList;
import org.eclipse.xtext.psi.PsiModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class JvmPsiClassImpl implements /* LightElement */JvmPsiClass/* , PsiExtensibleClass */ {
  public final static Object JVM_ELEMENT_KEY /* Skipped initializer because of errors */;
  
  @Inject
  private PsiModelAssociations psiAssocations;
  
  @Inject
  private IJvmModelAssociations jvmAssocations;
  
  private final JvmDeclaredType jvmType;
  
  private final /* PsiNamedElement */Object psiElement;
  
  private final /* ClassInnerStuffCache */Object membersCache;
  
  public JvmPsiClassImpl(final JvmDeclaredType declaredType, final /* PsiNamedElement */Object psiElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nClassInnerStuffCache cannot be resolved."
      + "\nmanager cannot be resolved"
      + "\nlanguage cannot be resolved"
      + "\ninjectMembers cannot be resolved");
  }
  
  public EClass getType() {
    return this.jvmType.eClass();
  }
  
  public JvmPsiClassImpl copy() {
    return new JvmPsiClassImpl(this.jvmType, this.psiElement);
  }
  
  public String getName() {
    return this.jvmType.getSimpleName();
  }
  
  public String getQualifiedName() {
    return this.jvmType.getQualifiedName();
  }
  
  public PsiNamedElement getNavigationElement() {
    return this.psiElement;
  }
  
  public Object getContainingFile() {
    throw new Error("Unresolved compilation problems:"
      + "\ncontainingFile cannot be resolved");
  }
  
  public Object isValid() {
    throw new Error("Unresolved compilation problems:"
      + "\nvalid cannot be resolved");
  }
  
  public Object getConstructors() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetConstructors cannot be resolved");
  }
  
  public Object getFields() {
    throw new Error("Unresolved compilation problems:"
      + "\nfields cannot be resolved");
  }
  
  public Object getMethods() {
    throw new Error("Unresolved compilation problems:"
      + "\nmethods cannot be resolved");
  }
  
  public Object getInnerClasses() {
    throw new Error("Unresolved compilation problems:"
      + "\ninnerClasses cannot be resolved");
  }
  
  public /* List<PsiField> */Object getOwnFields() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiField cannot be resolved to a type."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field modifierList is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field navigationElement is undefined for the type JvmPsiClassImpl"
      + "\nThe method putUserData is undefined for the type JvmPsiClassImpl");
  }
  
  public /* List<PsiMethod> */Object getOwnMethods() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiMethod cannot be resolved to a type."
      + "\nLightMethodBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field containingClass is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field constructor is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field methodReturnType is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field navigationElement is undefined for the type JvmPsiClassImpl"
      + "\nThe method putUserData is undefined for the type JvmPsiClassImpl"
      + "\n=> cannot be resolved");
  }
  
  private Object psiThrowsList(final JvmExecutable executable) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassReferenceType cannot be resolved to a type."
      + "\nLightReferenceListBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiReferenceList is undefined for the type JvmPsiClassImpl"
      + "\nThe method addReference is undefined for the type JvmPsiClassImpl"
      + "\nRole cannot be resolved"
      + "\nTHROWS_LIST cannot be resolved"
      + "\n=> cannot be resolved");
  }
  
  private Object getPsiParameters(final JvmExecutable m) {
    throw new Error("Unresolved compilation problems:"
      + "\nLightParameterListBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method addParameter is undefined for the type JvmPsiClassImpl"
      + "\nLightParameter cannot be resolved."
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field navigationElement is undefined for the type JvmPsiClassImpl"
      + "\nThe method putUserData is undefined for the type JvmPsiClassImpl"
      + "\n=> cannot be resolved"
      + "\n=> cannot be resolved");
  }
  
  private Object getNavigationElement(final EObject jvmElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getPsiElement is undefined for the type JvmPsiClassImpl");
  }
  
  private AnnotatableModifierList getPsiModifiers(final JvmMember m) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method addModifier is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiModifier is undefined for the type JvmPsiClassImpl"
      + "\nPACKAGE_LOCAL cannot be resolved"
      + "\nPRIVATE cannot be resolved"
      + "\nPROTECTED cannot be resolved"
      + "\nPUBLIC cannot be resolved"
      + "\nABSTRACT cannot be resolved"
      + "\nFINAL cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\nSTATIC cannot be resolved"
      + "\nFINAL cannot be resolved"
      + "\nTRANSIENT cannot be resolved"
      + "\nVOLATILE cannot be resolved"
      + "\nABSTRACT cannot be resolved"
      + "\nDEFAULT cannot be resolved"
      + "\nFINAL cannot be resolved"
      + "\nNATIVE cannot be resolved"
      + "\nSTRICTFP cannot be resolved"
      + "\nSYNCHRONIZED cannot be resolved");
  }
  
  private /* PsiType */Object toPsiType(final JvmTypeReference type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nbuildTypeFromTypeString cannot be resolved");
  }
  
  public /* List<PsiClass> */Object getOwnInnerClasses() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiNamedElement cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nThe method getPsiElement is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field navigationElement is undefined for the type JvmPsiClassImpl"
      + "\nThe method putUserData is undefined for the type JvmPsiClassImpl");
  }
  
  public PsiClass getContainingClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClass cannot be resolved to a type."
      + "\nThe method getPsiElement is undefined for the type JvmPsiClassImpl");
  }
  
  public Object getExtendsList() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassType cannot be resolved to a type."
      + "\nPsiClassType cannot be resolved to a type."
      + "\nLightReferenceListBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiReferenceList is undefined for the type JvmPsiClassImpl"
      + "\nThe method addReference is undefined for the type JvmPsiClassImpl"
      + "\nThe method addReference is undefined for the type JvmPsiClassImpl"
      + "\nRole cannot be resolved"
      + "\nEXTENDS_LIST cannot be resolved"
      + "\n=> cannot be resolved");
  }
  
  public Object getImplementsList() {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiClassType cannot be resolved to a type."
      + "\nLightReferenceListBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiReferenceList is undefined for the type JvmPsiClassImpl"
      + "\nThe method addReference is undefined for the type JvmPsiClassImpl"
      + "\nRole cannot be resolved"
      + "\nIMPLEMENTS_LIST cannot be resolved"
      + "\n=> cannot be resolved");
  }
  
  public List<Object> getInitializers() {
    return Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList());
  }
  
  public Object getLBrace() {
    return null;
  }
  
  public Object getRBrace() {
    return null;
  }
  
  public Object getNameIdentifier() {
    return null;
  }
  
  public Object getScope() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getPsiElement is undefined for the type JvmPsiClassImpl");
  }
  
  public boolean isAnnotationType() {
    return (this.jvmType instanceof JvmAnnotationType);
  }
  
  public boolean isEnum() {
    return (this.jvmType instanceof JvmEnumerationType);
  }
  
  public boolean isInterface() {
    if ((this.jvmType instanceof JvmGenericType)) {
      return ((JvmGenericType)this.jvmType).isInterface();
    }
    return false;
  }
  
  public void setName(final String name)/*  throws IncorrectOperationException */ {
    throw new Error("Unresolved compilation problems:"
      + "\nIncorrectOperationException cannot be resolved.");
  }
  
  public AnnotatableModifierList getModifierList() {
    return this.getPsiModifiers(this.jvmType);
  }
  
  public Object hasModifierProperty(final String name) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method hasModifierProperty(String) is not applicable for the arguments (AnnotatableModifierList,String)"
      + "\nType mismatch: cannot convert from AnnotatableModifierList to String");
  }
  
  public Object getDocComment() {
    return this.getPsiDocComment(this.jvmType);
  }
  
  private Object getPsiDocComment(final EObject jvmObject) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiDocCommentImpl cannot be resolved.");
  }
  
  public boolean isDeprecated() {
    return this.jvmType.isDeprecated();
  }
  
  public Object getTypeParameterList() {
    return this.getPsiTypeParameterList(this.jvmType);
  }
  
  private Object getPsiTypeParameterList(final EObject declarator) {
    throw new Error("Unresolved compilation problems:"
      + "\nLightTypeParameterListBuilder cannot be resolved."
      + "\nThe method or field manager is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field language is undefined for the type JvmPsiClassImpl"
      + "\n=> cannot be resolved");
  }
  
  public Object accept(final /* PsiElementVisitor */Object visitor) {
    throw new Error("Unresolved compilation problems:"
      + "\nJavaElementVisitor cannot be resolved to a type."
      + "\nvisitClass cannot be resolved"
      + "\nvisitElement cannot be resolved");
  }
  
  public boolean processDeclarations(final /* PsiScopeProcessor */Object processor, final /* ResolveState */Object state, final /* PsiElement */Object lastParent, final /* PsiElement */Object place) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiUtil is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nprocessDeclarationsInEnum cannot be resolved"
      + "\n! cannot be resolved"
      + "\ngetLanguageLevel cannot be resolved"
      + "\nprocessDeclarationsInClass cannot be resolved");
  }
  
  public String toString() {
    return this.jvmType.toString();
  }
  
  public Object isEquivalentTo(final /* PsiElement */Object another) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nisClassEquivalentTo cannot be resolved");
  }
  
  public Object findFieldByName(final String name, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindFieldByName cannot be resolved");
  }
  
  public Object findInnerClassByName(final String name, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindInnerByName cannot be resolved");
  }
  
  public Object findMethodBySignature(final /* PsiMethod */Object patternMethod, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindMethodBySignature cannot be resolved");
  }
  
  public Object findMethodsAndTheirSubstitutorsByName(final String name, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindMethodsAndTheirSubstitutorsByName cannot be resolved");
  }
  
  public Object findMethodsByName(final String name, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindMethodsByName cannot be resolved");
  }
  
  public Object findMethodsBySignature(final /* PsiMethod */Object patternMethod, final boolean checkBases) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nfindMethodsBySignature cannot be resolved");
  }
  
  public Object getVisibleSignatures() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiSuperMethodImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetVisibleSignatures cannot be resolved");
  }
  
  public Object getAllFields() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetAllFields cannot be resolved");
  }
  
  public Object getAllInnerClasses() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetAllInnerClasses cannot be resolved");
  }
  
  public Object getAllMethods() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetAllMethods cannot be resolved");
  }
  
  public Object getAllMethodsAndTheirSubstitutors() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetAllWithSubstitutorsByMap cannot be resolved"
      + "\nMemberType cannot be resolved"
      + "\nMETHOD cannot be resolved");
  }
  
  public Object getExtendsListTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetExtendsListTypes cannot be resolved");
  }
  
  public Object getImplementsListTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetImplementsListTypes cannot be resolved");
  }
  
  public Object getInterfaces() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetInterfaces cannot be resolved");
  }
  
  public Object getSuperClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetSuperClass cannot be resolved");
  }
  
  public Object getSuperTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetSuperTypes cannot be resolved");
  }
  
  public Object getSupers() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiClassImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetSupers cannot be resolved");
  }
  
  public Object isInheritor(final /* PsiClass */Object baseClass, final boolean checkDeep) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field InheritanceImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nisInheritor cannot be resolved");
  }
  
  public Object isInheritorDeep(final /* PsiClass */Object baseClass, final /* PsiClass */Object classToByPass) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field InheritanceImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nisInheritorDeep cannot be resolved");
  }
  
  public Object getTypeParameters() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiImplUtil is undefined for the type JvmPsiClassImpl"
      + "\ngetTypeParameters cannot be resolved");
  }
  
  public Object hasTypeParameters() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiImplUtil is undefined for the type JvmPsiClassImpl"
      + "\nhasTypeParameters cannot be resolved");
  }
}
