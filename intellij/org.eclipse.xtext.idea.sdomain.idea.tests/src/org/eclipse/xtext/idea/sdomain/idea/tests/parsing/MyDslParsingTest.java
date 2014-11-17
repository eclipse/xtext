package org.eclipse.xtext.idea.sdomain.idea.tests.parsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.sdomain.idea.tests.parsing.NodeModelPrinter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.ParserDefinition;
import com.intellij.testFramework.ParsingTestCase;

public class MyDslParsingTest extends ParsingTestCase {
	
	@Inject
	private InvariantChecker invariantChecker;
	
	@Inject
	private Provider<XtextResourceSet> xtextResourceSetProvider;
	
	@Inject
	private Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider;
	
	private NodeModelPrinter nodeModelPrinter = new NodeModelPrinter();

	public MyDslParsingTest() {
		super("", "sdomain", SDomainLanguage.INSTANCE.getInstance(ParserDefinition.class));
		SDomainLanguage.INSTANCE.injectMembers(this);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		addExplicitExtension(LanguageASTFactory.INSTANCE, SDomainLanguage.INSTANCE, SDomainLanguage.INSTANCE.getInstance(BaseXtextASTFactory.class));
	}
	
	public void testNamespaces() {
		doTest(true);
	}
	
	public void testEntities() {
		doTest(true);
	}
	
	public void testDatatypes() {
		doTest(true);
	}
	
	public void testQualifiedNamespace() {
		doTest(true);
	}
	
	public void testQualifiedNamespace2() {
		doTest(true);
	}
	
	public void testCrossReferences() {
		doTest(true);
	}
	
	public void testSyntaxErrors() {
		doTest(true);
	}
	
	public void testSyntaxErrors2() {
		doTest(true);
	}
	
	public void testMissingTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery() {
		doTest(true);
	}
	
	public void testUnwantedTokenErrorRecovery2() {
		doTest(true);
	}
	
	@Override
	protected String getTestDataPath() {
		return "./testData/parsing";
	}
	
	@Override
	protected boolean skipSpaces() {
		return false;
	}
	
	@Override
	protected boolean includeRanges() {
		return true;
	}
	
	@Override
	protected void doTest(boolean checkResult) {
		super.doTest(checkResult);
		if (checkResult) {
			XtextResource expectedResource = getExpectedResource();
			ICompositeNode expectedRootNode = expectedResource.getParseResult().getRootNode();
			
			XtextResource actualResource = getActualResource();
			ICompositeNode actualRootNode = actualResource.getParseResult().getRootNode();
			
			assertEquals(nodeModelPrinter.print(expectedRootNode), nodeModelPrinter.print(actualRootNode));
			assertEquals(EmfFormatter.objToStr(expectedRootNode.getSemanticElement()), EmfFormatter.objToStr(actualRootNode.getSemanticElement()));
			
			invariantChecker.checkInvariant(actualRootNode);
			Map<ASTNode, INode> nodesMapping = PsiToEcoreAdapter.get(actualResource).getNodesMapping();
			for (ASTNode astNode : nodesMapping.keySet()) {
				INode node = nodesMapping.get(astNode);
				boolean belongsToTree = false;
				for (INode child : actualRootNode.getAsTreeIterable()) {
					if (child == node) {
						belongsToTree = true;
						break;
					}
				}
				assertTrue("Node " + node + " is not a part of the tree", belongsToTree);
			}
		}
	}

	protected XtextResource getActualResource() {
		PsiToEcoreTransformator psiToEcoreTransformator = psiToEcoreTransformatorProvider.get();
		psiToEcoreTransformator.setXtextFile((BaseXtextFile) myFile);
		
		XtextResourceSet resourceSet = xtextResourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI(myFile.getVirtualFile().getUrl()));
		resource.setParser(psiToEcoreTransformator);
		
		try {
			resource.load(new ByteArrayInputStream(new byte[0]), null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		psiToEcoreTransformator.getAdapter().install(resource);
		
		return resource;
	}

	protected XtextResource getExpectedResource() {
		XtextResourceSet resourceSet = xtextResourceSetProvider.get();
		XtextResource resource = (XtextResource) resourceSet.createResource(URI.createURI(myFile.getVirtualFile().getUrl()));
		try {
			resource.load(new ByteArrayInputStream(myFile.getText().getBytes()), null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return resource;
	}
	
}
