package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.ParserDefinition
import com.intellij.testFramework.ParsingTestCase
import java.io.ByteArrayInputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet

import static extension org.eclipse.xtext.util.EmfFormatter.*

abstract class AbstractLanguageParsingTestCase extends ParsingTestCase {

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension NodeModelPrinter nodeModelPrinter

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension InvariantChecker invariantChecker

	@Inject 
	@Accessors(PROTECTED_GETTER)
	Provider<XtextResourceSet> xtextResourceSetProvider

	@Inject 
	@Accessors(PROTECTED_GETTER)
	Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider
	
	@Accessors(PROTECTED_GETTER)
	XtextResource actualResource
	
	@Accessors(PROTECTED_GETTER)
	XtextResource expectedResource
	
	override protected tearDown() throws Exception {
		super.tearDown()
		actualResource = null
		expectedResource = null
	}

	new(String dataPath, String fileExt, ParserDefinition... definitions) {
		super(dataPath, fileExt, definitions)
	}

	new(String dataPath, String fileExt, boolean lowercaseFirstLetter, ParserDefinition... definitions) {
		super(dataPath, fileExt, lowercaseFirstLetter, definitions)
	}
	
	override protected includeRanges() {
		true
	}
	
	override protected doTest(boolean checkResult) {
		super.doTest(checkResult)
		if (checkResult) {
			assertResource
		}
	}
	
	override protected doCodeTest(String code) throws IOException {
		super.doCodeTest(code)
		assertResource
	}
	
	protected def void assertResource() {
		actualResource = createActualResource
		expectedResource = createExpectedResource
		val expectedRootNode = expectedResource.parseResult.rootNode
		val actualRootNode = actualResource.parseResult.rootNode
		assertEquals(expectedRootNode.print, actualRootNode.print)
		assertEquals(expectedRootNode.semanticElement.objToStr, actualRootNode.semanticElement.objToStr)
		actualRootNode.checkInvariant
		val nodesMapping = PsiToEcoreAdapter.get(actualResource).nodesMapping
		for (astNode : nodesMapping.keySet) {
			val node = nodesMapping.get(astNode)
			var belongsToTree = false
			for (child : actualRootNode.asTreeIterable) {
				if (child == node) {
					belongsToTree = true /* FIXME unsupported BreakStatement: */
				}
			}
			assertTrue('''Node «node» is not a part of the tree''', belongsToTree)
		}
	}

	def protected XtextResource createActualResource() {
		var PsiToEcoreTransformator psiToEcoreTransformator = psiToEcoreTransformatorProvider.get()
		psiToEcoreTransformator.setXtextFile(myFile as BaseXtextFile)
		var XtextResourceSet resourceSet = xtextResourceSetProvider.get()
		var XtextResource resource = resourceSet.createResource(URI.createURI(myFile.getVirtualFile().getUrl())) as XtextResource
		resource.setParser(psiToEcoreTransformator)
		try {
			resource.load(new ByteArrayInputStream(newByteArrayOfSize(0)), null)
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		psiToEcoreTransformator.getAdapter().install(resource)
		return resource
	}

	def protected XtextResource createExpectedResource() {
		var XtextResourceSet resourceSet = xtextResourceSetProvider.get()
		var XtextResource resource = resourceSet.createResource(URI.createURI(myFile.getVirtualFile().getUrl())) as XtextResource
		try {
			resource.load(new ByteArrayInputStream(myFile.getText().getBytes()), null)
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return resource
	}

}
