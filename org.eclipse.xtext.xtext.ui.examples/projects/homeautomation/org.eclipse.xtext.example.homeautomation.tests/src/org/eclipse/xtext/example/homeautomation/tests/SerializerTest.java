/**
 * Copyright (c) 2016, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.tests;

import java.io.StringWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEngineFactory;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
public class SerializerTest extends Assert {
	@Inject
	private ISerializer serializer;

	private RuleEngineFactory ruleEngineFactory = RuleEngineFactory.eINSTANCE;

	private XbaseFactory xbaseFactory = XbaseFactory.eINSTANCE;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Provider<XtextResourceSet> rsProvider;

	@Test
	public void test() throws Exception {
		Model model = ruleEngineFactory.createModel();
		XtextResourceSet rs = rsProvider.get();
		Device deviceWindows = createDevice("Window");
		model.getDeclarations().add(deviceWindows);
		State openState = createState("open");
		deviceWindows.getStates().add(openState);
		deviceWindows.getStates().add(createState("closed"));
		Device deviceHeater = createDevice("Heater");
		deviceHeater.getStates().add(createState("on"));
		deviceHeater.getStates().add(createState("off"));
		model.getDeclarations().add(deviceHeater);
		Rule rule = this.ruleEngineFactory.createRule();
		rule.setDescription("Save energy");
		rule.setDeviceState(openState);
		XBlockExpression block = xbaseFactory.createXBlockExpression();
		XVariableDeclaration var1 = xbaseFactory.createXVariableDeclaration();
		var1.setName("msg");
		XStringLiteral stringLiteral = this.xbaseFactory.createXStringLiteral();
		stringLiteral.setValue("Another penny to the piggy bank!");
		var1.setRight(stringLiteral);
		block.getExpressions().add(var1);
		XVariableDeclaration var2 = xbaseFactory.createXVariableDeclaration();
		var2.setName("x");
		XNumberLiteral numberLiteral = xbaseFactory.createXNumberLiteral();
		numberLiteral.setValue("1");
		var2.setRight(numberLiteral);
		block.getExpressions().add(var2);
		rule.setThenPart(block);
		model.getDeclarations().add(rule);
		Resource resource = rs.createResource(URI.createURI("heater." + fileExtensionProvider.getPrimaryFileExtension()));
		resource.getContents().add(model);
		StringWriter sw = new StringWriter();
		serializer.serialize(model, sw, SaveOptions.newBuilder().format().getOptions());
		String expectation =
				"Device Window can be open, closed\n" +
				"Device Heater can be on, off\n" +
				"Rule \"Save energy\" when Window.open then\n" +
				"	val msg = \"Another penny to the piggy bank!\"\n" +
				"	val x = 1\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), sw.toString());
	}
	
	private Device createDevice(String name) {
		Device device = ruleEngineFactory.createDevice();
		device.setName(name);
		return device;
	}
	
	private State createState(String name) {
		State state = ruleEngineFactory.createState();
		state.setName(name);
		return state;
	}
}
