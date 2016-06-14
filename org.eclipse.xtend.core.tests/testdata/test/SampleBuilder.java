/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SampleBuilder {

	public static class Root {
		public String name;
		public Parent parent;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((parent == null) ? 0 : parent.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Root other = (Root) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (parent == null) {
				if (other.parent != null)
					return false;
			} else if (!parent.equals(other.parent))
				return false;
			return true;
		}
	}
	public static class Parent {
		public String name;
		public Child child;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((child == null) ? 0 : child.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Parent other = (Parent) obj;
			if (child == null) {
				if (other.child != null)
					return false;
			} else if (!child.equals(other.child))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}
	public static class Child {
		public String name;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Child other = (Child) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}
	
	public Root root(Procedures.Procedure1<? super Root> init) {
		Root result = new Root();
		init.apply(result);
		return result;
	}
	
	public Parent parent(Root root, Procedures.Procedure1<? super Parent> init) {
		Parent result = new Parent();
		root.parent = result;
		init.apply(result);
		return result;
	}
	
	public Child child(Parent parent, Procedures.Procedure1<? super Child> init) {
		Child result = new Child();
		parent.child = result;
		init.apply(result);
		return result;
	}
	
	public static Root staticRoot(Procedures.Procedure1<? super Root> init) {
		Root result = new Root();
		init.apply(result);
		return result;
	}
	
	public static Parent staticParent(Root root, Procedures.Procedure1<? super Parent> init) {
		Parent result = new Parent();
		root.parent = result;
		init.apply(result);
		return result;
	}
	
	public static Child staticChild(Parent parent, Procedures.Procedure1<? super Child> init) {
		Child result = new Child();
		parent.child = result;
		init.apply(result);
		return result;
	}
	
}
