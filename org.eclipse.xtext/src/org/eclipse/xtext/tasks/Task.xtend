/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@Accessors
@EqualsHashCode
class Task {
	TaskTag tag;
	String description;
	int lineNumber;
	int offset;

	def String getFullText() {
		tag.name + description
	}

	def int getTotalLength() {
		fullText.length
	}

	def int getTagLength() {
		tag.length
	}
}
