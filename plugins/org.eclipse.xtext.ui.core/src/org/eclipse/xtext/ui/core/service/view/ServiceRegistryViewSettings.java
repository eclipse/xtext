package org.eclipse.xtext.ui.core.service.view;

import org.eclipse.jface.dialogs.IDialogSettings;

/**
 * @author Dennis Hübner - Initial contribution and API
 *
 */
public class ServiceRegistryViewSettings {
	private static final String LINK_WITH_EDITOR_KEY = "linkWithEditor";
	private static final String SHOW_FQNAMES = "showFQNames";

	private IDialogSettings settings;

	public ServiceRegistryViewSettings(IDialogSettings settings) {
		this.settings = settings;
	}

	public Boolean isShowFQNames() {
		return settings.getBoolean(SHOW_FQNAMES);
	}

	public void setShowFQNames(boolean showFQNames) {
		settings.put(SHOW_FQNAMES, showFQNames);
	}

	public void setLinkWithEditor(boolean checked) {
		settings.put(LINK_WITH_EDITOR_KEY, checked);
	}

	public Boolean isLinkWithEditor() {
		return settings.getBoolean(LINK_WITH_EDITOR_KEY);
	}

}