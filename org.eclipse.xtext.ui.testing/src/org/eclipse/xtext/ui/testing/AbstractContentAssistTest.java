/**
 * Copyright (c) 2013, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.eclipse.xtext.util.Strings;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @since 2.12
 */
@SuppressWarnings("restriction")
public abstract class AbstractContentAssistTest implements ResourceLoadHelper, IJavaProjectProvider {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Injector injector;

	/**
	 * the {@link IJavaProject} used during tests, this is created once by {@link #setUp()}.
	 * @since 2.35 
	 */
	protected static IJavaProject javaProject;

	/**
	 * cursor position marker
	 * @since 2.35 
	 */
	protected String c = "<|>";

	@BeforeClass
	@BeforeAll
	public static void setUp() throws CoreException {
		javaProject = JavaProjectSetupUtil.createJavaProject("contentAssistTest");
		IResourcesSetupUtil.addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
	}

	@AfterClass
	@AfterAll
	public static void tearDown() throws CoreException {
		IProject project = AbstractContentAssistTest.javaProject.getProject();
		project.delete(true, new NullProgressMonitor());
	}

	@Override
	public XtextResource getResourceFor(InputStream stream) {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		initializeTypeProvider(resourceSet);
		try {
			String projectFullPath = getJavaProject(resourceSet).getProject().getFullPath().toString();
			URI resourceUri = URI.createPlatformResourceURI(projectFullPath + "/" + getProjectRelativePath() + "/" + "Test." + fileExtensionProvider.getPrimaryFileExtension(), true);

			/*
			 * Avoid the following java.lang.IllegalStateException:
			 * A different resource with the URI 'platform:/resource/contentAssistTest/Test....' was already registered.
			 */
			Resource resource = resourceSet.getResource(resourceUri, false);
			if (resource == null) {
				resource = resourceSet.createResource(resourceUri);
			}
			resource.load(stream, null);
			return (XtextResource) resource;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the project relative path where the files should be created.
	 * The default implementation creates them directly in the src folder.
	 * Clients may override.
	 *
	 * @since 2.35 
	 */
	protected String getProjectRelativePath() {
		return "src";
	}

	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		return javaProject;
	}

	protected List<String> expect(String[]... arrays) {
		List<String> expectation = new ArrayList<>();
		for (String[] array : arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation;
	}

	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(injector, this);
	}

	protected void initializeTypeProvider(XtextResourceSet resourceSet) {
		JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}

	/**
	 * Creates a dsl file.
	 * 
	 * @param fileName
	 * 		The name of the file (without the file extension).
	 * 		It is also possible to customize the project relative path, see {@link #getProjectRelativePath()}.
	 * 		To use workspace relative path, use {@link IResourcesSetupUtil#createFile(String, String)} instead.
	 * 
	 * @param content
	 * 		The content of the file.
	 * 
	 * @since 2.35
	 */
	protected IFile createDslFile(String fileName, CharSequence content) {
		return createDslFile(fileName, fileExtensionProvider.getPrimaryFileExtension(), content);
	}

	/**
	 * Creates a dsl file.
	 * 
	 * @param fileName
	 * 		The name of the file (without the file extension).
	 * 		It is also possible to customize the project relative path, see {@link #getProjectRelativePath()}.
	 * 		To use workspace relative path, use {@link IResourcesSetupUtil#createFile(String, String)} instead.
	 * 
	 * @param fileExtension
	 * 		The extension of the file.
	 * 
	 * @param content
	 * 		The content of the file.
	 * 
	 * @since 2.35
	 */
	protected IFile createDslFile(String fileName, String fileExtension, CharSequence content) {
		try {
			return IResourcesSetupUtil.createFile(javaProject.getElementName(), getProjectRelativePath() + "/" + fileName, fileExtension, content.toString());
		} catch (InvocationTargetException | CoreException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Verifies whether the content assistant provides the expected proposals on the given cursor position.
	 * 
	 * @param text
	 * 		The editor's input text. The text must contain the {@link #c} special symbol indicating the current cursor position.
	 * 
	 * @param expectedProposals
	 * 		The proposals (separated by new lines) that are expected to be offered whenever the content assistant is triggered on the given cursor position.
	 * 
	 * @since 2.35
	 */
	protected void assertContentAssistant(CharSequence text, CharSequence expectedProposals) {
		assertContentAssistant(text, expectedProposals, null, null);
	}
	
	/**
	 * Verifies whether the content assistant provides the expected proposals on the given cursor position.
	 * 
	 * @param text
	 * 		The editor's input text. The text must contain the {@link #c} special symbol indicating the current cursor position.
	 * 
	 * @param expectedProposals
	 * 		The proposals that are expected to be offered whenever the content assistant is triggered on the given cursor position.
	 * 
	 * @since 2.35
	 */
	protected void assertContentAssistant(CharSequence text, String[] expectedProposals) {
		assertContentAssistant(text, expectedProposals, null, null);
	}

	/**
	 * Verifies whether the content assistant provides the expected proposals on the given cursor position.
	 * Furthermore, it applies the proposalToApply - if it is given - and verifies the expected content afterwards.
	 * 
	 * @param text
	 * 		The editor's input text. The text must contain the {@link #c} special symbol indicating the current cursor position.
	 * 
	 * @param expectedProposals
	 * 		The proposals (separated by new lines) that are expected to be offered whenever the content assistant is triggered on the given cursor position. 
	 * 
	 * @param proposalToApply
	 * 		The proposal to apply from the list of the expected proposals.
	 * 
	 * @param expectedContent
	 * 		The expected editor content after the given proposal has been applied.
	 * 
	 * @since 2.35
	 */
	protected void assertContentAssistant(CharSequence text, CharSequence expectedProposals, String proposalToApply, String expectedContent) {
		String[] expectedProposalsArray = Strings.toUnixLineSeparator(expectedProposals.toString()).split("\n");
		assertContentAssistant(text, expectedProposalsArray, proposalToApply, expectedContent);
	}
	
	/**
	 * Verifies whether the content assistant provides the expected proposals on the given cursor position.
	 * Furthermore, it applies the proposalToApply - if it is given - and verifies the expected content afterwards.
	 * 
	 * @param text
	 * 		The editor's input text. The text must contain the {@link #c} special symbol indicating the current cursor position.
	 * 
	 * @param expectedProposals
	 * 		The proposals that are expected to be offered whenever the content assistant is triggered on the given cursor position. 
	 * 
	 * @param proposalToApply
	 * 		The proposal to apply from the list of the expected proposals.
	 * 
	 * @param expectedContent
	 * 		The expected editor content after the given proposal has been applied.
	 * 
	 * @since 2.35
	 */
	protected void assertContentAssistant(CharSequence text, String[] expectedProposals, String proposalToApply, String expectedContent) {

		int cursorPosition = text.toString().indexOf(c);
		if (cursorPosition == -1) {
			throw new RuntimeException("Can't locate cursor position symbols '" + c + "' in the input text.");
		}

		String content = text.toString().replace(c, "");

		try {
			ContentAssistProcessorTestBuilder builder = newBuilder().append(content).assertTextAtCursorPosition(cursorPosition, expectedProposals);
	
			if (proposalToApply != null) {
				builder.applyProposal(cursorPosition, proposalToApply).expectContent(expectedContent);
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}
