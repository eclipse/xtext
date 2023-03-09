/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import com.google.inject.ImplementedBy;

/**
 * Extends the {@link IScopeProvider} by a means to collect
 * scope information in a batch mode. It allows to {@link #newSession(Resource) open} 
 * a new {@link IFeatureScopeSession session} which maintains 
 * all the necessary scoping information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO More JavaDoc, remove ImplementedBy annotation
 */
@ImplementedBy(XbaseBatchScopeProvider.class)
public interface IBatchScopeProvider extends IScopeProvider {

	/**
	 * Returns a preconfigured feature scope session that is aware of
	 * implicitly imported types such as {@link CollectionLiterals}.
	 * @param context the resource that contains the to-be-linked instances.
	 * @return a new feature scope session. Never <code>null</code>.
	 */
	IFeatureScopeSession newSession(Resource context);
	
	/**
	 * Returns <code>true</code> if a proxy at the given reference should be 
	 * resolved by means of a batch run.
	 */
	boolean isBatchScopeable(EReference reference);
	
	
	boolean isConstructorCallScope(EReference reference);
	boolean isFeatureCallScope(EReference reference);
	
}
