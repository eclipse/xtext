/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IConsumerUtility {

	int consumeKeyword(Keyword keyword, String feature, boolean isMany,
			boolean isBoolean, ICharacterClass notFolledBy, boolean optional);

	int consumeTerminal(ITerminalConsumer consumer, String feature,
			boolean isMany, boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching, boolean optional);

	int consumeNonTerminal(INonTerminalConsumer consumer, String feature,
			boolean isMany, boolean isDatatype, boolean isBoolean, AbstractElement grammarElement, boolean optional) throws Exception;

	void consumeAction(Action action, boolean isMany);

	int consumeEnum(EnumLiteralDeclaration literal, ICharacterClass notFollowedBy);
}
