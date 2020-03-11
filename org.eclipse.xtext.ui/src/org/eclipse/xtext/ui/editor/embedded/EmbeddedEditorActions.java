/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.IAbstractTextEditorHelpContextIds;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.ResourceAction;
import org.eclipse.ui.texteditor.TextNavigationAction;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditorActions {

	public static final String EMBEDDED_TEXT_EDITOR_SCOPE = "org.eclipse.xtext.ui.embeddedTextEditorScope";

	public static class Factory {
		
		@Inject(optional=true)
		protected IWorkbench workbench;
		
		protected EmbeddedEditorActions createActions(ISourceViewer viewer) {
			return new EmbeddedEditorActions(viewer, workbench);
		}
		
	}
	
	protected static final ActionDefinitionToStyledTextAction[] ACTION_MAP= new ActionDefinitionToStyledTextAction[] {
		// navigation
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.LINE_UP, ST.LINE_UP),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.LINE_DOWN, ST.LINE_DOWN),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.LINE_START, ST.LINE_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.LINE_END, ST.LINE_END),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.COLUMN_PREVIOUS, ST.COLUMN_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.COLUMN_NEXT, ST.COLUMN_NEXT),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.PAGE_UP, ST.PAGE_UP),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.PAGE_DOWN, ST.PAGE_DOWN),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.WORD_PREVIOUS, ST.WORD_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.WORD_NEXT, ST.WORD_NEXT),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.TEXT_START, ST.TEXT_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.TEXT_END, ST.TEXT_END),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.WINDOW_START, ST.WINDOW_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.WINDOW_END, ST.WINDOW_END),
		// selection
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_LINE_UP, ST.SELECT_LINE_UP),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_LINE_DOWN, ST.SELECT_LINE_DOWN),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_LINE_START, ST.SELECT_LINE_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_LINE_END, ST.SELECT_LINE_END),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_COLUMN_PREVIOUS, ST.SELECT_COLUMN_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_COLUMN_NEXT, ST.SELECT_COLUMN_NEXT),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_PAGE_UP, ST.SELECT_PAGE_UP),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_PAGE_DOWN, ST.SELECT_PAGE_DOWN),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_WORD_PREVIOUS, ST.SELECT_WORD_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_WORD_NEXT,  ST.SELECT_WORD_NEXT),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_TEXT_START, ST.SELECT_TEXT_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_TEXT_END, ST.SELECT_TEXT_END),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_WINDOW_START, ST.SELECT_WINDOW_START),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.SELECT_WINDOW_END, ST.SELECT_WINDOW_END),
		// modification
//		new IdMapEntry(IWorkbenchCommandConstants.EDIT_CUT, ST.CUT),
//		new IdMapEntry(IWorkbenchCommandConstants.EDIT_COPY, ST.COPY),
//		new IdMapEntry(IWorkbenchCommandConstants.EDIT_PASTE, ST.PASTE),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.DELETE_PREVIOUS, ST.DELETE_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.DELETE_NEXT, ST.DELETE_NEXT),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.DELETE_PREVIOUS_WORD, ST.DELETE_WORD_PREVIOUS),
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.DELETE_NEXT_WORD, ST.DELETE_WORD_NEXT),
		// miscellaneous
		new ActionDefinitionToStyledTextAction(ITextEditorActionDefinitionIds.TOGGLE_OVERWRITE, ST.TOGGLE_OVERWRITE)
	};
	
	protected final Map<String, IAction> allActions = Maps.newHashMap();
	
	protected final ISourceViewer viewer;
	protected final IWorkbench workbench;
	
	public EmbeddedEditorActions(ISourceViewer viewer, IWorkbench workbench) {
		this.viewer = viewer;
		this.workbench = workbench;
		initialize();
	}
	
	protected void initialize() {
		createFocusAndDisposeListeners();

		createActions();

		// create context menu
		MenuManager manager = new MenuManager(null, null);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			@Override
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});

		StyledText text = viewer.getTextWidget();
		Menu menu = manager.createContextMenu(text);
		text.setMenu(menu);
		
		List<ActionActivationCode> activationCodes = Lists.newArrayList();
		setActionActivationCode(activationCodes, ITextEditorActionConstants.SHIFT_RIGHT_TAB,'\t', -1, SWT.NONE);
		setActionActivationCode(activationCodes, ITextEditorActionConstants.SHIFT_LEFT, '\t', -1, SWT.SHIFT);
		viewer.getTextWidget().addVerifyKeyListener(new ActivationCodeTrigger(allActions, activationCodes));
	}

	protected void createFocusAndDisposeListeners() {
		final List<IHandlerActivation> handlerActivations = Lists.newArrayListWithExpectedSize(3);
		final IHandlerService handlerService = workbench.getAdapter(IHandlerService.class);
		final IContextService contextService = workbench.getAdapter(IContextService.class);
		Shell shell = viewer.getTextWidget().getShell();
		final ActiveShellExpression expression = new ActiveShellExpression(shell);
		final IContextActivation contextActivation = contextService.activateContext(EMBEDDED_TEXT_EDITOR_SCOPE, expression);
		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
				contextService.deactivateContext(contextActivation);
			}
		});

		viewer.getTextWidget().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
				handlerActivations.clear();
			}

			@Override
			public void focusGained(FocusEvent e) {
				for(final IAction action: allActions.values()) {
					handlerActivations.add(handlerService.activateHandler(
							action.getActionDefinitionId(), new ActionHandler(action), expression, true));
				}
			}
			
		});
	}
	
	protected void fillContextMenu(IMenuManager menu) {
		menu.add(new GroupMarker(ITextEditorActionConstants.GROUP_UNDO));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, allActions.get(ITextEditorActionConstants.UNDO));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, allActions.get(ITextEditorActionConstants.REDO));

		menu.add(new Separator(ITextEditorActionConstants.GROUP_EDIT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.CUT));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.COPY));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.PASTE));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, allActions.get(ITextEditorActionConstants.SELECT_ALL));

		menu.add(new Separator(ITextEditorActionConstants.GROUP_GENERATE));
		menu.appendToGroup(ITextEditorActionConstants.GROUP_GENERATE, allActions.get("ContentAssistProposal")); //$NON-NLS-1$
	}
	
	protected void setActionActivationCode(List<ActionActivationCode> activationCodes, String actionID, char activationCharacter, int activationKeyCode, int activationStateMask) {
		ActionActivationCode found= findActionActivationCode(activationCodes, actionID);
		if (found == null) {
			found= new ActionActivationCode(actionID);
			activationCodes.add(found);
		}
		found.fCharacter= activationCharacter;
		found.fKeyCode= activationKeyCode;
		found.fStateMask= activationStateMask;
	}
	
	protected ActionActivationCode findActionActivationCode(List<ActionActivationCode> activationCodes, String actionID) {
		int size= activationCodes.size();
		for (int i= 0; i < size; i++) {
			ActionActivationCode code= activationCodes.get(i);
			if (actionID.equals(code.fActionId))
				return code;
		}
		return null;
	}

	protected void createActions() {
		
		StyledText textWidget= viewer.getTextWidget();
		for (int i= 0; i < ACTION_MAP.length; i++) {
			ActionDefinitionToStyledTextAction entry= ACTION_MAP[i];
			IAction action= new TextNavigationAction(textWidget, entry.getAction());
			action.setActionDefinitionId(entry.getActionId());
			setAction(entry.getActionId(), action);
		}
		
		ResourceAction action;

		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Undo.", viewer, ITextOperationTarget.UNDO); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.UNDO_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_UNDO);
		setAction(ITextEditorActionConstants.UNDO, action);
		
		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Redo.", viewer, ITextOperationTarget.REDO); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.REDO_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_REDO);
		setAction(ITextEditorActionConstants.REDO, action);
		
		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Cut.", viewer, ITextOperationTarget.CUT); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.CUT_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_CUT);
		setAction(ITextEditorActionConstants.CUT, action);

		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Copy.", viewer, ITextOperationTarget.COPY, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.COPY_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
		setAction(ITextEditorActionConstants.COPY, action);

		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Paste.", viewer, ITextOperationTarget.PASTE); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.PASTE_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_PASTE);
		setAction(ITextEditorActionConstants.PASTE, action);

		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.Delete.", viewer, ITextOperationTarget.DELETE); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.DELETE_ACTION);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
		setAction(ITextEditorActionConstants.DELETE, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.DeleteLine.", viewer, TextViewerDeleteLineAction.WHOLE, false); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.DELETE_LINE_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.DELETE_LINE);
		setAction(ITextEditorActionConstants.DELETE_LINE, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.CutLine.", viewer, TextViewerDeleteLineAction.WHOLE, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.CUT_LINE_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CUT_LINE);
		setAction(ITextEditorActionConstants.CUT_LINE, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.DeleteLineToBeginning.", viewer, TextViewerDeleteLineAction.TO_BEGINNING, false); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.DELETE_LINE_TO_BEGINNING_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.DELETE_LINE_TO_BEGINNING);
		setAction(ITextEditorActionConstants.DELETE_LINE_TO_BEGINNING, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.CutLineToBeginning.", viewer, TextViewerDeleteLineAction.TO_BEGINNING, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.CUT_LINE_TO_BEGINNING_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CUT_LINE_TO_BEGINNING);
		setAction(ITextEditorActionConstants.CUT_LINE_TO_BEGINNING, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.DeleteLineToEnd.", viewer, TextViewerDeleteLineAction.TO_END, false); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.DELETE_LINE_TO_END_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.DELETE_LINE_TO_END);
		setAction(ITextEditorActionConstants.DELETE_LINE_TO_END, action);

		action= new TextViewerDeleteLineAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.CutLineToEnd.", viewer, TextViewerDeleteLineAction.TO_END, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.CUT_LINE_TO_END_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CUT_LINE_TO_END);
		setAction(ITextEditorActionConstants.CUT_LINE_TO_END, action);

		action= new TextViewerJoinLinesAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.JoinLines.", viewer, " "); //$NON-NLS-1$ //$NON-NLS-2$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.JOIN_LINES_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.JOIN_LINES);
		setAction(ITextEditorActionConstants.JOIN_LINES, action);

		action= new TextViewerMarkAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.SetMark.", viewer, TextViewerMarkAction.SET_MARK); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.SET_MARK_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.SET_MARK);
		setAction(ITextEditorActionConstants.SET_MARK, action);

		action= new TextViewerMarkAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.ClearMark.", viewer, TextViewerMarkAction.CLEAR_MARK); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.CLEAR_MARK_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CLEAR_MARK);
		setAction(ITextEditorActionConstants.CLEAR_MARK, action);

		action= new TextViewerMarkAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.SwapMark.", viewer, TextViewerMarkAction.SWAP_MARK); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.SWAP_MARK_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.SWAP_MARK);
		setAction(ITextEditorActionConstants.SWAP_MARK, action);

		action= new TextViewerShiftAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.ShiftRight.", viewer, ITextOperationTarget.SHIFT_RIGHT); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.SHIFT_RIGHT_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.SHIFT_RIGHT);
		setAction(ITextEditorActionConstants.SHIFT_RIGHT, action);

		action= new TextViewerShiftAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.ShiftRight.", viewer, ITextOperationTarget.SHIFT_RIGHT) { //$NON-NLS-1$
			@Override
			public void update() {
				updateForTab();
			}
		};
		action.setActionDefinitionId(ITextEditorActionConstants.SHIFT_RIGHT_TAB);
		setAction(ITextEditorActionConstants.SHIFT_RIGHT_TAB, action);

		action= new TextViewerShiftAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.ShiftLeft.", viewer, ITextOperationTarget.SHIFT_LEFT); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.SHIFT_LEFT_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.SHIFT_LEFT);
		setAction(ITextEditorActionConstants.SHIFT_LEFT, action);
		
		action = new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.ContentAssist.", viewer, ISourceViewer.CONTENTASSIST_PROPOSALS);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
		setAction(ITextEditorActionConstants.CONTENT_ASSIST, action);
		
		action = new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.SelectAll.", viewer, ITextOperationTarget.SELECT_ALL, true);
		action.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_SELECT_ALL);
		setAction(ITextEditorActionConstants.SELECT_ALL, action);
		
		action= new TextViewerMoveLinesAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.MoveLinesUp.", viewer, true, false); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.MOVE_LINES_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.MOVE_LINES_UP);
		setAction(ITextEditorActionConstants.MOVE_LINE_UP, action);

		action= new TextViewerMoveLinesAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.MoveLinesDown.", viewer, false, false); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.MOVE_LINES_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.MOVE_LINES_DOWN);
		setAction(ITextEditorActionConstants.MOVE_LINE_DOWN, action);

		action= new TextViewerMoveLinesAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.CopyLineUp.", viewer, true, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.COPY_LINES_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.COPY_LINES_UP);
		setAction(ITextEditorActionConstants.COPY_LINE_UP, action);

		action= new TextViewerMoveLinesAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.CopyLineDown.", viewer, false, true); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.COPY_LINES_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.COPY_LINES_DOWN);
		setAction(ITextEditorActionConstants.COPY_LINE_DOWN, action);
		
		action= new TextViewerOperationAction(EmbeddedEditorMessages.getBundleForConstructedKeys(), "Editor.QuickAssist.", viewer, ISourceViewer.QUICK_ASSIST); //$NON-NLS-1$
		action.setHelpContextId(IAbstractTextEditorHelpContextIds.QUICK_ASSIST_ACTION);
		action.setActionDefinitionId(ITextEditorActionDefinitionIds.QUICK_ASSIST);
		setAction(ITextEditorActionConstants.QUICK_ASSIST, action);
	}
	
	protected void setAction(String actionID, final IAction action) {
		Assert.isNotNull(actionID);
		if (action == null) {
			allActions.remove(actionID);
		} else {
			if (action.getId() == null)
				action.setId(actionID); // make sure the action ID has been set
			allActions.put(actionID, action);
		}
	}

	protected IAction get(String actionId) {
		return allActions.get(actionId);
	}

	protected void updateAllActions() {
		for(IAction action: allActions.values()) {
			update(action);
		}
	}

	protected void updateSelectionDependentActions() {
		updateAllActions();
	}

	protected void updateAction(String actionId) {
		IAction action = get(actionId);
		update(action);
	}

	private void update(IAction action) {
		if (action instanceof IUpdate)
			((IUpdate) action).update();
	}
	
}
