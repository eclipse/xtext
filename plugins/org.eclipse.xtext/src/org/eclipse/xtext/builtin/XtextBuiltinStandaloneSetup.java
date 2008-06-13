package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

public class XtextBuiltinStandaloneSetup {

    private static boolean isInitialized = false;

    public final static void doSetup() {
        if (!isInitialized) {
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor(IXtextBuiltin.ID,
                    IXtextBuiltin.NAME, IXtextBuiltin.NAMESPACE, null);

            ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
            ServiceRegistry.registerService(languageDescriptor, IMetamodelAccess.class, XtextBuiltinMetamodelAccess.class);
            ServiceRegistry.registerService(languageDescriptor, IValueConverterService.class, XtextBuiltInConverters.class);
            isInitialized = true;
        }
    }

    public static ILanguageDescriptor getLanguageDescriptor() {
        if (!isInitialized) {
            doSetup();
        }
        return LanguageDescriptorFactory.get(IXtextBuiltin.ID);
    }
}
