/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.psi.impl

import com.google.inject.Inject
import com.intellij.core.JavaCoreBundle
import com.intellij.lang.Language
import com.intellij.lang.java.JavaLanguage
import com.intellij.psi.JVMElementFactories
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiAnnotationMemberValue
import com.intellij.psi.PsiAnnotationOwner
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiField
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierList
import com.intellij.psi.PsiNameHelper
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiParameterList
import com.intellij.psi.PsiReferenceList
import com.intellij.psi.PsiSubstitutor
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypeParameterList
import com.intellij.psi.ResolveState
import com.intellij.psi.impl.InheritanceImplUtil
import com.intellij.psi.impl.PsiClassImplUtil
import com.intellij.psi.impl.PsiImplUtil
import com.intellij.psi.impl.PsiSuperMethodImplUtil
import com.intellij.psi.impl.light.LightClassReference
import com.intellij.psi.impl.light.LightElement
import com.intellij.psi.impl.light.LightModifierList
import com.intellij.psi.impl.light.LightParameter
import com.intellij.psi.impl.light.LightParameterListBuilder
import com.intellij.psi.impl.light.LightReferenceListBuilder
import com.intellij.psi.impl.light.LightTypeParameter
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
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.impl.NameConcatHelper
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.service.OperationCanceledError
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiElementExtensions
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xtype.XComputedTypeReference

class JvmPsiClassImpl extends LightElement implements JvmPsiClass, PsiExtensibleClass {

	@Inject
	PsiModelAssociations psiAssocations
	@Inject
	IJvmModelAssociations jvmAssocations
	
	val JvmDeclaredType jvmType
	val PsiElement psiElement
	val ClassInnerStuffCache membersCache
	var PsiTypeParameterList typeParameterList

	new(JvmDeclaredType declaredType, PsiElement psiElement) {
		super(psiElement.manager, psiElement.language)
		this.jvmType = declaredType
		this.psiElement = psiElement
		val language = language
		if (language instanceof IXtextLanguage) {
			language.injectMembers(this)
		}
		JvmPsiElementExtensions.setJvmElement(this, declaredType)
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
		membersCache.constructors
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
				parent = this
				containingClass = this
				modifierList = f.psiModifiers
				docComment = f.psiDocComment
				deprecated = f.deprecated
				nullableNavigationElement = f.navigationElement
				JvmPsiElementExtensions.setJvmElement(it, f)
			]) as PsiField
		].toList
	}

	override getOwnMethods() {
		jvmType.members.filter(JvmExecutable).map [ m |
			(new LightMethodBuilder(
				manager,
				language,
				m.simpleName,
				m.psiParameters,
				m.psiModifiers,
				m.throwsList,
				m.psiTypeParameterList
			) => [
				parent = this
				containingClass = this
				constructor = m instanceof JvmConstructor
				// TODO subclass to allow doccomment
				if (m instanceof JvmOperation) {
					methodReturnType = m.returnType.toPsiType
				}
				nullableNavigationElement = m.navigationElement
				JvmPsiElementExtensions.setJvmElement(it, m)
			]) as PsiMethod
		].toList
	}

	protected def getThrowsList(JvmExecutable executable) {
		executable.exceptions.toReferenceList(PsiReferenceList.Role.THROWS_LIST)
	}

	private def getPsiParameters(JvmExecutable m) {
		new LightParameterListBuilder(manager, language) => [
			m.parameters.forEach [ p |
				val parameterName = p.simpleName
				val parameterType = p.parameterType?.toPsiType
				if (parameterName != null && parameterType != null) {
					addParameter(
						new LightParameter(parameterName, parameterType, psiElement, language) => [
							nullableNavigationElement = p.navigationElement
							JvmPsiElementExtensions.setJvmElement(it, p)
						]
					)
				}
			]
		]
	}

	private def getNavigationElement(EObject jvmElement) {
		val primarySourceElement = jvmAssocations.getPrimarySourceElement(jvmElement)
		psiAssocations.getPsiElement(primarySourceElement)
	}

	private def setNullableNavigationElement(LightElement element, PsiElement navigationElement) {
		if (navigationElement != null)
			element.navigationElement = navigationElement
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
			if (m !== null) {
				m.annotations.forEach [ anno |
					addAnnotation(anno.annotation.qualifiedName) => []
				]
			}
		]
	}

	private def PsiType toPsiType(JvmTypeReference type) {
		try {
			if (type == null) {
				return null
			} 
			if (type instanceof XComputedTypeReference) {
				return type.equivalent.toPsiType
			}
			return buildTypeFromTypeString(type.getQualifiedName('.'), psiElement, containingFile)
		} catch (OperationCanceledError e) {
			throw e.wrapped
		}
	}

	/*
	 * Copied from PsiClassImplUtil for Android Studio compatibility
	 */
	private def buildTypeFromTypeString(String typeName, PsiElement context, PsiFile psiFile) {
		val psiManager = psiFile.manager
		if (typeName.indexOf('<') != -1 || typeName.indexOf('[') != -1 || typeName.indexOf('.') == -1) {
			try {
				return JavaPsiFacade.getInstance(psiManager.project).elementFactory.createTypeFromText(typeName,
					context)
			} catch (Exception ex) {
			}
		}

		val aClass = JavaPsiFacade.getInstance(psiManager.project).findClass(typeName, context.resolveScope)
		if (aClass == null) {
			val ref = new LightClassReference(psiManager, PsiNameHelper.getShortClassName(typeName), typeName,
				PsiSubstitutor.EMPTY, psiFile)
			return new PsiClassReferenceType(ref, null)
		} else {
			val factory = JavaPsiFacade.getInstance(psiManager.project).elementFactory
			val substitutor = factory.createRawSubstitutor(aClass)
			return factory.createType(aClass, substitutor)
		}
	}

	override getOwnInnerClasses() {
		jvmType.allNestedTypes.map [ inner |
			val sourceElement = jvmAssocations.getPrimarySourceElement(inner)
			val psiElement = psiAssocations.getPsiElement(sourceElement) as PsiNamedElement
			(new JvmPsiClassImpl(inner, psiElement) => [
				nullableNavigationElement = inner.navigationElement
				JvmPsiElementExtensions.setJvmElement(it, inner)
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
		val references = if (interface)
				jvmType.extendedInterfaces
			else
				#[jvmType.extendedClass]
		references.toReferenceList(PsiReferenceList.Role.EXTENDS_LIST)
	}

	override getImplementsList() {
		val references = if (interface)
				emptyList
			else
				jvmType.extendedInterfaces
		references.toReferenceList(PsiReferenceList.Role.IMPLEMENTS_LIST)
	}
	
	protected def toReferenceList(Iterable<JvmTypeReference> references, PsiReferenceList.Role role) {
		val extension referenceList = new LightReferenceListBuilder(manager, language, role)
		references.map[toPsiType].filter(PsiClassType).forEach[addReference]
		referenceList
	}

	override getInitializers() {
		#[]
	}

	override getLBrace() {

		// TODO
		null
	}

	override getRBrace() {

		// TODO
		null
	}

	override getNameIdentifier() {

		// TODO
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
		if (typeParameterList === null)
			return typeParameterList = jvmType.psiTypeParameterList
		return typeParameterList
	}

	private def getPsiTypeParameterList(EObject declarator) {
		new LightTypeParameterListBuilder(manager, language) => [ builder |
			if (declarator instanceof JvmTypeParameterDeclarator) {
				declarator.typeParameters.forEach [ builder.addParameter(toPsiTypeParameter)]
			}
		]
	}
	
	def toPsiTypeParameter(JvmTypeParameter typeParam) {
		val psiFactory = JVMElementFactories.requireFactory(JavaLanguage.INSTANCE, project)
		val sb = new StringBuilder()
		sb.append('public <').append(typeParam.simpleName).append(' ')
		NameConcatHelper.appendConstraintsName(sb, typeParam.constraints, '.', NameConcatHelper.NameType.QUALIFIED)
		sb.append('> void m(){}')
		val psiTypeParam = try {
			psiFactory.createMethodFromText(sb.toString, null).typeParameters.get(0)
		} catch(IncorrectOperationException e) {
			psiFactory.createTypeParameter(typeParam.simpleName, PsiClassType.EMPTY_ARRAY)
		}
		// TODO set navigation element et al
		return new LightTypeParameter(psiTypeParam) {
			
			override getOwner() {
				return JvmPsiClassImpl.this
			}
			
		}
	}

	override accept(PsiElementVisitor visitor) {
		if (visitor instanceof JavaElementVisitor) {
			visitor.visitClass(this)
		} else {
			visitor.visitElement(this)
		}
	}

	override processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent,
		PsiElement place) {
		if (isEnum) {
			if(!PsiClassImplUtil.processDeclarationsInEnum(processor, state, membersCache)) return false
		}

		val level = PsiUtil.getLanguageLevel(place)
		return PsiClassImplUtil.processDeclarationsInClass(this, processor, state, null, lastParent, place, level,
			false)
	}

	override toString() {
		jvmType.toString
	}

	// default methods
	override protected getElementIcon(int flags) {
		PsiClassImplUtil.getClassIcon(flags, this)
	}

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
		if (jvmType instanceof JvmTypeParameterDeclarator) {
			return !jvmType.typeParameters.empty
		}
		return false
	}
}

public class LightMethodBuilder extends com.intellij.psi.impl.light.LightMethodBuilder {

	@Accessors PsiElement parent

	new(
		PsiManager manager,
		Language language,
		String name,
		PsiParameterList parameterList,
		PsiModifierList modifierList,
		PsiReferenceList throwsList,
		PsiTypeParameterList typeParameterList
	) {
		super(manager, language, name, parameterList, modifierList, throwsList, typeParameterList)
	}

}

public class LightFieldBuilder extends LightVariableBuilder<LightFieldBuilder> implements PsiField {

	@Accessors PsiElement parent
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

		// TODO filter
		annotations
	}

}

public class LightAnnotation extends LightElement implements PsiAnnotation {

	protected static final String CAN_NOT_MODIFY_MESSAGE = JavaCoreBundle.message("psi.error.attempt.to.edit.class.file");

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
		return null
	}

	override findDeclaredAttributeValue(String attributeName) {
		return null
	}

	override getNameReferenceElement() {
		return null
	}

	override getParameterList() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override <T extends PsiAnnotationMemberValue> setDeclaredAttributeValue(String attributeName, T value) {
		throw new IncorrectOperationException(CAN_NOT_MODIFY_MESSAGE);
	}

	override getMetaData() {
		return null
	}

}
