/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.copyqualifiedname

import org.eclipse.emf.ecore.EObject

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
interface CopyQualifiedNameService {

	def abstract String getQualifiedName(EObject selectedElement, EObject context)

}
