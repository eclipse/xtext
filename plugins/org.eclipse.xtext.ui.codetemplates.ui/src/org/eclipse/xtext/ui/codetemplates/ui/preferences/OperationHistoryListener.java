/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.preferences;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.ui.texteditor.IUpdate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class OperationHistoryListener implements IOperationHistoryListener {
	private final IUndoContext context;
	private final IUpdate update;

	protected OperationHistoryListener(IUndoContext context, IUpdate update) {
		this.context = context;
		this.update = update;
	}

	public void historyNotification(OperationHistoryEvent event) {
		final int type= event.getEventType();
		switch (type) {
			case OperationHistoryEvent.UNDONE:
			case OperationHistoryEvent.REDONE:
			case OperationHistoryEvent.OPERATION_NOT_OK:
			// if this is one of our operations
			if (event.getOperation().hasContext(context)) {
				update.update();
			}		
		}	
	}
}