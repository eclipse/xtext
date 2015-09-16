package org.eclipse.xtend.core;

import com.google.inject.Injector;
import java.util.Map;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend.core.XtendStandaloneSetupGenerated;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.impl.BinaryGrammarResourceFactoryImpl;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
@SuppressWarnings("all")
public class XtendStandaloneSetup extends XtendStandaloneSetupGenerated {
  @Override
  public Injector createInjectorAndDoEMFRegistration() {
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    boolean _containsKey = _extensionToFactoryMap.containsKey("ecore");
    boolean _not = (!_containsKey);
    if (_not) {
      Map<String, Object> _extensionToFactoryMap_1 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
      _extensionToFactoryMap_1.put("ecore", _ecoreResourceFactoryImpl);
    }
    Map<String, Object> _extensionToFactoryMap_2 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    boolean _containsKey_1 = _extensionToFactoryMap_2.containsKey("xmi");
    boolean _not_1 = (!_containsKey_1);
    if (_not_1) {
      Map<String, Object> _extensionToFactoryMap_3 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap_3.put("xmi", _xMIResourceFactoryImpl);
    }
    Map<String, Object> _extensionToFactoryMap_4 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    boolean _containsKey_2 = _extensionToFactoryMap_4.containsKey("xtextbin");
    boolean _not_2 = (!_containsKey_2);
    if (_not_2) {
      Map<String, Object> _extensionToFactoryMap_5 = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      BinaryGrammarResourceFactoryImpl _binaryGrammarResourceFactoryImpl = new BinaryGrammarResourceFactoryImpl();
      _extensionToFactoryMap_5.put("xtextbin", _binaryGrammarResourceFactoryImpl);
    }
    boolean _containsKey_3 = EPackage.Registry.INSTANCE.containsKey(XtextPackage.eNS_URI);
    boolean _not_3 = (!_containsKey_3);
    if (_not_3) {
      EPackage.Registry.INSTANCE.put(
        XtextPackage.eNS_URI, XtextPackage.eINSTANCE);
    }
    String _nsURI = XtendPackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI, XtendPackage.eINSTANCE);
    String _nsURI_1 = XbasePackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI_1, XbasePackage.eINSTANCE);
    String _nsURI_2 = XAnnotationsPackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI_2, XAnnotationsPackage.eINSTANCE);
    String _nsURI_3 = TypesPackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI_3, TypesPackage.eINSTANCE);
    String _nsURI_4 = XtypePackage.eINSTANCE.getNsURI();
    EPackage.Registry.INSTANCE.put(_nsURI_4, XtypePackage.eINSTANCE);
    Injector injector = this.createInjector();
    this.register(injector);
    return injector;
  }
  
  public static void doSetup() {
    XtendStandaloneSetup _xtendStandaloneSetup = new XtendStandaloneSetup();
    _xtendStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
