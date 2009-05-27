/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholt
 */
public interface IParseTreeConstructor {

	public IAbstractToken serialize(EObject object);

	public interface IAbstractToken {
		public AbstractElement getGrammarElement();

		public IInstanceDescription getCurrent();

		public IAbstractToken getNext();
		
		// TODO: enable getters below

		// public String getDiagnostic();

		// public int getNo();

		// public IAbstractToken2 getParent();
	}

	public interface IValueToken extends IAbstractToken {
		public Object getValue();
	}

	public interface IActionToken extends IAbstractToken {
		public Action getGrammarElement();
	}

	public interface IAlternativeesToken extends IAbstractToken {
		public Alternatives getGrammarElement();
	}

	public enum AssignmentType {
		KW, PRC, LRC, ERC, CR
	}

	public interface IAssignmentToken extends IValueToken {
		public AssignmentType getType();

		public Assignment getGrammarElement();

		public AbstractElement getAssignmentElement();
	}

	public interface IGroupToken extends IAbstractToken {
		public Group getGrammarElement();
	}

	public interface IKeywordToken extends IAbstractToken {
		public Keyword getGrammarElement();
	}

	public interface IRuleCallToken extends IAbstractToken {
		public RuleCall getGrammarElement();
	}
	
	public interface IUnassignedTextToken extends IAbstractToken {
		public RuleCall getGrammarElement();
	}
}
