/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class StatemachineGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		val statemachine = resource.contents.filter(Statemachine).head
		if (statemachine !== null) {
			fsa.generateFile('statemachine.html', generateHtml(statemachine))
		}
	}
	
	private def generateHtml(Statemachine statemachine) '''
		<!DOCTYPE html>
		<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<meta http-equiv="Content-Language" content="en-us">
			<title>State Machine Overview</title>
		</head>
		<body>
			<h1>Signals</h1>
			«FOR signal : statemachine.signals»
				<i>«signal.name»</i> («IF signal instanceof InputSignal»input«ELSE»output«ENDIF»)</br>
			«ENDFOR»
			<h1>States</h1>
			«FOR state : statemachine.states»
				<i>«state.name»</i> &ndash; transitions: «IF state.transitions.empty»NONE«ELSE»«FOR transition : state.transitions SEPARATOR ', '»«transition.state.name»«ENDFOR»«ENDIF»</br>
			«ENDFOR»
		</body>
		</html>
	'''
	
}
