/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import org.eclipse.xtext.resource.XtextResource

/**
 * Interface for accessing a document. Depending on the access type, some methods may not be supported.
 */
interface IXtextWebDocument {
	
	def XtextResource getResource()
	
	def String getResourceId()
	
	def String getText()
	
	def String getStateId()
	
	def boolean isDirty()
	
	def void setText(String text)
	
	def void createNewStateId()
	
	def void updateText(String text, int offset, int replaceLength)
	
	def void setDirty(boolean dirty)
	
}