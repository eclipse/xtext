/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng.debug

import org.eclipse.core.resources.IResourceChangeEvent

import static org.eclipse.core.resources.IResourceChangeEvent.*
import static org.eclipse.core.resources.IncrementalProjectBuilder.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class ResourceChangeEventToString implements (IResourceChangeEvent)=>String {

	def private String getBuildKindString(IResourceChangeEvent event) {
		switch kind:event.buildKind {
			case AUTO_BUILD: "AUTO_BUILD"
			case FULL_BUILD: "FULL_BUILD"
			case INCREMENTAL_BUILD: "INCREMENTAL_BUILD"
			case CLEAN_BUILD: "CLEAN_BUILD"
			default: kind.toString
		}
	}

	def private String getTypeString(IResourceChangeEvent event) {
		switch kind:event.type {
			case POST_BUILD: "POST_BUILD"
			case POST_CHANGE: "POST_CHANGE"
			case PRE_BUILD: "PRE_BUILD"
			case PRE_CLOSE: "PRE_CLOSE"
			case PRE_DELETE: "PRE_DELETE"
			case PRE_REFRESH: "PRE_REFRESH"
			default: kind.toString
		}
	}

	override apply(IResourceChangeEvent p) {
		p.class.simpleName + " buildKind=" + p.buildKindString + " type=" + p.typeString + " {\n delta=" +
			new ResourceDeltaToString().apply(p.delta).replace("\n", "\n  ") + "\n}"
	}

}