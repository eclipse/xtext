/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring

import com.google.common.collect.LinkedHashMultimap
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
		val change2strategies = LinkedHashMultimap.create
		for (change: context.changes) {
			for (strategy: strategies) {
				if (strategy.canHandle(change))
					change2strategies.put(change, strategy)
			}
		}
		val change2resource = newHashMap 
		for (change : change2strategies.keySet) {
			val primaryStrategy = change2strategies.get(change).head
			try {
				val resource = primaryStrategy.loadAndWatchResource(change, context)
				change2resource.put(change, resource)
			} catch (Throwable t) {
				context.issueAcceptor.add(ERROR, 'Error loading resource ' + change?.fromURI?.toString, t)
				LOG.error(t)
			}
		}
		for (change : change2strategies.keySet) {
			var changeApplied = false
			val resource = change2resource.get(change)
			for (strategy: change2strategies.get(change)) {
				if (!changeApplied) {
					try {
						strategy.applyChange(change, resource, context)
						changeApplied = true
					} catch (Throwable t) {
						context.issueAcceptor.add(ERROR, 'Error applying relocation change to ' + change?.fromURI?.toString, t)
						LOG.error(t)
					}
				}
				if (changeApplied) {
					try {
						strategy.applySideEffects(change, resource, context)
					} catch (Throwable t) {
						context.issueAcceptor.add(ERROR, 'Error applying side effect to ' + change?.fromURI?.toString, t)
						LOG.error(t)
					}
				}
			}
		}
	}
}
