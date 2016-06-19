package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class DefaultResourceDescription2Test extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new LangATestLanguageStandaloneSetup());
	}
	
	@Test public void testNotYetLinked() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
				"type Bar extends Foo"), null);
		
		Iterable<QualifiedName> names = res2.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(res2).getImportedNames();
		assertTrue(names.iterator().hasNext());
	}
	
	
	@Test public void testValidExternalLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Bar extends Foo"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<QualifiedName> names = res2.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(res2).getImportedNames();
		assertEquals(QualifiedName.create("foo"),names.iterator().next());
	}
	
	@Test public void testValidLocalLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Foo type Bar extends Foo"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<QualifiedName> names = res2.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(res2).getImportedNames();
		assertFalse(names.iterator().hasNext());
	}
	
	@Test public void testBrokenLink() throws Exception {
		XtextResourceSet rs = get(XtextResourceSet.class);
		Resource res1 = rs.createResource(URI.createURI("foo.langatestlanguage"));
		res1.load(new StringInputStream("type Foo"), null);
		
		XtextResource res2 = (XtextResource) rs.createResource(URI.createURI("bar.langatestlanguage"));
		res2.load(new StringInputStream("import 'foo.langatestlanguage'" +
		"type Bar extends Baz"), null);
		
		EcoreUtil.resolveAll(res2);
		Iterable<QualifiedName> names = res2.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(res2).getImportedNames();
		assertEquals(QualifiedName.create("baz"),names.iterator().next());
	}
	
	@Test public void testClasspathURIIsNormalized() {
		XtextResourceSet xtextResourceSet = new XtextResourceSet();
		xtextResourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.ecore");
		Resource resource = xtextResourceSet.getResource(classpathURI, true);
		IResourceDescription ecoreResourceDescription = createResourceDescription(resource);
		assertNotSame(classpathURI, ecoreResourceDescription.getURI());
		assertEquals(xtextResourceSet.getURIConverter().normalize(classpathURI), ecoreResourceDescription.getURI());
	}

	protected IResourceDescription createResourceDescription(Resource testResource) {
		DefaultResourceDescriptionStrategy strategy = new DefaultResourceDescriptionStrategy();
		strategy.setQualifiedNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
				return (name != null) ? QualifiedName.create(name) : null;
			}
		});
		IResourceDescription resourceDescription = new DefaultResourceDescription(testResource, strategy);
		return resourceDescription;
	}
}
