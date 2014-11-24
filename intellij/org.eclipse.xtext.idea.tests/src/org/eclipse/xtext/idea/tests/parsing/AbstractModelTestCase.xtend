package org.eclipse.xtext.idea.tests.parsing

import com.google.inject.Inject
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.LanguageLevelModuleExtension
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.pom.java.LanguageLevel
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import java.io.ByteArrayInputStream
import java.io.IOException
import javax.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.resource.IResourceSetProvider
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.InvariantChecker
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*
import static extension org.eclipse.xtext.util.EmfFormatter.*

class AbstractModelTestCase extends LightCodeInsightFixtureTestCase implements ModelChecker {

	public static val JAVA_INTERNAL = new DefaultLightProjectDescriptor() {

		override getSdk() {
			JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
		}

		override configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
			val languageLevelModuleExtension = model.getModuleExtension(LanguageLevelModuleExtension)
			if (languageLevelModuleExtension != null) {
				languageLevelModuleExtension.languageLevel = LanguageLevel.JDK_1_6
			}
			model.addXbaseLibrary
		}

	}

	@Inject
	@Accessors(PROTECTED_GETTER)
	BaseXtextASTFactory astFactory

	@Inject
	@Accessors(PROTECTED_GETTER)
	ValidationTestHelper validationHelper

	@Inject
	@Accessors(PROTECTED_GETTER)
	IResourceSetProvider resourceSetProvider

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension NodeModelPrinter nodeModelPrinter

	@Inject
	@Accessors(PROTECTED_GETTER)
	extension InvariantChecker invariantChecker

	@Inject
	@Accessors(PROTECTED_GETTER)
	Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider

	val LanguageFileType fileType

	new(LanguageFileType fileType) {
		this.fileType = fileType
		xtextLanguage.injectMembers(this)
	}

	override protected setUp() throws Exception {
		super.setUp()
	}

	def protected getXtextLanguage() {
		fileType.language as IXtextLanguage
	}

	override protected getProjectDescriptor() {
		JAVA_INTERNAL
	}

	override <T extends EObject> checkModel(String code, boolean validate) {
		checkModel(code)
		val model = actualResource.contents.head as T
		if (validate) {
			validationHelper.assertNoErrors(model)
		}
		model
	}

	protected def void checkModel(String code) {
		myFixture.configureByText(fileType, code)

		val actualResource = actualResource
		val expectedResource = createExpectedResource
		val expectedRootNode = expectedResource.parseResult.rootNode
		val actualRootNode = actualResource.parseResult.rootNode
		assertEquals(expectedRootNode.print, actualRootNode.print)
		assertEquals(expectedRootNode.semanticElement.objToStr, actualRootNode.semanticElement.objToStr)
		actualRootNode.checkInvariant
		val nodesMapping = PsiToEcoreAdapter.get(actualResource).nodesMapping
		for (astNode : nodesMapping.keySet) {
			val node = nodesMapping.get(astNode)
			assertTrue('''Node «node» is not a part of the tree''', node.belongsTo(actualRootNode))
		}
	}

	protected def belongsTo(INode node, ICompositeNode rootNode) {
		rootNode.asTreeIterable.exists[it == node]
	}

	def protected XtextResource getActualResource() {
		xtextFile.resource as XtextResource
	}

	def protected XtextResource createExpectedResource() {
		var resourceSet = resourceSetProvider.get(myFixture.project)
		var resource = resourceSet.createResource(URI.createURI(xtextFile.virtualFile.url)) as XtextResource
		try {
			resource.load(new ByteArrayInputStream(xtextFile.text.bytes), null)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}
		return resource
	}

	protected def getXtextFile() {
		myFixture.file as BaseXtextFile
	}

}
