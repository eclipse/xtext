package org.eclipse.xtext.ui.tests.core.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.util.BundleClasspathUriResolver;
import org.junit.Before;
import org.junit.Test;

public class BundleClasspathUriResolverTest extends AbstractClasspathUriResolverTest {

	private IClasspathUriResolver _resolver;

	@Before
	public void setUp() throws Exception {
		_resolver = new BundleClasspathUriResolver();
	}

	@Test public void testClasspathUriForFileInPlugin() {
		URI classpathUri = URI.createURI("classpath:/org/eclipse/xtext/ui/tests/util/simple.ecore");
		URI normalizedUri = _resolver.resolve(Activator.getInstance(), classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	@Test public void testClasspathUriForFileInPluginWithFragment() {
		URI classpathUri = URI.createURI("classpath:/org/eclipse/xtext/ui/tests/util/simple.ecore#/");
		URI normalizedUri = _resolver.resolve(Activator.getInstance(), classpathUri);
		assertEquals("/", normalizedUri.fragment());
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	@Test public void testPluginClasspathUriForJarredFile() {
		// doesn't work
	}

	@Test public void testClasspathUriForEcore() {
		URI classpathUri = URI.createURI("classpath:/model/Ecore.ecore");
		URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.emf.ecore"), classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	@Test public void testClasspathUriForEcoreWithFragment() {
		URI classpathUri = URI.createURI("classpath:/model/Ecore.ecore#/");
		URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.emf.ecore"), classpathUri);
		assertEquals("/", normalizedUri.fragment());
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

}
