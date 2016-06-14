/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.execution

import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.execution.TraceBasedApplicationConfigurationProducer

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendApplicationConfigurationProducer extends TraceBasedApplicationConfigurationProducer {

	new() {
		super(XtendLanguage.INSTANCE)
	}

}