package de.itemis.statefullexer.simpletemplate;

import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;

public class DebugResource extends LazyLinkingResource {

	protected void updateInternalState(IParseResult oldParseResult, IParseResult newParseResult) {
		super.updateInternalState(oldParseResult, newParseResult);
		System.out.println(NodeModelUtils.compactDump(newParseResult.getRootNode(), true));
	}
}
