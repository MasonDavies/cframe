public class CFrame {
    private final double x, y, z;
    private final double rx, ry, rz;

    /**
     * This constructor creates a new empty CFrame.
     */
    public CFrame() {
        this(new Vector3(0, 0, 0));
    }

    /**
     * This constructor allows for specifying the position of the CFrame as a
     * Vector3.
     */
    public CFrame(Vector3 pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        rx = 0;
        ry = 0;
        rz = 0;
    }

    /**
     * This constructor allows for specifying the position of the CFrame as separate
     * double values.
     */
    public CFrame(double x, double y, double z) {
        this(new Vector3(x, y, z));
    }

    /**
     * This constructor allows for specifying both position and rotation of the
     * CFrame as separate double values.
     */
    public CFrame(double x, double y, double z, double rx, double ry, double rz) {
        this(new Vector3(x, y, z), new Vector3(rx, ry, rz));
    }

    /**
     * This constructor allows for specifying both position and rotation of the
     * CFrame as separate Vector3 objects.
     */
    public CFrame(Vector3 pos, Vector3 rotation) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        this.rx = rotation.x;
        this.ry = rotation.y;
        this.rz = rotation.z;
    }

    /**
     * @return the position of this CFrame as a Vector3
     */
    public Vector3 getPosition() {
        return new Vector3(x, y, z);
    }

    /**
     * @return the rotation of this CFrame as a Vector3
     */
    public Vector3 getRotation() {
        return new Vector3(rx, ry, rz);
    }

    /**
     * Transforms a relative CFrame into world space.
     *
     * @param other the relative CFrame
     * @return the resulting world-space CFrame
     */
    public CFrame toWorldSpace(CFrame other) {
        Vector3 rotatedPos = new Vector3(other.x, other.y, other.z).rotate(rx, ry, rz);
        return new CFrame(x + rotatedPos.x, y + rotatedPos.y, z + rotatedPos.z, rx, ry, rz);
    }

    /**
     * Converts a world-space CFrame into object space relative to this CFrame.
     *
     * @param other the world-space CFrame to convert
     * @return the CFrame relative to this CFrame
     */
    public CFrame toObjectSpace(CFrame other) {
        Vector3 difference = new Vector3(other.x - x, other.y - y, other.z - z);

        return new CFrame(difference.rotate(rx, ry, rz));
    }
}