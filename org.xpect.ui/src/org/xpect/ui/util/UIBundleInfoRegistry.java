package org.xpect.ui.util;

import java.io.File;
import java.io.IOException;
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

		public UIBundleInfo(Bundle bundle) {
			super();
			this.bundle = bundle;
		}

		public Bundle getBundle() {
			return bundle;
		}

		private ResourceAccess.ResourceInfo getInfo() {
			return ResourceAccess.create(getRootURI());
		}

		public URI getRootURI() {
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

		public String getSymbolicName() {
			return bundle.getSymbolicName();
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
	}

	public Collection<String> getAllBundleNames() {
		Set<String> result = Sets.newLinkedHashSet();
		for (Bundle bundle : XpectPluginActivator.getInstance().getBundle().getBundleContext().getBundles())
			result.add(bundle.getSymbolicName());
		return result;
	}

	public IBundleInfo getBundle(String symbolicName) {
		Bundle bundle = Platform.getBundle(symbolicName);
		return bundle != null ? new UIBundleInfo(bundle) : null;
	}

	public IBundleInfo getBundle(Class<?> clazz) {
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		return bundle != null ? new UIBundleInfo(bundle) : null;
	}

	public IBundleInfo getBundle(URI uri) {
		return new IBundleInfo.BundleInfo(null, uri);
	}

}
