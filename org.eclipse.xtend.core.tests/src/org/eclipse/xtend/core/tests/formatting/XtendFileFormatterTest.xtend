/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.formatting2.XtendFormatterPreferenceKeys
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.FormatterPreferenceKeys.*
import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class XtendFileFormatterTest extends AbstractFormatterTest {

	@Test def formatClass11() {
		'''
			package foo
			
			class bar {
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatClass12() {
		'''
			package foo
			
			class bar
			{
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatClass112() {
		'''
			package foo
			
			class bar {
				int member1
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, false)]
	}

	@Test def formatClass122() {
		'''
			package foo
			
			class bar
			{
				int member1
			}
		'''.assertUnformattedEqualsFormatted[put(bracesInNewLine, true)]
	}

	@Test def formatClass111() {
		'''   package  foo  class  bar  {  }'''.assertFormattedTo('''
			package foo
			
			class bar {
			}
		''')
	}

	@Test def formatClass2() {
		'''
			class bar{}
		'''.assertFormattedTo('''
			class bar {
			}
		''')
	}

	@Test def formatClass3() {
		'''
			class bar{ int member1 int member2 def meth1() {} def meth2(){} int member3 }
		'''.assertFormattedTo('''
			class bar {
				int member1
				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', [put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)])
	}

	@Test def formatClass31() {
		'''
			class bar{
			

				def meth1() {} 


			}
		'''.assertFormattedTo('''
			class bar {
			
				def meth1() {
				}
			
			}
		''', [put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)])
	}

	@Test def formatClass4() {
		'''
			class bar{
				
				
				int member1 
				
				
				int member2 
				
				
				def meth1() {} 
				
				
				def meth2(){} 
				
				
				int member3
			}
		'''.assertFormattedTo('''
			class bar {

				int member1

				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', [put(XtendFormatterPreferenceKeys.keepOneLineMethods, false)])
	}

	@Test def formatClasses1() {
		'''
			package foo class bar{} class baz{}
		'''.assertFormattedTo('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''')
	}

	@Test def formatClasses2() {
		'''
			package foo 
			
			
			
			class bar{} 
			
			
			
			class baz{}
		'''.assertFormattedTo('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''')
	}

	@Test def formatImports1() {
		assertUnformattedEqualsFormatted('''
			package foo
			
			import java.util.Map
			import java.util.Set
			
			class bar {
				def baz() {
				}
			}
		''')
	}

	@Test def formatImports2() {
		'''
			package foo
			
			import java.util.Map

			
			import java.util.Set


			
			class bar {
			}
		'''.assertFormattedTo('''
			package foo
			
			import java.util.Map
			
			import java.util.Set
			
			class bar {
			}
		''')
	}

	@Test def formatPreferencesExample() {
		assertUnformattedEqualsFormatted('''
			class Movies {
				def settings(XtendFormatterConfig config) {
					val List<FormatterSetting> settings = newArrayList()
					for (entry : config.namedProperties.entrySet) {
						val key = entry.key
						val category = key.split(".").head
						var catEnum = Category::byName(category)
						if (catEnum == null)
							catEnum = Category::OTHER
						settings.add(
							createSetting(catEnum, SettingsData$WidgetType::NUMBER_FIELD,
								key, key.toFirstUpper, newArrayList(entry.value.name)))
					}
					return settings
				}
			}
		''', [put(maxLineWidth, 80)])
	}

	@Test def formatPreferencesExample_02() {
		assertUnformattedEqualsFormatted('''
			class Movies {
				def settings(XtendFormatterConfig config) {
					val List<FormatterSetting> settings = newArrayList()
					for (entry : config.namedProperties.entrySet) {
						val key = entry.key
						val category = key.split(".").head
						var catEnum = Category::byName(category)
						if (catEnum == null)
							catEnum = Category::OTHER
						settings.add(
							createSetting(catEnum, SettingsData::WidgetType::NUMBER_FIELD,
								key, key.toFirstUpper, newArrayList(entry.value.name)))
					}
					return settings
				}
			}
		''', [put(maxLineWidth, 80)])
	}

	@Test def formatAssignment_01() {
		assertUnformattedEqualsFormatted('''
			class C {
				int i
			
				def m() {
					this.i = 5
				}
			}
		''')
	}

	@Test def formatAssignment_02() {
		assertUnformattedEqualsFormatted('''
			class C {
				static int i
			
				def m() {
					C::i = 5
				}
			}
		''')
	}

	@Test def typeReferenceIntegration() {
		assertUnformattedEqualsFormatted('''
			import java.util.*

			abstract class Foo extends AbstractMap<String, Collection<?>> implements List<String>, Map<String, Collection<?>> {
				String[] field

				def String[] methode(String[] param) {
					val String[] valTypes = null
					val featureCall1 = <String>newArrayList
					val featureCall2 = <String, Collection<?>>newHashMap
					val memberFeatureCall1 = featureCall1.<String>toList
					val memberFeatureCall2 = featureCall1.<String, Collection<?>>toMap[it]
					val constructorCall1 = new ArrayList<String>
					val constructorCall2 = new HashMap<String, Collection<?>>
					val slclosure1 = [Collection<String> x|x]
					val slclosure2 = [Collection<String> x, Map<String, Collection<?>> y|x]
					val mlclosure1 = [ Collection<String> x |
						x
					]
					val mlclosure2 = [ Collection<String> x, Map<String, Collection<?>> y |
						x
					]
					null
				}
			}
		''')
	} 

}