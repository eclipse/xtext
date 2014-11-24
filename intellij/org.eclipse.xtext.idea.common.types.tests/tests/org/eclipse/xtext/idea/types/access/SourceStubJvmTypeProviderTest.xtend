package org.eclipse.xtext.idea.types.access

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.LanguageLevelProjectExtension
import com.intellij.openapi.util.Computable
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.pom.java.LanguageLevel
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import org.eclipse.xtext.idea.tests.TestDecorator

@TestDecorator
class SourceStubJvmTypeProviderTest extends PsiTestCase {

	val StubJvmTypeProviderTestDelegate delegate = new StubJvmTypeProviderTestDelegate

	override void setUp() throws Exception {
		super.setUp
		PsiTestUtil.addLibrary(module, "Guava", "/Users/kosyakov/.p2/pool/plugins", "com.google.guava_15.0.0.v201403281430.jar")
		
		LanguageLevelProjectExtension.getInstance(myJavaFacade.project).setLanguageLevel(LanguageLevel.JDK_1_5)
		val testPath = '/Users/kosyakov/oomph/xtext/master/git/xtext/tests/org.eclipse.xtext.common.types.tests/testdata'
		val testRoot = ApplicationManager.application.runWriteAction(
			[ |
				LocalFileSystem.instance.refreshAndFindFileByPath(testPath)
			] as Computable<VirtualFile>)
		if (testRoot != null) {
			PsiTestUtil.addSourceRoot(myModule, testRoot)
		}
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
