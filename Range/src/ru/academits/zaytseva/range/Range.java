package ru.academits.zaytseva.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (this.to <= range.from || range.to <= this.from) {
            return null;
        }

        return new Range(Math.max(this.from, range.from), Math.min(this.to, range.to));
    }

    public Range[] getRangeUnion(Range range) {
        if (this.to < range.from || range.to < this.from) {
            Range[] unionRange = new Range[2];
            unionRange[0] = new Range(this.from, this.to);
            unionRange[1] = new Range(range.from, range.to);

            return unionRange;
        }

        Range[] unionRange = new Range[1];
        unionRange[0] = new Range(Math.min(this.from, range.from), Math.max(this.to, range.to));

        return unionRange;
    }

    public Range[] getRangeDifference(Range range) {
        if (this.from == range.from && this.to == range.to) {
            return null;
        }

        if (this.from == range.from) {
            Range[] differenceRange = new Range[1];
            differenceRange[0] = new Range(Math.min(this.to, range.to), Math.max(this.to, range.to));

            return differenceRange;
        }

        if (this.to == range.to) {
            Range[] differenceRange = new Range[1];
            differenceRange[0] = new Range(Math.min(this.from, range.from), Math.max(this.from, range.from));

            return differenceRange;
        }

        Range[] differenceRange = new Range[2];
        differenceRange[0] = new Range(Math.min(this.from, range.from), Math.min(Math.max(this.from, range.from), this.to));
        differenceRange[1] = new Range(Math.max(Math.min(this.to, range.to), range.from), Math.max(this.to, range.to));

        return differenceRange;
    }
}
