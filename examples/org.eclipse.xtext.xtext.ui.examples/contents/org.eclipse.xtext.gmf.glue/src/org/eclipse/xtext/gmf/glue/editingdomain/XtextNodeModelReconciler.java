/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.gmf.glue.editingdomain;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.emf.transaction.TransactionalEditingDomainListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Lifecycle;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.xtext.gmf.glue.Activator;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Reconciles the node models of all XtextResources in a TransactionalEditingDomain with semantic changes.
 * 
 * @author koehnlein
 */
public class XtextNodeModelReconciler extends AdapterImpl implements TransactionalEditingDomainListener,
		IOperationHistoryListener {

	private TransactionalEditingDomain editingDomain;

	private ChangeAggregatorAdapter changeAggregator;

	private XtextNodeModelReconciler(TransactionalEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		lifecycle.addTransactionalEditingDomainListener(this);
		changeAggregator = new ChangeAggregatorAdapter();
		editingDomain.getResourceSet().eAdapters().add(changeAggregator);
		CommandStack commandStack = editingDomain.getCommandStack();
		if (commandStack instanceof IWorkspaceCommandStack) {
			IOperationHistory operationHistory = ((IWorkspaceCommandStack) commandStack).getOperationHistory();
			operationHistory.addOperationHistoryListener(this);
		}
		changeAggregator.beginRecording();
	}

	public void editingDomainDisposing(TransactionalEditingDomainEvent event) {
		changeAggregator.endRecording();
		CommandStack commandStack = editingDomain.getCommandStack();
		if (commandStack instanceof IWorkspaceCommandStack) {
			IOperationHistory operationHistory = ((IWorkspaceCommandStack) commandStack).getOperationHistory();
			operationHistory.removeOperationHistoryListener(this);
		}
		editingDomain.getResourceSet().eAdapters().remove(changeAggregator);
		Lifecycle lifecycle = TransactionUtil.getAdapter(editingDomain, Lifecycle.class);
		lifecycle.removeTransactionalEditingDomainListener(XtextNodeModelReconciler.this);
	}

	public void transactionClosed(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public void transactionClosing(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public void transactionInterrupted(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public void transactionStarted(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public void transactionStarting(TransactionalEditingDomainEvent event) {
		// ignore
	}

	public static XtextNodeModelReconciler adapt(TransactionalEditingDomain editingDomain) {
		XtextNodeModelReconciler adapter = (XtextNodeModelReconciler) EcoreUtil.getAdapter(editingDomain
				.getResourceSet().eAdapters(), XtextNodeModelReconciler.class);
		if (adapter == null) {
			adapter = new XtextNodeModelReconciler(editingDomain);
		}
		return adapter;
	}

	public void historyNotification(OperationHistoryEvent event) {
		int eventType = event.getEventType();
		switch (eventType) {
			case OperationHistoryEvent.DONE:
			case OperationHistoryEvent.UNDONE:
			case OperationHistoryEvent.REDONE:
				changeAggregator.endRecording();
				try {
					ICommand updateXtextResourceTextCommand = null;
					for (EObject modificationRoot : changeAggregator.getModificationRoots()) {
						XtextResource xtextResource = (XtextResource) modificationRoot.eResource();
						NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(modificationRoot);
						CompositeNode parserNode = nodeAdapter.getParserNode();
						Serializer serializer = xtextResource.getSerializer();
						String newText = serializer.serialize(modificationRoot);
						ICommand newCommand = UpdateXtextResourceTextCommand.createUpdateCommand(xtextResource,
								parserNode.getOffset(), parserNode.getLength(), newText);
						if (updateXtextResourceTextCommand == null) {
							updateXtextResourceTextCommand = newCommand;
						} else {
							updateXtextResourceTextCommand.compose(newCommand);
						}
					}
					try {
						if (updateXtextResourceTextCommand != null) {
							updateXtextResourceTextCommand.execute(null, null);
						}
					} catch (ExecutionException exc) {
						Activator.logError(exc);
					}
				} finally {
					changeAggregator.beginRecording();
				}
				break;
			default:
				// ignore
		}

	}
}
