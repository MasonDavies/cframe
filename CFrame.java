public class CFrame {
    private final double x, y, z;
    private final double rx, ry, rz;

    public CFrame() {
        this(new Vector3(0, 0, 0));
    }

    public CFrame(Vector3 pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        rx = 0;
        ry = 0;
        rz = 0;
    }

    public CFrame(double x, double y, double z) {
        this(new Vector3(x, y, z));
    }

    public CFrame(double x, double y, double z, double rx, double ry, double rz) {
        this(new Vector3(x, y, z), new Vector3(rx, ry, rz));
    }

    public CFrame(Vector3 pos, Vector3 rotation) {
        this.x = pos.x;
        this.y = pos.y;
        this.z = pos.z;
        this.rx = rotation.x;
        this.ry = rotation.y;
        this.rz = rotation.z;
    }

    public Vector3 getPosition() {
        return new Vector3(x, y, z);
    }

    public Vector3 getRotation() {
        return new Vector3(rx, ry, rz);
    }

    public CFrame toWorldSpace(CFrame other) {
        Vector3 rotatedPos = new Vector3(other.x, other.y, other.z).rotate(rx, ry, rz);
        return new CFrame(x + rotatedPos.x, y + rotatedPos.y, z + rotatedPos.z, rx, ry, rz);
    }

    public CFrame toObjectSpace(CFrame other) {
        Vector3 difference = new Vector3(other.x - x, other.y - y, other.z - z);

        return new CFrame(difference.rotate(rx, ry, rz));
    }
}