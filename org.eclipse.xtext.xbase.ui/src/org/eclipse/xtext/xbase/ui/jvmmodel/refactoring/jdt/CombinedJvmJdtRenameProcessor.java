/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.ui.refactoring.JdtRenameRefactoringProcessorFactory;
import org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * Bundles multiple {@link JavaRenameProcessor}s and combines their results.
 * Unfortunately {@link org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor#setRefactoring(org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring)} is
 * package private. So we have to set the refactoring from the other side. Note that this requires a refactoring
 * that is aware of that fact, e.g. {@link ChangeCombiningRenameRefactoring}.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings({ "restriction", "javadoc" })
public class CombinedJvmJdtRenameProcessor extends RenameElementProcessor {

	@Inject
	private JdtRenameRefactoringProcessorFactory jdtRefactoringFactory;

	private Map<URI, JavaRenameProcessor> jvmElements2jdtProcessors;
	
	@Override
	public boolean initialize(final IRenameElementContext renameElementContext) {
		Assert.isLegal(renameElementContext instanceof CombinedJvmJdtRenameContext);
		if (!super.initialize(renameElementContext))
			return false;
		jvmElements2jdtProcessors = newHashMap();
		for (Map.Entry<URI, IJavaElement> jvm2javaElement : ((CombinedJvmJdtRenameContext) renameElementContext)
				.getJvm2JavaElements().entrySet()) {
			JavaRenameProcessor jdtRenameProcessor = jdtRefactoringFactory.createRenameProcessor(jvm2javaElement
					.getValue());
			if (jdtRenameProcessor != null) {
				jvmElements2jdtProcessors.put(jvm2javaElement.getKey(), jdtRenameProcessor);
			} else {
				return false;
			}
		}
		return true;
	}
		
	@Override
	public Object[] getElements() {
		List<Object> elements = newArrayList(super.getElements());
		for (JavaRenameProcessor jdtProcessor : jvmElements2jdtProcessors.values()) {
			for (Object element : jdtProcessor.getElements())
				elements.add(element);
		}
		return toArray(elements, Object.class);
	}

	@Override
	public String getProcessorName() {
		return "Rename element and inferred Java artifacts";
	}

	protected Iterable<JavaRenameProcessor> getSubProcessors() {
		return jvmElements2jdtProcessors.values();
	}
	
	@Override
	public boolean isApplicable() throws CoreException {
		if (!super.isApplicable())
			return false;
		for (JavaRenameProcessor processor : jvmElements2jdtProcessors.values()) {
			if (!processor.isApplicable())
				return false;
		}
		return true;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		SubMonitor monitor = SubMonitor.convert(pm, jvmElements2jdtProcessors.size() + 1);
		RefactoringStatus status = super.checkInitialConditions(monitor.newChild(1));
		for (JavaRenameProcessor processor : jvmElements2jdtProcessors.values()) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			status.merge(processor.checkInitialConditions(monitor.newChild(1)));
		}
		return status;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm, CheckConditionsContext context)
			throws CoreException, OperationCanceledException {
		SubMonitor monitor = SubMonitor.convert(pm, jvmElements2jdtProcessors.size() + 1);
		RefactoringStatus status = super.checkFinalConditions(monitor.newChild(1), context);
		ResourceSet resourceSet = getResourceSet(getRenameElementContext());
		getRenameArguments().getRenameStrategy().applyDeclarationChange(getNewName(), resourceSet);
		for (Iterator<Map.Entry<URI, JavaRenameProcessor>> entryIterator = jvmElements2jdtProcessors.entrySet().iterator();
				entryIterator.hasNext();) {
			Map.Entry<URI, JavaRenameProcessor> jvmElement2jdtRefactoring = entryIterator.next();
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			URI renamedJvmElementURI = getRenameArguments().getNewElementURI(jvmElement2jdtRefactoring.getKey());
			EObject renamedJvmElement = resourceSet.getEObject(renamedJvmElementURI, false);
			if (!(renamedJvmElement instanceof JvmIdentifiableElement) || renamedJvmElement.eIsProxy()) {
				status.addError("Cannot find inferred JVM element after refactoring.");
			} else {
				JavaRenameProcessor jdtRefactoring = jvmElement2jdtRefactoring.getValue();
				String newName = ((JvmIdentifiableElement) renamedJvmElement).getSimpleName();
				if(jdtRefactoring.getCurrentElementName().equals(newName)) {
					entryIterator.remove();
				} else {
					jdtRefactoring.setNewElementName(newName);
					status.merge(jdtRefactoring.checkFinalConditions(monitor.newChild(1), context));
				}
			}
		}
		getRenameArguments().getRenameStrategy().revertDeclarationChange(resourceSet);
		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		SubMonitor monitor = SubMonitor.convert(pm, jvmElements2jdtProcessors.size() + 1);
		CompositeChange compositeChange = new CompositeChange(getProcessorName());
		compositeChange.add(super.createChange(monitor.newChild(1)));
		for (JavaRenameProcessor processor : jvmElements2jdtProcessors.values()) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			compositeChange.add(processor.createChange(monitor.newChild(1)));
		}
		return compositeChange;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(final RefactoringStatus status,
			final SharableParticipants sharedParticipants) throws CoreException {
		List<RefactoringParticipant> participants = newArrayList(super.loadParticipants(status, sharedParticipants));
		for (JavaRenameProcessor processor : jvmElements2jdtProcessors.values()) {
			for (RefactoringParticipant participant : processor.loadParticipants(status, sharedParticipants)) {
				if(participant instanceof JdtRenameParticipant) {
					((JdtRenameParticipant) participant).disableFor(getElements());
				}
				participants.add(participant);
			}
		}
		return toArray(participants, RefactoringParticipant.class);
	}
}
