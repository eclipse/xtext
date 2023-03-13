/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.internal.corext.refactoring.ParameterInfo;
import org.eclipse.jdt.internal.ui.refactoring.ChangeParametersControl;
import org.eclipse.jdt.internal.ui.refactoring.IParameterListChangeListener;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * Strongly inspired by JDT's {@link org.eclipse.jdt.internal.ui.refactoring.code.ExtractMethodInputPage}.
 * 
 * @author Jan Koehnlein
 */
@SuppressWarnings("restriction")
public class ExtractMethodUserInputPage extends UserInputWizardPage {

	@Inject
	private EmbeddedEditorFactory editorFactory;
	
	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private ProjectUtil projectUtil;

	private ExtractMethodRefactoring refactoring;

	private Text textField;

	private EmbeddedEditor signaturePreview;

	private EmbeddedEditorModelAccess partialEditor;
	
	private boolean isInitialName = true;

	protected ExtractMethodUserInputPage() {
		super("ExtractMethodInputPage");
	}

	public void setRefactoring(ExtractMethodRefactoring refactoring) {
		this.refactoring = refactoring;
	}

	@Override
	public void createControl(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);
		setControl(result);
		GridLayout layout = new GridLayout(2, false);
		result.setLayout(layout);
		initializeDialogUnits(result);
		createNameField(result);
		createAccessModifierSection(result);
		createParameterControl(result);
		createAdditionalCheckboxes(result);
		createSeparator(result);
		createSignaturePreview(result);
		Dialog.applyDialogFont(result);
	}

	protected void createNameField(Composite result) {
		Label label = new Label(result, SWT.NONE);
		label.setText("Method name:");
		textField = new Text(result, SWT.BORDER);
		textField.setText(refactoring.getMethodName());
		textField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				textModified(getText());
			}
		});
		textField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}

	protected void createAccessModifierSection(Composite result) {
		GridLayout layout;
		Label label = new Label(result, SWT.NONE);
		label.setText("Access modifier:");
		Composite group = new Composite(result, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginWidth = 0;
		group.setLayout(layout);
		String[] labels = new String[] { "public", "protected", "private" };
		JvmVisibility[] data = new JvmVisibility[] { JvmVisibility.PUBLIC, JvmVisibility.PROTECTED,
				JvmVisibility.PRIVATE };
		JvmVisibility visibility = refactoring.getVisibility();
		for (int i = 0; i < labels.length; i++) {
			Button radio = new Button(group, SWT.RADIO);
			radio.setText(labels[i]);
			radio.setData(data[i]);
			if (data[i].equals(visibility))
				radio.setSelection(true);
			radio.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					final JvmVisibility selectedModifier = (JvmVisibility) event.widget.getData();
					visibilityModified(selectedModifier);
					updatePreview();
				}
			});
		}
	}

	protected void createParameterControl(Composite result) {
		if (!refactoring.getParameterInfos().isEmpty()) {
			ChangeParametersControl cp = new ChangeParametersControl(result, SWT.NONE,
					"Parameters", new IParameterListChangeListener() {
						@Override
						public void parameterChanged(ParameterInfo parameter) {
							parameterModified();
						}
	
						@Override
						public void parameterListChanged() {
							parameterModified();
						}
	
						@Override
						public void parameterAdded(ParameterInfo parameter) {
							updatePreview();
						}
					}, ChangeParametersControl.Mode.EXTRACT_METHOD);
			GridData gridData = new GridData(GridData.FILL_BOTH);
			gridData.horizontalSpan = 2;
			cp.setLayoutData(gridData);
			cp.setInput(refactoring.getParameterInfos());
		}
	}

	protected void createAdditionalCheckboxes(Composite result) {
		Button declareReturnTypeButton = new Button(result, SWT.CHECK);
		declareReturnTypeButton.setText("Explicitly declare return type");
		declareReturnTypeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				refactoring.setExplicitlyDeclareReturnType(((Button)e.widget).getSelection());
				updatePreview();
			}
		});
		declareReturnTypeButton.setSelection(refactoring.isExplicitlyDeclareReturnType());
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		declareReturnTypeButton.setLayoutData(layoutData);
	}

	protected void createSeparator(Composite result) {
		Label label = new Label(result, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		label.setLayoutData(layoutData);
	}

	protected void createSignaturePreview(Composite composite) {
		Label previewLabel = new Label(composite, SWT.NONE);
		previewLabel.setText("Method signature preview:");
		GridData gridData = new GridData(SWT.FILL);
		gridData.horizontalSpan = 2;
		previewLabel.setLayoutData(gridData);
		signaturePreview = editorFactory.newEditor(new IEditedResourceProvider() {
			@Override
			public XtextResource createResource() {
				URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(refactoring.getXtendClass()).trimFragment();
				IProject project = projectUtil.getProject(resourceURI);
				ResourceSet resourceSet = resourceSetProvider.get(project);
				return (XtextResource) resourceSet.getResource(resourceURI, true);
			}
		}).readOnly().withParent(composite);
		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalSpan = 2;
		signaturePreview.getViewer().getControl().setLayoutData(gridData2);
		partialEditor = signaturePreview.createPartialEditor(getPartialEditorModelPrefix(),
				refactoring.getMethodSignature(), getPartialEditorModelSuffix(), true);
	}

	protected String getPartialEditorModelPrefix() {
		return "class " + refactoring.getXtendClass().getName() + " {";
	}
	
	protected String getPartialEditorModelSuffix() {
		return "() {} }";
	}

	protected String getText() {
		if (textField == null)
			return null;
		return textField.getText();
	}

	protected void textModified(String text) {
		isInitialName = false;
		refactoring.setMethodName(text);
		RefactoringStatus status = validatePage(true);
		if (!status.hasFatalError()) {
			updatePreview();
		} 
		setPageComplete(status);
	}

	protected void visibilityModified(JvmVisibility visibility) {
		refactoring.setVisibility(visibility);
		updatePreview();
	}
	
	protected void parameterModified() {
		updatePreview();
		RefactoringStatus status = validatePage(false);
		setPageComplete(status);
	}

	protected void updatePreview() {
		if (signaturePreview == null)
			return;
		String signature = refactoring.getMethodSignature();
		partialEditor.updateModel(getPartialEditorModelPrefix(), signature, getPartialEditorModelSuffix());
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			if(isInitialName) 
				setPageComplete(false);
			else 
				setPageComplete(validatePage(true));
			updatePreview();
			textField.setFocus();
		}
		super.setVisible(visible);
	}

	protected RefactoringStatus validatePage(boolean text) {
		RefactoringStatus result = new RefactoringStatus();
		if (text) {
			result.merge(validateMethodName());
			result.merge(validateParameters());
		} else {
			result.merge(validateParameters());
			result.merge(validateMethodName());
		}
		return result;
	}

	protected RefactoringStatus validateMethodName() {
		RefactoringStatus result = new RefactoringStatus();
		String text = getText();
		if (isEmpty(text)) {
			if(!isInitialName)
				result.addFatalError("Provide a method name");
			return result;
		}
		result.merge(refactoring.validateMethodName(text));
		return result;
	}

	protected RefactoringStatus validateParameters() {
		RefactoringStatus result = new RefactoringStatus();
		result.merge(refactoring.validateParameters());
		return result;
	}

}