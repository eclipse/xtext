/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring2.rename;

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
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring2.ChangeConverter;
import org.eclipse.xtext.ui.refactoring2.LtkIssueAcceptor;
import org.eclipse.xtext.ui.refactoring2.rename.ISimpleNameProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class RenameElementProcessor2 extends AbstractRenameProcessor {
  protected static final Logger LOG = Logger.getLogger(RenameElementProcessor2.class);
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Inject
  private IRenameNameValidator nameValidator;
  
  @Inject
  private RefactoringResourceSetProvider resourceSetProvider;
  
  @Inject
  private ISimpleNameProvider simpleNameProvider;
  
  @Inject
  private ProjectUtil projectUtil;
  
  @Inject
  private Provider<LtkIssueAcceptor> statusProvider;
  
  @Inject
  private IChangeSerializer changeSerializer;
  
  @Inject
  private IRenameStrategy2 renameStrategy;
  
  @Inject
  private ChangeConverter.Factory changeConverterFactory;
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PUBLIC_SETTER })
  private String newName;
  
  private IRenameElementContext renameElementContext;
  
  private IProject project;
  
  private ResourceSet resourceSet;
  
  private EObject target;
  
  private String originalName;
  
  private LtkIssueAcceptor status;
  
  private Change change;
  
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
    final EObject target = this.resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
    if ((target == null)) {
      this.status.add(RefactoringIssueAcceptor.Severity.ERROR, 
        "Rename target does not exist", 
        renameElementContext.getTargetElementURI());
    } else {
      this.originalName = this.simpleNameProvider.getSimpleName(target);
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
    final ChangeConverter changeConverter = this.changeConverterFactory.create(_builder.toString(), null, this.status);
    this.changeSerializer.applyModifications(changeConverter);
    this.change = changeConverter.getChange();
    return this.status.getRefactoringStatus();
  }
  
  @Override
  public Change createChange(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
    return this.change;
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
