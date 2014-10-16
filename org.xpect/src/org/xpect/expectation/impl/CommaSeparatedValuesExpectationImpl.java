package org.xpect.expectation.impl;

import java.util.Collection;

import org.eclipse.xtext.util.Pair;
import org.junit.ComparisonFailure;
import org.xpect.XpectArgument;
import org.xpect.XpectImport;
import org.xpect.expectation.CommaSeparatedValuesExpectation;
import org.xpect.expectation.ICommaSeparatedValuesExpectation;
import org.xpect.expectation.impl.ActualCollection.ActualItem;
import org.xpect.expectation.impl.ExpectationCollection.ExpectationItem;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.text.Text;

import com.google.common.base.Predicate;

@XpectSetupFactory
@XpectImport(ExpectationRegionProvider.class)
public class CommaSeparatedValuesExpectationImpl extends AbstractExpectation implements ICommaSeparatedValuesExpectation {
	private final CommaSeparatedValuesExpectation annotation;

	public CommaSeparatedValuesExpectationImpl(XpectArgument argument, TargetSyntaxSupport syntax) {
		super(argument, syntax);
		this.annotation = argument.getAnnotationOrDefault(CommaSeparatedValuesExpectation.class);
	}

	public void assertEquals(Iterable<?> actual) {
		assertEquals(actual, null);
	}

	public void assertEquals(Iterable<?> actual, Predicate<String> predicate) {
		ExpectationCollection exp = new ExpectationCollection();
		exp.setCaseSensitive(annotation.caseSensitive());
		exp.setOrdered(annotation.ordered());
		exp.setQuoted(annotation.quoted());
		exp.setSeparator(',');
		exp.setWhitespaceSensitive(annotation.whitespaceSensitive());
		exp.init(getExpectation());

		ActualCollection act = new ActualCollection();
		act.setTargetLiteralSupport(getTargetSyntaxLiteral());
		act.setCaseSensitive(annotation.caseSensitive());
		act.setOrdered(annotation.ordered());
		act.setQuoted(annotation.quoted());
		act.setSeparator(',');
		act.setWhitespaceSensitive(annotation.whitespaceSensitive());
		if (actual != null && predicate != null) {
			if (exp.isWildcard())
				act.init(exp.applyPredicate(predicate), annotation.itemFormatter());
			else
				act.init(actual, annotation.itemFormatter());
		} else if (predicate != null)
			act.init(exp.applyPredicate(predicate), annotation.itemFormatter());
		else if (actual != null)
			act.init(actual, annotation.itemFormatter());
		else
			throw new NullPointerException();

		String nl = new Text(this.getRegion().getDocument()).getNL();
		if (!exp.matches(act)) {
			StringBuilder expString = new StringBuilder();
			StringBuilder actString = new StringBuilder();
			boolean expWrap = false;
			boolean expEmpty = false;
			boolean actWrap = false;
			int lineLength = 0, lineCount = 0;
			for (Pair<Collection<ExpectationItem>, ActualItem> pair : exp.map(act)) {
				String expItem = null;
				String actItem = null;
				if (pair.getFirst() != null && !pair.getFirst().isEmpty()) {
					if (pair.getSecond() != null)
						expItem = pair.getSecond().getEscaped();
					else
						expItem = pair.getFirst().iterator().next().getEscaped();
				} else {
					if (pair.getSecond() != null)
						expItem = str(pair.getSecond().getEscaped().length());
				}
				if (pair.getSecond() != null) {
					actItem = pair.getSecond().getEscaped();
					lineCount++;
					lineLength += actItem.length() + 2;
					boolean count = annotation.maxItemsPerLine() > 0 && lineCount > annotation.maxItemsPerLine();
					boolean width = annotation.maxLineWidth() > 0 && lineLength > annotation.maxLineWidth();
					if (count || width)
						expWrap = actWrap = true;
				}
				if (expItem != null && expString.length() > 0) {
					if (expWrap) {
						expString.append(expEmpty ? nl : "," + nl);
						expWrap = false;
					} else
						expString.append(expEmpty ? "  " : ", ");
				}
				if (actItem != null && actString.length() > 0) {
					if (actWrap) {
						actString.append("," + nl);
						actWrap = false;
						lineCount = 0;
						lineLength = 0;
					} else
						actString.append(", ");
				}
				if (expItem != null) {
					expString.append(expItem);
					expEmpty = expItem.trim().length() == 0;
				}
				if (actItem != null)
					actString.append(actItem);
			}
			String expDoc = replaceInDocument(expString.toString());
			String actDoc = replaceInDocument(actString.toString());
			throw new ComparisonFailure("", expDoc, actDoc);
		}
	}

	public void assertEquals(Predicate<String> predicate) {
		assertEquals(null, predicate);
	}

	@Creates
	public ICommaSeparatedValuesExpectation create() {
		return this;
	}

	public CommaSeparatedValuesExpectation getAnnotation() {
		return annotation;
	}

	protected String str(int length) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < length; i++)
			b.append(" ");
		return b.toString();
	}

}