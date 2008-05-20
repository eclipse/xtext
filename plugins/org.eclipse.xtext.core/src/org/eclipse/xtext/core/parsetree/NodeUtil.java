package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NodeUtil {
	public static NodeAdapter getNodeAdapter(EObject obj) {
		return (NodeAdapter) EcoreUtil.getAdapter(obj.eAdapters(), AbstractNode.class);
	}
	
	protected static boolean removeNodeAdapter(EObject obj) {
		NodeAdapter adapter = getNodeAdapter(obj);
		if (adapter == null)
			return false;
		while (adapter!=null) {
			adapter.getParserNode().setParent(null);
			adapter = getNodeAdapter(obj);
		}
		return true;
	}

}
