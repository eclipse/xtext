/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class StatemachineGenerator extends AbstractGenerator {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val statemachine = resource.contents.filter(Statemachine).head
		if (statemachine !== null) {
			fsa.generateFile('/DEFAULT_ARTIFACT', generateHtml(statemachine))
			fsa.generateFile('/hidden.txt', '''This is an additional generator artifact.''')
		}
	}
	
	private def generateHtml(Statemachine statemachine) '''
		<!DOCTYPE html>
		<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<meta http-equiv="Content-Language" content="en-us">
			<title>State Machine Overview</title>
			<link rel="stylesheet" type="text/css" href="/style.css" />
			<style>
				.signal {
					color: #383;
					font-weight: bold;
				}
				.state {
					color: #338;
					font-weight: bold;
				}
			</style>
		</head>
		<body>
		<div class="text-container">
			<h2>Signals</h2>
			«FOR signal : statemachine.signals.sortBy[name]»
				<span class="signal">«signal.name»</span> («IF signal instanceof InputSignal»input«ELSE»output«ENDIF»)</br>
			«ENDFOR»
			<h2>States</h2>
			«FOR state : statemachine.states.sortBy[name]»
				<span class="state">«state.name»</span> &ndash; transitions: «IF state.transitions.empty»NONE«ELSE»«FOR transition : state.transitions SEPARATOR ', '»«transition.state.name»«ENDFOR»«ENDIF»</br>
			«ENDFOR»
		</div>
		</body>
		</html>
	'''
	
	
}
