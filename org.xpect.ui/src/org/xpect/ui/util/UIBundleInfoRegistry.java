package org.xpect.ui.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;
import org.xpect.ui.XpectPluginActivator;
import org.xpect.util.IBundleInfo;

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

		public URI getLocationURI() {
			try {
				return URI.createURI(FileLocator.resolve(bundle.getEntry("/")).toString());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public String getSynmbolicName() {
			return bundle.getSymbolicName();
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

}
