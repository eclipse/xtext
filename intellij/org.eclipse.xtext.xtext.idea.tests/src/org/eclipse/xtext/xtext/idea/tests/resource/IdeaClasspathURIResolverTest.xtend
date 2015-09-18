package org.eclipse.xtext.xtext.idea.tests.resource

import org.eclipse.xtext.idea.lang.XtextFileType
import org.eclipse.xtext.idea.tests.LightToolingTest
import org.junit.Test
import org.eclipse.xtext.idea.resource.IdeaClasspathURIResolver
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.ClasspathUriUtil
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil
import com.intellij.psi.search.GlobalSearchScope

class IdeaClasspathURIResolverTest extends LightToolingTest {
	
	new() {
		super(XtextFileType.INSTANCE)
	}
	
	val resolver = new IdeaClasspathURIResolver()
	
	@Test def void testResolveFromSourceFolder() {
		val file = myFixture.addFileToProject("foo/MyFile.text", "My Contents")
		val result = resolver.resolve(myFixture.module, URI.createURI(ClasspathUriUtil.CLASSPATH_SCHEME+"://foo/MyFile.text"))
		assertEquals(VirtualFileURIUtil.getURI(file.virtualFile), result)
	}
	
	@Test def void testResolveFromLibrary() {
		val type = myFixture.javaFacade.findClass("java.lang.String", GlobalSearchScope.moduleWithLibrariesScope(myFixture.module))
		val result = resolver.resolve(myFixture.module, URI.createURI(ClasspathUriUtil.CLASSPATH_SCHEME+"://java/lang/String.class"))
		assertEquals(VirtualFileURIUtil.getURI(type.containingFile.virtualFile), result)
	}
	
}