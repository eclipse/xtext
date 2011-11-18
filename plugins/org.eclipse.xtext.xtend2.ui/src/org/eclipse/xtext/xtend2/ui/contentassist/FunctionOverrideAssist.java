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

import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.util.VisibilityService;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.validation.UIStrings;
import org.eclipse.xtext.xtend2.formatting.OverrideFunction;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.ui.labeling.Xtend2Images;
import org.eclipse.xtext.xtend2.validation.OperationSignature;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FunctionOverrideAssist {

	@Inject
	private OperationSignature.Provider operationSignatureProvider;

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
	private OverrideFunction overrideFunction;

	@Inject
	private UIStrings uiStrings;
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;

	protected Iterable<JvmOperation> getOverrideableOperations(XtendClass clazz) {
		final JvmGenericType inferredType = associations.getInferredType(clazz);
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider
				.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
					@Override
					public JvmTypeReference getReceiverType() {
						return typeReferences.createTypeRef(inferredType);
					}
				});
		Set<Object> erasureKeys = newHashSet();
		for (JvmOperation op : inferredType.getDeclaredOperations()) {
			erasureKeys.add(operationSignatureProvider.get(op).getErasureKey());
		}
		List<JvmOperation> result = newArrayList();
		for (JvmOperation operation : filter(
				featureOverridesService.getAllJvmFeatures(inferredType, typeArgumentContext), JvmOperation.class)) {
			if (operation.getDeclaringType() != inferredType && visibilityService.isVisible(operation, inferredType)
					&& !operation.isFinal() && !operation.isStatic()) {
				Object erasureKey = operationSignatureProvider.get(operation).getErasureKey();
				if (erasureKeys.add(erasureKey)) {
					result.add(operation);
				}
			}
		}
		return result;
	}

	public void createOverrideProposals(XtendClass model, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Iterable<JvmOperation> overrideableOperations = getOverrideableOperations(model);
		for (JvmOperation op : overrideableOperations) {
			ICompletionProposal completionProposal = createOverrideMethodProposal(model, op, context);
			if (completionProposal != null)
				acceptor.accept(completionProposal);
		}
	}

	protected ICompletionProposal createOverrideMethodProposal(XtendClass model, JvmOperation overriddenOperation,
			ContentAssistContext context) {
		ReplacingAppendable appendable = appendableFactory.get(context.getDocument(), model, 
				context.getReplaceRegion().getOffset(), context.getReplaceRegion().getLength(), true);
		overrideFunction.appendOverrideFunction(model, overriddenOperation, appendable);
		String code = appendable.toString();
		if (!isEmpty(context.getPrefix()) && !overriddenOperation.getSimpleName().startsWith(context.getPrefix())
				&& !code.trim().startsWith(context.getPrefix()))
			return null;
		ImportOrganizingProposal completionProposal = createCompletionProposal(appendable, context.getReplaceRegion(),
				getLabel(overriddenOperation),
				images.forFunction(overriddenOperation.getVisibility()));
		int bodyOffset = code.lastIndexOf(OverrideFunction.DEFAULT_BODY);
		completionProposal.setSelectionStart(bodyOffset + completionProposal.getReplacementOffset());
		completionProposal.setSelectionLength(OverrideFunction.DEFAULT_BODY.length());
		completionProposal.setPriority(getPriority(model, overriddenOperation, context));
		return completionProposal;
	}

	protected int getPriority(XtendClass model, JvmOperation overriddenOperation,
			ContentAssistContext context) {
		return (overriddenOperation.isAbstract()) ? 400 : 350;
	}

	protected ImportOrganizingProposal createCompletionProposal(ReplacingAppendable appendable, Region replaceRegion,
			StyledString displayString, Image image) {
		return new ImportOrganizingProposal(appendable, replaceRegion.getOffset(), replaceRegion.getLength(),
				replaceRegion.getOffset(), image, displayString);
	}

	protected StyledString getLabel(JvmOperation operation) {
		return new StyledString(uiStrings.signature(operation)).append(new StyledString(" - Override method from "
				+ notNull(operation.getDeclaringType().getSimpleName()), StyledString.QUALIFIER_STYLER));
	}

}
