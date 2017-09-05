/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class LtkIssueAcceptor implements RefactoringIssueAcceptor {
  @Inject
  private StatusWrapper status;
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI uri, final ResourceSet resourceSet) {
    this.status.add(this.convert(severity), message, uri, resourceSet);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final URI resourceUri) {
    this.status.add(this.convert(severity), message, resourceUri);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element) {
    this.status.add(this.convert(severity), message, element);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final EObject element, final ITextRegion region) {
    this.status.add(this.convert(severity), message, element, region);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Exception exc, final Logger log) {
    this.status.add(this.convert(severity), message, exc, log);
  }
  
  @Override
  public void add(final RefactoringIssueAcceptor.Severity severity, final String message, final Object... params) {
    this.status.add(this.convert(severity), message, params);
  }
  
  public RefactoringStatus getRefactoringStatus() {
    return this.status.getRefactoringStatus();
  }
  
  protected int convert(final RefactoringIssueAcceptor.Severity severity) {
    int _switchResult = (int) 0;
    if (severity != null) {
      switch (severity) {
        case FATAL:
          _switchResult = RefactoringStatus.FATAL;
          break;
        case ERROR:
          _switchResult = RefactoringStatus.ERROR;
          break;
        case WARNING:
          _switchResult = RefactoringStatus.WARNING;
          break;
        case INFO:
          _switchResult = RefactoringStatus.INFO;
          break;
        case OK:
          _switchResult = RefactoringStatus.OK;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
}
