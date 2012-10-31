package org.xpect.parameters;

import org.eclipse.xtext.util.Exceptions;
import org.xpect.parameters.ActualCollection.ActualItem;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ActualCollection extends StringCollection<ActualItem> {

	public static class ToString implements Function<Object, String> {
		public String apply(Object from) {
			return from == null ? "null" : from.toString();
		}
	}

	public class ActualItem extends StringCollection<ActualItem>.Item {
		public ActualItem(String pure) {
			super(pure);
		}
	}

	public void init(String... actual) {
		items = createCollection();
		for (String obj : actual)
			items.add(new ActualItem(obj));
	}

	public void init(Iterable<?> actual, Class<? extends Function<Object, String>> functionClass) {
		items = createCollection();
		try {
			Function<Object, String> func = functionClass.newInstance();
			for (Object obj : actual)
				items.add(new ActualItem(func.apply(obj)));
		} catch (InstantiationException e) {
			Exceptions.throwUncheckedException(e);
		} catch (IllegalAccessException e) {
			Exceptions.throwUncheckedException(e);
		}
	}
}
