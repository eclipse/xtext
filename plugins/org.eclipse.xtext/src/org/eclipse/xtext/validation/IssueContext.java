/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public interface IssueContext {
	
	Issue getIssue();
	
	String getContent();
	
	EObject getModel();
	
	public static class IssueContextImpl implements IssueContext {

		private final EObject model;
		private final Issue issue;
		private final String content;
		
		public IssueContextImpl(EObject model, Issue issue, String content) {
			super();
			this.model = model;
			this.issue = issue;
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public Issue getIssue() {
			return issue;
		}

		public EObject getModel() {
			return model;
		}
		
		
		
	}

}
