package org.eclipse.xtext.xbase.ui.tests.quickfix

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Singleton
import java.io.InputStream
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext
import org.eclipse.xtext.ui.shared.SharedStateModule
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.xbase.XbaseRuntimeModule
import org.eclipse.xtext.xbase.ui.XbaseUiModule
import org.eclipse.xtext.xbase.ui.internal.XbaseActivator
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

abstract class AbstractXbaseQuickfixTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
	IProject demandCreateProject;

	static Injector injector = Guice::createInjector(
		Modules2::mixin(new XbaseRuntimeModule(), new SharedStateModule(),
			new TestQuickfixXbaseUIModule(XbaseActivator::instance))
	)

	override void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}

	override getJavaProject(ResourceSet resourceSet) {
		val projectName = getProjectName();
		var javaProject = findJavaProject(projectName);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = AbstractXbaseUITestCase::createPluginProject(projectName);
				javaProject = findJavaProject(projectName);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	def protected String getProjectName() {
		return getClass().getSimpleName() + "Project";
	}

	override getResourceFor(InputStream stream) {
		try {
			val result = getResourceSet().createResource(URI::createURI("Test." + fileExtension)) as XtextResource
			result.load(stream, null);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	def getResourceSet() {
		val set = get(typeof(XtextResourceSet))
		set.setClasspathURIContext(getJavaProject(set))
		set
	}

	override getInjector() {
		injector
	}

}

class TestQuickfixXbaseUIModule extends XbaseUiModule {

	new(AbstractUIPlugin plugin) {
		super(plugin);
	}

	def Class<? extends IssueModificationContext> bindIssueModificationContext() {
		return typeof(TestIssueModificationContext)
	}
}

@Singleton
class TestIssueModificationContext extends IssueModificationContext {
	IXtextDocument doc

	override IXtextDocument getXtextDocument() {
		return doc
	}

	def setDocument(IXtextDocument doc) {
		this.doc = doc;
	}

}
