package org.eclipse.xtext.example.arithmetics.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;

public class LinkingService extends DefaultLinkingService {
	
	@Override
	public String getCrossRefNodeAsString(AbstractNode node)
			throws IllegalNodeException {
		String result = super.getCrossRefNodeAsString(node); 
		EObject element = NodeUtil.getNearestSemanticObject(node);
		if (element instanceof FunctionCall) {
			FunctionCall fc = (FunctionCall) element;
			if (!fc.getArgs().isEmpty()) {
				result += "(";
				for(int i=0;i<fc.getArgs().size();i++) {
					result+="arg"+(i+1);
					if (i+1<fc.getArgs().size())
						result+=",";
				}
				result += ")";
			}
		}
		return result;
	}
}
