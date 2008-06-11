package org.eclipse.xtext.ui.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.baseadaptor.BaseData;
import org.eclipse.osgi.framework.internal.core.BundleHost;
import org.eclipse.osgi.framework.internal.core.BundleURLConnection;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.ClasspathUriUtil;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.osgi.framework.Bundle;

public class BundleClasspathUriResolver implements IClasspathUriResolver {

    public URI resolve(Object context, URI classpathUri) {
        if (context instanceof Plugin) {
            context = ((Plugin) context).getBundle();
        }
        if (!(context instanceof Bundle)) {
            throw new IllegalArgumentException("Context must implement Bundle");
        }
        Bundle bundle = (Bundle) context;
        try {
            if (ClasspathUriUtil.isClassapthUri(classpathUri)) {
                return findResourceInBundle(bundle, classpathUri);
            }
        } catch (Exception exc) {
            throw new ClasspathUriResolutionException(exc);
        }
        return classpathUri;
    }


    @SuppressWarnings("restriction")
    private URI findResourceInBundle(Bundle bundle, URI classpathUri)
            throws MalformedURLException, IOException {
        Path fullPath = new Path(classpathUri.path());
        if (bundle != null) {
            // TODO try to use FileLocator instead
            String projectRelativePath = "/" + fullPath;
            URL resourceUrl = bundle.getResource(projectRelativePath);
            if (resourceUrl != null) {
                String baseUrl = ((BaseData) ((BundleHost) bundle)
                        .getBundleData()).getBundleFile().getBaseFile().toURL()
                        .toString();
                if (baseUrl.endsWith(".jar")) {
                    baseUrl = "jar:" + baseUrl + "!/";
                }
                String localUrl = ((BundleURLConnection) resourceUrl
                        .openConnection()).getLocalURL().toString();
                String platformPluginUri = bundle.getSymbolicName() + "/"
                        + localUrl.substring(baseUrl.length());
                URI normalizedURI = URI.createPlatformPluginURI(
                        platformPluginUri, true);
                return normalizedURI;
            }
        }
        return classpathUri;
    }

}
