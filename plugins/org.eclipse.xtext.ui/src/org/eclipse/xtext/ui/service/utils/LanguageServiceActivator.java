package org.eclipse.xtext.ui.service.utils;

import static org.eclipse.xtext.ui.service.utils.GenericRegisteredServiceFactory.getConfigurationElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;
import org.eclipse.xtext.ui.service.IFormatter;
import org.eclipse.xtext.ui.service.IHoverInfo;
import org.eclipse.xtext.ui.service.ILabelProvider;
import org.eclipse.xtext.ui.service.IOutlineProvider;
import org.eclipse.xtext.ui.service.IPreferenceStore;
import org.eclipse.xtext.ui.service.IProposalsProvider;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.service.utils.LanguageDescriptorHierarchyUtil.LanguageDescriptorDescriptor;

public class LanguageServiceActivator {

	private static final String LANGUAGE_DESCRIPTOR = "languageDescriptor";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String SUPER_LANGUAGE = "superLanguage";

	private static final Map<String, Class<? extends ILanguageService>> serviceMap;

	static {
		serviceMap = new HashMap<String, Class<? extends ILanguageService>>();
		serviceMap.put("parser", IParser.class);
		serviceMap.put("aSTFactory", IAstFactory.class);
		serviceMap.put("parseTreeConstructor", IParseTreeConstructor.class);
		serviceMap.put("preferenceStore", IPreferenceStore.class);
		serviceMap.put("proposalsProvider", IProposalsProvider.class);
		serviceMap.put("syntaxColorer", ISyntaxColorer.class);
		serviceMap.put("grammarAccess", IGrammarAccess.class);
		serviceMap.put("resourceFactory", IResourceFactory.class);
		serviceMap.put("metamodelAccess", IMetamodelAccess.class);
		serviceMap.put("tokenTypeDef", ITokenTypeDefProvider.class);
		serviceMap.put("valueConverter", IValueConverterService.class);
		serviceMap.put("labelProvider", ILabelProvider.class);
		serviceMap.put("outlineProvider", IOutlineProvider.class);
		serviceMap.put("formatter", IFormatter.class);
		serviceMap.put("hoverInfo", IHoverInfo.class);
		serviceMap.put("foldingStructureProvider", IFoldingStructureProvider.class);
	}

	public static void activateServices() {
		registerLanguageDescriptors();
	}

	private static void registerDefaultServices(ILanguageDescriptor languageDescriptor) {
		for (String serviceName : serviceMap.keySet()) {
			try {
				IConfigurationElement configurationElement = getConfigurationElement(serviceName, languageDescriptor);
				if (configurationElement != null) {
					ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(
							languageDescriptor, serviceMap.get(serviceName), configurationElement));
				}
			}
			catch (Exception e) {
				CoreLog.logError(e);
			}
		}

	}

	private static void registerLanguageDescriptors() {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID,
				LANGUAGE_DESCRIPTOR);
		Assert.isNotNull(extensionPoint, "Extension point " + LANGUAGE_DESCRIPTOR + " not defined!");
		IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
		if (elements != null) {
			List<LanguageDescriptorDescriptor> languageDDs = new ArrayList<LanguageDescriptorDescriptor>();
			for (IConfigurationElement element : elements) {
				LanguageDescriptorDescriptor languageDD = new LanguageDescriptorDescriptor();
				languageDD.languageId = element.getAttribute(ID);
				languageDD.languageName = element.getAttribute(NAME);
				languageDD.namespace = element.getNamespaceIdentifier();
				languageDD.superLanguageID = element.getAttribute(SUPER_LANGUAGE);
				languageDDs.add(languageDD);
			}
			languageDDs = LanguageDescriptorHierarchyUtil.sortLanguageDescriptors(languageDDs);
			for (LanguageDescriptorDescriptor languageDD : languageDDs) {
				try {
					ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor(
							languageDD.languageId, languageDD.languageName, languageDD.namespace,
							LanguageDescriptorFactory.get(languageDD.superLanguageID));
					registerDefaultServices(languageDescriptor);
				}
				catch (Exception e) {
					CoreLog.logError(e);
				}
			}
		}
	}

}
