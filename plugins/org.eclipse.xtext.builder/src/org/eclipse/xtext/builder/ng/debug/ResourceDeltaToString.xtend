/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.ng.debug

import org.eclipse.core.resources.IResourceDelta
import org.eclipse.core.runtime.IPath

import static org.eclipse.core.resources.IResourceDelta.*
import org.eclipse.core.runtime.Path

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class ResourceDeltaToString implements (IResourceDelta)=>String {

	private def String getKindString(IResourceDelta delta) {
		switch kind: delta.kind {
			case ADDED: "ADDED"
			case REMOVED: "REMOVED"
			case CHANGED: "CHANGED"
			case ADDED_PHANTOM: "ADDED_PHANTOM"
			case REMOVED_PHANTOM: "REMOVED_PHANTOM"
			default: kind.toString
		}
	}

	override apply(IResourceDelta delta) {
		delta.class.simpleName + " " + apply(new Path("/"), delta)
	}

	def private String apply(IPath parent, IResourceDelta delta) {
		val children = delta.affectedChildren
		if (children.size == 1)
			return apply(parent, children.head)
		val kind = delta.kindString
		val type = delta.resource?.class.simpleName
		val name = delta.fullPath.makeRelativeTo(parent).toString
		val body = '''«kind» «type» «name»'''
		if (children.isEmpty)
			return body
		return body + " {\n  " + children.map[apply(delta.fullPath, it)].join("\n").replace("\n", "\n  ") + "\n}"
	}
}