/*******************************************************************************
 * Copyright (c) 2018 Sigasi NV (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import java.util.Map.Entry;

import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

import com.google.common.collect.MapDifference.ValueDifference;

/**
 * @since 2.16
 * @author Titouan Vervack - Initial contribution and API
 */
public class XtextBuildPreferenceEvaluator implements IBuildPreferenceEvaluator {
	
	// These are defined here because xtext.ui can not depend on xtext.builder without
	// introducing build cycles
	public static final String OUTPUT_PREFERENCE_TAG = "outlet";
	public static final String OUTPUT_CREATE_DIRECTORY = "createDirectory";
	public static final String OUTPUT_CLEAN_DIRECTORY = "cleanDirectory";
	public static final String OUTPUT_OVERRIDE = "override";
	public static final String OUTPUT_CLEANUP_DERIVED = "cleanupDerived";
	public static final String OUTPUT_DERIVED = "derived";
	public static final String OUTPUT_KEEP_LOCAL_HISTORY = "keepLocalHistory";

	private static final String PREFIX = OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR;

	@Override
	public boolean hasBuildAffectingChanges(Entry<String, ValueDifference<String>> preference) {
		String key = preference.getKey();
		if (key.startsWith(PREFIX)) {
			String keyName = key.substring(key.lastIndexOf(PreferenceConstants.SEPARATOR) + 1);
			switch (keyName) {
				case OUTPUT_CREATE_DIRECTORY:
				case OUTPUT_OVERRIDE:
				case OUTPUT_DERIVED:
				case OUTPUT_CLEANUP_DERIVED:
				case OUTPUT_CLEAN_DIRECTORY:
				case OUTPUT_KEEP_LOCAL_HISTORY:
					return false;
			}
		}
		return true;
	}
}
