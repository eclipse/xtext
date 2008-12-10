/*
Generated with Xtext
*/
package org.eclipse.xtext;

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
public class XtextGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = "org.eclipse.xtext.xtext.ui";

	
	public List<? extends ICompletionProposal> completeGrammarAbstract(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGrammarAbstract feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeGrammarIdElements(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGrammarIdElements feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"GrammarIdElements", offset));
	}
	
	
	public List<? extends ICompletionProposal> completeGrammarSuperGrammarIdElements(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGrammarSuperGrammarIdElements feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"GrammarSuperGrammarIdElements", offset));
	}
	
	
	public List<? extends ICompletionProposal> completeGrammarMetamodelDeclarations(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGrammarMetamodelDeclarations feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeGrammarRules(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGrammarRules feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeGeneratedMetamodelName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGeneratedMetamodelName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"GeneratedMetamodelName", offset));
	}
	
	public List<? extends ICompletionProposal> completeGeneratedMetamodelNsURI(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGeneratedMetamodelNsURI feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"GeneratedMetamodelNsURI\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeGeneratedMetamodelAlias(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGeneratedMetamodelAlias feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"GeneratedMetamodelAlias", offset));
	}
	
	public List<? extends ICompletionProposal> completeReferencedMetamodelUri(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeReferencedMetamodelUri feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"ReferencedMetamodelUri\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeReferencedMetamodelAlias(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeReferencedMetamodelAlias feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"ReferencedMetamodelAlias", offset));
	}
	
	public List<? extends ICompletionProposal> completeLexerRuleName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeLexerRuleName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"LexerRuleName", offset));
	}
	
	public List<? extends ICompletionProposal> completeLexerRuleType(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeLexerRuleType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeLexerRuleBody(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeLexerRuleBody feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"LexerRuleBody\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeParserRuleName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeParserRuleName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"ParserRuleName", offset));
	}
	
	public List<? extends ICompletionProposal> completeParserRuleType(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeParserRuleType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeParserRuleAlternatives(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeParserRuleAlternatives feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeTypeRefMetamodel(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTypeRefMetamodel feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeTypeRefType(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeTypeRefType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeAlternativesGroups(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeAlternativesGroups feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeGroupAbstractTokens(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeGroupAbstractTokens feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeAbstractTokenCardinality(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeAbstractTokenCardinality feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeAssignmentFeature(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeAssignmentFeature feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"AssignmentFeature", offset));
	}
	
	public List<? extends ICompletionProposal> completeAssignmentOperator(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeAssignmentOperator feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeAssignmentTerminal(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeAssignmentTerminal feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeActionTypeName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeActionTypeName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeActionFeature(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeActionFeature feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"ActionFeature", offset));
	}
	
	public List<? extends ICompletionProposal> completeActionOperator(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeActionOperator feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeCrossReferenceType(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCrossReferenceType feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeCrossReferenceRule(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeCrossReferenceRule feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
	
	public List<? extends ICompletionProposal> completeKeywordValue(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeywordValue feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"KeywordValue\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeRuleCallRule(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCallRule feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return lookupCrossReference(((CrossReference)assignment.getTerminal()), model, prefix, offset);
	}
    
    
	public List<? extends ICompletionProposal> complete(RuleCall ruleCall, EObject model, String prefix,
			IDocument doc, int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("complete '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
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
