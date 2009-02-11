/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.MapEntrySuperElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslMapEntryConsumer;

@SuppressWarnings("unused")
public final class EcoreDslMapEntrySuperConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer mapEntryConsumer;

	public EcoreDslMapEntrySuperConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeRuleCall$1(entryPoint);
	}

	protected int consumeRuleCall$1(int entryPoint) throws Exception {
		return consumeNonTerminal(mapEntryConsumer, null, false, false, false, getRule().eleParserRuleCallMapEntry());
	}

	public MapEntrySuperElements getRule() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntrySuper();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EObject";
	}
	
	public void setMapEntryConsumer(INonTerminalConsumer mapEntryConsumer) {
		this.mapEntryConsumer = mapEntryConsumer;
	}
	
}
