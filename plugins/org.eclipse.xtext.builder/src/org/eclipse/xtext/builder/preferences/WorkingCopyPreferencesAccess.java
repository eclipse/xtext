/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.ui.preferences.IWorkingCopyManager;
import org.eclipse.xtext.Constants;
import org.osgi.service.prefs.BackingStoreException;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class WorkingCopyPreferencesAccess {
	private String qualifier;
	private IScopeContext[] lookupOrder;
	private IWorkingCopyManager workingCopyManager;

	public static class Factory {
		private String qualifier;

		@Inject
		public Factory(@Named(Constants.LANGUAGE_NAME) String qualifier) {
			this.qualifier = qualifier;
		}

		public WorkingCopyPreferencesAccess create(IProject project, IWorkingCopyManager workingCopyManager) {
			IScopeContext[] lookupOrder = null;
			if (project != null) {
				lookupOrder = new IScopeContext[] { new ProjectScope(project), new InstanceScope(), new DefaultScope() };
			} else {
				lookupOrder = new IScopeContext[] { new InstanceScope(), new DefaultScope() };
			}
			return new WorkingCopyPreferencesAccess(this.qualifier, lookupOrder, workingCopyManager);
		}
	}

	public void applyChanges() throws BackingStoreException {
		workingCopyManager.applyChanges();
	}

	public WorkingCopyPreferencesAccess(String qualifier, IScopeContext[] lookupOrder,
			IWorkingCopyManager workingCopyManager) {
		this.qualifier = qualifier;
		this.lookupOrder = lookupOrder;
		this.workingCopyManager = workingCopyManager;
	}

	public void setValue(String key, String value) {
		setValue(key, lookupOrder[0], value);
	}

	public void setDefaultValue(String key, String value) {
		IScopeContext defaultScope = lookupOrder[lookupOrder.length - 1];
		setValue(key, defaultScope, value);
	}

	public void setValue(String key, IScopeContext context, String value) {
		if (value != null) {
			getNode(context, workingCopyManager).put(key, value);
		} else {
			getNode(context, workingCopyManager).remove(key);
		}
	}

	public String getValue(String key) {
		for (int i = 0; i < lookupOrder.length; i++) {
			String value = getValue(key, lookupOrder[i]);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	public String getValue(String key, IScopeContext context) {
		return getValue(key, context, workingCopyManager);
	}

	public String getOriginalValue(String key) {
		for (int i = 0; i < lookupOrder.length; i++) {
			String value = getValue(key, lookupOrder[i], null);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	public String getOriginalValue(String key, IScopeContext context) {
		return getValue(key, context, null);
	}

	public String getDefaultValue(String key) {
		for (int i = 1; i < lookupOrder.length; i++) {
			String value = getValue(key, lookupOrder[i], workingCopyManager);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	private String getValue(String key, IScopeContext context, IWorkingCopyManager manager) {
		return getNode(context, manager).get(key, null);
	}

	private IEclipsePreferences getNode(IScopeContext context, IWorkingCopyManager manager) {
		IEclipsePreferences node = context.getNode(qualifier);
		if (manager != null) {
			return manager.getWorkingCopy(node);
		}
		return node;
	}

}
