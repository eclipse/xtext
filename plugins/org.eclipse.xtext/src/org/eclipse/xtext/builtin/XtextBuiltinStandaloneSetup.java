package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;

public class XtextBuiltinStandaloneSetup {

    private static boolean isInitialized = false;

    public synchronized final static void doSetup() {
        if (!isInitialized) {
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI,XtextPackage.eINSTANCE);
            
            ILanguageDescriptor languageDescriptor = LanguageDescriptorFactory.createLanguageDescriptor(IXtextBuiltin.ID,
                    IXtextBuiltin.NAME, IXtextBuiltin.NAMESPACE, null);

            ServiceRegistry.registerService(languageDescriptor, IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
            ServiceRegistry.registerService(languageDescriptor, IValueConverterService.class, XtextBuiltInConverters.class);
            isInitialized = true;
        }
    }

    public synchronized static ILanguageDescriptor getLanguageDescriptor() {
        if (!isInitialized) {
            doSetup();
        }
        return LanguageDescriptorFactory.get(IXtextBuiltin.ID);
    }
}
