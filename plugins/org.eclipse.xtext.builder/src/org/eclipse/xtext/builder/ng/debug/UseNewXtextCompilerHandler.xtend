/** 
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.swt.widgets.Event
import org.eclipse.swt.widgets.ToolItem
import org.eclipse.xtext.builder.ng.BuilderSwitch

/** 
 * @author Jan Koehnlein - Initial contribution and API
 */
class UseNewXtextCompilerHandler extends AbstractHandler {
	
	override Object execute(ExecutionEvent event) throws ExecutionException {
		BuilderSwitch.setUseNewCompiler(event.isSelected)
		null
	}

	def private static isSelected(ExecutionEvent event) {
		(((event.trigger) as Event).widget as ToolItem).selection
	}
}
