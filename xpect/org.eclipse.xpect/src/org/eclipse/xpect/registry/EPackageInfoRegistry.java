package org.eclipse.xpect.registry;

import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EPackage;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class EPackageInfoRegistry implements IEPackageInfo.Registry {

	public static class EPackageInfo implements IEPackageInfo {
		private final IExtensionInfo source;

		public EPackageInfo(IExtensionInfo source) {
			this.source = source;
		}

		public LazyClass<EPackage> getEPackage() {
			String className = getEPackageClassName();
			return LazyClass.create(EPackage.class, className, source);
		}

		public String getEPackageClassName() {
			return source.getAttributeValue("class");
		}

		public String getGenmodel() {
			return source.getAttributeValue("genModel");
		}

		public String getNamespaceURI() {
			return source.getAttributeValue("uri");
		}

		public IExtensionInfo getSource() {
			return source;
		}

		@Override
		public String toString() {
			return "uri=" + getNamespaceURI() + " class=" + getEPackageClassName() + " genModel=" + getGenmodel();
		}
	}

	public static Logger LOG = Logger.getLogger(EPackageInfoRegistry.class);

	public static void main(String[] args) {
		System.out.println(new EPackageInfoRegistry().toString());
	}

	private final Map<String, IEPackageInfo> epackageInfos = ImmutableMap.copyOf(collectEPackageInfos());

	private Map<String, IEPackageInfo> collectEPackageInfos() {
		Map<String, IEPackageInfo> result = Maps.newHashMap();
		for (IExtensionInfo ext : IExtensionInfo.Registry.INSTANCE.getExtensions("org.eclipse.emf.ecore.generated_package")) {
			EPackageInfo info = new EPackageInfo(ext);
			String key = info.getNamespaceURI();
			IEPackageInfo conflict = result.get(key);
			if (conflict != null) {
				String loc1 = ((EPackageInfo) conflict).getSource().getLocation();
				String loc2 = info.getSource().getLocation();
				LOG.warn("namespaceURI " + key + " is already registered. File1: " + loc1 + " File2: " + loc2);
			} else
				result.put(key, info);
		}
		return result;
	}

	public IEPackageInfo getEPackageInfo(String namespaceURI) {
		return epackageInfos.get(namespaceURI);
	}

	public Collection<String> getNamespaceURIs() {
		return epackageInfos.keySet();
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(epackageInfos.values());
	}

}
