public class RoboArmTest {
    public static void main(String[] args) {
        // Example of using CFrame to calculate the positions of a robotic arm

        CFrame BasePos = new CFrame(0, 0, 0, 0, Math.toRadians(90), 0);
        CFrame firstJoint = BasePos.toWorldSpace(new CFrame(0, 0, -2));
        CFrame secondJoint = firstJoint.toWorldSpace(new CFrame(0, 0, -3));
        CFrame toolOffset = secondJoint.toWorldSpace(new CFrame(0, 0, -1));

        System.out.println("First joint: " + firstJoint.getPosition().x + ", " + firstJoint.getPosition().y + ", " + firstJoint.getPosition().z);
        System.out.println("Second joint: " + secondJoint.getPosition().x + ", " + secondJoint.getPosition().y + ", " + secondJoint.getPosition().z);
        System.out.println("Tool: " + toolOffset.getPosition().x + ", " + toolOffset.getPosition().y + ", " + toolOffset.getPosition().z);
    }
}