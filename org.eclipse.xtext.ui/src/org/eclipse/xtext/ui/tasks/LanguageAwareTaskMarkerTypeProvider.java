/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.tasks.Task;

import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class LanguageAwareTaskMarkerTypeProvider extends TaskMarkerTypeProvider {

	private String taskMarkerType;

	@Inject
	public void initialize(LanguageInfo languageInfo, AbstractUIPlugin uiPlugin) {
		String bundleName = uiPlugin.getBundle().getSymbolicName();
		String languageName = languageInfo.getShortName().toLowerCase();
		taskMarkerType = bundleName + "." + languageName + ".task";
	}

	@Override
	public String getMarkerType(Task task) {
		return taskMarkerType;
	}

}
