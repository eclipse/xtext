package org.xpect.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.xpect.util.ResourceAccess.ResourceInfo;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public interface IBundleInfo {

	public class BundleInfo implements IBundleInfo {

		private ResourceInfo info;
		private final URI location;
		private final String symbolicName;

		public BundleInfo(String symbolicName, URI locationURI) {
			super();
			this.symbolicName = symbolicName;
			this.location = locationURI;
		}

		private ResourceInfo getInfo() {
			if (info == null)
				info = ResourceAccess.create(location);
			return info;
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

		public URI getRootURI() {
			return getInfo().getLocation();
		}

		public String getSymbolicName() {
			return symbolicName;
		}

		@Override
		public String toString() {
			return symbolicName + ": " + getInfo();
		}

	}

	public enum Context {
		CLASSPATH, ROOT, SOURCE
	}

	public class Delegate implements Registry {

		private IBundleInfo.Registry delegate;

		public Collection<String> getAllBundleNames() {
			return delegate.getAllBundleNames();
		}

		public IBundleInfo getBundle(Class<?> clazz) {
			return delegate.getBundle(clazz);
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

		public IBundleInfo getBundle(URI uri) {
			return delegate.getBundle(uri);
		}

	}

	public interface Registry {

		public final Registry INSTANCE = EcorePlugin.IS_ECLIPSE_RUNNING ? new Delegate() : new StandaloneBundleRegistry();

		Collection<String> getAllBundleNames();

		IBundleInfo getBundle(Class<?> clazz);

		IBundleInfo getBundle(URI uri);

		IBundleInfo getBundle(String symbolicName);
	}

	public class StandaloneBundleRegistry implements IBundleInfo.Registry {

		public static final Logger LOG = Logger.getLogger(StandaloneBundleRegistry.class);

		public static void main(String[] args) {
			System.out.println(new StandaloneBundleRegistry());
		}

		private final Map<URI, IBundleInfo> locationToBundle;
		private final Map<String, IBundleInfo> symbolicNameToBundle;

		public StandaloneBundleRegistry() {
			symbolicNameToBundle = Maps.newLinkedHashMap();
			locationToBundle = Maps.newLinkedHashMap();
			for (URL url : ClasspathUtil.findResources("META-INF/MANIFEST.MF")) {
				String name;
				try {
					name = ClasspathUtil.getSymbolicName(url.openStream());
					if (name != null) {
						URI location = URI.createURI(url.toString()).trimSegments(2).appendSegment("");
						BundleInfo info = createBundleInfo(name, location);
						symbolicNameToBundle.put(name, info);
						locationToBundle.put(location, info);
					}
				} catch (Throwable e) {
					LOG.error("can't open " + url, e);
				}
			}
		}

		private BundleInfo createBundleInfo(String name, URI location) {
			return new BundleInfo(name, location);
		}

		public Collection<String> getAllBundleNames() {
			return symbolicNameToBundle.keySet();
		}

		public IBundleInfo getBundle(Class<?> clazz) {
			URI bundleURI = getBundleURI(clazz);
			IBundleInfo info = locationToBundle.get(bundleURI);
			if (info != null)
				return info;
			info = createBundleInfo(null, bundleURI);
			locationToBundle.put(bundleURI, info);
			return info;
		}

		public IBundleInfo getBundle(String symbolicName) {
			return symbolicNameToBundle.get(symbolicName);
		}

		private URI getBundleURI(Class<?> clazz) {
			String[] segments = clazz.getName().split("\\.");
			String fileName = Joiner.on('/').join(segments) + ".class";
			URL resource = clazz.getClassLoader().getResource(fileName);
			if ("jar".equals(resource.getProtocol())) {
				URI location = URI.createURI(resource.toString()).trimSegments(segments.length).appendSegment("");
				return location;
			} else {
				File classFile;
				try {
					classFile = new File(resource.toURI());
					File packageRootFolder = classFile;
					for (int i = 0; i < segments.length; i++) {
						packageRootFolder = packageRootFolder.getParentFile();
						if (packageRootFolder == null)
							throw new RuntimeException("Could not determine package root for " + clazz);
					}
					File current = packageRootFolder;
					while (current != null) {
						if (new File(current, ".project").isFile())
							return URI.createFileURI(current.toString()).appendSegment("");
						current = current.getParentFile();
					}
					throw new RuntimeException("Could not find .project file in super-folder of " + packageRootFolder);
				} catch (URISyntaxException e) {
					throw new RuntimeException(e);
				}
			}
		}

		@Override
		public String toString() {
			return Joiner.on("\n").join(symbolicNameToBundle.values());
		}

		public IBundleInfo getBundle(URI uri) {
			return createBundleInfo(null, uri);
		}
	}

	List<URI> find(Context context);

	URI find(Context context, String fileName);

	List<URI> find(Context context, String path, Predicate<String> matcher, String... fileExtensions);

	URI getRootURI();

	String getSymbolicName();
}
