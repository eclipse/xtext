/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.tasks

import org.eclipse.emf.ecore.resource.Resource

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class DefaultTaskTagProvider implements ITaskTagProvider {

	override getTaskTags(Resource resouce) {
		new TaskTags => [
			caseSensitive = true
			taskTags += #[
				new TaskTag => [
					name = "TODO"
					priority = Priority.NORMAL
				],
				new TaskTag => [
					name = "FIXME"
					priority = Priority.HIGH
				],
				new TaskTag => [
					name = "XXX"
					priority = Priority.NORMAL
				]
			]
		]
	}

}
