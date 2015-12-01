package org.eclipse.xtext.idea.tests

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.projectRoots.impl.ProjectJdkImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.util.Computable
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.IdeaTestCase
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import com.intellij.openapi.vfs.VfsUtil

abstract class AbstractIdeaTestCase extends IdeaTestCase {

	VirtualFile srcFolder

	abstract def void configureModule(Module module, ModifiableRootModel model, ContentEntry entry);

	override protected isRunInWriteAction() {
		return false
	}

	protected def <T> T write(Computable<T> c) {
		ApplicationManager.application.runWriteAction(c)
	}

	protected def VirtualFile addFile(Pair<String, String> file) {
		write [
			val result = srcFolder.findOrCreateChildData(AbstractIdeaTestCase.this, file.key)
			VfsUtil.saveText(result, file.value)
			assertNoCompileErrors(result)
			return result
		]
	}

	override protected setUp() throws Exception {
		super.setUp()
		write [
			val mnr = ModuleRootManager.getInstance(module)
			val model = mnr.modifiableModel
			val entry = model.addContentEntry(project.baseDir)
			srcFolder = VfsUtil.createDirectoryIfMissing(project.baseDir, "src")
			entry.addSourceFolder(srcFolder, srcFolder.testSource)
			configureModule(module, model, entry)
			model.commit
			return null;
		]
	}
	
	protected def isTestSource(VirtualFile srcFolder) {
		false
	}

	protected def void assertNoCompileErrors(VirtualFile file) {
		val psiFile = psiManager.findFile(file)
		if (psiFile instanceof BaseXtextFile) {
			val resource = psiFile.resource
			val issues = resource.resourceServiceProvider.resourceValidator.validate(resource,
				CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl)
			assertFalse(issues.toString, issues.exists[severity == Severity.ERROR])
		}
	}

	override protected getTestProjectJdk() {
		try {
			var ProjectJdkImpl jdk = JavaAwareProjectJdkTableImpl.getInstanceEx().getInternalJdk().
				clone() as ProjectJdkImpl
			jdk.setName("JDK")
			return jdk
		} catch (CloneNotSupportedException e) {
			LOG.error(e)
			return null
		}
	}

}