package org.eclipse.xpect.util;

import static org.eclipse.xpect.util.IDifferencer.ISimilarityFunction.UPPER_SIMILARITY_BOUND;
import static org.eclipse.xpect.util.IDifferencer.MatchKind.EQUAL;
import static org.eclipse.xpect.util.IDifferencer.MatchKind.LEFT_ONLY;
import static org.eclipse.xpect.util.IDifferencer.MatchKind.RIGHT_ONLY;
import static org.eclipse.xpect.util.IDifferencer.MatchKind.SIMILAR;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.xpect.text.Table;
import org.eclipse.xpect.text.Table.Column;
import org.eclipse.xpect.text.Table.Row;

import com.google.common.base.Preconditions;

public class DifferencerImpl implements IDifferencer {

	private enum Direction {
		BACKWARD, FORWARD
	}

	private static class DirectionState {
		private final Direction direction;

		private final State<?> state;

		public DirectionState(State<?> state, Direction direction) {
			super();
			this.state = state;
			this.direction = direction;
		}
	}

	private static class Match implements IDifferencer.Match, Comparable<Match> {
		private final float cost;
		private final DirectionState direction;
		private final MatchKind kind;
		private final int left;
		private final Match previous;
		private final int right;
		private final float similarity;

		public Match(DirectionState direction, int left, int right) {
			super();
			this.direction = direction;
			this.kind = MatchKind.EQUAL;
			this.previous = null;
			this.cost = 0.0f;
			this.similarity = 0.0f;
			this.left = left;
			this.right = right;
		}

		public Match(Match previous, MatchKind kind, int left, int right, float similarity) {
			super();
			// Preconditions.checkPositionIndex(Math.abs(previous.left - left), 1);
			// Preconditions.checkPositionIndex(Math.abs(previous.right - right), 1);
			this.direction = previous.direction;
			this.kind = kind;
			this.previous = previous;
			this.similarity = similarity;
			this.cost = previous.cost + similarity;
			this.left = left;
			this.right = right;
		}

		public int compareTo(Match o) {
			if (cost < o.cost)
				return -1;
			if (cost > o.cost)
				return 1;
			switch (kind) {
			case LEFT_ONLY:
				switch (o.kind) {
				case RIGHT_ONLY:
					return direction.direction == Direction.FORWARD ? -1 : 1;
				default:
				}
			case RIGHT_ONLY:
				switch (o.kind) {
				case LEFT_ONLY:
					return direction.direction == Direction.FORWARD ? 1 : -1;
				default:
				}
			default:
			}
			if (left < o.left)
				return -1;
			if (left > o.left)
				return 1;
			if (right < o.right)
				return -1;
			if (right > o.right)
				return 1;
			return 0;
		}

		public MatchKind getKind() {
			return kind;
		}

		public int getLeft() {
			if (kind == RIGHT_ONLY)
				return IDifferencer.Match.NO_INDEX;
			return left;
		}

		public int getRight() {
			if (kind == LEFT_ONLY)
				return IDifferencer.Match.NO_INDEX;
			return right;
		}

		public float getSimilarity() {
			switch (kind) {
			case EQUAL:
				return IDifferencer.Match.EQUAL;
			case LEFT_ONLY:
			case RIGHT_ONLY:
				return IDifferencer.Match.UNEQUAL;
			case SIMILAR:
				return similarity;
			}
			return 0;
		}

		@Override
		public String toString() {
			switch (kind) {
			case EQUAL:
				return "[" + left + "==" + right + "]";
			case LEFT_ONLY:
				return "[" + left + "---]";
			case RIGHT_ONLY:
				return "[---" + right + "]";
			case SIMILAR:
				return "[" + left + "~~" + right + "]";
			}
			return "(unknownKind)";
		}
	}

	private static class Solution<T> {
		private final Match backwardsEnd;
		private final float cost;
		private final Match forwardEnd;
		private final State<T> state;

		public Solution(State<T> state, Match match1, Match match2) {
			Preconditions.checkArgument(match1.direction.state == state);
			Preconditions.checkArgument(match2.direction.state == state);
			Preconditions.checkArgument(match1.direction != match2.direction);
			Preconditions.checkArgument(match1.left == match2.left);
			Preconditions.checkArgument(match1.right == match2.right);
			this.forwardEnd = match1.direction.direction == Direction.FORWARD ? match1 : match2;
			this.backwardsEnd = match1.direction.direction == Direction.FORWARD ? match2 : match1;
			this.cost = match1.cost + match2.cost;
			this.state = state;
		}

		private int getlastLeft(Match m) {
			return m.kind == RIGHT_ONLY ? getlastLeft(m.previous) : m.left;
		}

		private int getlastRight(Match m) {
			return m.kind == LEFT_ONLY ? getlastRight(m.previous) : m.right;
		}

		public boolean isBetterThan(Solution<T> o) {
			if (cost < o.cost)
				return true;
			if (cost > o.cost)
				return false;
			return false;
			// if (forwardEnd.left < o.forwardEnd.left)
			// return true;
			// if (forwardEnd.left > o.forwardEnd.left)
			// return false;
			// if (forwardEnd.right < o.forwardEnd.right)
			// return true;
			// if (forwardEnd.right > o.forwardEnd.right)
			// return false;
			// return false;
		}

		public List<IDifferencer.Match> toList() {
			List<IDifferencer.Match> result = new ToStrList(state.left, state.right);
			List<IDifferencer.Match> temp = new ArrayList<IDifferencer.Match>();
			for (Match m = forwardEnd; m.previous != null; m = m.previous)
				temp.add(m);
			for (int i = temp.size() - 1; i >= 0; i--)
				result.add(temp.get(i));
			int lastLeft = getlastLeft(forwardEnd);
			int lastRight = getlastRight(forwardEnd);
			for (Match m = backwardsEnd; m.previous != null; m = m.previous)
				switch (m.kind) {
				case LEFT_ONLY:
					if (m.left > lastLeft)
						result.add(m);
					break;
				case RIGHT_ONLY:
					if (m.right > lastRight)
						result.add(m);
					break;
				default:
					if (m.left > lastLeft && m.right > lastRight)
						result.add(m);
					else if (m.left > lastLeft)
						result.add(new Match(m.previous, MatchKind.LEFT_ONLY, m.left, IDifferencer.Match.NO_INDEX, m.similarity));
					else if (m.right > lastRight)
						result.add(new Match(m.previous, MatchKind.RIGHT_ONLY, IDifferencer.Match.NO_INDEX, m.right, m.similarity));
					break;
				}
			return result;
		}

		@Override
		public String toString() {
			return toList().toString();
		}

	}

	private static class State<T> {
		private final List<T> left;
		private final List<T> right;
		private TreeSet<Match> unvisited = new TreeSet<Match>();
		private final HashMap<Long, Match> visited = new HashMap<Long, Match>();

		public State(List<T> left, List<T> right) {
			super();
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return format(left, right, unvisited);
		}
	}

	@SuppressWarnings("serial")
	private static class ToStrList extends ArrayList<IDifferencer.Match> {
		private final List<?> left;
		private final List<?> right;

		private ToStrList(List<?> left, List<?> right) {
			super();
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return format(left, right, this);
		}
	}

	private static String format(List<?> left, List<?> right, Collection<?> matches) {
		Table table = new Table();
		table.setMaxCellWidth(5);
		table.setRowSeparatorHeight(0);
		table.setSeparatorCrossingBackground("+");
		Row topHeader = table.getRow(0);
		Row topIndex = table.getRow(1);
		topIndex.getBottomSeparator().setBackground("-").setHeight(1);
		topIndex.getCell(2).setText("-1");
		for (int i = 0; i < right.size(); i++) {
			topHeader.getCell(i + 3).setText(right.get(i));
			topIndex.getCell(i + 3).setText(i);
		}
		Column leftHeader = table.getColumn(0);
		Column leftIndex = table.getColumn(1);
		// leftHeader.getRightSeparator().setWidth(0);
		leftIndex.getRightSeparator().setBackground("|");
		leftIndex.getCell(2).setText("-1");
		for (int i = 0; i < left.size(); i++) {
			leftHeader.getCell(i + 3).setText(left.get(i));
			leftIndex.getCell(i + 3).setText(i);
		}
		for (Object o : matches) {
			Match match = (Match) o;
			String dir = String.valueOf(match.direction.direction.name().charAt(0));
			table.getCell(match.left + 3, match.right + 3).setText(match.cost + dir);
		}
		return table.toString();
	}

	public <T> List<IDifferencer.Match> diff(List<T> left, List<T> right, ISimilarityFunction<? super T> similarityFunction) {
		State<T> state = new State<T>(left, right);
		DirectionState forward = new DirectionState(state, Direction.FORWARD);
		DirectionState backward = new DirectionState(state, Direction.BACKWARD);
		final int leftSize = left.size();
		final int rightSize = right.size();

		Solution<T> solution = null;
		state.unvisited.add(new Match(forward, -1, -1));
		state.unvisited.add(new Match(backward, leftSize, rightSize));
		Match current;
		while (!state.unvisited.isEmpty()) {
			current = state.unvisited.pollFirst();
			List<Match> newMatches = new LinkedList<Match>();
			switch (current.direction.direction) {
			case FORWARD:
				int forwardLeft = current.left + 1;
				int forwardRight = current.right + 1;
				if (forwardLeft < leftSize)
					newMatches.add(new Match(current, LEFT_ONLY, forwardLeft, current.right, UPPER_SIMILARITY_BOUND));
				if (forwardRight < rightSize)
					newMatches.add(new Match(current, RIGHT_ONLY, current.left, forwardRight, UPPER_SIMILARITY_BOUND));
				if (forwardLeft < leftSize && forwardRight < rightSize) {
					float similarity = Math.abs(similarityFunction.similarity(left.get(forwardLeft), right.get(forwardRight)));
					if (similarity == ISimilarityFunction.EQUAL)
						newMatches.add(new Match(current, EQUAL, forwardLeft, forwardRight, similarity));
					else if (similarity < UPPER_SIMILARITY_BOUND)
						newMatches.add(new Match(current, SIMILAR, forwardLeft, forwardRight, similarity));
				}
				break;
			case BACKWARD:
				int backwardLeft = current.left - 1;
				int backwardRight = current.right - 1;
				if (backwardLeft >= 0)
					newMatches.add(new Match(current, LEFT_ONLY, backwardLeft, current.right, UPPER_SIMILARITY_BOUND));
				if (backwardRight >= 0)
					newMatches.add(new Match(current, RIGHT_ONLY, current.left, backwardRight, UPPER_SIMILARITY_BOUND));
				if (backwardLeft >= 0 && backwardRight >= 0) {
					float similarity = Math.abs(similarityFunction.similarity(left.get(backwardLeft), right.get(backwardRight)));
					if (similarity == ISimilarityFunction.EQUAL)
						newMatches.add(new Match(current, EQUAL, backwardLeft, backwardRight, similarity));
					else if (similarity < UPPER_SIMILARITY_BOUND)
						newMatches.add(new Match(current, SIMILAR, backwardLeft, backwardRight, similarity));
				}
				break;
			}
			for (Match match : newMatches) {
				Long key = Long.valueOf((((long) match.left) << 32) + ((long) match.right));
				Match old = state.visited.get(key);
				if (old == null) {
					if (solution == null || solution.cost > match.cost + current.cost) {
						state.visited.put(key, match);
						state.unvisited.add(match);
					}
				} else if (old.direction != match.direction) {
					Solution<T> newSolution = new Solution<T>(state, match, old);
					// System.out.println();
					// System.out.println();
					// System.out.println("Solution:");
					// System.out.println(format(left, right, newSolution.toList()));
					if (solution == null || newSolution.isBetterThan(solution)) {
						solution = newSolution;
						if (!state.unvisited.isEmpty() && state.unvisited.last().cost > old.cost)
							state.unvisited = new TreeSet<Match>(state.unvisited.headSet(old, true));
					}
				}
			}
			// System.out.println();
			// System.out.println();
			// System.out.println(state);
		}
		List<IDifferencer.Match> result = solution.toList();
		return result;
	}
}
