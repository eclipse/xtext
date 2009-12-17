package org.eclipse.xtext.gmf.glue.editingdomain;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.xtext.resource.XtextResource;

public class UpdateXtextResourceTextCommand {

	public static Command createEMFCommand(final XtextResource xtextResource,
			final int offset, final int length, final String newText) {
		final TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(xtextResource);
		if (editingDomain == null) {
			return null;
		}
		ResourceSet resourceSet = editingDomain.getResourceSet();
		final ChangeAggregatorAdapter changeAggregator = (ChangeAggregatorAdapter) EcoreUtil
				.getAdapter(resourceSet.eAdapters(),
						ChangeAggregatorAdapter.class);
		return new RecordingCommand(editingDomain, "update xtext resource") {
			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				try {
					if (changeAggregator != null) {
						changeAggregator.setSuspended(true);
					}
					xtextResource.update(offset, length, newText);
					xtextResource.setModified(true);
				} finally {
					if (changeAggregator != null) {
						changeAggregator.setSuspended(false);
					}
				}

			}
		};
	}

	public static ICommand createICommand(final XtextResource xtextResource,
			final int offset, final int length, final String newText) {
		final TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(xtextResource);
		if (editingDomain == null) {
			return null;
		}
		ResourceSet resourceSet = editingDomain.getResourceSet();
		final ChangeAggregatorAdapter changeAggregator = (ChangeAggregatorAdapter) EcoreUtil
				.getAdapter(resourceSet.eAdapters(),
						ChangeAggregatorAdapter.class);
		return new AbstractTransactionalCommand(editingDomain,
				"update xtext resource", null) {
			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					if (changeAggregator != null) {
						changeAggregator.setSuspended(true);
					}
					xtextResource.update(offset, length, newText);
					xtextResource.setModified(true);
					return CommandResult.newOKCommandResult();
				} catch (Exception exc) {
					return CommandResult.newErrorCommandResult(exc);
				} finally {
					if (changeAggregator != null) {
						changeAggregator.setSuspended(false);
					}
				}
			}
		};
	}

}
