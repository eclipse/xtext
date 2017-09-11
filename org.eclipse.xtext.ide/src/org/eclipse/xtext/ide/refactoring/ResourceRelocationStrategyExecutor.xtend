/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import java.util.List
import org.apache.log4j.Logger

import static org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity.*

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ResourceRelocationStrategyExecutor {

	static val LOG = Logger.getLogger(ResourceRelocationStrategyExecutor)

	def executeParticipants(List<? extends IResourceRelocationStrategy> strategies, ResourceRelocationContext context) {
		if(context.changeType === ResourceRelocationContext.ChangeType.COPY)
			context.changeSerializer.updateRelatedFiles = false
		strategies.forEach [
			try {
				loadAndWatchResources(context)			
			} catch (Throwable t) {
				context.issueAcceptor.add(ERROR, 'Error loading resources', t)
				LOG.error(t)
			}
		]
		strategies.forEach [
			try {
				applyChange(context)			
			} catch (Throwable t) {
				context.issueAcceptor.add(ERROR, 'Error applying resource changes', t)
				LOG.error(t)
			}
		]
		strategies.forEach [
			try {
				applySideEffects(context)			
			} catch (Throwable t) {
				context.issueAcceptor.add(ERROR, 'Error applying side effects', t)
				LOG.error(t)
			}
		]
	}
}
