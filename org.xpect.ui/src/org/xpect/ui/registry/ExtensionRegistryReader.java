package org.xpect.ui.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.xpect.util.ExtensionFactoryUtil;
import org.xpect.util.ExtensionFactoryUtil.NameAndClass;

public class ExtensionRegistryReader extends RegistryReader {

	private final UILanugageRegistry registry;

	public ExtensionRegistryReader(UILanugageRegistry registry) {
		super(Platform.getExtensionRegistry(), "org.eclipse.ui", "editors");
		this.registry = registry;
	}

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals("editor")) {
			String factAndClass = element.getAttribute("class");
			NameAndClass nameAndClass = ExtensionFactoryUtil.parseExtensionFactory(factAndClass);
			if (nameAndClass.hasNameAndClass()) {
				String rtLangName = element.getAttribute("id");
				String type = element.getAttribute("extensions");
				String[] fileExtensions = type != null ? type.split(",") : new String[0];
				if (add)
					registry.addLanguage(element.getContributor().getName(), rtLangName, nameAndClass.getUiLangName(), fileExtensions);
				else
					registry.removeLanguage(rtLangName, fileExtensions);
			}
		}
		return true;
	}

}
