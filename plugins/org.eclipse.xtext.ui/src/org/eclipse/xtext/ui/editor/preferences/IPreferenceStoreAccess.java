package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.ImplementedBy;

/**
 * Simplifies access to eclipse's preferences and properties.
 * 
 * @author Sven Efftinge
 */
@ImplementedBy(PreferenceStoreAccessImpl.class)
public interface IPreferenceStoreAccess {

	/**
	 * a read only preference store, used to obtain preferences, without any context.
	 * 
	 * If you register an {@link org.eclipse.jface.util.IPropertyChangeListener} make sure to remove it on the same
	 * {@link IPreferenceStore} instance.
	 */
	IPreferenceStore getPreferenceStore();

	/**
	 * a read only preference store, used to obtain preferences, based on the given context. typically the context would
	 * be an {@link org.eclipse.core.resources.IProject} and the result would be a preference store using the
	 * {@link org.eclipse.core.resources.ProjectScope}.
	 * 
	 * If you register an {@link org.eclipse.jface.util.IPropertyChangeListener} make sure to remove it on the same
	 * {@link IPreferenceStore} instance.
	 */
	IPreferenceStore getContextPreferenceStore(Object context);

	/**
	 * a preference store, used to store persisted preferences. This is usually used by global preference pages.
	 * 
	 * If you register an {@link org.eclipse.jface.util.IPropertyChangeListener} make sure to remove it on the same
	 * {@link IPreferenceStore} instance.
	 */
	IPreferenceStore getWritablePreferenceStore();

	/**
	 * a preference store, used to store persisted preferences. This is usually used by project properties pages.
	 * 
	 * If you register an {@link org.eclipse.jface.util.IPropertyChangeListener} make sure to remove it on the same
	 * {@link IPreferenceStore} instance.
	 * 
	 * @param context
	 *            - the context is typically an IProject, results in a writable preference store for the project.
	 */
	IPreferenceStore getWritablePreferenceStore(Object context);

}
