package org.xpect.runner;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.ComparisonFailure;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectStandaloneSetup;
import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.IXpectSetup;
import org.xpect.setup.SetupContext;
import org.xpect.setup.SetupInitializer;
import org.xpect.util.IssueVisualizer;

import com.google.common.collect.Lists;

public class XpectFileRunner {
	private List<XpectTestRunner> children;
	private Description description;
	private Throwable error;
	private XpectRunner runner;
	private URI uri;
	private XpectFile xpectFile;

	public XpectFileRunner(XpectRunner runner, URI uri) {
		this.runner = runner;
		this.uri = uri;
		try {
			this.xpectFile = loadXpectFile(loadXpectResource(uri));
		} catch (Throwable t) {
			this.error = t;
		}
	}

	protected Description createDescription() {
		String title = runner.getUriProvider().getTitle(getUri());
		Description result = Description.createSuiteDescription(title);
		if (error == null)
			for (XpectTestRunner child : getChildren())
				result.addChild(child.getDescription());
		return result;
	}

	protected XpectTestRunner createTestRunner(XpectInvocation invocation) {
		return new XpectTestRunner(this, invocation);
	}

	public List<XpectTestRunner> getChildren() {
		if (children == null) {
			children = Lists.newArrayList();
			for (XpectInvocation inv : xpectFile.getInvocations())
				children.add(createTestRunner(inv));
		}
		return children;
	}

	public Description getDescription() {
		if (description == null)
			description = createDescription();
		return description;
	}

	public Throwable getError() {
		return error;
	}

	public XpectRunner getRunner() {
		return runner;
	}

	public URI getUri() {
		return uri;
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	protected XpectFile loadXpectFile(XtextResource res) throws IOException {
		IResourceValidator validator = res.getResourceServiceProvider().get(IResourceValidator.class);
		List<Issue> issues = validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!issues.isEmpty()) {
			String document = res.getParseResult().getRootNode().getText();
			String errors = new IssueVisualizer().visualize(document, issues);
			throw new ComparisonFailure("Errors in " + res.getURI(), document.trim(), errors.trim());
		}
		if (res.getContents().isEmpty())
			throw new IllegalStateException("Resource for " + res.getURI() + " is empty.");
		EObject obj = res.getContents().get(0);
		if (!(obj instanceof XpectFile))
			throw new IllegalStateException("Root type differs from expectation: " + obj.eClass().getName() + " instead of "
					+ XpectFile.class.getSimpleName());
		return (XpectFile) obj;
	}

	protected XtextResource loadXpectResource(URI uri) throws IOException {
		IResourceServiceProvider rssp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createURI("foo.xpect"));
		if (rssp == null) {
			if (!EcorePlugin.IS_ECLIPSE_RUNNING)
				rssp = new XpectStandaloneSetup().createInjectorAndDoEMFRegistration().getInstance(IResourceServiceProvider.class);
			else
				throw new IllegalStateException("The language *.xpect is not activated");
		}
		XtextResourceSet resourceSet = rssp.get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(runner.getTestClass().getJavaClass().getClassLoader());
		XtextResource resource = (XtextResource) rssp.get(XtextResourceFactory.class).createResource(uri);
		resourceSet.getResources().add(resource);
		resource.load(null);
		return resource;
	}

	protected ISetupInitializer<Object> createSetupInitializer() {
		return new SetupInitializer<Object>(xpectFile.getTest());
	}

	public void run(RunNotifier notifier, IXpectSetup<Object, Object, Object, Object> setup, SetupContext ctx) {
		if (error != null) {
			notifier.fireTestFailure(new Failure(getDescription(), error));
		} else if (xpectFile.getTest() == null) {
			notifier.fireTestIgnored(getDescription());
		} else {
			ctx.setXpectFile(xpectFile);
			try {
				if (setup != null)
					ctx.setUserFileCtx(setup.beforeFile(ctx, ctx.getUserClassCtx(), createSetupInitializer()));
				if (getChildren().isEmpty()) {
					notifier.fireTestStarted(getDescription());
					notifier.fireTestFinished(getDescription());
				} else
					for (XpectTestRunner child : getChildren())
						try {
							child.run(notifier, setup, ctx);
						} catch (Throwable t) {
							notifier.fireTestFailure(new Failure(getDescription(), t));
						}
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			} finally {
				try {
					if (setup != null)
						setup.afterFile(ctx, ctx.getUserFileCtx());
				} catch (Throwable t) {
					notifier.fireTestFailure(new Failure(getDescription(), t));
				}
			}
		}
	}

}
