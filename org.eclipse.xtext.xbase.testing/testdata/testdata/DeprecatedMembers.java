/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package testdata;

/**
 * @author Stéphane Galland - Initial contribution and API
 */
public class DeprecatedMembers {

	@Deprecated
	public int deprecatedField;
	
	public float nodeprecatedField;

	@Deprecated
	public static String deprecatedStaticField;
	
	public static String nodeprecatedStaticField;

	@Deprecated
	public DeprecatedMembers(int a) {
		this.deprecatedField = a;
	}
	
	public DeprecatedMembers(float a) {
		this.nodeprecatedField = a;
	}
	
	@Deprecated
	public void deprecatedFunction(@SuppressWarnings("unused") String[] arg) {
	}

	public void nodeprecatedFunction() {
	}

	@Deprecated
	public static void deprecatedStaticFunction(@SuppressWarnings("unused") String... arg) {
	}

	public static void nodeprecatedStaticFunction() {
	}

	public static class InnerMember1 {

		@Deprecated
		public int deprecatedField;
		
		public float nodeprecatedField;

		@Deprecated
		public static String deprecatedStaticField;
		
		public static String nodeprecatedStaticField;

		@Deprecated
		public InnerMember1(int a) {
			this.deprecatedField = a;
		}
		
		public InnerMember1(float a) {
			this.nodeprecatedField = a;
		}
		
		@Deprecated
		public void deprecatedFunction() {
		}

		public void nodeprecatedFunction() {
		}

		@Deprecated
		public static void deprecatedStaticFunction() {
		}

		public static void nodeprecatedStaticFunction() {
		}

		public static class InnerMember11 {

			@Deprecated
			public int deprecatedField;
			
			public float nodeprecatedField;

			@Deprecated
			public static String deprecatedStaticField;
			
			public static String nodeprecatedStaticField;

			@Deprecated
			public InnerMember11(int a) {
				this.deprecatedField = a;
			}
			
			public InnerMember11(float a) {
				this.nodeprecatedField = a;
			}
			
			@Deprecated
			public void deprecatedFunction() {
			}

			public void nodeprecatedFunction() {
			}

			@Deprecated
			public static void deprecatedStaticFunction() {
			}

			public static void nodeprecatedStaticFunction() {
			}

		}

		@Deprecated
		public static class InnerMember12 {

			@Deprecated
			public int deprecatedField;
			
			public float nodeprecatedField;

			@Deprecated
			public static String deprecatedStaticField;
			
			public static String nodeprecatedStaticField;

			@Deprecated
			public InnerMember12(int a) {
				this.deprecatedField = a;
			}
			
			public InnerMember12(float a) {
				this.nodeprecatedField = a;
			}
			
			@Deprecated
			public void deprecatedFunction() {
			}

			public void nodeprecatedFunction() {
			}

			@Deprecated
			public static void deprecatedStaticFunction() {
			}

			public static void nodeprecatedStaticFunction() {
			}

		}
	}

	@Deprecated
	public static class InnerMember2 {

		@Deprecated
		public int deprecatedField;
		
		public float nodeprecatedField;

		@Deprecated
		public static String deprecatedStaticField;
		
		public static String nodeprecatedStaticField;

		@Deprecated
		public InnerMember2(int a) {
			this.deprecatedField = a;
		}
		
		public InnerMember2(float a) {
			this.nodeprecatedField = a;
		}
		
		@Deprecated
		public void deprecatedFunction() {
		}

		public void nodeprecatedFunction() {
		}

		@Deprecated
		public static void deprecatedStaticFunction() {
		}

		public static void nodeprecatedStaticFunction() {
		}

		public static class InnerMember21 {

			@Deprecated
			public int deprecatedField;
			
			public float nodeprecatedField;

			@Deprecated
			public static String deprecatedStaticField;
			
			public static String nodeprecatedStaticField;

			@Deprecated
			public InnerMember21(int a) {
				this.deprecatedField = a;
			}
			
			public InnerMember21(float a) {
				this.nodeprecatedField = a;
			}
			
			@Deprecated
			public void deprecatedFunction() {
			}

			public void nodeprecatedFunction() {
			}

			@Deprecated
			public static void deprecatedStaticFunction() {
			}

			public static void nodeprecatedStaticFunction() {
			}

		}

		@Deprecated
		public static class InnerMember22 {

			@Deprecated
			public int deprecatedField;
			
			public float nodeprecatedField;

			@Deprecated
			public static String deprecatedStaticField;
			
			public static String nodeprecatedStaticField;

			@Deprecated
			public InnerMember22(int a) {
				this.deprecatedField = a;
			}
			
			public InnerMember22(float a) {
				this.nodeprecatedField = a;
			}
			
			@Deprecated
			public void deprecatedFunction() {
			}

			public void nodeprecatedFunction() {
			}

			@Deprecated
			public static void deprecatedStaticFunction() {
			}

			public static void nodeprecatedStaticFunction() {
			}

		}
	}
}
