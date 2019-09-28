/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.tests

import java.io.StringWriter
import javax.inject.Inject
import javax.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEngineFactory
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.XbaseFactory
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuleEngineInjectorProvider)
class SerializerTest extends Assert {

	@Inject ISerializer serializer
	extension RuleEngineFactory = RuleEngineFactory.eINSTANCE
	extension XbaseFactory = XbaseFactory.eINSTANCE
	@Inject extension FileExtensionProvider
	@Inject Provider<XtextResourceSet> rsProvider

	@Test def test() {

		val model = createModel
		val rs = rsProvider.get

		model.declarations += createDevice => [
			name = "Window"
			states += #["open","closed"].map[s|createState => [name=s]]
		]

		model.declarations += createDevice => [
			name = "Heater"
			states += #["on","off"].map[s|createState => [name=s]]
		]

		model.declarations += createRule => [
			description = "Save energy"
			deviceState = (model.declarations.head as Device).states.head
			thenPart = createXBlockExpression => [
				expressions += createXVariableDeclaration => [
					name = "msg"
					right = createXStringLiteral => [ value = "Another penny to the piggy bank!" ]
				]
				expressions += createXVariableDeclaration => [
					name = "x"
					right = createXNumberLiteral => [ value = "1" ]
				]
			]
		]

		val resource = rs.createResource(URI.createURI("heater." + primaryFileExtension))
		resource.contents += model

		val sw = new StringWriter
		serializer.serialize(model, sw, SaveOptions.newBuilder.format.options)
		assertEquals('''
			Device Window can be open, closed
			Device Heater can be on, off
			Rule "Save energy" when Window.open then
				val msg = "Another penny to the piggy bank!"
				val x = 1
		'''.toString, sw.toString)
	}

}