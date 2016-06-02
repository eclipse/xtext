package org.eclipse.xpect.parameter;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xpect.XpectImport;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.XpectReplace;
import org.eclipse.xpect.expectation.impl.TargetSyntaxSupport;
import org.eclipse.xpect.runner.ArgumentContributor;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Configuration;
import org.eclipse.xpect.text.IRegion;
import org.eclipse.xpect.text.Region;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.NfaUtil.BacktrackHandler;
import org.eclipse.xtext.util.formallang.ProductionUtil;
import org.eclipse.xtext.util.formallang.StringProduction;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;
import org.junit.ComparisonFailure;

import com.google.common.collect.Maps;

@SuppressWarnings("restriction")
@XpectSetupFactory
@XpectReplace(ArgumentContributor.class)
@XpectImport({ StringProvider.class, IntegerProvider.class, OffsetProvider.class })
public class ParameterParserImpl extends ArgumentContributor {

	public static class AssignedProduction extends StringProduction {

		public AssignedProduction(String production) {
			super(production);
		}

		@Override
		protected ProdElement parsePrim(Stack<Pair<Token, String>> tokens) {
			Pair<Token, String> current = tokens.pop();
			switch (current.getFirst()) {
			case PL:
				ProdElement result1 = parseAlt(tokens);
				if (tokens.peek().getFirst().equals(Token.PR))
					tokens.pop();
				else
					throw new RuntimeException("')' expected, but " + tokens.peek().getFirst() + " found");
				parseCardinality(tokens, result1);
				return result1;
			case STRING:
				ProdElement result2 = createElement(ElementType.TOKEN);
				result2.setValue(current.getSecond());
				parseCardinality(tokens, result2);
				return result2;
			case ID:
				ProdElement result3 = createElement(ElementType.TOKEN);
				result3.setName(current.getSecond());
				Pair<Token, String> eq = tokens.pop();
				if (eq.getFirst() == Token.EQ) {
					Pair<Token, String> val = tokens.pop();
					switch (val.getFirst()) {
					case ID:
					case STRING:
						result3.setValue(val.getSecond());
						break;
					default:
						throw new RuntimeException("Unexpected token " + current.getFirst());
					}
				} else
					throw new RuntimeException("Unexpected token " + eq.getFirst() + ", expected '='");
				parseCardinality(tokens, result3);
				return result3;
			default:
				throw new RuntimeException("Unexpected token " + current.getFirst());
			}
		}
	}

	protected static class BacktrackItem {
		protected int offset;
		protected IRegion region;
		protected ProdElement token;

		public BacktrackItem(int offset) {
			super();
			this.offset = offset;
		}

		public BacktrackItem(int offset, ProdElement token, IRegion region) {
			super();
			this.offset = offset;
			this.token = token;
			this.region = region;
		}

		@Override
		public String toString() {
			return token + ":" + region;
		}
	}

	public enum Token {
		ID("[a-zA-Z][a-zA-Z0-9_]*"), // String
		INT("[0-9]+"), // Integer
		OFFSET("'([^']*)'|[^\\s]+"), // Integer, returns position of first occurrence of pattern below the test
		STRING("'([^']*)'"), // String, returns the string inside the quotes.
		TEXT("[^\\s]+"); // String, similar to ID but accepts more characters, i.e. anything that is not whitespace

		public final Pattern pattern;

		private Token(String regex) {
			this.pattern = Pattern.compile("^" + regex);
		}
	}

	protected static final Pattern WS = Pattern.compile("^[\\s]+");

	private final ParameterParser annotation;
	private final ParameterRegion parameterRegion;
	private final XpectInvocation statement;
	private final TargetSyntaxSupport syntax;

	public ParameterParserImpl(TargetSyntaxSupport syntax, XpectInvocation statement) {
		this.annotation = statement.getMethod().getJavaMethod().getAnnotation(ParameterParser.class);
		this.parameterRegion = statement.getRelatedRegion(ParameterRegion.class);
		this.statement = statement;
		this.syntax = syntax;
	}

	@Override
	public void contributeArguments(Configuration[] configurations) {
		if (annotation == null || Strings.isEmpty(annotation.syntax()))
			return;
		AssignedProduction syntax = new AssignedProduction(annotation.syntax());
		Map<String, IStatementRelatedRegion> parsed = parseParams(annotation.syntax(), syntax, statement, parameterRegion);
		Map<String, Token> defaults = getDefaults(syntax);
		for (int i = 0; i < configurations.length; i++) {
			String key = "arg" + i;
			IStatementRelatedRegion value = parsed.get(key);
			if (value != null) {
				configurations[i].addDefaultValue(value);
			} else {
				Token token = defaults.get(key);
				if (token != null) {
					IStatementRelatedRegion default1 = convertDefault(token);
					configurations[i].addDefaultValue(default1);
				}
			}
		}
	}

	protected Map<String, Token> getDefaults(AssignedProduction syntax) {
		Map<String, Token> result = Maps.newHashMap();
		for (ProdElement ele : new ProductionUtil().getAllChildren(syntax, syntax.getRoot())) {
			String name = ele.getName();
			if (!Strings.isEmpty(name))
				result.put(name, Token.valueOf(ele.getValue()));
		}
		return result;
	}

	protected IStatementRelatedRegion convertDefault(Token token) {
		switch (token) {
		case OFFSET:
			int offset = syntax.findFirstSemanticCharAfterStatement(statement);
			return new OffsetRegion(parameterRegion, offset);
		case INT:
			return new IntegerRegion(parameterRegion);
		case STRING:
		case TEXT:
		case ID:
			return new StringRegion(parameterRegion);
		}
		throw new RuntimeException();
	}

	protected IStatementRelatedRegion convertValue(XpectInvocation invocation, Token token, IRegion claim, IRegion match) {
		switch (token) {
		case OFFSET:
			return new OffsetRegion(parameterRegion, claim.getOffset() + match.getOffset(), match.getLength());
		case INT:
			return new IntegerRegion(parameterRegion, claim.getOffset() + match.getOffset(), match.getLength());
		case STRING:
		case TEXT:
		case ID:
			return new StringRegion(parameterRegion, claim.getOffset() + match.getOffset(), match.getLength());
		}
		throw new RuntimeException();
	}

	public ParameterParser getAnnotation() {
		return annotation;
	}

	protected Nfa<ProdElement> getParameterNfa(AssignedProduction prod) {
		FollowerFunctionImpl<ProdElement, String> ff = new FollowerFunctionImpl<ProdElement, String>(prod);
		ProdElement start = prod.new ProdElement(StringProduction.ElementType.TOKEN);
		ProdElement stop = prod.new ProdElement(StringProduction.ElementType.TOKEN);
		Nfa<ProdElement> result = new NfaUtil().create(prod, ff, start, stop);
		return result;
	}

	protected Map<String, IStatementRelatedRegion> parseParams(String syntax, AssignedProduction production, XpectInvocation invocation, IRegion claim) {
		String document = invocation.getFile().getDocument();
		final String text = document.substring(claim.getOffset(), claim.getOffset() + claim.getLength());
		Nfa<ProdElement> nfa = getParameterNfa(production);
		Matcher ws = WS.matcher(text);
		List<ParameterParserImpl.BacktrackItem> trace = new NfaUtil().backtrack(nfa, new BacktrackItem(ws.find() ? ws.end() : 0),
				new BacktrackHandler<ProdElement, ParameterParserImpl.BacktrackItem>() {
					public ParameterParserImpl.BacktrackItem handle(ProdElement state, ParameterParserImpl.BacktrackItem previous) {
						if (Strings.isEmpty(state.getValue()))
							return new BacktrackItem(previous.offset, state, new Region(text, previous.offset, 0));
						if (Strings.isEmpty(state.getName())) {
							if (text.regionMatches(previous.offset, state.getValue(), 0, state.getValue().length())) {
								int newOffset = previous.offset + state.getValue().length();
								Matcher ws = WS.matcher(text).region(newOffset, text.length());
								int childOffset = ws.find() ? ws.end() : newOffset;
								return new BacktrackItem(childOffset, state, new Region(text, previous.offset, state.getValue().length()));
							}
						} else {
							Token t = Token.valueOf(state.getValue());
							Matcher matcher = t.pattern.matcher(text).region(previous.offset, text.length());
							if (matcher.find()) {
								Matcher ws = WS.matcher(text).region(matcher.end(), text.length());
								int childOffset = ws.find() ? ws.end() : matcher.end();
								int start, end;
								if (matcher.groupCount() > 0 && matcher.group(1) != null) {
									start = matcher.start(1);
									end = matcher.end(1);
								} else {
									start = matcher.start(0);
									end = matcher.end(0);
								}
								return new BacktrackItem(childOffset, state, new Region(text, start, end - start));
							}
						}
						return null;
					}

					public boolean isSolution(ParameterParserImpl.BacktrackItem result) {
						return true;
					}

					public Iterable<ProdElement> sortFollowers(ParameterParserImpl.BacktrackItem result, Iterable<ProdElement> followers) {
						return followers;
					}
				});
		Map<String, IStatementRelatedRegion> result = Maps.newHashMap();
		String trimmed = text.trim();
		if (trace != null && !trace.isEmpty()) {
			IRegion last = trace.get(trace.size() - 1).region;
			int end = last.getOffset() + last.getLength();
			if (end < claim.getLength()) {
				String trailing = text.substring(end).trim();
				if (!trailing.isEmpty())
					errorLeftoverTrailingText(claim, end, trailing, syntax);
			}
			for (ParameterParserImpl.BacktrackItem item : trace) {
				if (item.token != null && item.token.getName() != null) {
					String key = item.token.getName();
					Token token = Token.valueOf(item.token.getValue());
					result.put(key, convertValue(invocation, token, claim, item.region));
				}
			}
			return result;
		}
		if (trimmed.isEmpty())
			throw new RuntimeException("Parameters that match syntax \"" + syntax + "\" are required, but have not been provided.");
		throw new RuntimeException("could not parse \"" + trimmed + "\" with grammar \"" + syntax + "\"");
	}

	protected void errorLeftoverTrailingText(IRegion claim, int offset, String leftover, String syntax) {
		String expected = claim.getDocument().toString();
		String actual = expected.substring(0, claim.getOffset() + offset) + expected.substring(claim.getOffset() + claim.getLength());
		String text = claim.getRegionText().trim();
		String msg = "When parsing \"" + text + "\" with syntax \"" + syntax + "\", the trailing part \"" + leftover + "\" remains unmatched.";
		throw new ComparisonFailure(msg, expected, actual);
	}
}