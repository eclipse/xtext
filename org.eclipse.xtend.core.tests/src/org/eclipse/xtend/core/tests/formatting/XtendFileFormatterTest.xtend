package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

import static org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys.*

class XtendFileFormatterTest extends AbstractXtendFormatterTest {
	
	@Test def formatClass11() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			class bar {
			}
		''')	
	}
	
	@Test def formatClass12() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			class bar
			{
			}
		''')	
	}
	
	@Test def formatClass112() {
		assertFormatted([
			put(bracesInNewLine, false)
		],'''
			package foo
			
			class bar {
				int member1
			}
		''')	
	}
	
	@Test def formatClass122() {
		assertFormatted([
			put(bracesInNewLine, true)
		],'''
			package foo
			
			class bar
			{
				int member1
			}
		''')	
	}
	
	@Test def formatClass111() {
		assertFormatted('''
			package foo
			
			class bar {
			}
			''', '''   package  foo  class  bar  {  }''')	
	}
	
	@Test def formatClass2() {
		assertFormatted('''
			class bar {
			}
		''', '''
			class bar{}
		''')	
	}
	
	@Test def formatClass3() {
		assertFormatted('''
			class bar {
				int member1
				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', '''
			class bar{ int member1 int member2 def meth1() {} def meth2(){} int member3 }
		''')	
	}
	
	@Test def formatClass31() {
		assertFormatted('''
			class bar {
			
				def meth1() {
				}
			
			}
		''', '''
			class bar{
			

				def meth1() {} 


			}
		''')	
	}
	
	@Test def formatClass4() {
		assertFormatted('''
			class bar {

				int member1

				int member2
			
				def meth1() {
				}
			
				def meth2() {
				}
			
				int member3
			}
		''', '''
			class bar{
				
				
				int member1 
				
				
				int member2 
				
				
				def meth1() {} 
				
				
				def meth2(){} 
				
				
				int member3
			}
		''')	
	}
	
	@Test def formatClasses1() {
		assertFormatted('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''', '''
			package foo class bar{} class baz{}
		''')	
	}
	
	@Test def formatClasses2() {
		assertFormatted('''
			package foo
			
			class bar {
			}
			
			class baz {
			}
		''', '''
			package foo 
			
			
			
			class bar{} 
			
			
			
			class baz{}
		''')	
	}
	
	@Test def formatImports1() {
		assertFormatted('''
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
		assertFormatted('''
			package foo
			
			import java.util.Map
			
			import java.util.Set
			
			class bar {
			}
		''', '''
			package foo
			
			import java.util.Map

			
			import java.util.Set


			
			class bar {
			}
		''')	
	}
	
	@Test def formatPreferencesExample() {
		assertFormatted('''
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
		''')	
	}
	
	@Test def formatPreferencesExample_02() {
		assertFormatted('''
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
		''')	
	}

	@Test def formatAssignment_01() {
		assertFormatted('''
			class C {
				int i
			
				def m() {
					this.i = 5
				}
			}
		''')	
	}

	@Test def formatAssignment_02() {
		assertFormatted('''
			class C {
				static int i
			
				def m() {
					C::i = 5
				}
			}
		''')	
	}
	
	@Test def typeReferenceIntegration() {
		assertFormatted('''
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