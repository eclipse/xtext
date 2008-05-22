package org.eclipse.xtext.ui.core.util;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IClasspathUriResolver;

public class BundleClasspathUriResolverTests extends AbstractClasspathUriResolverTests {

    private IClasspathUriResolver _resolver;

    @Override
    protected void setUp() throws Exception {
        _resolver = new BundleClasspathUriResolver();
    }

    @Override
    protected void tearDown() throws Exception {
        if (_project != null && _project.exists()) {
            _project.delete(true, null);
        }
    }

    public void testClasspathUriForFileInPlugin() {
        URI classpathUri = URI.createURI("classpath:/org/eclipse/xtext/ui/core/util/mydsl.ecore");
        String expectedUri = "platform:/plugin/org.eclipse.xtext.ui.core/bin/org/eclipse/xtext/ui/core/util/mydsl.ecore";
        URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.xtext.ui.core"), classpathUri);
        assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
    }

    public void testPluginClasspathUriForJarredFile() {
        // doesn't work
    }

    public void testClasspathUriForEcore() {
        URI classpathUri = URI.createURI("classpath:/model/Ecore.ecore");
        String expectedUri = "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore";
        URI normalizedUri = _resolver.resolve(Platform.getBundle("org.eclipse.emf.ecore"), classpathUri);
        assertResourceLoadable(classpathUri, normalizedUri, expectedUri);
    }

}
