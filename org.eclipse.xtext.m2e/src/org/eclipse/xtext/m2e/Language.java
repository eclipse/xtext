/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.m2e;

import java.util.List;

import com.google.common.collect.Lists;

public class Language {
	private List<OutputConfiguration> outputConfigurations = Lists
			.<OutputConfiguration> newArrayList();

	private String setup;
	
	private boolean javaSupport = true;

	public List<OutputConfiguration> getOutputConfigurations() {
		return this.outputConfigurations;
	}

	public String getSetup() {
		return this.setup;
	}
	
	public String name() {
		return setup.replace("StandaloneSetup", "");
	}

	public void setOutputConfigurations(
			List<OutputConfiguration> outputConfigurations) {
		this.outputConfigurations = outputConfigurations;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}
	
	public boolean isJavaSupport() {
		return javaSupport;
	}
	
	public void setJavaSupport(boolean javaSupport) {
		this.javaSupport = javaSupport;
	}
}
