package org.eclipse.xtext.ui.editor.preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;

/**
 * Initializer class of extension point
 * <code>org.eclipse.core.runtime.preferences</code> used to load the default
 * Xtext preferences.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
 */
public class XtextPreferenceInitializer extends AbstractPreferenceInitializer
		implements IExecutableExtension {

	private String nameSpaceIdentifier;

	@Override
	public void initializeDefaultPreferences() {
		Map<String, Object> defaultPreferencesMap = new HashMap<String, Object>();
		defaultPreferencesMap.put(PreferenceConstants.PREF_TASK_TAGS,
				PreferenceConstants.DEFAULT_TASK_TAGS);
		defaultPreferencesMap.put(
				PreferenceConstants.PREF_TASK_PRIORITIES,
				PreferenceConstants.DEFAULT_TASK_PRIORITIES);
		// Store default values to default preferences
		IEclipsePreferences defaultPreferences = ((IScopeContext) new DefaultScope())
				.getNode(nameSpaceIdentifier);
		Set<Entry<String, Object>> entrySet = defaultPreferencesMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String optionName = (String) entry.getKey();
			defaultPreferences.put(optionName, (String) entry.getValue());
		}
	}

	/**
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(IConfigurationElement,
	 *      String, Object)
	 */
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.nameSpaceIdentifier = config.getNamespaceIdentifier();

	}
}
