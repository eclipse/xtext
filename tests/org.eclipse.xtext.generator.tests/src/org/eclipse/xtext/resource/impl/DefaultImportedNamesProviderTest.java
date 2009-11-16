package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

public class DefaultImportedNamesProviderTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
	}
	
	public void testNotYetLinked() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
				"type Bar extends Foo"), null);
		
		Iterable<String> names = res2.getImportedNamesProvider().getImportedNames(res2);
		assertFalse(names.iterator().hasNext());
	}
	
	public void testValidExternalLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Bar extends Foo"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<String> names = res2.getImportedNamesProvider().getImportedNames(res2);
		assertEquals("Foo",names.iterator().next());
	}
	
	public void testValidLocalLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Foo type Bar extends Foo"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<String> names = res2.getImportedNamesProvider().getImportedNames(res2);
		assertFalse(names.iterator().hasNext());
	}
	
	public void testBrokenLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Bar extends Baz"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<String> names = res2.getImportedNamesProvider().getImportedNames(res2);
		assertEquals("Baz",names.iterator().next());
	}
}
