/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.debug;

import static org.eclipse.debug.internal.ui.views.variables.details.DetailPaneManager.*;
import static org.eclipse.xtext.xbase.ui.debug.XbaseBreakpointDetailPaneFactory.*;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.views.variables.details.DetailPaneManager;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Singleton;

@SuppressWarnings("restriction")
@Singleton
public class XbaseDetailPanePrioritizer {
	private static final Logger logger = Logger.getLogger(XbaseDetailPanePrioritizer.class);

	private static final String JDT_STANDARD_PANE = "org.eclipse.jdt.debug.ui.DETAIL_PANE_STANDARD";
	private Map<Set<String>, String> preferences;

	public void prioritizeXbaseOverJdt() {
		if (preferences == null) {
			synchronized (this) {
				if (preferences == null) {
					loadPreferredDetailsAreas();
					Set<String> xbaseAndJdt = Sets.newHashSet(XBASE_DETAIL_PANE, JDT_STANDARD_PANE);
					if (!preferences.containsKey(xbaseAndJdt)) {
						preferences.put(xbaseAndJdt, XBASE_DETAIL_PANE);
					}
					storePreferredDetailsAreas();
				}
			}
		}
	}

	//mostly copied from org.eclipse.debug.internal.ui.views.variables.details.DetailPaneManager
	@SuppressWarnings("deprecation")
	private void loadPreferredDetailsAreas() {
		preferences = Maps.newHashMap();
		String preferenceValue = DebugUIPlugin.getDefault().getPluginPreferences().getString(PREF_DETAIL_AREAS);
		StringTokenizer entryTokenizer = new StringTokenizer(preferenceValue, "|");
		while (entryTokenizer.hasMoreTokens()) {
			String token = entryTokenizer.nextToken();
			int valueStart = token.indexOf(':');
			StringTokenizer keyTokenizer = new StringTokenizer(token.substring(0, valueStart), ",");
			Set<String> keys = Sets.newHashSet();
			while (keyTokenizer.hasMoreTokens()) {
				keys.add(keyTokenizer.nextToken());
			}
			preferences.put(keys, token.substring(valueStart + 1));
		}
	}

	//mostly copied from org.eclipse.debug.internal.ui.views.variables.details.DetailPaneManager
	@SuppressWarnings("deprecation")
	private void storePreferredDetailsAreas() {
		StringBuffer buffer = new StringBuffer();
		Iterator<Entry<Set<String>, String>> iter = preferences.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<Set<String>, String> entry = iter.next();
			Iterator<String> setIter = entry.getKey().iterator();
			while (setIter.hasNext()) {
				String currentID = setIter.next();
				buffer.append(currentID);
				buffer.append(',');
			}
			buffer.deleteCharAt(buffer.length() - 1);
			buffer.append(':');
			buffer.append(entry.getValue());
			buffer.append('|');
		}
		DebugUIPlugin.getDefault().getPluginPreferences().setValue(PREF_DETAIL_AREAS, buffer.toString());
		updateDetailPanemanager();
	}

	private void updateDetailPanemanager() {
		try {
			Field preferredDetailAreasField = DetailPaneManager.class.getDeclaredField("fPreferredDetailPanes");
			preferredDetailAreasField.setAccessible(true);
			preferredDetailAreasField.set(DetailPaneManager.getDefault(), preferences);
		} catch (Exception e) {
			logger.debug("Could not update detail pane manager", e);
		}
	}
}
