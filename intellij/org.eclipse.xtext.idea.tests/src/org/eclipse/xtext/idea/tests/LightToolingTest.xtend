package org.eclipse.xtext.idea.tests

import com.intellij.codeInsight.CodeInsightSettings
import com.intellij.ide.highlighter.HighlighterFactory
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
import com.intellij.testFramework.LightProjectDescriptor
import com.intellij.testFramework.fixtures.JavaCodeInsightTestFixture
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.psi.impl.BaseXtextFile

class LightToolingTest extends LightCodeInsightFixtureTestCase {

	val LanguageFileType fileType
	protected var extension JavaCodeInsightTestFixture myFixture

	new(LanguageFileType fileType) {
		this.fileType = fileType
		xtextLanguage.injectMembers(this)
	}

	override protected setUp() throws Exception {
		super.setUp
		myFixture = super.myFixture
		CodeInsightSettings.instance.AUTOCOMPLETE_ON_CODE_COMPLETION = false
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
	
	protected def getSdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}
	
	protected def getLanguageLevel() {
		LanguageLevel.JDK_1_6
	}
	
	protected def void configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		
	}

	protected def configureByText(String code) {
		configureByText(fileType, LineDelimiters.toUnix(code))
	}

	protected def complete(String text) {
		configureByText(text)
		completeBasic
	}

	protected def assertLookupStrings(String... items) {
		assertEquals(items.toList, lookupElementStrings)
	}
	
	protected def assertHighlights(String lineDelimitedHighlights) {
		val expectedHighlights = LineDelimiters.toUnix(lineDelimitedHighlights)
		val highlighter = HighlighterFactory.createHighlighter(project, file.virtualFile) => [
	    	text = editor.document.text
	    	colorScheme = editor.colorsScheme
		]
		val highlights = highlighter.createIterator(0)
		val actualHighlights = compactHighlights(highlights)
		assertEquals(expectedHighlights, actualHighlights)
	}
	
	protected def compactHighlights(HighlighterIterator highlights) {
		val compactHighlights = new StringBuilder
		while(!highlights.atEnd) {
			val start = highlights.start
			val textAttributes = highlights.textAttributes
			var end = highlights.end
			while (!highlights.atEnd && highlights.textAttributes == textAttributes) {
				end = highlights.end
				highlights.advance
			}
			compactHighlights.append('''«start»-«end»:«textAttributes»''')
			compactHighlights.append("\n")
		}
		compactHighlights.toString
	}

	protected def getXtextFile() {
		file as BaseXtextFile
	}

}