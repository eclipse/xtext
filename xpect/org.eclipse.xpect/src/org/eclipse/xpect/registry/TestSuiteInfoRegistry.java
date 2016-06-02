package org.eclipse.xpect.registry;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.util.URIDelegationHandler;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class TestSuiteInfoRegistry implements ITestSuiteInfo.Registry {

	private static final String ORG_XPECT_TEST_SUITE = "org.xpect.testSuite";
	private final static Logger LOG = Logger.getLogger(TestSuiteInfoRegistry.class);

	public static class Delegate implements ITestSuiteInfo.Registry {

		private ITestSuiteInfo.Registry delegate;

		public ITestSuiteInfo getTestSuite(Resource resource) {
			return delegate.getTestSuite(resource);
		}

		public void setDelegate(ITestSuiteInfo.Registry delegate) {
			this.delegate = delegate;
		}

		@Override
		public String toString() {
			return delegate.toString();
		}
	}

	public static class TestSuiteInfo implements ITestSuiteInfo {

		private final LazyClass<Object> clazz;
		private final Set<String> fileExtensions;

		public TestSuiteInfo(LazyClass<Object> clazz, Collection<String> fileExtensions) {
			super();
			this.clazz = clazz;
			this.fileExtensions = ImmutableSet.copyOf(fileExtensions);
		}

		public LazyClass<Object> getClazz() {
			return clazz;
		}

		public Set<String> getFileExtensions() {
			return fileExtensions;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this).add("fileExtensions", fileExtensions).add("class", clazz).toString();
		}

	}

	public static void main(String[] args) {
		System.out.println(new TestSuiteInfoRegistry().toString());
	}

	private final Map<String, ITestSuiteInfo> extToInfo;

	public TestSuiteInfoRegistry() {
		Multimap<LazyClass<Object>, String> suiteToExt = HashMultimap.create();
		for (IExtensionInfo info : IExtensionInfo.Registry.INSTANCE.getExtensions(ORG_XPECT_TEST_SUITE)) {
			LazyClass<Object> clazz = LazyClass.create(Object.class, info, "class");
			if (clazz == null) {
				LOG.warn("Attribute 'class' missing for extension '" + ORG_XPECT_TEST_SUITE + "' in " + info.getLocation());
				continue;
			}
			String fileExtension = info.getAttributeValue("fileExtension");
			if (fileExtension == null) {
				LOG.warn("Attribute 'fileExtension' missing for extension '" + ORG_XPECT_TEST_SUITE + "' in " + info.getLocation());
				continue;
			}
			suiteToExt.put(clazz, fileExtension);
		}
		Map<String, ITestSuiteInfo> infos = Maps.newHashMap();
		for (Map.Entry<LazyClass<Object>, Collection<String>> e : suiteToExt.asMap().entrySet()) {
			TestSuiteInfo info = new TestSuiteInfo(e.getKey(), e.getValue());
			for (String ext : e.getValue())
				infos.put(ext, info);
		}
		this.extToInfo = ImmutableMap.copyOf(infos);
	}

	public ITestSuiteInfo getTestSuite(Resource resource) {
		String fileExtension = new URIDelegationHandler().getOriginalFileExtension(resource.getURI().lastSegment());
		return extToInfo.get(fileExtension);
	}

	@Override
	public String toString() {
		Collection<ITestSuiteInfo> values = extToInfo.values();
		if (values.isEmpty())
			return "(empty)";
		return Joiner.on('\n').join(values);
	}

}
