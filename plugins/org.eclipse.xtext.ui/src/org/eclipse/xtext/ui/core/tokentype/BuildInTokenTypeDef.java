package org.eclipse.xtext.ui.core.tokentype;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.core.service.ITokenTypeDefService;

public class BuildInTokenTypeDef implements ITokenTypeDefService {

	public Set<ITokenTypeDef> allTokenTypes() {
		Set<ITokenTypeDef> retVal = new HashSet<ITokenTypeDef>();
		retVal.add(keyWordTokenType());
		return retVal;
	}

	protected TokenTypeDef keyWordTokenType() {
		TokenTypeDef ttd = new TokenTypeDef("keyword") {
			@Override
			public boolean match(LeafNode node) {
				return node.getGrammarElement() instanceof Keyword && node.getText().length() > 1;
			}
		};
		ttd.setName("Keyword");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.KEYWORD_COLOR, null, TextStyleConstants.KEYWORD_STYLE, null));
		return ttd;
	}
}
