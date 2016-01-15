package org.eclipse.xpect.registry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xpect.registry.IEmfFileExtensionInfo.IXtextFileExtensionInfo;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Module;

public class FileExtensionInfoRegistry implements IEmfFileExtensionInfo.Registry {

	private abstract static class Data {
		protected LazyClass<Object> editor = null;
		protected String languageID = null;
		protected LazyClass<Factory> resFact = null;
		protected LazyClass<IResourceServiceProvider> resSvP = null;
		protected LazyClass<IResourceServiceProvider> resUISvP = null;
		protected LazyClass<Module> runtimeModule = null;
		protected LazyClass<Module> sharedModule = null;
		protected LazyClass<Module> uiModule = null;

		abstract protected String getFileExtensionString();

		@Override
		public String toString() {
			ToStringHelper result = Objects.toStringHelper(this).add("fileExtension", getFileExtensionString());
			if (resFact != null && !DEFAULT_RESOURCE_FACTORY.equals(resFact.getName()))
				result.add("resourceFactory", resFact);
			if (languageID != null)
				result.add("languageID", languageID);
			if (runtimeModule != null)
				result.add("runtimeModule", runtimeModule);
			if (uiModule != null)
				result.add("uiModule", uiModule);
			if (sharedModule != null && !DEFAULT_SHARED_STATE_MODULE.equals(sharedModule.getName()))
				result.add("sharedStateModule", sharedModule);
			if (resSvP != null && !DEFAULT_RESOURCE_SERVICE_PROVIDER.equals(resSvP.getName()))
				result.add("resourceServiceProvider", resSvP);
			if (resUISvP != null && !DEFAULT_RESOURCE_UI_SERVICE_PROVIDER.equals(resUISvP.getName()))
				result.add("resourceUIServiceProvider", resUISvP);
			return result.toString();
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
			List<String> extensions = Lists.newArrayList(fileExtensions);
			Collections.sort(extensions);
			ToStringHelper result = Objects.toStringHelper(IEmfFileExtensionInfo.class).add("fileExtensions", extensions);
			if (resourceFactory != null && !DEFAULT_RESOURCE_FACTORY.equals(resourceFactory.getName()))
				result.add("resourceFactory", resourceFactory);
			return result.toString();
		}

	}

	private static class ExtensionPointData extends Data {
		private Set<String> fileExtensions;
		private IExtensionInfo trace;

		public ExtensionPointData(IExtensionInfo trace, String fileExtensionAttributeName) {
			this.trace = trace;
			this.fileExtensions = Sets.newHashSet();
			String exts = trace.getAttributeValue(fileExtensionAttributeName);
			if (exts != null)
				for (String ext : exts.split(","))
					this.fileExtensions.add(ext.trim());
		}

		@Override
		protected String getFileExtensionString() {
			return Joiner.on(", ").join(fileExtensions);
		}

	}

	private static class FileExtensionData extends Data {
		protected String fileExtension;
		protected Set<IExtensionInfo> traces;

		@Override
		protected String getFileExtensionString() {
			return fileExtension;
		}

		public List<String> getLocations() {
			List<String> locations = Lists.newArrayList();
			for (IExtensionInfo trace : traces) {
				String location = trace.getLocation();
				if (!Strings.isEmpty(location))
					locations.add(location);
			}
			return locations;
		}
	}

	public static class XtextFileExtensionInfo extends EmfFileExtensionInfo implements IXtextFileExtensionInfo {
		private final String languageID;
		private final LazyClass<IResourceServiceProvider> resourceServiceProvider;
		private final LazyClass<IResourceServiceProvider> resourceUIServiceProvider;
		private final LazyClass<Module> runtimeModule;
		private final LazyClass<Module> sharedModule;
		private final LazyClass<Module> uiModule;

		public XtextFileExtensionInfo(Set<String> fileExtensions, LazyClass<Factory> resourceFactory, String languageID,
				LazyClass<IResourceServiceProvider> resourceServiceProvider, LazyClass<IResourceServiceProvider> resourceUIServiceProvider, LazyClass<Module> runtimeModule,
				LazyClass<Module> uiModule, LazyClass<Module> sharedModule, Set<IExtensionInfo> traces) {
			super(fileExtensions, resourceFactory, traces);

			this.languageID = languageID;
			this.resourceServiceProvider = resourceServiceProvider;
			this.resourceUIServiceProvider = resourceUIServiceProvider;
			this.runtimeModule = runtimeModule;
			this.uiModule = uiModule;
			this.sharedModule = sharedModule;
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

		public LazyClass<Module> getSharedModule() {
			return sharedModule;
		}

		public LazyClass<Module> getUIModule() {
			return uiModule;
		}

		public boolean hasInjector() {
			return runtimeModule != null;
		}

		@Override
		public String toString() {
			List<String> extensions = Lists.newArrayList(getFileExtensions());
			Collections.sort(extensions);
			ToStringHelper result = Objects.toStringHelper(IXtextFileExtensionInfo.class).add("fileExtensions", extensions);
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

	private static final String DEFAULT_RESOURCE_FACTORY = IResourceFactory.class.getName();
	private static final String DEFAULT_RESOURCE_SERVICE_PROVIDER = IResourceServiceProvider.class.getName();
	private static final String DEFAULT_RESOURCE_UI_SERVICE_PROVIDER = "org.eclipse.xtext.ui.resource.IResourceUIServiceProvider";
	private static final String DEFAULT_SHARED_STATE_MODULE = "org.eclipse.xtext.ui.shared.SharedStateModule";

	public static void main(String[] args) {
		System.out.println(new FileExtensionInfoRegistry());
	}

	private final Map<String, IEmfFileExtensionInfo> fileExtension2Info;

	private final List<IEmfFileExtensionInfo> infos;

	private final List<String> issues;

	public FileExtensionInfoRegistry() {
		this(IExtensionInfo.Registry.INSTANCE);
	}

	public FileExtensionInfoRegistry(IExtensionInfo.Registry registry) {
		List<String> issues = Lists.newArrayList();
		this.infos = ImmutableList.copyOf(collectFileExtensionInfos(registry, issues));
		this.fileExtension2Info = ImmutableMap.copyOf(collectFileExtensionInfosByExt(infos));
		this.issues = ImmutableList.copyOf(issues);
	}

	private List<IEmfFileExtensionInfo> collectFileExtensionInfos(IExtensionInfo.Registry registry, Collection<String> issues) {
		List<ExtensionPointData> infos = Lists.newArrayList();
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.emf.ecore.extension_parser"))
			infos.add(parseEmfExtensionParser(ext));
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.xtext.extension_resourceServiceProvider"))
			infos.add(parseXtextResourceUIServiceProvider(ext));
		for (IExtensionInfo ext : registry.getExtensions("org.eclipse.ui.editors")) {
			ExtensionPointData editorInfo = parseEditorExtension(ext);
			if (editorInfo.editor != null && editorInfo.editor.getFactory() != null)
				infos.add(editorInfo);
		}
		for (IExtensionInfo ext : registry.getExtensions("org.xpect.fileExtensions"))
			infos.add(parseXpectFileExtensionInfo(ext));

		Multimap<String, ExtensionPointData> ext2info = HashMultimap.create();
		for (ExtensionPointData info : infos)
			for (String ext : info.fileExtensions)
				if (ext != null && !"___xbase".equals(ext) && !"xt".equals(ext))
					ext2info.put(ext, info);

		List<IEmfFileExtensionInfo> allInfos = Lists.newArrayList();
		Multimap<String, FileExtensionData> name2xtextInfo = HashMultimap.create();
		for (String ext : ext2info.keySet()) {
			FileExtensionData merged = mergeByFileExt(ext, ext2info.get(ext), issues);
			if (merged.languageID == null)
				allInfos.add(toEmfFileExtensionInfo(merged, issues));
			else
				name2xtextInfo.put(merged.languageID, merged);
		}
		for (String name : name2xtextInfo.keySet())
			allInfos.add(mergeByLang(name, name2xtextInfo.get(name), issues));

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
		return fileExtension2Info.get(fileExtension);
	}

	public Collection<IEmfFileExtensionInfo> getFileExtensionInfos() {
		return infos;
	}

	private <T> T merge(T o1, T o2, Collection<IExtensionInfo> traceIn, Set<IExtensionInfo> tracOut, String name, String context, Collection<String> issues) {
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
				issues.add("WARNING:" + message + " " + context + " Traces:\n\t" + Joiner.on("\n\t").join(tr));
			}
		}
		return o1;
	}

	private FileExtensionData mergeByFileExt(String fileExtension, Collection<ExtensionPointData> infos, Collection<String> issues) {
		FileExtensionData result = new FileExtensionData();
		result.fileExtension = fileExtension;
		result.traces = Sets.newHashSet();
		String context = "FileExtension: " + fileExtension;
		for (ExtensionPointData info : infos) {
			Collection<IExtensionInfo> trace = Collections.singleton(info.trace);
			result.languageID = merge(result.languageID, info.languageID, trace, result.traces, "Xtext LanguageIDs", context, issues);
			result.resFact = merge(result.resFact, info.resFact, trace, result.traces, "EMF Resource Factories", context, issues);
			result.resSvP = merge(result.resSvP, info.resSvP, trace, result.traces, "Xtext Resource Service Provider", context, issues);
			result.resUISvP = merge(result.resUISvP, info.resUISvP, trace, result.traces, "Xtext Resource UI Service Provider", context, issues);
			result.runtimeModule = merge(result.runtimeModule, info.runtimeModule, trace, result.traces, "Xtext Runtime Modules", context, issues);
			result.uiModule = merge(result.uiModule, info.uiModule, trace, result.traces, "Xtext UI Modules", context, issues);
			result.sharedModule = merge(result.sharedModule, info.sharedModule, trace, result.traces, "Xtext Shared State Modules", context, issues);
			result.editor = merge(result.editor, info.editor, trace, result.traces, null, context, issues);
		}
		return result;
	}

	private XtextFileExtensionInfo mergeByLang(String langID, Collection<FileExtensionData> infos, Collection<String> issues) {
		Set<IExtensionInfo> traces = Sets.newHashSet();
		Set<String> fileExtensions = Sets.newHashSet();
		LazyClass<Factory> resFact = null;
		LazyClass<IResourceServiceProvider> rsp = null;
		LazyClass<IResourceServiceProvider> rUIsp = null;
		LazyClass<Module> runtimeModule = null;
		LazyClass<Module> uiModule = null;
		LazyClass<Module> sharedModule = null;
		LazyClass<Object> editor = null;

		String context = "XtextLanguageID: " + langID;
		for (FileExtensionData info : infos) {
			fileExtensions.add(info.fileExtension);
			resFact = merge(resFact, info.resFact, info.traces, traces, "EMF Resource Factories", context, issues);
			rsp = merge(rsp, info.resSvP, info.traces, traces, "Xtext Resource Service Provider", context, issues);
			rUIsp = merge(rUIsp, info.resUISvP, info.traces, traces, "Xtext Resource UI Service Provider", context, issues);
			runtimeModule = merge(runtimeModule, info.runtimeModule, info.traces, traces, "Xtext Runtime Modules", context, issues);
			uiModule = merge(uiModule, info.uiModule, info.traces, traces, "Xtext UI Modules", context, issues);
			sharedModule = merge(sharedModule, info.sharedModule, info.traces, traces, "Xtext Shared State Modules", context, issues);
			editor = merge(editor, info.editor, info.traces, traces, null, context, issues);
		}

		if (resFact == null && runtimeModule != null)
			resFact = LazyClass.create(Resource.Factory.class, DEFAULT_RESOURCE_FACTORY, runtimeModule.getLoader());
		if (rsp == null && runtimeModule != null)
			rsp = LazyClass.create(IResourceServiceProvider.class, DEFAULT_RESOURCE_SERVICE_PROVIDER, runtimeModule.getLoader());
		if (uiModule == null)
			for (LazyClass<?> clazz : new LazyClass[] { rUIsp, editor, resFact, rsp })
				if (clazz != null && clazz.getFactory() != null) {
					uiModule = LazyClass.create(Module.class, clazz.getFactory() + "UiModule", clazz.getLoader());
					break;
				}
		if (rUIsp == null && uiModule != null)
			rUIsp = LazyClass.create(IResourceServiceProvider.class, DEFAULT_RESOURCE_UI_SERVICE_PROVIDER, uiModule.getLoader());
		if (sharedModule == null && uiModule != null)
			sharedModule = LazyClass.create(Module.class, DEFAULT_SHARED_STATE_MODULE, uiModule.getLoader());

		return new XtextFileExtensionInfo(fileExtensions, resFact, langID, rsp, rUIsp, runtimeModule, uiModule, sharedModule, traces);
	}

	private ExtensionPointData parseEditorExtension(IExtensionInfo info) {
		ExtensionPointData result = new ExtensionPointData(info, "extensions");
		result.languageID = info.getAttributeValue("id");
		result.runtimeModule = LazyClass.create(Module.class, result.languageID + "RuntimeModule", info);
		result.editor = LazyClass.create(Object.class, info, "class");
		return result;
	}

	private ExtensionPointData parseEmfExtensionParser(IExtensionInfo info) {
		ExtensionPointData result = new ExtensionPointData(info, "type");
		result.resFact = LazyClass.create(Factory.class, info, "class");
		return result;
	}

	private ExtensionPointData parseXpectFileExtensionInfo(IExtensionInfo info) {
		ExtensionPointData result = new ExtensionPointData(info, "fileExtension");
		result.resFact = LazyClass.create(Resource.Factory.class, info, "emfResourceFactory");
		result.languageID = info.getAttributeValue("xtextLanguageName");
		result.resSvP = LazyClass.create(IResourceServiceProvider.class, info, "xtextResourceServiceProvider");
		result.resUISvP = LazyClass.create(IResourceServiceProvider.class, info, "xtextResourceUIServiceProvider");
		result.runtimeModule = LazyClass.create(Module.class, info, "xtextRuntimeModule");
		result.uiModule = LazyClass.create(Module.class, info, "xtextUiModule");
		result.sharedModule = LazyClass.create(Module.class, info, "xtextSharedStateModule");
		return result;
	}

	private ExtensionPointData parseXtextResourceUIServiceProvider(IExtensionInfo info) {
		ExtensionPointData result = new ExtensionPointData(info, "uriExtension");
		result.resUISvP = LazyClass.create(IResourceServiceProvider.class, info, "class");
		return result;
	}

	private EmfFileExtensionInfo toEmfFileExtensionInfo(FileExtensionData info, Collection<String> issues) {
		warnIfSet(info, info.resSvP, "resourceServiceProvider", issues);
		warnIfSet(info, info.resUISvP, "resourceUIServiceProvider", issues);
		warnIfSet(info, info.runtimeModule, "runtimeModule", issues);
		// warnIfSet(info, info.uiModule, "uiModule");
		return new EmfFileExtensionInfo(Collections.singleton(info.fileExtension), info.resFact, info.traces);
	}

	@Override
	public String toString() {
		return Joiner.on("\n").join(Iterables.concat(issues, infos));
	}

	private void warnIfSet(FileExtensionData info, Object value, String name, Collection<String> issues) {
		if (value != null)
			issues.add("WARNING: Ignoring " + name + " '" + value + "' for fileExtension '" + info.fileExtension + "' from " + info.getLocations());
	}

}
