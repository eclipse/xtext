/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.tests

import com.google.inject.Inject
import com.intellij.codeInsight.CodeInsightSettings
import com.intellij.facet.FacetManager
import com.intellij.facet.FacetType
import com.intellij.facet.FacetTypeRegistry
import com.intellij.ide.highlighter.HighlighterFactory
import com.intellij.ide.structureView.newStructureView.StructureViewComponent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.StdModuleTypes
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.LanguageLevelModuleExtension
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.pom.java.LanguageLevel
import com.intellij.psi.codeStyle.CodeStyleSettingsManager
import com.intellij.psi.tree.IElementType
import com.intellij.testFramework.LightProjectDescriptor
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import com.intellij.util.Consumer
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.psi.impl.BaseXtextFile

import static org.eclipse.xtext.idea.build.XtextAutoBuilderComponent.*
import static org.eclipse.xtext.idea.tests.LightToolingTest.*

import static extension com.intellij.testFramework.PlatformTestUtil.*
import static extension com.intellij.util.ui.tree.TreeUtil.*

class LightToolingTest extends LightCodeInsightFixtureTestCase {

	@Inject extension TokenTypeProvider tokenTypeProvider
	@Inject extension AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper
	
	@Accessors
	val LanguageFileType fileType
	
	new(LanguageFileType fileType) {
		XtextAutoBuilderComponent.TEST_MODE = true
		this.fileType = fileType
	}

	override protected setUp() throws Exception {
		super.setUp
		xtextLanguage.injectMembers(this)
		CodeInsightSettings.instance.AUTOCOMPLETE_ON_CODE_COMPLETION = false
		codeStyleSettings.indentOptions.USE_TAB_CHARACTER = true
	}
	
	override protected tearDown() throws Exception {
		CodeInsightSettings.instance.AUTOCOMPLETE_ON_CODE_COMPLETION = true
		super.tearDown
	}

	def final protected getXtextLanguage() {
		fileType.language as IXtextLanguage
	}

	override protected getProjectDescriptor() {
		new LightProjectDescriptor() {
			override configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
				val languageLevelModuleExtension = model.getModuleExtension(LanguageLevelModuleExtension)
				if (languageLevelModuleExtension != null) {
					languageLevelModuleExtension.languageLevel = LightToolingTest.this.languageLevel
				}
				addFacetToModule(module, fileType.language.ID)
				LightToolingTest.this.configureModule(module, model, contentEntry)
			}
	

			override ModuleType<?> getModuleType() {
				StdModuleTypes.JAVA
			}

			override getSdk() {
				LightToolingTest.this.sdk
			}

		}
	}
	
	public static def void addFacetToModule(Module module, String languageId) {
		val mnr = FacetManager.getInstance(module)
		val facetType = FacetTypeRegistry.getInstance().facetTypes.findFirst [FacetType it|
			it.stringId == languageId
		]
		ApplicationManager.application.runWriteAction [|
			mnr.addFacet(facetType, facetType.defaultFacetName, null)
			return;
		]
	}
	
	protected def getSdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}
	
	protected def getLanguageLevel() {
		LanguageLevel.JDK_1_6
	}
	
	protected def void configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		
	}

	protected def configureByText(String code) {
		myFixture.configureByText(fileType, LineDelimiters.toUnix(code))
	}

	protected def complete(String text) {
		configureByText(text)
		myFixture.completeBasic
	}

	protected def assertLookupStrings(String... items) {
		assertEquals(items.toList, myFixture.lookupElementStrings)
	}
	
	protected def assertHighlights(String lineDelimitedHighlights) {
		val expectedHighlights = LineDelimiters.toUnix(lineDelimitedHighlights)
		val highlighter = HighlighterFactory.createHighlighter(project, myFixture.file.virtualFile) => [
	    	text = myFixture.editor.document.text
	    	colorScheme = myFixture.editor.colorsScheme
		]
		val highlights = highlighter.createIterator(0)
		val actualHighlights = compactHighlights(highlights)
		assertEquals(expectedHighlights, actualHighlights)
	}
	
	protected def compactHighlights(HighlighterIterator highlights) {
		val compactHighlights = new StringBuilder
		while(!highlights.atEnd) {
			val start = highlights.start
			val tokenType = highlights.tokenType
			var end = highlights.end
			while (!highlights.atEnd && highlights.tokenType == tokenType) {
				end = highlights.end
				highlights.advance
			}
			if(tokenType.xtextStyle != HighlightingStyles.DEFAULT_ID) {
				compactHighlights.append('''«start»-«end»:«tokenType.xtextStyle»''')
				compactHighlights.append("\n")
			}
		}
		compactHighlights.toString
	}
	
	protected def getXtextStyle(IElementType tokenType) {
		tokenType.antlrType.id
	}
	
	protected def getXtextFile() {
		myFixture.file as BaseXtextFile
	}

	protected def void testStructureView(String model, String expected) {
		testStructureView(model) [ component |
			component.assertTreeStructure(expected)
		]
	}

	protected def assertTreeStructure(StructureViewComponent component, String expected) {
		component.tree.expandAll
		component.treeStructure.assertTreeStructureEquals(expected)
	}

	protected def void testStructureView(String model, Consumer<StructureViewComponent> consumer) {
		myFixture.configureByText(fileType, model)
		testStructureView(consumer)
	}
	
	protected def void testStructureView(Consumer<StructureViewComponent> consumer) {
		myFixture.testStructureView(consumer)
	}

	protected def getCodeStyleSettings() {
		CodeStyleSettingsManager.getSettings(project)
	}

}