/*******************************************************************************
 * Copyright (c) 2018, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import static org.junit.Assert.*;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.builder.impl.XtextBuilder.SchedulingOption;
import org.eclipse.xtext.builder.internal.Activator;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class ParallelBuildEnabledTest {
	@Test
	public void testIsParallelBuildEnabledInWorkspace() {
		int maxConcurrentProjectBuilds = new ScopedPreferenceStore(InstanceScope.INSTANCE, ResourcesPlugin.PI_RESOURCES).getInt("maxConcurrentBuilds");
		assertEquals("parallel build was not enabled", 8, maxConcurrentProjectBuilds);
	}
	
	@Test
	public void testBuilderSchedulingRuleEnabledInWorkspace() {
		String schedulingRule = new ScopedPreferenceStore(InstanceScope.INSTANCE, Activator.PLUGIN_ID).getString(XtextBuilder.BuilderPreferences.PREF_SCHEDULING_RULE);
		assertEquals("non-default scheduling rule was not enabled", SchedulingOption.ALL_XTEXT_PROJECTS.name(), schedulingRule);
	}
	
}
