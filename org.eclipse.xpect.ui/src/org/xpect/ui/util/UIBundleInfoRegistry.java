package org.xpect.ui.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.xpect.ui.XpectPluginActivator;
import org.xpect.util.IBundleInfo;
import org.xpect.util.ResourceAccess;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public class UIBundleInfoRegistry implements IBundleInfo.Registry {

	public static class UIBundleInfo implements IBundleInfo {
		private final Bundle bundle;
		private final URI locationURI;

		public UIBundleInfo(URI locationURI, Bundle bundle) {
			super();
			this.locationURI = locationURI;
			this.bundle = bundle;
		}

		public List<URI> find(Context context) {
			return getInfo().find(context);
		}

		public URI find(Context context, String fileName) {
			return getInfo().find(context, fileName);
		}

		public List<URI> find(Context context, String path, Predicate<String> matcher, String... fileExtensions) {
			return getInfo().find(context, path, matcher, fileExtensions);
		}

		public Bundle getBundle() {
			return bundle;
		}

		private ResourceAccess.ResourceInfo getInfo() {
			return ResourceAccess.create(getRootURI());
		}

		public URI getRootURI() {
			return locationURI;
		}

		public String getSymbolicName() {
			return bundle.getSymbolicName();
		}

		@Override
		public String toString() {
			String type = Platform.isFragment(bundle) ? "fragment" : "bundle";
			return type + " '" + getSymbolicName() + "' locationURI:" + getRootURI();
		}

	}

	public Collection<String> getAllBundleNames() {
		Set<String> result = Sets.newLinkedHashSet();
		for (Bundle bundle : XpectPluginActivator.getInstance().getBundle().getBundleContext().getBundles())
			result.add(bundle.getSymbolicName());
		return result;
	}

	public IBundleInfo getBundle(Class<?> clazz) {
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		if (bundle == null)
			return null;
		URI locationURI = getBundleLocationURI(bundle);
		Bundle[] fragments = Platform.getFragments(bundle);
		if (fragments == null || fragments.length == 0)
			return new UIBundleInfo(locationURI, bundle);
		String classURI = getClassURI(clazz).toString();
		if (classURI.startsWith(locationURI.toString()))
			return new UIBundleInfo(locationURI, bundle);
		for (Bundle fragment : fragments) {
			URI fragmentURI = getBundleLocationURI(fragment);
			if (classURI.startsWith(fragmentURI.toString()))
				return new UIBundleInfo(fragmentURI, fragment);
		}
		return null;
	}

	public IBundleInfo getBundle(String symbolicName) {
		Bundle bundle = Platform.getBundle(symbolicName);
		return bundle != null ? new UIBundleInfo(getBundleLocationURI(bundle), bundle) : null;
	}

	public IBundleInfo getBundle(URI uri) {
		return new IBundleInfo.BundleInfo(null, uri);
	}

	private URI getBundleLocationURI(Bundle bundle) {
		try {
			URI uri = URI.createURI(FileLocator.resolve(bundle.getEntry("/")).toString());
			if (uri.isArchive())
				return uri;
			File current = new File(uri.toFileString());
			while (current != null) {
				if (new File(current, "META-INF").isDirectory())
					return URI.createFileURI(current.toString()).appendSegment("");
			}
			return uri;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private URI getClassURI(Class<?> clazz) {
		try {
			URL resource = clazz.getClassLoader().getResource("/" + clazz.getName().replace('.', '/') + ".class");
			URL url = FileLocator.resolve(resource);
			return URI.createURI(url.toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
