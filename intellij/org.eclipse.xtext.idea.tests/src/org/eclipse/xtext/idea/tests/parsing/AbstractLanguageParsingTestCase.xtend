package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.LanguageASTFactory
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.testFramework.ParsingTestCase
import java.io.ByteArrayInputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet

import static extension org.eclipse.xtext.util.EmfFormatter.*
import org.eclipse.emf.ecore.EObject

abstract class AbstractLanguageParsingTestCase extends ParsingTestCase implements ModelChecker {

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

	@Inject
	@Accessors(PROTECTED_GETTER)
	BaseXtextASTFactory astFactory
	
	@Inject
	@Accessors(PROTECTED_GETTER)
	ValidationTestHelper validationHelper

	override protected setUp() throws Exception {
		super.setUp()
		addExplicitExtension(LanguageASTFactory.INSTANCE, myLanguage, astFactory)
	}

	override protected tearDown() throws Exception {
		super.tearDown()
		actualResource = null
		expectedResource = null
	}

	new(LanguageFileType fileType) {
		this("", fileType)
	}

	new(String dataPath, LanguageFileType fileType) {
		this(dataPath, fileType.defaultExtension, fileType.language as IXtextLanguage)
	}

	new(String fileExt, IXtextLanguage language) {
		this("", fileExt, language.getInstance(ParserDefinition))
	}

	new(String dataPath, String fileExt, IXtextLanguage language) {
		super(dataPath, fileExt, language.getInstance(ParserDefinition))
		language.injectMembers(this)
	}

	new(String dataPath, String fileExt, ParserDefinition... definitions) {
		super(dataPath, fileExt, definitions)
	}

	new(String dataPath, String fileExt, boolean lowercaseFirstLetter, ParserDefinition... definitions) {
		super(dataPath, fileExt, lowercaseFirstLetter, definitions)
	}
	
	override <T extends EObject> checkModel(String code, boolean validate) {
		doCodeTest(code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
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
