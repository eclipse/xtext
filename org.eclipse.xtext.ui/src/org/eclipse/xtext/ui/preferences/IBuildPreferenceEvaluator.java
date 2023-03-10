/*******************************************************************************
 * Copyright (c) 2018 Sigasi NV (https://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Predicate;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

/**
 *
 * Evaluates if a build preference actually affects the builder
 * e.g. En/disabling "Create directory if it doesn't exist" doesn't require a rebuild of the project
 * e.g. Changing the output folder for generated sources requires a rebuild of the project
 * 
 * @since 2.16
 * @author Titouan Vervack - Initial contribution and API
 */
public interface IBuildPreferenceEvaluator {

	default boolean isAffectingBuild(Map<String, ValueDifference<String>> preferenceChanges) {
		return !Maps.filterEntries(preferenceChanges, hasBuildAffectingChangesPredicate()).isEmpty();
	}

	default Predicate<Entry<String, ValueDifference<String>>> hasBuildAffectingChangesPredicate() {
		return (Predicate<Entry<String, ValueDifference<String>>>) preference -> hasBuildAffectingChanges(preference);
	}

	boolean hasBuildAffectingChanges(Entry<String, ValueDifference<String>> preference);
}
