package org.xpect.tests

import com.google.common.io.Closeables
import java.io.ByteArrayInputStream
import java.net.URL
import org.junit.Test
import org.xpect.registry.StandaloneExtensionRegistry

import static org.xpect.tests.TestUtil.*
import org.xpect.registry.FileExtensionInfoRegistry

class FileExtensionInfoTest {
	@Test def void testEmfExtensionParserDefault() {
		val actual = '''
			<extension point="org.eclipse.emf.ecore.extension_parser">
				<parser
					class="org.FooExecutableExtensionFactory:org.eclipse.xtext.resource.IResourceFactory"
					type="foo">
				</parser>
			</extension>
		'''.parse
		val expected = '''
			IEmfFileExtensionInfo{fileExtensions=[foo]}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testEmfExtensionParser() {
		val actual = '''
			<extension point="org.eclipse.emf.ecore.extension_parser">
				<parser
					class="org.FooExecutableExtensionFactory:org.foo.BarFactory"
					type="foo">
				</parser>
			</extension>
		'''.parse
		val expected = '''
			IEmfFileExtensionInfo{fileExtensions=[foo], resourceFactory=org.foo.BarFactory}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testResourceServiceProviderDefault() {
		val actual = '''
			<extension point="org.eclipse.xtext.extension_resourceServiceProvider">
				<resourceServiceProvider
					class="org.FooExecutableExtensionFactory:org.eclipse.xtext.ui.resource.IResourceUIServiceProvider"
					uriExtension="foo">
				</resourceServiceProvider>
			</extension>
			<extension point="org.xpect.fileExtensions">
				<fileExtension
					emfResourceFactory="org.eclipse.xtext.resource.IResourceFactory"
					fileExtension="foo"
					xtextLanguageName="org.foo.Foo"
					xtextResourceServiceProvider="org.eclipse.xtext.resource.IResourceServiceProvider"
					xtextRuntimeModule="org.foo.RuntimeModule">
				</fileExtension>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[foo], languageID=org.foo.Foo, runtimeModule=org.foo.RuntimeModule, uiModule=org.FooUiModule}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testResourceServiceProvider() {
		val actual = '''
			<extension point="org.eclipse.xtext.extension_resourceServiceProvider">
				<resourceServiceProvider
					class="org.FooExecutableExtensionFactory:org.foo.ResourceUIServiceProvider"
					uriExtension="foo">
				</resourceServiceProvider>
			</extension>
			<extension point="org.xpect.fileExtensions">
				<fileExtension
					emfResourceFactory="org.foo.ResourceFactory"
					fileExtension="foo"
					xtextLanguageName="org.foo.Foo"
					xtextResourceServiceProvider="org.foo.ResourceServiceProvider"
					xtextRuntimeModule="org.foo.RuntimeModule">
				</fileExtension>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[foo], resourceFactory=org.foo.ResourceFactory, languageID=org.foo.Foo, runtimeModule=org.foo.RuntimeModule, uiModule=org.FooUiModule, resourceServiceProvider=org.foo.ResourceServiceProvider, resourceUIServiceProvider=org.foo.ResourceUIServiceProvider}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testEditor() {
		val actual = '''
			<extension point="org.eclipse.ui.editors">
				<editor
					class="org.foo.ui.FooExecutableExtensionFactory:org.eclipse.xtext.ui.editor.XtextEditor"
					contributorClass="org.eclipse.ui.editors.text.TextEditorActionContributor"
					default="true"
					extensions="foo, bar"
					id="org.foo.Foo"
					name="Foo Editor">
				</editor>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[bar, foo], languageID=org.foo.Foo, runtimeModule=org.foo.FooRuntimeModule, uiModule=org.foo.ui.FooUiModule}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testXpectFileExtension() {
		val actual = '''
			<extension point="org.xpect.fileExtensions">
				<fileExtension
					emfResourceFactory="org.foo.ResourceFactory"
					fileExtension="foo, bar"
					xtextLanguageName="org.foo.Foo"
					xtextResourceServiceProvider="org.foo.ResourceServiceProvider"
					xtextResourceUIServiceProvider="org.foo.ResourceUIServiceProvider"
					xtextRuntimeModule="org.foo.RuntimeModule"
					xtextUiModule="org.foo.uiModle">
				</fileExtension>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[bar, foo], resourceFactory=org.foo.ResourceFactory, languageID=org.foo.Foo, runtimeModule=org.foo.RuntimeModule, uiModule=org.foo.uiModle, resourceServiceProvider=org.foo.ResourceServiceProvider, resourceUIServiceProvider=org.foo.ResourceUIServiceProvider}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testLanguageWithoutUI() {
		val actual = '''
			<extension point="org.xpect.fileExtensions">
				<fileExtension
					emfResourceFactory="org.foo.ResourceFactory"
					fileExtension="foo, bar"
					xtextLanguageName="org.foo.Foo"
					xtextResourceServiceProvider="org.foo.ResourceServiceProvider"
					xtextRuntimeModule="org.foo.RuntimeModule">
				</fileExtension>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[bar, foo], resourceFactory=org.foo.ResourceFactory, languageID=org.foo.Foo, runtimeModule=org.foo.RuntimeModule, resourceServiceProvider=org.foo.ResourceServiceProvider}
		'''
		assertEquals(expected, actual)
	}

	@Test def void testRedundant() {
		val actual = '''
			<extension point="org.eclipse.emf.ecore.extension_parser">
				<parser
					class="org.FooExecutableExtensionFactory:org.foo.ResourceFactory"
					type="foo">
				</parser>
			</extension>
			<extension point="org.eclipse.emf.ecore.extension_parser">
				<parser
					class="org.FooExecutableExtensionFactory:org.foo.ResourceFactory"
					type="bar">
				</parser>
			</extension>
			<extension point="org.eclipse.xtext.extension_resourceServiceProvider">
				<resourceServiceProvider
					class="org.FooExecutableExtensionFactory:org.foo.ResourceUIServiceProvider"
					uriExtension="foo">
				</resourceServiceProvider>
			</extension>
			<extension point="org.eclipse.xtext.extension_resourceServiceProvider">
				<resourceServiceProvider
					class="org.FooExecutableExtensionFactory:org.foo.ResourceUIServiceProvider"
					uriExtension="bar">
				</resourceServiceProvider>
			</extension>
			<extension point="org.eclipse.ui.editors">
				<editor
					class="org.FooExecutableExtensionFactory:org.eclipse.xtext.ui.editor.XtextEditor"
					contributorClass="org.eclipse.ui.editors.text.TextEditorActionContributor"
					default="true"
					extensions="foo, bar"
					id="org.foo.Foo"
					name="Foo Editor">
				</editor>
			</extension>
			<extension point="org.xpect.fileExtensions">
				<fileExtension
					emfResourceFactory="org.foo.ResourceFactory"
					fileExtension="foo, bar"
					xtextLanguageName="org.foo.Foo"
					xtextResourceServiceProvider="org.foo.ResourceServiceProvider"
					xtextResourceUIServiceProvider="org.foo.ResourceUIServiceProvider"
					xtextRuntimeModule="org.foo.FooRuntimeModule"
					xtextUiModule="org.FooUiModule">
				</fileExtension>
			</extension>
		'''.parse
		val expected = '''
			IXtextFileExtensionInfo{fileExtensions=[bar, foo], resourceFactory=org.foo.ResourceFactory, languageID=org.foo.Foo, runtimeModule=org.foo.FooRuntimeModule, uiModule=org.FooUiModule, resourceServiceProvider=org.foo.ResourceServiceProvider, resourceUIServiceProvider=org.foo.ResourceUIServiceProvider}
		'''
		assertEquals(expected, actual)
	}

	def String parse(CharSequence pluginXmlContent) {
		val in = new ByteArrayInputStream(
			'''
				<?xml version="1.0" encoding="UTF-8"?>
				<?eclipse version="3.0"?>
				<plugin>
					«pluginXmlContent»
				</plugin>
			'''.toString.getBytes("UTF-8")
		)
		val extensionInfo = new StandaloneExtensionRegistry(new URL("file:/plugin.xml"), in)
		Closeables.closeQuietly(in)
		val fileExtensionInfo = new FileExtensionInfoRegistry(extensionInfo)
		fileExtensionInfo.toString
	}
}
