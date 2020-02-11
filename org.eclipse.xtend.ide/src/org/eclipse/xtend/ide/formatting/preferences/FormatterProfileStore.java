/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class FormatterProfileStore extends ProfileStore {

	public static final String XTEND_PROFILES_KEY = "XtendFormatterProfile";
	private final String xtendNodeID;
	private IProfileVersioner profileVersionerCopy;
	private String profilesVersionKeyCopy;

	public FormatterProfileStore(IProfileVersioner profileVersioner, String xtendNodeID) {
		super(XTEND_PROFILES_KEY, profileVersioner);
		this.profileVersionerCopy = profileVersioner;
		this.xtendNodeID = xtendNodeID;
		this.profilesVersionKeyCopy = XTEND_PROFILES_KEY + VERSION_KEY_SUFFIX;
	}

	/*
	 * Eclipse 3.5 uses raw types thus we have to use them here, too
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List readProfiles(IScopeContext scope) throws CoreException {
		return readProfilesFromString(scope.getNode(xtendNodeID).get(XTEND_PROFILES_KEY, null));
	}

	/*
	 * Eclipse 3.5 uses raw types thus we have to use them here, too
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void writeProfiles(Collection profiles, IScopeContext instanceScope)
			throws CoreException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream(2000);
		try {
			writeProfilesToStream(profiles, stream, ENCODING, profileVersionerCopy);
			String val;
			try {
				val = stream.toString(ENCODING);
			} catch (UnsupportedEncodingException e) {
				val = stream.toString();
			}
			IEclipsePreferences uiPreferences = instanceScope.getNode(xtendNodeID);
			uiPreferences.put(XTEND_PROFILES_KEY, val);
			uiPreferences.putInt(profilesVersionKeyCopy, profileVersionerCopy.getCurrentVersion());
		} finally {
			try {
				stream.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
