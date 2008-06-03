package org.eclipse.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.services.XtextASTFactoryServiceFactory;
import org.eclipse.xtext.services.XtextGrammarAccessServiceFactory;
import org.eclipse.xtext.services.XtextMetamodelAccessServiceFactory;
import org.eclipse.xtext.services.XtextParseTreeConstructorServiceFactory;
import org.eclipse.xtext.services.XtextParserServiceFactory;
import org.eclipse.xtext.services.XtextResourceFactoryServiceFactory;

public abstract class XtextStandaloneSetup {

    private static boolean isInitialized;

    public static void doSetup() {
        if (!isInitialized) {
            // setup super language first
            XtextBuiltinStandaloneSetup.doSetup();

            ILanguageDescriptor languageDescriptor = getLanguageDescriptor();

            ServiceRegistry.registerFactory(languageDescriptor, new XtextParserServiceFactory());

            ServiceRegistry.registerFactory(languageDescriptor, new XtextASTFactoryServiceFactory());

            ServiceRegistry.registerFactory(languageDescriptor, new XtextParseTreeConstructorServiceFactory());

            ServiceRegistry.registerFactory(languageDescriptor, new XtextResourceFactoryServiceFactory());

            ServiceRegistry.registerFactory(languageDescriptor, new XtextGrammarAccessServiceFactory());

            ServiceRegistry.registerFactory(languageDescriptor, new XtextMetamodelAccessServiceFactory());

            if (LanguageFacadeFactory.getFacade("org.eclipse.xtext.Xtext") == null) {
                ILanguageFacade facade = new XtextLanguageFacade();
                LanguageFacadeFactory.register(facade);
                Factory resourceFactory = facade.getResourceFactory();
                Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xtext", resourceFactory);
            }
            isInitialized = true;
        }
    }

    private static ILanguageDescriptor INSTANCE;

    public static final String LANGUAGE_ID = "org.eclipse.xtext.Xtext";
    public static final String LANGUAGE_NAME = "Xtext";
    public static final String NAMESPACE = "org/eclipse/xtext";

    public static ILanguageDescriptor getLanguageDescriptor() {
        if (INSTANCE == null) {
            INSTANCE = LanguageDescriptorFactory.get(LANGUAGE_ID);
            if (INSTANCE == null) {
                INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(LANGUAGE_ID, LANGUAGE_NAME, NAMESPACE,
                        XtextBuiltinStandaloneSetup.getLanguageDescriptor());
            }
        }
        return INSTANCE;
    }

}
