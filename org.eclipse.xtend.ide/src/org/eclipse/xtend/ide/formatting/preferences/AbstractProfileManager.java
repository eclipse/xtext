/*******************************************************************************
 * Copyright (c) 2000, 2023 IBM Corporation and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.osgi.util.NLS;
import org.osgi.service.prefs.BackingStoreException;

/**
 * COPIED FROM {@link org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager}
 * It is a direct copy where all references to {@link org.eclipse.jdt.ui.JavaUI#ID_PLUGIN} are replaced by calls to {@link #getNodeId()}.
 * 
 * The initialization is a bit strange as there's so much going on in the super constructor.
 * The super() call in the constructor will do a half baked initialization without any external side-effects (only private fields of the super class will be initialized).
 * The real initialization is done in this class' constructor.
 * 
 * The model for the set of profiles which are available in the workbench.
 */
@SuppressWarnings({ "rawtypes", "unchecked", "restriction" })
public abstract class AbstractProfileManager extends org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager {

	/**
	 * A prefix which is prepended to every ID of a user-defined profile, in order to differentiate it from a built-in
	 * profile.
	 */
	public final static String ID_PREFIX = "_"; //$NON-NLS-1$

	/**
	 * The possible events for observers listening to this class.
	 */
	public final static int SELECTION_CHANGED_EVENT = 1;
	public final static int PROFILE_DELETED_EVENT = 2;
	public final static int PROFILE_RENAMED_EVENT = 3;
	public final static int PROFILE_CREATED_EVENT = 4;
	public final static int SETTINGS_CHANGED_EVENT = 5;

	/**
	 * The key of the preference where the selected profile is stored.
	 */
	private String fProfileKey = null;

	/**
	 * The key of the preference where the version of the current settings is stored
	 */
	private final String fProfileVersionKey;

	/**
	 * A map containing the available profiles, using the IDs as keys.
	 */
	private final Map fProfiles;

	/**
	 * The available profiles, sorted by name.
	 */
	private final List fProfilesByName;

	/**
	 * The currently selected profile.
	 */
	private Profile fSelected;

	/**
	 * The keys of the options to be saved with each profile
	 */
	private KeySet[] fKeySets = null;

	private final PreferencesAccess fPreferencesAccess;
	private final IProfileVersioner fProfileVersioner;

	/**
	 * Create and initialize a new profile manager.
	 * 
	 * @param profiles
	 *            Initial custom profiles (List of type <code>CustomProfile</code>)
	 * @param profileVersioner
	 */
	public AbstractProfileManager(List profiles, IScopeContext context, PreferencesAccess preferencesAccess,
			IProfileVersioner profileVersioner,
			/* @NonNull */ org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.KeySet[] keySets, String profileKey,
			String profileVersionKey) {
		super(profiles, context, preferencesAccess, profileVersioner, keySets, profileKey, profileVersionKey);
		fPreferencesAccess = preferencesAccess;
		fProfileVersioner = profileVersioner;
		fKeySets = keySets.clone();
		fProfileKey = profileKey;
		fProfileVersionKey = profileVersionKey;

		fProfiles = new HashMap();
		fProfilesByName = new ArrayList();

		for (final Iterator iter = profiles.iterator(); iter.hasNext();) {
			final Profile profile = (Profile) iter.next();
			if (profile instanceof CustomProfile) {
				((CustomProfile) profile).setManager(this);
			}
			fProfiles.put(profile.getID(), profile);
			fProfilesByName.add(profile);
		}

		Collections.sort(fProfilesByName);

		String profileId = getSelectedProfileId(fPreferencesAccess.getInstanceScope());

		Profile profile = (Profile) fProfiles.get(profileId);
		if (profile == null) {
			profile = getDefaultProfile();
		}
		fSelected = profile;

		if (context.getName() == ProjectScope.SCOPE && hasProjectSpecificSettings(context)) {
			Map map = readFromPreferenceStore(context, profile);
			if (map != null) {

				List allKeys = new ArrayList();
				for (int i = 0; i < fKeySets.length; i++) {
					allKeys.addAll(fKeySets[i].getKeys());
				}
				Collections.sort(allKeys);

				Profile matching = null;

				String projProfileId = context.getNode(getNodeId()).get(fProfileKey, null);
				if (projProfileId != null) {
					Profile curr = (Profile) fProfiles.get(projProfileId);
					if (curr != null && (curr.isBuiltInProfile() || curr.hasEqualSettings(map, allKeys))) {
						matching = curr;
					}
				} else {
					// old version: look for similar
					for (final Iterator iter = fProfilesByName.iterator(); iter.hasNext();) {
						Profile curr = (Profile) iter.next();
						if (curr.hasEqualSettings(map, allKeys)) {
							matching = curr;
							break;
						}
					}
				}
				if (matching == null) {
					String name;
					if (projProfileId != null && !fProfiles.containsKey(projProfileId)) {
						name = NLS.bind(Messages.AbstractProfileManager_unmanaged_profile_with_name,
								projProfileId.substring(ID_PREFIX.length()));
					} else {
						name = Messages.AbstractProfileManager_unmanaged_profile;
					}
					// current settings do not correspond to any profile -> create a 'team' profile
					SharedProfile shared = new SharedProfile(name, map, fProfileVersioner.getCurrentVersion(),
							fProfileVersioner.getProfileKind());
					shared.setManager(this);
					fProfiles.put(shared.getID(), shared);
					fProfilesByName.add(shared); // add last
					matching = shared;
				}
				fSelected = matching;
			}
		}
	}

	/*
	 * Suppress deprecation warning which is not present in 3.5
	 */
	@Override
	protected String getSelectedProfileId(IScopeContext instanceScope) {
		if (fProfileKey != null) {
			String profileId = instanceScope.getNode(getNodeId()).get(fProfileKey, null);
			if (profileId == null) {
				// request from bug 129427
				profileId = DefaultScope.INSTANCE.getNode(getNodeId()).get(fProfileKey, null);
			}
			return profileId;
		}
		return null;
	}

	protected abstract String getNodeId();

	/**
	 * Notify observers with a message. The message must be one of the following:
	 * 
	 * @param message
	 *            Message to send out
	 * 
	 * @see #SELECTION_CHANGED_EVENT
	 * @see #PROFILE_DELETED_EVENT
	 * @see #PROFILE_RENAMED_EVENT
	 * @see #PROFILE_CREATED_EVENT
	 * @see #SETTINGS_CHANGED_EVENT
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void notifyObservers(int message) {
		setChanged();
		notifyObservers(Integer.valueOf(message));
	}

	public static boolean hasProjectSpecificSettings(IScopeContext context, KeySet[] keySets) {
		for (int i = 0; i < keySets.length; i++) {
			KeySet keySet = keySets[i];
			IEclipsePreferences preferences = context.getNode(keySet.getNodeName());
			for (final Iterator keyIter = keySet.getKeys().iterator(); keyIter.hasNext();) {
				final String key = (String) keyIter.next();
				Object val = preferences.get(key, null);
				if (val != null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasProjectSpecificSettings(IScopeContext context) {
		if (fKeySets != null)
			return hasProjectSpecificSettings(context, fKeySets);
		else
			return false;
	}

	/**
	 * Only to read project specific settings to find out to what profile it matches.
	 * 
	 * @param context
	 *            The project context
	 */
	private Map readFromPreferenceStore(IScopeContext context, Profile workspaceProfile) {
		final Map profileOptions = new HashMap();
		IEclipsePreferences uiPrefs = context.getNode(getNodeId());

		int version = uiPrefs.getInt(fProfileVersionKey, fProfileVersioner.getFirstVersion());
		if (version != fProfileVersioner.getCurrentVersion()) {
			Map allOptions = new HashMap();
			for (int i = 0; i < fKeySets.length; i++) {
				addAll(context.getNode(fKeySets[i].getNodeName()), allOptions);
			}
			CustomProfile profile = new CustomProfile("tmp", allOptions, version, fProfileVersioner.getProfileKind()); //$NON-NLS-1$
			fProfileVersioner.update(profile);
			return profile.getSettings();
		}

		boolean hasValues = false;
		for (int i = 0; i < fKeySets.length; i++) {
			KeySet keySet = fKeySets[i];
			IEclipsePreferences preferences = context.getNode(keySet.getNodeName());
			for (final Iterator keyIter = keySet.getKeys().iterator(); keyIter.hasNext();) {
				final String key = (String) keyIter.next();
				Object val = preferences.get(key, null);
				if (val != null) {
					hasValues = true;
				} else {
					val = workspaceProfile.getSettings().get(key);
				}
				profileOptions.put(key, val);
			}
		}

		if (!hasValues) {
			return null;
		}

		setLatestCompliance(profileOptions);
		return profileOptions;
	}

	/**
	 * @param uiPrefs
	 * @param allOptions
	 */
	private void addAll(IEclipsePreferences uiPrefs, Map allOptions) {
		try {
			String[] keys = uiPrefs.keys();
			for (int i = 0; i < keys.length; i++) {
				String key = keys[i];
				String val = uiPrefs.get(key, null);
				if (val != null) {
					allOptions.put(key, val);
				}
			}
		} catch (BackingStoreException e) {
			// ignore
		}

	}

	private boolean updatePreferences(IEclipsePreferences prefs, List keys, Map profileOptions) {
		boolean hasChanges = false;
		for (final Iterator keyIter = keys.iterator(); keyIter.hasNext();) {
			final String key = (String) keyIter.next();
			final String oldVal = prefs.get(key, null);
			final String val = (String) profileOptions.get(key);
			if (val == null) {
				if (oldVal != null) {
					prefs.remove(key);
					hasChanges = true;
				}
			} else if (!val.equals(oldVal)) {
				prefs.put(key, val);
				hasChanges = true;
			}
		}
		return hasChanges;
	}

	/**
	 * Update all formatter settings with the settings of the specified profile.
	 * 
	 * @param profile
	 *            The profile to write to the preference store
	 */
	private void writeToPreferenceStore(Profile profile, IScopeContext context) {
		final Map profileOptions = profile.getSettings();

		for (int i = 0; i < fKeySets.length; i++) {
			updatePreferences(context.getNode(fKeySets[i].getNodeName()), fKeySets[i].getKeys(), profileOptions);
		}

		final IEclipsePreferences uiPrefs = context.getNode(getNodeId());
		if (uiPrefs.getInt(fProfileVersionKey, 0) != fProfileVersioner.getCurrentVersion()) {
			uiPrefs.putInt(fProfileVersionKey, fProfileVersioner.getCurrentVersion());
		}

		if (context.getName() == InstanceScope.SCOPE) {
			uiPrefs.put(fProfileKey, profile.getID());
		} else if (context.getName() == ProjectScope.SCOPE && !profile.isSharedProfile()) {
			uiPrefs.put(fProfileKey, profile.getID());
		}
	}

	/**
	 * Get an immutable list as view on all profiles, sorted alphabetically. Unless the set of profiles has been
	 * modified between the two calls, the sequence is guaranteed to correspond to the one returned by
	 * <code>getSortedNames</code>.
	 * 
	 * @return a list of elements of type <code>Profile</code>
	 * 
	 * @see #getSortedDisplayNames()
	 */
	@Override
	public List getSortedProfiles() {
		return Collections.unmodifiableList(fProfilesByName);
	}

	/**
	 * Get the names of all profiles stored in this profile manager, sorted alphabetically. Unless the set of profiles
	 * has been modified between the two calls, the sequence is guaranteed to correspond to the one returned by
	 * <code>getSortedProfiles</code>.
	 * 
	 * @return All names, sorted alphabetically
	 * @see #getSortedProfiles()
	 */
	@Override
	public String[] getSortedDisplayNames() {
		final String[] sortedNames = new String[fProfilesByName.size()];
		int i = 0;
		for (final Iterator iter = fProfilesByName.iterator(); iter.hasNext();) {
			Profile curr = (Profile) iter.next();
			sortedNames[i++] = curr.getName();
		}
		return sortedNames;
	}

	/**
	 * Get the profile for this profile id.
	 * 
	 * @param ID
	 *            The profile ID
	 * @return The profile with the given ID or <code>null</code>
	 */
	@Override
	public Profile getProfile(String ID) {
		if (fProfiles != null)
			return (Profile) fProfiles.get(ID);
		return null;
	}

	/**
	 * Activate the selected profile, update all necessary options in preferences and save profiles to disk.
	 */
	@Override
	public void commitChanges(IScopeContext scopeContext) {
		if (fSelected != null) {
			writeToPreferenceStore(fSelected, scopeContext);
		}
	}

	@Override
	public void clearAllSettings(IScopeContext context) {
		for (int i = 0; i < fKeySets.length; i++) {
			updatePreferences(context.getNode(fKeySets[i].getNodeName()), fKeySets[i].getKeys(), Collections.EMPTY_MAP);
		}
		final IEclipsePreferences uiPrefs = context.getNode(getNodeId());
		uiPrefs.remove(fProfileKey);
	}

	/**
	 * Get the currently selected profile.
	 * 
	 * @return The currently selected profile.
	 */
	@Override
	public Profile getSelected() {
		return fSelected;
	}

	/**
	 * Set the selected profile. The profile must already be contained in this profile manager.
	 * 
	 * @param profile
	 *            The profile to select
	 */
	@Override
	public void setSelected(Profile profile) {
		final Profile newSelected = (Profile) fProfiles.get(profile.getID());
		if (newSelected != null && !newSelected.equals(fSelected)) {
			fSelected = newSelected;
			notifyObservers(SELECTION_CHANGED_EVENT);
		}
	}

	/**
	 * Check whether a user-defined profile in this profile manager already has this name.
	 * 
	 * @param name
	 *            The name to test for
	 * @return Returns <code>true</code> if a profile with the given name exists
	 */
	@Override
	public boolean containsName(String name) {
		for (final Iterator iter = fProfilesByName.iterator(); iter.hasNext();) {
			Profile curr = (Profile) iter.next();
			if (name.equals(curr.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Add a new custom profile to this profile manager.
	 * 
	 * @param profile
	 *            The profile to add
	 */
	@Override
	public void addProfile(CustomProfile profile) {
		profile.setManager(this);
		final CustomProfile oldProfile = (CustomProfile) fProfiles.get(profile.getID());
		if (oldProfile != null) {
			fProfiles.remove(oldProfile.getID());
			fProfilesByName.remove(oldProfile);
			oldProfile.setManager(null);
		}
		fProfiles.put(profile.getID(), profile);
		fProfilesByName.add(profile);
		Collections.sort(fProfilesByName);
		fSelected = profile;
		notifyObservers(PROFILE_CREATED_EVENT);
	}

	/**
	 * Delete the currently selected profile from this profile manager. The next profile in the list is selected.
	 * 
	 * @return true if the profile has been successfully removed, false otherwise.
	 */
	@Override
	public boolean deleteSelected() {
		if (!(fSelected instanceof CustomProfile))
			return false;

		return deleteProfile((CustomProfile) fSelected);
	}

	@Override
	public boolean deleteProfile(CustomProfile profile) {
		int index = fProfilesByName.indexOf(profile);

		fProfiles.remove(profile.getID());
		fProfilesByName.remove(profile);

		profile.setManager(null);

		if (index >= fProfilesByName.size())
			index--;
		fSelected = (Profile) fProfilesByName.get(index);

		if (!profile.isSharedProfile()) {
			updateProfilesWithName(profile.getID(), null, false);
		}

		notifyObservers(PROFILE_DELETED_EVENT);
		return true;
	}

	@Override
	public void profileRenamed(CustomProfile profile, String oldID) {
		fProfiles.remove(oldID);
		fProfiles.put(profile.getID(), profile);

		if (!profile.isSharedProfile()) {
			updateProfilesWithName(oldID, profile, false);
		}

		Collections.sort(fProfilesByName);
		notifyObservers(PROFILE_RENAMED_EVENT);
	}

	@Override
	public void profileReplaced(CustomProfile oldProfile, CustomProfile newProfile) {
		fProfiles.remove(oldProfile.getID());
		fProfiles.put(newProfile.getID(), newProfile);
		fProfilesByName.remove(oldProfile);
		fProfilesByName.add(newProfile);
		Collections.sort(fProfilesByName);

		if (!oldProfile.isSharedProfile()) {
			updateProfilesWithName(oldProfile.getID(), null, false);
		}

		setSelected(newProfile);
		notifyObservers(PROFILE_CREATED_EVENT);
		notifyObservers(SELECTION_CHANGED_EVENT);
	}

	@Override
	public void profileChanged(CustomProfile profile) {
		if (!profile.isSharedProfile()) {
			updateProfilesWithName(profile.getID(), profile, true);
		}

		notifyObservers(SETTINGS_CHANGED_EVENT);
	}

	@Override
	protected void updateProfilesWithName(String oldName, Profile newProfile, boolean applySettings) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			IScopeContext projectScope = fPreferencesAccess.getProjectScope(projects[i]);
			IEclipsePreferences node = projectScope.getNode(getNodeId());
			String profileId = node.get(fProfileKey, null);
			if (oldName.equals(profileId)) {
				if (newProfile == null) {
					node.remove(fProfileKey);
				} else {
					if (applySettings) {
						writeToPreferenceStore(newProfile, projectScope);
					} else {
						node.put(fProfileKey, newProfile.getID());
					}
				}
			}
		}

		IScopeContext instanceScope = fPreferencesAccess.getInstanceScope();
		final IEclipsePreferences uiPrefs = instanceScope.getNode(getNodeId());
		if (newProfile != null && oldName.equals(uiPrefs.get(fProfileKey, null))) {
			writeToPreferenceStore(newProfile, instanceScope);
		}
	}

	private static void setLatestCompliance(Map map) {
		//		JavaModelUtil.set50ComplianceOptions(map);
	}

	@Override
	public abstract Profile getDefaultProfile();

	@Override
	public IProfileVersioner getProfileVersioner() {
		return fProfileVersioner;
	}
}
