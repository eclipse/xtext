/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.xtext.resource.IResourceDescription;

/**
 * <p>
 * This event is used to indicate that there were changes but it was not possible to determine what kind of changes had
 * been done. This event does not contain any deltas.
 * </p>
 * 
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.5
 */
public class CoarseGrainedChangeEvent extends ResourceDescriptionChangeEvent implements
		IResourceDescription.CoarseGrainedEvent {

	public CoarseGrainedChangeEvent() {
		super(Collections.<IResourceDescription.Delta> emptyList());
	}

}
