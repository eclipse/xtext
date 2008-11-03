/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.internal.xtend.type.impl.java.JavaMetaModel;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtext.xtext.ui.wizard.EclipseResourceUtil;

/**
 * This is a project wizard used to help in the creation of new Xtext Projects.
 * The wizard contains one page with the following configurations options
 * <p>
 * wizard page ask's for:
 * <ul>
 * <li>Main project name (default: org.xtext.example.MyDsl)</li>
 * <li>Qualified language name (default: org.xtext.example.MyDsl)</li>
 * <li>DSL-File extensions (comma separated) (default: dsl)</li>
 * <li>Namespace URI (for the EPackage to be generated)
 * (default:http://example.xtext.org/MyDsl)</li>
 * </ul>
 * </p>
 * <p>
 * In addition there is a checkbox "Create generator project" to indicate the
 * creation of a new 'generator' project which is activated by default. The
 * wizard than creates three to four plug-in projects *
 * <ul>
 * <li>main project name}</li>
 * <li>main project name}.ui</li>
 * <li>main project name}.ui_gen</li>
 * <li>[{main project name}.generator] based on the checkbox state mentioned
 * above</li>
 * </ul>
 * 
 * @author Michael Clay - Initial contribution and API
 */

public class NewXtextProjectWizard extends Wizard implements INewWizard {

	private static Logger logger = Logger.getLogger(NewXtextProjectWizard.class);

	private NewXtextProjectWizardPage page;
	private ISelection selection;

	/**
	 * Constructor for NewXtextProjectWizard.
	 */
	public NewXtextProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new NewXtextProjectWizardPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(page.getXtextProjectInfo(), monitor);
				}
				catch (Exception e) {
					throw new InvocationTargetException(e);
				}
				finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(final XtextProjectInfo xtextProjectInfo, final IProgressMonitor monitor) {
		new UIJob("creating Xtext projects...") {

			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				try {
					new XtextProjectCreator(xtextProjectInfo).run(monitor);
				}
				catch (final InvocationTargetException e) {
					logger.error(e);
				}
				catch (final InterruptedException e) {
					logger.error(e);
				}
				return Status.OK_STATUS;
			}

		}.schedule();

	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	private class XtextProjectCreator extends WorkspaceModifyOperation {

		// some constants
		private static final String SRC_GEN_ROOT = "src-gen";
		private static final String SRC_ROOT = "src";
		private final List<String> SRC_FOLDER_LIST = Collections
				.unmodifiableList(Arrays.asList(SRC_ROOT, SRC_GEN_ROOT));

		private final XtextProjectInfo xtextProjectInfo;

		public XtextProjectCreator(final XtextProjectInfo xtextProjectInfo) {
			this.xtextProjectInfo = xtextProjectInfo;
		}

		@Override
		protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
				InterruptedException {
			monitor.beginTask("Creating dsl project's " + xtextProjectInfo.getProjectName(), 3);

			String basePackage = xtextProjectInfo.getBasePackage();
			// DSL Project
			List<String> exportedPackages = Arrays.asList(basePackage, basePackage + ".parser",
			basePackage + ".parser.internal", basePackage + ".parsetree.reconstr", basePackage
					+ ".services");
			final IProject dslProject = EclipseResourceUtil.createProject(xtextProjectInfo.getProjectName(),
					SRC_FOLDER_LIST, Collections.<IProject> emptyList(), new LinkedHashSet<String>(Arrays.asList(
							"org.eclipse.xtext.log4j;bundle-version=\"1.2.15\"", "org.eclipse.xtext",
							"org.eclipse.xtext.generator", "org.apache.log4j", "org.antlr.gen", "org.eclipse.xtend",
							"org.eclipse.xtend.typesystem.emf", "org.eclipse.xpand", "org.apache.commons.logging",
							"org.eclipse.xtend.util.stdlib")), exportedPackages, null, monitor, NewXtextProjectWizard.this.getShell());

			if (dslProject == null) {
				return;
			}
			
			EclipseResourceUtil.createPackagesWithDummyClasses(dslProject,"src-gen",exportedPackages);
			monitor.worked(1);

			// DSL UI Project
			final IProject dslUIProject = EclipseResourceUtil.createProject(xtextProjectInfo.getProjectName() + ".ui",
					SRC_FOLDER_LIST, Collections.<IProject> emptyList(), new LinkedHashSet<String>(Arrays.asList(
							xtextProjectInfo.getProjectName().toLowerCase() + ";visibility:=reexport",
							"org.eclipse.xtext.ui.core", "org.eclipse.xtext.ui.common",
							"org.eclipse.xtext.log4j;bundle-version=\"1.2.15\"",
							"org.eclipse.ui.editors;bundle-version=\"3.4.0\"")), Arrays.asList(basePackage
							+ ".ui.services"), null, monitor, NewXtextProjectWizard.this.getShell());

			if (dslUIProject == null) {
				return;
			}
			monitor.worked(1);

			// Generator Project
			IProject dslGeneratorProject = null;
			if (xtextProjectInfo.isCreateGeneratorProject()) {
				dslGeneratorProject = EclipseResourceUtil.createProject(xtextProjectInfo.getProjectName()
						+ ".generator", SRC_FOLDER_LIST, Collections.<IProject> emptyList(), new LinkedHashSet<String>(
						Arrays.asList(xtextProjectInfo.getProjectName().toLowerCase(), "org.eclipse.xtext",
								"org.eclipse.xtext.generator")), Collections.<String> emptyList(), null, monitor,
						NewXtextProjectWizard.this.getShell());

				if (dslGeneratorProject == null) {
					return;
				}
			}
			monitor.worked(1);

			IFolder basePackageFolder = createSubPackages(basePackage, dslProject, (IFolder) dslProject
					.findMember(SRC_ROOT), monitor);

			OutputImpl output = new OutputImpl();
			String defaultEncoding = System.getProperty("file.encoding");
			output.addOutlet(new Outlet(false, defaultEncoding, "GRAMMAR_GENERATOR_OUTLET", true, basePackageFolder
					.getLocation().makeAbsolute().toOSString()));
			if (dslGeneratorProject != null) {
				output.addOutlet(new Outlet(false, defaultEncoding, "GENERATOR_OUTLET", true, createSubPackages(
						basePackage, dslGeneratorProject, (IFolder) dslGeneratorProject.findMember(SRC_ROOT), monitor)
						.getLocation().makeAbsolute().toOSString()));
				EclipseResourceUtil.createFile("Model." + xtextProjectInfo.getFirstFileExtension(), createSubPackages(
						"model", dslGeneratorProject, (IFolder) dslGeneratorProject.findMember(SRC_ROOT), monitor),
						"//Your model", monitor);
			}
			output.addOutlet(new Outlet(false, defaultEncoding, "ACTIVATOR_OUTLET", true, dslUIProject.getFolder(
					SRC_ROOT + IPath.SEPARATOR + xtextProjectInfo.getBasePath() + IPath.SEPARATOR + "ui").getLocation()
					.makeAbsolute().toOSString()));
			XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null, Collections.singletonMap(
					"xtextProjectInfo", new Variable("xtextProjectInfo", xtextProjectInfo)), null, null);
			execCtx.registerMetaModel(new JavaMetaModel());

			// generate generator and activator for dsl and dsl.ui project
			XpandFacade facade = XpandFacade.create(execCtx);
			facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::XtextTemplateFile::root",
					xtextProjectInfo);
			facade
					.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::GrammarGenerator::root",
							xtextProjectInfo);
			facade.evaluate("org::eclipse::xtext::xtext::ui::wizard::project::Generator::root", xtextProjectInfo);

			EclipseResourceUtil.createFile("dummy.properties", createSubPackages(basePackage + ".ui.services",
					dslUIProject, (IFolder) dslUIProject.findMember(SRC_ROOT), monitor), "a=b", monitor);

			monitor.worked(1);

			// refresh folder and select file to edit
			basePackageFolder.refreshLocal(1, monitor);
			IFile dslGrammarFile = getDslGrammarFile(basePackageFolder);
			BasicNewResourceWizard
					.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			EclipseResourceUtil.openFileToEdit(getShell(), dslGrammarFile);

		}

		private IFile getDslGrammarFile(IFolder folder) throws CoreException {
			for (IResource resource : folder.members()) {
				if (!"java".equals(resource.getFileExtension())) {
					return (IFile) resource;
				}
			}
			throw new IllegalStateException("No xtext file was found in folder '" + folder.toString() + "'!");
		}

		private IFolder createSubPackages(String basePackage, final IProject project, IFolder srcFolder,
				final IProgressMonitor monitor) throws CoreException {
			for (String packageName : basePackage.split("\\.")) {
				srcFolder = (IFolder) project.getFolder(srcFolder.getProjectRelativePath().toString() + IPath.SEPARATOR
						+ packageName);
				srcFolder.create(true, true, new SubProgressMonitor(monitor, 1));
			}
			return srcFolder;
		}
	}

}