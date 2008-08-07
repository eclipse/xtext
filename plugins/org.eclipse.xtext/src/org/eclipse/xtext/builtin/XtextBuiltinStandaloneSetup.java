package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.crossref.IFragmentProvider;
import org.eclipse.xtext.crossref.ILinkProvider;
import org.eclipse.xtext.crossref.ILinker;
import org.eclipse.xtext.crossref.IURIChecker;
import org.eclipse.xtext.crossref.impl.DefaultRuntimeURIChecker;
import org.eclipse.xtext.crossref.impl.XtextBuiltinFragmentProvider;
import org.eclipse.xtext.crossref.impl.XtextBuiltinLinkProvider;
import org.eclipse.xtext.crossref.internal.Linker;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;

public class XtextBuiltinStandaloneSetup {

    private static boolean isInitialized = false;

    public synchronized final static void doSetup() {
        if (!isInitialized) {
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI,XtextPackage.eINSTANCE);
            
            IServiceScope serviceScope = ServiceScopeFactory.createScope(IXtextBuiltin.ID, null);

            ServiceRegistry.registerService(serviceScope, IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
            ServiceRegistry.registerService(serviceScope, IValueConverterService.class, XtextBuiltInConverters.class);
            ServiceRegistry.registerService(serviceScope, ILinker.class, Linker.class);
            ServiceRegistry.registerService(serviceScope, ILinkProvider.class, XtextBuiltinLinkProvider.class);
            ServiceRegistry.registerService(serviceScope, IURIChecker.class, DefaultRuntimeURIChecker.class);
            ServiceRegistry.registerService(serviceScope, IFragmentProvider.class, XtextBuiltinFragmentProvider.class);
            
            
            isInitialized = true;
        }
    }

    public synchronized static IServiceScope getServiceScope() {
        if (!isInitialized) {
            doSetup();
        }
        return ServiceScopeFactory.get(IXtextBuiltin.ID);
    }
}
