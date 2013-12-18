package org.xpect.util;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

public interface IBundleInfo {

	public class BundleInfo implements IBundleInfo {

		private final URI locationURI;
		private final String symbolicName;

		public BundleInfo(String symbolicName, URI locationURI) {
			super();
			this.symbolicName = symbolicName;
			this.locationURI = locationURI;
		}

		public URI getLocationURI() {
			return locationURI;
		}

		public String getSynmbolicName() {
			return symbolicName;
		}

		@Override
		public String toString() {
			return symbolicName + ": " + locationURI;
		}

	}

	public class Delegate implements Registry {

		private IBundleInfo.Registry delegate;

		public Collection<String> getAllBundleNames() {
			return delegate.getAllBundleNames();
		}

		public IBundleInfo getBundle(String symbolicName) {
			return delegate.getBundle(symbolicName);
		}

		public IBundleInfo.Registry getDelegate() {
			return delegate;
		}

		public void setDelegate(IBundleInfo.Registry delegate) {
			this.delegate = delegate;
		}

	}

	public interface Registry {

		public final Registry INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new StandaloneBundleRegistry();

		Collection<String> getAllBundleNames();

		IBundleInfo getBundle(String symbolicName);
	}

	public class StandaloneBundleRegistry implements IBundleInfo.Registry {

		public static final Logger LOG = Logger.getLogger(StandaloneBundleRegistry.class);

		public static void main(String[] args) {
			System.out.println(new StandaloneBundleRegistry());
		}

		private final Map<String, IBundleInfo> bundles = collectBundles();

		private Map<String, IBundleInfo> collectBundles() {
			Map<String, IBundleInfo> result = Maps.newLinkedHashMap();
			for (URL url : ClasspathUtil.findResources("META-INF/MANIFEST.MF")) {
				String name;
				try {
					name = ClasspathUtil.getSymbolicName(url.openStream());
					if (name != null) {
						URI location = URI.createURI(url.toString()).trimSegments(2).appendSegment("");
						result.put(name, new BundleInfo(name, location));
					}
				} catch (IOException e) {
					LOG.error("can't open " + url, e);
				}
			}
			return result;
		}

		public Collection<String> getAllBundleNames() {
			return bundles.keySet();
		}

		public IBundleInfo getBundle(String symbolicName) {
			return bundles.get(symbolicName);
		}

		@Override
		public String toString() {
			return Joiner.on("\n").join(bundles.values());
		}
	}

	URI getLocationURI();

	String getSynmbolicName();
}
