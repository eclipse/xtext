/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for EObjects.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class RuleEngineLabelProvider extends XbaseLabelProvider {

	@Inject
	public RuleEngineLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public String text(Rule rule) {
		Device device = ((Device) rule.getDeviceState().eContainer());
		return rule.getDescription() + " when " + device.getName() + "." + rule.getDeviceState().getName();
	}

	public String image(Rule rule) {
		return "rule.gif";
	}

	public String image(Device device) {
		return "device.gif";
	}

	public String image(State state) {
		return "state.gif";
	}
}
