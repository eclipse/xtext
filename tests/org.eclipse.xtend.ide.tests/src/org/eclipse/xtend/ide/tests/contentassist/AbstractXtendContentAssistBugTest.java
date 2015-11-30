package org.eclipse.xtend.ide.tests.contentassist;

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.junit4.Flaky;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.junit4.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.ui.builder.XbaseBuilderPreferenceAccess;
import org.junit.Rule;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtendContentAssistBugTest extends AbstractXtendUITestCase implements IJavaProjectProvider, ResourceLoadHelper {

	private IProject demandCreateProject;
	
	@Inject
	private WorkbenchTestHelper testHelper;
	
	@Inject
	IPreferenceStoreAccess preferenceStoreAccess;
	
	@Inject
	XbaseBuilderPreferenceAccess xbaseBuilderPreferenceAccess;
	
	@Rule
	public Flaky.Rule testRule = new Flaky.Rule();
	
	@Override
	public void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		IPreferenceStore preferenceStore = preferenceStoreAccess.getWritablePreferenceStore(null);
		preferenceStore.setToDefault(XbaseBuilderPreferenceAccess.PREF_USE_COMPILER_SOURCE);
		preferenceStore.setToDefault(XbaseBuilderPreferenceAccess.PREF_JAVA_VERSION);
		super.tearDown();
	}
	
	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		IJavaProject javaProject = findJavaProject(WorkbenchTestHelper.TESTPROJECT_NAME);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME);
				javaProject = findJavaProject(WorkbenchTestHelper.TESTPROJECT_NAME);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	@Override
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = get(XtextResourceSet.class);
			XtextResource result = (XtextResource) set.createResource(URI.createURI("Test." + testHelper.getFileExtension()));
			result.load(stream, null);
			initializeTypeProvider(result);
			return result;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}
	
	protected String[] expect(String[]... arrays) {
		List<String> expectation = Lists.newArrayList();
		for(String[] array: arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation.toArray(new String[expectation.size()]);
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
	@Override
	protected void setJavaVersion(JavaVersion javaVersion) throws Exception {
		// The content assist models have no access to the project settings, so set the global preferences
		xbaseBuilderPreferenceAccess.setJavaVersion(null, javaVersion);
		super.setJavaVersion(javaVersion);
	}
	
}
