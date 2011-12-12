/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class WizardContribution implements Comparable<WizardContribution> {

	public static Map<String, WizardContribution> getFromRegistry() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.xtext.xtext.ui.wizardContribution");

		Map<String, WizardContribution> elements = new HashMap<String, WizardContribution>();
		for (int i = 0; i < config.length; i++) {
			IConfigurationElement e = config[i];
			String name = e.getAttribute("name");
			String mweSnippet = e.getChildren("MweSnippet")[0].getValue();
			String requiredBundlesAsString = e.getAttribute("requiredBundles");
			String sortKey = e.getAttribute("sortKey");
			String[] requiredBundles = new String[0];
			if (requiredBundlesAsString != null) {
				requiredBundles = requiredBundlesAsString.split(",");
			}
			elements.put(name, new WizardContribution(name, mweSnippet, requiredBundles, sortKey));
		}
		return elements;
	}

	private String name;
	private String mweSnippet;
	private String[] requiredBundles;
	private String sortKey;

	public WizardContribution(String name, String mweSnippet, String[] requiredBundles, String sortKey) {
		super();
		this.name = name;
		this.mweSnippet = mweSnippet;
		this.requiredBundles = requiredBundles;
		this.sortKey = sortKey;
	}

	public String getName() {
		return name;
	}

	public String getMweSnippet() {
		return mweSnippet;
	}

	public String[] getRequiredBundles() {
		return requiredBundles;
	}

	public String getSortKey() {
		return sortKey;
	}

	public int compareTo(WizardContribution o) {
		if (this.getSortKey() == null)
			return -1000;
		if (o.getSortKey() == null)
			return +1000;
		return getSortKey().compareTo(o.getSortKey());
	}

}
