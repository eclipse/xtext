/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess.TermElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageRef2Consumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTypeConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageSpareConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageAtomConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageManyStringsConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageTwoNumbersConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.SimpleReconstrTestLanguageParensConsumer;

public final class SimpleReconstrTestLanguageTermConsumer extends NonTerminalConsumer {

	private SimpleReconstrTestLanguageRef2Consumer ref2Consumer;
	private SimpleReconstrTestLanguageTypeConsumer typeConsumer;
	private SimpleReconstrTestLanguageSpareConsumer spareConsumer;
	private SimpleReconstrTestLanguageAtomConsumer atomConsumer;
	private SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer;
	private SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer;
	private SimpleReconstrTestLanguageParensConsumer parensConsumer;

	public SimpleReconstrTestLanguageTermConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		ALTERNATIVES$1SUCCESS: {
			ALTERNATIVES$1FAILURE: {
				ALTERNATIVES$2SUCCESS: {
					ALTERNATIVES$2FAILURE: {
						ALTERNATIVES$3SUCCESS: {
							ALTERNATIVES$3FAILURE: {
								ALTERNATIVES$4SUCCESS: {
									ALTERNATIVES$4FAILURE: {
										ALTERNATIVES$5SUCCESS: {
											ALTERNATIVES$5FAILURE: {
												ALTERNATIVES$6SUCCESS: {
													ALTERNATIVES$6FAILURE: {
														RULECALL$7SUCCESS: {
															if (!consumeNonTerminal(atomConsumer, null, false, false,  getRule().ele000000ParserRuleCallAtom()))
																break RULECALL$7SUCCESS;
															break ALTERNATIVES$6FAILURE;
														}
														RULECALL$8SUCCESS: {
															if (!consumeNonTerminal(twoNumbersConsumer, null, false, false,  getRule().ele000001ParserRuleCallTwoNumbers()))
																break RULECALL$8SUCCESS;
															break ALTERNATIVES$6FAILURE;
														}
														break ALTERNATIVES$6SUCCESS;
													}
													break ALTERNATIVES$5FAILURE;
												}
												RULECALL$9SUCCESS: {
													if (!consumeNonTerminal(manyStringsConsumer, null, false, false,  getRule().ele00001ParserRuleCallManyStrings()))
														break RULECALL$9SUCCESS;
													break ALTERNATIVES$5FAILURE;
												}
												break ALTERNATIVES$5SUCCESS;
											}
											break ALTERNATIVES$4FAILURE;
										}
										RULECALL$10SUCCESS: {
											if (!consumeNonTerminal(parensConsumer, null, false, false,  getRule().ele0001ParserRuleCallParens()))
												break RULECALL$10SUCCESS;
											break ALTERNATIVES$4FAILURE;
										}
										break ALTERNATIVES$4SUCCESS;
									}
									break ALTERNATIVES$3FAILURE;
								}
								RULECALL$11SUCCESS: {
									if (!consumeNonTerminal(typeConsumer, null, false, false,  getRule().ele001ParserRuleCallType()))
										break RULECALL$11SUCCESS;
									break ALTERNATIVES$3FAILURE;
								}
								break ALTERNATIVES$3SUCCESS;
							}
							break ALTERNATIVES$2FAILURE;
						}
						RULECALL$12SUCCESS: {
							if (!consumeNonTerminal(ref2Consumer, null, false, false,  getRule().ele01ParserRuleCallRef2()))
								break RULECALL$12SUCCESS;
							break ALTERNATIVES$2FAILURE;
						}
						break ALTERNATIVES$2SUCCESS;
					}
					break ALTERNATIVES$1FAILURE;
				}
				RULECALL$13SUCCESS: {
					if (!consumeNonTerminal(spareConsumer, null, false, false,  getRule().ele1ParserRuleCallSpare()))
						break RULECALL$13SUCCESS;
					break ALTERNATIVES$1FAILURE;
				}
				break ALTERNATIVES$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public TermElements getRule() {
		return SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prTerm();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setRef2Consumer(SimpleReconstrTestLanguageRef2Consumer ref2Consumer) {
		this.ref2Consumer = ref2Consumer;
	}
	
	public void setTypeConsumer(SimpleReconstrTestLanguageTypeConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
	public void setSpareConsumer(SimpleReconstrTestLanguageSpareConsumer spareConsumer) {
		this.spareConsumer = spareConsumer;
	}
	
	public void setAtomConsumer(SimpleReconstrTestLanguageAtomConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setManyStringsConsumer(SimpleReconstrTestLanguageManyStringsConsumer manyStringsConsumer) {
		this.manyStringsConsumer = manyStringsConsumer;
	}
	
	public void setTwoNumbersConsumer(SimpleReconstrTestLanguageTwoNumbersConsumer twoNumbersConsumer) {
		this.twoNumbersConsumer = twoNumbersConsumer;
	}
	
	public void setParensConsumer(SimpleReconstrTestLanguageParensConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	

}
