/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendExecutable;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XtendProposalProvider extends AbstractXtendProposalProvider {

	@Inject
	private JdtVariableCompletions completions;

	@Inject
	private XtendGrammarAccess grammarAccess;

	@Inject
	private ImplementMemberFromSuperAssist overrideAssist;
	
	@Inject
	private OperatorMapping operatorMapping;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private IGeneratorConfigProvider generatorConfigProvider;

	@Override
	public void completeMember_Name(final EObject model, Assignment assignment, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		if (announceProcessing(Lists.newArrayList("completeMember_Name", model, assignment.getFeature()))) {
			EObject previousModel = context.getPreviousModel();
			if (previousModel instanceof XExpression) {
				if (!(previousModel instanceof XBlockExpression)) {
					return;
				}
			}
			if (model instanceof XtendField) {
				//TODO go up type hierarchy and collect all local fields
				final List<XtendField> siblings = EcoreUtil2.getSiblingsOfType(model, XtendField.class);
				Set<String> alreadyTaken = Sets.newHashSet();
				for(XtendField sibling: siblings) {
					alreadyTaken.add(sibling.getName());
				}
				alreadyTaken.addAll(getAllKeywords());
				completions.getVariableProposals(model, XtendPackage.Literals.XTEND_FIELD__TYPE,
						VariableType.INSTANCE_FIELD, alreadyTaken, new JdtVariableCompletions.CompletionDataAcceptor() {
							@Override
							public void accept(String replaceText, StyledString label, Image img) {
								acceptor.accept(createCompletionProposal(replaceText, label, img, context));
							}
						});
			} else if (model instanceof XtendFunction) {
				for(QualifiedName operator: operatorMapping.getOperators()) {
					StyledString displayString = new StyledString(operator.getFirstSegment());
					displayString.append(" " + operatorMapping.getMethodName(operator), StyledString.DECORATIONS_STYLER);
					acceptor.accept(createCompletionProposal(
							operator.getFirstSegment(),
							displayString,
							getImage(model),
							context));
				}
				super.completeMember_Name(model, assignment, context, acceptor);
			} else {
				super.completeMember_Name(model, assignment, context, acceptor);
			}
		}
	}
	
	@Override
	public void completeTypeReferenceNoTypeArgs_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals() || getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
			completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, createVisibilityFilter(context), acceptor);
		}
	}
	
	private static class VisibilityFilter extends TypeMatchFilters.AbstractFilter {
		private ContentAssistContext context;
		public VisibilityFilter(ContentAssistContext context, int searchFor) {
			super(searchFor);
			this.context = context;
		}
		@Override
		public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName, char[][] enclosingTypeNames,
				String path) {
			if (TypeMatchFilters.isNotInternal(getSearchFor()).accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)
				&& TypeMatchFilters.isAcceptableByPreference().accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)) {
				XtendFile file = (XtendFile) context.getRootModel();
				final char[] contextPackageName = Strings.emptyIfNull(file.getPackage()).toCharArray();

				if ("org.eclipse.xtend.lib".equals(String.valueOf(packageName))) {
					if ("Property".equals(String.valueOf(simpleTypeName))||"Data".equals(String.valueOf(simpleTypeName))) {
						return false;
					}
				}
				if (Flags.isPublic(modifiers)) {
					return true;
				}
				if (Flags.isPrivate(modifiers)) {
					return false;
				}
				if (Arrays.equals(contextPackageName, packageName)) {
					return true;
				}
			} 
			return false;
		}
	}

	@Override
	protected ITypesProposalProvider.Filter createVisibilityFilter(ContentAssistContext context, int searchFor) {
		return new VisibilityFilter(context, searchFor);
	}
	
	@Override
	public void completeMember_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (announceProcessing(Lists.newArrayList("completeMember_Type", model, assignment.getFeature()))) {
			if (model instanceof XtendField) {
				XtendField field = (XtendField) model;
				if(!field.getModifiers().isEmpty()) {
					// don't propose types everywhere but only if there's already an indicator for fields, e.g. static, extension, var, val
					if (field.getName() != null) {
						List<INode> nameNodes = NodeModelUtils.findNodesForFeature(model, XtendPackage.Literals.XTEND_FIELD__NAME);
						if (nameNodes.size() == 1) {
							INode node = nameNodes.get(0);
							if (node.getOffset() < context.getOffset()) {
								return;
							}
						}
					}
					completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
							getQualifiedNameValueConverter(), createVisibilityFilter(context), acceptor);
				}
			}
		}
	}
	
	@Override
	public void completeMember_Exceptions(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
			INode lastCompleteNode = context.getLastCompleteNode();
			if (lastCompleteNode instanceof ILeafNode && !((ILeafNode) lastCompleteNode).isHidden()) {
				if (lastCompleteNode.getLength() > 0 && lastCompleteNode.getTotalEndOffset() == context.getOffset()) {
					String text = lastCompleteNode.getText();
					char lastChar = text.charAt(text.length() - 1);
					if (Character.isJavaIdentifierPart(lastChar)) {
						return;
					}
				}
			}
			getTypesProposalProvider().createSubTypeProposals(
					typeReferences.findDeclaredType(Throwable.class, model),
					this,
					context,
					TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
					createVisibilityFilter(context, IJavaSearchConstants.CLASS),
					getQualifiedNameValueConverter(),
					acceptor);
		} else {
			super.completeJvmParameterizedTypeReference_Type(model, assignment, context, acceptor);
		}
	}
	
	@Override
	public void completeJvmParameterizedTypeReference_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XtendField) { // already handled by completeMember_Type
			XtendField field = (XtendField) model;
			if (!field.getModifiers().isEmpty())
				return;
		} else if (model instanceof XtendExecutable) {
			return;
		} else if (isExtendsClause(context)) {
			return;
		}
		super.completeJvmParameterizedTypeReference_Type(model, assignment, context, acceptor);
	}

	private boolean isExtendsClause(ContentAssistContext context) {
		return context.getLastCompleteNode() != null && context.getLastCompleteNode().getGrammarElement() instanceof Keyword
				&& (((Keyword) context.getLastCompleteNode().getGrammarElement()) == grammarAccess.getTypeAccess()
						.getExtendsKeyword_2_0_5_0()
				|| (((Keyword) context.getLastCompleteNode().getGrammarElement()) == grammarAccess.getTypeAccess()
						.getExtendsKeyword_2_1_5_0()));
	}
	
	@Override
	public void completeParameterizedTypeReferenceWithTypeArgs_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// all way that end up in this call graph will already have been processed by another
		// call graph that leads to type proposals
		
		// completeJvmParameterizedTypeReference_Type(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeMember_ReturnType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (context.getPrefix().length() == 0) {
			EObject previousGrammarElement = context.getLastCompleteNode().getGrammarElement();
			AbstractRule rule = GrammarUtil.containingRule(previousGrammarElement);
			if (rule != grammarAccess.getValidIDRule()) {
				completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
						getQualifiedNameValueConverter(), createVisibilityFilter(context), acceptor);
			}
		}
	}

	protected Set<String> getAllKeywords() {
		return GrammarUtil.getAllKeywords(grammarAccess.getGrammar());
	}

	@Override
	public void completeParameter_Name(final EObject model, Assignment assignment, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		if (model instanceof XtendParameter) {
			final List<XtendParameter> siblings = EcoreUtil2.getSiblingsOfType(model, XtendParameter.class);
			Set<String> alreadyTaken = Sets.newHashSet();
			for(XtendParameter sibling: siblings) {
				alreadyTaken.add(sibling.getName());
			}
			alreadyTaken.addAll(getAllKeywords());
			completions.getVariableProposals(model, XtendPackage.Literals.XTEND_PARAMETER__PARAMETER_TYPE,
					VariableType.PARAMETER, alreadyTaken, new JdtVariableCompletions.CompletionDataAcceptor() {
						@Override
						public void accept(String replaceText, StyledString label, Image img) {
							acceptor.accept(createCompletionProposal(replaceText, label, img, context));
						}
					});
		} else {
			super.completeParameter_Name(model, assignment, context, acceptor);
		}
	}

	@Override
	protected Predicate<IEObjectDescription> getFeatureDescriptionPredicate(ContentAssistContext contentAssistContext) {
		if (contentAssistContext.getPrefix().startsWith("_"))
			return super.getFeatureDescriptionPredicate(contentAssistContext);
		final Predicate<IEObjectDescription> delegate = super.getFeatureDescriptionPredicate(contentAssistContext);
		return new Predicate<IEObjectDescription>() {

			@Override
			public boolean apply(IEObjectDescription input) {
				boolean result = !input.getName().getFirstSegment().startsWith("_") && delegate.apply(input);
				if (result) {
					if (input instanceof IIdentifiableElementDescription) {
						IIdentifiableElementDescription casted = (IIdentifiableElementDescription) input;
						if (isDiscouragedExtension(casted)) {
							return false;
						}
					}
				}
				return result;
			}

		};
	}
	
	private final String WAIT = "java.lang.Object.wait";
	protected boolean isDiscouragedExtension(IIdentifiableElementDescription description) {
		if (description.isExtension()) {
			JvmIdentifiableElement candidate = description.getElementOrProxy();
			if ("equals".equals(candidate.getSimpleName())) {
				return description.getNumberOfParameters() == 0;
			}
			if ("wait".equals(candidate.getSimpleName())) {
				return WAIT.equals(candidate.getQualifiedName());
			}
		} else { // if (description.getImplicitFirstArgument() != null) {
			JvmIdentifiableElement candidate = description.getElementOrProxy();
			if ("equals".equals(candidate.getSimpleName())) {
				return description.getNumberOfParameters() == 0;
			}
		}
		return false;
	}

	@Override
	public void completeType_Extends(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		final boolean isInterface = assignment == grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_1()
				|| assignment == grammarAccess.getTypeAccess().getExtendsAssignment_2_1_5_2_1();
		//	FIXME filter "self"
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true, getQualifiedNameValueConverter(),
				new ITypesProposalProvider.Filter() {
					@Override
					public int getSearchFor() {
						return isInterface ? IJavaSearchConstants.INTERFACE : IJavaSearchConstants.CLASS;
					}

					@Override
					public boolean accept(int modifiers, char[] packageName, char[] simpleTypeName,
							char[][] enclosingTypeNames, String path) {
						
						if (TypeMatchFilters.isInternalClass(simpleTypeName, enclosingTypeNames))
							return false;
						if (!TypeMatchFilters.isAcceptableByPreference().accept(modifiers, packageName, simpleTypeName, enclosingTypeNames, path)) {
							return false;
						}
						return !Flags.isFinal(modifiers);
					}
				}, acceptor);
	}

	@Override
	public void completeType_Implements(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true, getQualifiedNameValueConverter(),
				createVisibilityFilter(context, IJavaSearchConstants.INTERFACE), acceptor);
	}

	@Override
	public void completeType_Members(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (isValidTypeForOverriding(model)) {
			INode node = context.getCurrentNode();
			EObject eObject = NodeModelUtils.findActualSemanticObjectFor(node);
			if (!(eObject instanceof AnonymousClass)) {
				// due to some optimizations in the CA parser, we get some bogus context here and have to
				// double check that an override proposal would be valid at this location
				// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=370955
				EObject prevModel = context.getPreviousModel();
				if (prevModel instanceof XExpression) {
					XtendMember containingMember = EcoreUtil2.getContainerOfType(prevModel, XtendMember.class);
					XBlockExpression blockExpression = EcoreUtil2.getContainerOfType(prevModel, XBlockExpression.class);
					if (blockExpression != null && blockExpression != prevModel) {
						if (EcoreUtil.isAncestor(containingMember, blockExpression)) { // still inside block
							return;
						}
					}
				}
				overrideAssist.createOverrideProposals((XtendTypeDeclaration) model, context, acceptor, getConflictHelper());
			}
		}
		super.completeType_Members(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeAnnotationField_Members(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeMember_Members(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeMember_Members(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (isValidTypeForOverriding(model)) {
			INode node = context.getCurrentNode();
			EObject eObject = NodeModelUtils.findActualSemanticObjectFor(node);
			if (!(eObject instanceof AnonymousClass)) {
				overrideAssist.createOverrideProposals((XtendTypeDeclaration) model, context, acceptor, getConflictHelper());
				return;
			}
		} else if (model instanceof XtendField) {
			/*
			 * class C {
			 *   static class C2 {
			 *     toS<|>
			 *   }
			 * }
			 *
			 * At this cursor position, we get a field without a name and the type 'toS' as the context.
			 * If there's a field decl preceding the cursor position, the field will have a name.
			 */
			XtendField field = (XtendField) model;
			if (isValidTypeForOverriding(field.eContainer())) {
				overrideAssist.createOverrideProposals((XtendTypeDeclaration) field.eContainer(), context, acceptor, getConflictHelper());
				return;
			}
		} else if (model instanceof XtendExecutable && context.getPrefix().length() == 0
				&& isValidTypeForOverriding(model.eContainer())) {
			overrideAssist.createOverrideProposals((XtendTypeDeclaration) model.eContainer(), context, acceptor, getConflictHelper());
			return;
		} else if (model instanceof XExpression) {
			XtendMember member = EcoreUtil2.getContainerOfType(model, XtendMember.class);
			INode memberNode = NodeModelUtils.findActualNodeFor(member);
			if (memberNode.getTotalEndOffset() <= context.getOffset()) {
				if (isValidTypeForOverriding(member.eContainer())) {
					overrideAssist.createOverrideProposals((XtendTypeDeclaration) member.eContainer(), context, acceptor, getConflictHelper());
					return;
				}
			}
		}
		INode node = context.getCurrentNode();
		EObject eObject = NodeModelUtils.findActualSemanticObjectFor(node);
		if (isValidTypeForOverriding(eObject))
			overrideAssist.createOverrideProposals((XtendTypeDeclaration) eObject, context, acceptor, getConflictHelper());
	}
	
	private boolean isValidTypeForOverriding(EObject model) {
		return model instanceof XtendClass || model instanceof XtendInterface
				&& generatorConfigProvider.get(model).getJavaSourceVersion().isAtLeast(JavaVersion.JAVA8);
	}
	
	@Override
	public void completeXConstructorCall_Members(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof AnonymousClass) {
			overrideAssist.createOverrideProposals((AnonymousClass) model, context, acceptor, getConflictHelper());
			return;
		} else if (model instanceof XtendField) {
			/*
			 * class C {
			 *   val x = new Object() {
			 *     toS<|>
			 *   }
			 * }
			 *
			 * At this cursor position, we get a field without a name and the type 'toS' as the context.
			 * If there's a field decl preceding the cursor position, the field will have a name.
			 */
			XtendField field = (XtendField) model;
			if (field.eContainer() instanceof AnonymousClass) {
				overrideAssist.createOverrideProposals((AnonymousClass) field.eContainer(), context, acceptor, getConflictHelper());
				return;
			}
		} else if (model instanceof XtendExecutable && context.getPrefix().length() == 0 && model.eContainer() instanceof AnonymousClass) {
			overrideAssist.createOverrideProposals((AnonymousClass) model.eContainer(), context, acceptor, getConflictHelper());
			return;
		} else if (model instanceof XExpression) {
			XtendMember member = EcoreUtil2.getContainerOfType(model, XtendMember.class);
			INode memberNode = NodeModelUtils.findActualNodeFor(member);
			if (memberNode.getTotalEndOffset() <= context.getOffset()) {
				if (member.eContainer() instanceof AnonymousClass) {
					overrideAssist.createOverrideProposals((AnonymousClass) member.eContainer(), context, acceptor, getConflictHelper());
					return;
				}
			}
		}
		INode node = context.getCurrentNode();
		EObject eObject = NodeModelUtils.findActualSemanticObjectFor(node);
		if (eObject instanceof AnonymousClass)
			overrideAssist.createOverrideProposals((XtendTypeDeclaration) eObject, context, acceptor, getConflictHelper());
	}

	protected void addGuillemotsProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		acceptor.accept(new ConfigurableCompletionProposal("\u00AB\u00BB", context.getOffset(), context
				.getSelectedText().length(), 1));
	}

	public void completeInRichString(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		INode node = context.getCurrentNode();
		ITextRegion textRegion = node.getTextRegion();
		int offset = textRegion.getOffset();
		int length = textRegion.getLength();
		String currentNodeText = node.getText();
		if (currentNodeText.startsWith("\u00BB") && offset + 1 <= context.getOffset()
				|| currentNodeText.startsWith("'''") && offset + 3 <= context.getOffset()) {
			if (context.getOffset() > offset && context.getOffset() < offset + length)
				addGuillemotsProposal(context, acceptor);
		} else if (currentNodeText.startsWith("\u00AB\u00AB")) {
			try {
				IDocument document = context.getViewer().getDocument();
				int nodeLine = document.getLineOfOffset(offset);
				int completionLine = document.getLineOfOffset(context.getOffset());
				if (completionLine > nodeLine) {
					addGuillemotsProposal(context, acceptor);
				}
			} catch (BadLocationException e) {
				// ignore
			}
		}
	}
	
	@Override
	public void completeInitializedVariableDeclaration_Name(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeXVariableDeclaration_Name(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeInitializedVariableDeclaration_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeXVariableDeclaration_Type(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeInitializedVariableDeclaration_Right(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeXVariableDeclaration_Right(model, assignment, context, acceptor);
	}
	
	@Override
	public void completeXFeatureCall_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XtendField) {
			if (((XtendField) model).getInitialValue() == null) {
				if (!"=".equals(context.getLastCompleteNode().getText())) {
					return;
				}
				if (model.eContainer() instanceof AnonymousClass) {
					createLocalVariableAndImplicitProposals(model.eContainer(), context, acceptor);
					return;
				}
			} else {
				List<INode> initializerNodes = NodeModelUtils.findNodesForFeature(model, XtendPackage.Literals.XTEND_FIELD__INITIAL_VALUE);
				if (initializerNodes.size() == 1) {
					INode node = initializerNodes.get(0);
					if (node.getEndOffset() <= context.getOffset()) {
						return;
					}
				}
			}
			createLocalVariableAndImplicitProposals(context.getPreviousModel(), context, acceptor);
		} else if (model instanceof AnonymousClass) {
			ICompositeNode node = NodeModelUtils.getNode(model);
			if (node.getOffset() >= context.getOffset()) {
				super.completeXFeatureCall_Feature(model, assignment, context, acceptor);
			} else {
				return;
			}
		} else {
			super.completeXFeatureCall_Feature(model, assignment, context, acceptor);
		}
	}

	@Override
	public void complete_RICH_TEXT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_START(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_END(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_RICH_TEXT_INBETWEEN(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_COMMENT_RICH_TEXT_END(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_COMMENT_RICH_TEXT_INBETWEEN(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeInRichString(model, ruleCall, context, acceptor);
	}
	
	@Override
	public void completeXVariableDeclaration_Right(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
	}
	
	@Override
	public void completeXbaseConstructorCall_Constructor(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(
				context,
				TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE,
				true,
				getQualifiedNameValueConverter(),
				createVisibilityFilter(context),
				acceptor);
	}

	@Override
	public void completeXSwitchExpression_Default(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor);
	}
	
	@Override
	protected void completeWithinBlock(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (model instanceof AnonymousClass) {
			ICompositeNode node = NodeModelUtils.getNode(model);
			if (node.getOffset() >= context.getOffset()) {
				super.completeWithinBlock(model, context, acceptor);
			} else {
				return;
			}
		}
		if (model instanceof XtendMember && model.eContainer() instanceof AnonymousClass) {
			return;
		}
		super.completeWithinBlock(model, context, acceptor);
	}
	
	@Override
	protected void completeBinaryOperationFeature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XtendExecutable)
			return;
		super.completeBinaryOperationFeature(model, assignment, context, acceptor);
	}
	
	/* see https://bugs.eclipse.org/bugs/show_bug.cgi?id=453453 */
	@Override
	protected String getConcreteSyntaxRuleName(RuleCall ruleCall) {
		if (grammarAccess.getFeatureCallIDRule() == ruleCall.getRule()) {
			return grammarAccess.getIdOrSuperRule().getName();
		}
		return super.getConcreteSyntaxRuleName(ruleCall);
	}
}
