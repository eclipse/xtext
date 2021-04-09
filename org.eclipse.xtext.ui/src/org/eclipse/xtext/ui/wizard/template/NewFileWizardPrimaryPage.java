/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The first page shown in the {@link TemplateNewFileWizard}. Allows selection of a path, a name and optionally of any parameters provided
 * by a template. In case multiple templates are available a combo box is shown to select the template. In that case the configuration of
 * the template parameters is done inside a {@link TemplateParameterPage}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class NewFileWizardPrimaryPage extends WizardPage implements IParameterPage {

	private final AbstractFileTemplate[] templates;
	private final IStructuredSelection selection;

	private Text folderText;
	private Text fileText;
	private ParameterComposite parameterComposite;

	private ComboViewer templateCombo;
	private TemplateLabelProvider labelProvider;

	protected NewFileWizardPrimaryPage(String pageName, AbstractFileTemplate[] templates, IStructuredSelection selection,
			TemplateLabelProvider labelProvider) {
		super(pageName);
		this.templates = templates;
		this.selection = selection;
		this.labelProvider = labelProvider;
	}

	@Override
	public void createControl(Composite parent) {
		setTitle(Messages.TemplateNewFileWizard_title);
		if (hasExactlyOneTemplate()) {
			setDescription(getSelectedTemplate().getDescription());
		} else {
			setDescription(Messages.TemplateNewFileWizard_create_new);
		}

		Composite main = new Composite(parent, SWT.NONE);
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		main.setLayout(new GridLayout(2, false));

		createHeader(main);
		createTemplateWidgets(main);

		setControl(main);

		validateInitial();
	}

	private void createHeader(Composite parent) {
		Composite main = new Composite(parent, SWT.NONE);
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		main.setLayout(new GridLayout(3, false));

		Label folderLabel = new Label(main, SWT.NONE);
		folderLabel.setText(Messages.NewFileWizardPrimaryPage_folder_label);
		folderLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		folderText = new Text(main, SWT.SINGLE | SWT.BORDER);
		folderText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button folderBrowseButton = new Button(main, SWT.PUSH);
		folderBrowseButton.setText(Messages.NewFileWizardPrimaryPage_browse_button);
		folderBrowseButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		Label fileLabel = new Label(main, SWT.NONE);
		fileLabel.setText(Messages.NewFileWizardPrimaryPage_name_label);
		fileLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		fileText = new Text(main, SWT.SINGLE | SWT.BORDER);
		fileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		fileText.setFocus();

		folderText.setText(initFolderText());
		fileText.setText(initFileText());

		folderText.addModifyListener(e -> validate());
		fileText.addModifyListener(e -> validate());
		folderBrowseButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog dialog = new ContainerSelectionDialog(Display.getDefault().getActiveShell(),
						ResourcesPlugin.getWorkspace().getRoot(), false, Messages.NewFileWizardPrimaryPage_selection_description);
				if (dialog.open() == Window.OK) {
					folderText.setText(getFolderFromPath((IPath) dialog.getResult()[0]));
				}
			}
		});
	}
	
	/**
	 * @since 2.25
	 */
	protected String initFolderText() {
		return getFolderFromSelection();
	}

	/**
	 * @since 2.25
	 */
	protected String initFileText() {
		return "";
	}
	
	/**
	 * @since 2.25
	 */
	protected String getFolderFromSelection() {
		Object element = Adapters.adapt(selection.getFirstElement(), IResource.class);
		IContainer container = null;
		if (element instanceof IContainer) {
			container = (IContainer) element;
		} else if (element instanceof IResource) {
			container = ((IResource) element).getParent();
		}
		if (container != null) {
			return getFolderStringFromContainer(container);
		}
		return ""; //$NON-NLS-1$
	}

	private String getFolderStringFromContainer(IContainer container) {
		return getFolderFromPath(container.getFullPath());
	}

	private String getFolderFromPath(IPath path) {
		String result = path.toOSString();
		if (result.startsWith(File.separator)) {
			return result.substring(File.separator.length());
		}
		return result;
	}

	private void createTemplateWidgets(Composite main) {
		if (hasExactlyOneTemplateWithVariables()) {
			Label seperator = new Label(main, SWT.SEPARATOR | SWT.HORIZONTAL);
			seperator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			parameterComposite = new ParameterComposite(main, SWT.NONE, templates[0], this);
			parameterComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		} else if (hasMoreThenOneTempalte()) {
			Label seperator = new Label(main, SWT.SEPARATOR | SWT.HORIZONTAL);
			seperator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			Label templateLabel = new Label(main, SWT.NONE);
			templateLabel.setText(Messages.NewFileWizardPrimaryPage_template_label);
			templateLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
			templateCombo = new ComboViewer(main);
			templateCombo.setLabelProvider(labelProvider);
			templateCombo.setContentProvider(new ArrayContentProvider());
			templateCombo.setInput(templates);
			templateCombo.setSelection(new StructuredSelection(templates[0]));
			templateCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			templateCombo.getCombo().setToolTipText(getSelectedTemplate().getDescription());
			templateCombo.addSelectionChangedListener(e -> {
				templateCombo.getCombo().setToolTipText(getSelectedTemplate().getDescription());
				validate();
				getContainer().updateButtons();
			});
		}
	}

	private boolean hasExactlyOneTemplateWithVariables() {
		return hasExactlyOneTemplate() && templates[0].variables.size() > 0;
	}

	private boolean hasExactlyOneTemplate() {
		return templates.length == 1;
	}

	private boolean hasMoreThenOneTempalte() {
		return templates.length > 1;
	}

	/**
	 * @since 2.25
	 */
	protected void validateInitial() {
		setStatus(null);
		IContainer folder = getFolder();
		if (folder == null || !folder.exists()) {
			setStatus(new Status(IStatus.ERROR, "NewFileWizard", Messages.NewFileWizardPrimaryPage_unexistint_folder_pre //$NON-NLS-1$
					+ folderText.getText() + Messages.NewFileWizardPrimaryPage_unexistent_folder_post));
			return;
		}
		if (parameterComposite != null) {
			parameterComposite.validate();
		}
		setPageComplete(false);
	}

	/**
	 * @since 2.25
	 */
	protected void validate() {
		setStatus(null);
		IContainer folder = getFolder();
		if (folder == null || !folder.exists()) {
			setStatus(new Status(IStatus.ERROR, "NewFileWizard", Messages.NewFileWizardPrimaryPage_unexistint_folder_pre //$NON-NLS-1$
					+ folderText.getText() + Messages.NewFileWizardPrimaryPage_unexistent_folder_post));
			return;
		}
		if ("".equals(fileText.getText().trim())) { //$NON-NLS-1$
			setStatus(new Status(IStatus.ERROR, "NewFileWizard", Messages.NewFileWizardPrimaryPage_empty_name)); //$NON-NLS-1$
			return;
		}
		if (parameterComposite != null) {
			parameterComposite.validate();
		}
		if (getErrorMessage() == null) {
			AbstractFileTemplate template = getSelectedTemplate();
			template.setTemplateInfo(getFileInfo());
			PathCollector fileCollector = new PathCollector();
			template.generateFiles(fileCollector);
			for (CharSequence path : fileCollector.getResult()) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path.toString()));
				if (file.exists()) {
					setStatus(new Status(IStatus.ERROR, "NewFileWizard", Messages.NewFileWizardPrimaryPage_file_already_exist_pre + path //$NON-NLS-1$
							+ Messages.NewFileWizardPrimaryPage_file_already_exist_post));
					return;
				}
			}
		}
	}

	/**
	 * @since 2.25
	 */
	protected IContainer getFolder() {
		return getFolder(folderText.getText());
	}

	/**
	 * @since 2.25
	 */
	protected IContainer getFolder(String folderText) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/" + folderText)); //$NON-NLS-1$
		} catch (IllegalArgumentException e) {
			try {
				return ResourcesPlugin.getWorkspace().getRoot().getProject(folderText);
			} catch (IllegalArgumentException e1) {
				return null;
			}
		}
	}

	@Override
	public void setStatus(IStatus status) {
		if (status == null || status.getSeverity() == IStatus.OK) {
			setErrorMessage(null);
			setMessage(null);
			setPageComplete(true);
		} else if (status.getSeverity() == IStatus.ERROR) {
			setErrorMessage(status.getMessage());
			setPageComplete(false);
		} else if (status.getSeverity() == IStatus.WARNING) {
			setErrorMessage(null);
			setMessage(status.getMessage(), IMessageProvider.WARNING);
			setPageComplete(true);
		} else {
			setErrorMessage(null);
			setMessage(status.getMessage(), IMessageProvider.INFORMATION);
			setPageComplete(true);
		}
	}

	public TemplateFileInfo getFileInfo() {
		return new TemplateFileInfo(getLocation(), getFileName(), getSelectedTemplate());
	}

	public String getLocation() {
		return folderText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}

	public AbstractFileTemplate getSelectedTemplate() {
		if (templates.length == 1) {
			return templates[0];
		}
		ISelection selection = templateCombo.getSelection();
		if (selection instanceof IStructuredSelection) {
			return (AbstractFileTemplate) ((IStructuredSelection) selection).getFirstElement();
		}
		return null;
	}

	private final class PathCollector implements IFileGenerator {
		private List<CharSequence> result = new ArrayList<>();

		@Override
		public void generate(CharSequence path, CharSequence content) {
			result.add(path);
		}

		public List<CharSequence> getResult() {
			return result;
		}
	}

}
