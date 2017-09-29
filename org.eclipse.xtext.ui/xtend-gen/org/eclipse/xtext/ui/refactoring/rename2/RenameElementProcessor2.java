/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.rename2;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ide.refactoring.IRenameNameValidator;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.participant.ChangeConverter;
import org.eclipse.xtext.ui.refactoring.participant.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class RenameElementProcessor2 extends AbstractRenameProcessor {
  protected final static Logger LOG = Logger.getLogger(RenameElementProcessor2.class);
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Inject
  private IRenameNameValidator nameValidator;
  
  @Inject
  private IResourceSetProvider resourceSetProvider;
  
  @Inject
  private LiveScopeResourceSetInitializer liveScopeResourceSetInitializer;
  
  @Inject
  private ProjectUtil projectUtil;
  
  @Inject
  private Provider<LtkIssueAcceptor> statusProvider;
  
  @Inject
  private IChangeSerializer changeSerializer;
  
  @Inject
  private IRenameStrategy renameStrategy;
  
  @Inject
  private ChangeConverter changeConverter;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PUBLIC_SETTER })
  private String newName;
  
  private IRenameElementContext renameElementContext;
  
  private IProject project;
  
  private ResourceSet resourceSet;
  
  private EObject target;
  
  private String originalName;
  
  private LtkIssueAcceptor status;
  
  @Override
  public boolean initialize(final IRenameElementContext renameElementContext) {
    this.renameElementContext = renameElementContext;
    this.status = this.statusProvider.get();
    this.project = this.projectUtil.getProject(renameElementContext.getTargetElementURI().trimFragment());
    if ((this.project == null)) {
      URI _targetElementURI = renameElementContext.getTargetElementURI();
      String _string = null;
      if (_targetElementURI!=null) {
        _string=_targetElementURI.toString();
      }
      String _plus = ("Cannot determine project from targetURI " + _string);
      this.status.add(RefactoringIssueAcceptor.Severity.ERROR, _plus, 
        renameElementContext.getTargetElementURI());
    }
    this.resourceSet = this.resourceSetProvider.get(this.project);
    this.liveScopeResourceSetInitializer.initialize(this.resourceSet);
    final EObject target = this.resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
    if ((target == null)) {
      this.status.add(RefactoringIssueAcceptor.Severity.ERROR, 
        "Rename target does not exist", 
        renameElementContext.getTargetElementURI());
    } else {
      this.originalName = this.renameStrategy.getCurrentName(target);
    }
    return true;
  }
  
  @Override
  public RefactoringStatus checkInitialConditions(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    return this.status.getRefactoringStatus();
  }
  
  @Override
  public RefactoringStatus checkFinalConditions(final IProgressMonitor pm, final CheckConditionsContext context) throws CoreException, OperationCanceledException {
    URI _targetElementURI = this.renameElementContext.getTargetElementURI();
    final RenameChange change = new RenameChange(this.newName, _targetElementURI);
    final RenameContext renameContext = new RenameContext(Collections.<RenameChange>unmodifiableList(CollectionLiterals.<RenameChange>newArrayList(change)), this.resourceSet, this.changeSerializer, this.status);
    this.renameStrategy.applyRename(renameContext);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rename ");
    _builder.append(this.originalName);
    _builder.append(" to ");
    _builder.append(this.newName);
    this.changeConverter.initialize(_builder.toString(), null, this.status);
    this.changeSerializer.applyModifications(this.changeConverter);
    return this.status.getRefactoringStatus();
  }
  
  @Override
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    return this.changeConverter.getChange();
  }
  
  @Override
  public Object[] getElements() {
    URI _targetElementURI = this.renameElementContext.getTargetElementURI();
    return new Object[] { _targetElementURI };
  }
  
  @Override
  public String getIdentifier() {
    return (this.languageName + ".renameProcessor2");
  }
  
  @Override
  public String getProcessorName() {
    return "Rename element";
  }
  
  @Override
  public boolean isApplicable() throws CoreException {
    return true;
  }
  
  @Override
  public RefactoringParticipant[] loadParticipants(final RefactoringStatus status, final SharableParticipants sharedParticipants) throws CoreException {
    RenameArguments _renameArguments = new RenameArguments(this.newName, true);
    return ParticipantManager.loadRenameParticipants(status, this, 
      this.renameElementContext, _renameArguments, 
      new String[] { XtextProjectHelper.NATURE_ID }, sharedParticipants);
  }
  
  @Override
  public String getOriginalName() {
    return this.originalName;
  }
  
  @Override
  public RefactoringStatus validateNewName(final String newName) {
    final LtkIssueAcceptor nameStatus = this.statusProvider.get();
    this.nameValidator.validate(this.target, newName, nameStatus);
    return nameStatus.getRefactoringStatus();
  }
  
  @Pure
  public String getNewName() {
    return this.newName;
  }
  
  public void setNewName(final String newName) {
    this.newName = newName;
  }
}
