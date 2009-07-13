/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class MweReader extends AbstractWorkflowComponent2 {

	public static final String DEFAULT_OUTPUT_SLOT = "model";

	private Injector injector;

	public void setRegister(ISetup setup) {
		injector = setup.createInjectorAndDoEMFRegistration();
	}

	private String outputSlot = DEFAULT_OUTPUT_SLOT;

	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}

	private String uri = null;

	private Object classpathURIContext;

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (injector==null)
			issues.addError(this,"No setup has been registered (property 'register')");
		if (uri == null)
			issues.addError(this,"No resource uri configured (property 'uri')");
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		set.setClasspathURIContext(getClasspathURIContext());
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = set.getResource(URI.createURI(uri), true);
		Object value = getContent(resource);
		ctx.set(outputSlot, value);
		registerIssues(set,issues);

		doValidate(issues, resource);
	}

	protected EObject getContent(Resource resource) {
		return resource.getContents().get(0);
	}

	protected void doValidate(Issues issues, Resource resource) {
		if (validate) {
			EObject toCheck = getContent(resource);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(toCheck, getContext());
			registerIssues(diagnostic, issues);
		}
	}

	private void registerIssues(XtextResourceSet set, Issues issues) {
		for(Resource res: set.getResources())
			registerIssues(res, issues);
	}

	private String getIssueMessage(Resource res, Resource.Diagnostic diagnostic) {
		return String.format("%s(%d): %s", res.getURI().toString(), diagnostic.getLine(), diagnostic.getMessage());
	}

	private void registerIssues(Resource resource, Issues issues) {
		for (Resource.Diagnostic diagnostic : resource.getErrors()) {
			issues.addError(this, getIssueMessage(resource, diagnostic));
		}
		for (Resource.Diagnostic diagnostic : resource.getWarnings()) {
			issues.addWarning(this,getIssueMessage(resource, diagnostic));
		}
	}
	
	public Object getClasspathURIContext() {
        return classpathURIContext;
    }

    public void setClasspathURIContext(Object classpathURIContext) {
        this.classpathURIContext = classpathURIContext;
    }

	/**
	 * @return
	 */
	protected Map<?, ?> getContext() {
		return new HashMap<Object, Object>();
	}

	private boolean validate = true;

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	/**
	 * @param diagnostic
	 * @param issues
	 */
	private void registerIssues(Diagnostic d, Issues issues) {
		if (d.getSeverity() == Diagnostic.ERROR) {
			issues.addError(this, d.getMessage(), getContextObject(d));
		} else if (d.getSeverity() == Diagnostic.WARNING){
			issues.addWarning(this, d.getMessage(), getContextObject(d));
		}
		for (Diagnostic diag : d.getChildren()) {
			registerIssues(diag, issues);
		}
	}

	private Object getContextObject(Diagnostic d) {
		return d != null && d.getData() != null && d.getData().size() > 0 ? d.getData().get(0) : null;
	}

	@Override
	public String getLogMessage() {
		return "loading file from "+uri;
	}

}
