package org.eclipse.xtext.ui.core.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.ImplementedBy;
/**
 * 
 * @author Sven Efftinge
 */
@ImplementedBy(PreferenceStoreAccessImpl.class)
public interface IPreferenceStoreAccess {
	
	/**
	 * a read only preference store, used to obtain preferences, without any context.
	 */
	IPreferenceStore getPreferenceStore();

	/**
	 * a read only preference store, used to obtain preferences, based on the given context.
	 * typically the context would be an {@link org.eclipse.core.resources.IProject} and the result would be a preference store using the
	 * {@link org.eclipse.core.resources.ProjectScope}.
	 */
	IPreferenceStore getContextPreferenceStore(Object context);
	
	/**
	 * a preference store, used to store persisted preferences.
	 * This is usually used by global preference pages.
	 */
	IPreferenceStore getWritablePreferenceStore();
	
	/**
	 * a preference store, used to store persisted preferences.
	 * This is usually used by project properties pages.
	 * @param context - the context is typically an IProject, results in a writable preference store for the project.
	 */
	IPreferenceStore getWritablePreferenceStore(Object context);
	
}
