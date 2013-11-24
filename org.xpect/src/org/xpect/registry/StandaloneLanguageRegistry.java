/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.registry;

import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Modules2;
import org.xpect.registry.StandalonePluginXMLParser.EMFExtensionParserInfo;
import org.xpect.registry.StandalonePluginXMLParser.EMFGeneratedPackageInfo;
import org.xpect.registry.StandalonePluginXMLParser.EditorInfo;
import org.xpect.registry.StandalonePluginXMLParser.ExtensionInfo;
import org.xpect.XpectConstants;
import org.xpect.registry.IEmfFileExtensionInfo.IXtextFileExtensionInfo;
import org.xpect.services.XtResourceServiceProviderProvider;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StandaloneLanguageRegistry implements ILanguageInfo.Registry {

	protected static class StandaloneLanguageInfoImpl extends AbstractLanguageInfo {
		public StandaloneLanguageInfoImpl(IXtextFileExtensionInfo info) {
			super(info);
		}

		protected Injector createInjector(Module... modules) {
			if (modules.length > 0)
				return Guice.createInjector(Modules2.mixin(getRuntimeModule(), Modules2.mixin(modules)));
			else
				return Guice.createInjector(getRuntimeModule());
		}

	}

	private static final Logger LOG = Logger.getLogger(StandaloneLanguageRegistry.class);

	private static boolean running = false;

	private Map<String, ILanguageInfo> ext2language;

	private Map<String, ILanguageInfo> name2language;

	public StandaloneLanguageRegistry() {
		try {
			init();
		} catch (Throwable e) {
			LOG.error("Error initalizing language registry", e);
		}
	}

	public ILanguageInfo getLanguageByFileExtension(String fileExtension) {
		return ext2language.get(fileExtension);
	}

	public ILanguageInfo getLanguageByName(String name) {
		return name2language.get(name);
	}

	public Collection<ILanguageInfo> getLanguages() {
		return name2language.values();
	}

	protected void init() {
		ext2language = Maps.newHashMap();
		name2language = Maps.newHashMap();
		if (EcorePlugin.IS_ECLIPSE_RUNNING)
			throw new IllegalStateException("This class can only run in standalone mode (no OSGi, no Eclipse)");
		if (running)
			throw new IllegalStateException("I want to be a singleton!");
		running = true;

		for (String nsURI : IEPackageInfo.Registry.INSTANCE.getNamespaceURIs())
			EPackageRegistrar.register(IEPackageInfo.Registry.INSTANCE.getEPackageInfo(nsURI));

		for (IEmfFileExtensionInfo info : IEmfFileExtensionInfo.Registry.INSTANCE.getFileExtensionInfos()) {
			FileExtensionRegistrar.register(info);
			if (info instanceof IXtextFileExtensionInfo) {
				StandaloneLanguageInfoImpl infoImpl = new StandaloneLanguageInfoImpl((IXtextFileExtensionInfo) info);
				name2language.put(infoImpl.getLanguageName(), infoImpl);
				for (String ext : info.getFileExtensions())
					ext2language.put(ext, infoImpl);
			}
		}
<<<<<<< Upstream, based on ab758eabcbd837e460cbeb6f775e18e54587191d
	}

	protected ILanguageInfo registerEFactoryWithInjector(String uiName, Collection<EditorInfo> editors,
			Collection<EMFExtensionParserInfo> parsers) {
		if (editors.size() > 0) {
			EditorInfo editor = editors.iterator().next();
			Map<String, String> extension2factory = Maps.newLinkedHashMap();
			for (EMFExtensionParserInfo info : parsers)
				extension2factory.put(info.getType(), info.getClazz());
			StandaloneLanguageInfoImpl impl = new StandaloneLanguageInfoImpl(editor.getRtLang(), uiName, extension2factory.keySet());
			for (Map.Entry<String, String> entry : extension2factory.entrySet()) {
				ResourceFactoryDescriptorForXtext descriptor = new ResourceFactoryDescriptorForXtext(impl, entry.getValue());
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), descriptor);
				ResourceServiceProviderProviderImpl provider = new ResourceServiceProviderProviderImpl(impl);
				IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(entry.getKey(), provider);
			}
			return impl;
		}
		return null;
	}

	protected void registerEFactoryWithoutInjector(EMFExtensionParserInfo info) {
		ResourceFactoryDescriptorForEMF descriptor = new ResourceFactoryDescriptorForEMF(info.getClazz());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(info.getType(), descriptor);
	}

	protected void registerEPackage(EMFGeneratedPackageInfo info) {
		EPackage.Registry.INSTANCE.put(info.getUri(), new EPackageDescriptorImpl(info));
		if (info.getGenModel() != null)
			EcorePlugin.getEPackageNsURIToGenModelLocationMap().put(info.getUri(), URI.createURI(info.getGenModel()));
		else {
			LOG.warn("No GenModel found for EPackage " + info.getUri());
		}
=======
		registerRSPProviderForXt();
>>>>>>> 719c471 improved detection of installed Xtext languages
	}
}
