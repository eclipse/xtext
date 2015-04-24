/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork

class XtextWorkerThread extends Thread {
	
	val CancelableUnitOfWork<?, IXtextWebDocument> work
	
	@Accessors
	IXtextWebDocument document
	
	@Accessors
	CancelIndicator cancelIndicator
	
	@Accessors(PUBLIC_SETTER)
	()=>void whenFinished
	
	new(CancelableUnitOfWork<?, IXtextWebDocument> work) {
		super("Xtext Worker Thread")
		this.work = work
	}
	
	override run() {
		try {
			work.exec(document, cancelIndicator)
		} finally {
			if (whenFinished != null)
				whenFinished.apply()
		}
	}
	
}