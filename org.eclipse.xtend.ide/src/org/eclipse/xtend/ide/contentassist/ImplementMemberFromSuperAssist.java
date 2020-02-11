/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.MemberFromSuperImplementor;
import org.eclipse.xtend.ide.labeling.XtendImages;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.ide.contentassist.OverrideProposalUtil;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.ui.contentassist.ImportOrganizingProposal;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters;
import org.eclipse.xtext.xbase.ui.labeling.XbaseImageAdornments;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImplementMemberFromSuperAssist {

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private XtendImages images;
	
	@Inject 
	private XbaseImageAdornments adornments;

	@Inject
	private MemberFromSuperImplementor implementor;
	
	@Inject
	private ReplacingAppendable.Factory appendableFactory;
	
	@Inject
	private IImageHelper imageHelper;
	
	private static Pattern bodyExpressionPattern = Pattern.compile("\\{\\s*(.*?)\\s*$\\s*\\}", Pattern.MULTILINE
			| Pattern.DOTALL);

	@Inject
	private OverrideProposalUtil overrideProposalUtil;

	public void createOverrideProposals(XtendTypeDeclaration model, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, IProposalConflictHelper conflictHelper) {
		final JvmDeclaredType inferredType = associations.getInferredType(model);
		List<IResolvedExecutable> overrideables = overrideProposalUtil.getImplementationCandidates(inferredType, model.isAnonymous());
		for (IResolvedExecutable overrideable : overrideables) {
			ICompletionProposal completionProposal = createOverrideMethodProposal(model, overrideable, context,	conflictHelper);
			if (completionProposal != null)
				acceptor.accept(completionProposal);
		}
	}

	protected ICompletionProposal createOverrideMethodProposal(XtendTypeDeclaration model, IResolvedExecutable overrideable,
			final ContentAssistContext context, IProposalConflictHelper conflictHelper) {
		IXtextDocument document = context.getDocument();
		XtextResource resource = (XtextResource) model.eResource();
		int offset = context.getReplaceRegion().getOffset();
		int currentIndentation = appendableFactory.getIndentationLevelAtOffset(offset, document, resource);
		final int indentationLevel = currentIndentation == 0 ? 1 : currentIndentation;
		ReplacingAppendable appendable = appendableFactory.create(document, resource, offset, context.getReplaceRegion().getLength(), new OptionalParameters() {{ 
					ensureEmptyLinesAround = true;
					baseIndentationLevel = indentationLevel;	
				}});
		final String simpleName;
		JvmExecutable declaration = overrideable.getDeclaration();
		if (overrideable instanceof IResolvedOperation) {
			implementor.appendOverrideFunction(model, (IResolvedOperation) overrideable, appendable);
			simpleName = overrideable.getDeclaration().getSimpleName();
		} else if (model instanceof XtendClass) {
			implementor.appendConstructorFromSuper((XtendClass) model, (IResolvedConstructor) overrideable, appendable);
			simpleName = "new";
		} else {
			return null;
		}
		String code = appendable.getCode();
		if (!isValidProposal(code.trim(), context, conflictHelper) && !isValidProposal(simpleName, context, conflictHelper))
			return null;
		ImageDescriptor imageDescriptor = images.forOperation(declaration.getVisibility(), adornments.getOverrideAdornment(declaration));
		ImportOrganizingProposal completionProposal = createCompletionProposal(appendable, context.getReplaceRegion(),
				getLabel(overrideable), imageHelper.getImage(imageDescriptor));
		Matcher matcher = bodyExpressionPattern.matcher(code);
		if (matcher.find()) {
			int bodyExpressionLength = matcher.end(1) - matcher.start(1);
			int bodyExpressionStart = matcher.start(1) + appendable.getTotalOffset() - completionProposal.getReplacementOffset();
			if (bodyExpressionLength == 0) {
				completionProposal.setCursorPosition(bodyExpressionStart);
			} else {
				completionProposal.setSelectionStart(completionProposal.getReplacementOffset() + bodyExpressionStart);
				completionProposal.setSelectionLength(bodyExpressionLength);
				completionProposal.setAutoInsertable(false);
				completionProposal.setCursorPosition(bodyExpressionStart + bodyExpressionLength);
				completionProposal.setSimpleLinkedMode(context.getViewer(), '\t');
			}
		}
		completionProposal.setPriority(getPriority(model, declaration, context));
		completionProposal.setMatcher(new PrefixMatcher() {

			@Override
			public boolean isCandidateMatchingPrefix(String name, String prefix) {
				PrefixMatcher delegate = context.getMatcher();
				boolean result = delegate.isCandidateMatchingPrefix(simpleName, prefix);
				return result;
			}
			
		});
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

	protected int getPriority(XtendTypeDeclaration model, JvmExecutable overridden, ContentAssistContext context) {
		return (overridden instanceof JvmOperation && ((JvmOperation) overridden).isAbstract()) ? 400 : 350;
	}

	protected ImportOrganizingProposal createCompletionProposal(ReplacingAppendable appendable, Region replaceRegion,
			StyledString displayString, Image image) {
		return new ImportOrganizingProposal(appendable, replaceRegion.getOffset(), replaceRegion.getLength(),
				replaceRegion.getOffset(), image, displayString);
	}

	protected StyledString getLabel(IResolvedExecutable executable) {
		if (executable instanceof IResolvedOperation) {
			IResolvedOperation resolvedOperation = (IResolvedOperation) executable;
			return new StyledString(resolvedOperation.getSimpleSignature()).append(
					" - Override method from " + resolvedOperation.getResolvedDeclarator().getHumanReadableName(),
					StyledString.QUALIFIER_STYLER);
		} else {
			return new StyledString("Add constructor 'new " + executable.getSimpleSignature() + "'");
		}
	}

}
