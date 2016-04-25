/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtext.ide.editor.hierarchy.DefaultCallHierarchyBuilder.CallHierarchyType
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ide.AbstractHierarchyBuilderTest
import org.eclipse.xtext.junit4.internal.XtextInjectorProvider
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyBuilder
import org.eclipse.xtext.ui.editor.hierarchy.XtextCallHierarchyNode
import org.junit.Test
import org.junit.runner.RunWith
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode

/**
 * @author kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class XtextCallHierarchyBuilderTest extends AbstractHierarchyBuilderTest {

	@Inject
	Provider<XtextCallHierarchyBuilder> callHierarchyBuilderProvider

	override protected testBuildHierarchy((HierarchyBuilderTestConfiguration)=>void configurator) {
		super.testBuildHierarchy [
			hierarchyBuilderProvider = [ resourceSet |
				val callHierarchyBuilder = callHierarchyBuilderProvider.get.configureBuilderWith(resourceSet)
				callHierarchyBuilder.hierarchyType = CallHierarchyType.CALLER
				return callHierarchyBuilder
			]
			configurator.apply(it)
		]
	}

	protected def void testBuildCalleeHierarchy((HierarchyBuilderTestConfiguration)=>void configurator) {
		super.testBuildHierarchy [
			hierarchyBuilderProvider = [ resourceSet |
				val callHierarchyBuilder = callHierarchyBuilderProvider.get.configureBuilderWith(resourceSet)
				callHierarchyBuilder.hierarchyType = CallHierarchyType.CALLEE
				return callHierarchyBuilder
			]
			configurator.apply(it)
		]
	}

	@Test
	def void testBuildHierarchy_01() {
		testBuildHierarchy[
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model:
					element+=Element*
				;
				
				Element:
					name=ID
				;
			''')

			index = models.head.value.indexOf('Element*')
			expectedHierarchy = '''
				Element {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'element+=Element*' [250, 17]
					}
				}
			'''
		]
	}

	@Test
	def void testBuildCalleeHierarchy_01() {
		testBuildCalleeHierarchy[
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model:
					element+=Element*
				;
				
				Element:
					name=ID
				;
			''')

			index = models.head.value.indexOf('Model')
			expectedHierarchy = '''
				Model {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Element {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'element+=Element*' [250, 17]
						ID {
							grammar: org.eclipse.xtext.common.Terminals
							'name=ID' [281, 7]
						}
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_02() {
		testBuildHierarchy[
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model:
					element+=AbstractElement*
				;
				
				AbstractElement:
					Element |
					'(' Model ')'
				;
				
				Element:
					name=ID
				;
			''')

			index = models.head.value.indexOf('AbstractElement*')
			expectedHierarchy = '''
				AbstractElement {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'element+=AbstractElement*' [250, 25]
						AbstractElement {
							grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
							'Model' [312, 5]
						}
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_03() {
		testBuildHierarchy[
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model:
					element+=Element element+=Element element+=Element
				;
				
				Element:
					name=ID
				;
			''')

			index = models.head.value.lastIndexOf('Element')
			expectedHierarchy = '''
				Element {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'element+=Element' [250, 16]
						'element+=Element' [267, 16]
						'element+=Element' [284, 16]
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_04() {
		testBuildHierarchy[
			models += ('baseCallHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals hidden(ID)
				
				generate baseCallHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage"
				
				Model: name=ID;
			''')
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model: name=ID;
			''')

			resourceURI = models.head.key
			index = models.head.value.indexOf('ID')
			expectedHierarchy = '''
				ID {
					grammar: org.eclipse.xtext.common.Terminals
					org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
						'ID' [136, 2]
					}
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
						'name=ID' [272, 7]
					}
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'name=ID' [295, 7]
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_05() {
		testBuildHierarchy[
			models += ('baseCallHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate baseCallHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage"
				
				Model: name=ID;
			''')

			index = models.head.value.indexOf('BaseCallHierarchyBuilderTestLanguage')
			expectedHierarchy = ''
		]
	}

	@Test
	def void testBuildHierarchy_06() {
		testBuildHierarchy[
			models += ('baseCallHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate baseCallHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage"
				
				Model: 
					elements+=Element*
				;
				
				Element:
					name=ID
				;
			''')
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model2:
					elements+=Element*
				;
				
				Element:
					name=ID
				;
			''')

			resourceURI = models.head.key
			index = models.head.value.indexOf('Element')
			expectedHierarchy = '''
				Element {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
						'elements+=Element*' [263, 18]
					}
					Model2 {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'elements+=Element*' [297, 18]
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_07() {
		testBuildHierarchy[
			models += ('baseCallHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate baseCallHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/BaseCallHierarchyBuilderTestLanguage"
				
				Model: 
					elements+=Element*
				;
				
				Element:
					name=ID
				;
			''')
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model2:
					elements+=Element*
				;
				
				Element:
					name=ID
				;
			''')

			resourceURI = models.last.key
			index = models.last.value.indexOf('Element')
			expectedHierarchy = '''
				Element {
					grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.BaseCallHierarchyBuilderTestLanguage
						'elements+=Element*' [263, 18]
					}
					Model2 {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'elements+=Element*' [297, 18]
					}
				}
			'''
		]
	}

	@Test
	def void testBuildHierarchy_08() {
		testBuildHierarchy[
			models += ('callHierarchyBuilderTestLanguage.xtext' -> '''
				grammar org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage with org.eclipse.xtext.common.Terminals
				
				generate callHierarchyBuilderTestLanguage "http://www.eclipse.org/2010/tmf/xtext/CallHierarchyBuilderTestLanguage"
				
				Model:
					elements+=[Element]
					elements+=[Element|ID]
				;
				
				Element:
					name=ID
				;
			''')

			index = models.head.value.lastIndexOf('ID')
			expectedHierarchy = '''
				ID {
					grammar: org.eclipse.xtext.common.Terminals
					Model {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'elements+=[Element]' [250, 19]
						'elements+=[Element|ID]' [271, 22]
					}
					Element {
						grammar: org.eclipse.xtext.ui.tests.editor.hierarchy.CallHierarchyBuilderTestLanguage
						'name=ID' [307, 7]
					}
				}
			'''
		]
	}

	override protected internalToExpectation(IHierarchyNode node, IHierarchyBuilder builder) {
		val superExpectation = super.internalToExpectation(node, builder)
		if (node instanceof XtextCallHierarchyNode)
			return '''
				grammar: «node.grammarDescription»
				«superExpectation»
			'''
		return superExpectation
	}

}
