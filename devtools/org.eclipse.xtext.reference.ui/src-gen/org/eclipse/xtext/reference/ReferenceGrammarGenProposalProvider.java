/*
Generated with Xtext
*/
package org.eclipse.xtext.reference;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.codecompletion.AbstractProposalProvider;
import org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * 
 * In addition to the declared methods, the framework tries to call grammar dependent methods for assignments using reflection.
 * The signature of such methods invoked reflectively follows the following pattern:
 * 
 * public List<ICompletionProposal> complete[Typename][featureName](Assignment ele, EObject model, String prefix)
 * 
 * <b>Example</b>
 *  Given the following grammar :
 *  <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 *
 * One could provide the following method in an implementation of this interface:
 *  <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, EObject model, String prefix, IDocument doc) {...}
 *  </code>
 *  Note that if you have generated Java classes for your domain model (meta model) you can alternatively declare the second parameter using 
 *  a specific type:
 *  <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, MyType model, String prefix, IDocument doc) {...}
 *  </code>
 *   
 */
public class ReferenceGrammarGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.reference.ui";

	
	public List<? extends ICompletionProposal> completeSpielplatzGroesse(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzGroesse feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"1", offset));		
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzBeschreibung(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzBeschreibung feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"SpielplatzBeschreibung\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzKinder(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzKinder feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzErzieher(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzErzieher feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzSpielzeuge(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzSpielzeuge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzFamilie(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzFamilie feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeSpielplatzTypes(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielplatzTypes feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeKindName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKindName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"KindName", offset));
	}
	
	public List<? extends ICompletionProposal> completeKindAge(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKindAge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"1", offset));		
	}
	
	public List<? extends ICompletionProposal> completeErwachsenerName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeErwachsenerName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"ErwachsenerName", offset));
	}
	
	public List<? extends ICompletionProposal> completeErwachsenerAge(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeErwachsenerAge feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"1", offset));		
	}
	
	public List<? extends ICompletionProposal> completeSpielzeugName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielzeugName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"SpielzeugName", offset));
	}
	
	public List<? extends ICompletionProposal> completeSpielzeugFarbe(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeSpielzeugFarbe feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeFamilieName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeFamilieMutter(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieMutter feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeFamilieVater(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieVater feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeFamilieKinder(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFamilieKinder feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	
	public List<? extends ICompletionProposal> completeFarbeWert(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeFarbeWert feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeCustomTypeParserRuleName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCustomTypeParserRuleName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"CustomTypeParserRuleName", offset));
	}
    
	public List<? extends ICompletionProposal> completeReferenceModelCustomType(RuleCall ruleCall, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeReferenceModelCustomType '" + ruleCall.getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + model + "' and prefix '" + prefix.trim() + "'");
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
