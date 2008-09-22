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
import org.eclipse.xtext.service.ServiceRegistry;

public class XtextBuiltinStandaloneSetup {

    private static boolean isInitialized = false;

    public synchronized final static void doSetup() {
        if (!isInitialized) {
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
            Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            EPackage.Registry.INSTANCE.put(XtextPackage.eNS_URI,XtextPackage.eINSTANCE);
            
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, IGrammarAccess.class, XtextBuiltinGrammarAccess.class);
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, IValueConverterService.class, XtextBuiltInConverters.class);
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, ILinker.class, Linker.class);
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, ILinkProvider.class, XtextBuiltinLinkProvider.class);
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, IURIChecker.class, DefaultRuntimeURIChecker.class);
            ServiceRegistry.registerService(IXtextBuiltin.SCOPE, IFragmentProvider.class, XtextBuiltinFragmentProvider.class);
            
            isInitialized = true;
        }
    }

}
