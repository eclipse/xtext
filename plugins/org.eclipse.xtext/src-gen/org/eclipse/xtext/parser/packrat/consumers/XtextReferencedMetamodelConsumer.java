/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.ReferencedMetamodelElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

public final class XtextReferencedMetamodelConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	public XtextReferencedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				GROUP$2SUCCESS: {
					IMarker mGROUP$2 = mark();
					GROUP$2FAILURE: {
						KEYWORD$3SUCCESS: {
							if (!consumeKeyword(getRule().ele00KeywordImport(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$4SUCCESS: {
							ASSIGNMENT$4FAILURE: {
								if (consumeTerminal(stringConsumer, null, false, false, getRule().ele010CrossReferenceEStringEPackage()))
									break ASSIGNMENT$4FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$4SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$7SUCCESS: {
					IMarker mGROUP$7 = mark();
					GROUP$7FAILURE: {
						KEYWORD$8SUCCESS: {
							if (!consumeKeyword(getRule().ele10KeywordAs(), null, false, false))
								break KEYWORD$8SUCCESS;
							break GROUP$7FAILURE;
						}
						mGROUP$7.rollback();
						break GROUP$7SUCCESS;
					}
					GROUP$7FAILURE: {
						ASSIGNMENT$9SUCCESS: {
							ASSIGNMENT$9FAILURE: {
								if (consumeTerminal(idConsumer, "alias", false, false, getRule().ele110LexerRuleCallID()))
									break ASSIGNMENT$9FAILURE;
								mGROUP$7.rollback();
								break ASSIGNMENT$9SUCCESS;
							}
							break GROUP$7FAILURE;
						}
						mGROUP$7.rollback();
						break GROUP$7SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public ReferencedMetamodelElements getRule() {
		return XtextGrammarAccess.INSTANCE.prReferencedMetamodel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ReferencedMetamodel";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	

}
