package org.eclipse.xtext.ui.services;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;
import org.eclipse.xtext.ui.core.service.IProposalsProvider;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;
import org.eclipse.xtext.ui.core.service.ITokenTypeDefService;

public class LanguageServiceActivator {

    private static final String LANGUAGE_DESCRIPTOR = "languageDescriptor";
    private static final String ID = "id";
    private static final String NAME = "name";

    public static void activateServices() {
        registerLanguageDescriptors();
        ILanguageDescriptor baseLanguageDescriptor = getBaseLanguageDescriptor();
        registerDefaultServices(baseLanguageDescriptor);
    }

    private static void registerDefaultServices(ILanguageDescriptor languageDescriptor) {
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IParser.class, "parser"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IElementFactory.class, "aSTFactory"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IParseTreeConstructor.class, "parseTreeConstructor"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IResourceFactory.class, "resourceFactory"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IPreferenceStoreService.class, "preferenceStore"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IProposalsProvider.class, "proposalsProvider"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, ISyntaxColorer.class, "syntaxColorer"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IGrammarAccess.class, "grammarAccess"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, IMetamodelAccess.class, "metamodelAccess"));
        ServiceRegistry.registerFactory(languageDescriptor, new GenericRegisteredServiceFactory(languageDescriptor, ITokenTypeDefService.class, "tokenTypeDef"));
        }

    private static void registerLanguageDescriptors() {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID, LANGUAGE_DESCRIPTOR);
        Assert.isNotNull(extensionPoint, "Extension point " + LANGUAGE_DESCRIPTOR + " not defined!");
        IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
        if (elements != null) {
            for (IConfigurationElement element : elements) {
                String languageId = element.getAttribute(ID);
                String languageName = element.getAttribute(NAME);
                String namespace = element.getNamespaceIdentifier();
                try {
                    ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor(languageId, languageName, namespace, null);
                    registerDefaultServices(languageDescriptor);
                } catch (Exception e) {
                    CoreLog.logError(e);
                }
            }
        }
    }

    private static ILanguageDescriptor getBaseLanguageDescriptor() {
        // TODO: replace after bootstrap
        return LanguageDescriptorFactory.get("org.eclipse.xtext.BaseLanguage");
    }
}
