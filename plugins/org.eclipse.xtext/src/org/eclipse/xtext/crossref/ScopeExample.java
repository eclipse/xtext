package org.eclipse.xtext.crossref;

// scope
import java.util.List;
import static java.util.Collections.emptyList;

public class ScopeExample { // scope
	private List field = emptyList();
	
	private void method(String param) { // scope
		String localVar = "bar";
		innerBlock: { // scope
			String innerScopeVar = "foo";
			Object field = innerScopeVar;
		}
		field.add(localVar);
	}
}
