/*******************************************************************************
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Page of the new project wizard to present a list of templates to the user. The user can select a template and press finish. If the
 * template is configurable the variables can be configured in the following page, the {@link TemplateParameterPage}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class NewProjectWizardTemplateSelectionPage extends WizardPage {

	private static final String PROJECT_TEMPLATE_PROVIDER_EXTENSION_POINT_ID = "org.eclipse.xtext.ui.projectTemplate"; //$NON-NLS-1$
	private static final String PROJECT_TEMPLATE_PROVIDER_ID = "projectTemplateProvider"; //$NON-NLS-1$
	private static final String PROJECT_TEMPLATE_PROVIDER_GRAMMAR_NAME_ATTRIBUTE = "grammarName"; //$NON-NLS-1$
	private static final String PROJECT_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private static final Logger logger = Logger.getLogger(NewProjectWizardTemplateSelectionPage.class);

	private TemplateLabelProvider labelProvider;
	private AbstractProjectTemplate selectedTemplate;
	private String grammarName;

	public NewProjectWizardTemplateSelectionPage(String pageName, String grammarName, TemplateLabelProvider labelProvider) {
		super(pageName);
		this.grammarName = grammarName;
		this.labelProvider = labelProvider;
	}

	@Override
	public void createControl(Composite parent) {
		Composite main = new Composite(parent, SWT.NONE);
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		main.setLayout(new GridLayout(1, false));

		Label availableTemplatesLabel = new Label(main, SWT.NONE);
		availableTemplatesLabel.setText(Messages.NewProjectWizardTemplateSelectionPage_available_templates);
		availableTemplatesLabel.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false));

		SashForm sash = new SashForm(main, SWT.HORIZONTAL);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.widthHint = 400;
		sash.setLayoutData(data);

		TableViewer templateTable = new TableViewer(sash, SWT.BORDER);
		templateTable.setContentProvider(new ArrayContentProvider());
		templateTable.setLabelProvider(labelProvider);
		AbstractProjectTemplate[] templates = loadTemplatesFromExtensionPoint();
		templateTable.setInput(templates);

		FormText text = new FormText(sash, SWT.BORDER);
		text.setText("", false, false); //$NON-NLS-1$
		text.setBackground(templateTable.getTable().getBackground());

		// register images
		for (AbstractProjectTemplate template : templates) {
			for (Pair<String, Image> image : template.getImages()) {
				text.setImage(image.getKey(), image.getValue());
			}
		}

		templateTable.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					Object element = structuredSelection.getFirstElement();
					if (element instanceof AbstractProjectTemplate) {
						selectedTemplate = (AbstractProjectTemplate) element;
						setPageComplete(true);
						String content = "<form>" + selectedTemplate.getDescription() + "</form>"; //$NON-NLS-1$ //$NON-NLS-2$
						try {
							text.setText(content, true, true);
						} catch (Exception e) {
							text.setText(e.getMessage(), false, false);
						}
					} else {
						selectedTemplate = null;
						text.setText("", false, false); //$NON-NLS-1$
						setPageComplete(false);
					}
				} else {
					selectedTemplate = null;
					text.setText("", false, false); //$NON-NLS-1$
					setPageComplete(false);
				}
			}
		});

		templateTable.setSelection(new StructuredSelection(templateTable.getElementAt(0)));

		setControl(main);
	}

	private AbstractProjectTemplate[] loadTemplatesFromExtensionPoint() {
		List<AbstractProjectTemplate> result = new ArrayList<>();
		for (IConfigurationElement element : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(PROJECT_TEMPLATE_PROVIDER_EXTENSION_POINT_ID)) {
			if (PROJECT_TEMPLATE_PROVIDER_ID.equals(element.getName())
					&& grammarName.equals(element.getAttribute(PROJECT_TEMPLATE_PROVIDER_GRAMMAR_NAME_ATTRIBUTE))) {
				try {
					IProjectTemplateProvider provider = (IProjectTemplateProvider) element
							.createExecutableExtension(PROJECT_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE);
					result.addAll(Arrays.asList(provider.getProjectTemplates()));
				} catch (CoreException e) {
					logger.error("Can not instantiate '" + element.getAttribute(PROJECT_TEMPLATE_PROVIDER_GRAMMAR_CLASS_ATTRIBUTE) + "'", //$NON-NLS-1$ //$NON-NLS-2$
							e);
				}
			}
		}
		return result.toArray(new AbstractProjectTemplate[0]);
	}

	public AbstractProjectTemplate getSelectedTemplate() {
		return selectedTemplate;
	}

}
