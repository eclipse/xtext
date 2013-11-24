package org.xpect.registry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.xpect.registry.IEmfFileExtensionInfo.IXtextFileExtensionInfo;
import org.xpect.registry.IExtensionInfo.Registry;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Module;

public class FileExtensionInfoRegistry implements IEmfFileExtensionInfo.Registry {

	private static class EditorInfo extends Info {

		private final String languageID;
		private final LazyClass<Module> runtimeModule;
		private final LazyClass<Module> uiModule;

		public EditorInfo(IExtensionInfo source) {
			super(source, "extensions");
			this.languageID = source.getAttributeValue("id");
			this.runtimeModule = LazyClass.create(Module.class, this.languageID + "RuntimeModule", source);
			LazyClass<Object> editorClass = LazyClass.create(Object.class, source, "class");
			this.uiModule = newUIModule(editorClass);
		}

		@Override
		public String getLanguageID() {
			return languageID;
		}

		@Override
		public LazyClass<Module> getRuntimeModule() {
			return runtimeModule;
		}

		@Override
		public LazyClass<Module> getUIModule() {
			return uiModule;
		}

	}

	private static class EmfExtensionParserInfo extends Info {

		private final LazyClass<Factory> resourceFactory;
		private final LazyClass<Module> uiModule;

		public EmfExtensionParserInfo(IExtensionInfo source) {
			super(source, "type");
			this.resourceFactory = LazyClass.create(Factory.class, source, "class");
			this.uiModule = newUIModule(resourceFactory);
		}

		@Override
		public LazyClass<Factory> getResourceFactory() {
			return resourceFactory;
		}

		@Override
		public LazyClass<Module> getUIModule() {
			return uiModule;
		}

	}

	public static class EmfFileExtensionInfo implements IEmfFileExtensionInfo {
		private final Set<String> fileExtensions;
		private final LazyClass<Factory> resourceFactory;

		private final Set<IExtensionInfo> traces;

		public EmfFileExtensionInfo(Set<String> fileExtensions, LazyClass<Factory> resourceFactory, Set<IExtensionInfo> traces) {
			super();
			this.traces = ImmutableSet.copyOf(traces);
			this.fileExtensions = ImmutableSet.copyOf(fileExtensions);
			this.resourceFactory = resourceFactory;
		}

		public Set<String> getFileExtensions() {
			return fileExtensions;
		}

		public LazyClass<Factory> getResourceFactory() {
			return resourceFactory;
		}

		public Set<IExtensionInfo> getTraces() {
			return traces;
		}

		@Override
		public String toString() {
			ToStringHelper result = Objects.toStringHelper(IEmfFileExtensionInfo.class).add("fileExtensions", fileExtensions);
			if (resourceFactory != null && !DEFAULT_RESOURCE_FACTORY.equals(resourceFactory.getName()))
				result.add("resourceFactory", resourceFactory);
			return result.toString();
		}

	}

	public static class FileExtensionInfo {
		private final String fileExtension;
		private final String languageID;
		private final LazyClass<Factory> resourceFactory;
		private final LazyClass<IResourceServiceProvider> resourceServiceProvider;
		private final LazyClass<IResourceServiceProvider> resourceUIServiceProvider;
		private final LazyClass<Module> runtimeModule;
		private final Set<IExtensionInfo> traces;
		private final LazyClass<Module> uiModule;

		public FileExtensionInfo(String fileExtension, String languageID, LazyClass<Factory> resourceFactory,
				LazyClass<IResourceServiceProvider> resourceServiceProvider, LazyClass<IResourceServiceProvider> resourceUIServiceProvider,
				LazyClass<Module> runtimeModule, LazyClass<Module> uiModule, Set<IExtensionInfo> traces) {
			super();
			this.fileExtension = fileExtension;
			this.languageID = languageID;
			this.resourceFactory = resourceFactory;
			this.resourceServiceProvider = resourceServiceProvider;
			this.resourceUIServiceProvider = resourceUIServiceProvider;
			this.runtimeModule = runtimeModule;
			this.uiModule = uiModule;
			this.traces = ImmutableSet.copyOf(traces);
		}

		@Override
		public String toString() {
			ToStringHelper result = Objects.toStringHelper(this).add("fileExtension", fileExtension);
			if (resourceFactory != null && !DEFAULT_RESOURCE_FACTORY.equals(resourceFactory.getName()))
				result.add("resourceFactory", resourceFactory);
			if (languageID != null)
				result.add("languageID", languageID);
			if (runtimeModule != null)
				result.add("runtimeModule", runtimeModule);
			if (uiModule != null)
				result.add("uiModule", uiModule);
			if (resourceServiceProvider != null && !DEFAULT_RESOURCE_SERVICE_PROVIDER.equals(resourceServiceProvider.getName()))
				result.add("resourceServiceProvider", resourceServiceProvider);
			if (resourceUIServiceProvider != null && !DEFAULT_RESOURCE_UI_SERVICE_PROVIDER.equals(resourceUIServiceProvider.getName()))
				result.add("resourceUIServiceProvider", resourceUIServiceProvider);
			return result.toString();
		}
	}

	private static class Info {

		private Set<String> fileExtensions;
		private IExtensionInfo trace;

		public Info(IExtensionInfo trace, String fileExtensionAttributeName) {
			this.trace = trace;
			this.fileExtensions = Sets.newHashSet();
			String exts = trace.getAttributeValue(fileExtensionAttributeName);
			if (exts != null)
				for (String ext : exts.split(","))
					this.fileExtensions.add(ext.trim());
		}

		public Collection<String> getFileExtensions() {
			return fileExtensions;
		}

		public String getLanguageID() {
			return null;
		}

		public LazyClass<Resource.Factory> getResourceFactory() {
			return null;
		}

		public LazyClass<IResourceServiceProvider> getResourceServiceProvider() {
			return null;
		}

		public LazyClass<IResourceServiceProvider> getResourceUIServiceProvider() {
			return null;
		}

		public LazyClass<Module> getRuntimeModule() {
			return null;
		}

		public IExtensionInfo getTrace() {
			return trace;
		}

		public LazyClass<Module> getUIModule() {
			return null;
		}

		protected LazyClass<Module> newUIModule(LazyClass<?> clazz) {
			if (clazz != null && clazz.getFactory() != null)
				return LazyClass.create(Module.class, clazz.getFactory() + "UiModule", clazz.getLoader());
			return null;
		}
	}

	public static class XtextFileExtensionInfo extends EmfFileExtensionInfo implements IXtextFileExtensionInfo {
		private final String languageID;
		private final LazyClass<IResourceServiceProvider> resourceServiceProvider;
		private final LazyClass<IResourceServiceProvider> resourceUIServiceProvider;
		private final LazyClass<Module> runtimeModule;

		private final LazyClass<Module> uiModule;

		public XtextFileExtensionInfo(Set<String> fileExtensions, LazyClass<Factory> resourceFactory, String languageID,
				LazyClass<IResourceServiceProvider> resourceServiceProvider, LazyClass<IResourceServiceProvider> resourceUIServiceProvider,
				LazyClass<Module> runtimeModule, LazyClass<Module> uiModule, Set<IExtensionInfo> traces) {
			super(fileExtensions, resourceFactory, traces);

			this.languageID = languageID;
			this.resourceServiceProvider = resourceServiceProvider;
			this.resourceUIServiceProvider = resourceUIServiceProvider;
			this.runtimeModule = runtimeModule;
			this.uiModule = uiModule;
		}

		public String getLanguageID() {
			return languageID;
		}

		public LazyClass<IResourceServiceProvider> getResourceServiceProvider() {
			return resourceServiceProvider;
		}

		public LazyClass<IResourceServiceProvider> getResourceUIServiceProvider() {
			return resourceUIServiceProvider;
		}

		public LazyClass<Module> getRuntimeModule() {
			return runtimeModule;
		}

		public LazyClass<Module> getUIModule() {
			return uiModule;
		}

		public boolean hasInjector() {
			return runtimeModule != null;
		}

		@Override
		public String toString() {
			ToStringHelper result = Objects.toStringHelper(IXtextFileExtensionInfo.class).add("fileExtensions", getFileExtensions());
			if (getResourceFactory() != null && !DEFAULT_RESOURCE_FACTORY.equals(getResourceFactory().getName()))
				result.add("resourceFactory", getResourceFactory());
			if (languageID != null)
				result.add("languageID", languageID);
			if (runtimeModule != null)
				result.add("runtimeModule", runtimeModule);
			if (uiModule != null)
				result.add("uiModule", uiModule);
			if (resourceServiceProvider != null && !DEFAULT_RESOURCE_SERVICE_PROVIDER.equals(resourceServiceProvider.getName()))
				result.add("resourceServiceProvider", resourceServiceProvider);
			if (resourceUIServiceProvider != null && !DEFAULT_RESOURCE_UI_SERVICE_PROVIDER.equals(resourceUIServiceProvider.getName()))
				result.add("resourceUIServiceProvider", resourceUIServiceProvider);
			return result.toString();
		}

	}

	private static class XtextResourceServiceProviderInfo extends Info {

		private final LazyClass<IResourceServiceProvider> resourceUIServiceProvider;
		private final LazyClass<Module> uiModule;

		public XtextResourceServiceProviderInfo(IExtensionInfo source) {
			super(source, "uriExtension");
			this.resourceUIServiceProvider = LazyClass.create(IResourceServiceProvider.class, source, "class");
			this.uiModule = newUIModule(resourceUIServiceProvider);
		}

		@Override
		public LazyClass<IResourceServiceProvider> getResourceUIServiceProvider() {
			return resourceUIServiceProvider;
		}

		@Override
		public LazyClass<Module> getUIModule() {
			return uiModule;
		}

	}

	private static final String DEFAULT_RESOURCE_FACTORY = IResourceFactory.class.getName();

	private static final String DEFAULT_RESOURCE_SERVICE_PROVIDER = IResourceServiceProvider.class.getName();

	private static final String DEFAULT_RESOURCE_UI_SERVICE_PROVIDER = "org.eclipse.xtext.ui.resource.IResourceUIServiceProvider";

	private final static Logger LOG = Logger.getLogger(FileExtensionInfoRegistry.class);

	public static void main(String[] args) {
		System.out.println(new FileExtensionInfoRegistry());
	}

	private final List<IEmfFileExtensionInfo> allInfos = ImmutableList.copyOf(collectFileExtensionInfos());

	private final Map<String, IEmfFileExtensionInfo> fileExtensio2Info = ImmutableMap.copyOf(collectFileExtensionInfosByExt(allInfos));

	private List<IEmfFileExtensionInfo> collectFileExtensionInfos() {
		List<Info> infos = Lists.newArrayList();
		Registry registry = IExtensionInfo.Registry.INSTANCE;
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.emf.ecore.extension_parser"))
			infos.add(new EmfExtensionParserInfo(ext));
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.xtext.extension_resourceServiceProvider"))
			infos.add(new XtextResourceServiceProviderInfo(ext));
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.ui.editors")) {
			EditorInfo editorInfo = new EditorInfo(ext);
			if (editorInfo.getUIModule() != null)
				infos.add(editorInfo);
		}

		Multimap<String, Info> ext2info = HashMultimap.create();
		for (Info info : infos)
			for (String ext : info.getFileExtensions())
				ext2info.put(ext, info);

		List<IEmfFileExtensionInfo> allInfos = Lists.newArrayList();
		Multimap<String, FileExtensionInfo> name2xtextInfo = HashMultimap.create();
		for (String ext : ext2info.keySet()) {
			FileExtensionInfo merged = mergeByFileExt(ext, ext2info.get(ext));
			if (merged.languageID == null)
				allInfos.add(toEmfFileExtensionInfo(merged));
			else
				name2xtextInfo.put(merged.languageID, merged);
		}
		for (String name : name2xtextInfo.keySet())
			allInfos.add(mergeByLang(name, name2xtextInfo.get(name)));

		return allInfos;
	}

	private Map<String, IEmfFileExtensionInfo> collectFileExtensionInfosByExt(List<IEmfFileExtensionInfo> allInfos) {
		Map<String, IEmfFileExtensionInfo> result = Maps.newHashMap();
		for (IEmfFileExtensionInfo info : allInfos)
			for (String ext : info.getFileExtensions())
				result.put(ext, info);
		return result;
	}

	public IEmfFileExtensionInfo getEmfFileExtensionInfo(String fileExtension) {
		return fileExtensio2Info.get(fileExtension);
	}

	public Collection<IEmfFileExtensionInfo> getFileExtensionInfos() {
		return allInfos;
	}

	private <T> T merge(T o1, T o2, Collection<IExtensionInfo> traceIn, Set<IExtensionInfo> tracOut, String name, String context) {
		if (o2 != null) {
			Collection<IExtensionInfo> trace;
			if (o2 instanceof LazyClass<?>) {
				IExtensionInfo cand = ((LazyClass<?>) o2).getTrace();
				trace = cand == null ? Collections.<IExtensionInfo> emptySet() : Collections.singleton(cand);
			} else
				trace = traceIn;
			if (o1 == null) {
				if (trace != null)
					tracOut.addAll(trace);
				return o2;
			} else if (name != null && !o1.equals(o2)) {
				String message = "Conflicting " + name + ": '" + o1 + "' and '" + o2 + "'";
				HashSet<IExtensionInfo> set = Sets.newHashSet(tracOut);
				set.addAll(trace);
				List<String> tr = Lists.newArrayList();
				for (IExtensionInfo e : set)
					tr.add(e + " from " + e.getLocation());
				LOG.warn(message + " " + context + " Traces:\n\t" + Joiner.on("\n\t").join(tr));
			}
		}
		return o1;
	}

	private FileExtensionInfo mergeByFileExt(String fileExtension, Collection<Info> infos) {
		Set<IExtensionInfo> traces = Sets.newHashSet();
		String languageID = null;
		LazyClass<Factory> resourceFactory = null;
		LazyClass<IResourceServiceProvider> rsp = null;
		LazyClass<IResourceServiceProvider> rUIsp = null;
		LazyClass<Module> runtimeModule = null;
		LazyClass<Module> uiModule = null;

		String context = "FileExtension: " + fileExtension;
		for (Info info : infos) {
			Collection<IExtensionInfo> traceIn = Collections.singleton(info.getTrace());
			languageID = merge(languageID, info.getLanguageID(), traceIn, traces, "Xtext LanguageIDs", context);
			resourceFactory = merge(resourceFactory, info.getResourceFactory(), traceIn, traces, "EMF Resource Factories", context);
			rsp = merge(rsp, info.getResourceServiceProvider(), traceIn, traces, "Xtext Resource Service Provider", context);
			rUIsp = merge(rUIsp, info.getResourceUIServiceProvider(), traceIn, traces, "Xtext Resource UI Service Provider", context);
			runtimeModule = merge(runtimeModule, info.getRuntimeModule(), traceIn, traces, "Xtext Runtime Modules", context);
			uiModule = merge(uiModule, info.getUIModule(), traceIn, traces, "Xtext UI Modules", context);
		}

		return new FileExtensionInfo(fileExtension, languageID, resourceFactory, rsp, rUIsp, runtimeModule, uiModule, traces);
	}

	private XtextFileExtensionInfo mergeByLang(String langID, Collection<FileExtensionInfo> infos) {
		Set<IExtensionInfo> traces = Sets.newHashSet();
		Set<String> fileExtensions = Sets.newHashSet();
		LazyClass<Factory> resourceFactory = null;
		LazyClass<IResourceServiceProvider> rsp = null;
		LazyClass<IResourceServiceProvider> rUIsp = null;
		LazyClass<Module> runtimeModule = null;
		LazyClass<Module> uiModule = null;

		String context = "XtextLanguageID: " + langID;
		for (FileExtensionInfo info : infos) {
			fileExtensions.add(info.fileExtension);
			resourceFactory = merge(resourceFactory, info.resourceFactory, info.traces, traces, "EMF Resource Factories", context);
			rsp = merge(rsp, info.resourceServiceProvider, info.traces, traces, "Xtext Resource Service Provider", context);
			rUIsp = merge(rUIsp, info.resourceUIServiceProvider, info.traces, traces, "Xtext Resource UI Service Provider", context);
			runtimeModule = merge(runtimeModule, info.runtimeModule, info.traces, traces, "Xtext Runtime Modules", context);
			uiModule = merge(uiModule, info.uiModule, info.traces, traces, "Xtext UI Modules", context);
		}

		if (resourceFactory == null && runtimeModule != null)
			resourceFactory = LazyClass.create(Resource.Factory.class, DEFAULT_RESOURCE_FACTORY, runtimeModule.getLoader());
		if (rsp == null && runtimeModule != null)
			rsp = LazyClass.create(IResourceServiceProvider.class, DEFAULT_RESOURCE_SERVICE_PROVIDER, runtimeModule.getLoader());
		if (rUIsp == null && uiModule != null)
			rUIsp = LazyClass.create(IResourceServiceProvider.class, DEFAULT_RESOURCE_UI_SERVICE_PROVIDER, uiModule.getLoader());

		return new XtextFileExtensionInfo(fileExtensions, resourceFactory, langID, rsp, rUIsp, runtimeModule, uiModule, traces);
	}

	private EmfFileExtensionInfo toEmfFileExtensionInfo(FileExtensionInfo info) {
		warnIfSet(info, info.resourceServiceProvider, "resourceServiceProvider");
		warnIfSet(info, info.resourceUIServiceProvider, "resourceUIServiceProvider");
		warnIfSet(info, info.runtimeModule, "runtimeModule");
		warnIfSet(info, info.uiModule, "uiModule");
		return new EmfFileExtensionInfo(Collections.singleton(info.fileExtension), info.resourceFactory, info.traces);
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(allInfos);
	}

	private void warnIfSet(FileExtensionInfo info, Object value, String name) {
		if (value != null)
			LOG.warn("Ignoring " + name + " '" + value + "' for fileExtension '" + info.fileExtension + "'");
	}

}
