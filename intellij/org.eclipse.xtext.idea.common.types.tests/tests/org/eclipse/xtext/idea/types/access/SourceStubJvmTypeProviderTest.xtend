package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.pom.java.LanguageLevel
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import java.io.File
import org.eclipse.xtext.idea.tests.TestDecorator

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

@TestDecorator
class SourceStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate

	override void setUp() throws Exception {
		super.setUp
		LanguageLevelProjectExtension.getInstance(myJavaFacade.project).setLanguageLevel(LanguageLevel.JDK_1_5)
		module.addGuavaLibrary
		
		val testDataFolder = new File("../../tests/org.eclipse.xtext.common.types.tests/testdata")
		val testDataSourceRoot = LocalFileSystem.instance.refreshAndFindFileByIoFile(testDataFolder)
		PsiTestUtil.addSourceRoot(myModule, testDataSourceRoot)
		delegate.setUp(project)
	}

	override protected getTestProjectJdk() {
		JavaAwareProjectJdkTableImpl.instanceEx.internalJdk
	}

	override void tearDown() throws Exception {
		delegate.tearDown
		super.tearDown
	}

}
