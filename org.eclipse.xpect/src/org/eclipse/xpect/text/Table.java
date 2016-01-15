package org.eclipse.xpect.text;

import java.util.Collections;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Table {

	public static class Cell extends Element2 {

		public static class Provider implements Provider2<Cell> {
			public Cell get(Table table, Object old, int rowIndex, int columnIndex) {
				if (old instanceof Cell)
					return (Cell) old;
				if (old == null)
					return new Cell(table, rowIndex, columnIndex);
				throw new ClassCastException();
			}
		}

		private ITextBlock text = ITextBlock.EMPTY;

		protected Cell(Table table, int row, int col) {
			super(table, row, col);
		}

		public Column getColumn() {
			return table.getColumn(getColIndex());
		}

		public int getHeight() {
			return text.getLines().size();
		}

		public Row getRow() {
			return table.getRow(getRowIndex());
		}

		public int getWidth() {
			int result = 0;
			for (String line : text.getLines()) {
				int length = line.length();
				if (length > result)
					result = length;
			}
			if (table.maxCellWidth > 0 && result > table.maxCellWidth)
				result = table.maxCellWidth;
			return result;
		}

		protected void paint(ICanvas canvas) {
			canvas.print(text);
		}

		public Cell setText(Object text) {
			this.text = TextBlock.get(text);
			return this;
		}
	}

	public static class CellHSeparator extends Element2 {

		public static class Provider implements Provider2<CellHSeparator> {
			public CellHSeparator get(Table table, Object old, int rowIndex, int columnIndex) {
				if (old instanceof CellHSeparator)
					return (CellHSeparator) old;
				if (old == null)
					return new CellHSeparator(table, rowIndex, columnIndex);
				throw new ClassCastException();
			}
		}

		private ITextBlock background = ITextBlock.EMPTY;

		protected CellHSeparator(Table table, int rowIndex, int colIndex) {
			super(table, rowIndex, colIndex);
		}

		public ITextBlock getBackground() {
			if (background != ITextBlock.EMPTY)
				return background;
			return getRowSeparator().getBackground();
		}

		public RowSeparator getRowSeparator() {
			return table.idxRowSeparators.get(rowIndex);
		}

		public void paint(ICanvas canvas) {
			ITextBlock b = getBackground();
			if (b != ITextBlock.EMPTY)
				canvas.fill(b);
		}

		public CellHSeparator setBackground(ITextBlock background) {
			this.background = background;
			return this;
		}

	}

	public static class CellVSeparator extends Element2 {

		public static class Provider implements Provider2<CellVSeparator> {
			public CellVSeparator get(Table table, Object old, int rowIndex, int columnIndex) {
				if (old instanceof CellVSeparator)
					return (CellVSeparator) old;
				if (old == null)
					return new CellVSeparator(table, rowIndex, columnIndex);
				throw new ClassCastException();
			}
		}

		private ITextBlock background = ITextBlock.EMPTY;

		protected CellVSeparator(Table table, int rowIndex, int colIndex) {
			super(table, rowIndex, colIndex);
		}

		public ITextBlock getBackground() {
			if (background != ITextBlock.EMPTY)
				return background;
			return getColumnSeparator().getBackground();
		}

		public ColumnSeparator getColumnSeparator() {
			return table.idxColumnSeparators.get(colIndex);
		}

		public void paint(ICanvas canvas) {
			ITextBlock b = getBackground();
			if (b != ITextBlock.EMPTY)
				canvas.fill(b);
		}

		public CellVSeparator setBackground(ITextBlock background) {
			this.background = background;
			return this;
		}
	}

	public static class Column extends Element1 {

		public static class Provider implements Provider1<Column> {

			public Column get(Table table, Object old, int index) {
				if (old instanceof Column)
					return (Column) old;
				if (old == null)
					return new Column(table, index);
				throw new ClassCastException();
			}

		}

		protected Column(Table table, int index) {
			super(table, index);
		}

		public Cell getCell(int rowIndex) {
			return table.getCell(rowIndex, index);
		}

		public ColumnSeparator getLeftSeparator() {
			return table.idxColumnSeparators.get(index);
		}

		public ColumnSeparator getRightSeparator() {
			return table.idxColumnSeparators.get(index + 1);
		}

		public int getWidth() {
			int result = 0;
			for (Cell cell : table.idxCells.getByColumn(index)) {
				int width = cell.getWidth();
				if (width > result)
					result = width;
			}
			return result;
		}
	}

	public static class ColumnSeparator extends Element1 {
		public static class Provider implements Provider1<ColumnSeparator> {

			public ColumnSeparator get(Table table, Object old, int index) {
				if (old instanceof ColumnSeparator)
					return (ColumnSeparator) old;
				if (old == null)
					return new ColumnSeparator(table, index);
				throw new ClassCastException();
			}

		}

		private ITextBlock background = ITextBlock.EMPTY;

		private int width = UNDEFINED;

		protected ColumnSeparator(Table table, int index) {
			super(table, index);
		}

		public ITextBlock getBackground() {
			if (background == ITextBlock.EMPTY)
				return table.columnSeparatorBackground;
			return background;
		}

		public int getWidth() {
			if (width != UNDEFINED)
				return width;
			if (isBorder())
				return table.border;
			return table.columnSeparatorWidth;
		}

		public boolean isBorder() {
			return isLeftBorder() || isRightBorder();
		}

		public boolean isLeftBorder() {
			return index == 0;
		}

		public boolean isRightBorder() {
			return index == table.getColumnCount();
		}

		public ColumnSeparator setBackground(Object background) {
			this.background = TextBlock.get(background);
			return this;
		}

		public ColumnSeparator setWidth(int width) {
			this.width = width;
			return this;
		}
	}

	public abstract static class Element {
		protected final Table table;

		protected Element(Table table) {
			super();
			this.table = table;
		}

		public Table getTable() {
			return table;
		}

	}

	public abstract static class Element1 extends Element {

		protected final int index;

		protected Element1(Table table, int index) {
			super(table);
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

	}

	public abstract static class Element2 extends Element {

		protected final int colIndex;

		protected final int rowIndex;

		protected Element2(Table table, int rowIndex, int colIndex) {
			super(table);
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}

		public int getColIndex() {
			return colIndex;
		}

		public int getRowIndex() {
			return rowIndex;
		}
	}

	public class Indexed1<T> {

		private final Provider1<T> factory;

		private final List<T> list = Lists.newArrayList();

		protected Indexed1(Provider1<T> factory) {
			super();
			this.factory = factory;
		}

		public T get(int index) {
			return get(index, factory);
		}

		public <X extends T> X get(int index, Provider1<X> factory) {
			for (int i = list.size(); i < index; i++)
				list.add(null);
			if (list.size() == index) {
				X result = factory.get(Table.this, null, index);
				list.add(result);
				return result;
			} else {
				T old = list.get(index);
				X result = factory.get(Table.this, old, index);
				if (old != result)
					list.set(index, result);
				return result;
			}
		}

	}

	public class Indexed2<T> {

		private final List<List<T>> list = Lists.newArrayList();

		private final Provider2<T> provider;

		protected Indexed2(Provider2<T> factory) {
			super();
			this.provider = factory;
		}

		public T addToColumn(int colIndex) {
			return addToColumn(colIndex, provider);
		}

		public <X extends T> X addToColumn(int colIndex, Provider2<X> provider) {
			return get(getCountInColumn(colIndex), colIndex, provider);
		}

		public T addToRow(int rowIndex) {
			return addToRow(rowIndex, provider);
		}

		public <X extends T> X addToRow(int rowIndex, Provider2<X> provider) {
			Preconditions.checkArgument(rowIndex >= 0);
			for (int i = list.size(); i <= rowIndex; i++)
				list.add(Lists.<T> newArrayList());
			List<T> row = list.get(rowIndex);
			X result = provider.get(Table.this, null, rowIndex, row.size());
			row.add(result);
			return result;
		}

		public T get(int rowIndex, int colIndex) {
			return get(rowIndex, colIndex, provider);
		}

		public <X extends T> X get(int rowIndex, int colIndex, Provider2<X> provider) {
			Preconditions.checkArgument(colIndex >= 0);
			Preconditions.checkArgument(rowIndex >= 0);
			for (int i = list.size(); i <= rowIndex; i++)
				list.add(Lists.<T> newArrayList());
			List<T> row = list.get(rowIndex);
			for (int i = row.size(); i < colIndex; i++)
				row.add(null);
			if (row.size() == colIndex) {
				X result = provider.get(Table.this, null, rowIndex, colIndex);
				row.add(result);
				return result;
			} else {
				T old = row.get(colIndex);
				X result = provider.get(Table.this, old, rowIndex, colIndex);
				if (old != result)
					row.set(colIndex, result);
				return result;
			}
		}

		public Iterable<T> getByColumn(final int columIndex) {
			Preconditions.checkArgument(columIndex >= 0);
			return Iterables.filter(Iterables.transform(list, new Function<List<T>, T>() {
				public T apply(List<T> input) {
					if (columIndex < input.size())
						return input.get(columIndex);
					return null;
				}
			}), Predicates.notNull());
		}

		public Iterable<T> getByRow(int rowIndex) {
			Preconditions.checkArgument(rowIndex >= 0);
			if (rowIndex >= list.size())
				return Collections.emptyList();
			return Iterables.filter(list.get(rowIndex), Predicates.notNull());
		}

		public int getColumnCount() {
			int result = 0;
			for (List<T> row : list) {
				int size = row.size();
				if (size > result)
					result = size;
			}
			return result;
		}

		public int getCountInColumn(int colIndex) {
			Preconditions.checkArgument(colIndex > 0);
			int lastNonemptyRow = list.size() - 1;
			while (lastNonemptyRow >= 0) {
				List<T> row = list.get(lastNonemptyRow);
				if (colIndex < row.size() && row.get(colIndex) == null)
					lastNonemptyRow--;
				else
					break;
			}
			return lastNonemptyRow + 1;
		}

		public int getRowCount() {
			return list.size();
		}

	}

	public interface Provider1<T> {
		T get(Table table, Object old, int index);
	}

	public interface Provider2<T> {
		T get(Table table, Object old, int rowIndex, int columnIndex);
	}

	public static class Row extends Element1 {
		public static class Provider implements Provider1<Row> {
			public Row get(Table table, Object old, int index) {
				if (old instanceof Row)
					return (Row) old;
				if (old == null)
					return new Row(table, index);
				throw new ClassCastException();
			}
		}

		protected Row(Table table, int index) {
			super(table, index);
		}

		public Cell addCell() {
			return table.idxCells.addToRow(index);
		}

		public RowSeparator getBottomSeparator() {
			return table.idxRowSeparators.get(index + 1);
		}

		public Cell getCell(int colIndex) {
			return table.idxCells.get(index, colIndex);
		}

		public int getHeight() {
			int result = 0;
			for (Cell cell : table.idxCells.getByRow(index)) {
				int height = cell.getHeight();
				if (height > result)
					result = height;
			}
			return result;
		}

		public RowSeparator getTopSeparator() {
			return table.idxRowSeparators.get(index);
		}
	}

	public static class RowSeparator extends Element1 {
		public static class Provider implements Provider1<RowSeparator> {
			public RowSeparator get(Table table, Object old, int index) {
				if (old instanceof RowSeparator)
					return (RowSeparator) old;
				if (old == null)
					return new RowSeparator(table, index);
				throw new ClassCastException();
			}
		}

		private ITextBlock background = ITextBlock.EMPTY;
		private int height = UNDEFINED;

		protected RowSeparator(Table table, int index) {
			super(table, index);
		}

		public ITextBlock getBackground() {
			if (background == ITextBlock.EMPTY)
				return table.rowSeparatorBackground;
			return background;
		}

		public int getHeight() {
			if (height != UNDEFINED)
				return height;
			if (isBorder())
				return table.border;
			return table.rowSeparatorHeight;
		}

		public boolean isBorder() {
			return isTopBorder() || isBottomBorder();
		}

		public boolean isBottomBorder() {
			return index == table.getRowCount();
		}

		public boolean isTopBorder() {
			return index == 0;
		}

		public RowSeparator setBackground(Object background) {
			this.background = TextBlock.get(background);
			return this;
		}

		public RowSeparator setHeight(int height) {
			this.height = height;
			return this;
		}

	}

	public static class SeparatorCrossing extends Element2 {

		public static class Provider implements Provider2<SeparatorCrossing> {
			public SeparatorCrossing get(Table table, Object old, int rowIndex, int columnIndex) {
				if (old instanceof SeparatorCrossing)
					return (SeparatorCrossing) old;
				if (old == null)
					return new SeparatorCrossing(table, rowIndex, columnIndex);
				throw new ClassCastException();
			}
		}

		private ITextBlock background = ITextBlock.EMPTY;

		protected SeparatorCrossing(Table table, int rowIndex, int colIndex) {
			super(table, rowIndex, colIndex);
		}

		public ITextBlock getBackground() {
			if (background != ITextBlock.EMPTY)
				return background;
			return table.separatorCrossingBackground;
		}

		public void paint(ICanvas canvas) {
			ITextBlock c = getBackground();
			if (c != ITextBlock.EMPTY)
				canvas.fill(c);
		}

		public SeparatorCrossing setBackground(Object background) {
			this.background = TextBlock.get(background);
			return this;
		}
	}

	protected static final int UNDEFINED = -1;

	private int border = 0;
	private ITextBlock columnSeparatorBackground = ITextBlock.EMPTY;
	private int columnSeparatorWidth = 1;

	private final Indexed2<CellHSeparator> idxCellHSeparators = new Indexed2<Table.CellHSeparator>(new CellHSeparator.Provider());
	private final Indexed2<Cell> idxCells = new Indexed2<Table.Cell>(new Cell.Provider());
	private final Indexed2<CellVSeparator> idxCellVSeparators = new Indexed2<CellVSeparator>(new CellVSeparator.Provider());
	private final Indexed1<Column> idxColumns = new Indexed1<Column>(new Column.Provider());
	private final Indexed1<ColumnSeparator> idxColumnSeparators = new Indexed1<ColumnSeparator>(new ColumnSeparator.Provider());
	private final Indexed1<Row> idxRows = new Indexed1<Table.Row>(new Row.Provider());
	private final Indexed1<RowSeparator> idxRowSeparators = new Indexed1<RowSeparator>(new RowSeparator.Provider());
	private final Indexed2<SeparatorCrossing> idxSeparatorCrossings = new Indexed2<SeparatorCrossing>(new SeparatorCrossing.Provider());

	private int maxCellWidth = -1;
	private ITextBlock rowSeparatorBackground = ITextBlock.EMPTY;
	private int rowSeparatorHeight = 1;
	private ITextBlock separatorCrossingBackground = ITextBlock.EMPTY;

	public Table() {
		super();
	}

	public Column addColumn() {
		return getColumn(getColumnCount());
	}

	public Row addRow() {
		return getRow(getRowCount());
	}

	public int getBorder() {
		return border;
	}

	public RowSeparator getBottomBorder() {
		return idxRowSeparators.get(getRowCount());
	}

	public Cell getCell(int rowIndex, int colIndex) {
		return idxCells.get(rowIndex, colIndex);
	}

	public <T extends Cell> Cell getCell(int rowIndex, int colIndex, Provider2<T> provider) {
		return idxCells.get(rowIndex, colIndex, provider);
	}

	public Column getColumn(int index) {
		return idxColumns.get(index);
	}

	public <T extends Column> T getColumn(int index, Provider1<T> provider) {
		return idxColumns.get(index, provider);
	}

	public int getColumnCount() {
		return idxCells.getColumnCount();
	}

	public ITextBlock getColumnSeparatorBackground() {
		return columnSeparatorBackground;
	}

	public int getColumnSeparatorWidth() {
		return columnSeparatorWidth;
	}

	public ColumnSeparator getLeftBorder() {
		return idxColumnSeparators.get(0);
	}

	public int getMaxCellWidth() {
		return maxCellWidth;
	}

	public ColumnSeparator getRightBorder() {
		return idxColumnSeparators.get(getColumnCount());
	}

	public Row getRow(int index) {
		return idxRows.get(index);
	}

	public <T extends Row> T getRow(int index, Provider1<T> provider) {
		return idxRows.get(index, provider);
	}

	public int getRowCount() {
		return idxCells.getRowCount();
	}

	public ITextBlock getRowSeparatorBackground() {
		return rowSeparatorBackground;
	}

	public int getRowSeparatorHeight() {
		return rowSeparatorHeight;
	}

	public ITextBlock getSeparatorCrossingBackground() {
		return separatorCrossingBackground;
	}

	public RowSeparator getTopBorder() {
		return idxRowSeparators.get(0);
	}

	public void paint(ICanvas canvas) {
		int cols = getColumnCount();
		int rows = getRowCount();
		List<Integer> columnWidths = Lists.newArrayList();
		for (int col = 0; col < cols; col++)
			columnWidths.add(idxColumns.get(col).getWidth());
		List<Integer> columnSeparatorWidths = Lists.newArrayList();
		for (int col = 0; col <= cols; col++)
			columnSeparatorWidths.add(idxColumnSeparators.get(col).getWidth());
		int top = 0;
		for (int row = 0; row <= rows; row++) {
			{
				int height = idxRowSeparators.get(row).getHeight();
				if (height > 0) {
					int left = 0;
					for (int col = 0; col <= cols; col++) {
						{
							int width = columnSeparatorWidths.get(col);
							if (width > 0) {
								idxSeparatorCrossings.get(row, col).paint(canvas.at(top, left).withBounds(height, width).newSubCanvas());
								left += width;
							}
						}
						if (col < cols) {
							int width = columnWidths.get(col);
							if (width > 0) {
								idxCellHSeparators.get(row, col).paint(canvas.at(top, left).withBounds(height, width).newSubCanvas());
								left += width;
							}
						}
					}
					top += height;
				}
			}
			if (row < rows) {
				int height = idxRows.get(row).getHeight();
				if (height > 0) {
					int left = 0;
					for (int col = 0; col <= cols; col++) {
						{
							int width = columnSeparatorWidths.get(col);
							if (width > 0) {
								idxCellVSeparators.get(row, col).paint(canvas.at(top, left).withBounds(height, width).newSubCanvas());
								left += width;
							}
						}
						if (col < cols) {
							int width = columnWidths.get(col);
							if (width > 0) {
								idxCells.get(row, col).paint(canvas.at(top, left).withBounds(height, width).newSubCanvas());
								left += width;
							}
						}
					}
					top += height;
				}
			}
		}
	}

	public Table setBorder(int border) {
		this.border = border;
		return this;
	}

	public Table setColumnSeparatorBackground(Object ColumnSeparatorBackground) {
		this.columnSeparatorBackground = TextBlock.get(ColumnSeparatorBackground);
		return this;
	}

	public Table setColumnSeparatorWidth(int columnSeparatorWidth) {
		this.columnSeparatorWidth = columnSeparatorWidth;
		return this;
	}

	public Table setMaxCellWidth(int maxCellWidth) {
		this.maxCellWidth = maxCellWidth;
		return this;
	}

	public Table setRowSeparatorBackground(Object RowSeparatorBackground) {
		this.rowSeparatorBackground = TextBlock.get(RowSeparatorBackground);
		return this;
	}

	public Table setRowSeparatorHeight(int rowSeparatorHeight) {
		this.rowSeparatorHeight = rowSeparatorHeight;
		return this;
	}

	public Table setSeparatorCrossingBackground(Object text) {
		this.separatorCrossingBackground = TextBlock.get(text);
		return this;
	}

	@Override
	public String toString() {
		ICanvas canvas = Canvas.create();
		paint(canvas);
		return canvas.toString();
	}
}
