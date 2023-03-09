/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.KeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.EnumLiteralConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserConfiguration implements
	IParserConfiguration,
	ITerminalConsumerConfiguration,
	INonTerminalConsumerConfiguration {

	protected static ITerminalConsumer[] EMPTY_HIDDENS = IHiddenTokenHandler.EMPTY_HIDDENS;

	public interface IInternalParserConfiguration {

		ICharSequenceWithOffset getInput();

		IMarkerFactory getMarkerFactory();

		IParsedTokenAcceptor getTokenAcceptor();

		IHiddenTokenHandler getHiddenTokenHandler();

		IConsumerUtility getConsumerUtil();

		IBacktracker getBacktracker();

	}

	private final ICharSequenceWithOffset input;
	private final IMarkerFactory markerFactory;
	private final IParsedTokenAcceptor tokenAcceptor;
	private final IHiddenTokenHandler hiddenTokenHandler;
	private final IConsumerUtility consumerUtil;
	private final IBacktracker backtracker;

	protected AbstractParserConfiguration(IInternalParserConfiguration configuration) {
		this.input = configuration.getInput();
		this.markerFactory = configuration.getMarkerFactory();
		this.tokenAcceptor = configuration.getTokenAcceptor();
		this.hiddenTokenHandler = configuration.getHiddenTokenHandler();
		this.consumerUtil = configuration.getConsumerUtil();
		this.backtracker = configuration.getBacktracker();
	}

	@Override
	public ICharSequenceWithOffset getInput() {
		return input;
	}

	@Override
	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	@Override
	public IParsedTokenAcceptor getTokenAcceptor() {
		return tokenAcceptor;
	}

	@Override
	public IHiddenTokenHandler getHiddenTokenHandler() {
		return hiddenTokenHandler;
	}

	@Override
	public IConsumerUtility getConsumerUtil() {
		return consumerUtil;
	}

	@Override
	public IBacktracker getBacktracker() {
		return backtracker;
	}

	@Override
	public KeywordConsumer createKeywordConsumer() {
		return new KeywordConsumer(this);
	}

	@Override
	public EnumLiteralConsumer createLiteralConsumer() {
		return new EnumLiteralConsumer(this);
	}

	@Override
	public ITerminalConsumer[] getInitialHiddenTerminals() {
		return EMPTY_HIDDENS;
	}

	protected ITerminalConsumer[] toArray(ITerminalConsumer... consumers) {
		return consumers;
	}
}

