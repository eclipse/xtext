package org.eclipse.xtext.purexbase.ui.autoedit;

import static com.google.common.collect.Sets.newHashSet;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext;
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ReplAutoEdit implements IAutoEditStrategy {

	@Inject
	private Provider<XbaseInterpreter> interpreterProvider;

	@Inject
	private IBatchTypeResolver typeResolver;

	@Inject
	private IResourceValidator validator;

	@Override
	public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
		if (!isLineDelimiter(document, command)) {
			return;
		}
		try {
			IXtextDocument doc = (IXtextDocument) document;
			String result = doc.tryReadOnly(new IUnitOfWork<String, XtextResource>() {
				@Override
				public String exec(XtextResource resource) throws Exception {
					return computeResultText(document, command, resource);
				}
			});
			if (result == null)
				return;
			command.text = result;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isLineDelimiter(IDocument document, DocumentCommand command) {
		if (command.length != 0) {
			return false;
		}
		String originalText = command.text;
		String[] lineDelimiters = document.getLegalLineDelimiters();
		int delimiterIndex = TextUtilities.startsWith(lineDelimiters, originalText);
		return delimiterIndex != -1 && originalText.trim().length() == 0;
	}

	protected String computeResultText(final IDocument document, final DocumentCommand command, XtextResource resource)
			throws BadLocationException {
		if (resource.getContents().isEmpty())
			return null;
		if (!(resource.getContents().get(0) instanceof Model))
			return null;
		Model model = (Model) resource.getContents().get(0);
		if (model.getBlock() == null)
			return null;
		EList<XExpression> expressions = model.getBlock().getExpressions();
		if (expressions.isEmpty())
			return null;
		XExpression expression = expressions.get(expressions.size() - 1);
		if (expression == null) {
			return null;
		}
		ICompositeNode node = NodeModelUtils.getNode(expression);
		if (node == null || document.getLineOfOffset(command.offset) + 1 != node.getEndLine())
			return null;
		List<Issue> issues = validator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		if (issues.stream().anyMatch(i -> i.getSeverity() == Severity.ERROR)) {
			return null;
		}
		XbaseInterpreter xbaseInterpreter = getConfiguredInterpreter(resource);
		IEvaluationResult result = xbaseInterpreter.evaluate(model.getBlock(), new DefaultEvaluationContext(),
				new CancelIndicator() {
					private long stopAt = System.currentTimeMillis() + 2000;

					@Override
					public boolean isCanceled() {
						return System.currentTimeMillis() > stopAt;
					}
				});
		if (result == null)
			return null;

		String value = "" + result.getResult();
		if (result.getException() != null)
			value = "threw " + result.getException().getClass().getSimpleName();

		LightweightTypeReference expressionType = typeResolver.resolveTypes(expression).getActualType(expression);
		if (expressionType != null) {
			String newText = command.text + "// " + value + " ("
					+ expressionType.getSimpleName() + ")" + command.text;
			return newText;
		}
		return command.text + "// " + value;
	}

	protected XbaseInterpreter getConfiguredInterpreter(XtextResource resource) {
		XbaseInterpreter interpreter2 = interpreterProvider.get();
		ResourceSet set = resource.getResourceSet();
		ClassLoader cl = getClass().getClassLoader();
		if (set instanceof XtextResourceSet) {
			Object context = ((XtextResourceSet) set).getClasspathURIContext();
			if (context instanceof IJavaProject) {
				try {
					final IJavaProject jp = (IJavaProject) context;
					// String[] runtimeClassPath =
					// JavaRuntime.computeDefaultRuntimeClassPath(jp);
					// URL[] urls = new URL[runtimeClassPath.length];
					// for (int i = 0; i < urls.length; i++) {
					// urls[i] = new URL(runtimeClassPath[i]);
					// }
					// cl = new URLClassLoader(urls);
					IClasspathEntry[] classpath = jp.getResolvedClasspath(true);
					final IWorkspaceRoot root = jp.getProject().getWorkspace().getRoot();
					Set<URL> urls = newHashSet();
					for (int i = 0; i < classpath.length; i++) {
						final IClasspathEntry entry = classpath[i];
						if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
							IPath outputLocation = entry.getOutputLocation();
							if (outputLocation == null) {
								outputLocation = jp.getOutputLocation();
							}
							IFolder folder = root.getFolder(outputLocation);
							if (folder.exists()) {
								urls.add(new URL(folder.getRawLocationURI().toASCIIString() + "/"));
							}
						} else if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
							IPath outputLocation = entry.getOutputLocation();
							if (outputLocation == null) {
								IProject project = (IProject) jp.getProject().getWorkspace().getRoot()
										.getContainerForLocation(entry.getPath());
								IJavaProject javaProject = JavaCore.create(project);
								outputLocation = javaProject.getOutputLocation();
							}
							IFolder folder = root.getFolder(outputLocation);
							if (folder.exists()) {
								urls.add(new URL(folder.getRawLocationURI().toASCIIString() + "/"));
							}
						} else {
							urls.add(entry.getPath().toFile().toURI().toURL());
						}
					}
					cl = new URLClassLoader(urls.toArray(new URL[urls.size()]));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		interpreter2.setClassLoader(cl);
		return interpreter2;
	}

}
