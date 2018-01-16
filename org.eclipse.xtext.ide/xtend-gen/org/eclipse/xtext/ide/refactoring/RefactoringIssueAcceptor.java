/**
 * Copyright (c) 2017, 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public interface RefactoringIssueAcceptor {
  public enum Severity {
    FATAL,
    
    ERROR,
    
    WARNING,
    
    INFO,
    
    OK;
  }
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI uri, final ResourceSet resourceSet);
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI resourceUri);
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element);
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element, final ITextRegion region);
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Exception exc, final Logger log);
  
  public abstract void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Object... params);
}
