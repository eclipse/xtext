package org.eclipse.xtext.xbase.idea.tests.parsing

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.lang.ASTNode
import com.intellij.lang.LanguageASTFactory
import com.intellij.lang.ParserDefinition
import com.intellij.testFramework.ParsingTestCase
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.idea.tests.TestDecorator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.EmfFormatter
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage

@TestDecorator
class XbaseParsingTest extends ParsingTestCase implements XExpressionChecker {

	IdeaXbaseParserTest delegate

	@Inject InvariantChecker invariantChecker

	@Inject Provider<XtextResourceSet> xtextResourceSetProvider

	@Inject Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider
	
	@Inject
	ValidationTestHelper validationHelper

	NodeModelPrinter nodeModelPrinter = new NodeModelPrinter()

	new() {
		super("", "___xbase", XbaseLanguage.INSTANCE.getInstance(ParserDefinition))
		XbaseLanguage.INSTANCE.injectMembers(this)
		delegate = new IdeaXbaseParserTest(this)
	}

	@Override override protected void setUp() {
		super.setUp()
		addExplicitExtension(LanguageASTFactory.INSTANCE, XbaseLanguage.INSTANCE,
			XbaseLanguage.INSTANCE.getInstance(BaseXtextASTFactory))
	}

	@Override override protected String getTestDataPath() {
		return "./testData/parsing"
	}

	@Override override protected boolean skipSpaces() {
		return false
	}

	@Override override protected boolean includeRanges() {
		return true
	}

	override XExpression testExpression(String code, boolean resolve) {
		super.doCodeTest(code)
		var XtextResource expectedResource = getExpectedResource()
		var ICompositeNode expectedRootNode = expectedResource.getParseResult().getRootNode()
		var XtextResource actualResource = getActualResource()
		var ICompositeNode actualRootNode = actualResource.getParseResult().getRootNode()
		assertEquals(nodeModelPrinter.print(expectedRootNode), nodeModelPrinter.print(actualRootNode))
		assertEquals(EmfFormatter.objToStr(expectedRootNode.getSemanticElement()),
			EmfFormatter.objToStr(actualRootNode.getSemanticElement()))
		invariantChecker.checkInvariant(actualRootNode)
		var Map<ASTNode, INode> nodesMapping = PsiToEcoreAdapter.get(actualResource).getNodesMapping()
		for (ASTNode astNode : nodesMapping.keySet()) {

			var INode node = nodesMapping.get(astNode)
			var boolean belongsToTree = false
			for (INode child : actualRootNode.getAsTreeIterable()) {
				if (child == node) {
					belongsToTree = true /* FIXME unsupported BreakStatement: */
				}

			}
			assertTrue('''Node «node» is not a part of the tree''', belongsToTree)
		}
		val expression = actualResource.contents.head as XExpression
		if (resolve) {
			validationHelper.assertNoErrors(expression)
		}
		expression
	}

	def protected XtextResource getActualResource() {
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

	def protected XtextResource getExpectedResource() {
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
