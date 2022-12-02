/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.text.templates.ContextTypeRegistry;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.codetemplates.ui.evaluator.EvaluatedTemplate;
import org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialEditingContentAssistContextFactory;
import org.eclipse.xtext.ui.codetemplates.ui.projectedEditing.ProjectionAwareProposalAcceptor;
import org.eclipse.xtext.ui.codetemplates.ui.projectedEditing.TemporaryResourceProvider;
import org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.IInspectableTemplateVariableResolver;
import org.eclipse.xtext.ui.codetemplates.ui.resolvers.InspectableTemplateVariableResolverRegistry;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor.ModeAware;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#content-assist
 * on how to customize the content assistant.
 */
public class CodetemplatesProposalProvider extends AbstractCodetemplatesProposalProvider implements ModeAware {
	
	@Inject
	private LanguageRegistry languageRegistry;
	
	@Inject
	private InspectableTemplateVariableResolverRegistry templateVariableResolverRegistry;
	
	@Inject
	private TemporaryResourceProvider temporaryResourceProvider;
	
	private int mode;
	
	private static final int NESTED = 2;
	private static final int NORMAL = 1;
	
	@Override
	public void reset() {
		mode = 2;
	}
	
	@Override
	public void nextMode() {
		mode = (mode % 3) + 1;
	}
	
	@Override
	public String getNextCategory() {
		switch(mode) {
			case 1: return "target language proposals";
			case 2: return "all proposals";
			default: return "template infrastructure proposals";
		}
	}
	
	@Override
	public boolean isLastMode() {
		return mode == 2;
	}
	
	private String getAssignedFeature(RuleCall call) {
		Assignment ass = GrammarUtil.containingAssignment(call);
		if (ass != null) {
			String result = ass.getFeature();
			if (result.equals(result.toLowerCase()))
				result = Strings.toFirstUpper(result);
			return result;
		}
		return null;
	}
	
	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			String feature = getAssignedFeature(ruleCall);
			createStringProposal(context, acceptor, feature, ruleCall);
		}
	}

	private void createStringProposal(ContentAssistContext context, ICompletionProposalAcceptor acceptor,
			String feature, RuleCall ruleCall) {
		String proposalText = feature != null ? feature : Strings.toFirstUpper(ruleCall.getRule().getName().toLowerCase());
		proposalText = getValueConverter().toString(proposalText, ruleCall.getRule().getName());
		String displayText = proposalText;
		if (feature != null)
			displayText = displayText + " - " + ruleCall.getRule().getName();
		ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset() + 1);
			configurable.setSelectionLength(proposalText.length() - 2);
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), proposalText.charAt(0), '\t');
			
		}
		acceptor.accept(proposal);
	}
		
	@Override
	public void completeVariable_Name(EObject model, Assignment assignment, final ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			{
				String proposalText = "variable";
				StyledString displayText = new StyledString(proposalText).append(" - Create a new template variable", StyledString.QUALIFIER_STYLER);
				ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
				if (proposal instanceof ConfigurableCompletionProposal) {
					ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
					configurable.setSelectionStart(configurable.getReplacementOffset());
					configurable.setSelectionLength(proposalText.length());
					configurable.setAutoInsertable(false);
					configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
				}
				acceptor.accept(proposal);
			}
			TemplateData data = new TemplateData(model);
			if (data.doCreateProposals()) {
				ContextTypeIdHelper helper = languageRegistry.getContextTypeIdHelper(data.language); 
				if (helper != null) {
					String contextTypeId = helper.getId(data.rule);
					ContextTypeRegistry contextTypeRegistry = languageRegistry.getContextTypeRegistry(data.language);
					TemplateContextType contextType = contextTypeRegistry.getContextType(contextTypeId);
					if (contextType != null) {
						Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(), TemplateVariableResolver.class);
						while(resolvers.hasNext()) {
							final TemplateVariableResolver resolver = resolvers.next();
							IInspectableTemplateVariableResolver inspectableResolver = templateVariableResolverRegistry.toInspectableResolver(resolver);
							if (inspectableResolver != null) {
								if (!inspectableResolver.hasMandatoryParameters()) {
									String type = resolver.getType();
									StyledString displayString = new StyledString(type, StyledString.DECORATIONS_STYLER).append(" - " + resolver.getDescription(), StyledString.QUALIFIER_STYLER);
									acceptor.accept(createCompletionProposal(type, displayString, null, context));
								}
								String proposalText = "variable:" + resolver.getType();
								StyledString displayText = new StyledString("variable")
									.append(":" + resolver.getType(), StyledString.DECORATIONS_STYLER)
									.append(" - " + resolver.getDescription(), StyledString.QUALIFIER_STYLER);
								if (inspectableResolver.hasMandatoryParameters())
									proposalText = proposalText + "()";
								Builder builder = context.copy();
								PrefixMatcher newMatcher = new PrefixMatcher() {
									@Override
									public boolean isCandidateMatchingPrefix(String name, String prefix) {
										return context.getMatcher().isCandidateMatchingPrefix(name, prefix) ||
											context.getMatcher().isCandidateMatchingPrefix("variable:" + resolver.getType(), prefix) ||
											context.getMatcher().isCandidateMatchingPrefix(resolver.getType(), prefix);
									}
								};
								builder.setMatcher(newMatcher);
								ContentAssistContext myContext = builder.toContext();
								ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, myContext);
								if (proposal instanceof ConfigurableCompletionProposal) {
									ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
									configurable.setSelectionStart(configurable.getReplacementOffset());
									configurable.setSelectionLength("variable".length());
									configurable.setAutoInsertable(false);
									if (inspectableResolver.hasMandatoryParameters()) {
										configurable.setCursorPosition(proposalText.length() - 1);
									}
									configurable.setSimpleLinkedMode(myContext.getViewer(), '\t');
								}
								acceptor.accept(proposal);
							} else {
								String type = resolver.getType();
								StyledString displayString = new StyledString(type, StyledString.DECORATIONS_STYLER).append(" - " + resolver.getDescription(), StyledString.QUALIFIER_STYLER);
								acceptor.accept(createCompletionProposal(type, displayString, null, context));
							}
						}
					}
				}
				if (data.template.getBody() != null) {
					for(Variable variable: Iterables.filter(data.template.getBody().getParts(), Variable.class)) {
						if (variable != model && variable.getName() != null) {
							String proposalText = variable.getName();
							StyledString displayText = new StyledString(proposalText).append(" - existing variable", StyledString.QUALIFIER_STYLER);
							if (variable.getType() != null)
								displayText = displayText.append(" of type " + variable.getType(), StyledString.QUALIFIER_STYLER);
							ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
							acceptor.accept(proposal);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void complete_Variable(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			String proposalText = "${}";
			StyledString displayText = new StyledString(proposalText, StyledString.DECORATIONS_STYLER).append(" - Create a new template variable", StyledString.QUALIFIER_STYLER);
			ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setSelectionStart(configurable.getReplacementOffset() + 2);
				configurable.setSelectionLength(0);
				configurable.setAutoInsertable(false);
				configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
			}
			acceptor.accept(proposal);
		}
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			if ("$".equals(keyword.getValue()) || "${".equals(keyword.getValue()))
				return;
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}
	
	@Override
	public void completeVariable_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			super.completeVariable_Name(model, assignment, context, acceptor);
			TemplateData data = new TemplateData(model);
			if (data.doCreateProposals()) {
				ContextTypeIdHelper helper = languageRegistry.getContextTypeIdHelper(data.language); 
				if (helper != null) {
					String contextTypeId = helper.getId(data.rule);
					ContextTypeRegistry contextTypeRegistry = languageRegistry.getContextTypeRegistry(data.language);
					TemplateContextType contextType = contextTypeRegistry.getContextType(contextTypeId);
					if (contextType != null) {
						Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(), TemplateVariableResolver.class);
						while(resolvers.hasNext()) {
							TemplateVariableResolver resolver = resolvers.next();
							String type = resolver.getType();
							StyledString displayString = new StyledString(type).append(" - " + resolver.getDescription(), StyledString.QUALIFIER_STYLER);
							acceptor.accept(createCompletionProposal(type, displayString, null, context));
						}
					}
				}
			}
		}
	}
	
	@Override
	public void completeVariable_Parameters(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if ((mode & NORMAL) != 0) {
			VariableData data = new VariableData(model);
			if (data.doCreateProposals()) {
				String variableType = data.variable.getType();
				if ("CrossReference".equals(variableType)) {
					List<CrossReference> crossReferences = GrammarUtil.containedCrossReferences(data.rule);
					for(CrossReference crossReference: crossReferences) {
						EReference reference = GrammarUtil.getReference(crossReference);
						String fqn = reference.getEContainingClass().getName() + "." + reference.getName();
						acceptor.accept(createCompletionProposal(fqn, context));
						acceptor.accept(createCompletionProposal("'" + fqn + "'", context));
					}
				} else if ("Enum".equals(variableType)) {
					
				}
				super.completeVariable_Parameters(model, assignment, context, acceptor);	
			}
		}
	}
	
	@Override
	public void complete_Literal(EObject model, RuleCall ruleCall, final ContentAssistContext context,
			final ICompletionProposalAcceptor acceptor) {
		if ((mode & NESTED) != 0) {
			final TemplateData data = new TemplateData(model);
			if (data.doCreateProposals()) {
				final EvaluatedTemplate evaluatedTemplate = new EvaluatedTemplate(data.template);
				temporaryResourceProvider.useTemporaryResource(data.template.eResource().getResourceSet(), 
						data.language, data.rule, evaluatedTemplate.getMappedString(), new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						IPartialEditingContentAssistContextFactory delegateFactory = languageRegistry.getPartialContentAssistContextFactory(data.language);
						delegateFactory.initializeFor(data.rule);
						String mappedInput = evaluatedTemplate.getMappedString();
						int mappedOffset = Math.min(mappedInput.length(), evaluatedTemplate.getMappedOffset(context.getOffset()));
						DummyDocument document = new DummyDocument(mappedInput);
						DummyTextViewer dummyViewer = new DummyTextViewer(TextSelection.emptySelection(), document);
						ContentAssistContext[] contexts = delegateFactory.create(dummyViewer, mappedOffset, resource);
						ICompletionProposalAcceptor mappingAcceptor = new ProjectionAwareProposalAcceptor(acceptor, evaluatedTemplate);
						createNestedProposals(contexts, context.getViewer(), mappingAcceptor, data);
					}
				});
			}
		}
	}
	
	@Override
	public void completeCodetemplate_KeywordContext(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Codetemplate template = EcoreUtil2.getContainerOfType(model, Codetemplate.class);
		if (template != null) {
			Codetemplates templates = EcoreUtil2.getContainerOfType(template, Codetemplates.class);
			if (templates != null) {
				Grammar language = templates.getLanguage();
				if (language != null && !language.eIsProxy()) {
					Set<String> keywords = GrammarUtil.getAllKeywords(language);
					for(String keyword: keywords) {
						String proposalText = keyword;
						proposalText = getValueConverter().toString(proposalText, ((RuleCall)assignment.getTerminal()).getRule().getName());
						StyledString displayText = new StyledString(proposalText).append(" - Keyword", StyledString.QUALIFIER_STYLER);
						ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
						getPriorityHelper().adjustCrossReferencePriority(proposal, context.getPrefix());
						if (proposal instanceof ConfigurableCompletionProposal) {
							((ConfigurableCompletionProposal) proposal).setPriority(((ConfigurableCompletionProposal) proposal).getPriority() - 1);
						}
						acceptor.accept(proposal);
					}
				}
			}
		}
	}
	
	protected static class TemplateData {
		protected Codetemplate template;
		protected Codetemplates templates;
		protected Grammar language;
		protected AbstractRule rule;

		protected TemplateData(EObject model) {
			template = EcoreUtil2.getContainerOfType(model, Codetemplate.class);
			if (template != null) {
				templates = EcoreUtil2.getContainerOfType(template, Codetemplates.class);
				language = templates.getLanguage();
				rule = template.getContext();
			}
		}
		
		protected boolean doCreateProposals() {
			return rule != null && !rule.eIsProxy() && rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule);
		}
	}
	
	protected static class VariableData extends TemplateData {

		protected Variable variable;

		protected VariableData(EObject model) {
			super(model);
			if (template != null)
				variable = EcoreUtil2.getContainerOfType(model, Variable.class);
		}
		
		@Override
		protected boolean doCreateProposals() {
			return variable != null && super.doCreateProposals();
		}
		
	}
	
	public void createNestedProposals(ContentAssistContext[] contexts, ITextViewer originalViewer, final ICompletionProposalAcceptor acceptor, TemplateData data) {
		for(ContentAssistContext context: contexts) {
			Builder builder = context.copy();
			builder.setViewer(originalViewer);
			ContentAssistContext myContext = builder.toContext();
			IFollowElementAcceptor selector = createNestedSelector(myContext, acceptor, data);
			for (AbstractElement element : myContext.getFirstSetGrammarElements()) {
				selector.accept(element);
			}
		}
	}
	
	protected IFollowElementAcceptor createNestedSelector(ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, TemplateData data) {
		return new NestedContentAssistProcessorSwitch(context, acceptor, data);
	}
	
	public void completeNestedKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor, TemplateData data) {
		String keywordValue = keyword.getValue();
		String escapedKeywordValue = keywordValue.replace("$", "$$");
		StyledString displayString = new StyledString(keywordValue);
		if (!keywordValue.equals(escapedKeywordValue)) {
			displayString = new StyledString(escapedKeywordValue)
				.append(" - ", StyledString.QUALIFIER_STYLER)
				.append(keywordValue, StyledString.COUNTER_STYLER)
				.append(" - Keyword", StyledString.QUALIFIER_STYLER);
		} else {
			displayString = displayString.append(" - Keyword", StyledString.QUALIFIER_STYLER);
		}
		ConfigurableCompletionProposal proposal = (ConfigurableCompletionProposal) createCompletionProposal(escapedKeywordValue,
				displayString,
				getImage(keyword),
				contentAssistContext);
		getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
		if (proposal != null)
			proposal.setPriority(proposal.getPriority() * 2);
		acceptor.accept(proposal);
	}
	
	public void completeNestedAssignment(Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor, TemplateData data) {
		String proposalText = "${" + assignment.getFeature() + "}";
		StyledString displayText;
		if (assignment.getTerminal() instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) assignment.getTerminal();
			AbstractRule calledRule = ruleCall.getRule();
			displayText = new StyledString("${", StyledString.DECORATIONS_STYLER)
				.append(assignment.getFeature(), null)
				.append("}", StyledString.DECORATIONS_STYLER)
				.append(" - ", StyledString.QUALIFIER_STYLER)
				.append(calledRule.getName(), StyledString.COUNTER_STYLER)
				.append(" - Create a new template variable", StyledString.QUALIFIER_STYLER);
		} else {
			displayText = new StyledString("${", StyledString.DECORATIONS_STYLER)
				.append(assignment.getFeature(), null)
				.append("}", StyledString.DECORATIONS_STYLER)
				.append(" - Create a new template variable", StyledString.QUALIFIER_STYLER);
		}
		ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset() + 2);
			configurable.setSelectionLength(proposalText.length() - 3);
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), '\t');
			configurable.setPriority(configurable.getPriority() * 2);
		}
		acceptor.accept(proposal);
	}
	
	public void completeNestedCrossReference(CrossReference crossReference, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor, TemplateData data) {
		if (data.doCreateProposals()) {
			ContextTypeIdHelper helper = languageRegistry.getContextTypeIdHelper(data.language);
			if (helper != null) {
				String contextTypeId = helper.getId(data.rule);
				ContextTypeRegistry contextTypeRegistry = languageRegistry.getContextTypeRegistry(data.language);
				TemplateContextType contextType = contextTypeRegistry.getContextType(contextTypeId);
				TemplateVariableResolver crossRefResolver = getResolver(contextType, "CrossReference");
				if (crossRefResolver != null) {
					Assignment assignment = (Assignment) crossReference.eContainer();
					EReference reference = GrammarUtil.getReference(crossReference);
					if (reference != null) {
						String proposalText = "${" + assignment.getFeature() + ":CrossReference("
								+ reference.getEContainingClass().getName() + "." + reference.getName() + ")}";
						StyledString displayText = new StyledString("${", StyledString.DECORATIONS_STYLER)
								.append(assignment.getFeature())
								.append(":CrossReference(", StyledString.DECORATIONS_STYLER)
								.append(reference.getEContainingClass().getName() + "." + reference.getName(),
										StyledString.COUNTER_STYLER)
								.append(")}", StyledString.DECORATIONS_STYLER)
								.append(" - Create a new template variable", StyledString.QUALIFIER_STYLER);
						ICompletionProposal proposal = createCompletionProposal(proposalText, displayText, null, context);
						if (proposal instanceof ConfigurableCompletionProposal) {
							ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
							configurable.setSelectionStart(configurable.getReplacementOffset() + 2);
							configurable.setSelectionLength(assignment.getFeature().length());
							configurable.setAutoInsertable(false);
							configurable.setSimpleLinkedMode(context.getViewer(), '\t');
							configurable.setPriority(configurable.getPriority() * 2);
						}
						acceptor.accept(proposal);
					}
				}
			}
		}
	}
		
	private TemplateVariableResolver getResolver(TemplateContextType contextType, String resolver) {
		if (contextType == null)
			return null;
		Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(), TemplateVariableResolver.class);
		while(resolvers.hasNext()) {
			TemplateVariableResolver result = resolvers.next();
			if (resolver.equals(result.getType())) {
				return result;
			}
		}
		return null;
	}

	public class NestedContentAssistProcessorSwitch extends XtextSwitch<Boolean> implements IFollowElementAcceptor {

		private final ContentAssistContext context;
		private final ICompletionProposalAcceptor acceptor;
		private final TemplateData data;

		public NestedContentAssistProcessorSwitch(ContentAssistContext context, ICompletionProposalAcceptor acceptor, TemplateData data) {
			this.context = context;
			this.acceptor = acceptor;
			this.data = data;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseKeyword(Keyword object) {
			completeNestedKeyword(object, context, acceptor, data);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseAssignment(Assignment object) {
			doSwitch(object.getTerminal());
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseCrossReference(CrossReference object) {
			completeNestedCrossReference(object, context, acceptor, data);
			return Boolean.TRUE;
		}
		
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			if (object.getRule() instanceof EnumRule) {
				
			} else if (object.getRule() instanceof TerminalRule || GrammarUtil.isDatatypeRule((ParserRule) object.getRule())) {
				if (object.eContainer() instanceof Assignment) {
					completeNestedAssignment((Assignment) object.eContainer(), context, acceptor, data);
				}
			}
			return Boolean.TRUE;
		}

		@Override
		public void accept(AbstractElement element) {
			doSwitch(element);
		}
	}

	public void setMode(int cycle) {
		mode = cycle;
	}

}
