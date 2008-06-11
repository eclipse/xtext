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

            ServiceRegistry.registerService(getLanguageDescriptor(), IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
            ServiceRegistry.registerService(getLanguageDescriptor(), IMetamodelAccess.class, XtextBuiltinMetamodelAccess.class);
            ServiceRegistry.registerService(getLanguageDescriptor(), IValueConverterService.class, XtextBuiltInConverters.class);
            isInitialized = true;
        }
    }

  //TODO private constructor?
//  private XtextStandaloneSetup() {
//  }

    private static class InstanceHolder {
        private static ILanguageDescriptor INSTANCE;

        static {
            INSTANCE = LanguageDescriptorFactory.get(IXtextBuiltin.ID);
            if (INSTANCE == null) {
                // TODO put super grammar
                INSTANCE = LanguageDescriptorFactory.createLanguageDescriptor(IXtextBuiltin.ID,
                        IXtextBuiltin.NAME, IXtextBuiltin.NAMESPACE, null);
            }
        }
    }

    public static ILanguageDescriptor getLanguageDescriptor() {
        return InstanceHolder.INSTANCE;
    }
}
