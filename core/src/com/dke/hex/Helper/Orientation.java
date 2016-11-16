package com.dke.hex.Helper;

public class Orientation {
    public final double f0, f1, f2, f3; // 2×2 forward matrix
    public final double b0, b1, b2, b3; // 2x2 inverse matrix
    public final double startAngle; // in multiple of 60°

    public Orientation(double f0, double f1, double f2, double f3,
                       double b0, double b1, double b2, double b3,
                       double startAngle) {
        this.f0 = f0; this.f1 = f1; this.f2 = f2; this.f3 = f3;
        this.b0 = b0; this.b1 = b1; this.b2 = b2; this.b3 = b3;
        this.startAngle = startAngle;
    }
}
