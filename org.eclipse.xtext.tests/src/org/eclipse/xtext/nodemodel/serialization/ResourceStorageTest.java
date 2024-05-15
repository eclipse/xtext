package org.eclipse.xtext.nodemodel.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.detachable.DetachableNodeModelBuilder;
import org.eclipse.xtext.nodemodel.detachable.DetachableParseResult;
import org.eclipse.xtext.nodemodel.detachable.StorageAwareDetachableParseResultWrapper;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;
import org.eclipse.xtext.resource.ParseResultWrapper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.simpleExpressions.Expression;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ResourceStorageTest extends AbstractXtextTests {
	
	public static class CustomSetup extends SimpleExpressionsTestLanguageStandaloneSetup {
		@SuppressWarnings("unused")
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new SimpleExpressionsTestLanguageRuntimeModule() {
				public Class<? extends IResourceStorageFacade> bindIResourceStorageFacade() {
					return ResourceStorageFacade.class;
				}
				@Override
				public Class<? extends XtextResource> bindXtextResource() {
					return StorageAwareResource.class;
				}
				public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
					return JavaIoFileSystemAccess.class;
				}
				public Class<? extends ParseResultWrapper> bindParseResultWrapper() {
					return StorageAwareDetachableParseResultWrapper.class;
				}
				public Class<? extends NodeModelBuilder> bindNodeModelBuilder() {
					return DetachableNodeModelBuilder.class;
				}
				public Class<? extends PartialParsingHelper> bindPartialParsingHelper() {
					return null;
				}
			});
		}
	}
	

	public static class InMemoryURIConverter extends ExtensibleURIConverterImpl {
		private final Map<URI, InputStream> models = new HashMap<URI, InputStream>();

		public void addModel(String uri, String content) {
			models.put(URI.createURI(uri), new StringInputStream(content));
		}

		@Override
		public boolean exists(URI uri, Map<?, ?> options) {
			boolean result = models.containsKey(uri);
			if (!result) {
				for (URI knownUri : models.keySet()) {
					if (uri.toString().endsWith(knownUri.toString())) {
						return true;
					}
				}
			}
			return result;
		}

		@Override
		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			return models.get(uri);
		}
	}
	
	private ParserTestHelper helper;

	@Inject
	private ResourceStorageFacade resourceStorageFacade;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(CustomSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
		injectMembers(this);
	}

	@Test
	public void testWriteAndLoad_01() throws Exception {
		String modelAsString = "(d - e) / e * d // fasdf s";
		doTestWriteAndLoad(modelAsString);
	}
	
	@Test
	public void testWriteAndLoad_02() throws Exception {
		String modelAsString = "a + b + c + d + e +";
		doTestWriteAndLoad(modelAsString);
	}
	
	void doTestWriteAndLoad(String modelAsString) throws Exception {
		StorageAwareResource originalResource = parse(modelAsString);
		DetachableParseResult originalParseResult = (DetachableParseResult) originalResource.getParseResult();
		RootNode originalRootNode = (RootNode) originalParseResult.getRootNode();
		
		Expression model = (Expression) originalResource.getContents().get(0);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		resourceStorageFacade.setStoreNodeModel(true);
		resourceStorageFacade.createResourceStorageWritable(bout).writeResource(originalResource);
		ResourceStorageLoadable in = resourceStorageFacade.createResourceStorageLoadable(new ByteArrayInputStream(bout.toByteArray()));
		StorageAwareResource reloadedResource = (StorageAwareResource) originalResource.getResourceSet().createResource(URI.createURI("synthetic:/Test." + originalResource.getURI().fileExtension()));
		InMemoryURIConverter converter = new InMemoryURIConverter();
		converter.addModel(reloadedResource.getURI().toString(), modelAsString);
		reloadedResource.getResourceSet().setURIConverter(converter);
		originalResource.getResourceSet().getResources().add(reloadedResource);
		reloadedResource.loadFromStorage(in);
		Expression reloadedModel = (Expression) reloadedResource.getContents().get(0);
		EqualityHelper equalityHelper = new EqualityHelper();
		assertTrue(equalityHelper.equals(model, reloadedModel));
		
		DetachableParseResult reloadedParseResult = (DetachableParseResult) reloadedResource.getParseResult();
		RootNode reloadedRootNode = (RootNode) reloadedParseResult.getRootNode();
		
		assertEqualNodes(originalRootNode, reloadedRootNode, equalityHelper);
		
		assertEquals(originalParseResult.hasSyntaxErrors(), reloadedParseResult.hasSyntaxErrors());
		
		// By default, de-serialized resources don't populate the error list 
		reloadedResource.relink();
		
		assertEquals(originalResource.getErrors().size(), reloadedResource.getErrors().size());
	}
	
	protected void assertEqualNodes(RootNode expected, RootNode actual, EqualityHelper equalityHelper) throws IOException {
		Iterator<INode> expectedIter = expected.getAsTreeIterable().iterator();
		Iterator<INode> actualIter = actual.getAsTreeIterable().iterator();
		while(expectedIter.hasNext()) {
			assertTrue(actualIter.hasNext());
			doAssertEqualNodes(expectedIter.next(), actualIter.next(), equalityHelper);
		}
		assertFalse(actualIter.hasNext());
	}

	protected void doAssertEqualNodes(INode expected, INode actual, EqualityHelper equalityHelper) {
		assertEquals("class", expected.getClass(), actual.getClass());
		assertEquals("text", expected.getText(), actual.getText());
		assertEquals("total offset", expected.getTotalOffset(), actual.getTotalOffset());
		assertEquals("total length", expected.getTotalLength(), actual.getTotalLength());
		assertEquals("grammar element", expected.getGrammarElement(), actual.getGrammarElement());
		assertEquals("direct semantic element", expected.hasDirectSemanticElement(), actual.hasDirectSemanticElement());
		assertTrue(equalityHelper.equals(expected.getSemanticElement(), actual.getSemanticElement()));
		assertEquals("syntax error message", expected.getSyntaxErrorMessage(), actual.getSyntaxErrorMessage());
		if (expected instanceof ICompositeNode) {
			assertEquals("lookAhead", ((ICompositeNode) expected).getLookAhead(), ((ICompositeNode) actual).getLookAhead());
		}
	}
	
	protected StorageAwareResource parse(String modelAsString) throws IOException {
		return (StorageAwareResource) helper.getResourceFromString(modelAsString);
	}
}
