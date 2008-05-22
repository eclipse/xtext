package org.eclipse.xtext.resource;

import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


public class ClassloaderClasspathUriResolverTests extends TestCase {
	private ClassloaderClasspathUriResolver _resolver;
	private ClassLoader _classLoader;

	@Override
	protected void setUp() throws Exception {
		_resolver = new ClassloaderClasspathUriResolver();
		_classLoader = getClass().getClassLoader();
		Thread.currentThread().setContextClassLoader(_classLoader);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
	}

	public void testClasspathUriForFile() {
		URI classpathUri = URI
				.createURI("classpath:/org/eclipse/xtext/resource/mydsl.ecore");
		URL rootURL = getClass().getClassLoader().getResource(
				"org/eclipse/xtext/resource/mydsl.ecore");
		String expectedUri = rootURL.toString();
		normalizeUriAndLoadResource(classpathUri, expectedUri);
	}

	public void testClasspathUriForFileInJar() {
		URI classpathUri = URI.createURI("classpath:/model/simple.ecore");
		URL rootURL = getClass().getClassLoader().getResource(
				"model/simple.ecore");
		String expectedUri = rootURL.toString();
		normalizeUriAndLoadResource(classpathUri, expectedUri);
	}

	private void normalizeUriAndLoadResource(URI classpathUri,
			String expectedUri) {
		URI normalizedUri = _resolver.resolve(_classLoader, classpathUri);
		assertEquals(expectedUri, normalizedUri.toString());
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(normalizedUri, true);
		assertNotNull("Classpth URI ot registered", resource);
		assertTrue("Resource not loaded", resource.isLoaded());
	}

	public static void main(String[] args) {
		new ClassloaderClasspathUriResolverTests().testClasspathUriForFileInJar();
	}
}
