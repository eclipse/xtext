package org.eclipse.xtext.ui.core.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
/**
 * 
 * provides access to the preference store of the editor of a particular scope.
 */
public interface IPreferenceStoreAccess {
	
	/**
	 * @return
	 */
	IPreferenceStore getPreferenceStore();
}
