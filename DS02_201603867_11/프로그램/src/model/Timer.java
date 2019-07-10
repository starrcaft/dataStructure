package model;

public class Timer {
    private long _start;
    private long _stop;

    public long Start() { return _start; }
    private void setStart(long newStart) { this._start = newStart; }

    public long Stop() { return _stop; }
    private void setStop(long newStop) { this._stop = newStop; }

    public void start() { this.setStart(System.nanoTime()); }
    public void stop() { this.setStop(System.nanoTime()); }
    public long duration() { return this.Stop() - this.Start(); }
}