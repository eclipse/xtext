package org.eclipse.xtext.ui.service.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
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
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.IServiceFactory;
import org.eclipse.xtext.service.IServiceRegistrationFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.service.IFoldingStructureProvider;
import org.eclipse.xtext.ui.service.IFormatter;
import org.eclipse.xtext.ui.service.IHoverInfo;
import org.eclipse.xtext.ui.service.ILabelProvider;
import org.eclipse.xtext.ui.service.IOutlineProvider;
import org.eclipse.xtext.ui.service.IPreferenceStore;
import org.eclipse.xtext.ui.service.IProposalsProvider;
import org.eclipse.xtext.ui.service.IQuickFixGenerator;
import org.eclipse.xtext.ui.service.ISyntaxColorer;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;

public class XtextServiceRegistrationFactory implements IServiceRegistrationFactory {

	private static final String SCOPE = "languageId";
	private static final String PRIO = "priority";

	private static final Logger log = Logger.getLogger(XtextServiceRegistrationFactory.class);

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
		serviceMap.put("quickFixGenerator", IQuickFixGenerator.class);
	}

	public Set<IServiceRegistration> registrations() {
		Set<IServiceRegistration> regs = new HashSet<IServiceRegistration>();
		for (final String serviceDef : serviceMap.keySet()) {
			IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID,
					serviceDef);
			IConfigurationElement[] elements = extensionPoint.getConfigurationElements();
			for (final IConfigurationElement ele : elements) {
				final String scopeId = ele.getAttribute(SCOPE);
				final IServiceScope scope = ServiceScopeFactory.get(scopeId);
				if (scope == null) {
					log.error("The referred scope " + scopeId + " is not registered");
				}
				else {
					final String prio = ele.getAttribute(PRIO);
					final IServiceFactory fa = new XtextServiceFactory(serviceMap.get(serviceDef), ele);
					IServiceRegistration reg = new IServiceRegistration() {

						public int priority() {
							return prio != null ? Integer.valueOf(prio) : 0;
						}

						public String scopeId() {
							return scopeId;
						}

						public IServiceFactory serviceFactory() {
							return fa;
						}
					};
					regs.add(reg);
				}
			}
		}
		return regs;
	}

}
