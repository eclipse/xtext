/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TraceRegionMergerTest {
	public static class TestBuilder {
		private List<AbstractTraceRegion> roots = new ArrayList<>();

		public TestBuilder traceTo(String uri, Function1<? super TraceBuilder, ? extends AbstractTraceRegion> init) {
			TraceBuilder traceBuilder = new TraceBuilder(this, uri);
			roots.add(init.apply(traceBuilder));
			return this;
		}

		public void assertMerged(Procedure1<? super AssertBuilder> init) {
			AbstractTraceRegion mergedRoot = new TraceRegionMerger().mergeTraceRegions(roots);
			Assert.assertNotNull(mergedRoot);
			AssertBuilder assertBuilder = new AssertBuilder(this, Lists.newLinkedList(Arrays.asList(mergedRoot)));
			init.apply(assertBuilder);
			assertBuilder.thatsIt();
		}

		public List<AbstractTraceRegion> getRoots() {
			return roots;
		}

		public void setRoots(List<AbstractTraceRegion> roots) {
			this.roots = roots;
		}
	}

	public static class TraceBuilder {
		private final TestBuilder testBuilder;

		private final SourceRelativeURI uri;

		private final AbstractTraceRegion root;

		public TraceBuilder(TestBuilder testBuilder, String uri) {
			this(testBuilder, new SourceRelativeURI(URI.createURI(uri)), null);
		}

		public AbstractTraceRegion region(int offset, int length, int startLine, int endLine) {
			return region(offset, length, startLine, endLine, null);
		}

		public AbstractTraceRegion region(int offset, int length, int startLine, int endLine,
				Procedure1<? super TraceBuilder> init) {
			TraceRegion root = new TraceRegion(offset, length, startLine, endLine, true, 0, 0, 0, 0, this.root, uri);
			if (init != null) {
				TraceBuilder child = new TraceBuilder(testBuilder, uri, root);
				init.apply(child);
			}
			return root;
		}

		public TraceBuilder(TestBuilder testBuilder, SourceRelativeURI uri, AbstractTraceRegion root) {
			this.testBuilder = testBuilder;
			this.uri = uri;
			this.root = root;
		}
	}

	public static class AssertBuilder {
		private final TestBuilder testBuilder;

		private final Queue<AbstractTraceRegion> regions;

		public AssertBuilder region(int offset, int length, int startLine, int endLine, String... uris) {
			return region(offset, length, startLine, endLine, Arrays.asList(uris), null);
		}

		public AssertBuilder region(int offset, int length, int startLine, int endLine, String uri,
				Procedure1<? super AssertBuilder> init) {
			return region(offset, length, startLine, endLine, Lists.newArrayList(uri), null);
		}

		public AssertBuilder region(int offset, int length, int startLine, int endLine,
				Procedure1<? super AssertBuilder> init) {
			return region(offset, length, startLine, endLine, new ArrayList<>(), init);
		}

		public AssertBuilder region(int offset, int length, int startLine, int endLine, List<String> uris,
				Procedure1<? super AssertBuilder> init) {
			AbstractTraceRegion head = regions.poll();
			Assert.assertEquals(head.toString(), offset, head.getMyOffset());
			Assert.assertEquals(head.toString(), length, head.getMyLength());
			Assert.assertEquals(head.toString(), startLine, head.getMyLineNumber());
			Assert.assertEquals(head.toString(), endLine, head.getMyEndLineNumber());
			Set<SourceRelativeURI> associatedLocations = IterableExtensions.toSet(
					Lists.transform(head.getAssociatedLocations(), (ILocationData it) -> it.getSrcRelativePath()));
			Assert.assertEquals(head.toString(), uris.size(), associatedLocations.size());
			for (String uri : uris) {
				Assert.assertTrue("Missing " + uri,
						associatedLocations.contains(new SourceRelativeURI(URI.createURI(uri))));
			}
			if (init == null) {
				Assert.assertTrue(head.getNestedRegions().isEmpty());
			} else {
				AssertBuilder child = new AssertBuilder(testBuilder, Lists.newLinkedList(head.getNestedRegions()));
				init.apply(child);
				child.thatsIt();
			}
			return this;
		}

		public void thatsIt() {
			Assert.assertTrue(regions.toString(), regions.isEmpty());
		}

		public AssertBuilder(TestBuilder testBuilder, Queue<AbstractTraceRegion> regions) {
			this.testBuilder = testBuilder;
			this.regions = regions;
		}
	}

	@Test
	public void testSingleFile() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(2, 6, 1, 3, (TraceBuilder it) -> {
				it.region(2, 2, 1, 2);
				it.region(4, 2, 2, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(2, 6, 1, 3, (AssertBuilder it) -> {
				it.region(2, 2, 1, 2, "foo");
				it.region(4, 2, 2, 2, "foo");
				it.region(6, 2, 2, 3, "foo");
			});
		});
	}

	@Test
	public void testSame() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 4, 0, 2, (TraceBuilder it) -> {
				it.region(0, 2, 0, 1);
				it.region(2, 2, 1, 2);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(0, 4, 0, 2, (TraceBuilder it) -> {
				it.region(0, 2, 0, 1);
				it.region(2, 2, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 4, 0, 2, (AssertBuilder it) -> {
				it.region(0, 2, 0, 1, "foo", "bar");
				it.region(2, 2, 1, 2, "foo", "bar");
			});
		});
	}

	@Test
	public void testDisjunctive() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 2, 0, 1, (TraceBuilder it) -> {
				it.region(0, 2, 0, 1);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(2, 2, 1, 2, (TraceBuilder it) -> {
				it.region(2, 2, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 4, 0, 2, (AssertBuilder it) -> {
				it.region(0, 2, 0, 1, "foo");
				it.region(2, 2, 1, 2, "bar");
			});
		});
	}

	@Test
	public void testOneInCommon() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 4, 0, 2, (TraceBuilder it) -> {
				it.region(0, 2, 0, 1);
				it.region(2, 2, 1, 2);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(2, 2, 1, 2, (TraceBuilder it) -> {
				it.region(2, 2, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 4, 0, 2, (AssertBuilder it) -> {
				it.region(0, 2, 0, 1, "foo");
				it.region(2, 2, 1, 2, "foo", "bar");
			});
		});
	}

	@Test
	public void testSplit() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(2, 6, 1, 3, (TraceBuilder it) -> {
				it.region(2, 2, 1, 2);
				it.region(4, 2, 2, 2);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(0, 3, 0, 1);
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 8, 0, 3, (AssertBuilder it) -> {
				it.region(0, 2, 0, 1, "bar");
				it.region(2, 1, 1, 1, "foo", "bar");
				it.region(3, 1, 1, 2, "foo");
				it.region(4, 2, 2, 2, "foo");
				it.region(6, 2, 2, 3, "foo");
			});
		});
	}

	@Test
	public void testContainedSplitBeforeNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 6, 0, 2);
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(2, 2, 0, 1);
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 6, 0, 2, (AssertBuilder it) -> {
				it.region(0, 2, 0, 0, "foo");
				it.region(2, 2, 0, 1, "foo", "bar");
				it.region(4, 2, 1, 2, "foo");
			});
		});
	}

	@Test
	public void testContainedSplitAfterNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 6, 0, 2);
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(3, 2, 1, 1);
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 6, 0, 2, (AssertBuilder it) -> {
				it.region(0, 3, 0, 1, "foo");
				it.region(3, 2, 1, 1, "foo", "bar");
				it.region(5, 1, 1, 2, "foo");
			});
		});
	}

	@Test
	public void testOverlapSplitBeforeNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 4, 0, 1);
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(2, 4, 0, 2);
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 6, 0, 2, (AssertBuilder it) -> {
				it.region(0, 2, 0, 0, "foo");
				it.region(2, 2, 0, 1, "foo", "bar");
				it.region(4, 2, 1, 2, "bar");
			});
		});
	}

	@Test
	public void testOverlapSplitAfterNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 4, 0, 1);
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(3, 3, 1, 2);
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 6, 0, 2, (AssertBuilder it) -> {
				it.region(0, 3, 0, 1, "foo");
				it.region(3, 1, 1, 1, "foo", "bar");
				it.region(4, 2, 1, 2, "bar");
			});
		});
	}

	@Test
	public void testOverlapChain_SplitAfterNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 9, 0, 3, (TraceBuilder it) -> {
				it.region(0, 3, 0, 1);
				it.region(3, 3, 1, 2);
				it.region(6, 3, 2, 3);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(1, 6, 0, 2, (TraceBuilder it) -> {
				it.region(1, 3, 0, 1);
				it.region(4, 3, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 9, 0, 3, (AssertBuilder it) -> {
				it.region(0, 1, 0, 0, "foo");
				it.region(1, 2, 0, 1, "foo", "bar");
				it.region(3, 1, 1, 1, "foo", "bar");
				it.region(4, 2, 1, 2, "foo", "bar");
				it.region(6, 1, 2, 2, "foo", "bar");
				it.region(7, 2, 2, 3, "foo");
			});
		});
	}

	@Test
	public void testOverlapChain_SplitBeforeNewline() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 9, 0, 3, (TraceBuilder it) -> {
				it.region(0, 3, 0, 1);
				it.region(3, 3, 1, 2);
				it.region(6, 3, 2, 3);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(2, 6, 0, 2, (TraceBuilder it) -> {
				it.region(2, 3, 0, 1);
				it.region(5, 3, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 9, 0, 3, (AssertBuilder it) -> {
				it.region(0, 2, 0, 0, "foo");
				it.region(2, 1, 0, 1, "foo", "bar");
				it.region(3, 2, 1, 1, "foo", "bar");
				it.region(5, 1, 1, 2, "foo", "bar");
				it.region(6, 2, 2, 2, "foo", "bar");
				it.region(8, 1, 2, 3, "foo");
			});
		});
	}

	@Test
	public void testThree() {
		traceTo("foo", (TraceBuilder t) -> {
			return t.region(0, 9, 0, 3, (TraceBuilder it) -> {
				it.region(0, 3, 0, 1);
				it.region(3, 3, 1, 2);
				it.region(6, 3, 2, 3);
			});
		}).traceTo("bar", (TraceBuilder t) -> {
			return t.region(1, 6, 0, 2, (TraceBuilder it) -> {
				it.region(1, 3, 0, 1);
				it.region(4, 3, 1, 2);
			});
		}).traceTo("baz", (TraceBuilder t) -> {
			return t.region(2, 6, 0, 2, (TraceBuilder it) -> {
				it.region(2, 3, 0, 1);
				it.region(5, 3, 1, 2);
			});
		}).assertMerged((AssertBuilder a) -> {
			a.region(0, 9, 0, 3, (AssertBuilder it) -> {
				it.region(0, 1, 0, 0, "foo");
				it.region(1, 1, 0, 0, "foo", "bar");
				it.region(2, 1, 0, 1, "foo", "bar", "baz");
				it.region(3, 1, 1, 1, "foo", "bar", "baz");
				it.region(4, 1, 1, 1, "foo", "bar", "baz");
				it.region(5, 1, 1, 2, "foo", "bar", "baz");
				it.region(6, 1, 2, 2, "foo", "bar", "baz");
				it.region(7, 1, 2, 2, "foo", "baz");
				it.region(8, 1, 2, 3, "foo");
			});
		});
	}

	public TestBuilder traceTo(String uri, Function1<? super TraceBuilder, ? extends AbstractTraceRegion> init) {
		return new TestBuilder().traceTo(uri, init);
	}
}
