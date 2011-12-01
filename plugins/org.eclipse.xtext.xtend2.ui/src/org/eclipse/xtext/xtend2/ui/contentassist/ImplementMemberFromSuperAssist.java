/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.contentassist;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtend2.formatting.MemberFromSuperImplementor;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.labeling.Xtend2Images;
import org.eclipse.xtext.xtend2.validation.TypeErasedSignature;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImplementMemberFromSuperAssist {

	@Inject
	private TypeErasedSignature.Provider signatureProvider;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private VisibilityService visibilityService;

	@Inject
	private Xtend2Images images;

	@Inject
	private MemberFromSuperImplementor implementor;

	@Inject
	private UIStrings uiStrings;

	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	private static Pattern bodyExpressionPattern = Pattern.compile("\\{\\s*(.*?)\\s*$\\s*\\}", Pattern.MULTILINE
			| Pattern.DOTALL);

	protected Iterable<JvmExecutable> getImplementationCandidates(XtendClass clazz) {
		final JvmGenericType inferredType = associations.getInferredType(clazz);
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return typeReferences.createTypeRef(inferredType);
					}
				});
		Set<TypeErasedSignature> erasureKeys = newHashSet();
		for (JvmOperation op : inferredType.getDeclaredOperations()) {
			erasureKeys.add(signatureProvider.get(op));
		}
		List<JvmExecutable> result = newArrayList();
		for (JvmExecutable executable : filter(
				featureOverridesService.getAllJvmFeatures(inferredType, typeArgumentContext), JvmExecutable.class)) {
			if (isCandidate(executable, inferredType)) {
				TypeErasedSignature erasureKey = signatureProvider.get(executable);
				if (erasureKeys.add(erasureKey)) {
					result.add(executable);
				}
			}
		}
		return result;
	}

	protected boolean isCandidate(JvmExecutable executable, JvmDeclaredType overrider) {
		if (executable.getDeclaringType() != overrider && visibilityService.isVisible(executable, overrider)) {
			if (executable instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) executable;
				return !operation.isFinal() && !operation.isStatic();
			} else {
				return executable instanceof JvmConstructor
						&& contains(transform(overrider.getSuperTypes(), new Function<JvmTypeReference, JvmType>() {
							public JvmType apply(JvmTypeReference from) {
								return from.getType();
							}
						}), executable.getDeclaringType());
			}
		}
		return false;
	}

	public void createOverrideProposals(XtendClass model, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, IProposalConflictHelper conflictHelper) {
		Iterable<JvmExecutable> overrideables = getImplementationCandidates(model);
		for (JvmExecutable overridden : overrideables) {
			ICompletionProposal completionProposal = createOverrideMethodProposal(model, overridden, context,
					conflictHelper);
			if (completionProposal != null)
				acceptor.accept(completionProposal);
		}
	}

	protected ICompletionProposal createOverrideMethodProposal(XtendClass model, JvmExecutable overridden,
			ContentAssistContext context, IProposalConflictHelper conflictHelper) {
		ReplacingAppendable appendable = appendableFactory.get(context.getDocument(), model, context.getReplaceRegion()
				.getOffset(), context.getReplaceRegion().getLength(), 1, true);
		if (overridden instanceof JvmOperation)
			implementor.appendOverrideFunction(model, (JvmOperation) overridden, appendable);
		else
			implementor.appendConstructorFromSuper(model, (JvmConstructor) overridden, appendable);
		String code = appendable.toString();
		if (!isValidProposal(code.trim(), context, conflictHelper)
				&& !isValidProposal(overridden.getSimpleName(), context, conflictHelper))
			return null;
		ImportOrganizingProposal completionProposal = createCompletionProposal(appendable, context.getReplaceRegion(),
				getLabel(overridden), images.forFunction(overridden.getVisibility(), false));
		Matcher matcher = bodyExpressionPattern.matcher(code);
		if (matcher.find()) {
			int bodyExpressionLength = matcher.end(1) - matcher.start(1);
			if (bodyExpressionLength == 0) {
				completionProposal.setCursorPosition(matcher.start(1));
			} else {
				completionProposal.setSelectionStart(completionProposal.getReplacementOffset() + matcher.start(1));
				completionProposal.setSelectionLength(bodyExpressionLength);
			}
		}
		completionProposal.setPriority(getPriority(model, overridden, context));
		return completionProposal;
	}

	protected boolean isValidProposal(String proposal, ContentAssistContext context,
			IProposalConflictHelper conflictHelper) {
		if (proposal == null)
			return false;
		if (!context.getMatcher().isCandidateMatchingPrefix(proposal, context.getPrefix()))
			return false;
		if (conflictHelper.existsConflict(proposal, context))
			return false;
		return true;
	}

	protected int getPriority(XtendClass model, JvmExecutable overridden, ContentAssistContext context) {
		return (overridden instanceof JvmOperation && ((JvmOperation) overridden).isAbstract()) ? 400 : 350;
	}

	protected ImportOrganizingProposal createCompletionProposal(ReplacingAppendable appendable, Region replaceRegion,
			StyledString displayString, Image image) {
		return new ImportOrganizingProposal(appendable, replaceRegion.getOffset(), replaceRegion.getLength(),
				replaceRegion.getOffset(), image, displayString);
	}

	protected StyledString getLabel(JvmExecutable executable) {
		if (executable instanceof JvmOperation) {
			return new StyledString(uiStrings.signature(executable)).append(new StyledString(" - Override method from "
					+ notNull(((JvmOperation) executable).getDeclaringType().getSimpleName()),
					StyledString.QUALIFIER_STYLER));
		} else {
			return new StyledString("Add constructor 'new" + uiStrings.parameters(executable) + "'");
		}
	}

}
