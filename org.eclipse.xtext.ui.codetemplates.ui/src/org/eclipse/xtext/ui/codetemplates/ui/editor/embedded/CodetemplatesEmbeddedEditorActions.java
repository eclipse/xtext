/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.editor.embedded;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorActions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author cdietrich - Initial contribution and API
 */
public class CodetemplatesEmbeddedEditorActions extends EmbeddedEditorActions {

	public static class Factory extends EmbeddedEditorActions.Factory {

		@Inject(optional = true)
		protected IWorkbench workbench;

		@Override
		protected EmbeddedEditorActions createActions(ISourceViewer viewer) {
			return new CodetemplatesEmbeddedEditorActions(viewer, workbench);
		}

	}

	public CodetemplatesEmbeddedEditorActions(ISourceViewer viewer, IWorkbench workbench) {
		super(viewer, workbench);
	}

	@Override
	protected void createFocusAndDisposeListeners() {
		final List<IHandlerActivation> handlerActivations = Lists.newArrayListWithExpectedSize(3);
		final IHandlerService handlerService = workbench.getAdapter(IHandlerService.class);
		final IContextService contextService = workbench.getAdapter(IContextService.class);
		Shell shell = viewer.getTextWidget().getShell();
		final ActiveShellExpression expression = new ActiveShellExpression(shell);
		AtomicReference<IContextActivation> contextActivationHolder = new AtomicReference<>();

		shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
			}
		});

		viewer.getTextWidget().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				IContextActivation contextActivation = contextActivationHolder.get();
				if (contextActivation != null) {
					contextService.deactivateContext(contextActivation);
				}
				handlerService.deactivateHandlers(handlerActivations);
				handlerActivations.clear();
			}

			@Override
			public void focusGained(FocusEvent e) {
				final IContextActivation contextActivation = contextService.activateContext(EMBEDDED_TEXT_EDITOR_SCOPE, expression);
				contextActivationHolder.set(contextActivation);
				for (final IAction action : allActions.values()) {
					handlerActivations.add(
							handlerService.activateHandler(action.getActionDefinitionId(), new ActionHandler(action), expression, true));
				}
			}

		});
	}

}
