/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages;

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
public class TreeTestLanguageGenProposalProvider  extends AbstractProposalProvider {
	// constants
	private static final String UI_PLUGIN_ID  = ".";

	
	public List<? extends ICompletionProposal> completeModelChildren(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeModelChildren feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.emptyList();
	}
	
	public List<? extends ICompletionProposal> completeNodeName(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeNodeName feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"NodeName", offset));
	}
	
	public List<? extends ICompletionProposal> completeNodeAttrib(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeNodeAttrib feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(assignment,model,"\"NodeAttrib\"", offset));		
	}
	
	public List<? extends ICompletionProposal> completeNodeChildren(Assignment assignment, EObject model, String prefix, IDocument doc,int offset) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeNodeChildren feature '" + assignment.getFeature() + "' terminal '"
					+ assignment.getTerminal() + "' cardinality '" + assignment.getCardinality() + "' and prefix '"
					+ prefix.trim() + "'");
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
