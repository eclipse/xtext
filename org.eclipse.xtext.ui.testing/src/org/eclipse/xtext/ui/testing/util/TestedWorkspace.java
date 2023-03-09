/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.testing.RepeatedTest;
import org.eclipse.xtext.util.Exceptions;
import org.junit.Assert;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.google.common.annotations.Beta;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * A tested workspace encapsulates pairwise logic that is supposed to be executed around a
 * test methods. One may think of it as a utility to achieve a consistent setup and tearDown 
 * for tests, that do use a workspace.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @see TestedWorkspaceWithJDT
 * @see org.eclipse.xtext.builder.noJdt.TestedWorkspaceWithoutJdt
 * @see TestWatcher
 * @see org.junit.rules.TestRule
 * @since 2.17
 */
@Beta
public abstract class TestedWorkspace extends TestWatcher {

	private String name;

	private final ProjectOpenedOrClosedListener closedProjectTaskProcessor;
	
	@Inject
	private IBuilderState builderState;

	protected TestedWorkspace(ProjectOpenedOrClosedListener closedProjectTaskProcessor) {
		this.closedProjectTaskProcessor = closedProjectTaskProcessor;
	}
	
	@Override
	public Statement apply(Statement statement, Description description) {
		Statement result = super.apply(statement, description);
		// Apparently there is no good solution to order TestRules
		// that's why we do inline the (simple) logic for RepeatedTest here.
		RepeatedTest repeat = description.getAnnotation(RepeatedTest.class);
		if (repeat == null) {
			repeat = description.getTestClass().getAnnotation(RepeatedTest.class);
		}
		if (repeat != null) {
			result = new RepeatedTest.Rule.RepeatedTestStatement(repeat.times(), result, description, false);
		}
		return result;
	}
	
	@Override
	protected void starting(Description d) {
		name = d.getMethodName();
		
		assertEmptyIndex();
		Assert.assertEquals(0, IResourcesSetupUtil.root().getProjects().length);

		if (PlatformUI.isWorkbenchRunning()) {
			final IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
			if (introManager.getIntro() != null) {
				Display.getDefault().asyncExec(()->introManager.closeIntro(introManager.getIntro()));
			}
		}
	}

	/**
	 * Join on the job that processes removed projects. The calling thread will effectively wait
	 * for the job to finish.
	 */
	private void joinRemovedProjectsJob() {
		closedProjectTaskProcessor.joinRemoveProjectJob();
	}

	@Override
	protected void finished(Description description) {
		super.finished(description);
		deleteAllProjects();
		build();
		assertEmptyIndex();
	}

	public void assertEmptyIndex() {
		Collection<IResourceDescription> inIndex = Lists.newArrayList(builderState.getAllResourceDescriptions());
		if (!inIndex.isEmpty()) {
			StringBuilder remaining = new StringBuilder();
			inIndex.forEach(desc -> remaining.append(desc.getURI()).append("\n"));
			Assert.assertEquals(remaining.toString(), 0, inIndex.size());
		}
	}

	public void build() {
		joinJobsBeforeBuild();
		IResourcesSetupUtil.waitForBuild();
	}

	/**
	 * Some events in the workspace are processed asynchronously. These async operations
	 * must be finished before a build can yield meaningful results. This method is used
	 * to sync on all these processes.
	 * 
	 * Implementation note: Specializations of this method are not supposed to do some
	 * busy waiting or sleepting but it is strongly encouraged to join on the concrete
	 * async operations.  
	 */
	public void joinJobsBeforeBuild() {
		joinRemovedProjectsJob();
	}

	public void cleanBuild() {
		try {
			joinJobsBeforeBuild();
			IResourcesSetupUtil.cleanBuild();
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}

	public void fullBuild() {
		try {
			joinJobsBeforeBuild();
			IResourcesSetupUtil.fullBuild();
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}

	public IFile createFile(IPath wsRelativePath, final String content) {
		try {
			return IResourcesSetupUtil.createFile(wsRelativePath, content);
		} catch (Exception e) {
			return Exceptions.throwUncheckedException(e);
		}
	}
	
	public IFile createFile(String wsRelativePath, String content) {
		return createFile(new Path(wsRelativePath), content);
	}

	public String readFile(IFile file) {
		try {
			return IResourcesSetupUtil.fileToString(file);
		} catch (Exception e) {
			return Exceptions.throwUncheckedException(e);
		}
	}

	public void deleteAllProjects() {
		try {
			IResourcesSetupUtil.cleanWorkspace();
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}

	/**
	 * @return the name of the currently-running test method
	 */
	public String getTestName() {
		return name;
	}

	public IProject createProject() {
		return createProject(getTestName());
	}
	
	@FunctionalInterface
	public interface IWorkspaceModifyOperation {
		void accept(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException;
		
		default ISchedulingRule getRule() {
			return IDEWorkbenchPlugin.getPluginWorkspace().getRoot();
		}
	}
	
	public void run(IWorkspaceModifyOperation op) {
		try {
			new WorkspaceModifyOperation(op.getRule()) {
				@Override
				protected void execute(IProgressMonitor monitor) throws InvocationTargetException, CoreException, InterruptedException {
					op.accept(monitor);
				}
			}.run(monitor());
		} catch (InvocationTargetException | InterruptedException e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	@FunctionalInterface
	public interface IWorkspaceModifyOperationWithResult<Result> {
		Result compute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException;
		
		default ISchedulingRule getRule() {
			return IDEWorkbenchPlugin.getPluginWorkspace().getRoot();
		}
	}
	
	public <Result> Result run(IWorkspaceModifyOperationWithResult<? extends Result> op) {
		try {
			return new WorkspaceModifyOperation(op.getRule()) {
				Result result;
				@Override
				protected void execute(IProgressMonitor monitor) throws InvocationTargetException, CoreException, InterruptedException {
					this.result = op.compute(monitor);
				}
				protected Result getResult() throws InvocationTargetException, InterruptedException {
					run(monitor());
					return result;
				}
			}.getResult();
		} catch (InvocationTargetException | InterruptedException e) {
			return Exceptions.throwUncheckedException(e);
		}
	}

	public IProject createProject(String name) {
		try {
			return IResourcesSetupUtil.createProject(name);
		} catch (Exception e) {
			return Exceptions.throwUncheckedException(e);
		}
	}

	public void addNature(IProject project, String natureId) {
		try {
			IResourcesSetupUtil.addNature(project, natureId);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	public void addBuilder(IProject project, String builderId) {
		try {
			IResourcesSetupUtil.addBuilder(project, builderId);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	public void setReference(final IProject from, final IProject to) {
		try {
			IResourcesSetupUtil.setReference(from, to);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	public void removeReference(final IProject from, final IProject to) {
		try {
			IResourcesSetupUtil.removeReference(from, to);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	public void removeNature(IProject project, String natureId) {
		try {
			IResourcesSetupUtil.removeNature(project, natureId);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}
	
	public void removeBuilder(IProject project, String builderId) {
		try {
			IResourcesSetupUtil.removeBuilder(project, builderId);
		} catch (Exception e) {
			Exceptions.throwUncheckedException(e);
		}
	}

	public IWorkspaceRoot root() {
		return IResourcesSetupUtil.root();
	}

	public IProgressMonitor monitor() {
		return IResourcesSetupUtil.monitor();
	}

	public void enableAutobuild(Runnable r) {
		withAutobuild(true, r);
	}

	public void disableAutobuild(Runnable r) {
		withAutobuild(false, r);
	}

	private void withAutobuild(boolean enabled, Runnable r) {
		boolean prev = ResourcesPlugin.getWorkspace().getDescription().isAutoBuilding();
		if (prev == enabled) {
			r.run();
		} else {
			try {
				IResourcesSetupUtil.setAutobuild(enabled);
				r.run();
			} finally {
				IResourcesSetupUtil.setAutobuild(prev);
			}
		}
	}
}
