/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import static org.junit.Assert.*;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.builder.impl.XtextBuilder;
import org.eclipse.xtext.builder.impl.XtextBuilder.SchedulingOption;
import org.eclipse.xtext.builder.internal.Activator;
import org.junit.Test;
import org.osgi.framework.Version;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class ParallelBuildEnabledTest {
	@Test
	public void testIsParallelBuildEnabledInWorkspace() {
		// preference and constant ResourcesPlugin#PREF_MAX_CONCURRENT_BUILDS only available on o.e.core.resources >= 3.13 
		if (Platform.getBundle(ResourcesPlugin.PI_RESOURCES).getVersion().compareTo(new Version(3,13,0)) < 0) {
			return; // running on too old platform
		}
		int maxConcurrentProjectBuilds = new ScopedPreferenceStore(InstanceScope.INSTANCE, ResourcesPlugin.PI_RESOURCES).getInt("maxConcurrentBuilds");
		assertEquals("parallel build was not enabled", 8, maxConcurrentProjectBuilds);
	}
	
	@Test
	public void testBuilderSchedulingRuleEnabledInWorkspace() {
		String schedulingRule = new ScopedPreferenceStore(InstanceScope.INSTANCE, Activator.PLUGIN_ID).getString(XtextBuilder.BuilderPreferences.PREF_SCHEDULING_RULE);
		assertEquals("non-default scheduling rule was not enabled", SchedulingOption.ALL_XTEXT_PROJECTS.name(), schedulingRule);
	}
	
}
