/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler.IHiddenTokenState;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.internal.IFurtherParsable;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.AlternativesToken;
import org.eclipse.xtext.parser.packrat.tokens.AssignmentToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.GroupToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenSource;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.PlaceholderToken;
import org.eclipse.xtext.parser.packrat.tokens.UnorderedGroupToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class NonTerminalConsumer extends AbstractConsumer implements INonTerminalConsumer, INonTerminalConsumerConfiguration {

	protected static final int SUCCESS = ConsumeResult.SUCCESS;

	private final IHiddenTokenHandler hiddenTokenHandler;

	private final IMarkerFactory markerFactory;

	private final IBacktracker backtracker;

	private final ITerminalConsumer[] hiddenTokens;

	private final IConsumerUtility consumerUtil;

	private int doConsumeGroup(ElementConsumer<Group> groupConsumer, IElementConsumer[] groupElements, boolean optional) throws Exception {
		final GroupResult result = createGroupResult(groupConsumer, optional);
		result.reset();
		for(IElementConsumer consumer: groupElements) {
			if (result.didGroupFail(consumer.consume())) {
				if (result.result == ConsumeResult.EMPTY_MATCH) {
					result.error(groupConsumer.getErrorMessage());
					result.getResult();
					return getOffset();
				}
				return result.getResult();
			}
		}
		return result.getResult();
	}
	
	private int doConsumeUnorderedGroup(ElementConsumer<UnorderedGroup> groupConsumer, IElementConsumer[] groupElements, 
			IFurtherParsable.Source<UnorderedGroupToken> source, boolean optional) throws Exception {
		final UnorderedGroupResult result = createUnorderedGroupResult(groupConsumer, source, optional);
		result.reset();
		for(IElementConsumer consumer: groupElements) {
			if (result.didGroupFail(consumer.consume())) {
				if (result.result == ConsumeResult.EMPTY_MATCH) {
					result.error(groupConsumer.getErrorMessage());
					result.getResult();
					return getOffset();
				}
				return result.getResult();
			}
		}
		return result.getResult();
//		result.reset();
//		result.setAlternative(entry - 1);
//		for (int i = entry; i < alternativesElements.length; i++) {
//			result.nextAlternative();
//			if (result.isAlternativeDone(alternativesElements[i].consume()))
//				return result.getResult();
//		}
//		if (result.bestResult == ConsumeResult.EMPTY_MATCH) {
//			result.fakeNextAlternative();
//			result.error(alternativesConsumer.getErrorMessage());
//			result.isAlternativeDone(ConsumeResult.SUCCESS);
//			result.getResult();
//			return getOffset();
//		}
//		return result.getResult();
	}

	private int doConsumeAlternatives(ElementConsumer<Alternatives> alternativesConsumer, IElementConsumer[] alternativesElements,
			IFurtherParsable.Source<AlternativesToken> source, boolean optional, int entry) throws Exception {
		final AlternativesResult result = createAlternativesResult(alternativesConsumer, source, optional, alternativesElements.length);
		result.reset();
		result.setAlternative(entry - 1);
		for (int i = entry; i < alternativesElements.length; i++) {
			result.nextAlternative();
			if (result.isAlternativeDone(alternativesElements[i].consume()))
				return result.getResult();
		}
		if (result.bestResult == ConsumeResult.EMPTY_MATCH) {
			result.fakeNextAlternative();
			result.error(alternativesConsumer.getErrorMessage());
			result.isAlternativeDone(ConsumeResult.SUCCESS);
			result.getResult();
			return getOffset();
		}
		return result.getResult();
	}

	private int doConsumeAssignment(ElementConsumer<Assignment> assignmentConsumer, IElementConsumer element, boolean optional) throws Exception {
		final AssignmentResult result = createAssignmentResult(assignmentConsumer, optional);
		return result.getResult(element.consume());
	}

	protected static class ConsumerAcceptor {
		private final List<IElementConsumer> result = new ArrayList<IElementConsumer>(4);

		public void accept(IElementConsumer consumer) {
			result.add(consumer);
		}

		private IElementConsumer[] getResult() {
			return result.toArray(new IElementConsumer[result.size()]);
		}
	}

	protected abstract class ElementConsumer<Element extends AbstractElement> implements IElementConsumer, IParsedTokenSource {

		private final Element element;

		protected ElementConsumer(Element element) {
			this.element = element;
		}

		@Override
		public int consume() throws Exception {
			IMarker marker = mark();
			int result = doConsume(false);
			if (result != ConsumeResult.SUCCESS) {
				IMarker forkedMarker = marker.fork();
				IBacktracker.IBacktrackingResult backtrackingResult = skipPreviousToken();
				while(result != ConsumeResult.SUCCESS && backtrackingResult.isSuccessful()) {
					IMarker localMarker = mark();
					result = doConsume(false);
					if (result != ConsumeResult.SUCCESS) {
						localMarker.rollback();
						backtrackingResult = backtrackingResult.skipPreviousToken();
					} else {
						localMarker.commit();
					}
					localMarker = null;
				}
				// TODO keep the better result
				if (result == ConsumeResult.SUCCESS) {
					backtrackingResult.commit();
					marker = forkedMarker.join(marker);
				} else {
					backtrackingResult.discard();
					marker = marker.join(forkedMarker);
				}
				forkedMarker = null;
			}
			marker.commit();
			return result;
		}

		@Override
		public int parseAgain(ParsedToken token) throws Exception {
			return consume();
		}

		protected abstract int doConsume(boolean optional) throws Exception;

		protected final Element getElement() {
			return element;
		}

		protected String getErrorMessage() {
			return "Another token expected.";
		}
	}

	protected abstract class GroupConsumer extends ElementConsumer<Group> {

		private IElementConsumer[] consumers;

		public GroupConsumer(Group element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeGroup(this, getConsumers(), optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}
	
	protected abstract class UnorderedGroupConsumer extends ElementConsumer<UnorderedGroup> implements IFurtherParsable.Source<UnorderedGroupToken> {

		private IElementConsumer[] consumers;

		public UnorderedGroupConsumer(UnorderedGroup element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeUnorderedGroup(this, getConsumers(), this, optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}
		
		@Override
		public int parseFurther(IFurtherParsable<UnorderedGroupToken> token) throws Exception {
			final UnorderedGroupToken groupToken = token.getToken();
			return doConsumeUnorderedGroup(this, getConsumers(), this, groupToken.isOptional() /*, groupToken.getAlternative() + 1 */);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class AlternativesConsumer extends ElementConsumer<Alternatives> implements IFurtherParsable.Source<AlternativesToken> {

		private IElementConsumer[] consumers;

		protected AlternativesConsumer(Alternatives element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAlternatives(this, getConsumers(), this, optional, 0);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		@Override
		public int parseFurther(IFurtherParsable<AlternativesToken> token) throws Exception {
			final AlternativesToken alternativesToken = token.getToken();
			return doConsumeAlternatives(this, getConsumers(), this, alternativesToken.isOptional(), alternativesToken.getAlternative() + 1);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class AssignmentConsumer extends ElementConsumer<Assignment> {

		public AssignmentConsumer(Assignment element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAssignment(this, getConsumer(), optional);
		}

		protected abstract IElementConsumer getConsumer();
	}

	protected abstract class OptionalElementConsumer<Element extends AbstractElement> extends ElementConsumer<Element> {

		protected OptionalElementConsumer(Element element) {
			super(element);
		}

		@Override
		public final int consume() throws Exception {
			IMarker marker = mark();
			int result = doConsume(true);
			if (result != ConsumeResult.SUCCESS) {
				marker.rollback();
				skipped(this);
			} else
				marker.commit();
			return ConsumeResult.SUCCESS;
		}
	}

	protected abstract class OptionalGroupConsumer extends OptionalElementConsumer<Group> {

		private IElementConsumer[] consumers;

		protected OptionalGroupConsumer(Group element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeGroup(this, getConsumers(), optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}
	
	protected abstract class OptionalUnorderedGroupConsumer extends OptionalElementConsumer<UnorderedGroup> implements IFurtherParsable.Source<UnorderedGroupToken> {

		private IElementConsumer[] consumers;

		public OptionalUnorderedGroupConsumer(UnorderedGroup element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeUnorderedGroup(this, getConsumers(), this, optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}
		
		@Override
		public int parseFurther(IFurtherParsable<UnorderedGroupToken> token) throws Exception {
			final UnorderedGroupToken groupToken = token.getToken();
			return doConsumeUnorderedGroup(this, getConsumers(), this, groupToken.isOptional() /*, groupToken.getAlternative() + 1 */);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class OptionalAlternativesConsumer extends OptionalElementConsumer<Alternatives> implements IFurtherParsable.Source<AlternativesToken> {

		private IElementConsumer[] consumers;

		protected OptionalAlternativesConsumer(Alternatives element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAlternatives(this, getConsumers(), this, optional, 0);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		@Override
		public int parseFurther(IFurtherParsable<AlternativesToken> token) throws Exception {
			final AlternativesToken alternativesToken = token.getToken();
			return doConsumeAlternatives(this, getConsumers(), this, alternativesToken.isOptional(), alternativesToken.getAlternative() + 1);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class OptionalAssignmentConsumer extends OptionalElementConsumer<Assignment> {

		protected OptionalAssignmentConsumer(Assignment element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAssignment(this, getConsumer(), optional);
		}

		protected abstract IElementConsumer getConsumer();
	}

	protected abstract class LoopElementConsumer<Element extends AbstractElement> extends ElementConsumer<Element> {

		protected LoopElementConsumer(Element element) {
			super(element);
		}

		@Override
		public final int consume() throws Exception {
			IMarker marker = mark();
			while(doConsume(true) == ConsumeResult.SUCCESS) {
				marker.flush();
			}
			marker.rollback();
			skipped(this);
			return ConsumeResult.SUCCESS;
		}
	}

	protected abstract class LoopGroupConsumer extends LoopElementConsumer<Group> {

		private IElementConsumer[] consumers;

		protected LoopGroupConsumer(Group element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeGroup(this, getConsumers(), optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}
	
	protected abstract class LoopUnorderedGroupConsumer extends LoopElementConsumer<UnorderedGroup> implements IFurtherParsable.Source<UnorderedGroupToken> {

		private IElementConsumer[] consumers;

		public LoopUnorderedGroupConsumer(UnorderedGroup element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeUnorderedGroup(this, getConsumers(), this, optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}
		
		@Override
		public int parseFurther(IFurtherParsable<UnorderedGroupToken> token) throws Exception {
			final UnorderedGroupToken groupToken = token.getToken();
			return doConsumeUnorderedGroup(this, getConsumers(), this, groupToken.isOptional() /*, groupToken.getAlternative() + 1 */);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class LoopAlternativesConsumer extends LoopElementConsumer<Alternatives> implements IFurtherParsable.Source<AlternativesToken> {

		private IElementConsumer[] consumers;

		protected LoopAlternativesConsumer(Alternatives element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAlternatives(this, getConsumers(), this, optional, 0);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		@Override
		public int parseFurther(IFurtherParsable<AlternativesToken> token) throws Exception {
			final AlternativesToken alternativesToken = token.getToken();
			return doConsumeAlternatives(this, getConsumers(), this, alternativesToken.isOptional(), alternativesToken.getAlternative() + 1);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class LoopAssignmentConsumer extends LoopElementConsumer<Assignment> {

		public LoopAssignmentConsumer(Assignment element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAssignment(this, getConsumer(), optional);
		}

		protected abstract IElementConsumer getConsumer();
	}

	protected abstract class MandatoryLoopElementConsumer<Element extends AbstractElement> extends ElementConsumer<Element> {

		protected MandatoryLoopElementConsumer(Element element) {
			super(element);
		}

		@Override
		public int parseAgain(ParsedToken token) throws Exception {
			if (!token.isOptional())
				return consume();
			IMarker marker = mark();
			while(doConsume(true) == ConsumeResult.SUCCESS) {
				marker.flush();
			}
			marker.rollback();
			skipped(this);
			return ConsumeResult.SUCCESS;
		}

		@Override
		public final int consume() throws Exception {
			IMarker marker = mark();
			int result = doConsume(false);
			if (result != ConsumeResult.SUCCESS) {
				IMarker forkedMarker = marker.fork();
				IBacktracker.IBacktrackingResult backtrackingResult = skipPreviousToken();
				while(result != ConsumeResult.SUCCESS && backtrackingResult.isSuccessful()) {
					IMarker localMarker = mark();
					result = doConsume(false);
					if (result != ConsumeResult.SUCCESS) {
						localMarker.rollback();
						backtrackingResult = backtrackingResult.skipPreviousToken();
					} else {
						localMarker.commit();
					}
					localMarker = null;
				}
				// TODO keep the better result
				if (result == ConsumeResult.SUCCESS) {
					backtrackingResult.commit();
					marker = forkedMarker.join(marker);
				} else {
					backtrackingResult.discard();
					marker = marker.join(forkedMarker);
				}
				forkedMarker = null;
			}
			if (result == ConsumeResult.SUCCESS) {
				marker.flush();
				while(doConsume(true)==ConsumeResult.SUCCESS) {
					marker.flush();
				}
				marker.rollback();
				skipped(this);
				return ConsumeResult.SUCCESS;
			}
			error("Could not find token.", getElement());
			marker.commit();
			return result;
		}

	}

	protected abstract class MandatoryLoopGroupConsumer extends MandatoryLoopElementConsumer<Group> {

		private IElementConsumer[] consumers;

		protected MandatoryLoopGroupConsumer(Group element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeGroup(this, getConsumers(), optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}
	
	protected abstract class MandatoryLoopUnorderedGroupConsumer extends MandatoryLoopElementConsumer<UnorderedGroup> implements IFurtherParsable.Source<UnorderedGroupToken> {

		private IElementConsumer[] consumers;

		public MandatoryLoopUnorderedGroupConsumer(UnorderedGroup element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeUnorderedGroup(this, getConsumers(), this, optional);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}
		
		@Override
		public int parseFurther(IFurtherParsable<UnorderedGroupToken> token) throws Exception {
			final UnorderedGroupToken groupToken = token.getToken();
			return doConsumeUnorderedGroup(this, getConsumers(), this, groupToken.isOptional() /*, groupToken.getAlternative() + 1 */);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class MandatoryLoopAlternativesConsumer extends MandatoryLoopElementConsumer<Alternatives> implements IFurtherParsable.Source<AlternativesToken> {

		private IElementConsumer[] consumers;

		protected MandatoryLoopAlternativesConsumer(Alternatives element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAlternatives(this, getConsumers(), this, optional, 0);
		}

		protected final IElementConsumer[] getConsumers() {
			if (consumers == null) {
				ConsumerAcceptor acceptor = new ConsumerAcceptor();
				doGetConsumers(acceptor);
				consumers = acceptor.getResult();
			}
			return consumers;
		}

		@Override
		public int parseFurther(IFurtherParsable<AlternativesToken> token) throws Exception {
			final AlternativesToken alternativesToken = token.getToken();
			return doConsumeAlternatives(this, getConsumers(), this, alternativesToken.isOptional(), alternativesToken.getAlternative() + 1);
		}

		protected abstract void doGetConsumers(ConsumerAcceptor acceptor);
	}

	protected abstract class MandatoryLoopAssignmentConsumer extends MandatoryLoopElementConsumer<Assignment> {

		protected MandatoryLoopAssignmentConsumer(Assignment element) {
			super(element);
		}

		@Override
		protected final int doConsume(boolean optional) throws Exception {
			return doConsumeAssignment(this, getConsumer(), optional);
		}

		protected abstract IElementConsumer getConsumer();

	}

	protected class AbstractElementResult<Element extends AbstractElement> {

		private final ElementConsumer<Element> elementConsumer;

		protected AbstractElementResult(ElementConsumer<Element> elementConsumer) {
			this.elementConsumer = elementConsumer;
		}

		protected void error(String errorMessage) {
			NonTerminalConsumer.this.error(errorMessage, elementConsumer.getElement());
		}

	}

	protected class AlternativesResult extends AbstractElementResult<Alternatives> {
		private int bestResult;
		private int alternative;
		private IMarker bestMarker;
		private IMarker currentMarker;
		private final AlternativesToken begin;

		protected AlternativesResult(ElementConsumer<Alternatives> elementConsumer, AlternativesToken begin) {
			super(elementConsumer);
			alternative = -1;
			bestResult = ConsumeResult.SUCCESS;
			this.begin = begin;
			bestMarker = mark();
		}

		public void setAlternative(int alternative) {
			this.alternative = alternative;
		}

		public void nextAlternative() {
			alternative++;
			currentMarker = bestMarker.fork();
		}

		public void fakeNextAlternative() {
			currentMarker = bestMarker.fork();
		}

		public void reset() {
			bestResult = ConsumeResult.EMPTY_MATCH;
		}

		public int getResult() {
			bestMarker.commit();
			begin.setAlternative(alternative);
			getTokenAcceptor().accept(new AlternativesToken.End(getOffset(), alternative));
			return bestResult;
		}

		public boolean isAlternativeDone(int result) {
			if (result == ConsumeResult.SUCCESS || result > bestResult) {
				bestMarker = currentMarker.join(bestMarker);
				bestResult = result;
			} else {
				bestMarker = bestMarker.join(currentMarker);
			}
			currentMarker = null;
			return result == ConsumeResult.SUCCESS;
		}
	}
	
	protected class UnorderedGroupResult extends AbstractElementResult<UnorderedGroup> {
		private int result;
		private final IMarker marker;

		protected UnorderedGroupResult(ElementConsumer<UnorderedGroup> elementConsumer, UnorderedGroupToken begin) {
			super(elementConsumer);
			result = ConsumeResult.SUCCESS;
			marker = mark();
		}

		public void reset() {
			result = ConsumeResult.EMPTY_MATCH;
		}

		public int getResult() {
			marker.commit();
			getTokenAcceptor().accept(new UnorderedGroupToken.End(getOffset()));
			return result;
		}

		public boolean didGroupFail(int result) {
			this.result = result;
			return result != ConsumeResult.SUCCESS;
		}
	}

	protected class GroupResult extends AbstractElementResult<Group> {
		private int result;
		private final IMarker marker;

		protected GroupResult(ElementConsumer<Group> elementConsumer) {
			super(elementConsumer);
			result = ConsumeResult.SUCCESS;
			marker = mark();
		}

		public void reset() {
			result = ConsumeResult.EMPTY_MATCH;
		}

		public int getResult() {
			marker.commit();
			getTokenAcceptor().accept(new GroupToken.End(getOffset()));
			return result;
		}

		public boolean didGroupFail(int result) {
			this.result = result;
			return result != ConsumeResult.SUCCESS;
		}
	}

	protected class AssignmentResult extends AbstractElementResult<Assignment> {

		protected AssignmentResult(ElementConsumer<Assignment> elementConsumer) {
			super(elementConsumer);
		}

		public int getResult(int result) {
			getTokenAcceptor().accept(new AssignmentToken.End(getOffset()));
			return result;
		}

	}

	protected NonTerminalConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration.getInput(), configuration.getTokenAcceptor());
		this.markerFactory = configuration.getMarkerFactory();
		this.hiddenTokenHandler = configuration.getHiddenTokenHandler();
		this.consumerUtil = configuration.getConsumerUtil();
		this.hiddenTokens = hiddenTokens;
		this.backtracker = configuration.getBacktracker();
	}

	private AlternativesResult createAlternativesResult(ElementConsumer<Alternatives> alternativesConsumer,
			IFurtherParsable.Source<AlternativesToken> source, boolean optional, int totalAlternatives) {
		final AlternativesToken begin = new AlternativesToken(getOffset(), alternativesConsumer.getElement(), source, optional, totalAlternatives);
		getTokenAcceptor().accept(begin);
		return new AlternativesResult(alternativesConsumer, begin);
	}

	private GroupResult createGroupResult(ElementConsumer<Group> groupConsumer, boolean optional) {
		getTokenAcceptor().accept(new GroupToken(getOffset(), groupConsumer.getElement(), groupConsumer, optional));
		return new GroupResult(groupConsumer);
	}
	
	private UnorderedGroupResult createUnorderedGroupResult(ElementConsumer<UnorderedGroup> groupConsumer, 
			IFurtherParsable.Source<UnorderedGroupToken> source, boolean optional) {
		final UnorderedGroupToken begin = new UnorderedGroupToken(getOffset(), groupConsumer.getElement(), source, optional);
		getTokenAcceptor().accept(begin);
		return new UnorderedGroupResult(groupConsumer, begin);
	}

	private AssignmentResult createAssignmentResult(ElementConsumer<Assignment> assignmentConsumer, boolean optional) {
		getTokenAcceptor().accept(new AssignmentToken(getOffset(), assignmentConsumer.getElement(), assignmentConsumer, optional));
		return new AssignmentResult(assignmentConsumer);
	}

	public IBacktracker.IBacktrackingResult skipPreviousToken() {
		return backtracker.skipPreviousToken();
	}

	private <Type extends AbstractElement> void skipped(ElementConsumer<Type> consumer) {
		getTokenAcceptor().accept(new PlaceholderToken(getOffset(), consumer.getElement(), consumer, true));
	}

	@Override
	public boolean isDefiningHiddens() {
		return hiddenTokens != null;
	}

	@Override
	public int consume(final String feature, final boolean isMany, final boolean isDatatype, final boolean isBoolean,
			final AbstractElement grammarElement, final boolean optional) throws Exception {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		getTokenAcceptor().accept(new ParsedNonTerminal(getInput().getOffset(), grammarElement != null ? grammarElement : getGrammarElement(),
				getDefaultType(), new IParsedTokenSource(){
					@Override
					public int parseAgain(ParsedToken token) throws Exception {
						return consume(feature, isMany, isDatatype, isBoolean, grammarElement, optional);
					}
				}, optional));
		int result = doConsume();
		getTokenAcceptor().accept(new ParsedNonTerminalEnd(getInput().getOffset(), feature, isMany, isDatatype, isBoolean));
		marker.commit();
		prevState.restore();
		return result;
	}

	@Override
	public void consumeAsRoot(final IRootConsumerListener listener) {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		getTokenAcceptor().accept(new ParsedNonTerminal(getInput().getOffset(), getGrammarElement(),
				getDefaultType(), new IParsedTokenSource(){
					@Override
					public int parseAgain(ParsedToken token) throws Exception {
						throw new IllegalStateException("Cannot reparse root token");
					}
				}, false));
		listener.afterNonTerminalBegin(this, this);
		int result;
		try {
			result = doConsume();
		} catch(Exception e) {
			result = ConsumeResult.EXCEPTION;
			listener.handleException(this, e, this);
		}
		listener.beforeNonTerminalEnd(this, result, this);
		getTokenAcceptor().accept(new ParsedNonTerminalEnd(getInput().getOffset(), null, false, false, false));
		marker.commit();
		prevState.restore();
	}

	protected final IMarker mark() {
		return markerFactory.mark();
	}

	protected final void error(String message, AbstractElement grammarElement) {
		getTokenAcceptor().accept(new ErrorToken(getOffset(), 0, grammarElement, message));
	}

	protected final int consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean,
			ICharacterClass notFollowedBy, boolean optional) {
		return consumerUtil.consumeKeyword(keyword, feature, isMany, isBoolean, notFollowedBy, optional);
	}

	protected final int consumeEnum(EnumLiteralDeclaration literal, ICharacterClass notFollowedBy) {
		return consumerUtil.consumeEnum(literal, notFollowedBy);
	}

	protected final int consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany,
			boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching, boolean optional) {
		return consumerUtil.consumeTerminal(consumer, feature, isMany, isBoolean, grammarElement, notMatching, optional);
	}

	protected final int consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany,
			boolean isDatatype, boolean isBoolean, AbstractElement grammarElement, boolean optional) throws Exception {
		return consumerUtil.consumeNonTerminal(consumer, feature, isMany, isDatatype, isBoolean, grammarElement, optional);
	}

	protected final void consumeAction(Action action, boolean isMany) {
		consumerUtil.consumeAction(action, isMany);
	}

	protected abstract int doConsume() throws Exception;

	protected abstract EClassifier getDefaultType();

	protected abstract AbstractRule getGrammarElement();

	@Override
	public IConsumerUtility getConsumerUtil() {
		return consumerUtil;
	}

	@Override
	public IHiddenTokenHandler getHiddenTokenHandler() {
		return hiddenTokenHandler;
	}

	@Override
	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	@Override
	public IBacktracker getBacktracker() {
		return backtracker;
	}

	@Override
	public String toString() {
		return "NonTerminalConsumer " + getClass().getSimpleName() + " for type '" + getDefaultType()  + "'";
	}
}