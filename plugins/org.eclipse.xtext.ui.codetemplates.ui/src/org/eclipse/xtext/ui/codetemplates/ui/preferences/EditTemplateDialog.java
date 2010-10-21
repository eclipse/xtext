package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ui.codetemplates.ui.internal.CodetemplatesActivator;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.ISyntheticResourceProvider;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.PartialModelEditor;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.SourceViewerHandle;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class EditTemplateDialog extends StatusDialog implements IEditTemplateDialog {

	private Template fTemplate;

	private Text fNameText;
	private Text fDescriptionText;
	private Combo fContextCombo;
	private SourceViewer fPatternEditor;
	private PartialModelEditor partialModelEditor;
	private Button fInsertVariableButton;
	private Button fAutoInsertCheckbox;
	private boolean fIsNameModifiable;

	private Map<String, TextViewerAction> fGlobalActions= Maps.newHashMapWithExpectedSize(10);
	private List<String> fSelectionActions = Lists.newArrayListWithExpectedSize(3);
	private String[][] fContextTypes;

	private ContextTypeRegistry fContextTypeRegistry;

	private OperationHistoryListener operationHistoryListener;

	private final String languageName;

	private final TemplatesLanguageConfiguration configuration;

	private final ISyntheticResourceProvider resourceProvider;

	public EditTemplateDialog(Shell parent, Template template, boolean edit, boolean isNameModifiable, 
			ContextTypeRegistry registry, TemplatesLanguageConfiguration configuration, 
			ISyntheticResourceProvider resourceProvider, String languageName) {
		super(parent);
		this.configuration = configuration;
		this.resourceProvider = resourceProvider;
		this.languageName = languageName;

		String title= edit
			? TemplateDialogMessages.EditTemplateDialog_title_edit
			: TemplateDialogMessages.EditTemplateDialog_title_new;
		setTitle(title);

		this.fTemplate= template;
		fIsNameModifiable= isNameModifiable;

		List<String[]> contexts= Lists.newArrayList();
		for (Iterator<TemplateContextType> it= Iterators.filter(registry.contextTypes(), TemplateContextType.class); it.hasNext();) {
			TemplateContextType type= it.next();
			contexts.add(new String[] { type.getId(), type.getName() });
		}
		fContextTypes= contexts.toArray(new String[contexts.size()][]);
		fContextTypeRegistry= registry;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void create() {
		super.create();
		getButton(IDialogConstants.OK_ID).setEnabled(getStatus().isOK());
	}

	@Override
	protected Control createDialogArea(Composite ancestor) {
		Composite parent= new Composite(ancestor, SWT.NONE);
		GridLayout layout= new GridLayout();
		layout.numColumns= 2;
		layout.marginHeight= convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth= convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing= convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing= convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);

		parent.setLayout(layout);
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));

		ModifyListener listener= new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				doTextWidgetChanged(e.widget);
			}
		};

		if (fIsNameModifiable) {
			createLabel(parent, TemplateDialogMessages.EditTemplateDialog_name);

			Composite composite= new Composite(parent, SWT.NONE);
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			layout= new GridLayout();
			layout.numColumns= 4;
			layout.marginWidth= 0;
			layout.marginHeight= 0;
			composite.setLayout(layout);

			fNameText= createText(composite);

			createLabel(composite, TemplateDialogMessages.EditTemplateDialog_context);
			fContextCombo= new Combo(composite, SWT.READ_ONLY);
			fContextCombo.setVisibleItemCount(30); // default

			for (int i= 0; i < fContextTypes.length; i++) {
				fContextCombo.add(fContextTypes[i][1]);
			}

			fContextCombo.addModifyListener(listener);

			fAutoInsertCheckbox= createCheckbox(composite, TemplateDialogMessages.EditTemplateDialog_autoinsert);
			fAutoInsertCheckbox.setSelection(fTemplate.isAutoInsertable());
		}

		createLabel(parent, TemplateDialogMessages.EditTemplateDialog_description);

		int descFlags= fIsNameModifiable ? SWT.BORDER : SWT.BORDER | SWT.READ_ONLY;
		fDescriptionText= new Text(parent, descFlags );
		fDescriptionText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		fDescriptionText.addModifyListener(listener);

		Label patternLabel= createLabel(parent, TemplateDialogMessages.EditTemplateDialog_pattern);
		patternLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		fPatternEditor= createEditor(parent);

		Label filler= new Label(parent, SWT.NONE);
		filler.setLayoutData(new GridData());

		Composite composite= new Composite(parent, SWT.NONE);
		layout= new GridLayout();
		layout.marginWidth= 0;
		layout.marginHeight= 0;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData());

		fInsertVariableButton= new Button(composite, SWT.NONE);
		fInsertVariableButton.setLayoutData(getButtonGridData());
		fInsertVariableButton.setText(TemplateDialogMessages.EditTemplateDialog_insert_variable);
		fInsertVariableButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				fPatternEditor.getTextWidget().setFocus();
				fPatternEditor.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});

		fDescriptionText.setText(fTemplate.getDescription());
		if (fIsNameModifiable) {
			fNameText.setText(fTemplate.getName());
			fNameText.addModifyListener(listener);
			fContextCombo.select(getIndex(fTemplate.getContextTypeId()));
		} else {
			fPatternEditor.getControl().setFocus();
		}
		initializeActions();

		applyDialogFont(parent);
		return composite;
	}

	protected void doTextWidgetChanged(Widget w) {
		if (w == fNameText || w == fContextCombo) {
			partialModelEditor.updatePrefix(getPrefix());
		}
	}

	protected String getContextName() {
		String result;
		if (fContextCombo != null && !fContextCombo.isDisposed()) {
			result = fContextCombo.getText();
		} else {
			String contextId = fTemplate.getContextTypeId();
			result = fContextTypeRegistry.getContextType(contextId).getName();	
		}
		if (result.startsWith("Keyword "))
			result = result.substring("Keyword ".length());
		return result;
	}

	protected void doSourceChanged(IDocument document) {
		updateAction(ITextEditorActionConstants.UNDO);
	}
	
	protected String getContextId() {
		if (fContextCombo != null && !fContextCombo.isDisposed()) {
			String name= fContextCombo.getText();
			for (int i= 0; i < fContextTypes.length; i++) {
				if (name.equals(fContextTypes[i][1])) {
					return fContextTypes[i][0];
				}
			}
		}
		return fTemplate.getContextTypeId();
	}

	protected Status createErrorStatus(String message, TemplateException e) {
		return new Status(IStatus.ERROR, 
				CodetemplatesActivator.getInstance().getBundle().getSymbolicName(),
				message, e);
	}

	private static GridData getButtonGridData() {
		GridData data= new GridData(GridData.FILL_HORIZONTAL);
		return data;
	}

	private static Label createLabel(Composite parent, String name) {
		Label label= new Label(parent, SWT.NULL);
		label.setText(name);
		label.setLayoutData(new GridData());
		return label;
	}

	private static Button createCheckbox(Composite parent, String name) {
		Button button= new Button(parent, SWT.CHECK);
		button.setText(name);
		button.setLayoutData(new GridData());
		return button;
	}

	private static Text createText(Composite parent) {
		Text text= new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return text;
	}

	private SourceViewer createEditor(Composite parent) {
		SourceViewer viewer= createViewer(parent);
//		Font font= JFaceResources.getFont(PreferenceConstants.EDITOR_TEXT_FONT);
//		viewer.getTextWidget().setFont(font);
//		new JavaSourcePreviewerUpdater(viewer, configuration, store);
		int numberOfLines= viewer.getDocument().getNumberOfLines();
		if (numberOfLines < 7) {
			numberOfLines= 7;
		} else if (numberOfLines > 14) {
			numberOfLines= 14;
		}

		Control control= viewer.getControl();
		GridData data= new GridData(GridData.FILL_BOTH);
		data.widthHint= convertWidthInCharsToPixels(80);
		data.heightHint= convertHeightInCharsToPixels(numberOfLines);
		control.setLayoutData(data);

		viewer.addTextListener(new ITextListener() {
			public void textChanged(TextEvent event) {
				if (event.getDocumentEvent() != null)
					doSourceChanged(event.getDocumentEvent().getDocument());
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateSelectionDependentActions();
			}
		});
		installUndoRedoSupport(viewer);
		return viewer;
	}

	protected void installUndoRedoSupport(SourceViewer viewer) {
		IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(viewer.getDocument());
		final IUndoContext context = undoManager.getUndoContext();
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		operationHistoryListener = new OperationHistoryListener(context, new IUpdate() {
			public void update() {
				updateAction(ITextEditorActionConstants.REDO);
				updateAction(ITextEditorActionConstants.UNDO);
			}
		});
		operationHistory.addOperationHistoryListener(operationHistoryListener);
	}
	
	@Override
	public boolean close() {
		uninstallUndoRedoSupport();
		configuration.getHighlightingHelper().uninstall();
		return super.close();
	}
	
	protected void uninstallUndoRedoSupport() {
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		operationHistory.removeOperationHistoryListener(operationHistoryListener);
		operationHistoryListener = null;
	}
	
	protected SourceViewer createViewer(Composite parent) {
//		XtextSourceViewerConfiguration viewerConfiguration = configuration.sourceViewerConfigurationProvider.get();
////		SourceViewerConfiguration configuration= new SourceViewerConfiguration() {
////			public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
////
////				ContentAssistant assistant= new ContentAssistant();
////				assistant.enableAutoActivation(true);
////				assistant.enableAutoInsert(true);
////				assistant.setContentAssistProcessor(fTemplateProcessor, IDocument.DEFAULT_CONTENT_TYPE);
////				return assistant;
////			}
////		};
//		viewer.configure(viewerConfiguration);
		SourceViewerHandle handle = configuration.getSourceViewerHandleFactory().create(parent, resourceProvider);
		handle.setIssueProcessor(new IValidationIssueProcessor() {
			public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
				IStatus result = Status.OK_STATUS;
				StringBuilder messages = new StringBuilder();
				for(Issue issue: issues) {
					if (issue.getSeverity() == Severity.ERROR) {
						if (messages.length() != 0)
							messages.append('\n');
						messages.append(issue.getMessage());
					}
				}
				if (messages.length() != 0) {
					result = createErrorStatus(messages.toString(), null);
				}
				final IStatus toBeUpdated = result;
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						updateStatus(toBeUpdated);
					}
				});
			}
		});
		partialModelEditor = handle.createPartialEditor(getPrefix(), fTemplate.getPattern(), "");
		configuration.getHighlightingHelper().install(handle.getConfiguration(), handle.getViewer());
		return handle.getViewer();
	}
	
	protected String getPrefix() {
		String contextName = getContextName();
		String name = fTemplate.getName();
		if (fNameText != null && !fNameText.isDisposed()) {
			name = fNameText.getText();
		}
		String prefix = 
			"templates for " + languageName + 
			" '" + name + "'" + " for " + contextName + " >>";
		return prefix;
	}

	private void initializeActions() {
		final List<IHandlerActivation> handlerActivations= Lists.newArrayListWithExpectedSize(3);
		final IHandlerService handlerService= (IHandlerService) PlatformUI.getWorkbench().getAdapter(IHandlerService.class);
		final Expression expression= new ActiveShellExpression(fPatternEditor.getControl().getShell());

		getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
				}
		});

		fPatternEditor.getTextWidget().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
			}
			public void focusGained(FocusEvent e) {
				IAction action= fGlobalActions.get(ITextEditorActionConstants.REDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_REDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.UNDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_UNDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.CONTENT_ASSIST);
				handlerActivations.add(handlerService.activateHandler(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, new ActionHandler(action), expression));
			}
		});

		TextViewerAction action= new TextViewerAction(fPatternEditor, ITextOperationTarget.UNDO);
		action.setText(TemplateDialogMessages.EditTemplateDialog_undo);
		fGlobalActions.put(ITextEditorActionConstants.UNDO, action);

		action= new TextViewerAction(fPatternEditor, ITextOperationTarget.REDO);
		action.setText(TemplateDialogMessages.EditTemplateDialog_redo);
		fGlobalActions.put(ITextEditorActionConstants.REDO, action);

		action= new TextViewerAction(fPatternEditor, ITextOperationTarget.CUT);
		action.setText(TemplateDialogMessages.EditTemplateDialog_cut);
		fGlobalActions.put(ITextEditorActionConstants.CUT, action);

		action= new TextViewerAction(fPatternEditor, ITextOperationTarget.COPY);
		action.setText(TemplateDialogMessages.EditTemplateDialog_copy);
		fGlobalActions.put(ITextEditorActionConstants.COPY, action);

		action= new TextViewerAction(fPatternEditor, ITextOperationTarget.PASTE);
		action.setText(TemplateDialogMessages.EditTemplateDialog_paste);
		fGlobalActions.put(ITextEditorActionConstants.PASTE, action);

		action= new TextViewerAction(fPatternEditor, ITextOperationTarget.SELECT_ALL);
		action.setText(TemplateDialogMessages.EditTemplateDialog_select_all);
		fGlobalActions.put(ITextEditorActionConstants.SELECT_ALL, action);

		action= new TextViewerAction(fPatternEditor, ISourceViewer.CONTENTASSIST_PROPOSALS);
		action.setText(TemplateDialogMessages.EditTemplateDialog_content_assist);
		fGlobalActions.put(ITextEditorActionConstants.CONTENT_ASSIST, action);

		fSelectionActions.add(ITextEditorActionConstants.CUT);
		fSelectionActions.add(ITextEditorActionConstants.COPY);
		fSelectionActions.add(ITextEditorActionConstants.PASTE);

		// create context menu
		MenuManager manager= new MenuManager(null, null);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});

		StyledText text= fPatternEditor.getTextWidget();
		Menu menu= manager.createContextMenu(text);
		text.setMenu(menu);
	}

	private void fillContextMenu(IMenuManager menu) {
		menu.add(new GroupMarker(ITextEditorActionConstants.GROUP_UNDO));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, fGlobalActions.get(ITextEditorActionConstants.UNDO));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, fGlobalActions.get(ITextEditorActionConstants.REDO));

		menu.add(new Separator(ITextEditorActionConstants.GROUP_EDIT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fGlobalActions.get(ITextEditorActionConstants.CUT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fGlobalActions.get(ITextEditorActionConstants.COPY));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fGlobalActions.get(ITextEditorActionConstants.PASTE));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, fGlobalActions.get(ITextEditorActionConstants.SELECT_ALL));

		menu.add(new Separator(ICommonMenuConstants.GROUP_GENERATE));
		menu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE, fGlobalActions.get("ContentAssistProposal")); //$NON-NLS-1$
	}

	protected void updateSelectionDependentActions() {
		Iterator<String> iterator= fSelectionActions.iterator();
		while (iterator.hasNext())
			updateAction(iterator.next());
	}

	protected void updateAction(String actionId) {
		IAction action= fGlobalActions.get(actionId);
		if (action instanceof IUpdate)
			((IUpdate) action).update();
	}

	private int getIndex(String contextid) {
		if (contextid == null)
			return -1;

		for (int i= 0; i < fContextTypes.length; i++) {
			if (contextid.equals(fContextTypes[i][0])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	protected void okPressed() {
		String name= fNameText == null ? fTemplate.getName() : fNameText.getText();
		boolean isAutoInsertable= fAutoInsertCheckbox != null && fAutoInsertCheckbox.getSelection();
		fTemplate= new Template(name, fDescriptionText.getText(), getContextId(), getPattern(), isAutoInsertable);
		super.okPressed();
	}

	public Template getTemplate() {
		return fTemplate;
	}

	protected String getPattern() {
		return partialModelEditor.getEditablePart();
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		String sectionName= getClass().getName() + "_dialogBounds"; //$NON-NLS-1$
		IDialogSettings section= configuration.getDialogSettings().getSection(sectionName);
		if (section == null)
			section= configuration.getDialogSettings().addNewSection(sectionName);
		return section;
	}

}
