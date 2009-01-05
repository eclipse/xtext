/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.AbstractProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * 
 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider
 */
public class ReferenceGrammarGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.reference.ui";

	
	public List<? extends ICompletionProposal> completeSpielplatzGroesse(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzGroesse feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "1", contentAssistContext));		
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzBeschreibung(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzBeschreibung feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "\"SpielplatzBeschreibung\"", contentAssistContext));		
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzKinder(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzKinder feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzErzieher(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzErzieher feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzSpielzeuge(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzSpielzeuge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzFamilie(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzFamilie feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzTypes(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzTypes feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeKindName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKindName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "KindName", contentAssistContext));
	}
	
	public List<? extends ICompletionProposal> completeKindAge(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKindAge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "1", contentAssistContext));		
	}
	
	public List<? extends ICompletionProposal> completeErwachsenerName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeErwachsenerName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "ErwachsenerName", contentAssistContext));
	}
	
	public List<? extends ICompletionProposal> completeErwachsenerAge(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeErwachsenerAge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "1", contentAssistContext));		
	}
	
	public List<? extends ICompletionProposal> completeSpielzeugName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielzeugName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "SpielzeugName", contentAssistContext));
	}
	
	public List<? extends ICompletionProposal> completeSpielzeugFarbe(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielzeugFarbe feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeFamilieName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeFamilieMutter(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieMutter feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
	}
	
	public List<? extends ICompletionProposal> completeFamilieVater(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieVater feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
	}
	
	public List<? extends ICompletionProposal> completeFamilieKinder(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieKinder feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), contentAssistContext);
	}
	
	
	public List<? extends ICompletionProposal> completeFarbeWert(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFarbeWert feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeCustomTypeParserRuleName(Assignment assignment, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCustomTypeParserRuleName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment, "CustomTypeParserRuleName", contentAssistContext));
	}
    
    
	public List<? extends ICompletionProposal> complete(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + contentAssistContext.getModel() + "' and prefix '" + contentAssistContext.getMatchString() + "'");
		}
		return Collections.emptyList();
	}
    
    
    
    
    
    
    
	public List<? extends ICompletionProposal> completeReferenceModelCustomType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeReferenceModelCustomType '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + contentAssistContext.getModel() + "' and prefix '" + contentAssistContext.getMatchString() + "'");
		}
		return Collections.emptyList();
	}
    @Override
	protected String getDefaultImageFilePath() {
		return "icons/editor.gif";
	}

	@Override
	protected String getPluginId() {
		return UI_PLUGIN_ID;
	}
}
