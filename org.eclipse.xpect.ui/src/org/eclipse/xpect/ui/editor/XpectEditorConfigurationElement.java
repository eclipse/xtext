package org.eclipse.xpect.ui.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.internal.registry.IWorkbenchRegistryConstants;
import org.eclipse.xpect.registry.ILanguageInfo;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.google.inject.Module;

@SuppressWarnings("restriction")
public class XpectEditorConfigurationElement implements IConfigurationElement {

	private String clazz = null;

	private final IConfigurationElement delegate;

	private String id = null;

	private String language = null;

	private String name = null;

	private String pluginID = null;

	public XpectEditorConfigurationElement(IConfigurationElement delegate) {
		super();
		this.delegate = delegate;
	}

	protected Object createEditor() {
		ILanguageInfo language = ILanguageInfo.Registry.INSTANCE.getLanguageByName(this.language);
		Module runtimeModule = language.getRuntimeModule();
		Module sharedStateModuel = new SharedStateModule();
		Module uiModule = language.getUIModule();
		Module assimilatingModule = new AssimilatingModule();
		Injector injector = language.getInjector(runtimeModule, sharedStateModuel, uiModule, assimilatingModule);
		Bundle bundle = Platform.getBundle(this.pluginID);
		try {
			Class<?> editorClass = bundle.loadClass(this.clazz);
			return injector.getInstance(editorClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object createExecutableExtension(String propertyName) throws CoreException {
		if (IWorkbenchRegistryConstants.ATT_CLASS.equals(propertyName) && this.clazz != null)
			return createEditor();
		return delegate.createExecutableExtension(propertyName);
	}

	@Override
	public String getAttribute(String name) throws InvalidRegistryObjectException {
		if (IWorkbenchRegistryConstants.ATT_ID.equals(name) && this.id != null)
			return this.id;
		if (IWorkbenchRegistryConstants.ATT_NAME.equals(name) && this.name != null)
			return this.name;
		if (IWorkbenchRegistryConstants.ATT_CLASS.equals(name) && this.clazz != null)
			return this.clazz;
		return delegate.getAttribute(name);
	}

	@Override
	public String getAttribute(String attrName, String locale) throws InvalidRegistryObjectException {
		return delegate.getAttribute(attrName, locale);
	}

	@Override
	@SuppressWarnings("deprecation")
	public String getAttributeAsIs(String name) throws InvalidRegistryObjectException {
		if (IWorkbenchRegistryConstants.ATT_ID.equals(name) && this.id != null)
			return this.id;
		if (IWorkbenchRegistryConstants.ATT_NAME.equals(name) && this.name != null)
			return this.name;
		if (IWorkbenchRegistryConstants.ATT_CLASS.equals(name) && this.clazz != null)
			return this.clazz;
		return delegate.getAttributeAsIs(name);
	}

	@Override
	public String[] getAttributeNames() throws InvalidRegistryObjectException {
		return delegate.getAttributeNames();
	}

	@Override
	public IConfigurationElement[] getChildren() throws InvalidRegistryObjectException {
		return delegate.getChildren();
	}

	@Override
	public IConfigurationElement[] getChildren(String name) throws InvalidRegistryObjectException {
		return delegate.getChildren(name);
	}

	@Override
	public IContributor getContributor() throws InvalidRegistryObjectException {
		return delegate.getContributor();
	}

	@Override
	public IExtension getDeclaringExtension() throws InvalidRegistryObjectException {
		return delegate.getDeclaringExtension();
	}

	@Override
	public String getName() throws InvalidRegistryObjectException {
		if (name != null)
			return name;
		return delegate.getName();
	}

	@Override
	@SuppressWarnings("deprecation")
	public String getNamespace() throws InvalidRegistryObjectException {
		return delegate.getNamespace();
	}

	@Override
	public String getNamespaceIdentifier() throws InvalidRegistryObjectException {
		return delegate.getNamespaceIdentifier();
	}

	@Override
	public Object getParent() throws InvalidRegistryObjectException {
		return delegate.getParent();
	}

	@Override
	public String getValue() throws InvalidRegistryObjectException {
		return delegate.getValue();
	}

	@Override
	public String getValue(String locale) throws InvalidRegistryObjectException {
		return delegate.getValue(locale);
	}

	@Override
	@SuppressWarnings("deprecation")
	public String getValueAsIs() throws InvalidRegistryObjectException {
		return delegate.getValueAsIs();
	}

	@Override
	public boolean isValid() {
		return delegate.isValid();
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPluginID(String pluginID) {
		this.pluginID = pluginID;
	}

}
