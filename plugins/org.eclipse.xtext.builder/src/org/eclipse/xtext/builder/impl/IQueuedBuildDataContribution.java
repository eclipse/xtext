/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.builder.impl.javasupport.JdtQueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.annotations.Beta;

/**
 * Allows to extend the {@link QueuedBuildData} with changes that are not produced by Xtext languages.
 * 
 * @see JdtQueuedBuildData
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public interface IQueuedBuildDataContribution {

	/**
	 * Resets internal state of the contribution.
	 */
	void reset();

	/**
	 * A to-be-queued delta is passed to the known contributors to establish a communication channel between clients of
	 * the {@link QueuedBuildData} and a potentially available special treatment of a certain kind of delta.
	 * 
	 * @return <code>false</code> if the delta was not processed, <code>true</code> if this contribution handled the
	 *         given delta.
	 * 
	 * @see UnconfirmedStructuralChangesDelta
	 */
	boolean queueChange(IResourceDescription.Delta delta);

	/**
	 * Decide based on the given project, the known internal state and the existing list of deltas whether a rebuilt is
	 * required. The collection of deltas may be modified by the contribution.
	 * 
	 * @return <code>true</code> if the project has to be rebuilt according to the known state.
	 */
	boolean needsRebuild(IProject project, Collection<Delta> deltas);

}
