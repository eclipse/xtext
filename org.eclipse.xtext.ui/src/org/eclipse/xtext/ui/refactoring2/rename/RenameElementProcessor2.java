/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2.rename;

import java.util.Arrays;

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

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
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

	private String newName;

	private IRenameElementContext renameElementContext;

	private IProject project;

	private ResourceSet resourceSet;

	private EObject target;

	private String originalName;

	private LtkIssueAcceptor status;

	private Change change;

	@Override
	public boolean initialize(IRenameElementContext renameElementContext) {
		this.renameElementContext = renameElementContext;
		status = statusProvider.get();
		project = projectUtil.getProject(renameElementContext.getTargetElementURI().trimFragment());

		if (project == null) {
			URI targetElementURI = renameElementContext.getTargetElementURI();
			status.add(RefactoringIssueAcceptor.Severity.ERROR, //
					"Cannot determine project from targetURI " + (targetElementURI != null ? targetElementURI.toString() : null), //
					renameElementContext.getTargetElementURI());
			return false;
		}

		resourceSet = resourceSetProvider.get(project);
		EObject target = resourceSet.getEObject(renameElementContext.getTargetElementURI(), true);
		if (target == null) {
			status.add(RefactoringIssueAcceptor.Severity.ERROR, "Rename target does not exist", renameElementContext.getTargetElementURI());
		} else {
			originalName = simpleNameProvider.getSimpleName(target);
		}
		return true;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return status.getRefactoringStatus();
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws CoreException, OperationCanceledException {
		RenameChange renameChange = new RenameChange(newName, renameElementContext.getTargetElementURI());
		RenameContext renameContext = new RenameContext(Arrays.asList(renameChange), resourceSet, changeSerializer, status);
		renameStrategy.applyRename(renameContext);

		String name = "Rename " + originalName + " to " + newName;
		ChangeConverter changeConverter = changeConverterFactory.create(name, null, status);
		changeSerializer.applyModifications(changeConverter);
		change = changeConverter.getChange();
		return status.getRefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return change;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { renameElementContext.getTargetElementURI() };
	}

	@Override
	public String getIdentifier() {
		return languageName + ".renameProcessor2";
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
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status, SharableParticipants sharedParticipants)
			throws CoreException {
		return ParticipantManager.loadRenameParticipants(status, this, renameElementContext, new RenameArguments(newName, true),
				new String[] { XtextProjectHelper.NATURE_ID }, sharedParticipants);
	}

	@Override
	public String getOriginalName() {
		return originalName;
	}

	@Override
	public RefactoringStatus validateNewName(String newName) {
		LtkIssueAcceptor nameStatus = statusProvider.get();
		nameValidator.validate(target, newName, nameStatus);
		return nameStatus.getRefactoringStatus();
	}

	@Override
	public String getNewName() {
		return newName;
	}

	@Override
	public void setNewName(String newName) {
		this.newName = newName;
	}
}
