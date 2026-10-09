public class Vector3 {
    public final double x, y, z;

    /**
     * Constructs a new Vector3 with the specified x, y, and z coordinates.
     */
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Adds the specified Vector3 to this Vector3 and returns the result.
     *
     * @param other the Vector3 to add
     * @return the resulting Vector3
     */
    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    /**
     * Calculates the length of this vector.
     *
     * @return the vector's magnitude
     */
    public double magnitude() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    /**
     * Rotates this Vector3 by the specified angles around the x, y, and z axes.
     *
     * @param rx the rotation angle around the x axis in radians
     * @param ry the rotation angle around the y axis in radians
     * @param rz the rotation angle around the z axis in radians
     * @return the rotated Vector3
     */
    public Vector3 rotate(double rx, double ry, double rz) {
        double cx = Math.cos(rx), sx = Math.sin(rx),
        cy = Math.cos(ry), sy = Math.sin(ry),
        cz = Math.cos(rz), sz = Math.sin(rz);

        double x1 = x;
        double y1 = y * cx - z * sx;
        double z1 = y * sx + z * cx;

        double x2 = x1 * cy + z1 * sy;
        double y2 = y1;
        double z2 = -x1 * sy + z1 * cy;

        return new Vector3(
            x2 * cz - y2 * sz,
            x2 * sz + y2 * cz,
            z2
        );
    }
}