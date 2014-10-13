package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.impl.JavaPsiFacadeEx
import com.intellij.psi.impl.compiled.SignatureParsing
import java.text.StringCharacterIterator
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider
import org.eclipse.xtext.common.types.access.impl.ITypeFactory
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.resource.ISynchronizable
import org.eclipse.xtext.util.Strings

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*
import org.eclipse.xtext.resource.XtextResourceSet
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope

class StubJvmTypeProvider extends AbstractRuntimeJvmTypeProvider {
	
	val static String PRIMITIVES = URIHelperConstants.PRIMITIVES_URI.segment(0)
	
	@Accessors(AccessorType.PUBLIC_GETTER)
	val Project project
	
	val ITypeFactory<PsiClass, JvmDeclaredType> psiClassFactory
	
	@Accessors(AccessorType.PUBLIC_GETTER)
	val extension StubURIHelper uriHelper
	
	protected new(Project project, ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess, TypeResourceServices services, IPsiModelAssociator psiModelAssociator) {
		super(resourceSet, indexedJvmTypeAccess, services)
		this.project = project
		this.uriHelper = createStubURIHelper
		this.psiClassFactory = createPsiClassFactory(psiModelAssociator)
	}
	
	def createPsiClassFactory(IPsiModelAssociator psiModelAssociator) {
		new PsiBasedTypeFactory(uriHelper, psiModelAssociator)
	}
	
	protected def createStubURIHelper() {
		new StubURIHelper
	}

	override findTypeByName(String name) {
		doFindTypeByName(name, false)
	} 
	
	override findTypeByName(String name, boolean binaryNestedTypeDelimiter) {
		var result = doFindTypeByName(name, false)
		if (result != null || isBinaryNestedTypeDelimiter(name, binaryNestedTypeDelimiter)) {
			return result
		}
		val nameVariants = new ClassNameVariants(name)
		while (result == null && nameVariants.hasNext) {
			val nextVariant = nameVariants.next
			result = doFindTypeByName(nextVariant, true)
		}
		result
	}
	
	def doFindTypeByName(String name, boolean traverseNestedTypes) {
		ProgressIndicatorProvider.checkCanceled
		val normalizedName = name.normalize
		val resourceURI = normalizedName.createResourceURI
		val fragment = normalizedName.fragment
		switch resourceSet : resourceSet {
			ISynchronizable<ResourceSet>:
				resourceSet.execute [
					findType(resourceURI, fragment, traverseNestedTypes)
				]
			default:
				findType(resourceURI, fragment, traverseNestedTypes)
		}
	}
	
	protected def normalize(String name) {
		if (name.startsWith('[')) {
			SignatureParsing.parseTypeString(new StringCharacterIterator(name))
		} else {
			name
		}
	}
	
	def findType(URI resourceURI, String fragment, boolean traverseNestedTypes) {
		val indexedJvmTypeAccess = indexedJvmTypeAccess
		if (indexedJvmTypeAccess != null) {
			val proxyURI = resourceURI.appendFragment(fragment)
			val candidate = indexedJvmTypeAccess.getIndexedJvmType(proxyURI, resourceSet)
			if (candidate instanceof JvmType) {
				return candidate
			}
		}
		ProgressIndicatorProvider.checkCanceled
		val resource = resourceSet.getResource(resourceURI, true)
		resource.findType(fragment, traverseNestedTypes)
	}
	
	protected def findType(Resource resource, String fragment, boolean traverseNestedTypes) {
		val result = resource.getEObject(fragment) as JvmType
		if (result != null || !traverseNestedTypes) {
			return result
		}
		val rootType = resource.contents.head
		if (rootType instanceof JvmDeclaredType) {
			val rootTypeName = resource.URI.segment(1)
			val nestedTypeName = fragment.substring(rootTypeName.length + 1)
			val segments = Strings.split(nestedTypeName, '$')
			return findNestedType(rootType, segments, 0)
		}
		return null
	}
	
	protected override createMirrorForFQN(String name) {
		val scope = switch it:resourceSet {
			XtextResourceSet: classpathURIContext as GlobalSearchScope
			default: GlobalSearchScope.allScope(project)
		}
		val psiClass = JavaPsiFacadeEx.getInstanceEx(project).findClass(name, scope)
		if (psiClass == null || psiClass.containingClass != null) {
			return null
		}
		new PsiClassMirror(psiClass, psiClassFactory)
	}
	
}