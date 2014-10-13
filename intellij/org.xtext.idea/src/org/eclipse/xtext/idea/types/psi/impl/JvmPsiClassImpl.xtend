package org.eclipse.xtext.idea.types.psi.impl

import com.google.inject.Inject
import com.intellij.lang.Language
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiAnnotationMemberValue
import com.intellij.psi.PsiAnnotationOwner
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiField
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReferenceList
import com.intellij.psi.PsiType
import com.intellij.psi.ResolveState
import com.intellij.psi.impl.InheritanceImplUtil
import com.intellij.psi.impl.PsiClassImplUtil
import com.intellij.psi.impl.PsiImplUtil
import com.intellij.psi.impl.PsiSuperMethodImplUtil
import com.intellij.psi.impl.light.LightElement
import com.intellij.psi.impl.light.LightMethodBuilder
import com.intellij.psi.impl.light.LightModifierList
import com.intellij.psi.impl.light.LightParameter
import com.intellij.psi.impl.light.LightParameterListBuilder
import com.intellij.psi.impl.light.LightReferenceListBuilder
import com.intellij.psi.impl.light.LightTypeParameterListBuilder
import com.intellij.psi.impl.light.LightVariableBuilder
import com.intellij.psi.impl.source.ClassInnerStuffCache
import com.intellij.psi.impl.source.PsiClassReferenceType
import com.intellij.psi.impl.source.PsiExtensibleClass
import com.intellij.psi.impl.source.javadoc.PsiDocCommentImpl
import com.intellij.psi.javadoc.PsiDocComment
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.util.PsiUtil
import com.intellij.util.IncorrectOperationException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmConstructor
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmExecutable
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.types.psi.JvmPsiClass
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xtype.XComputedTypeReference

class JvmPsiClassImpl extends LightElement implements JvmPsiClass, PsiExtensibleClass {

	@Inject
	PsiModelAssociations psiAssocations
	@Inject
	IJvmModelAssociations jvmAssocations

	val JvmDeclaredType jvmType
	val PsiNamedElement psiElement
	val ClassInnerStuffCache membersCache

	new(JvmDeclaredType declaredType, PsiNamedElement psiElement) {
		super(psiElement.manager, psiElement.language)
		this.jvmType = declaredType
		this.psiElement = psiElement
		val language = language
		if (language instanceof IXtextLanguage) {
			language.injectMembers(this)
		}
		this.membersCache = new ClassInnerStuffCache(this);
	}

	override getType() {
		jvmType.eClass
	}

	override copy() {
		new JvmPsiClassImpl(jvmType, psiElement)
	}

	override getName() {
		jvmType.simpleName
	}

	override getQualifiedName() {
		jvmType.qualifiedName
	}

	override getNavigationElement() {
		psiElement
	}

	override getContainingFile() {
		psiElement.containingFile
	}

	override isValid() {
		psiElement.valid
	}

	override getConstructors() {
		PsiImplUtil.getConstructors(this)
	}

	override getFields() {
		membersCache.fields
	}

	override getMethods() {
		membersCache.methods
	}

	override getInnerClasses() {
		membersCache.innerClasses
	}

	override getOwnFields() {
		jvmType.declaredFields.map [ f |
			(new LightFieldBuilder(manager, language, f.simpleName, f.type.toPsiType) => [
				containingClass = this
				modifierList = f.psiModifiers
				docComment = f.psiDocComment
				deprecated = f.deprecated
				associatePrimary(f, it)
			]) as PsiField
		].toList
	}

	override getOwnMethods() {
		jvmType.members.filter(JvmExecutable).map [ m |
			(new LightMethodBuilder(manager, language, m.simpleName, m.psiParameters, m.psiModifiers, m.psiThrowsList, m.psiTypeParameterList) => [
				containingClass = this
				constructor = m instanceof JvmConstructor
				//TODO subclass to allow doccomment
				if (m instanceof JvmOperation) {
					methodReturnType = m.returnType.toPsiType
				}
				associatePrimary(m, it)
			]) as PsiMethod
		].toList
	}

	private def psiThrowsList(JvmExecutable executable) {
		new LightReferenceListBuilder(manager, language, PsiReferenceList.Role.THROWS_LIST) => [
			executable.exceptions.forEach [ e |
				addReference(e.toPsiType as PsiClassReferenceType)
			]
		]
	}

	private def getPsiParameters(JvmExecutable m) {
		new LightParameterListBuilder(manager, language) => [
			m.parameters.forEach [ p |
				val psiParameter = new LightParameter(p.simpleName, p.parameterType.toPsiType, psiElement, language)
				associatePrimary(p, psiParameter)
				addParameter(psiParameter)
			]
		]
	}

	private def associatePrimary(EObject jvmElement, LightElement psiElement) {
		val primarySourceElement = jvmAssocations.getPrimarySourceElement(jvmElement)
		val navigationElement = psiAssocations.getPsiElement(primarySourceElement)
		psiElement.navigationElement = navigationElement
		psiAssocations.associatePrimary(primarySourceElement, [psiElement])
	}

	private def getPsiModifiers(JvmMember m) {
		new AnnotatableModifierList(manager, language) => [
			switch m.visibility {
				case DEFAULT:
					addModifier(PsiModifier.PACKAGE_LOCAL)
				case PRIVATE:
					addModifier(PsiModifier.PRIVATE)
				case PROTECTED:
					addModifier(PsiModifier.PROTECTED)
				case PUBLIC:
					addModifier(PsiModifier.PUBLIC)
			}
			if (m instanceof JvmDeclaredType) {
				if (m.isAbstract)
					addModifier(PsiModifier.ABSTRACT)
				if (m.isFinal)
					addModifier(PsiModifier.FINAL)
				if (m.isStatic)
					addModifier(PsiModifier.STATIC)
			}
			if (m instanceof JvmFeature) {
				if (m.isStatic)
					addModifier(PsiModifier.STATIC)
			}
			if (m instanceof JvmField) {
				if (m.isFinal)
					addModifier(PsiModifier.FINAL)
				if (m.isTransient)
					addModifier(PsiModifier.TRANSIENT)
				if (m.isVolatile)
					addModifier(PsiModifier.VOLATILE)
			}
			if (m instanceof JvmOperation) {
				if (m.isAbstract)
					addModifier(PsiModifier.ABSTRACT)
				if (m.isDefault)
					addModifier(PsiModifier.DEFAULT)
				if (m.isFinal)
					addModifier(PsiModifier.FINAL)
				if (m.isNative)
					addModifier(PsiModifier.NATIVE)
				if (m.isStrictFloatingPoint)
					addModifier(PsiModifier.STRICTFP)
				if (m.isSynchronized)
					addModifier(PsiModifier.SYNCHRONIZED)
			}
			if (m instanceof JvmAnnotationTarget) {
				m.annotations.forEach[anno|
					addAnnotation(anno.annotation.qualifiedName) => [
						associatePrimary(m, it) 
					]
				]
			}
		]
	}

	private def PsiType toPsiType(JvmTypeReference type) {
		if (type instanceof XComputedTypeReference) {
			type.equivalent.toPsiType
		} else {
			PsiImplUtil.buildTypeFromTypeString(type.getQualifiedName('.'), psiElement, containingFile)
		}
	}

	override getOwnInnerClasses() {
		jvmType.allNestedTypes.map [ inner |
			val sourceElement = jvmAssocations.getPrimarySourceElement(inner)
			val psiElement = psiAssocations.getPsiElement(sourceElement) as PsiNamedElement
			(new JvmPsiClassImpl(inner, psiElement) => [
				associatePrimary(inner, it)
			]) as PsiClass
		].toList
	}

	override getContainingClass() {
		val container = jvmType.eContainer
		if (container instanceof JvmDeclaredType) {
			return psiAssocations.getPsiElement(container) as PsiClass
		}
		return null
	}

	override getExtendsList() {
		new LightReferenceListBuilder(manager, language, PsiReferenceList.Role.EXTENDS_LIST) => [
			if (isInterface) {
				jvmType.extendedInterfaces.forEach[type|addReference(type.toPsiType as PsiClassType)]
			} else {
				addReference(jvmType.extendedClass.toPsiType as PsiClassType)
			}
		]
	}

	override getImplementsList() {
		new LightReferenceListBuilder(manager, language, PsiReferenceList.Role.IMPLEMENTS_LIST) => [
			if (!isInterface) {
				jvmType.extendedInterfaces.forEach[type|addReference(type.toPsiType as PsiClassType)]
			}
		]
	}

	override getInitializers() {
		#[]
	}

	override getLBrace() {

		//TODO
		null
	}

	override getRBrace() {

		//TODO
		null
	}

	override getNameIdentifier() {

		//TODO
		null
	}

	override getScope() {
		val container = jvmType.eContainer
		if (container instanceof JvmDeclaredType) {
			return psiAssocations.getPsiElement(container)
		}
		return containingFile
	}

	override isAnnotationType() {
		jvmType instanceof JvmAnnotationType
	}

	override isEnum() {
		jvmType instanceof JvmEnumerationType
	}

	override isInterface() {
		if (jvmType instanceof JvmGenericType)
			return jvmType.isInterface
		return false
	}

	override setName(String name) throws IncorrectOperationException {
		throw new IncorrectOperationException
	}

	override getModifierList() {
		jvmType.psiModifiers
	}

	override hasModifierProperty(String name) {
		modifierList.hasModifierProperty(name)
	}

	override getDocComment() {
		jvmType.psiDocComment
	}
	
	private def getPsiDocComment(EObject jvmObject) {
		val adapter = EcoreUtil.getAdapter(jvmObject.eAdapters, DocumentationAdapter) as DocumentationAdapter;
		new PsiDocCommentImpl(adapter?.documentation ?: "")
	}

	override isDeprecated() {
		jvmType.isDeprecated
	}

	override getTypeParameterList() {
		jvmType.psiTypeParameterList
	}

	private def getPsiTypeParameterList(EObject declarator) {
		new LightTypeParameterListBuilder(manager, language) => [
			if (declarator instanceof JvmTypeParameterDeclarator) {
				//TODO
			}
		]
	}

	override accept(PsiElementVisitor visitor) {
		if (visitor instanceof JavaElementVisitor) {
			visitor.visitClass(this)
		} else {
			visitor.visitElement(this)
		}
	}

	override processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place) {
		if (isEnum) {
			if(!PsiClassImplUtil.processDeclarationsInEnum(processor, state, membersCache)) return false
		}

		val level = PsiUtil.getLanguageLevel(place)
		return PsiClassImplUtil.processDeclarationsInClass(this, processor, state, null, lastParent, place, level, false)
	}

	override toString() {
		jvmType.toString
	}

	//default methods
	override isEquivalentTo(PsiElement another) {
		PsiClassImplUtil.isClassEquivalentTo(this, another)
	}

	override findFieldByName(String name, boolean checkBases) {
		PsiClassImplUtil.findFieldByName(this, name, checkBases)
	}

	override findInnerClassByName(String name, boolean checkBases) {
		PsiClassImplUtil.findInnerByName(this, name, checkBases)
	}

	override findMethodBySignature(PsiMethod patternMethod, boolean checkBases) {
		PsiClassImplUtil.findMethodBySignature(this, patternMethod, checkBases)
	}

	override findMethodsAndTheirSubstitutorsByName(String name, boolean checkBases) {
		PsiClassImplUtil.findMethodsAndTheirSubstitutorsByName(this, name, checkBases)
	}

	override findMethodsByName(String name, boolean checkBases) {
		PsiClassImplUtil.findMethodsByName(this, name, checkBases)
	}

	override findMethodsBySignature(PsiMethod patternMethod, boolean checkBases) {
		PsiClassImplUtil.findMethodsBySignature(this, patternMethod, checkBases)
	}

	override getVisibleSignatures() {
		PsiSuperMethodImplUtil.getVisibleSignatures(this)
	}

	override getAllFields() {
		PsiClassImplUtil.getAllFields(this)
	}

	override getAllInnerClasses() {
		PsiClassImplUtil.getAllInnerClasses(this)
	}

	override getAllMethods() {
		PsiClassImplUtil.getAllMethods(this)
	}

	override getAllMethodsAndTheirSubstitutors() {
		PsiClassImplUtil.getAllWithSubstitutorsByMap(this, PsiClassImplUtil.MemberType.METHOD)
	}

	override getExtendsListTypes() {
		PsiClassImplUtil.getExtendsListTypes(this)
	}

	override getImplementsListTypes() {
		PsiClassImplUtil.getImplementsListTypes(this)
	}

	override getInterfaces() {
		PsiClassImplUtil.getInterfaces(this)
	}

	override getSuperClass() {
		PsiClassImplUtil.getSuperClass(this)
	}

	override getSuperTypes() {
		PsiClassImplUtil.getSuperTypes(this)
	}

	override getSupers() {
		PsiClassImplUtil.getSupers(this)
	}

	override isInheritor(PsiClass baseClass, boolean checkDeep) {
		InheritanceImplUtil.isInheritor(this, baseClass, checkDeep)
	}

	override isInheritorDeep(PsiClass baseClass, PsiClass classToByPass) {
		InheritanceImplUtil.isInheritorDeep(this, baseClass, classToByPass)
	}

	override getTypeParameters() {
		PsiImplUtil.getTypeParameters(this)
	}

	override hasTypeParameters() {
		PsiImplUtil.hasTypeParameters(this)
	}
}

public class LightFieldBuilder extends LightVariableBuilder<LightFieldBuilder> implements PsiField {

	@Accessors PsiClass containingClass
	@Accessors PsiExpression initializer
	@Accessors PsiDocComment docComment
	@Accessors boolean deprecated

	new(PsiManager manager, Language language, String name, PsiType type) {
		super(manager, name, type, language)
	}
}

public class AnnotatableModifierList extends LightModifierList {
	
	val annotations = <PsiAnnotation>newArrayList
	
	new(PsiManager manager, Language language) {
		super(manager, language, #[])
	}
	
	
	override LightAnnotation addAnnotation(String qualifiedName) {
		val anno = new LightAnnotation(manager, language, qualifiedName)
		anno.owner = this
		annotations += anno
		anno
	}

	override findAnnotation(String qualifiedName) {
		annotations.findFirst[a|qualifiedName == a.qualifiedName]
	}

	override getAnnotations() {
		annotations
	}

	override getApplicableAnnotations() {

		//TODO filter
		annotations
	}

}

public class LightAnnotation extends LightElement implements PsiAnnotation {

	String qualifiedName
	
	@Accessors PsiAnnotationOwner owner
	
	public new(PsiManager manager, Language language, String qualifiedName) {
		super(manager, language)
		this.qualifiedName = qualifiedName
	}

	override getQualifiedName() {
		qualifiedName
	}

	override toString() {
		qualifiedName
	}

	override findAttributeValue(String attributeName) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override findDeclaredAttributeValue(String attributeName) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getNameReferenceElement() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getParameterList() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override <T extends PsiAnnotationMemberValue> setDeclaredAttributeValue(String attributeName, T value) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override getMetaData() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
