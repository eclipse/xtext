/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.test

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine
import org.eclipse.xtext.web.server.generator.GeneratorResult
import org.eclipse.xtext.web.server.generator.GeneratorService
import org.eclipse.xtext.web.server.test.GeneratorTest.Generator
import org.junit.Test

class GeneratorTest extends AbstractWebServerTest {
	
	static Generator generatorInstance
	
	static class Generator extends AbstractGenerator {
		
		int invocationCount = 0
		
		new() {
			generatorInstance = this
		}
		
		override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext ctx) {
			invocationCount++
			val statemachine = input.contents.filter(Statemachine).head
			fsa.generateFile('/DEFAULT_ARTIFACT', '''
				«FOR state : statemachine.states SEPARATOR ','»«state.name»«ENDFOR»
			''')
			fsa.generateFile('/test.txt', '''hello, world!''')
		}

	}
	
	override protected getRuntimeModule() {
		new StatemachineRuntimeModule {
			override bindIGenerator2() {
				Generator
			}
		}
	}
	
	@Test def testGenerateText() {
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name})
		assertFalse(generate.hasSideEffects)
		val result = generate.service.apply() as GeneratorResult
		val String expectedResult = '''
			GeneratorResult [
			  name = "DEFAULT_OUTPUT/DEFAULT_ARTIFACT"
			  content = "foo,bar\n"
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testGenerateAdditionalText() {
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name, 'artifact' -> 'DEFAULT_OUTPUT/test.txt'})
		assertFalse(generate.hasSideEffects)
		val result = generate.service.apply() as GeneratorResult
		val String expectedResult = '''
			GeneratorResult [
			  name = "DEFAULT_OUTPUT/test.txt"
			  contentType = "text/plain"
			  content = "hello, world!"
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testInvokedOnce() {
		if (generatorInstance !== null)
			generatorInstance.invocationCount = 0
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name})
		generate.service.apply()
		assertEquals(1, generatorInstance.invocationCount)
		generate.service.apply()
		assertEquals(1, generatorInstance.invocationCount)
	}
	
	@Test def testGetResultWithoutContent() {
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name, 'artifact' -> 'DEFAULT_OUTPUT/test.txt',
				'includeContent' -> 'false'})
		val result = generate.service.apply() as GeneratorResult
		val String expectedResult = '''
			GeneratorResult [
			  name = "DEFAULT_OUTPUT/test.txt"
			  contentType = "text/plain"
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testGetAllResults() {
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name, 'allArtifacts' -> 'true'})
		val result = generate.service.apply() as GeneratorService.GeneratedArtifacts
		val String expectedResult = '''
			GeneratedArtifacts [
			  artifacts = ArrayList (
			    GeneratorResult [
			      name = "DEFAULT_OUTPUT/DEFAULT_ARTIFACT"
			      content = "foo,bar\n"
			    ],
			    GeneratorResult [
			      name = "DEFAULT_OUTPUT/test.txt"
			      contentType = "text/plain"
			      content = "hello, world!"
			    ]
			  )
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
	@Test def testGetAllResultsWithoutContent() {
		val file = createFile('state foo end state bar end')
		val generate = getService(#{'serviceType' -> 'generate', 'resource' -> file.name, 'allArtifacts' -> 'true',
				'includeContent' -> 'false'})
		val result = generate.service.apply() as GeneratorService.GeneratedArtifacts
		val String expectedResult = '''
			GeneratedArtifacts [
			  artifacts = ArrayList (
			    GeneratorResult [
			      name = "DEFAULT_OUTPUT/DEFAULT_ARTIFACT"
			    ],
			    GeneratorResult [
			      name = "DEFAULT_OUTPUT/test.txt"
			      contentType = "text/plain"
			    ]
			  )
			]'''
		assertEquals(expectedResult, result.toString)
	}
	
}