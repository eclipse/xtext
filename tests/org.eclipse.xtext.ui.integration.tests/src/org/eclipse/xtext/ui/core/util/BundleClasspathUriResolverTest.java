package org.eclipse.xtext.ui.core.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.ui.integration.XtextUIIntegrationTestsPlugin;
import org.eclipse.xtext.ui.util.BundleClasspathUriResolver;

public class BundleClasspathUriResolverTest extends AbstractClasspathUriResolverTest {

	private IClasspathUriResolver _resolver;

	@Override
	protected void setUp() throws Exception {
		_resolver = new BundleClasspathUriResolver();
	}

	public void testClasspathUriForFileInPlugin() {
		URI classpathUri = URI.createURI("classpath:/org/eclipse/xtext/ui/core/util/simple.ecore");
		URI normalizedUri = _resolver.resolve(Platform.getBundle(XtextUIIntegrationTestsPlugin.PLUGIN_ID), classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	public void testClasspathUriForFileInPluginWithFragment() {
		URI classpathUri = URI.createURI("classpath:/org/eclipse/xtext/ui/core/util/simple.ecore#/");
		URI normalizedUri = _resolver.resolve(Platform.getBundle(XtextUIIntegrationTestsPlugin.PLUGIN_ID), classpathUri);
		assertEquals("/", normalizedUri.fragment());
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	public void testPluginClasspathUriForJarredFile() {
		// doesn't work
	}

	public void testClasspathUriForEcore() {
		URI classpathUri = URI.createURI("classpath:/model/Ecore.ecore");
		URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.emf.ecore"), classpathUri);
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

	public void testClasspathUriForEcoreWithFragment() {
		URI classpathUri = URI.createURI("classpath:/model/Ecore.ecore#/");
		URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.emf.ecore"), classpathUri);
		assertEquals("/", normalizedUri.fragment());
		assertResourceLoadable(classpathUri, normalizedUri, null);
	}

}
